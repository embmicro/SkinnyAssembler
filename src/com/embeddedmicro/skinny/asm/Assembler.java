package com.embeddedmicro.skinny.asm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.embeddedmicro.skinny.parser.SkinnyBaseListener;
import com.embeddedmicro.skinny.parser.SkinnyLexer;
import com.embeddedmicro.skinny.parser.SkinnyParser;
import com.embeddedmicro.skinny.parser.SkinnyParser.InstructionContext;
import com.embeddedmicro.skinny.parser.SkinnyParser.LabelContext;
import com.embeddedmicro.skinny.parser.SkinnyParser.SourceContext;

public class Assembler extends SkinnyBaseListener {

	public static void main(String[] args) {
		if (args.length != 1) {
			printUsage();
			System.exit(1);
		}
		File input = new File(args[0]);
		if (!input.exists()) {
			System.err.println("File " + args[0] + " does not exits!");
			System.exit(2);
		}
		try {
			ANTLRFileStream fileStream = new ANTLRFileStream(args[0]);
			SkinnyLexer lexer = new SkinnyLexer(fileStream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SkinnyParser parser = new SkinnyParser(tokens);
			ParseTree tree = parser.source();
			Assembler asm = new Assembler();
			ParseTreeWalker.DEFAULT.walk(asm, tree);
			ParseTreeWalker.DEFAULT.walk(asm, tree);
			if (!asm.hasErrors)
				System.out.println(asm.getText());
		} catch (IOException e) {
			System.err.println("Could not open file: " + args[0]);
			System.exit(2);
		}

	}

	private static void printUsage() {
		System.out.println("Proper usage is: java -jar skinny-asm.jar file.asm");
	}

	private StringBuilder text;
	private HashMap<String, Integer> labels;
	private int line;
	private boolean hasErrors;
	private int walk;

	private Assembler() {
		text = new StringBuilder();
		labels = new HashMap<>();
		hasErrors = false;
		line = 0;
		walk = 0;

	}

	private String getText() {
		if (!hasErrors)
			return text.toString();
		else
			return null;
	}

	@Override
	public void enterSource(SourceContext ctx) {
		line = 0;
		if (walk > 0)
			text.replace(0, text.length(), "module instRom (\n" + "    input address[8],\n" + "    output inst[16]\n" + "  ) {\n" + "\n" + "  always {\n"
					+ "    inst = c{Inst.NOP, 12b0};\n" + "\n" + "    case (address) {\n"); // clear text
	}

	@Override
	public void exitSource(SourceContext ctx) {
		if (walk > 0)
			text.append("    }\n  }\n}");
		walk++;
	}

	@Override
	public void exitLabel(LabelContext ctx) {
		if (walk == 0)
			if (labels.put(ctx.NAME().getText(), line) != null)
				printError(ctx, "The label " + ctx.NAME().getText() + " was already used!");
		if (walk > 0)
			text.append("      // ").append(ctx.NAME().getText()).append(":\n");
	}

	@Override
	public void exitInstruction(InstructionContext ctx) {
		if (walk > 0) {
			String inst = ctx.NAME(0).getText();
			StringBuilder sb = new StringBuilder();
			int args = ctx.NAME().size() - 1;
			sb.append("      ");
			sb.append(line);
			sb.append(": inst = c{Inst.");
			sb.append(inst);
			sb.append(", ");
			switch (inst) {
			case "NOP":
				if (args != 0) {
					printError(ctx, inst + " accepts exactly 0 arguments");
					return;
				}
				sb.append("NOP, 12b0");
				break;
			case "ADD":
			case "SUB":
			case "LT":
			case "EQ":
			case "SHL":
			case "SHR":
			case "AND":
			case "OR":
			case "XOR":
				if (args != 3) {
					printError(ctx, inst + " accepts exactly 3 arguments");
					return;
				}
				sb.append(regNameToString(ctx.NAME(1).getText(), ctx)).append(", ");
				sb.append(regNameToString(ctx.NAME(2).getText(), ctx)).append(", ");
				sb.append(regNameToString(ctx.NAME(3).getText(), ctx));
				break;

			case "SET":
			case "BEQ":
			case "BNEQ":
				if (args != 2) {
					printError(ctx, inst + " accepts exactly 2 arguments");
					return;
				}
				sb.append(regNameToString(ctx.NAME(1).getText(), ctx)).append(", ");
				sb.append(constToString(ctx.NAME(2).getText(), ctx, 8));
				break;
			case "LOAD":
			case "STORE":
				if (args != 3) {
					printError(ctx, inst + " accepts exactly 3 arguments");
					return;
				}
				sb.append(regNameToString(ctx.NAME(1).getText(), ctx)).append(", ");
				sb.append(regNameToString(ctx.NAME(2).getText(), ctx)).append(", ");
				sb.append(constToString(ctx.NAME(3).getText(), ctx, 4));
				break;
			case "INV":
				if (args != 2) {
					printError(ctx, "INV accepts exactly 2 arguments");
					return;
				}
				sb.append(regNameToString(ctx.NAME(1).getText(), ctx)).append(", ");
				sb.append(regNameToString(ctx.NAME(2).getText(), ctx));
				break;
			default:
				printError(ctx, "Unknown instruction " + inst);
			}
			sb.append("};");
			while (sb.length() < 52)
				sb.append(' ');
			sb.append("// ");
			sb.append(ctx.NAME(0).getText());
			sb.append(" ");
			boolean first = true;
			for (int i = 1; i < ctx.NAME().size(); i++) {
				if (!first)
					sb.append(", ");
				else
					first = false;
				sb.append(ctx.NAME(i).getText());
			}
			sb.append("\n");
			text.append(sb.toString());
		}
		line++;
	}

	private String regNameToString(String reg, ParserRuleContext ctx) {
		if (reg.length() < 2) {
			printError(ctx, "Unknown register name " + reg);
			return "";
		}
		if (reg.charAt(0) != 'R') {
			printError(ctx, "Register names must start with R");
			return "";
		}
		String num = reg.substring(1);
		try {
			int r = Integer.parseInt(num);
			if (r < 0 || r > 15) {
				printError(ctx, "Valid register numbers are 0-15");
				return "";
			}
			return "4d" + r;
		} catch (NumberFormatException e) {
			printError(ctx, "Unknown register name " + reg);
			return "";
		}
	}

	private String constToString(String c, ParserRuleContext ctx, int width) {
		try {
			int r = Integer.parseInt(c);
			if (r < 0 || r > Math.pow(2, width) - 1) {
				printError(ctx, "Invalid constant value " + c + " (must be between 0 and " + (Math.pow(2, width) - 1) + ")");
				return "";
			}
			return width + "d" + r;
		} catch (NumberFormatException e) {
			Integer i = labels.get(c);
			if (i != null) {
				if (i < 0 || i > Math.pow(2, width) - 1) {
					printError(ctx, "Invalid constant value " + c + " (must be between 0 and " + (Math.pow(2, width) - 1) + ")");
					return "";
				}
				return width + "d" + i.toString();
			}
			printError(ctx, "Unknown constant value " + c);
			return "";
		}
	}

	private void printError(ParserRuleContext ctx, String msg) {
		printError(ctx.start, msg);
	}

	private void printError(Token ctx, String msg) {
		System.out.println("Error on line " + ctx.getLine() + ": " + msg);
		hasErrors = true;
	}
}

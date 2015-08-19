// Generated from Skinny.g4 by ANTLR 4.5

package com.embeddedmicro.skinny.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SkinnyParser}.
 */
public interface SkinnyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SkinnyParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(SkinnyParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkinnyParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(SkinnyParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkinnyParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(SkinnyParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkinnyParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(SkinnyParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkinnyParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(SkinnyParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkinnyParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(SkinnyParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SkinnyParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(SkinnyParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SkinnyParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(SkinnyParser.EndContext ctx);
}
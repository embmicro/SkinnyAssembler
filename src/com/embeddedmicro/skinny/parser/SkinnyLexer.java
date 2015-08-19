// Generated from Skinny.g4 by ANTLR 4.5

package com.embeddedmicro.skinny.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SkinnyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NAME=3, BLOCK_COMMENT=4, COMMENT=5, NL=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "NAME", "BLOCK_COMMENT", "COMMENT", "NL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "NAME", "BLOCK_COMMENT", "COMMENT", "NL", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SkinnyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Skinny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tB\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\6\4"+
		"\27\n\4\r\4\16\4\30\3\5\3\5\3\5\3\5\7\5\37\n\5\f\5\16\5\"\13\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\7\6+\n\6\f\6\16\6.\13\6\3\6\5\6\61\n\6\3\6\3\6\5"+
		"\6\65\n\6\3\7\5\78\n\7\3\7\3\7\3\b\6\b=\n\b\r\b\16\b>\3\b\3\b\3 \2\t\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\6\2\62;C\\aac|\4\2\f\f\17\17\4\2\13"+
		"\13\"\"H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\23\3\2\2\2\7\26\3\2\2\2\t\32"+
		"\3\2\2\2\13&\3\2\2\2\r\67\3\2\2\2\17<\3\2\2\2\21\22\7<\2\2\22\4\3\2\2"+
		"\2\23\24\7.\2\2\24\6\3\2\2\2\25\27\t\2\2\2\26\25\3\2\2\2\27\30\3\2\2\2"+
		"\30\26\3\2\2\2\30\31\3\2\2\2\31\b\3\2\2\2\32\33\7\61\2\2\33\34\7,\2\2"+
		"\34 \3\2\2\2\35\37\13\2\2\2\36\35\3\2\2\2\37\"\3\2\2\2 !\3\2\2\2 \36\3"+
		"\2\2\2!#\3\2\2\2\" \3\2\2\2#$\7,\2\2$%\7\61\2\2%\n\3\2\2\2&\'\7\61\2\2"+
		"\'(\7\61\2\2(,\3\2\2\2)+\n\3\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2"+
		"\2-\64\3\2\2\2.,\3\2\2\2/\61\7\17\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\62"+
		"\3\2\2\2\62\65\7\f\2\2\63\65\7\2\2\3\64\60\3\2\2\2\64\63\3\2\2\2\65\f"+
		"\3\2\2\2\668\7\17\2\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\f\2\2:\16"+
		"\3\2\2\2;=\t\4\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?@\3\2\2\2@"+
		"A\b\b\2\2A\20\3\2\2\2\n\2\30 ,\60\64\67>\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
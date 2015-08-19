// Generated from Skinny.g4 by ANTLR 4.5

package com.embeddedmicro.skinny.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SkinnyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, NAME=3, BLOCK_COMMENT=4, COMMENT=5, NL=6, WS=7;
	public static final int
		RULE_source = 0, RULE_label = 1, RULE_instruction = 2, RULE_end = 3;
	public static final String[] ruleNames = {
		"source", "label", "instruction", "end"
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

	@Override
	public String getGrammarFileName() { return "Skinny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SkinnyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SourceContext extends ParserRuleContext {
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << BLOCK_COMMENT) | (1L << COMMENT) | (1L << NL))) != 0)) {
				{
				setState(11);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(8);
					label();
					}
					break;
				case 2:
					{
					setState(9);
					instruction();
					}
					break;
				case 3:
					{
					setState(10);
					end();
					}
					break;
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SkinnyParser.NAME, 0); }
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SkinnyParser.EOF, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(NAME);
			setState(17);
			match(T__0);
			setState(20);
			switch (_input.LA(1)) {
			case BLOCK_COMMENT:
			case COMMENT:
			case NL:
				{
				setState(18);
				end();
				}
				break;
			case EOF:
				{
				setState(19);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(SkinnyParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SkinnyParser.NAME, i);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SkinnyParser.EOF, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(NAME);
			setState(23);
			match(NAME);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(24);
				match(T__1);
				setState(25);
				match(NAME);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			switch (_input.LA(1)) {
			case BLOCK_COMMENT:
			case COMMENT:
			case NL:
				{
				setState(31);
				end();
				}
				break;
			case EOF:
				{
				setState(32);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(SkinnyParser.NL, 0); }
		public TerminalNode COMMENT() { return getToken(SkinnyParser.COMMENT, 0); }
		public TerminalNode BLOCK_COMMENT() { return getToken(SkinnyParser.BLOCK_COMMENT, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SkinnyListener ) ((SkinnyListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLOCK_COMMENT) | (1L << COMMENT) | (1L << NL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3\3\3"+
		"\3\3\5\3\27\n\3\3\4\3\4\3\4\3\4\7\4\35\n\4\f\4\16\4 \13\4\3\4\3\4\5\4"+
		"$\n\4\3\5\3\5\3\5\2\2\6\2\4\6\b\2\3\3\2\6\b)\2\17\3\2\2\2\4\22\3\2\2\2"+
		"\6\30\3\2\2\2\b%\3\2\2\2\n\16\5\4\3\2\13\16\5\6\4\2\f\16\5\b\5\2\r\n\3"+
		"\2\2\2\r\13\3\2\2\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2"+
		"\2\20\3\3\2\2\2\21\17\3\2\2\2\22\23\7\5\2\2\23\26\7\3\2\2\24\27\5\b\5"+
		"\2\25\27\7\2\2\3\26\24\3\2\2\2\26\25\3\2\2\2\27\5\3\2\2\2\30\31\7\5\2"+
		"\2\31\36\7\5\2\2\32\33\7\4\2\2\33\35\7\5\2\2\34\32\3\2\2\2\35 \3\2\2\2"+
		"\36\34\3\2\2\2\36\37\3\2\2\2\37#\3\2\2\2 \36\3\2\2\2!$\5\b\5\2\"$\7\2"+
		"\2\3#!\3\2\2\2#\"\3\2\2\2$\7\3\2\2\2%&\t\2\2\2&\t\3\2\2\2\7\r\17\26\36"+
		"#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
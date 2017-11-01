// Generated from /Users/liyi/IdeaProjects/Mediator/src-antlr/MediatorLang.g4 by ANTLR 4.7
package org.fmgroup.mediator.language;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MediatorLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, LINE_COMMENT=62, COMMENT=63, IGNORE=64, INT=65, REAL=66, 
		STRING=67, BOOLEAN=68, ID=69;
	public static final int
		RULE_prog = 0, RULE_dependency = 1, RULE_typedef = 2, RULE_statement = 3, 
		RULE_statements = 4, RULE_compTemplate = 5, RULE_param = 6, RULE_function = 7, 
		RULE_localVariableDef = 8, RULE_funcInterface = 9, RULE_funcArg = 10, 
		RULE_portsDecl = 11, RULE_compInterface = 12, RULE_variableSegment = 13, 
		RULE_transitionSegment = 14, RULE_transition = 15, RULE_automaton = 16, 
		RULE_componentSegment = 17, RULE_internalSegment = 18, RULE_connectionSegment = 19, 
		RULE_componentDecl = 20, RULE_connectionDecl = 21, RULE_system = 22, RULE_term = 23, 
		RULE_value = 24, RULE_type = 25, RULE_typeorvalue = 26, RULE_scopeID = 27;
	public static final String[] ruleNames = {
		"prog", "dependency", "typedef", "statement", "statements", "compTemplate", 
		"param", "function", "localVariableDef", "funcInterface", "funcArg", "portsDecl", 
		"compInterface", "variableSegment", "transitionSegment", "transition", 
		"automaton", "componentSegment", "internalSegment", "connectionSegment", 
		"componentDecl", "connectionDecl", "system", "term", "value", "type", 
		"typeorvalue", "scopeID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "'.'", "'*'", "';'", "'typedef'", "'as'", "'='", "'sync'", 
		"','", "'return'", "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'<'", 
		"'>'", "':'", "'native'", "'function'", "'in'", "'out'", "'variables'", 
		"'transitions'", "'->'", "'group'", "'automaton'", "'components'", "'internals'", 
		"'connections'", "'system'", "'['", "']'", "'-'", "'!'", "'%'", "'/'", 
		"'+'", "'<='", "'>='", "'=='", "'!='", "'^'", "'^^'", "'&'", "'&&'", "'|'", 
		"'||'", "'?'", "'null'", "'int'", "'..'", "'char'", "'double'", "'bool'", 
		"'enum'", "'struct'", "'init'", "'type'", "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "LINE_COMMENT", "COMMENT", "IGNORE", "INT", "REAL", "STRING", 
		"BOOLEAN", "ID"
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
	public String getGrammarFileName() { return "MediatorLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MediatorLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<DependencyContext> dependency() {
			return getRuleContexts(DependencyContext.class);
		}
		public DependencyContext dependency(int i) {
			return getRuleContext(DependencyContext.class,i);
		}
		public List<TypedefContext> typedef() {
			return getRuleContexts(TypedefContext.class);
		}
		public TypedefContext typedef(int i) {
			return getRuleContext(TypedefContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<AutomatonContext> automaton() {
			return getRuleContexts(AutomatonContext.class);
		}
		public AutomatonContext automaton(int i) {
			return getRuleContext(AutomatonContext.class,i);
		}
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__19) | (1L << T__20) | (1L << T__27) | (1L << T__31))) != 0)) {
				{
				setState(61);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(56);
					dependency();
					}
					break;
				case T__4:
					{
					setState(57);
					typedef();
					}
					break;
				case T__19:
				case T__20:
					{
					setState(58);
					function();
					}
					break;
				case T__27:
					{
					setState(59);
					automaton();
					}
					break;
				case T__31:
					{
					setState(60);
					system();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65);
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

	public static class DependencyContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterDependency(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitDependency(this);
		}
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dependency);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__0);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					match(ID);
					setState(68);
					match(T__1);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(T__3);
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

	public static class TypedefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public TypedefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTypedef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTypedef(this);
		}
	}

	public final TypedefContext typedef() throws RecognitionException {
		TypedefContext _localctx = new TypedefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typedef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__4);
			setState(78);
			type(0);
			setState(79);
			match(T__5);
			setState(80);
			match(ID);
			setState(81);
			match(T__3);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IteStatementContext extends StatementContext {
		public TermContext condition;
		public StatementContext thenstmt;
		public StatementsContext thenstmts;
		public StatementContext elsestmt;
		public StatementsContext elsestmts;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IteStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIteStatement(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public TermContext target;
		public TermContext expr;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAssignmentStatement(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitReturnStatement(this);
		}
	}
	public static class SynchronizingStatementContext extends StatementContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public SynchronizingStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterSynchronizingStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitSynchronizingStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__32:
			case T__34:
			case T__35:
			case T__50:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(83);
					((AssignmentStatementContext)_localctx).target = term(0);
					setState(84);
					match(T__6);
					}
					break;
				}
				setState(88);
				((AssignmentStatementContext)_localctx).expr = term(0);
				setState(89);
				match(T__3);
				}
				break;
			case T__7:
				_localctx = new SynchronizingStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(T__7);
				setState(92);
				match(ID);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(93);
					match(T__8);
					setState(94);
					match(ID);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(T__3);
				}
				break;
			case T__9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__9);
				setState(102);
				term(0);
				setState(103);
				match(T__3);
				}
				break;
			case T__10:
				_localctx = new IteStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(T__10);
				setState(106);
				match(T__11);
				setState(107);
				((IteStatementContext)_localctx).condition = term(0);
				setState(108);
				match(T__12);
				setState(114);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
				case T__9:
				case T__10:
				case T__11:
				case T__32:
				case T__34:
				case T__35:
				case T__50:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(109);
					((IteStatementContext)_localctx).thenstmt = statement();
					}
					break;
				case T__13:
					{
					setState(110);
					match(T__13);
					setState(111);
					((IteStatementContext)_localctx).thenstmts = statements();
					setState(112);
					match(T__14);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(116);
					match(T__15);
					setState(122);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__7:
					case T__9:
					case T__10:
					case T__11:
					case T__32:
					case T__34:
					case T__35:
					case T__50:
					case INT:
					case REAL:
					case STRING:
					case BOOLEAN:
					case ID:
						{
						setState(117);
						((IteStatementContext)_localctx).elsestmt = statement();
						}
						break;
					case T__13:
						{
						setState(118);
						match(T__13);
						setState(119);
						((IteStatementContext)_localctx).elsestmts = statements();
						setState(120);
						match(T__14);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (T__7 - 8)) | (1L << (T__9 - 8)) | (1L << (T__10 - 8)) | (1L << (T__11 - 8)) | (1L << (T__32 - 8)) | (1L << (T__34 - 8)) | (1L << (T__35 - 8)) | (1L << (T__50 - 8)) | (1L << (INT - 8)) | (1L << (REAL - 8)) | (1L << (STRING - 8)) | (1L << (BOOLEAN - 8)) | (1L << (ID - 8)))) != 0)) {
				{
				{
				setState(128);
				statement();
				}
				}
				setState(133);
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

	public static class CompTemplateContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public CompTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterCompTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitCompTemplate(this);
		}
	}

	public final CompTemplateContext compTemplate() throws RecognitionException {
		CompTemplateContext _localctx = new CompTemplateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_compTemplate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__16);
			setState(135);
			param();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(136);
				match(T__8);
				setState(137);
				param();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(T__17);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ID);
			setState(146);
			match(T__18);
			setState(147);
			type(0);
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

	public static class FunctionContext extends ParserRuleContext {
		public boolean isNative = false;
		public Token name;
		public TypeContext returnType;
		public FuncInterfaceContext funcInterface() {
			return getRuleContext(FuncInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public CompTemplateContext compTemplate() {
			return getRuleContext(CompTemplateContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<LocalVariableDefContext> localVariableDef() {
			return getRuleContexts(LocalVariableDefContext.class);
		}
		public LocalVariableDefContext localVariableDef(int i) {
			return getRuleContext(LocalVariableDefContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(149);
				match(T__19);
				((FunctionContext)_localctx).isNative =  true; 
				}
			}

			setState(153);
			match(T__20);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(154);
				compTemplate();
				}
			}

			setState(157);
			((FunctionContext)_localctx).name = match(ID);
			setState(158);
			match(T__11);
			setState(159);
			funcInterface();
			setState(160);
			match(T__12);
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(161);
				match(T__18);
				setState(162);
				((FunctionContext)_localctx).returnType = type(0);
				}
				break;
			}
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(165);
				if (!(!_localctx.isNative)) throw new FailedPredicateException(this, "!$isNative");
				setState(166);
				match(T__13);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (T__7 - 8)) | (1L << (T__9 - 8)) | (1L << (T__10 - 8)) | (1L << (T__11 - 8)) | (1L << (T__32 - 8)) | (1L << (T__34 - 8)) | (1L << (T__35 - 8)) | (1L << (T__50 - 8)) | (1L << (INT - 8)) | (1L << (REAL - 8)) | (1L << (STRING - 8)) | (1L << (BOOLEAN - 8)) | (1L << (ID - 8)))) != 0)) {
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						setState(167);
						localVariableDef();
						}
						break;
					case 2:
						{
						setState(168);
						statement();
						}
						break;
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				match(T__14);
				}
				break;
			case 2:
				{
				setState(175);
				if (!(_localctx.isNative)) throw new FailedPredicateException(this, "$isNative");
				setState(176);
				match(T__3);
				}
				break;
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

	public static class LocalVariableDefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalVariableDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterLocalVariableDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitLocalVariableDef(this);
		}
	}

	public final LocalVariableDefContext localVariableDef() throws RecognitionException {
		LocalVariableDefContext _localctx = new LocalVariableDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_localVariableDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(180);
				match(T__8);
				setState(181);
				match(ID);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(T__18);
			setState(188);
			type(0);
			setState(189);
			match(T__3);
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

	public static class FuncInterfaceContext extends ParserRuleContext {
		public List<FuncArgContext> funcArg() {
			return getRuleContexts(FuncArgContext.class);
		}
		public FuncArgContext funcArg(int i) {
			return getRuleContext(FuncArgContext.class,i);
		}
		public FuncInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFuncInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFuncInterface(this);
		}
	}

	public final FuncInterfaceContext funcInterface() throws RecognitionException {
		FuncInterfaceContext _localctx = new FuncInterfaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(191);
				funcArg();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(192);
					match(T__8);
					setState(193);
					funcArg();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class FuncArgContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFuncArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFuncArg(this);
		}
	}

	public final FuncArgContext funcArg() throws RecognitionException {
		FuncArgContext _localctx = new FuncArgContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ID);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(202);
				match(T__8);
				setState(203);
				match(ID);
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(T__18);
			setState(210);
			type(0);
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

	public static class PortsDeclContext extends ParserRuleContext {
		public Token direction;
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PortsDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_portsDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterPortsDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitPortsDecl(this);
		}
	}

	public final PortsDeclContext portsDecl() throws RecognitionException {
		PortsDeclContext _localctx = new PortsDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_portsDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ID);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(213);
				match(T__8);
				setState(214);
				match(ID);
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			match(T__18);
			setState(221);
			((PortsDeclContext)_localctx).direction = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
				((PortsDeclContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(222);
			type(0);
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

	public static class CompInterfaceContext extends ParserRuleContext {
		public List<PortsDeclContext> portsDecl() {
			return getRuleContexts(PortsDeclContext.class);
		}
		public PortsDeclContext portsDecl(int i) {
			return getRuleContext(PortsDeclContext.class,i);
		}
		public CompInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterCompInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitCompInterface(this);
		}
	}

	public final CompInterfaceContext compInterface() throws RecognitionException {
		CompInterfaceContext _localctx = new CompInterfaceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_compInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(224);
				portsDecl();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(225);
					match(T__8);
					setState(226);
					portsDecl();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class VariableSegmentContext extends ParserRuleContext {
		public List<LocalVariableDefContext> localVariableDef() {
			return getRuleContexts(LocalVariableDefContext.class);
		}
		public LocalVariableDefContext localVariableDef(int i) {
			return getRuleContext(LocalVariableDefContext.class,i);
		}
		public VariableSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterVariableSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitVariableSegment(this);
		}
	}

	public final VariableSegmentContext variableSegment() throws RecognitionException {
		VariableSegmentContext _localctx = new VariableSegmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__23);
			setState(235);
			match(T__13);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(236);
				localVariableDef();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
			match(T__14);
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

	public static class TransitionSegmentContext extends ParserRuleContext {
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public TransitionSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTransitionSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTransitionSegment(this);
		}
	}

	public final TransitionSegmentContext transitionSegment() throws RecognitionException {
		TransitionSegmentContext _localctx = new TransitionSegmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_transitionSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__24);
			setState(245);
			match(T__13);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__26 - 12)) | (1L << (T__32 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__50 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
				{
				{
				setState(246);
				transition();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			match(T__14);
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

	public static class TransitionContext extends ParserRuleContext {
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	 
		public TransitionContext() { }
		public void copyFrom(TransitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TransitionGroupContext extends TransitionContext {
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public TransitionGroupContext(TransitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTransitionGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTransitionGroup(this);
		}
	}
	public static class TransitionSingleContext extends TransitionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TransitionSingleContext(TransitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTransitionSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTransitionSingle(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_transition);
		int _la;
		try {
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__32:
			case T__34:
			case T__35:
			case T__50:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new TransitionSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				term(0);
				setState(255);
				match(T__25);
				setState(261);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(256);
					match(T__13);
					setState(257);
					statements();
					setState(258);
					match(T__14);
					}
					break;
				case T__7:
				case T__9:
				case T__10:
				case T__11:
				case T__32:
				case T__34:
				case T__35:
				case T__50:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(260);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__26:
				_localctx = new TransitionGroupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(T__26);
				setState(264);
				match(T__13);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__26 - 12)) | (1L << (T__32 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__50 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
					{
					{
					setState(265);
					transition();
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(271);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AutomatonContext extends ParserRuleContext {
		public Token name;
		public CompInterfaceContext compInterface() {
			return getRuleContext(CompInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public CompTemplateContext compTemplate() {
			return getRuleContext(CompTemplateContext.class,0);
		}
		public List<VariableSegmentContext> variableSegment() {
			return getRuleContexts(VariableSegmentContext.class);
		}
		public VariableSegmentContext variableSegment(int i) {
			return getRuleContext(VariableSegmentContext.class,i);
		}
		public List<TransitionSegmentContext> transitionSegment() {
			return getRuleContexts(TransitionSegmentContext.class);
		}
		public TransitionSegmentContext transitionSegment(int i) {
			return getRuleContext(TransitionSegmentContext.class,i);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAutomaton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAutomaton(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__27);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(275);
				compTemplate();
				}
			}

			setState(278);
			((AutomatonContext)_localctx).name = match(ID);
			setState(279);
			match(T__11);
			setState(280);
			compInterface();
			setState(281);
			match(T__12);
			setState(282);
			match(T__13);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23 || _la==T__24) {
				{
				setState(285);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					setState(283);
					variableSegment();
					}
					break;
				case T__24:
					{
					setState(284);
					transitionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(290);
			match(T__14);
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

	public static class ComponentSegmentContext extends ParserRuleContext {
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public ComponentSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterComponentSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitComponentSegment(this);
		}
	}

	public final ComponentSegmentContext componentSegment() throws RecognitionException {
		ComponentSegmentContext _localctx = new ComponentSegmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_componentSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(T__28);
			setState(293);
			match(T__13);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(294);
				componentDecl();
				setState(295);
				match(T__3);
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			match(T__14);
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

	public static class InternalSegmentContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public InternalSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_internalSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterInternalSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitInternalSegment(this);
		}
	}

	public final InternalSegmentContext internalSegment() throws RecognitionException {
		InternalSegmentContext _localctx = new InternalSegmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_internalSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__29);
			setState(305);
			match(ID);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(306);
				match(T__8);
				setState(307);
				match(ID);
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			match(T__3);
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

	public static class ConnectionSegmentContext extends ParserRuleContext {
		public List<ConnectionDeclContext> connectionDecl() {
			return getRuleContexts(ConnectionDeclContext.class);
		}
		public ConnectionDeclContext connectionDecl(int i) {
			return getRuleContext(ConnectionDeclContext.class,i);
		}
		public ConnectionSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectionSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterConnectionSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitConnectionSegment(this);
		}
	}

	public final ConnectionSegmentContext connectionSegment() throws RecognitionException {
		ConnectionSegmentContext _localctx = new ConnectionSegmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_connectionSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(T__30);
			setState(316);
			match(T__13);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__51 - 12)) | (1L << (T__53 - 12)) | (1L << (T__54 - 12)) | (1L << (T__55 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__59 - 12)) | (1L << (T__60 - 12)) | (1L << (ID - 12)))) != 0)) {
				{
				{
				setState(317);
				connectionDecl();
				setState(318);
				match(T__3);
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
			match(T__14);
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

	public static class ComponentDeclContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ComponentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterComponentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitComponentDecl(this);
		}
	}

	public final ComponentDeclContext componentDecl() throws RecognitionException {
		ComponentDeclContext _localctx = new ComponentDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_componentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(ID);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(328);
				match(T__8);
				setState(329);
				match(ID);
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
			match(T__18);
			setState(336);
			type(0);
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

	public static class ConnectionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ConnectionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterConnectionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitConnectionDecl(this);
		}
	}

	public final ConnectionDeclContext connectionDecl() throws RecognitionException {
		ConnectionDeclContext _localctx = new ConnectionDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_connectionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			type(0);
			setState(339);
			match(T__11);
			setState(340);
			term(0);
			setState(341);
			match(T__12);
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

	public static class SystemContext extends ParserRuleContext {
		public Token name;
		public CompInterfaceContext compInterface() {
			return getRuleContext(CompInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public CompTemplateContext compTemplate() {
			return getRuleContext(CompTemplateContext.class,0);
		}
		public List<ComponentSegmentContext> componentSegment() {
			return getRuleContexts(ComponentSegmentContext.class);
		}
		public ComponentSegmentContext componentSegment(int i) {
			return getRuleContext(ComponentSegmentContext.class,i);
		}
		public List<InternalSegmentContext> internalSegment() {
			return getRuleContexts(InternalSegmentContext.class);
		}
		public InternalSegmentContext internalSegment(int i) {
			return getRuleContext(InternalSegmentContext.class,i);
		}
		public List<ConnectionSegmentContext> connectionSegment() {
			return getRuleContexts(ConnectionSegmentContext.class);
		}
		public ConnectionSegmentContext connectionSegment(int i) {
			return getRuleContext(ConnectionSegmentContext.class,i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitSystem(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__31);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(344);
				compTemplate();
				}
			}

			setState(347);
			((SystemContext)_localctx).name = match(ID);
			setState(348);
			match(T__11);
			setState(349);
			compInterface();
			setState(350);
			match(T__12);
			setState(351);
			match(T__13);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) {
				{
				setState(355);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__28:
					{
					setState(352);
					componentSegment();
					}
					break;
				case T__29:
					{
					setState(353);
					internalSegment();
					}
					break;
				case T__30:
					{
					setState(354);
					connectionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(360);
			match(T__14);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueTermContext extends TermContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterValueTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitValueTerm(this);
		}
	}
	public static class IteTermContext extends TermContext {
		public TermContext condition;
		public TermContext ifTrue;
		public TermContext ifFalse;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IteTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIteTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIteTerm(this);
		}
	}
	public static class BinaryOprTermContext extends TermContext {
		public TermContext left;
		public Token opr;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public BinaryOprTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBinaryOprTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBinaryOprTerm(this);
		}
	}
	public static class ElementTermContext extends TermContext {
		public TermContext container;
		public TermContext key;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ElementTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterElementTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitElementTerm(this);
		}
	}
	public static class BracketTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public BracketTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBracketTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBracketTerm(this);
		}
	}
	public static class TupleTermContext extends TermContext {
		public TermContext left;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TupleTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTupleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTupleTerm(this);
		}
	}
	public static class SingleOprTermContext extends TermContext {
		public Token opr;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SingleOprTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterSingleOprTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitSingleOprTerm(this);
		}
	}
	public static class ListTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ListTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterListTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitListTerm(this);
		}
	}
	public static class CallTermContext extends TermContext {
		public TermContext callee;
		public TermContext args;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public CallTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterCallTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitCallTerm(this);
		}
	}
	public static class FieldTermContext extends TermContext {
		public TermContext structure;
		public Token key;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public FieldTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFieldTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFieldTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				_localctx = new BracketTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(363);
				match(T__11);
				setState(364);
				term(0);
				setState(365);
				match(T__12);
				}
				break;
			case T__32:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367);
				match(T__32);
				setState(368);
				term(0);
				setState(369);
				match(T__33);
				}
				break;
			case T__34:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				((SingleOprTermContext)_localctx).opr = match(T__34);
				setState(372);
				term(25);
				}
				break;
			case T__35:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
				((SingleOprTermContext)_localctx).opr = match(T__35);
				setState(374);
				term(24);
				}
				break;
			case T__50:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				{
				_localctx = new ValueTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(451);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(378);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(379);
						((BinaryOprTermContext)_localctx).opr = match(T__36);
						setState(380);
						((BinaryOprTermContext)_localctx).right = term(21);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(381);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(382);
						((BinaryOprTermContext)_localctx).opr = match(T__2);
						setState(383);
						((BinaryOprTermContext)_localctx).right = term(20);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(384);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(385);
						((BinaryOprTermContext)_localctx).opr = match(T__37);
						setState(386);
						((BinaryOprTermContext)_localctx).right = term(19);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(387);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(388);
						((BinaryOprTermContext)_localctx).opr = match(T__38);
						setState(389);
						((BinaryOprTermContext)_localctx).right = term(18);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(390);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(391);
						((BinaryOprTermContext)_localctx).opr = match(T__34);
						setState(392);
						((BinaryOprTermContext)_localctx).right = term(17);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(393);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(394);
						((BinaryOprTermContext)_localctx).opr = match(T__16);
						setState(395);
						((BinaryOprTermContext)_localctx).right = term(16);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(396);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(397);
						((BinaryOprTermContext)_localctx).opr = match(T__39);
						setState(398);
						((BinaryOprTermContext)_localctx).right = term(15);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(399);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(400);
						((BinaryOprTermContext)_localctx).opr = match(T__17);
						setState(401);
						((BinaryOprTermContext)_localctx).right = term(14);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(402);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(403);
						((BinaryOprTermContext)_localctx).opr = match(T__40);
						setState(404);
						((BinaryOprTermContext)_localctx).right = term(13);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(405);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(406);
						((BinaryOprTermContext)_localctx).opr = match(T__41);
						setState(407);
						((BinaryOprTermContext)_localctx).right = term(12);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(408);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(409);
						((BinaryOprTermContext)_localctx).opr = match(T__42);
						setState(410);
						((BinaryOprTermContext)_localctx).right = term(11);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(411);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(412);
						((BinaryOprTermContext)_localctx).opr = match(T__43);
						setState(413);
						((BinaryOprTermContext)_localctx).right = term(10);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(414);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(415);
						((BinaryOprTermContext)_localctx).opr = match(T__44);
						setState(416);
						((BinaryOprTermContext)_localctx).right = term(9);
						}
						break;
					case 14:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(417);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(418);
						((BinaryOprTermContext)_localctx).opr = match(T__45);
						setState(419);
						((BinaryOprTermContext)_localctx).right = term(8);
						}
						break;
					case 15:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(420);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(421);
						((BinaryOprTermContext)_localctx).opr = match(T__46);
						setState(422);
						((BinaryOprTermContext)_localctx).right = term(7);
						}
						break;
					case 16:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(423);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(424);
						((BinaryOprTermContext)_localctx).opr = match(T__47);
						setState(425);
						((BinaryOprTermContext)_localctx).right = term(6);
						}
						break;
					case 17:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(426);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(427);
						((BinaryOprTermContext)_localctx).opr = match(T__48);
						setState(428);
						((BinaryOprTermContext)_localctx).right = term(5);
						}
						break;
					case 18:
						{
						_localctx = new IteTermContext(new TermContext(_parentctx, _parentState));
						((IteTermContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(429);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(430);
						match(T__49);
						setState(431);
						((IteTermContext)_localctx).ifTrue = term(0);
						setState(432);
						match(T__18);
						setState(433);
						((IteTermContext)_localctx).ifFalse = term(4);
						}
						break;
					case 19:
						{
						_localctx = new TupleTermContext(new TermContext(_parentctx, _parentState));
						((TupleTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(435);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(436);
						match(T__8);
						setState(437);
						((TupleTermContext)_localctx).right = term(3);
						}
						break;
					case 20:
						{
						_localctx = new CallTermContext(new TermContext(_parentctx, _parentState));
						((CallTermContext)_localctx).callee = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(438);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(439);
						match(T__11);
						setState(440);
						((CallTermContext)_localctx).args = term(0);
						setState(441);
						match(T__12);
						}
						break;
					case 21:
						{
						_localctx = new ElementTermContext(new TermContext(_parentctx, _parentState));
						((ElementTermContext)_localctx).container = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(443);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(444);
						match(T__32);
						setState(445);
						((ElementTermContext)_localctx).key = term(0);
						setState(446);
						match(T__33);
						}
						break;
					case 22:
						{
						_localctx = new FieldTermContext(new TermContext(_parentctx, _parentState));
						((FieldTermContext)_localctx).structure = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(448);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(449);
						match(T__1);
						setState(450);
						((FieldTermContext)_localctx).key = match(ID);
						}
						break;
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntValueContext extends ValueContext {
		public TerminalNode INT() { return getToken(MediatorLangParser.INT, 0); }
		public IntValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIntValue(this);
		}
	}
	public static class BoolValueContext extends ValueContext {
		public TerminalNode BOOLEAN() { return getToken(MediatorLangParser.BOOLEAN, 0); }
		public BoolValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBoolValue(this);
		}
	}
	public static class IdValueContext extends ValueContext {
		public ScopeIDContext scopeID() {
			return getRuleContext(ScopeIDContext.class,0);
		}
		public IdValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIdValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIdValue(this);
		}
	}
	public static class DoubleValueContext extends ValueContext {
		public TerminalNode REAL() { return getToken(MediatorLangParser.REAL, 0); }
		public DoubleValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterDoubleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitDoubleValue(this);
		}
	}
	public static class StrValueContext extends ValueContext {
		public TerminalNode STRING() { return getToken(MediatorLangParser.STRING, 0); }
		public StrValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterStrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitStrValue(this);
		}
	}
	public static class NullValueContext extends ValueContext {
		public NullValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterNullValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitNullValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_value);
		try {
			setState(462);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				match(INT);
				}
				break;
			case REAL:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(457);
				match(REAL);
				}
				break;
			case STRING:
				_localctx = new StrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(458);
				match(STRING);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(459);
				match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new IdValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(460);
				scopeID();
				}
				break;
			case T__50:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(461);
				match(T__50);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BracketTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BracketTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBracketType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBracketType(this);
		}
	}
	public static class CharTypeContext extends TypeContext {
		public CharTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitCharType(this);
		}
	}
	public static class DoubleTypeContext extends TypeContext {
		public DoubleTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterDoubleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitDoubleType(this);
		}
	}
	public static class IdTypeContext extends TypeContext {
		public ScopeIDContext scopeID() {
			return getRuleContext(ScopeIDContext.class,0);
		}
		public IdTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIdType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIdType(this);
		}
	}
	public static class AbstractTypeContext extends TypeContext {
		public AbstractTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAbstractType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAbstractType(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitIntType(this);
		}
	}
	public static class EnumTypeContext extends TypeContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public EnumTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitEnumType(this);
		}
	}
	public static class InitTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public InitTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterInitType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitInitType(this);
		}
	}
	public static class ListTypeContext extends TypeContext {
		public TermContext capacity;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ListTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitListType(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBoolType(this);
		}
	}
	public static class InterfaceTypeContext extends TypeContext {
		public ScopeIDContext scopeID() {
			return getRuleContext(ScopeIDContext.class,0);
		}
		public List<TypeorvalueContext> typeorvalue() {
			return getRuleContexts(TypeorvalueContext.class);
		}
		public TypeorvalueContext typeorvalue(int i) {
			return getRuleContext(TypeorvalueContext.class,i);
		}
		public InterfaceTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitInterfaceType(this);
		}
	}
	public static class BoundedIntTypeContext extends TypeContext {
		public TermContext lbound;
		public TermContext ubound;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public BoundedIntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBoundedIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBoundedIntType(this);
		}
	}
	public static class StructTypeContext extends TypeContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public StructTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitStructType(this);
		}
	}
	public static class NullTypeContext extends TypeContext {
		public NullTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterNullType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitNullType(this);
		}
	}
	public static class UnionTypeContext extends TypeContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public UnionTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterUnionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitUnionType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(465);
				match(T__11);
				setState(466);
				type(0);
				setState(467);
				match(T__12);
				}
				break;
			case 2:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(469);
				match(T__51);
				}
				break;
			case 3:
				{
				_localctx = new BoundedIntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(470);
				match(T__51);
				setState(471);
				((BoundedIntTypeContext)_localctx).lbound = term(0);
				setState(472);
				match(T__52);
				setState(473);
				((BoundedIntTypeContext)_localctx).ubound = term(0);
				}
				break;
			case 4:
				{
				_localctx = new CharTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(475);
				match(T__53);
				}
				break;
			case 5:
				{
				_localctx = new DoubleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(476);
				match(T__54);
				}
				break;
			case 6:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(477);
				match(T__55);
				}
				break;
			case 7:
				{
				_localctx = new EnumTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(478);
				match(T__56);
				setState(479);
				match(T__13);
				setState(480);
				match(ID);
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(481);
					match(T__8);
					setState(482);
					match(ID);
					}
					}
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(488);
				match(T__14);
				}
				break;
			case 8:
				{
				_localctx = new StructTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(489);
				match(T__57);
				setState(490);
				match(T__13);
				setState(496); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(491);
					match(ID);
					setState(492);
					match(T__18);
					setState(493);
					type(0);
					setState(494);
					match(T__3);
					}
					}
					setState(498); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(500);
				match(T__14);
				}
				break;
			case 9:
				{
				_localctx = new AbstractTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				match(T__59);
				}
				break;
			case 10:
				{
				_localctx = new NullTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				match(T__60);
				}
				break;
			case 11:
				{
				_localctx = new IdTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504);
				scopeID();
				}
				break;
			case 12:
				{
				_localctx = new InterfaceTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				scopeID();
				setState(517);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(506);
					match(T__16);
					setState(507);
					typeorvalue();
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(508);
						match(T__8);
						setState(509);
						typeorvalue();
						}
						}
						setState(514);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(515);
					match(T__17);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(535);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(533);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new UnionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(521);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(522);
						match(T__47);
						setState(523);
						type(6);
						}
						break;
					case 2:
						{
						_localctx = new ListTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(524);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(525);
						match(T__32);
						setState(527);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__32 - 12)) | (1L << (T__34 - 12)) | (1L << (T__35 - 12)) | (1L << (T__50 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
							{
							setState(526);
							((ListTypeContext)_localctx).capacity = term(0);
							}
						}

						setState(529);
						match(T__33);
						}
						break;
					case 3:
						{
						_localctx = new InitTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(530);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(531);
						match(T__58);
						setState(532);
						term(0);
						}
						break;
					}
					} 
				}
				setState(537);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeorvalueContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TypeorvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeorvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTypeorvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTypeorvalue(this);
		}
	}

	public final TypeorvalueContext typeorvalue() throws RecognitionException {
		TypeorvalueContext _localctx = new TypeorvalueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeorvalue);
		try {
			setState(540);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				type(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				value();
				}
				break;
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

	public static class ScopeIDContext extends ParserRuleContext {
		public Token ID;
		public List<Token> scopes = new ArrayList<Token>();
		public Token identifier;
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public ScopeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterScopeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitScopeID(this);
		}
	}

	public final ScopeIDContext scopeID() throws RecognitionException {
		ScopeIDContext _localctx = new ScopeIDContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_scopeID);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(542);
					((ScopeIDContext)_localctx).ID = match(ID);
					((ScopeIDContext)_localctx).scopes.add(((ScopeIDContext)_localctx).ID);
					setState(543);
					match(T__1);
					}
					} 
				}
				setState(548);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			setState(549);
			((ScopeIDContext)_localctx).identifier = match(ID);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return function_sempred((FunctionContext)_localctx, predIndex);
		case 23:
			return term_sempred((TermContext)_localctx, predIndex);
		case 25:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean function_sempred(FunctionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !_localctx.isNative;
		case 1:
			return _localctx.isNative;
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 12);
		case 11:
			return precpred(_ctx, 11);
		case 12:
			return precpred(_ctx, 10);
		case 13:
			return precpred(_ctx, 9);
		case 14:
			return precpred(_ctx, 8);
		case 15:
			return precpred(_ctx, 7);
		case 16:
			return precpred(_ctx, 6);
		case 17:
			return precpred(_ctx, 5);
		case 18:
			return precpred(_ctx, 4);
		case 19:
			return precpred(_ctx, 3);
		case 20:
			return precpred(_ctx, 2);
		case 21:
			return precpred(_ctx, 23);
		case 22:
			return precpred(_ctx, 22);
		case 23:
			return precpred(_ctx, 21);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 5);
		case 25:
			return precpred(_ctx, 7);
		case 26:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u022a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\3\3\3\3\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5Y\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5b\n\5\f\5\16\5e\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5u\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5}\n\5\5\5\177\n\5\5\5\u0081"+
		"\n\5\3\6\7\6\u0084\n\6\f\6\16\6\u0087\13\6\3\7\3\7\3\7\3\7\7\7\u008d\n"+
		"\7\f\7\16\7\u0090\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u009a\n\t\3"+
		"\t\3\t\5\t\u009e\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a6\n\t\3\t\3\t\3\t"+
		"\3\t\7\t\u00ac\n\t\f\t\16\t\u00af\13\t\3\t\3\t\3\t\5\t\u00b4\n\t\3\n\3"+
		"\n\3\n\7\n\u00b9\n\n\f\n\16\n\u00bc\13\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\7\13\u00c5\n\13\f\13\16\13\u00c8\13\13\5\13\u00ca\n\13\3\f\3\f\3\f\7"+
		"\f\u00cf\n\f\f\f\16\f\u00d2\13\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00da\n\r"+
		"\f\r\16\r\u00dd\13\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u00e6\n\16\f"+
		"\16\16\16\u00e9\13\16\5\16\u00eb\n\16\3\17\3\17\3\17\7\17\u00f0\n\17\f"+
		"\17\16\17\u00f3\13\17\3\17\3\17\3\20\3\20\3\20\7\20\u00fa\n\20\f\20\16"+
		"\20\u00fd\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0108"+
		"\n\21\3\21\3\21\3\21\7\21\u010d\n\21\f\21\16\21\u0110\13\21\3\21\5\21"+
		"\u0113\n\21\3\22\3\22\5\22\u0117\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u0120\n\22\f\22\16\22\u0123\13\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\7\23\u012c\n\23\f\23\16\23\u012f\13\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\7\24\u0137\n\24\f\24\16\24\u013a\13\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\7\25\u0143\n\25\f\25\16\25\u0146\13\25\3\25\3\25\3\26\3"+
		"\26\3\26\7\26\u014d\n\26\f\26\16\26\u0150\13\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\5\30\u015c\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u0166\n\30\f\30\16\30\u0169\13\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u017b\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\7\31\u01c6\n\31\f\31\16\31\u01c9\13\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u01d1\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u01e6\n\33\f\33\16\33\u01e9\13\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\6\33\u01f3\n\33\r\33\16\33\u01f4\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u0201\n\33\f\33\16\33\u0204\13\33\3\33\3\33\5"+
		"\33\u0208\n\33\5\33\u020a\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0212"+
		"\n\33\3\33\3\33\3\33\3\33\7\33\u0218\n\33\f\33\16\33\u021b\13\33\3\34"+
		"\3\34\5\34\u021f\n\34\3\35\3\35\7\35\u0223\n\35\f\35\16\35\u0226\13\35"+
		"\3\35\3\35\3\35\2\4\60\64\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668\2\4\4\2\5\5GG\3\2\30\31\2\u026e\2A\3\2\2\2\4D\3\2"+
		"\2\2\6O\3\2\2\2\b\u0080\3\2\2\2\n\u0085\3\2\2\2\f\u0088\3\2\2\2\16\u0093"+
		"\3\2\2\2\20\u0099\3\2\2\2\22\u00b5\3\2\2\2\24\u00c9\3\2\2\2\26\u00cb\3"+
		"\2\2\2\30\u00d6\3\2\2\2\32\u00ea\3\2\2\2\34\u00ec\3\2\2\2\36\u00f6\3\2"+
		"\2\2 \u0112\3\2\2\2\"\u0114\3\2\2\2$\u0126\3\2\2\2&\u0132\3\2\2\2(\u013d"+
		"\3\2\2\2*\u0149\3\2\2\2,\u0154\3\2\2\2.\u0159\3\2\2\2\60\u017a\3\2\2\2"+
		"\62\u01d0\3\2\2\2\64\u0209\3\2\2\2\66\u021e\3\2\2\28\u0224\3\2\2\2:@\5"+
		"\4\3\2;@\5\6\4\2<@\5\20\t\2=@\5\"\22\2>@\5.\30\2?:\3\2\2\2?;\3\2\2\2?"+
		"<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\3\3\2\2\2"+
		"CA\3\2\2\2DI\7\3\2\2EF\7G\2\2FH\7\4\2\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\t\2\2\2MN\7\6\2\2N\5\3\2\2\2OP\7\7\2"+
		"\2PQ\5\64\33\2QR\7\b\2\2RS\7G\2\2ST\7\6\2\2T\7\3\2\2\2UV\5\60\31\2VW\7"+
		"\t\2\2WY\3\2\2\2XU\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\5\60\31\2[\\\7\6\2\2"+
		"\\\u0081\3\2\2\2]^\7\n\2\2^c\7G\2\2_`\7\13\2\2`b\7G\2\2a_\3\2\2\2be\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2f\u0081\7\6\2\2gh\7\f\2"+
		"\2hi\5\60\31\2ij\7\6\2\2j\u0081\3\2\2\2kl\7\r\2\2lm\7\16\2\2mn\5\60\31"+
		"\2nt\7\17\2\2ou\5\b\5\2pq\7\20\2\2qr\5\n\6\2rs\7\21\2\2su\3\2\2\2to\3"+
		"\2\2\2tp\3\2\2\2u~\3\2\2\2v|\7\22\2\2w}\5\b\5\2xy\7\20\2\2yz\5\n\6\2z"+
		"{\7\21\2\2{}\3\2\2\2|w\3\2\2\2|x\3\2\2\2}\177\3\2\2\2~v\3\2\2\2~\177\3"+
		"\2\2\2\177\u0081\3\2\2\2\u0080X\3\2\2\2\u0080]\3\2\2\2\u0080g\3\2\2\2"+
		"\u0080k\3\2\2\2\u0081\t\3\2\2\2\u0082\u0084\5\b\5\2\u0083\u0082\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\13"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\23\2\2\u0089\u008e\5\16\b\2"+
		"\u008a\u008b\7\13\2\2\u008b\u008d\5\16\b\2\u008c\u008a\3\2\2\2\u008d\u0090"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\24\2\2\u0092\r\3\2\2\2\u0093\u0094\7G\2\2"+
		"\u0094\u0095\7\25\2\2\u0095\u0096\5\64\33\2\u0096\17\3\2\2\2\u0097\u0098"+
		"\7\26\2\2\u0098\u009a\b\t\1\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u009b\3\2\2\2\u009b\u009d\7\27\2\2\u009c\u009e\5\f\7\2\u009d\u009c"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7G\2\2\u00a0"+
		"\u00a1\7\16\2\2\u00a1\u00a2\5\24\13\2\u00a2\u00a5\7\17\2\2\u00a3\u00a4"+
		"\7\25\2\2\u00a4\u00a6\5\64\33\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2"+
		"\2\u00a6\u00b3\3\2\2\2\u00a7\u00a8\6\t\2\3\u00a8\u00ad\7\20\2\2\u00a9"+
		"\u00ac\5\22\n\2\u00aa\u00ac\5\b\5\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3"+
		"\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b4\7\21\2\2\u00b1\u00b2\6"+
		"\t\3\3\u00b2\u00b4\7\6\2\2\u00b3\u00a7\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\21\3\2\2\2\u00b5\u00ba\7G\2\2\u00b6\u00b7\7\13\2\2\u00b7\u00b9\7G\2\2"+
		"\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\25\2\2"+
		"\u00be\u00bf\5\64\33\2\u00bf\u00c0\7\6\2\2\u00c0\23\3\2\2\2\u00c1\u00c6"+
		"\5\26\f\2\u00c2\u00c3\7\13\2\2\u00c3\u00c5\5\26\f\2\u00c4\u00c2\3\2\2"+
		"\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\25\3\2\2\2\u00cb\u00d0\7G\2\2\u00cc\u00cd\7\13\2\2\u00cd\u00cf\7G\2\2"+
		"\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\25\2\2"+
		"\u00d4\u00d5\5\64\33\2\u00d5\27\3\2\2\2\u00d6\u00db\7G\2\2\u00d7\u00d8"+
		"\7\13\2\2\u00d8\u00da\7G\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00de\u00df\7\25\2\2\u00df\u00e0\t\3\2\2\u00e0\u00e1\5\64\33\2\u00e1"+
		"\31\3\2\2\2\u00e2\u00e7\5\30\r\2\u00e3\u00e4\7\13\2\2\u00e4\u00e6\5\30"+
		"\r\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\33\3\2\2\2\u00ec\u00ed\7\32\2\2\u00ed\u00f1"+
		"\7\20\2\2\u00ee\u00f0\5\22\n\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f4\u00f5\7\21\2\2\u00f5\35\3\2\2\2\u00f6\u00f7\7\33\2\2\u00f7"+
		"\u00fb\7\20\2\2\u00f8\u00fa\5 \21\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3"+
		"\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00ff\7\21\2\2\u00ff\37\3\2\2\2\u0100\u0101\5\60"+
		"\31\2\u0101\u0107\7\34\2\2\u0102\u0103\7\20\2\2\u0103\u0104\5\n\6\2\u0104"+
		"\u0105\7\21\2\2\u0105\u0108\3\2\2\2\u0106\u0108\5\b\5\2\u0107\u0102\3"+
		"\2\2\2\u0107\u0106\3\2\2\2\u0108\u0113\3\2\2\2\u0109\u010a\7\35\2\2\u010a"+
		"\u010e\7\20\2\2\u010b\u010d\5 \21\2\u010c\u010b\3\2\2\2\u010d\u0110\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0113\7\21\2\2\u0112\u0100\3\2\2\2\u0112\u0109\3"+
		"\2\2\2\u0113!\3\2\2\2\u0114\u0116\7\36\2\2\u0115\u0117\5\f\7\2\u0116\u0115"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7G\2\2\u0119"+
		"\u011a\7\16\2\2\u011a\u011b\5\32\16\2\u011b\u011c\7\17\2\2\u011c\u0121"+
		"\7\20\2\2\u011d\u0120\5\34\17\2\u011e\u0120\5\36\20\2\u011f\u011d\3\2"+
		"\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7\21"+
		"\2\2\u0125#\3\2\2\2\u0126\u0127\7\37\2\2\u0127\u012d\7\20\2\2\u0128\u0129"+
		"\5*\26\2\u0129\u012a\7\6\2\2\u012a\u012c\3\2\2\2\u012b\u0128\3\2\2\2\u012c"+
		"\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7\21\2\2\u0131%\3\2\2\2\u0132\u0133"+
		"\7 \2\2\u0133\u0138\7G\2\2\u0134\u0135\7\13\2\2\u0135\u0137\7G\2\2\u0136"+
		"\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7\6\2\2\u013c"+
		"\'\3\2\2\2\u013d\u013e\7!\2\2\u013e\u0144\7\20\2\2\u013f\u0140\5,\27\2"+
		"\u0140\u0141\7\6\2\2\u0141\u0143\3\2\2\2\u0142\u013f\3\2\2\2\u0143\u0146"+
		"\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0148\7\21\2\2\u0148)\3\2\2\2\u0149\u014e\7G\2\2"+
		"\u014a\u014b\7\13\2\2\u014b\u014d\7G\2\2\u014c\u014a\3\2\2\2\u014d\u0150"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0152\7\25\2\2\u0152\u0153\5\64\33\2\u0153+\3\2\2"+
		"\2\u0154\u0155\5\64\33\2\u0155\u0156\7\16\2\2\u0156\u0157\5\60\31\2\u0157"+
		"\u0158\7\17\2\2\u0158-\3\2\2\2\u0159\u015b\7\"\2\2\u015a\u015c\5\f\7\2"+
		"\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e"+
		"\7G\2\2\u015e\u015f\7\16\2\2\u015f\u0160\5\32\16\2\u0160\u0161\7\17\2"+
		"\2\u0161\u0167\7\20\2\2\u0162\u0166\5$\23\2\u0163\u0166\5&\24\2\u0164"+
		"\u0166\5(\25\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0164\3\2"+
		"\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\7\21\2\2\u016b/\3\2\2\2"+
		"\u016c\u016d\b\31\1\2\u016d\u016e\7\16\2\2\u016e\u016f\5\60\31\2\u016f"+
		"\u0170\7\17\2\2\u0170\u017b\3\2\2\2\u0171\u0172\7#\2\2\u0172\u0173\5\60"+
		"\31\2\u0173\u0174\7$\2\2\u0174\u017b\3\2\2\2\u0175\u0176\7%\2\2\u0176"+
		"\u017b\5\60\31\33\u0177\u0178\7&\2\2\u0178\u017b\5\60\31\32\u0179\u017b"+
		"\5\62\32\2\u017a\u016c\3\2\2\2\u017a\u0171\3\2\2\2\u017a\u0175\3\2\2\2"+
		"\u017a\u0177\3\2\2\2\u017a\u0179\3\2\2\2\u017b\u01c7\3\2\2\2\u017c\u017d"+
		"\f\26\2\2\u017d\u017e\7\'\2\2\u017e\u01c6\5\60\31\27\u017f\u0180\f\25"+
		"\2\2\u0180\u0181\7\5\2\2\u0181\u01c6\5\60\31\26\u0182\u0183\f\24\2\2\u0183"+
		"\u0184\7(\2\2\u0184\u01c6\5\60\31\25\u0185\u0186\f\23\2\2\u0186\u0187"+
		"\7)\2\2\u0187\u01c6\5\60\31\24\u0188\u0189\f\22\2\2\u0189\u018a\7%\2\2"+
		"\u018a\u01c6\5\60\31\23\u018b\u018c\f\21\2\2\u018c\u018d\7\23\2\2\u018d"+
		"\u01c6\5\60\31\22\u018e\u018f\f\20\2\2\u018f\u0190\7*\2\2\u0190\u01c6"+
		"\5\60\31\21\u0191\u0192\f\17\2\2\u0192\u0193\7\24\2\2\u0193\u01c6\5\60"+
		"\31\20\u0194\u0195\f\16\2\2\u0195\u0196\7+\2\2\u0196\u01c6\5\60\31\17"+
		"\u0197\u0198\f\r\2\2\u0198\u0199\7,\2\2\u0199\u01c6\5\60\31\16\u019a\u019b"+
		"\f\f\2\2\u019b\u019c\7-\2\2\u019c\u01c6\5\60\31\r\u019d\u019e\f\13\2\2"+
		"\u019e\u019f\7.\2\2\u019f\u01c6\5\60\31\f\u01a0\u01a1\f\n\2\2\u01a1\u01a2"+
		"\7/\2\2\u01a2\u01c6\5\60\31\13\u01a3\u01a4\f\t\2\2\u01a4\u01a5\7\60\2"+
		"\2\u01a5\u01c6\5\60\31\n\u01a6\u01a7\f\b\2\2\u01a7\u01a8\7\61\2\2\u01a8"+
		"\u01c6\5\60\31\t\u01a9\u01aa\f\7\2\2\u01aa\u01ab\7\62\2\2\u01ab\u01c6"+
		"\5\60\31\b\u01ac\u01ad\f\6\2\2\u01ad\u01ae\7\63\2\2\u01ae\u01c6\5\60\31"+
		"\7\u01af\u01b0\f\5\2\2\u01b0\u01b1\7\64\2\2\u01b1\u01b2\5\60\31\2\u01b2"+
		"\u01b3\7\25\2\2\u01b3\u01b4\5\60\31\6\u01b4\u01c6\3\2\2\2\u01b5\u01b6"+
		"\f\4\2\2\u01b6\u01b7\7\13\2\2\u01b7\u01c6\5\60\31\5\u01b8\u01b9\f\31\2"+
		"\2\u01b9\u01ba\7\16\2\2\u01ba\u01bb\5\60\31\2\u01bb\u01bc\7\17\2\2\u01bc"+
		"\u01c6\3\2\2\2\u01bd\u01be\f\30\2\2\u01be\u01bf\7#\2\2\u01bf\u01c0\5\60"+
		"\31\2\u01c0\u01c1\7$\2\2\u01c1\u01c6\3\2\2\2\u01c2\u01c3\f\27\2\2\u01c3"+
		"\u01c4\7\4\2\2\u01c4\u01c6\7G\2\2\u01c5\u017c\3\2\2\2\u01c5\u017f\3\2"+
		"\2\2\u01c5\u0182\3\2\2\2\u01c5\u0185\3\2\2\2\u01c5\u0188\3\2\2\2\u01c5"+
		"\u018b\3\2\2\2\u01c5\u018e\3\2\2\2\u01c5\u0191\3\2\2\2\u01c5\u0194\3\2"+
		"\2\2\u01c5\u0197\3\2\2\2\u01c5\u019a\3\2\2\2\u01c5\u019d\3\2\2\2\u01c5"+
		"\u01a0\3\2\2\2\u01c5\u01a3\3\2\2\2\u01c5\u01a6\3\2\2\2\u01c5\u01a9\3\2"+
		"\2\2\u01c5\u01ac\3\2\2\2\u01c5\u01af\3\2\2\2\u01c5\u01b5\3\2\2\2\u01c5"+
		"\u01b8\3\2\2\2\u01c5\u01bd\3\2\2\2\u01c5\u01c2\3\2\2\2\u01c6\u01c9\3\2"+
		"\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\61\3\2\2\2\u01c9\u01c7"+
		"\3\2\2\2\u01ca\u01d1\7C\2\2\u01cb\u01d1\7D\2\2\u01cc\u01d1\7E\2\2\u01cd"+
		"\u01d1\7F\2\2\u01ce\u01d1\58\35\2\u01cf\u01d1\7\65\2\2\u01d0\u01ca\3\2"+
		"\2\2\u01d0\u01cb\3\2\2\2\u01d0\u01cc\3\2\2\2\u01d0\u01cd\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d0\u01cf\3\2\2\2\u01d1\63\3\2\2\2\u01d2\u01d3\b\33\1"+
		"\2\u01d3\u01d4\7\16\2\2\u01d4\u01d5\5\64\33\2\u01d5\u01d6\7\17\2\2\u01d6"+
		"\u020a\3\2\2\2\u01d7\u020a\7\66\2\2\u01d8\u01d9\7\66\2\2\u01d9\u01da\5"+
		"\60\31\2\u01da\u01db\7\67\2\2\u01db\u01dc\5\60\31\2\u01dc\u020a\3\2\2"+
		"\2\u01dd\u020a\78\2\2\u01de\u020a\79\2\2\u01df\u020a\7:\2\2\u01e0\u01e1"+
		"\7;\2\2\u01e1\u01e2\7\20\2\2\u01e2\u01e7\7G\2\2\u01e3\u01e4\7\13\2\2\u01e4"+
		"\u01e6\7G\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2"+
		"\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea"+
		"\u020a\7\21\2\2\u01eb\u01ec\7<\2\2\u01ec\u01f2\7\20\2\2\u01ed\u01ee\7"+
		"G\2\2\u01ee\u01ef\7\25\2\2\u01ef\u01f0\5\64\33\2\u01f0\u01f1\7\6\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01ed\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2"+
		"\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\7\21\2\2\u01f7"+
		"\u020a\3\2\2\2\u01f8\u020a\7>\2\2\u01f9\u020a\7?\2\2\u01fa\u020a\58\35"+
		"\2\u01fb\u0207\58\35\2\u01fc\u01fd\7\23\2\2\u01fd\u0202\5\66\34\2\u01fe"+
		"\u01ff\7\13\2\2\u01ff\u0201\5\66\34\2\u0200\u01fe\3\2\2\2\u0201\u0204"+
		"\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0205\u0206\7\24\2\2\u0206\u0208\3\2\2\2\u0207\u01fc\3"+
		"\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u01d2\3\2\2\2\u0209"+
		"\u01d7\3\2\2\2\u0209\u01d8\3\2\2\2\u0209\u01dd\3\2\2\2\u0209\u01de\3\2"+
		"\2\2\u0209\u01df\3\2\2\2\u0209\u01e0\3\2\2\2\u0209\u01eb\3\2\2\2\u0209"+
		"\u01f8\3\2\2\2\u0209\u01f9\3\2\2\2\u0209\u01fa\3\2\2\2\u0209\u01fb\3\2"+
		"\2\2\u020a\u0219\3\2\2\2\u020b\u020c\f\7\2\2\u020c\u020d\7\62\2\2\u020d"+
		"\u0218\5\64\33\b\u020e\u020f\f\t\2\2\u020f\u0211\7#\2\2\u0210\u0212\5"+
		"\60\31\2\u0211\u0210\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0218\7$\2\2\u0214\u0215\f\b\2\2\u0215\u0216\7=\2\2\u0216\u0218\5\60"+
		"\31\2\u0217\u020b\3\2\2\2\u0217\u020e\3\2\2\2\u0217\u0214\3\2\2\2\u0218"+
		"\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\65\3\2\2"+
		"\2\u021b\u0219\3\2\2\2\u021c\u021f\5\64\33\2\u021d\u021f\5\62\32\2\u021e"+
		"\u021c\3\2\2\2\u021e\u021d\3\2\2\2\u021f\67\3\2\2\2\u0220\u0221\7G\2\2"+
		"\u0221\u0223\7\4\2\2\u0222\u0220\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222"+
		"\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227"+
		"\u0228\7G\2\2\u02289\3\2\2\2\67?AIXct|~\u0080\u0085\u008e\u0099\u009d"+
		"\u00a5\u00ab\u00ad\u00b3\u00ba\u00c6\u00c9\u00d0\u00db\u00e7\u00ea\u00f1"+
		"\u00fb\u0107\u010e\u0112\u0116\u011f\u0121\u012d\u0138\u0144\u014e\u015b"+
		"\u0165\u0167\u017a\u01c5\u01c7\u01d0\u01e7\u01f4\u0202\u0207\u0209\u0211"+
		"\u0217\u0219\u021e\u0224";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
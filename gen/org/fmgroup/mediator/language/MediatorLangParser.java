// Generated from /Users/liyi/Library/Mobile Documents/com~apple~CloudDocs/项目/Mediator/src-antlr/MediatorLang.g4 by ANTLR 4.7
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
		T__59=60, T__60=61, T__61=62, LINE_COMMENT=63, COMMENT=64, IGNORE=65, 
		INT=66, REAL=67, STRING=68, BOOLEAN=69, PORTVAR_SUFFIX=70, ID=71;
	public static final int
		RULE_prog = 0, RULE_dependency = 1, RULE_typedef = 2, RULE_portIdentifier = 3, 
		RULE_statement = 4, RULE_statements = 5, RULE_template = 6, RULE_function = 7, 
		RULE_localVariableDef = 8, RULE_functionInterface = 9, RULE_portsDecl = 10, 
		RULE_entityInterface = 11, RULE_variableSegment = 12, RULE_transitionSegment = 13, 
		RULE_transition = 14, RULE_automaton = 15, RULE_componentSegment = 16, 
		RULE_internalSegment = 17, RULE_connectionSegment = 18, RULE_componentDecl = 19, 
		RULE_connectionDecl = 20, RULE_system = 21, RULE_term = 22, RULE_value = 23, 
		RULE_type = 24, RULE_typeorvalue = 25, RULE_scopedID = 26;
	public static final String[] ruleNames = {
		"prog", "dependency", "typedef", "portIdentifier", "statement", "statements", 
		"template", "function", "localVariableDef", "functionInterface", "portsDecl", 
		"entityInterface", "variableSegment", "transitionSegment", "transition", 
		"automaton", "componentSegment", "internalSegment", "connectionSegment", 
		"componentDecl", "connectionDecl", "system", "term", "value", "type", 
		"typeorvalue", "scopedID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "'.'", "'*'", "';'", "'typedef'", "'as'", "','", "'='", 
		"'sync'", "'return'", "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'<'", 
		"'>'", "'native'", "'function'", "':'", "'variables'", "'statements'", 
		"'in'", "'out'", "'transitions'", "'->'", "'group'", "'automaton'", "'components'", 
		"'internals'", "'connections'", "'system'", "'['", "']'", "'-'", "'!'", 
		"'%'", "'/'", "'+'", "'<='", "'>='", "'=='", "'!='", "'^'", "'^^'", "'&'", 
		"'&&'", "'|'", "'||'", "'?'", "'null'", "'int'", "'..'", "'char'", "'double'", 
		"'bool'", "'enum'", "'struct'", "'init'", "'type'", "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "LINE_COMMENT", "COMMENT", "IGNORE", "INT", "REAL", 
		"STRING", "BOOLEAN", "PORTVAR_SUFFIX", "ID"
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
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__18) | (1L << T__19) | (1L << T__28) | (1L << T__32))) != 0)) {
				{
				setState(59);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(54);
					dependency();
					}
					break;
				case T__4:
					{
					setState(55);
					typedef();
					}
					break;
				case T__18:
				case T__19:
					{
					setState(56);
					function();
					}
					break;
				case T__28:
					{
					setState(57);
					automaton();
					}
					break;
				case T__32:
					{
					setState(58);
					system();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
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
			setState(64);
			match(T__0);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(65);
					match(ID);
					setState(66);
					match(T__1);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(73);
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
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__4);
			setState(76);
			type(0);
			setState(77);
			match(T__5);
			setState(78);
			match(ID);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(79);
				match(T__6);
				setState(80);
				match(ID);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
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

	public static class PortIdentifierContext extends ParserRuleContext {
		public Token owner;
		public Token identifier;
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public PortIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_portIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterPortIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitPortIdentifier(this);
		}
	}

	public final PortIdentifierContext portIdentifier() throws RecognitionException {
		PortIdentifierContext _localctx = new PortIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_portIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(88);
				((PortIdentifierContext)_localctx).owner = match(ID);
				setState(89);
				match(T__1);
				}
				break;
			}
			setState(92);
			((PortIdentifierContext)_localctx).identifier = match(ID);
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
		public List<PortIdentifierContext> portIdentifier() {
			return getRuleContexts(PortIdentifierContext.class);
		}
		public PortIdentifierContext portIdentifier(int i) {
			return getRuleContext(PortIdentifierContext.class,i);
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
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__33:
			case T__35:
			case T__36:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(94);
					((AssignmentStatementContext)_localctx).target = term(0);
					setState(95);
					match(T__7);
					}
					break;
				}
				setState(99);
				((AssignmentStatementContext)_localctx).expr = term(0);
				setState(100);
				match(T__3);
				}
				break;
			case T__8:
				_localctx = new SynchronizingStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(T__8);
				setState(103);
				portIdentifier();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(104);
					match(T__6);
					setState(105);
					portIdentifier();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(T__3);
				}
				break;
			case T__9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(T__9);
				setState(114);
				term(0);
				setState(115);
				match(T__3);
				}
				break;
			case T__10:
				_localctx = new IteStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(T__10);
				setState(118);
				match(T__11);
				setState(119);
				((IteStatementContext)_localctx).condition = term(0);
				setState(120);
				match(T__12);
				setState(126);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__33:
				case T__35:
				case T__36:
				case T__51:
				case T__52:
				case T__54:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__60:
				case T__61:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(121);
					((IteStatementContext)_localctx).thenstmt = statement();
					}
					break;
				case T__13:
					{
					setState(122);
					match(T__13);
					setState(123);
					((IteStatementContext)_localctx).thenstmts = statements();
					setState(124);
					match(T__14);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(128);
					match(T__15);
					setState(134);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__8:
					case T__9:
					case T__10:
					case T__11:
					case T__33:
					case T__35:
					case T__36:
					case T__51:
					case T__52:
					case T__54:
					case T__55:
					case T__56:
					case T__57:
					case T__58:
					case T__60:
					case T__61:
					case INT:
					case REAL:
					case STRING:
					case BOOLEAN:
					case ID:
						{
						setState(129);
						((IteStatementContext)_localctx).elsestmt = statement();
						}
						break;
					case T__13:
						{
						setState(130);
						match(T__13);
						setState(131);
						((IteStatementContext)_localctx).elsestmts = statements();
						setState(132);
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
		enterRule(_localctx, 10, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (T__8 - 9)) | (1L << (T__9 - 9)) | (1L << (T__10 - 9)) | (1L << (T__11 - 9)) | (1L << (T__33 - 9)) | (1L << (T__35 - 9)) | (1L << (T__36 - 9)) | (1L << (T__51 - 9)) | (1L << (T__52 - 9)) | (1L << (T__54 - 9)) | (1L << (T__55 - 9)) | (1L << (T__56 - 9)) | (1L << (T__57 - 9)) | (1L << (T__58 - 9)) | (1L << (T__60 - 9)) | (1L << (T__61 - 9)) | (1L << (INT - 9)) | (1L << (REAL - 9)) | (1L << (STRING - 9)) | (1L << (BOOLEAN - 9)) | (1L << (ID - 9)))) != 0)) {
				{
				{
				setState(140);
				statement();
				}
				}
				setState(145);
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

	public static class TemplateContext extends ParserRuleContext {
		public List<LocalVariableDefContext> localVariableDef() {
			return getRuleContexts(LocalVariableDefContext.class);
		}
		public LocalVariableDefContext localVariableDef(int i) {
			return getRuleContext(LocalVariableDefContext.class,i);
		}
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTemplate(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_template);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__16);
			setState(147);
			localVariableDef();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(148);
				match(T__6);
				setState(149);
				localVariableDef();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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

	public static class FunctionContext extends ParserRuleContext {
		public boolean isNative = false;
		public Token name;
		public TypeContext returnType;
		public FunctionInterfaceContext functionInterface() {
			return getRuleContext(FunctionInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
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
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(157);
				match(T__18);
				((FunctionContext)_localctx).isNative =  true; 
				}
			}

			setState(161);
			match(T__19);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(162);
				template();
				}
			}

			setState(165);
			((FunctionContext)_localctx).name = match(ID);
			setState(166);
			match(T__11);
			setState(167);
			functionInterface();
			setState(168);
			match(T__12);
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(169);
				match(T__20);
				setState(170);
				((FunctionContext)_localctx).returnType = type(0);
				}
				break;
			}
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(173);
				if (!(!_localctx.isNative)) throw new FailedPredicateException(this, "!$isNative");
				setState(174);
				match(T__13);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__21 || _la==T__22) {
					{
					setState(195);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__21:
						{
						setState(175);
						match(T__21);
						setState(176);
						match(T__13);
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==ID) {
							{
							{
							setState(177);
							localVariableDef();
							setState(178);
							match(T__3);
							}
							}
							setState(184);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(185);
						match(T__14);
						}
						break;
					case T__22:
						{
						setState(186);
						match(T__22);
						setState(187);
						match(T__13);
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (T__8 - 9)) | (1L << (T__9 - 9)) | (1L << (T__10 - 9)) | (1L << (T__11 - 9)) | (1L << (T__33 - 9)) | (1L << (T__35 - 9)) | (1L << (T__36 - 9)) | (1L << (T__51 - 9)) | (1L << (T__52 - 9)) | (1L << (T__54 - 9)) | (1L << (T__55 - 9)) | (1L << (T__56 - 9)) | (1L << (T__57 - 9)) | (1L << (T__58 - 9)) | (1L << (T__60 - 9)) | (1L << (T__61 - 9)) | (1L << (INT - 9)) | (1L << (REAL - 9)) | (1L << (STRING - 9)) | (1L << (BOOLEAN - 9)) | (1L << (ID - 9)))) != 0)) {
							{
							{
							setState(188);
							statement();
							}
							}
							setState(193);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(194);
						match(T__14);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__14);
				}
				break;
			case 2:
				{
				setState(201);
				if (!(_localctx.isNative)) throw new FailedPredicateException(this, "$isNative");
				setState(202);
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
			setState(205);
			match(ID);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(206);
				match(T__6);
				setState(207);
				match(ID);
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			match(T__20);
			setState(214);
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

	public static class FunctionInterfaceContext extends ParserRuleContext {
		public List<LocalVariableDefContext> localVariableDef() {
			return getRuleContexts(LocalVariableDefContext.class);
		}
		public LocalVariableDefContext localVariableDef(int i) {
			return getRuleContext(LocalVariableDefContext.class,i);
		}
		public FunctionInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFunctionInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFunctionInterface(this);
		}
	}

	public final FunctionInterfaceContext functionInterface() throws RecognitionException {
		FunctionInterfaceContext _localctx = new FunctionInterfaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(216);
				localVariableDef();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(217);
					match(T__6);
					setState(218);
					localVariableDef();
					}
					}
					setState(223);
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
		enterRule(_localctx, 20, RULE_portsDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(ID);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(227);
				match(T__6);
				setState(228);
				match(ID);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
			match(T__20);
			setState(235);
			((PortsDeclContext)_localctx).direction = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
				((PortsDeclContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(236);
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

	public static class EntityInterfaceContext extends ParserRuleContext {
		public List<PortsDeclContext> portsDecl() {
			return getRuleContexts(PortsDeclContext.class);
		}
		public PortsDeclContext portsDecl(int i) {
			return getRuleContext(PortsDeclContext.class,i);
		}
		public EntityInterfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityInterface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterEntityInterface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitEntityInterface(this);
		}
	}

	public final EntityInterfaceContext entityInterface() throws RecognitionException {
		EntityInterfaceContext _localctx = new EntityInterfaceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_entityInterface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(238);
				portsDecl();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(239);
					match(T__6);
					setState(240);
					portsDecl();
					}
					}
					setState(245);
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
		enterRule(_localctx, 24, RULE_variableSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__21);
			setState(249);
			match(T__13);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(250);
				localVariableDef();
				setState(251);
				match(T__3);
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
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
		enterRule(_localctx, 26, RULE_transitionSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__25);
			setState(261);
			match(T__13);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__27 - 12)) | (1L << (T__33 - 12)) | (1L << (T__35 - 12)) | (1L << (T__36 - 12)) | (1L << (T__51 - 12)) | (1L << (T__52 - 12)) | (1L << (T__54 - 12)) | (1L << (T__55 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
				{
				{
				setState(262);
				transition();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
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
		enterRule(_localctx, 28, RULE_transition);
		int _la;
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__33:
			case T__35:
			case T__36:
			case T__51:
			case T__52:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new TransitionSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				term(0);
				setState(271);
				match(T__26);
				setState(277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(272);
					match(T__13);
					setState(273);
					statements();
					setState(274);
					match(T__14);
					}
					break;
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__33:
				case T__35:
				case T__36:
				case T__51:
				case T__52:
				case T__54:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__60:
				case T__61:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(276);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__27:
				_localctx = new TransitionGroupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(T__27);
				setState(280);
				match(T__13);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__27 - 12)) | (1L << (T__33 - 12)) | (1L << (T__35 - 12)) | (1L << (T__36 - 12)) | (1L << (T__51 - 12)) | (1L << (T__52 - 12)) | (1L << (T__54 - 12)) | (1L << (T__55 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
					{
					{
					setState(281);
					transition();
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(287);
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
		public EntityInterfaceContext entityInterface() {
			return getRuleContext(EntityInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
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
		enterRule(_localctx, 30, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__28);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(291);
				template();
				}
			}

			setState(294);
			((AutomatonContext)_localctx).name = match(ID);
			setState(295);
			match(T__11);
			setState(296);
			entityInterface();
			setState(297);
			match(T__12);
			setState(298);
			match(T__13);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21 || _la==T__25) {
				{
				setState(301);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(299);
					variableSegment();
					}
					break;
				case T__25:
					{
					setState(300);
					transitionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
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
		enterRule(_localctx, 32, RULE_componentSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__29);
			setState(309);
			match(T__13);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(310);
				componentDecl();
				setState(311);
				match(T__3);
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
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
		enterRule(_localctx, 34, RULE_internalSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__30);
			setState(321);
			match(ID);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(322);
				match(T__6);
				setState(323);
				match(ID);
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
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
		enterRule(_localctx, 36, RULE_connectionSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(T__31);
			setState(332);
			match(T__13);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__52 - 12)) | (1L << (T__54 - 12)) | (1L << (T__55 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (ID - 12)))) != 0)) {
				{
				{
				setState(333);
				connectionDecl();
				setState(334);
				match(T__3);
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(341);
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
		enterRule(_localctx, 38, RULE_componentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(ID);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(344);
				match(T__6);
				setState(345);
				match(ID);
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(351);
			match(T__20);
			setState(352);
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
		public List<PortIdentifierContext> portIdentifier() {
			return getRuleContexts(PortIdentifierContext.class);
		}
		public PortIdentifierContext portIdentifier(int i) {
			return getRuleContext(PortIdentifierContext.class,i);
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
		enterRule(_localctx, 40, RULE_connectionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			type(0);
			setState(355);
			match(T__11);
			setState(356);
			portIdentifier();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(357);
				match(T__6);
				setState(358);
				portIdentifier();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364);
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
		public EntityInterfaceContext entityInterface() {
			return getRuleContext(EntityInterfaceContext.class,0);
		}
		public TerminalNode ID() { return getToken(MediatorLangParser.ID, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
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
		enterRule(_localctx, 42, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(T__32);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(367);
				template();
				}
			}

			setState(370);
			((SystemContext)_localctx).name = match(ID);
			setState(371);
			match(T__11);
			setState(372);
			entityInterface();
			setState(373);
			match(T__12);
			setState(374);
			match(T__13);
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) {
				{
				setState(378);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(375);
					componentSegment();
					}
					break;
				case T__30:
					{
					setState(376);
					internalSegment();
					}
					break;
				case T__31:
					{
					setState(377);
					connectionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(383);
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
		public TypeContext callee;
		public TermContext args;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(386);
				match(T__11);
				setState(387);
				term(0);
				setState(388);
				match(T__12);
				}
				break;
			case 2:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390);
				match(T__33);
				setState(391);
				term(0);
				setState(392);
				match(T__34);
				}
				break;
			case 3:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394);
				((SingleOprTermContext)_localctx).opr = match(T__35);
				setState(395);
				term(25);
				}
				break;
			case 4:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(396);
				((SingleOprTermContext)_localctx).opr = match(T__36);
				setState(397);
				term(24);
				}
				break;
			case 5:
				{
				_localctx = new CallTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398);
				((CallTermContext)_localctx).callee = type(0);
				setState(399);
				match(T__11);
				setState(400);
				((CallTermContext)_localctx).args = term(0);
				setState(401);
				match(T__12);
				}
				break;
			case 6:
				{
				_localctx = new ValueTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(403);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(476);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(474);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(406);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(407);
						((BinaryOprTermContext)_localctx).opr = match(T__37);
						setState(408);
						((BinaryOprTermContext)_localctx).right = term(21);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(409);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(410);
						((BinaryOprTermContext)_localctx).opr = match(T__2);
						setState(411);
						((BinaryOprTermContext)_localctx).right = term(20);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(412);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(413);
						((BinaryOprTermContext)_localctx).opr = match(T__38);
						setState(414);
						((BinaryOprTermContext)_localctx).right = term(19);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(415);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(416);
						((BinaryOprTermContext)_localctx).opr = match(T__39);
						setState(417);
						((BinaryOprTermContext)_localctx).right = term(18);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(418);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(419);
						((BinaryOprTermContext)_localctx).opr = match(T__35);
						setState(420);
						((BinaryOprTermContext)_localctx).right = term(17);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(421);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(422);
						((BinaryOprTermContext)_localctx).opr = match(T__16);
						setState(423);
						((BinaryOprTermContext)_localctx).right = term(16);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(424);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(425);
						((BinaryOprTermContext)_localctx).opr = match(T__40);
						setState(426);
						((BinaryOprTermContext)_localctx).right = term(15);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(427);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(428);
						((BinaryOprTermContext)_localctx).opr = match(T__17);
						setState(429);
						((BinaryOprTermContext)_localctx).right = term(14);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(430);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(431);
						((BinaryOprTermContext)_localctx).opr = match(T__41);
						setState(432);
						((BinaryOprTermContext)_localctx).right = term(13);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(433);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(434);
						((BinaryOprTermContext)_localctx).opr = match(T__42);
						setState(435);
						((BinaryOprTermContext)_localctx).right = term(12);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(436);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(437);
						((BinaryOprTermContext)_localctx).opr = match(T__43);
						setState(438);
						((BinaryOprTermContext)_localctx).right = term(11);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(439);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(440);
						((BinaryOprTermContext)_localctx).opr = match(T__44);
						setState(441);
						((BinaryOprTermContext)_localctx).right = term(10);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(442);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(443);
						((BinaryOprTermContext)_localctx).opr = match(T__45);
						setState(444);
						((BinaryOprTermContext)_localctx).right = term(9);
						}
						break;
					case 14:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(445);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(446);
						((BinaryOprTermContext)_localctx).opr = match(T__46);
						setState(447);
						((BinaryOprTermContext)_localctx).right = term(8);
						}
						break;
					case 15:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(448);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(449);
						((BinaryOprTermContext)_localctx).opr = match(T__47);
						setState(450);
						((BinaryOprTermContext)_localctx).right = term(7);
						}
						break;
					case 16:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(451);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(452);
						((BinaryOprTermContext)_localctx).opr = match(T__48);
						setState(453);
						((BinaryOprTermContext)_localctx).right = term(6);
						}
						break;
					case 17:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(454);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(455);
						((BinaryOprTermContext)_localctx).opr = match(T__49);
						setState(456);
						((BinaryOprTermContext)_localctx).right = term(5);
						}
						break;
					case 18:
						{
						_localctx = new IteTermContext(new TermContext(_parentctx, _parentState));
						((IteTermContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(457);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(458);
						match(T__50);
						setState(459);
						((IteTermContext)_localctx).ifTrue = term(0);
						setState(460);
						match(T__20);
						setState(461);
						((IteTermContext)_localctx).ifFalse = term(4);
						}
						break;
					case 19:
						{
						_localctx = new TupleTermContext(new TermContext(_parentctx, _parentState));
						((TupleTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(463);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(464);
						match(T__6);
						setState(465);
						((TupleTermContext)_localctx).right = term(3);
						}
						break;
					case 20:
						{
						_localctx = new ElementTermContext(new TermContext(_parentctx, _parentState));
						((ElementTermContext)_localctx).container = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(466);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(467);
						match(T__33);
						setState(468);
						((ElementTermContext)_localctx).key = term(0);
						setState(469);
						match(T__34);
						}
						break;
					case 21:
						{
						_localctx = new FieldTermContext(new TermContext(_parentctx, _parentState));
						((FieldTermContext)_localctx).structure = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(471);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(472);
						match(T__1);
						setState(473);
						((FieldTermContext)_localctx).key = match(ID);
						}
						break;
					}
					} 
				}
				setState(478);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
	public static class PortVarValueContext extends ValueContext {
		public ScopedIDContext scopedID() {
			return getRuleContext(ScopedIDContext.class,0);
		}
		public TerminalNode PORTVAR_SUFFIX() { return getToken(MediatorLangParser.PORTVAR_SUFFIX, 0); }
		public PortVarValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterPortVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitPortVarValue(this);
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
		public ScopedIDContext scopedID() {
			return getRuleContext(ScopedIDContext.class,0);
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
		enterRule(_localctx, 46, RULE_value);
		try {
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(INT);
				}
				break;
			case 2:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				match(REAL);
				}
				break;
			case 3:
				_localctx = new StrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(481);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(482);
				match(BOOLEAN);
				}
				break;
			case 5:
				_localctx = new PortVarValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(483);
				scopedID();
				setState(484);
				match(T__1);
				setState(485);
				match(PORTVAR_SUFFIX);
				}
				break;
			case 6:
				_localctx = new IdValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(487);
				scopedID();
				}
				break;
			case 7:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(488);
				match(T__51);
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
	public static class TemplateTypeContext extends TypeContext {
		public ScopedIDContext scopedID() {
			return getRuleContext(ScopedIDContext.class,0);
		}
		public List<TypeorvalueContext> typeorvalue() {
			return getRuleContexts(TypeorvalueContext.class);
		}
		public TypeorvalueContext typeorvalue(int i) {
			return getRuleContext(TypeorvalueContext.class,i);
		}
		public TemplateTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTemplateType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTemplateType(this);
		}
	}
	public static class IdTypeContext extends TypeContext {
		public ScopedIDContext scopedID() {
			return getRuleContext(ScopedIDContext.class,0);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(492);
				match(T__11);
				setState(493);
				type(0);
				setState(494);
				match(T__12);
				}
				break;
			case 2:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				match(T__52);
				}
				break;
			case 3:
				{
				_localctx = new BoundedIntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				match(T__52);
				setState(498);
				((BoundedIntTypeContext)_localctx).lbound = term(0);
				setState(499);
				match(T__53);
				setState(500);
				((BoundedIntTypeContext)_localctx).ubound = term(0);
				}
				break;
			case 4:
				{
				_localctx = new CharTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(502);
				match(T__54);
				}
				break;
			case 5:
				{
				_localctx = new DoubleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				match(T__55);
				}
				break;
			case 6:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(504);
				match(T__56);
				}
				break;
			case 7:
				{
				_localctx = new EnumTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				match(T__57);
				setState(506);
				match(T__13);
				setState(507);
				match(ID);
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(508);
					match(T__6);
					setState(509);
					match(ID);
					}
					}
					setState(514);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(515);
				match(T__14);
				}
				break;
			case 8:
				{
				_localctx = new StructTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(516);
				match(T__58);
				setState(517);
				match(T__13);
				setState(523); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(518);
					match(ID);
					setState(519);
					match(T__20);
					setState(520);
					type(0);
					setState(521);
					match(T__3);
					}
					}
					setState(525); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(527);
				match(T__14);
				}
				break;
			case 9:
				{
				_localctx = new AbstractTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(529);
				match(T__60);
				}
				break;
			case 10:
				{
				_localctx = new NullTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(530);
				match(T__61);
				}
				break;
			case 11:
				{
				_localctx = new IdTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(531);
				scopedID();
				}
				break;
			case 12:
				{
				_localctx = new TemplateTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(532);
				scopedID();
				setState(544);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(533);
					match(T__16);
					setState(534);
					typeorvalue();
					setState(539);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(535);
						match(T__6);
						setState(536);
						typeorvalue();
						}
						}
						setState(541);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(542);
					match(T__17);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(562);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(560);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new UnionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(548);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(549);
						match(T__48);
						setState(550);
						type(6);
						}
						break;
					case 2:
						{
						_localctx = new ListTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(551);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(552);
						match(T__33);
						setState(554);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (T__11 - 12)) | (1L << (T__33 - 12)) | (1L << (T__35 - 12)) | (1L << (T__36 - 12)) | (1L << (T__51 - 12)) | (1L << (T__52 - 12)) | (1L << (T__54 - 12)) | (1L << (T__55 - 12)) | (1L << (T__56 - 12)) | (1L << (T__57 - 12)) | (1L << (T__58 - 12)) | (1L << (T__60 - 12)) | (1L << (T__61 - 12)) | (1L << (INT - 12)) | (1L << (REAL - 12)) | (1L << (STRING - 12)) | (1L << (BOOLEAN - 12)) | (1L << (ID - 12)))) != 0)) {
							{
							setState(553);
							((ListTypeContext)_localctx).capacity = term(0);
							}
						}

						setState(556);
						match(T__34);
						}
						break;
					case 3:
						{
						_localctx = new InitTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(557);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(558);
						match(T__59);
						setState(559);
						term(0);
						}
						break;
					}
					} 
				}
				setState(564);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		enterRule(_localctx, 50, RULE_typeorvalue);
		try {
			setState(567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(565);
				type(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(566);
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

	public static class ScopedIDContext extends ParserRuleContext {
		public Token ID;
		public List<Token> scopes = new ArrayList<Token>();
		public Token identifier;
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public ScopedIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopedID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterScopedID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitScopedID(this);
		}
	}

	public final ScopedIDContext scopedID() throws RecognitionException {
		ScopedIDContext _localctx = new ScopedIDContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_scopedID);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(569);
					((ScopedIDContext)_localctx).ID = match(ID);
					((ScopedIDContext)_localctx).scopes.add(((ScopedIDContext)_localctx).ID);
					setState(570);
					match(T__1);
					}
					} 
				}
				setState(575);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			setState(576);
			((ScopedIDContext)_localctx).identifier = match(ID);
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
		case 22:
			return term_sempred((TermContext)_localctx, predIndex);
		case 24:
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
			return precpred(_ctx, 22);
		case 22:
			return precpred(_ctx, 21);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 5);
		case 24:
			return precpred(_ctx, 7);
		case 25:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3I\u0245\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A"+
		"\13\2\3\3\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4T\n\4\f\4\16\4W\13\4\3\4\3\4\3\5\3\5\5\5]\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\5\6d\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6m\n\6\f\6\16\6p\13\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0081"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0089\n\6\5\6\u008b\n\6\5\6\u008d\n\6"+
		"\3\7\7\7\u0090\n\7\f\7\16\7\u0093\13\7\3\b\3\b\3\b\3\b\7\b\u0099\n\b\f"+
		"\b\16\b\u009c\13\b\3\b\3\b\3\t\3\t\5\t\u00a2\n\t\3\t\3\t\5\t\u00a6\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ae\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u00b7\n\t\f\t\16\t\u00ba\13\t\3\t\3\t\3\t\3\t\7\t\u00c0\n\t\f\t\16\t"+
		"\u00c3\13\t\3\t\7\t\u00c6\n\t\f\t\16\t\u00c9\13\t\3\t\3\t\3\t\5\t\u00ce"+
		"\n\t\3\n\3\n\3\n\7\n\u00d3\n\n\f\n\16\n\u00d6\13\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\7\13\u00de\n\13\f\13\16\13\u00e1\13\13\5\13\u00e3\n\13\3\f\3"+
		"\f\3\f\7\f\u00e8\n\f\f\f\16\f\u00eb\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7"+
		"\r\u00f4\n\r\f\r\16\r\u00f7\13\r\5\r\u00f9\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0100\n\16\f\16\16\16\u0103\13\16\3\16\3\16\3\17\3\17\3\17\7\17"+
		"\u010a\n\17\f\17\16\17\u010d\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0118\n\20\3\20\3\20\3\20\7\20\u011d\n\20\f\20\16\20\u0120"+
		"\13\20\3\20\5\20\u0123\n\20\3\21\3\21\5\21\u0127\n\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\7\21\u0130\n\21\f\21\16\21\u0133\13\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\7\22\u013c\n\22\f\22\16\22\u013f\13\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\7\23\u0147\n\23\f\23\16\23\u014a\13\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\7\24\u0153\n\24\f\24\16\24\u0156\13\24\3"+
		"\24\3\24\3\25\3\25\3\25\7\25\u015d\n\25\f\25\16\25\u0160\13\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u016a\n\26\f\26\16\26\u016d\13"+
		"\26\3\26\3\26\3\27\3\27\5\27\u0173\n\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\7\27\u017d\n\27\f\27\16\27\u0180\13\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0197\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u01dd\n\30\f\30\16\30\u01e0\13\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ec\n\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u0201\n\32\f\32\16\32\u0204\13\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\6\32\u020e\n\32\r\32\16\32\u020f\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u021c\n\32\f\32\16\32\u021f\13"+
		"\32\3\32\3\32\5\32\u0223\n\32\5\32\u0225\n\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u022d\n\32\3\32\3\32\3\32\3\32\7\32\u0233\n\32\f\32\16\32\u0236"+
		"\13\32\3\33\3\33\5\33\u023a\n\33\3\34\3\34\7\34\u023e\n\34\f\34\16\34"+
		"\u0241\13\34\3\34\3\34\3\34\2\4.\62\35\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\66\2\4\4\2\5\5II\3\2\32\33\2\u028f\2?\3\2\2\2"+
		"\4B\3\2\2\2\6M\3\2\2\2\b\\\3\2\2\2\n\u008c\3\2\2\2\f\u0091\3\2\2\2\16"+
		"\u0094\3\2\2\2\20\u00a1\3\2\2\2\22\u00cf\3\2\2\2\24\u00e2\3\2\2\2\26\u00e4"+
		"\3\2\2\2\30\u00f8\3\2\2\2\32\u00fa\3\2\2\2\34\u0106\3\2\2\2\36\u0122\3"+
		"\2\2\2 \u0124\3\2\2\2\"\u0136\3\2\2\2$\u0142\3\2\2\2&\u014d\3\2\2\2(\u0159"+
		"\3\2\2\2*\u0164\3\2\2\2,\u0170\3\2\2\2.\u0196\3\2\2\2\60\u01eb\3\2\2\2"+
		"\62\u0224\3\2\2\2\64\u0239\3\2\2\2\66\u023f\3\2\2\28>\5\4\3\29>\5\6\4"+
		"\2:>\5\20\t\2;>\5 \21\2<>\5,\27\2=8\3\2\2\2=9\3\2\2\2=:\3\2\2\2=;\3\2"+
		"\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2A?\3\2\2\2BG\7"+
		"\3\2\2CD\7I\2\2DF\7\4\2\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3"+
		"\2\2\2IG\3\2\2\2JK\t\2\2\2KL\7\6\2\2L\5\3\2\2\2MN\7\7\2\2NO\5\62\32\2"+
		"OP\7\b\2\2PU\7I\2\2QR\7\t\2\2RT\7I\2\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2U"+
		"V\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\6\2\2Y\7\3\2\2\2Z[\7I\2\2[]\7\4\2\2"+
		"\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7I\2\2_\t\3\2\2\2`a\5.\30\2ab\7\n\2"+
		"\2bd\3\2\2\2c`\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5.\30\2fg\7\6\2\2g\u008d"+
		"\3\2\2\2hi\7\13\2\2in\5\b\5\2jk\7\t\2\2km\5\b\5\2lj\3\2\2\2mp\3\2\2\2"+
		"nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7\6\2\2r\u008d\3\2\2\2st\7"+
		"\f\2\2tu\5.\30\2uv\7\6\2\2v\u008d\3\2\2\2wx\7\r\2\2xy\7\16\2\2yz\5.\30"+
		"\2z\u0080\7\17\2\2{\u0081\5\n\6\2|}\7\20\2\2}~\5\f\7\2~\177\7\21\2\2\177"+
		"\u0081\3\2\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0081\u008a\3\2\2\2\u0082"+
		"\u0088\7\22\2\2\u0083\u0089\5\n\6\2\u0084\u0085\7\20\2\2\u0085\u0086\5"+
		"\f\7\2\u0086\u0087\7\21\2\2\u0087\u0089\3\2\2\2\u0088\u0083\3\2\2\2\u0088"+
		"\u0084\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008cc\3\2\2\2\u008ch\3\2\2\2\u008cs\3\2\2\2"+
		"\u008cw\3\2\2\2\u008d\13\3\2\2\2\u008e\u0090\5\n\6\2\u008f\u008e\3\2\2"+
		"\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\r"+
		"\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\23\2\2\u0095\u009a\5\22\n\2"+
		"\u0096\u0097\7\t\2\2\u0097\u0099\5\22\n\2\u0098\u0096\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7\24\2\2\u009e\17\3\2\2\2\u009f\u00a0\7\25"+
		"\2\2\u00a0\u00a2\b\t\1\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a5\7\26\2\2\u00a4\u00a6\5\16\b\2\u00a5\u00a4\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7I\2\2\u00a8"+
		"\u00a9\7\16\2\2\u00a9\u00aa\5\24\13\2\u00aa\u00ad\7\17\2\2\u00ab\u00ac"+
		"\7\27\2\2\u00ac\u00ae\5\62\32\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2"+
		"\2\u00ae\u00cd\3\2\2\2\u00af\u00b0\6\t\2\3\u00b0\u00c7\7\20\2\2\u00b1"+
		"\u00b2\7\30\2\2\u00b2\u00b8\7\20\2\2\u00b3\u00b4\5\22\n\2\u00b4\u00b5"+
		"\7\6\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00c6\7\21\2\2\u00bc\u00bd\7\31\2\2\u00bd\u00c1\7\20\2\2\u00be"+
		"\u00c0\5\n\6\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c6\7\21\2\2\u00c5\u00b1\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c6\u00c9\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00ce\7\21\2\2\u00cb\u00cc\6\t\3\3\u00cc\u00ce\7"+
		"\6\2\2\u00cd\u00af\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\21\3\2\2\2\u00cf"+
		"\u00d4\7I\2\2\u00d0\u00d1\7\t\2\2\u00d1\u00d3\7I\2\2\u00d2\u00d0\3\2\2"+
		"\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\27\2\2\u00d8\u00d9\5\62\32"+
		"\2\u00d9\23\3\2\2\2\u00da\u00df\5\22\n\2\u00db\u00dc\7\t\2\2\u00dc\u00de"+
		"\5\22\n\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\25\3\2\2\2\u00e4\u00e9\7I\2\2\u00e5"+
		"\u00e6\7\t\2\2\u00e6\u00e8\7I\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7\27\2\2\u00ed\u00ee\t\3\2\2\u00ee\u00ef\5"+
		"\62\32\2\u00ef\27\3\2\2\2\u00f0\u00f5\5\26\f\2\u00f1\u00f2\7\t\2\2\u00f2"+
		"\u00f4\5\26\f\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00f0\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\31\3\2\2\2\u00fa\u00fb\7\30\2"+
		"\2\u00fb\u0101\7\20\2\2\u00fc\u00fd\5\22\n\2\u00fd\u00fe\7\6\2\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00fc\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0105\7\21\2\2\u0105\33\3\2\2\2\u0106\u0107\7\34\2\2\u0107\u010b\7\20"+
		"\2\2\u0108\u010a\5\36\20\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010e\u010f\7\21\2\2\u010f\35\3\2\2\2\u0110\u0111\5.\30\2\u0111\u0117"+
		"\7\35\2\2\u0112\u0113\7\20\2\2\u0113\u0114\5\f\7\2\u0114\u0115\7\21\2"+
		"\2\u0115\u0118\3\2\2\2\u0116\u0118\5\n\6\2\u0117\u0112\3\2\2\2\u0117\u0116"+
		"\3\2\2\2\u0118\u0123\3\2\2\2\u0119\u011a\7\36\2\2\u011a\u011e\7\20\2\2"+
		"\u011b\u011d\5\36\20\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0123\7\21\2\2\u0122\u0110\3\2\2\2\u0122\u0119\3\2\2\2\u0123\37\3\2\2"+
		"\2\u0124\u0126\7\37\2\2\u0125\u0127\5\16\b\2\u0126\u0125\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\7I\2\2\u0129\u012a\7\16"+
		"\2\2\u012a\u012b\5\30\r\2\u012b\u012c\7\17\2\2\u012c\u0131\7\20\2\2\u012d"+
		"\u0130\5\32\16\2\u012e\u0130\5\34\17\2\u012f\u012d\3\2\2\2\u012f\u012e"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7\21\2\2\u0135!\3\2\2\2"+
		"\u0136\u0137\7 \2\2\u0137\u013d\7\20\2\2\u0138\u0139\5(\25\2\u0139\u013a"+
		"\7\6\2\2\u013a\u013c\3\2\2\2\u013b\u0138\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u0140\u0141\7\21\2\2\u0141#\3\2\2\2\u0142\u0143\7!\2\2\u0143\u0148"+
		"\7I\2\2\u0144\u0145\7\t\2\2\u0145\u0147\7I\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7\6\2\2\u014c%\3\2\2\2\u014d\u014e"+
		"\7\"\2\2\u014e\u0154\7\20\2\2\u014f\u0150\5*\26\2\u0150\u0151\7\6\2\2"+
		"\u0151\u0153\3\2\2\2\u0152\u014f\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157"+
		"\u0158\7\21\2\2\u0158\'\3\2\2\2\u0159\u015e\7I\2\2\u015a\u015b\7\t\2\2"+
		"\u015b\u015d\7I\2\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161"+
		"\u0162\7\27\2\2\u0162\u0163\5\62\32\2\u0163)\3\2\2\2\u0164\u0165\5\62"+
		"\32\2\u0165\u0166\7\16\2\2\u0166\u016b\5\b\5\2\u0167\u0168\7\t\2\2\u0168"+
		"\u016a\5\b\5\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e"+
		"\u016f\7\17\2\2\u016f+\3\2\2\2\u0170\u0172\7#\2\2\u0171\u0173\5\16\b\2"+
		"\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175"+
		"\7I\2\2\u0175\u0176\7\16\2\2\u0176\u0177\5\30\r\2\u0177\u0178\7\17\2\2"+
		"\u0178\u017e\7\20\2\2\u0179\u017d\5\"\22\2\u017a\u017d\5$\23\2\u017b\u017d"+
		"\5&\24\2\u017c\u0179\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d"+
		"\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2"+
		"\2\2\u0180\u017e\3\2\2\2\u0181\u0182\7\21\2\2\u0182-\3\2\2\2\u0183\u0184"+
		"\b\30\1\2\u0184\u0185\7\16\2\2\u0185\u0186\5.\30\2\u0186\u0187\7\17\2"+
		"\2\u0187\u0197\3\2\2\2\u0188\u0189\7$\2\2\u0189\u018a\5.\30\2\u018a\u018b"+
		"\7%\2\2\u018b\u0197\3\2\2\2\u018c\u018d\7&\2\2\u018d\u0197\5.\30\33\u018e"+
		"\u018f\7\'\2\2\u018f\u0197\5.\30\32\u0190\u0191\5\62\32\2\u0191\u0192"+
		"\7\16\2\2\u0192\u0193\5.\30\2\u0193\u0194\7\17\2\2\u0194\u0197\3\2\2\2"+
		"\u0195\u0197\5\60\31\2\u0196\u0183\3\2\2\2\u0196\u0188\3\2\2\2\u0196\u018c"+
		"\3\2\2\2\u0196\u018e\3\2\2\2\u0196\u0190\3\2\2\2\u0196\u0195\3\2\2\2\u0197"+
		"\u01de\3\2\2\2\u0198\u0199\f\26\2\2\u0199\u019a\7(\2\2\u019a\u01dd\5."+
		"\30\27\u019b\u019c\f\25\2\2\u019c\u019d\7\5\2\2\u019d\u01dd\5.\30\26\u019e"+
		"\u019f\f\24\2\2\u019f\u01a0\7)\2\2\u01a0\u01dd\5.\30\25\u01a1\u01a2\f"+
		"\23\2\2\u01a2\u01a3\7*\2\2\u01a3\u01dd\5.\30\24\u01a4\u01a5\f\22\2\2\u01a5"+
		"\u01a6\7&\2\2\u01a6\u01dd\5.\30\23\u01a7\u01a8\f\21\2\2\u01a8\u01a9\7"+
		"\23\2\2\u01a9\u01dd\5.\30\22\u01aa\u01ab\f\20\2\2\u01ab\u01ac\7+\2\2\u01ac"+
		"\u01dd\5.\30\21\u01ad\u01ae\f\17\2\2\u01ae\u01af\7\24\2\2\u01af\u01dd"+
		"\5.\30\20\u01b0\u01b1\f\16\2\2\u01b1\u01b2\7,\2\2\u01b2\u01dd\5.\30\17"+
		"\u01b3\u01b4\f\r\2\2\u01b4\u01b5\7-\2\2\u01b5\u01dd\5.\30\16\u01b6\u01b7"+
		"\f\f\2\2\u01b7\u01b8\7.\2\2\u01b8\u01dd\5.\30\r\u01b9\u01ba\f\13\2\2\u01ba"+
		"\u01bb\7/\2\2\u01bb\u01dd\5.\30\f\u01bc\u01bd\f\n\2\2\u01bd\u01be\7\60"+
		"\2\2\u01be\u01dd\5.\30\13\u01bf\u01c0\f\t\2\2\u01c0\u01c1\7\61\2\2\u01c1"+
		"\u01dd\5.\30\n\u01c2\u01c3\f\b\2\2\u01c3\u01c4\7\62\2\2\u01c4\u01dd\5"+
		".\30\t\u01c5\u01c6\f\7\2\2\u01c6\u01c7\7\63\2\2\u01c7\u01dd\5.\30\b\u01c8"+
		"\u01c9\f\6\2\2\u01c9\u01ca\7\64\2\2\u01ca\u01dd\5.\30\7\u01cb\u01cc\f"+
		"\5\2\2\u01cc\u01cd\7\65\2\2\u01cd\u01ce\5.\30\2\u01ce\u01cf\7\27\2\2\u01cf"+
		"\u01d0\5.\30\6\u01d0\u01dd\3\2\2\2\u01d1\u01d2\f\4\2\2\u01d2\u01d3\7\t"+
		"\2\2\u01d3\u01dd\5.\30\5\u01d4\u01d5\f\30\2\2\u01d5\u01d6\7$\2\2\u01d6"+
		"\u01d7\5.\30\2\u01d7\u01d8\7%\2\2\u01d8\u01dd\3\2\2\2\u01d9\u01da\f\27"+
		"\2\2\u01da\u01db\7\4\2\2\u01db\u01dd\7I\2\2\u01dc\u0198\3\2\2\2\u01dc"+
		"\u019b\3\2\2\2\u01dc\u019e\3\2\2\2\u01dc\u01a1\3\2\2\2\u01dc\u01a4\3\2"+
		"\2\2\u01dc\u01a7\3\2\2\2\u01dc\u01aa\3\2\2\2\u01dc\u01ad\3\2\2\2\u01dc"+
		"\u01b0\3\2\2\2\u01dc\u01b3\3\2\2\2\u01dc\u01b6\3\2\2\2\u01dc\u01b9\3\2"+
		"\2\2\u01dc\u01bc\3\2\2\2\u01dc\u01bf\3\2\2\2\u01dc\u01c2\3\2\2\2\u01dc"+
		"\u01c5\3\2\2\2\u01dc\u01c8\3\2\2\2\u01dc\u01cb\3\2\2\2\u01dc\u01d1\3\2"+
		"\2\2\u01dc\u01d4\3\2\2\2\u01dc\u01d9\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de"+
		"\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df/\3\2\2\2\u01e0\u01de\3\2\2\2"+
		"\u01e1\u01ec\7D\2\2\u01e2\u01ec\7E\2\2\u01e3\u01ec\7F\2\2\u01e4\u01ec"+
		"\7G\2\2\u01e5\u01e6\5\66\34\2\u01e6\u01e7\7\4\2\2\u01e7\u01e8\7H\2\2\u01e8"+
		"\u01ec\3\2\2\2\u01e9\u01ec\5\66\34\2\u01ea\u01ec\7\66\2\2\u01eb\u01e1"+
		"\3\2\2\2\u01eb\u01e2\3\2\2\2\u01eb\u01e3\3\2\2\2\u01eb\u01e4\3\2\2\2\u01eb"+
		"\u01e5\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ec\61\3\2\2"+
		"\2\u01ed\u01ee\b\32\1\2\u01ee\u01ef\7\16\2\2\u01ef\u01f0\5\62\32\2\u01f0"+
		"\u01f1\7\17\2\2\u01f1\u0225\3\2\2\2\u01f2\u0225\7\67\2\2\u01f3\u01f4\7"+
		"\67\2\2\u01f4\u01f5\5.\30\2\u01f5\u01f6\78\2\2\u01f6\u01f7\5.\30\2\u01f7"+
		"\u0225\3\2\2\2\u01f8\u0225\79\2\2\u01f9\u0225\7:\2\2\u01fa\u0225\7;\2"+
		"\2\u01fb\u01fc\7<\2\2\u01fc\u01fd\7\20\2\2\u01fd\u0202\7I\2\2\u01fe\u01ff"+
		"\7\t\2\2\u01ff\u0201\7I\2\2\u0200\u01fe\3\2\2\2\u0201\u0204\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0205\u0225\7\21\2\2\u0206\u0207\7=\2\2\u0207\u020d\7\20\2\2\u0208"+
		"\u0209\7I\2\2\u0209\u020a\7\27\2\2\u020a\u020b\5\62\32\2\u020b\u020c\7"+
		"\6\2\2\u020c\u020e\3\2\2\2\u020d\u0208\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\7\21"+
		"\2\2\u0212\u0225\3\2\2\2\u0213\u0225\7?\2\2\u0214\u0225\7@\2\2\u0215\u0225"+
		"\5\66\34\2\u0216\u0222\5\66\34\2\u0217\u0218\7\23\2\2\u0218\u021d\5\64"+
		"\33\2\u0219\u021a\7\t\2\2\u021a\u021c\5\64\33\2\u021b\u0219\3\2\2\2\u021c"+
		"\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2"+
		"\2\2\u021f\u021d\3\2\2\2\u0220\u0221\7\24\2\2\u0221\u0223\3\2\2\2\u0222"+
		"\u0217\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u01ed\3\2"+
		"\2\2\u0224\u01f2\3\2\2\2\u0224\u01f3\3\2\2\2\u0224\u01f8\3\2\2\2\u0224"+
		"\u01f9\3\2\2\2\u0224\u01fa\3\2\2\2\u0224\u01fb\3\2\2\2\u0224\u0206\3\2"+
		"\2\2\u0224\u0213\3\2\2\2\u0224\u0214\3\2\2\2\u0224\u0215\3\2\2\2\u0224"+
		"\u0216\3\2\2\2\u0225\u0234\3\2\2\2\u0226\u0227\f\7\2\2\u0227\u0228\7\63"+
		"\2\2\u0228\u0233\5\62\32\b\u0229\u022a\f\t\2\2\u022a\u022c\7$\2\2\u022b"+
		"\u022d\5.\30\2\u022c\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2"+
		"\2\2\u022e\u0233\7%\2\2\u022f\u0230\f\b\2\2\u0230\u0231\7>\2\2\u0231\u0233"+
		"\5.\30\2\u0232\u0226\3\2\2\2\u0232\u0229\3\2\2\2\u0232\u022f\3\2\2\2\u0233"+
		"\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\63\3\2\2"+
		"\2\u0236\u0234\3\2\2\2\u0237\u023a\5\62\32\2\u0238\u023a\5\60\31\2\u0239"+
		"\u0237\3\2\2\2\u0239\u0238\3\2\2\2\u023a\65\3\2\2\2\u023b\u023c\7I\2\2"+
		"\u023c\u023e\7\4\2\2\u023d\u023b\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d"+
		"\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241\u023f\3\2\2\2\u0242"+
		"\u0243\7I\2\2\u0243\67\3\2\2\2;=?GU\\cn\u0080\u0088\u008a\u008c\u0091"+
		"\u009a\u00a1\u00a5\u00ad\u00b8\u00c1\u00c5\u00c7\u00cd\u00d4\u00df\u00e2"+
		"\u00e9\u00f5\u00f8\u0101\u010b\u0117\u011e\u0122\u0126\u012f\u0131\u013d"+
		"\u0148\u0154\u015e\u016b\u0172\u017c\u017e\u0196\u01dc\u01de\u01eb\u0202"+
		"\u020f\u021d\u0222\u0224\u022c\u0232\u0234\u0239\u023f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
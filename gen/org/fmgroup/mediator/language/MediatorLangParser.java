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
		T__59=60, T__60=61, T__61=62, T__62=63, LINE_COMMENT=64, COMMENT=65, IGNORE=66, 
		INT=67, REAL=68, STRING=69, BOOLEAN=70, PORTVAR_SUFFIX=71, ID=72;
	public static final int
		RULE_prog = 0, RULE_dependency = 1, RULE_typedef = 2, RULE_portIdentifier = 3, 
		RULE_statement = 4, RULE_statements = 5, RULE_template = 6, RULE_function = 7, 
		RULE_localVariableDef = 8, RULE_functionInterface = 9, RULE_portsDecl = 10, 
		RULE_entityInterface = 11, RULE_variableSegment = 12, RULE_transitionSegment = 13, 
		RULE_transition = 14, RULE_automaton = 15, RULE_componentSegment = 16, 
		RULE_internalSegment = 17, RULE_connectionSegment = 18, RULE_componentDecl = 19, 
		RULE_connectionDecl = 20, RULE_system = 21, RULE_terms = 22, RULE_term = 23, 
		RULE_value = 24, RULE_type = 25, RULE_typeorvalue = 26, RULE_scopedID = 27;
	public static final String[] ruleNames = {
		"prog", "dependency", "typedef", "portIdentifier", "statement", "statements", 
		"template", "function", "localVariableDef", "functionInterface", "portsDecl", 
		"entityInterface", "variableSegment", "transitionSegment", "transition", 
		"automaton", "componentSegment", "internalSegment", "connectionSegment", 
		"componentDecl", "connectionDecl", "system", "terms", "term", "value", 
		"type", "typeorvalue", "scopedID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "';'", "'from'", "','", "'*'", "'typedef'", "'as'", 
		"'.'", "'='", "'sync'", "'return'", "'if'", "'('", "')'", "'{'", "'}'", 
		"'else'", "'<'", "'>'", "'native'", "'function'", "':'", "'variables'", 
		"'statements'", "'in'", "'out'", "'transitions'", "'->'", "'group'", "'automaton'", 
		"'components'", "'internalCollection'", "'connections'", "'system'", "'['", 
		"']'", "'-'", "'!'", "'%'", "'/'", "'+'", "'<='", "'>='", "'=='", "'!='", 
		"'^'", "'^^'", "'&'", "'&&'", "'|'", "'||'", "'?'", "'null'", "'int'", 
		"'..'", "'char'", "'double'", "'bool'", "'enum'", "'struct'", "'init'", 
		"'type'", "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "LINE_COMMENT", "COMMENT", "IGNORE", "INT", "REAL", 
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__19) | (1L << T__20) | (1L << T__29) | (1L << T__33))) != 0)) {
				{
				setState(61);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
					{
					setState(56);
					dependency();
					}
					break;
				case T__5:
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
				case T__29:
					{
					setState(59);
					automaton();
					}
					break;
				case T__33:
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
		public boolean importAll = false;
		public ScopedIDContext importedlib;
		public ScopedIDContext fromlib;
		public ScopedIDContext scopedID() {
			return getRuleContext(ScopedIDContext.class,0);
		}
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
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(T__0);
				setState(67);
				((DependencyContext)_localctx).importedlib = scopedID();
				setState(68);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(T__2);
				setState(71);
				((DependencyContext)_localctx).fromlib = scopedID();
				setState(72);
				match(T__0);
				setState(83);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(73);
					match(ID);
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(74);
						match(T__3);
						setState(75);
						match(ID);
						}
						}
						setState(80);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__4:
					{
					setState(81);
					match(T__4);
					((DependencyContext)_localctx).importAll =  true;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(85);
				match(T__1);
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
			setState(89);
			match(T__5);
			setState(90);
			type(0);
			setState(91);
			match(T__6);
			setState(92);
			match(ID);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(93);
				match(T__3);
				setState(94);
				match(ID);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(T__1);
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
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(102);
				((PortIdentifierContext)_localctx).owner = match(ID);
				setState(103);
				match(T__7);
				}
				break;
			}
			setState(106);
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
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__34:
			case T__36:
			case T__37:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__61:
			case T__62:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(108);
					((AssignmentStatementContext)_localctx).target = term(0);
					setState(109);
					match(T__8);
					}
					break;
				}
				setState(113);
				((AssignmentStatementContext)_localctx).expr = term(0);
				setState(114);
				match(T__1);
				}
				break;
			case T__9:
				_localctx = new SynchronizingStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__9);
				setState(117);
				portIdentifier();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(118);
					match(T__3);
					setState(119);
					portIdentifier();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				match(T__1);
				}
				break;
			case T__10:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(T__10);
				setState(128);
				term(0);
				setState(129);
				match(T__1);
				}
				break;
			case T__11:
				_localctx = new IteStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(T__11);
				setState(132);
				match(T__12);
				setState(133);
				((IteStatementContext)_localctx).condition = term(0);
				setState(134);
				match(T__13);
				setState(140);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__34:
				case T__36:
				case T__37:
				case T__52:
				case T__53:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__59:
				case T__61:
				case T__62:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(135);
					((IteStatementContext)_localctx).thenstmt = statement();
					}
					break;
				case T__14:
					{
					setState(136);
					match(T__14);
					setState(137);
					((IteStatementContext)_localctx).thenstmts = statements();
					setState(138);
					match(T__15);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(142);
					match(T__16);
					setState(148);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__9:
					case T__10:
					case T__11:
					case T__12:
					case T__34:
					case T__36:
					case T__37:
					case T__52:
					case T__53:
					case T__55:
					case T__56:
					case T__57:
					case T__58:
					case T__59:
					case T__61:
					case T__62:
					case INT:
					case REAL:
					case STRING:
					case BOOLEAN:
					case ID:
						{
						setState(143);
						((IteStatementContext)_localctx).elsestmt = statement();
						}
						break;
					case T__14:
						{
						setState(144);
						match(T__14);
						setState(145);
						((IteStatementContext)_localctx).elsestmts = statements();
						setState(146);
						match(T__15);
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
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__34 - 10)) | (1L << (T__36 - 10)) | (1L << (T__37 - 10)) | (1L << (T__52 - 10)) | (1L << (T__53 - 10)) | (1L << (T__55 - 10)) | (1L << (T__56 - 10)) | (1L << (T__57 - 10)) | (1L << (T__58 - 10)) | (1L << (T__59 - 10)) | (1L << (T__61 - 10)) | (1L << (T__62 - 10)) | (1L << (INT - 10)) | (1L << (REAL - 10)) | (1L << (STRING - 10)) | (1L << (BOOLEAN - 10)) | (1L << (ID - 10)))) != 0)) {
				{
				{
				setState(154);
				statement();
				}
				}
				setState(159);
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
			setState(160);
			match(T__17);
			setState(161);
			localVariableDef();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(162);
				match(T__3);
				setState(163);
				localVariableDef();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(T__18);
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
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(171);
				match(T__19);
				((FunctionContext)_localctx).isNative =  true; 
				}
			}

			setState(175);
			match(T__20);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(176);
				template();
				}
			}

			setState(179);
			((FunctionContext)_localctx).name = match(ID);
			setState(180);
			match(T__12);
			setState(181);
			functionInterface();
			setState(182);
			match(T__13);
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(183);
				match(T__21);
				setState(184);
				((FunctionContext)_localctx).returnType = type(0);
				}
				break;
			}
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(187);
				if (!(!_localctx.isNative)) throw new FailedPredicateException(this, "!$isNative");
				setState(188);
				match(T__14);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22 || _la==T__23) {
					{
					setState(209);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__22:
						{
						setState(189);
						match(T__22);
						setState(190);
						match(T__14);
						setState(196);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==ID) {
							{
							{
							setState(191);
							localVariableDef();
							setState(192);
							match(T__1);
							}
							}
							setState(198);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(199);
						match(T__15);
						}
						break;
					case T__23:
						{
						setState(200);
						match(T__23);
						setState(201);
						match(T__14);
						setState(205);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__34 - 10)) | (1L << (T__36 - 10)) | (1L << (T__37 - 10)) | (1L << (T__52 - 10)) | (1L << (T__53 - 10)) | (1L << (T__55 - 10)) | (1L << (T__56 - 10)) | (1L << (T__57 - 10)) | (1L << (T__58 - 10)) | (1L << (T__59 - 10)) | (1L << (T__61 - 10)) | (1L << (T__62 - 10)) | (1L << (INT - 10)) | (1L << (REAL - 10)) | (1L << (STRING - 10)) | (1L << (BOOLEAN - 10)) | (1L << (ID - 10)))) != 0)) {
							{
							{
							setState(202);
							statement();
							}
							}
							setState(207);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(208);
						match(T__15);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(T__15);
				}
				break;
			case 2:
				{
				setState(215);
				if (!(_localctx.isNative)) throw new FailedPredicateException(this, "$isNative");
				setState(216);
				match(T__1);
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
			setState(219);
			match(ID);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(220);
				match(T__3);
				setState(221);
				match(ID);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(T__21);
			setState(228);
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
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(230);
				localVariableDef();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(231);
					match(T__3);
					setState(232);
					localVariableDef();
					}
					}
					setState(237);
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
			setState(240);
			match(ID);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(241);
				match(T__3);
				setState(242);
				match(ID);
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(T__21);
			setState(249);
			((PortsDeclContext)_localctx).direction = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
				((PortsDeclContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(250);
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
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(252);
				portsDecl();
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(253);
					match(T__3);
					setState(254);
					portsDecl();
					}
					}
					setState(259);
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
			setState(262);
			match(T__22);
			setState(263);
			match(T__14);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(264);
				localVariableDef();
				setState(265);
				match(T__1);
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			match(T__15);
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
			setState(274);
			match(T__26);
			setState(275);
			match(T__14);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__12 - 13)) | (1L << (T__28 - 13)) | (1L << (T__34 - 13)) | (1L << (T__36 - 13)) | (1L << (T__37 - 13)) | (1L << (T__52 - 13)) | (1L << (T__53 - 13)) | (1L << (T__55 - 13)) | (1L << (T__56 - 13)) | (1L << (T__57 - 13)) | (1L << (T__58 - 13)) | (1L << (T__59 - 13)) | (1L << (T__61 - 13)) | (1L << (T__62 - 13)) | (1L << (INT - 13)) | (1L << (REAL - 13)) | (1L << (STRING - 13)) | (1L << (BOOLEAN - 13)) | (1L << (ID - 13)))) != 0)) {
				{
				{
				setState(276);
				transition();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(T__15);
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
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__34:
			case T__36:
			case T__37:
			case T__52:
			case T__53:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__61:
			case T__62:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new TransitionSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				term(0);
				setState(285);
				match(T__27);
				setState(291);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(286);
					match(T__14);
					setState(287);
					statements();
					setState(288);
					match(T__15);
					}
					break;
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__34:
				case T__36:
				case T__37:
				case T__52:
				case T__53:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__59:
				case T__61:
				case T__62:
				case INT:
				case REAL:
				case STRING:
				case BOOLEAN:
				case ID:
					{
					setState(290);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__28:
				_localctx = new TransitionGroupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(T__28);
				setState(294);
				match(T__14);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__12 - 13)) | (1L << (T__28 - 13)) | (1L << (T__34 - 13)) | (1L << (T__36 - 13)) | (1L << (T__37 - 13)) | (1L << (T__52 - 13)) | (1L << (T__53 - 13)) | (1L << (T__55 - 13)) | (1L << (T__56 - 13)) | (1L << (T__57 - 13)) | (1L << (T__58 - 13)) | (1L << (T__59 - 13)) | (1L << (T__61 - 13)) | (1L << (T__62 - 13)) | (1L << (INT - 13)) | (1L << (REAL - 13)) | (1L << (STRING - 13)) | (1L << (BOOLEAN - 13)) | (1L << (ID - 13)))) != 0)) {
					{
					{
					setState(295);
					transition();
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
				match(T__15);
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
			setState(304);
			match(T__29);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(305);
				template();
				}
			}

			setState(308);
			((AutomatonContext)_localctx).name = match(ID);
			setState(309);
			match(T__12);
			setState(310);
			entityInterface();
			setState(311);
			match(T__13);
			setState(312);
			match(T__14);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__26) {
				{
				setState(315);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__22:
					{
					setState(313);
					variableSegment();
					}
					break;
				case T__26:
					{
					setState(314);
					transitionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(320);
			match(T__15);
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
			setState(322);
			match(T__30);
			setState(323);
			match(T__14);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(324);
				componentDecl();
				setState(325);
				match(T__1);
				}
				}
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(332);
			match(T__15);
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
			setState(334);
			match(T__31);
			setState(335);
			match(ID);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(336);
				match(T__3);
				setState(337);
				match(ID);
				}
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(343);
			match(T__1);
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
			setState(345);
			match(T__32);
			setState(346);
			match(T__14);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__12 - 13)) | (1L << (T__53 - 13)) | (1L << (T__55 - 13)) | (1L << (T__56 - 13)) | (1L << (T__57 - 13)) | (1L << (T__58 - 13)) | (1L << (T__59 - 13)) | (1L << (T__61 - 13)) | (1L << (T__62 - 13)) | (1L << (ID - 13)))) != 0)) {
				{
				{
				setState(347);
				connectionDecl();
				setState(348);
				match(T__1);
				}
				}
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(355);
			match(T__15);
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
			setState(357);
			match(ID);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(358);
				match(T__3);
				setState(359);
				match(ID);
				}
				}
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(365);
			match(T__21);
			setState(366);
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
			setState(368);
			type(0);
			setState(369);
			match(T__12);
			setState(370);
			portIdentifier();
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(371);
				match(T__3);
				setState(372);
				portIdentifier();
				}
				}
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(378);
			match(T__13);
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
			setState(380);
			match(T__33);
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(381);
				template();
				}
			}

			setState(384);
			((SystemContext)_localctx).name = match(ID);
			setState(385);
			match(T__12);
			setState(386);
			entityInterface();
			setState(387);
			match(T__13);
			setState(388);
			match(T__14);
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) {
				{
				setState(392);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__30:
					{
					setState(389);
					componentSegment();
					}
					break;
				case T__31:
					{
					setState(390);
					internalSegment();
					}
					break;
				case T__32:
					{
					setState(391);
					connectionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
			match(T__15);
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

	public static class TermsContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTerms(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__12 - 13)) | (1L << (T__34 - 13)) | (1L << (T__36 - 13)) | (1L << (T__37 - 13)) | (1L << (T__52 - 13)) | (1L << (T__53 - 13)) | (1L << (T__55 - 13)) | (1L << (T__56 - 13)) | (1L << (T__57 - 13)) | (1L << (T__58 - 13)) | (1L << (T__59 - 13)) | (1L << (T__61 - 13)) | (1L << (T__62 - 13)) | (1L << (INT - 13)) | (1L << (REAL - 13)) | (1L << (STRING - 13)) | (1L << (BOOLEAN - 13)) | (1L << (ID - 13)))) != 0)) {
				{
				setState(399);
				term(0);
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(400);
					match(T__3);
					setState(401);
					term(0);
					}
					}
					setState(406);
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
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
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
		public TermsContext args;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(410);
				match(T__12);
				setState(411);
				term(0);
				setState(412);
				match(T__13);
				}
				break;
			case 2:
				{
				_localctx = new TupleTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				match(T__12);
				setState(415);
				term(0);
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(416);
					match(T__3);
					setState(417);
					term(0);
					}
					}
					setState(420); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(422);
				match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(424);
				match(T__34);
				setState(425);
				terms();
				setState(426);
				match(T__35);
				}
				break;
			case 4:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(428);
				((SingleOprTermContext)_localctx).opr = match(T__36);
				setState(429);
				term(24);
				}
				break;
			case 5:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(430);
				((SingleOprTermContext)_localctx).opr = match(T__37);
				setState(431);
				term(23);
				}
				break;
			case 6:
				{
				_localctx = new CallTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(432);
				((CallTermContext)_localctx).callee = type(0);
				setState(433);
				match(T__12);
				setState(434);
				((CallTermContext)_localctx).args = terms();
				setState(435);
				match(T__13);
				}
				break;
			case 7:
				{
				_localctx = new ValueTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(437);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(505);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(440);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(441);
						((BinaryOprTermContext)_localctx).opr = match(T__38);
						setState(442);
						((BinaryOprTermContext)_localctx).right = term(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(443);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(444);
						((BinaryOprTermContext)_localctx).opr = match(T__4);
						setState(445);
						((BinaryOprTermContext)_localctx).right = term(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(446);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(447);
						((BinaryOprTermContext)_localctx).opr = match(T__39);
						setState(448);
						((BinaryOprTermContext)_localctx).right = term(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(449);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(450);
						((BinaryOprTermContext)_localctx).opr = match(T__40);
						setState(451);
						((BinaryOprTermContext)_localctx).right = term(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(452);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(453);
						((BinaryOprTermContext)_localctx).opr = match(T__36);
						setState(454);
						((BinaryOprTermContext)_localctx).right = term(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(455);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(456);
						((BinaryOprTermContext)_localctx).opr = match(T__17);
						setState(457);
						((BinaryOprTermContext)_localctx).right = term(15);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(458);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(459);
						((BinaryOprTermContext)_localctx).opr = match(T__41);
						setState(460);
						((BinaryOprTermContext)_localctx).right = term(14);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(461);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(462);
						((BinaryOprTermContext)_localctx).opr = match(T__18);
						setState(463);
						((BinaryOprTermContext)_localctx).right = term(13);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(464);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(465);
						((BinaryOprTermContext)_localctx).opr = match(T__42);
						setState(466);
						((BinaryOprTermContext)_localctx).right = term(12);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(467);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(468);
						((BinaryOprTermContext)_localctx).opr = match(T__43);
						setState(469);
						((BinaryOprTermContext)_localctx).right = term(11);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(470);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(471);
						((BinaryOprTermContext)_localctx).opr = match(T__44);
						setState(472);
						((BinaryOprTermContext)_localctx).right = term(10);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(473);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(474);
						((BinaryOprTermContext)_localctx).opr = match(T__45);
						setState(475);
						((BinaryOprTermContext)_localctx).right = term(9);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(476);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(477);
						((BinaryOprTermContext)_localctx).opr = match(T__46);
						setState(478);
						((BinaryOprTermContext)_localctx).right = term(8);
						}
						break;
					case 14:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(479);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(480);
						((BinaryOprTermContext)_localctx).opr = match(T__47);
						setState(481);
						((BinaryOprTermContext)_localctx).right = term(7);
						}
						break;
					case 15:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(482);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(483);
						((BinaryOprTermContext)_localctx).opr = match(T__48);
						setState(484);
						((BinaryOprTermContext)_localctx).right = term(6);
						}
						break;
					case 16:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(485);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(486);
						((BinaryOprTermContext)_localctx).opr = match(T__49);
						setState(487);
						((BinaryOprTermContext)_localctx).right = term(5);
						}
						break;
					case 17:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(488);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(489);
						((BinaryOprTermContext)_localctx).opr = match(T__50);
						setState(490);
						((BinaryOprTermContext)_localctx).right = term(4);
						}
						break;
					case 18:
						{
						_localctx = new IteTermContext(new TermContext(_parentctx, _parentState));
						((IteTermContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(491);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(492);
						match(T__51);
						setState(493);
						((IteTermContext)_localctx).ifTrue = term(0);
						setState(494);
						match(T__21);
						setState(495);
						((IteTermContext)_localctx).ifFalse = term(3);
						}
						break;
					case 19:
						{
						_localctx = new ElementTermContext(new TermContext(_parentctx, _parentState));
						((ElementTermContext)_localctx).container = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(497);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(498);
						match(T__34);
						setState(499);
						((ElementTermContext)_localctx).key = term(0);
						setState(500);
						match(T__35);
						}
						break;
					case 20:
						{
						_localctx = new FieldTermContext(new TermContext(_parentctx, _parentState));
						((FieldTermContext)_localctx).structure = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(502);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(503);
						match(T__7);
						setState(504);
						((FieldTermContext)_localctx).key = match(ID);
						}
						break;
					}
					} 
				}
				setState(509);
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
		enterRule(_localctx, 48, RULE_value);
		try {
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				match(INT);
				}
				break;
			case 2:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(REAL);
				}
				break;
			case 3:
				_localctx = new StrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(512);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(513);
				match(BOOLEAN);
				}
				break;
			case 5:
				_localctx = new PortVarValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(514);
				scopedID();
				setState(515);
				match(T__7);
				setState(516);
				match(PORTVAR_SUFFIX);
				}
				break;
			case 6:
				_localctx = new IdValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(518);
				scopedID();
				}
				break;
			case 7:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(519);
				match(T__52);
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
	public static class TupleTypeContext extends TypeContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TupleTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterTupleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitTupleType(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(523);
				match(T__12);
				setState(524);
				type(0);
				setState(525);
				match(T__13);
				}
				break;
			case 2:
				{
				_localctx = new TupleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(527);
				match(T__12);
				setState(528);
				type(0);
				setState(531); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(529);
					match(T__3);
					setState(530);
					type(0);
					}
					}
					setState(533); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(535);
				match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(537);
				match(T__53);
				}
				break;
			case 4:
				{
				_localctx = new BoundedIntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(538);
				match(T__53);
				setState(539);
				((BoundedIntTypeContext)_localctx).lbound = term(0);
				setState(540);
				match(T__54);
				setState(541);
				((BoundedIntTypeContext)_localctx).ubound = term(0);
				}
				break;
			case 5:
				{
				_localctx = new CharTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(543);
				match(T__55);
				}
				break;
			case 6:
				{
				_localctx = new DoubleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(544);
				match(T__56);
				}
				break;
			case 7:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(545);
				match(T__57);
				}
				break;
			case 8:
				{
				_localctx = new EnumTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(546);
				match(T__58);
				setState(547);
				match(T__14);
				setState(548);
				match(ID);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(549);
					match(T__3);
					setState(550);
					match(ID);
					}
					}
					setState(555);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(556);
				match(T__15);
				}
				break;
			case 9:
				{
				_localctx = new StructTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(557);
				match(T__59);
				setState(558);
				match(T__14);
				setState(564); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(559);
					match(ID);
					setState(560);
					match(T__21);
					setState(561);
					type(0);
					setState(562);
					match(T__1);
					}
					}
					setState(566); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(568);
				match(T__15);
				}
				break;
			case 10:
				{
				_localctx = new AbstractTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(570);
				match(T__61);
				}
				break;
			case 11:
				{
				_localctx = new NullTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(571);
				match(T__62);
				}
				break;
			case 12:
				{
				_localctx = new IdTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(572);
				scopedID();
				}
				break;
			case 13:
				{
				_localctx = new TemplateTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(573);
				scopedID();
				setState(585);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(574);
					match(T__17);
					setState(575);
					typeorvalue();
					setState(580);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(576);
						match(T__3);
						setState(577);
						typeorvalue();
						}
						}
						setState(582);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(583);
					match(T__18);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(603);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(601);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
					case 1:
						{
						_localctx = new UnionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(589);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(590);
						match(T__49);
						setState(591);
						type(6);
						}
						break;
					case 2:
						{
						_localctx = new ListTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(592);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(593);
						match(T__34);
						setState(595);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__12 - 13)) | (1L << (T__34 - 13)) | (1L << (T__36 - 13)) | (1L << (T__37 - 13)) | (1L << (T__52 - 13)) | (1L << (T__53 - 13)) | (1L << (T__55 - 13)) | (1L << (T__56 - 13)) | (1L << (T__57 - 13)) | (1L << (T__58 - 13)) | (1L << (T__59 - 13)) | (1L << (T__61 - 13)) | (1L << (T__62 - 13)) | (1L << (INT - 13)) | (1L << (REAL - 13)) | (1L << (STRING - 13)) | (1L << (BOOLEAN - 13)) | (1L << (ID - 13)))) != 0)) {
							{
							setState(594);
							((ListTypeContext)_localctx).capacity = term(0);
							}
						}

						setState(597);
						match(T__35);
						}
						break;
					case 3:
						{
						_localctx = new InitTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(598);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(599);
						match(T__60);
						setState(600);
						term(0);
						}
						break;
					}
					} 
				}
				setState(605);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
			setState(608);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(606);
				type(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
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
		enterRule(_localctx, 54, RULE_scopedID);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(610);
					((ScopedIDContext)_localctx).ID = match(ID);
					((ScopedIDContext)_localctx).scopes.add(((ScopedIDContext)_localctx).ID);
					setState(611);
					match(T__7);
					}
					} 
				}
				setState(616);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(617);
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
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		case 8:
			return precpred(_ctx, 13);
		case 9:
			return precpred(_ctx, 12);
		case 10:
			return precpred(_ctx, 11);
		case 11:
			return precpred(_ctx, 10);
		case 12:
			return precpred(_ctx, 9);
		case 13:
			return precpred(_ctx, 8);
		case 14:
			return precpred(_ctx, 7);
		case 15:
			return precpred(_ctx, 6);
		case 16:
			return precpred(_ctx, 5);
		case 17:
			return precpred(_ctx, 4);
		case 18:
			return precpred(_ctx, 3);
		case 19:
			return precpred(_ctx, 2);
		case 20:
			return precpred(_ctx, 21);
		case 21:
			return precpred(_ctx, 20);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 5);
		case 23:
			return precpred(_ctx, 7);
		case 24:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3J\u026e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3O\n\3\f\3\16"+
		"\3R\13\3\3\3\3\3\5\3V\n\3\3\3\3\3\5\3Z\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"b\n\4\f\4\16\4e\13\4\3\4\3\4\3\5\3\5\5\5k\n\5\3\5\3\5\3\6\3\6\3\6\5\6"+
		"r\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6{\n\6\f\6\16\6~\13\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008f\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u0097\n\6\5\6\u0099\n\6\5\6\u009b\n\6\3\7\7\7\u009e"+
		"\n\7\f\7\16\7\u00a1\13\7\3\b\3\b\3\b\3\b\7\b\u00a7\n\b\f\b\16\b\u00aa"+
		"\13\b\3\b\3\b\3\t\3\t\5\t\u00b0\n\t\3\t\3\t\5\t\u00b4\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00bc\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c5\n\t\f"+
		"\t\16\t\u00c8\13\t\3\t\3\t\3\t\3\t\7\t\u00ce\n\t\f\t\16\t\u00d1\13\t\3"+
		"\t\7\t\u00d4\n\t\f\t\16\t\u00d7\13\t\3\t\3\t\3\t\5\t\u00dc\n\t\3\n\3\n"+
		"\3\n\7\n\u00e1\n\n\f\n\16\n\u00e4\13\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13"+
		"\u00ec\n\13\f\13\16\13\u00ef\13\13\5\13\u00f1\n\13\3\f\3\f\3\f\7\f\u00f6"+
		"\n\f\f\f\16\f\u00f9\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u0102\n\r\f\r"+
		"\16\r\u0105\13\r\5\r\u0107\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u010e\n\16"+
		"\f\16\16\16\u0111\13\16\3\16\3\16\3\17\3\17\3\17\7\17\u0118\n\17\f\17"+
		"\16\17\u011b\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0126"+
		"\n\20\3\20\3\20\3\20\7\20\u012b\n\20\f\20\16\20\u012e\13\20\3\20\5\20"+
		"\u0131\n\20\3\21\3\21\5\21\u0135\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\7\21\u013e\n\21\f\21\16\21\u0141\13\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\7\22\u014a\n\22\f\22\16\22\u014d\13\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\7\23\u0155\n\23\f\23\16\23\u0158\13\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\7\24\u0161\n\24\f\24\16\24\u0164\13\24\3\24\3\24\3\25\3"+
		"\25\3\25\7\25\u016b\n\25\f\25\16\25\u016e\13\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\7\26\u0178\n\26\f\26\16\26\u017b\13\26\3\26\3\26\3"+
		"\27\3\27\5\27\u0181\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u018b\n\27\f\27\16\27\u018e\13\27\3\27\3\27\3\30\3\30\3\30\7\30\u0195"+
		"\n\30\f\30\16\30\u0198\13\30\5\30\u019a\n\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\6\31\u01a5\n\31\r\31\16\31\u01a6\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01b9"+
		"\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u01fc\n\31\f\31"+
		"\16\31\u01ff\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u020b\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\6\33\u0216"+
		"\n\33\r\33\16\33\u0217\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u022a\n\33\f\33\16\33\u022d\13"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\6\33\u0237\n\33\r\33\16\33"+
		"\u0238\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0245\n"+
		"\33\f\33\16\33\u0248\13\33\3\33\3\33\5\33\u024c\n\33\5\33\u024e\n\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\5\33\u0256\n\33\3\33\3\33\3\33\3\33\7\33"+
		"\u025c\n\33\f\33\16\33\u025f\13\33\3\34\3\34\5\34\u0263\n\34\3\35\3\35"+
		"\7\35\u0267\n\35\f\35\16\35\u026a\13\35\3\35\3\35\3\35\2\4\60\64\36\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\3\3\2\33"+
		"\34\2\u02be\2A\3\2\2\2\4Y\3\2\2\2\6[\3\2\2\2\bj\3\2\2\2\n\u009a\3\2\2"+
		"\2\f\u009f\3\2\2\2\16\u00a2\3\2\2\2\20\u00af\3\2\2\2\22\u00dd\3\2\2\2"+
		"\24\u00f0\3\2\2\2\26\u00f2\3\2\2\2\30\u0106\3\2\2\2\32\u0108\3\2\2\2\34"+
		"\u0114\3\2\2\2\36\u0130\3\2\2\2 \u0132\3\2\2\2\"\u0144\3\2\2\2$\u0150"+
		"\3\2\2\2&\u015b\3\2\2\2(\u0167\3\2\2\2*\u0172\3\2\2\2,\u017e\3\2\2\2."+
		"\u0199\3\2\2\2\60\u01b8\3\2\2\2\62\u020a\3\2\2\2\64\u024d\3\2\2\2\66\u0262"+
		"\3\2\2\28\u0268\3\2\2\2:@\5\4\3\2;@\5\6\4\2<@\5\20\t\2=@\5 \21\2>@\5,"+
		"\27\2?:\3\2\2\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3"+
		"\2\2\2AB\3\2\2\2B\3\3\2\2\2CA\3\2\2\2DE\7\3\2\2EF\58\35\2FG\7\4\2\2GZ"+
		"\3\2\2\2HI\7\5\2\2IJ\58\35\2JU\7\3\2\2KP\7J\2\2LM\7\6\2\2MO\7J\2\2NL\3"+
		"\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RP\3\2\2\2ST\7\7\2\2TV\b"+
		"\3\1\2UK\3\2\2\2US\3\2\2\2VW\3\2\2\2WX\7\4\2\2XZ\3\2\2\2YD\3\2\2\2YH\3"+
		"\2\2\2Z\5\3\2\2\2[\\\7\b\2\2\\]\5\64\33\2]^\7\t\2\2^c\7J\2\2_`\7\6\2\2"+
		"`b\7J\2\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2"+
		"fg\7\4\2\2g\7\3\2\2\2hi\7J\2\2ik\7\n\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2"+
		"lm\7J\2\2m\t\3\2\2\2no\5\60\31\2op\7\13\2\2pr\3\2\2\2qn\3\2\2\2qr\3\2"+
		"\2\2rs\3\2\2\2st\5\60\31\2tu\7\4\2\2u\u009b\3\2\2\2vw\7\f\2\2w|\5\b\5"+
		"\2xy\7\6\2\2y{\5\b\5\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3"+
		"\2\2\2~|\3\2\2\2\177\u0080\7\4\2\2\u0080\u009b\3\2\2\2\u0081\u0082\7\r"+
		"\2\2\u0082\u0083\5\60\31\2\u0083\u0084\7\4\2\2\u0084\u009b\3\2\2\2\u0085"+
		"\u0086\7\16\2\2\u0086\u0087\7\17\2\2\u0087\u0088\5\60\31\2\u0088\u008e"+
		"\7\20\2\2\u0089\u008f\5\n\6\2\u008a\u008b\7\21\2\2\u008b\u008c\5\f\7\2"+
		"\u008c\u008d\7\22\2\2\u008d\u008f\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008a"+
		"\3\2\2\2\u008f\u0098\3\2\2\2\u0090\u0096\7\23\2\2\u0091\u0097\5\n\6\2"+
		"\u0092\u0093\7\21\2\2\u0093\u0094\5\f\7\2\u0094\u0095\7\22\2\2\u0095\u0097"+
		"\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0090\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009aq\3\2\2\2"+
		"\u009av\3\2\2\2\u009a\u0081\3\2\2\2\u009a\u0085\3\2\2\2\u009b\13\3\2\2"+
		"\2\u009c\u009e\5\n\6\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\r\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a3\7\24\2\2\u00a3\u00a8\5\22\n\2\u00a4\u00a5\7\6\2\2\u00a5\u00a7\5"+
		"\22\n\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7\25"+
		"\2\2\u00ac\17\3\2\2\2\u00ad\u00ae\7\26\2\2\u00ae\u00b0\b\t\1\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\7\27\2\2"+
		"\u00b2\u00b4\5\16\b\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b6\7J\2\2\u00b6\u00b7\7\17\2\2\u00b7\u00b8\5\24\13\2"+
		"\u00b8\u00bb\7\20\2\2\u00b9\u00ba\7\30\2\2\u00ba\u00bc\5\64\33\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00db\3\2\2\2\u00bd\u00be\6\t"+
		"\2\3\u00be\u00d5\7\21\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c6\7\21\2\2\u00c1"+
		"\u00c2\5\22\n\2\u00c2\u00c3\7\4\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c1\3"+
		"\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00d4\7\22\2\2\u00ca\u00cb\7"+
		"\32\2\2\u00cb\u00cf\7\21\2\2\u00cc\u00ce\5\n\6\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\7\22\2\2\u00d3\u00bf\3\2\2\2\u00d3"+
		"\u00ca\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00dc\7\22\2\2\u00d9"+
		"\u00da\6\t\3\3\u00da\u00dc\7\4\2\2\u00db\u00bd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\21\3\2\2\2\u00dd\u00e2\7J\2\2\u00de\u00df\7\6\2\2\u00df\u00e1"+
		"\7J\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7\30"+
		"\2\2\u00e6\u00e7\5\64\33\2\u00e7\23\3\2\2\2\u00e8\u00ed\5\22\n\2\u00e9"+
		"\u00ea\7\6\2\2\u00ea\u00ec\5\22\n\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3"+
		"\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\25\3\2\2"+
		"\2\u00f2\u00f7\7J\2\2\u00f3\u00f4\7\6\2\2\u00f4\u00f6\7J\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7\30\2\2\u00fb\u00fc\t"+
		"\2\2\2\u00fc\u00fd\5\64\33\2\u00fd\27\3\2\2\2\u00fe\u0103\5\26\f\2\u00ff"+
		"\u0100\7\6\2\2\u0100\u0102\5\26\f\2\u0101\u00ff\3\2\2\2\u0102\u0105\3"+
		"\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0106\u00fe\3\2\2\2\u0106\u0107\3\2\2\2\u0107\31\3\2\2"+
		"\2\u0108\u0109\7\31\2\2\u0109\u010f\7\21\2\2\u010a\u010b\5\22\n\2\u010b"+
		"\u010c\7\4\2\2\u010c\u010e\3\2\2\2\u010d\u010a\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\7\22\2\2\u0113\33\3\2\2\2\u0114\u0115\7\35"+
		"\2\2\u0115\u0119\7\21\2\2\u0116\u0118\5\36\20\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\22\2\2\u011d\35\3\2\2\2\u011e\u011f"+
		"\5\60\31\2\u011f\u0125\7\36\2\2\u0120\u0121\7\21\2\2\u0121\u0122\5\f\7"+
		"\2\u0122\u0123\7\22\2\2\u0123\u0126\3\2\2\2\u0124\u0126\5\n\6\2\u0125"+
		"\u0120\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0131\3\2\2\2\u0127\u0128\7\37"+
		"\2\2\u0128\u012c\7\21\2\2\u0129\u012b\5\36\20\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012f\u0131\7\22\2\2\u0130\u011e\3\2\2\2\u0130"+
		"\u0127\3\2\2\2\u0131\37\3\2\2\2\u0132\u0134\7 \2\2\u0133\u0135\5\16\b"+
		"\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\7J\2\2\u0137\u0138\7\17\2\2\u0138\u0139\5\30\r\2\u0139\u013a\7\20\2\2"+
		"\u013a\u013f\7\21\2\2\u013b\u013e\5\32\16\2\u013c\u013e\5\34\17\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142"+
		"\u0143\7\22\2\2\u0143!\3\2\2\2\u0144\u0145\7!\2\2\u0145\u014b\7\21\2\2"+
		"\u0146\u0147\5(\25\2\u0147\u0148\7\4\2\2\u0148\u014a\3\2\2\2\u0149\u0146"+
		"\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7\22\2\2\u014f#\3\2\2\2"+
		"\u0150\u0151\7\"\2\2\u0151\u0156\7J\2\2\u0152\u0153\7\6\2\2\u0153\u0155"+
		"\7J\2\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7\4"+
		"\2\2\u015a%\3\2\2\2\u015b\u015c\7#\2\2\u015c\u0162\7\21\2\2\u015d\u015e"+
		"\5*\26\2\u015e\u015f\7\4\2\2\u015f\u0161\3\2\2\2\u0160\u015d\3\2\2\2\u0161"+
		"\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2"+
		"\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7\22\2\2\u0166\'\3\2\2\2\u0167\u016c"+
		"\7J\2\2\u0168\u0169\7\6\2\2\u0169\u016b\7J\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\30\2\2\u0170\u0171\5\64\33\2\u0171"+
		")\3\2\2\2\u0172\u0173\5\64\33\2\u0173\u0174\7\17\2\2\u0174\u0179\5\b\5"+
		"\2\u0175\u0176\7\6\2\2\u0176\u0178\5\b\5\2\u0177\u0175\3\2\2\2\u0178\u017b"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b"+
		"\u0179\3\2\2\2\u017c\u017d\7\20\2\2\u017d+\3\2\2\2\u017e\u0180\7$\2\2"+
		"\u017f\u0181\5\16\b\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182"+
		"\3\2\2\2\u0182\u0183\7J\2\2\u0183\u0184\7\17\2\2\u0184\u0185\5\30\r\2"+
		"\u0185\u0186\7\20\2\2\u0186\u018c\7\21\2\2\u0187\u018b\5\"\22\2\u0188"+
		"\u018b\5$\23\2\u0189\u018b\5&\24\2\u018a\u0187\3\2\2\2\u018a\u0188\3\2"+
		"\2\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7\22"+
		"\2\2\u0190-\3\2\2\2\u0191\u0196\5\60\31\2\u0192\u0193\7\6\2\2\u0193\u0195"+
		"\5\60\31\2\u0194\u0192\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2"+
		"\u0196\u0197\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u0191"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a/\3\2\2\2\u019b\u019c\b\31\1\2\u019c"+
		"\u019d\7\17\2\2\u019d\u019e\5\60\31\2\u019e\u019f\7\20\2\2\u019f\u01b9"+
		"\3\2\2\2\u01a0\u01a1\7\17\2\2\u01a1\u01a4\5\60\31\2\u01a2\u01a3\7\6\2"+
		"\2\u01a3\u01a5\5\60\31\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\7\20"+
		"\2\2\u01a9\u01b9\3\2\2\2\u01aa\u01ab\7%\2\2\u01ab\u01ac\5.\30\2\u01ac"+
		"\u01ad\7&\2\2\u01ad\u01b9\3\2\2\2\u01ae\u01af\7\'\2\2\u01af\u01b9\5\60"+
		"\31\32\u01b0\u01b1\7(\2\2\u01b1\u01b9\5\60\31\31\u01b2\u01b3\5\64\33\2"+
		"\u01b3\u01b4\7\17\2\2\u01b4\u01b5\5.\30\2\u01b5\u01b6\7\20\2\2\u01b6\u01b9"+
		"\3\2\2\2\u01b7\u01b9\5\62\32\2\u01b8\u019b\3\2\2\2\u01b8\u01a0\3\2\2\2"+
		"\u01b8\u01aa\3\2\2\2\u01b8\u01ae\3\2\2\2\u01b8\u01b0\3\2\2\2\u01b8\u01b2"+
		"\3\2\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01fd\3\2\2\2\u01ba\u01bb\f\25\2\2"+
		"\u01bb\u01bc\7)\2\2\u01bc\u01fc\5\60\31\26\u01bd\u01be\f\24\2\2\u01be"+
		"\u01bf\7\7\2\2\u01bf\u01fc\5\60\31\25\u01c0\u01c1\f\23\2\2\u01c1\u01c2"+
		"\7*\2\2\u01c2\u01fc\5\60\31\24\u01c3\u01c4\f\22\2\2\u01c4\u01c5\7+\2\2"+
		"\u01c5\u01fc\5\60\31\23\u01c6\u01c7\f\21\2\2\u01c7\u01c8\7\'\2\2\u01c8"+
		"\u01fc\5\60\31\22\u01c9\u01ca\f\20\2\2\u01ca\u01cb\7\24\2\2\u01cb\u01fc"+
		"\5\60\31\21\u01cc\u01cd\f\17\2\2\u01cd\u01ce\7,\2\2\u01ce\u01fc\5\60\31"+
		"\20\u01cf\u01d0\f\16\2\2\u01d0\u01d1\7\25\2\2\u01d1\u01fc\5\60\31\17\u01d2"+
		"\u01d3\f\r\2\2\u01d3\u01d4\7-\2\2\u01d4\u01fc\5\60\31\16\u01d5\u01d6\f"+
		"\f\2\2\u01d6\u01d7\7.\2\2\u01d7\u01fc\5\60\31\r\u01d8\u01d9\f\13\2\2\u01d9"+
		"\u01da\7/\2\2\u01da\u01fc\5\60\31\f\u01db\u01dc\f\n\2\2\u01dc\u01dd\7"+
		"\60\2\2\u01dd\u01fc\5\60\31\13\u01de\u01df\f\t\2\2\u01df\u01e0\7\61\2"+
		"\2\u01e0\u01fc\5\60\31\n\u01e1\u01e2\f\b\2\2\u01e2\u01e3\7\62\2\2\u01e3"+
		"\u01fc\5\60\31\t\u01e4\u01e5\f\7\2\2\u01e5\u01e6\7\63\2\2\u01e6\u01fc"+
		"\5\60\31\b\u01e7\u01e8\f\6\2\2\u01e8\u01e9\7\64\2\2\u01e9\u01fc\5\60\31"+
		"\7\u01ea\u01eb\f\5\2\2\u01eb\u01ec\7\65\2\2\u01ec\u01fc\5\60\31\6\u01ed"+
		"\u01ee\f\4\2\2\u01ee\u01ef\7\66\2\2\u01ef\u01f0\5\60\31\2\u01f0\u01f1"+
		"\7\30\2\2\u01f1\u01f2\5\60\31\5\u01f2\u01fc\3\2\2\2\u01f3\u01f4\f\27\2"+
		"\2\u01f4\u01f5\7%\2\2\u01f5\u01f6\5\60\31\2\u01f6\u01f7\7&\2\2\u01f7\u01fc"+
		"\3\2\2\2\u01f8\u01f9\f\26\2\2\u01f9\u01fa\7\n\2\2\u01fa\u01fc\7J\2\2\u01fb"+
		"\u01ba\3\2\2\2\u01fb\u01bd\3\2\2\2\u01fb\u01c0\3\2\2\2\u01fb\u01c3\3\2"+
		"\2\2\u01fb\u01c6\3\2\2\2\u01fb\u01c9\3\2\2\2\u01fb\u01cc\3\2\2\2\u01fb"+
		"\u01cf\3\2\2\2\u01fb\u01d2\3\2\2\2\u01fb\u01d5\3\2\2\2\u01fb\u01d8\3\2"+
		"\2\2\u01fb\u01db\3\2\2\2\u01fb\u01de\3\2\2\2\u01fb\u01e1\3\2\2\2\u01fb"+
		"\u01e4\3\2\2\2\u01fb\u01e7\3\2\2\2\u01fb\u01ea\3\2\2\2\u01fb\u01ed\3\2"+
		"\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\61\3\2\2\2\u01ff\u01fd\3\2\2"+
		"\2\u0200\u020b\7E\2\2\u0201\u020b\7F\2\2\u0202\u020b\7G\2\2\u0203\u020b"+
		"\7H\2\2\u0204\u0205\58\35\2\u0205\u0206\7\n\2\2\u0206\u0207\7I\2\2\u0207"+
		"\u020b\3\2\2\2\u0208\u020b\58\35\2\u0209\u020b\7\67\2\2\u020a\u0200\3"+
		"\2\2\2\u020a\u0201\3\2\2\2\u020a\u0202\3\2\2\2\u020a\u0203\3\2\2\2\u020a"+
		"\u0204\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2\2\2\u020b\63\3\2\2"+
		"\2\u020c\u020d\b\33\1\2\u020d\u020e\7\17\2\2\u020e\u020f\5\64\33\2\u020f"+
		"\u0210\7\20\2\2\u0210\u024e\3\2\2\2\u0211\u0212\7\17\2\2\u0212\u0215\5"+
		"\64\33\2\u0213\u0214\7\6\2\2\u0214\u0216\5\64\33\2\u0215\u0213\3\2\2\2"+
		"\u0216\u0217\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219"+
		"\3\2\2\2\u0219\u021a\7\20\2\2\u021a\u024e\3\2\2\2\u021b\u024e\78\2\2\u021c"+
		"\u021d\78\2\2\u021d\u021e\5\60\31\2\u021e\u021f\79\2\2\u021f\u0220\5\60"+
		"\31\2\u0220\u024e\3\2\2\2\u0221\u024e\7:\2\2\u0222\u024e\7;\2\2\u0223"+
		"\u024e\7<\2\2\u0224\u0225\7=\2\2\u0225\u0226\7\21\2\2\u0226\u022b\7J\2"+
		"\2\u0227\u0228\7\6\2\2\u0228\u022a\7J\2\2\u0229\u0227\3\2\2\2\u022a\u022d"+
		"\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022e\3\2\2\2\u022d"+
		"\u022b\3\2\2\2\u022e\u024e\7\22\2\2\u022f\u0230\7>\2\2\u0230\u0236\7\21"+
		"\2\2\u0231\u0232\7J\2\2\u0232\u0233\7\30\2\2\u0233\u0234\5\64\33\2\u0234"+
		"\u0235\7\4\2\2\u0235\u0237\3\2\2\2\u0236\u0231\3\2\2\2\u0237\u0238\3\2"+
		"\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023b\7\22\2\2\u023b\u024e\3\2\2\2\u023c\u024e\7@\2\2\u023d\u024e\7A"+
		"\2\2\u023e\u024e\58\35\2\u023f\u024b\58\35\2\u0240\u0241\7\24\2\2\u0241"+
		"\u0246\5\66\34\2\u0242\u0243\7\6\2\2\u0243\u0245\5\66\34\2\u0244\u0242"+
		"\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247"+
		"\u0249\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u024a\7\25\2\2\u024a\u024c\3"+
		"\2\2\2\u024b\u0240\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024e\3\2\2\2\u024d"+
		"\u020c\3\2\2\2\u024d\u0211\3\2\2\2\u024d\u021b\3\2\2\2\u024d\u021c\3\2"+
		"\2\2\u024d\u0221\3\2\2\2\u024d\u0222\3\2\2\2\u024d\u0223\3\2\2\2\u024d"+
		"\u0224\3\2\2\2\u024d\u022f\3\2\2\2\u024d\u023c\3\2\2\2\u024d\u023d\3\2"+
		"\2\2\u024d\u023e\3\2\2\2\u024d\u023f\3\2\2\2\u024e\u025d\3\2\2\2\u024f"+
		"\u0250\f\7\2\2\u0250\u0251\7\64\2\2\u0251\u025c\5\64\33\b\u0252\u0253"+
		"\f\t\2\2\u0253\u0255\7%\2\2\u0254\u0256\5\60\31\2\u0255\u0254\3\2\2\2"+
		"\u0255\u0256\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u025c\7&\2\2\u0258\u0259"+
		"\f\b\2\2\u0259\u025a\7?\2\2\u025a\u025c\5\60\31\2\u025b\u024f\3\2\2\2"+
		"\u025b\u0252\3\2\2\2\u025b\u0258\3\2\2\2\u025c\u025f\3\2\2\2\u025d\u025b"+
		"\3\2\2\2\u025d\u025e\3\2\2\2\u025e\65\3\2\2\2\u025f\u025d\3\2\2\2\u0260"+
		"\u0263\5\64\33\2\u0261\u0263\5\62\32\2\u0262\u0260\3\2\2\2\u0262\u0261"+
		"\3\2\2\2\u0263\67\3\2\2\2\u0264\u0265\7J\2\2\u0265\u0267\7\n\2\2\u0266"+
		"\u0264\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2"+
		"\2\2\u0269\u026b\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u026c\7J\2\2\u026c"+
		"9\3\2\2\2A?APUYcjq|\u008e\u0096\u0098\u009a\u009f\u00a8\u00af\u00b3\u00bb"+
		"\u00c6\u00cf\u00d3\u00d5\u00db\u00e2\u00ed\u00f0\u00f7\u0103\u0106\u010f"+
		"\u0119\u0125\u012c\u0130\u0134\u013d\u013f\u014b\u0156\u0162\u016c\u0179"+
		"\u0180\u018a\u018c\u0196\u0199\u01a6\u01b8\u01fb\u01fd\u020a\u0217\u022b"+
		"\u0238\u0246\u024b\u024d\u0255\u025b\u025d\u0262\u0268";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
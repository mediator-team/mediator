// Generated from /Users/liyi/Dropbox/Projects/Mediator/src-antlr/MediatorLang.g4 by ANTLR 4.7
package org.fmgroup.mediator.language.generated;
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
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, LINE_COMMENT=75, COMMENT=76, IGNORE=77, INT=78, REAL=79, STRING=80, 
		BOOLEAN=81, PORTVAR_SUFFIX=82, ID=83;
	public static final int
		RULE_prog = 0, RULE_dependency = 1, RULE_typedef = 2, RULE_portIdentifier = 3, 
		RULE_statement = 4, RULE_statements = 5, RULE_template = 6, RULE_function = 7, 
		RULE_localVariableDef = 8, RULE_functionInterface = 9, RULE_portsDecl = 10, 
		RULE_entityInterface = 11, RULE_variableSegment = 12, RULE_transitionSegment = 13, 
		RULE_transition = 14, RULE_propertySegment = 15, RULE_property = 16, RULE_automaton = 17, 
		RULE_componentSegment = 18, RULE_internalSegment = 19, RULE_connectionSegment = 20, 
		RULE_componentDecl = 21, RULE_connectionDecl = 22, RULE_system = 23, RULE_meta = 24, 
		RULE_pathFormulae = 25, RULE_stateFormulae = 26, RULE_terms = 27, RULE_term = 28, 
		RULE_value = 29, RULE_type = 30, RULE_typeorvalue = 31, RULE_scopedID = 32;
	public static final String[] ruleNames = {
		"prog", "dependency", "typedef", "portIdentifier", "statement", "statements", 
		"template", "function", "localVariableDef", "functionInterface", "portsDecl", 
		"entityInterface", "variableSegment", "transitionSegment", "transition", 
		"propertySegment", "property", "automaton", "componentSegment", "internalSegment", 
		"connectionSegment", "componentDecl", "connectionDecl", "system", "meta", 
		"pathFormulae", "stateFormulae", "terms", "term", "value", "type", "typeorvalue", 
		"scopedID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'import'", "';'", "'from'", "','", "'*'", "'typedef'", "'as'", 
		"'.'", "'='", "'sync'", "'return'", "'if'", "'('", "')'", "'{'", "'}'", 
		"'else'", "'assert'", "'<'", "'>'", "'native'", "'function'", "':'", "'variables'", 
		"'statements'", "'in'", "'out'", "'transitions'", "'->'", "'group'", "'properties'", 
		"'automaton'", "'components'", "'internalCollection'", "'connections'", 
		"'system'", "'meta'", "'!'", "'A'", "'E'", "'<-'", "'<->'", "'&&'", "'||'", 
		"'X'", "'F'", "'G'", "'['", "'U'", "']'", "'-'", "'%'", "'/'", "'+'", 
		"'<='", "'>='", "'=='", "'!='", "'^'", "'^^'", "'&'", "'|'", "'?'", "'null'", 
		"'int'", "'..'", "'char'", "'double'", "'bool'", "'enum'", "'struct'", 
		"'init'", "'type'", "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
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
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__35))) != 0)) {
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
					{
					setState(66);
					dependency();
					}
					break;
				case T__5:
					{
					setState(67);
					typedef();
					}
					break;
				case T__20:
				case T__21:
					{
					setState(68);
					function();
					}
					break;
				case T__31:
					{
					setState(69);
					automaton();
					}
					break;
				case T__35:
					{
					setState(70);
					system();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75);
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__0);
				setState(77);
				((DependencyContext)_localctx).importedlib = scopedID();
				setState(78);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__2);
				setState(81);
				((DependencyContext)_localctx).fromlib = scopedID();
				setState(82);
				match(T__0);
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(83);
					match(ID);
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(84);
						match(T__3);
						setState(85);
						match(ID);
						}
						}
						setState(90);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__4:
					{
					setState(91);
					match(T__4);
					((DependencyContext)_localctx).importAll =  true;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(95);
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
			setState(99);
			match(T__5);
			setState(100);
			type(0);
			setState(101);
			match(T__6);
			setState(102);
			match(ID);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(103);
				match(T__3);
				setState(104);
				match(ID);
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
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
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(112);
				((PortIdentifierContext)_localctx).owner = match(ID);
				setState(113);
				match(T__7);
				}
				break;
			}
			setState(116);
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
	public static class AssertStatementContext extends StatementContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AssertStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAssertStatement(this);
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
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__14:
			case T__37:
			case T__47:
			case T__50:
			case T__63:
			case T__64:
			case T__66:
			case T__67:
			case T__68:
			case T__69:
			case T__70:
			case T__72:
			case T__73:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(118);
					((AssignmentStatementContext)_localctx).target = term(0);
					setState(119);
					match(T__8);
					}
					break;
				}
				setState(123);
				((AssignmentStatementContext)_localctx).expr = term(0);
				setState(124);
				match(T__1);
				}
				break;
			case T__9:
				_localctx = new SynchronizingStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__9);
				setState(127);
				portIdentifier();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(128);
					match(T__3);
					setState(129);
					portIdentifier();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(T__1);
				}
				break;
			case T__10:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__10);
				setState(138);
				term(0);
				setState(139);
				match(T__1);
				}
				break;
			case T__11:
				_localctx = new IteStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(T__11);
				setState(142);
				match(T__12);
				setState(143);
				((IteStatementContext)_localctx).condition = term(0);
				setState(144);
				match(T__13);
				setState(150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(145);
					((IteStatementContext)_localctx).thenstmt = statement();
					}
					break;
				case 2:
					{
					setState(146);
					match(T__14);
					setState(147);
					((IteStatementContext)_localctx).thenstmts = statements();
					setState(148);
					match(T__15);
					}
					break;
				}
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(152);
					match(T__16);
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(153);
						((IteStatementContext)_localctx).elsestmt = statement();
						}
						break;
					case 2:
						{
						setState(154);
						match(T__14);
						setState(155);
						((IteStatementContext)_localctx).elsestmts = statements();
						setState(156);
						match(T__15);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case T__17:
				_localctx = new AssertStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(T__17);
				setState(163);
				term(0);
				setState(164);
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
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__17) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(168);
				statement();
				}
				}
				setState(173);
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
			setState(174);
			match(T__18);
			setState(175);
			localVariableDef();
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(176);
				match(T__3);
				setState(177);
				localVariableDef();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__19);
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
		public MetaContext meta() {
			return getRuleContext(MetaContext.class,0);
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
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(185);
				match(T__20);
				((FunctionContext)_localctx).isNative =  true; 
				}
			}

			setState(189);
			match(T__21);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(190);
				template();
				}
			}

			setState(193);
			((FunctionContext)_localctx).name = match(ID);
			setState(194);
			match(T__12);
			setState(195);
			functionInterface();
			setState(196);
			match(T__13);
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(197);
				match(T__22);
				setState(198);
				((FunctionContext)_localctx).returnType = type(0);
				}
				break;
			}
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(201);
				if (!(!_localctx.isNative)) throw new FailedPredicateException(this, "!$isNative");
				setState(202);
				match(T__14);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23 || _la==T__24) {
					{
					setState(223);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__23:
						{
						setState(203);
						match(T__23);
						setState(204);
						match(T__14);
						setState(210);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==ID) {
							{
							{
							setState(205);
							localVariableDef();
							setState(206);
							match(T__1);
							}
							}
							setState(212);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(213);
						match(T__15);
						}
						break;
					case T__24:
						{
						setState(214);
						match(T__24);
						setState(215);
						match(T__14);
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__17) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
							{
							{
							setState(216);
							statement();
							}
							}
							setState(221);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(222);
						match(T__15);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(T__15);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(229);
					meta();
					}
				}

				}
				break;
			case 2:
				{
				setState(232);
				if (!(_localctx.isNative)) throw new FailedPredicateException(this, "$isNative");
				setState(233);
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
			setState(236);
			match(ID);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(237);
				match(T__3);
				setState(238);
				match(ID);
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(T__22);
			setState(245);
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
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(247);
				localVariableDef();
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(248);
					match(T__3);
					setState(249);
					localVariableDef();
					}
					}
					setState(254);
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
			setState(257);
			match(ID);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(258);
				match(T__3);
				setState(259);
				match(ID);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			match(T__22);
			setState(266);
			((PortsDeclContext)_localctx).direction = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
				((PortsDeclContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(267);
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
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(269);
				portsDecl();
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(270);
					match(T__3);
					setState(271);
					portsDecl();
					}
					}
					setState(276);
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
			setState(279);
			match(T__23);
			setState(280);
			match(T__14);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(281);
				localVariableDef();
				setState(282);
				match(T__1);
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
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
			setState(291);
			match(T__27);
			setState(292);
			match(T__14);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__29) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(293);
				transition();
				}
				}
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
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
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__14:
			case T__37:
			case T__47:
			case T__50:
			case T__63:
			case T__64:
			case T__66:
			case T__67:
			case T__68:
			case T__69:
			case T__70:
			case T__72:
			case T__73:
			case INT:
			case REAL:
			case STRING:
			case BOOLEAN:
			case ID:
				_localctx = new TransitionSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				term(0);
				setState(302);
				match(T__28);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(303);
					match(T__14);
					setState(304);
					statements();
					setState(305);
					match(T__15);
					}
					break;
				case 2:
					{
					setState(307);
					statement();
					}
					break;
				}
				}
				break;
			case T__29:
				_localctx = new TransitionGroupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(T__29);
				setState(311);
				match(T__14);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__29) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
					{
					{
					setState(312);
					transition();
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(318);
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

	public static class PropertySegmentContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public PropertySegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertySegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterPropertySegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitPropertySegment(this);
		}
	}

	public final PropertySegmentContext propertySegment() throws RecognitionException {
		PropertySegmentContext _localctx = new PropertySegmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertySegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(T__30);
			setState(322);
			match(T__14);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(323);
				match(ID);
				setState(324);
				match(T__22);
				setState(325);
				property();
				setState(326);
				match(T__1);
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
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

	public static class PropertyContext extends ParserRuleContext {
		public PathFormulaeContext pathFormulae() {
			return getRuleContext(PathFormulaeContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			pathFormulae(0);
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
		public List<PropertySegmentContext> propertySegment() {
			return getRuleContexts(PropertySegmentContext.class);
		}
		public PropertySegmentContext propertySegment(int i) {
			return getRuleContext(PropertySegmentContext.class,i);
		}
		public MetaContext meta() {
			return getRuleContext(MetaContext.class,0);
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
		enterRule(_localctx, 34, RULE_automaton);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__31);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(338);
				template();
				}
			}

			setState(341);
			((AutomatonContext)_localctx).name = match(ID);
			setState(342);
			match(T__12);
			setState(343);
			entityInterface();
			setState(344);
			match(T__13);
			setState(345);
			match(T__14);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__27) | (1L << T__30))) != 0)) {
				{
				setState(349);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					setState(346);
					variableSegment();
					}
					break;
				case T__27:
					{
					setState(347);
					transitionSegment();
					}
					break;
				case T__30:
					{
					setState(348);
					propertySegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
			match(T__15);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(355);
				meta();
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
		enterRule(_localctx, 36, RULE_componentSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(T__32);
			setState(359);
			match(T__14);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(360);
				componentDecl();
				setState(361);
				match(T__1);
				}
				}
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(368);
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
		enterRule(_localctx, 38, RULE_internalSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__33);
			setState(371);
			match(ID);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(372);
				match(T__3);
				setState(373);
				match(ID);
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(379);
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
		enterRule(_localctx, 40, RULE_connectionSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__34);
			setState(382);
			match(T__14);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__66 - 65)) | (1L << (T__67 - 65)) | (1L << (T__68 - 65)) | (1L << (T__69 - 65)) | (1L << (T__70 - 65)) | (1L << (T__72 - 65)) | (1L << (T__73 - 65)) | (1L << (ID - 65)))) != 0)) {
				{
				{
				setState(383);
				connectionDecl();
				setState(384);
				match(T__1);
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(391);
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
		enterRule(_localctx, 42, RULE_componentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(ID);
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(394);
				match(T__3);
				setState(395);
				match(ID);
				}
				}
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(401);
			match(T__22);
			setState(402);
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
		enterRule(_localctx, 44, RULE_connectionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			type(0);
			setState(405);
			match(T__12);
			setState(406);
			portIdentifier();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(407);
				match(T__3);
				setState(408);
				portIdentifier();
				}
				}
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(414);
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
		public MetaContext meta() {
			return getRuleContext(MetaContext.class,0);
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
		enterRule(_localctx, 46, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(T__35);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(417);
				template();
				}
			}

			setState(420);
			((SystemContext)_localctx).name = match(ID);
			setState(421);
			match(T__12);
			setState(422);
			entityInterface();
			setState(423);
			match(T__13);
			setState(424);
			match(T__14);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) {
				{
				setState(428);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__32:
					{
					setState(425);
					componentSegment();
					}
					break;
				case T__33:
					{
					setState(426);
					internalSegment();
					}
					break;
				case T__34:
					{
					setState(427);
					connectionSegment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(433);
			match(T__15);
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__36) {
				{
				setState(434);
				meta();
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

	public static class MetaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public MetaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterMeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitMeta(this);
		}
	}

	public final MetaContext meta() throws RecognitionException {
		MetaContext _localctx = new MetaContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_meta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(T__36);
			setState(438);
			match(T__14);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(439);
				match(ID);
				setState(440);
				match(T__8);
				setState(441);
				term(0);
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(442);
					match(T__3);
					setState(443);
					match(ID);
					setState(444);
					match(T__8);
					setState(445);
					term(0);
					}
					}
					setState(450);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(453);
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

	public static class PathFormulaeContext extends ParserRuleContext {
		public PathFormulaeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathFormulae; }
	 
		public PathFormulaeContext() { }
		public void copyFrom(PathFormulaeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotPathFormulaeContext extends PathFormulaeContext {
		public PathFormulaeContext pathFormulae() {
			return getRuleContext(PathFormulaeContext.class,0);
		}
		public NotPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterNotPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitNotPathFormulae(this);
		}
	}
	public static class ExistsPathFormulaeContext extends PathFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public ExistsPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterExistsPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitExistsPathFormulae(this);
		}
	}
	public static class BracketPathFormulaeContext extends PathFormulaeContext {
		public PathFormulaeContext pathFormulae() {
			return getRuleContext(PathFormulaeContext.class,0);
		}
		public BracketPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBracketPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBracketPathFormulae(this);
		}
	}
	public static class AllPathFormulaeContext extends PathFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public AllPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAllPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAllPathFormulae(this);
		}
	}
	public static class BinaryPathFormulaeContext extends PathFormulaeContext {
		public PathFormulaeContext left;
		public Token opr;
		public PathFormulaeContext right;
		public List<PathFormulaeContext> pathFormulae() {
			return getRuleContexts(PathFormulaeContext.class);
		}
		public PathFormulaeContext pathFormulae(int i) {
			return getRuleContext(PathFormulaeContext.class,i);
		}
		public BinaryPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBinaryPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBinaryPathFormulae(this);
		}
	}
	public static class AtomicPathFormulaeContext extends PathFormulaeContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AtomicPathFormulaeContext(PathFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterAtomicPathFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitAtomicPathFormulae(this);
		}
	}

	public final PathFormulaeContext pathFormulae() throws RecognitionException {
		return pathFormulae(0);
	}

	private PathFormulaeContext pathFormulae(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathFormulaeContext _localctx = new PathFormulaeContext(_ctx, _parentState);
		PathFormulaeContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_pathFormulae, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				_localctx = new AtomicPathFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(456);
				term(0);
				}
				break;
			case 2:
				{
				_localctx = new NotPathFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(457);
				match(T__37);
				setState(458);
				pathFormulae(9);
				}
				break;
			case 3:
				{
				_localctx = new AllPathFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(459);
				match(T__38);
				setState(460);
				stateFormulae(0);
				}
				break;
			case 4:
				{
				_localctx = new ExistsPathFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(461);
				match(T__39);
				setState(462);
				stateFormulae(0);
				}
				break;
			case 5:
				{
				_localctx = new BracketPathFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(463);
				match(T__12);
				setState(464);
				pathFormulae(0);
				setState(465);
				match(T__13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(486);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(484);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryPathFormulaeContext(new PathFormulaeContext(_parentctx, _parentState));
						((BinaryPathFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFormulae);
						setState(469);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(470);
						((BinaryPathFormulaeContext)_localctx).opr = match(T__28);
						setState(471);
						((BinaryPathFormulaeContext)_localctx).right = pathFormulae(7);
						}
						break;
					case 2:
						{
						_localctx = new BinaryPathFormulaeContext(new PathFormulaeContext(_parentctx, _parentState));
						((BinaryPathFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFormulae);
						setState(472);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(473);
						((BinaryPathFormulaeContext)_localctx).opr = match(T__40);
						setState(474);
						((BinaryPathFormulaeContext)_localctx).right = pathFormulae(6);
						}
						break;
					case 3:
						{
						_localctx = new BinaryPathFormulaeContext(new PathFormulaeContext(_parentctx, _parentState));
						((BinaryPathFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFormulae);
						setState(475);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(476);
						((BinaryPathFormulaeContext)_localctx).opr = match(T__41);
						setState(477);
						((BinaryPathFormulaeContext)_localctx).right = pathFormulae(5);
						}
						break;
					case 4:
						{
						_localctx = new BinaryPathFormulaeContext(new PathFormulaeContext(_parentctx, _parentState));
						((BinaryPathFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFormulae);
						setState(478);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(479);
						((BinaryPathFormulaeContext)_localctx).opr = match(T__42);
						setState(480);
						((BinaryPathFormulaeContext)_localctx).right = pathFormulae(4);
						}
						break;
					case 5:
						{
						_localctx = new BinaryPathFormulaeContext(new PathFormulaeContext(_parentctx, _parentState));
						((BinaryPathFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_pathFormulae);
						setState(481);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(482);
						((BinaryPathFormulaeContext)_localctx).opr = match(T__43);
						setState(483);
						((BinaryPathFormulaeContext)_localctx).right = pathFormulae(3);
						}
						break;
					}
					} 
				}
				setState(488);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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

	public static class StateFormulaeContext extends ParserRuleContext {
		public StateFormulaeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateFormulae; }
	 
		public StateFormulaeContext() { }
		public void copyFrom(StateFormulaeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public NotStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterNotStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitNotStateFormulae(this);
		}
	}
	public static class PathStateFormulaeContext extends StateFormulaeContext {
		public PathFormulaeContext pathFormulae() {
			return getRuleContext(PathFormulaeContext.class,0);
		}
		public PathStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterPathStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitPathStateFormulae(this);
		}
	}
	public static class GloballyStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public GloballyStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterGloballyStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitGloballyStateFormulae(this);
		}
	}
	public static class BinaryStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext left;
		public Token opr;
		public StateFormulaeContext right;
		public List<StateFormulaeContext> stateFormulae() {
			return getRuleContexts(StateFormulaeContext.class);
		}
		public StateFormulaeContext stateFormulae(int i) {
			return getRuleContext(StateFormulaeContext.class,i);
		}
		public BinaryStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBinaryStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBinaryStateFormulae(this);
		}
	}
	public static class BracketStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public BracketStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterBracketStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitBracketStateFormulae(this);
		}
	}
	public static class FinallyStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public FinallyStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterFinallyStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitFinallyStateFormulae(this);
		}
	}
	public static class NextStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext stateFormulae() {
			return getRuleContext(StateFormulaeContext.class,0);
		}
		public NextStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterNextStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitNextStateFormulae(this);
		}
	}
	public static class UntilStateFormulaeContext extends StateFormulaeContext {
		public StateFormulaeContext keep;
		public StateFormulaeContext until;
		public List<StateFormulaeContext> stateFormulae() {
			return getRuleContexts(StateFormulaeContext.class);
		}
		public StateFormulaeContext stateFormulae(int i) {
			return getRuleContext(StateFormulaeContext.class,i);
		}
		public UntilStateFormulaeContext(StateFormulaeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterUntilStateFormulae(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitUntilStateFormulae(this);
		}
	}

	public final StateFormulaeContext stateFormulae() throws RecognitionException {
		return stateFormulae(0);
	}

	private StateFormulaeContext stateFormulae(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StateFormulaeContext _localctx = new StateFormulaeContext(_ctx, _parentState);
		StateFormulaeContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_stateFormulae, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				_localctx = new PathStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(490);
				pathFormulae(0);
				}
				break;
			case 2:
				{
				_localctx = new NotStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(491);
				match(T__37);
				setState(492);
				stateFormulae(11);
				}
				break;
			case 3:
				{
				_localctx = new NextStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				match(T__44);
				setState(494);
				stateFormulae(5);
				}
				break;
			case 4:
				{
				_localctx = new FinallyStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495);
				match(T__45);
				setState(496);
				stateFormulae(4);
				}
				break;
			case 5:
				{
				_localctx = new GloballyStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				match(T__46);
				setState(498);
				stateFormulae(3);
				}
				break;
			case 6:
				{
				_localctx = new UntilStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499);
				match(T__47);
				setState(500);
				((UntilStateFormulaeContext)_localctx).keep = stateFormulae(0);
				setState(501);
				match(T__48);
				setState(502);
				((UntilStateFormulaeContext)_localctx).until = stateFormulae(0);
				setState(503);
				match(T__49);
				}
				break;
			case 7:
				{
				_localctx = new BracketStateFormulaeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(505);
				match(T__12);
				setState(506);
				stateFormulae(0);
				setState(507);
				match(T__13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(528);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(526);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryStateFormulaeContext(new StateFormulaeContext(_parentctx, _parentState));
						((BinaryStateFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stateFormulae);
						setState(511);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(512);
						((BinaryStateFormulaeContext)_localctx).opr = match(T__28);
						setState(513);
						((BinaryStateFormulaeContext)_localctx).right = stateFormulae(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryStateFormulaeContext(new StateFormulaeContext(_parentctx, _parentState));
						((BinaryStateFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stateFormulae);
						setState(514);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(515);
						((BinaryStateFormulaeContext)_localctx).opr = match(T__40);
						setState(516);
						((BinaryStateFormulaeContext)_localctx).right = stateFormulae(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryStateFormulaeContext(new StateFormulaeContext(_parentctx, _parentState));
						((BinaryStateFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stateFormulae);
						setState(517);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(518);
						((BinaryStateFormulaeContext)_localctx).opr = match(T__41);
						setState(519);
						((BinaryStateFormulaeContext)_localctx).right = stateFormulae(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryStateFormulaeContext(new StateFormulaeContext(_parentctx, _parentState));
						((BinaryStateFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stateFormulae);
						setState(520);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(521);
						((BinaryStateFormulaeContext)_localctx).opr = match(T__42);
						setState(522);
						((BinaryStateFormulaeContext)_localctx).right = stateFormulae(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryStateFormulaeContext(new StateFormulaeContext(_parentctx, _parentState));
						((BinaryStateFormulaeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_stateFormulae);
						setState(523);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(524);
						((BinaryStateFormulaeContext)_localctx).opr = match(T__43);
						setState(525);
						((BinaryStateFormulaeContext)_localctx).right = stateFormulae(7);
						}
						break;
					}
					} 
				}
				setState(530);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		enterRule(_localctx, 54, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				setState(531);
				term(0);
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(532);
					match(T__3);
					setState(533);
					term(0);
					}
					}
					setState(538);
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
	public static class StructTermContext extends TermContext {
		public List<TerminalNode> ID() { return getTokens(MediatorLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MediatorLangParser.ID, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public StructTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).enterStructTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MediatorLangListener ) ((MediatorLangListener)listener).exitStructTerm(this);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(542);
				match(T__12);
				setState(543);
				term(0);
				setState(544);
				match(T__13);
				}
				break;
			case 2:
				{
				_localctx = new TupleTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(546);
				match(T__12);
				setState(547);
				term(0);
				setState(550); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(548);
					match(T__3);
					setState(549);
					term(0);
					}
					}
					setState(552); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(554);
				match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new ListTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(556);
				match(T__47);
				setState(557);
				terms();
				setState(558);
				match(T__49);
				}
				break;
			case 4:
				{
				_localctx = new StructTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(560);
				match(T__14);
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(561);
					match(ID);
					setState(562);
					match(T__8);
					setState(563);
					term(0);
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(564);
						match(T__3);
						setState(565);
						match(ID);
						setState(566);
						match(T__8);
						setState(567);
						term(0);
						}
						}
						setState(572);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(575);
				match(T__15);
				}
				break;
			case 5:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(576);
				((SingleOprTermContext)_localctx).opr = match(T__50);
				setState(577);
				term(24);
				}
				break;
			case 6:
				{
				_localctx = new SingleOprTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(578);
				((SingleOprTermContext)_localctx).opr = match(T__37);
				setState(579);
				term(23);
				}
				break;
			case 7:
				{
				_localctx = new CallTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(580);
				((CallTermContext)_localctx).callee = type(0);
				setState(581);
				match(T__12);
				setState(582);
				((CallTermContext)_localctx).args = terms();
				setState(583);
				match(T__13);
				}
				break;
			case 8:
				{
				_localctx = new ValueTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(585);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(655);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(653);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(588);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(589);
						((BinaryOprTermContext)_localctx).opr = match(T__51);
						setState(590);
						((BinaryOprTermContext)_localctx).right = term(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(591);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(592);
						((BinaryOprTermContext)_localctx).opr = match(T__4);
						setState(593);
						((BinaryOprTermContext)_localctx).right = term(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(594);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(595);
						((BinaryOprTermContext)_localctx).opr = match(T__52);
						setState(596);
						((BinaryOprTermContext)_localctx).right = term(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(597);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(598);
						((BinaryOprTermContext)_localctx).opr = match(T__53);
						setState(599);
						((BinaryOprTermContext)_localctx).right = term(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(600);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(601);
						((BinaryOprTermContext)_localctx).opr = match(T__50);
						setState(602);
						((BinaryOprTermContext)_localctx).right = term(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(603);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(604);
						((BinaryOprTermContext)_localctx).opr = match(T__18);
						setState(605);
						((BinaryOprTermContext)_localctx).right = term(15);
						}
						break;
					case 7:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(606);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(607);
						((BinaryOprTermContext)_localctx).opr = match(T__54);
						setState(608);
						((BinaryOprTermContext)_localctx).right = term(14);
						}
						break;
					case 8:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(609);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(610);
						((BinaryOprTermContext)_localctx).opr = match(T__19);
						setState(611);
						((BinaryOprTermContext)_localctx).right = term(13);
						}
						break;
					case 9:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(612);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(613);
						((BinaryOprTermContext)_localctx).opr = match(T__55);
						setState(614);
						((BinaryOprTermContext)_localctx).right = term(12);
						}
						break;
					case 10:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(615);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(616);
						((BinaryOprTermContext)_localctx).opr = match(T__56);
						setState(617);
						((BinaryOprTermContext)_localctx).right = term(11);
						}
						break;
					case 11:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(618);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(619);
						((BinaryOprTermContext)_localctx).opr = match(T__57);
						setState(620);
						((BinaryOprTermContext)_localctx).right = term(10);
						}
						break;
					case 12:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(621);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(622);
						((BinaryOprTermContext)_localctx).opr = match(T__58);
						setState(623);
						((BinaryOprTermContext)_localctx).right = term(9);
						}
						break;
					case 13:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(624);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(625);
						((BinaryOprTermContext)_localctx).opr = match(T__59);
						setState(626);
						((BinaryOprTermContext)_localctx).right = term(8);
						}
						break;
					case 14:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(627);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(628);
						((BinaryOprTermContext)_localctx).opr = match(T__60);
						setState(629);
						((BinaryOprTermContext)_localctx).right = term(7);
						}
						break;
					case 15:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(630);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(631);
						((BinaryOprTermContext)_localctx).opr = match(T__42);
						setState(632);
						((BinaryOprTermContext)_localctx).right = term(6);
						}
						break;
					case 16:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(633);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(634);
						((BinaryOprTermContext)_localctx).opr = match(T__61);
						setState(635);
						((BinaryOprTermContext)_localctx).right = term(5);
						}
						break;
					case 17:
						{
						_localctx = new BinaryOprTermContext(new TermContext(_parentctx, _parentState));
						((BinaryOprTermContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(636);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(637);
						((BinaryOprTermContext)_localctx).opr = match(T__43);
						setState(638);
						((BinaryOprTermContext)_localctx).right = term(4);
						}
						break;
					case 18:
						{
						_localctx = new IteTermContext(new TermContext(_parentctx, _parentState));
						((IteTermContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(639);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(640);
						match(T__62);
						setState(641);
						((IteTermContext)_localctx).ifTrue = term(0);
						setState(642);
						match(T__22);
						setState(643);
						((IteTermContext)_localctx).ifFalse = term(3);
						}
						break;
					case 19:
						{
						_localctx = new ElementTermContext(new TermContext(_parentctx, _parentState));
						((ElementTermContext)_localctx).container = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(645);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(646);
						match(T__47);
						setState(647);
						((ElementTermContext)_localctx).key = term(0);
						setState(648);
						match(T__49);
						}
						break;
					case 20:
						{
						_localctx = new FieldTermContext(new TermContext(_parentctx, _parentState));
						((FieldTermContext)_localctx).structure = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(650);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(651);
						match(T__7);
						setState(652);
						((FieldTermContext)_localctx).key = match(ID);
						}
						break;
					}
					} 
				}
				setState(657);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
		enterRule(_localctx, 58, RULE_value);
		try {
			setState(668);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(658);
				match(INT);
				}
				break;
			case 2:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(659);
				match(REAL);
				}
				break;
			case 3:
				_localctx = new StrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(660);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(661);
				match(BOOLEAN);
				}
				break;
			case 5:
				_localctx = new PortVarValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(662);
				scopedID();
				setState(663);
				match(T__7);
				setState(664);
				match(PORTVAR_SUFFIX);
				}
				break;
			case 6:
				_localctx = new IdValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(666);
				scopedID();
				}
				break;
			case 7:
				_localctx = new NullValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(667);
				match(T__63);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				_localctx = new BracketTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(671);
				match(T__12);
				setState(672);
				type(0);
				setState(673);
				match(T__13);
				}
				break;
			case 2:
				{
				_localctx = new TupleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(675);
				match(T__12);
				setState(676);
				type(0);
				setState(679); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(677);
					match(T__3);
					setState(678);
					type(0);
					}
					}
					setState(681); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				setState(683);
				match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(685);
				match(T__64);
				}
				break;
			case 4:
				{
				_localctx = new BoundedIntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(686);
				match(T__64);
				setState(687);
				((BoundedIntTypeContext)_localctx).lbound = term(0);
				setState(688);
				match(T__65);
				setState(689);
				((BoundedIntTypeContext)_localctx).ubound = term(0);
				}
				break;
			case 5:
				{
				_localctx = new CharTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(691);
				match(T__66);
				}
				break;
			case 6:
				{
				_localctx = new DoubleTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(692);
				match(T__67);
				}
				break;
			case 7:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(693);
				match(T__68);
				}
				break;
			case 8:
				{
				_localctx = new EnumTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(694);
				match(T__69);
				setState(695);
				match(T__14);
				setState(696);
				match(ID);
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(697);
					match(T__3);
					setState(698);
					match(ID);
					}
					}
					setState(703);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(704);
				match(T__15);
				}
				break;
			case 9:
				{
				_localctx = new StructTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(705);
				match(T__70);
				setState(706);
				match(T__14);
				setState(712); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(707);
					match(ID);
					setState(708);
					match(T__22);
					setState(709);
					type(0);
					setState(710);
					match(T__1);
					}
					}
					setState(714); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(716);
				match(T__15);
				}
				break;
			case 10:
				{
				_localctx = new AbstractTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(718);
				match(T__72);
				}
				break;
			case 11:
				{
				_localctx = new NullTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				match(T__73);
				}
				break;
			case 12:
				{
				_localctx = new IdTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(720);
				scopedID();
				}
				break;
			case 13:
				{
				_localctx = new TemplateTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(721);
				scopedID();
				setState(733);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(722);
					match(T__18);
					setState(723);
					typeorvalue();
					setState(728);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(724);
						match(T__3);
						setState(725);
						typeorvalue();
						}
						}
						setState(730);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(731);
					match(T__19);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(751);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(749);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
					case 1:
						{
						_localctx = new UnionTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(737);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(738);
						match(T__61);
						setState(739);
						type(6);
						}
						break;
					case 2:
						{
						_localctx = new ListTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(740);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(741);
						match(T__47);
						setState(743);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__37) | (1L << T__47) | (1L << T__50))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (INT - 64)) | (1L << (REAL - 64)) | (1L << (STRING - 64)) | (1L << (BOOLEAN - 64)) | (1L << (ID - 64)))) != 0)) {
							{
							setState(742);
							((ListTypeContext)_localctx).capacity = term(0);
							}
						}

						setState(745);
						match(T__49);
						}
						break;
					case 3:
						{
						_localctx = new InitTypeContext(new TypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type);
						setState(746);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(747);
						match(T__71);
						setState(748);
						term(0);
						}
						break;
					}
					} 
				}
				setState(753);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
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
		enterRule(_localctx, 62, RULE_typeorvalue);
		try {
			setState(756);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(754);
				type(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(755);
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
		enterRule(_localctx, 64, RULE_scopedID);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(758);
					((ScopedIDContext)_localctx).ID = match(ID);
					((ScopedIDContext)_localctx).scopes.add(((ScopedIDContext)_localctx).ID);
					setState(759);
					match(T__7);
					}
					} 
				}
				setState(764);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			setState(765);
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
		case 25:
			return pathFormulae_sempred((PathFormulaeContext)_localctx, predIndex);
		case 26:
			return stateFormulae_sempred((StateFormulaeContext)_localctx, predIndex);
		case 28:
			return term_sempred((TermContext)_localctx, predIndex);
		case 30:
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
	private boolean pathFormulae_sempred(PathFormulaeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean stateFormulae_sempred(StateFormulaeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		case 16:
			return precpred(_ctx, 15);
		case 17:
			return precpred(_ctx, 14);
		case 18:
			return precpred(_ctx, 13);
		case 19:
			return precpred(_ctx, 12);
		case 20:
			return precpred(_ctx, 11);
		case 21:
			return precpred(_ctx, 10);
		case 22:
			return precpred(_ctx, 9);
		case 23:
			return precpred(_ctx, 8);
		case 24:
			return precpred(_ctx, 7);
		case 25:
			return precpred(_ctx, 6);
		case 26:
			return precpred(_ctx, 5);
		case 27:
			return precpred(_ctx, 4);
		case 28:
			return precpred(_ctx, 3);
		case 29:
			return precpred(_ctx, 2);
		case 30:
			return precpred(_ctx, 21);
		case 31:
			return precpred(_ctx, 20);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return precpred(_ctx, 5);
		case 33:
			return precpred(_ctx, 7);
		case 34:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3U\u0302\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3\3\3\5\3`\n\3\3"+
		"\3\3\3\5\3d\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4l\n\4\f\4\16\4o\13\4\3\4\3"+
		"\4\3\5\3\5\5\5u\n\5\3\5\3\5\3\6\3\6\3\6\5\6|\n\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u0085\n\6\f\6\16\6\u0088\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0099\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\u00a1\n\6\5\6\u00a3\n\6\3\6\3\6\3\6\3\6\5\6\u00a9\n\6\3\7\7\7\u00ac"+
		"\n\7\f\7\16\7\u00af\13\7\3\b\3\b\3\b\3\b\7\b\u00b5\n\b\f\b\16\b\u00b8"+
		"\13\b\3\b\3\b\3\t\3\t\5\t\u00be\n\t\3\t\3\t\5\t\u00c2\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00ca\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d3\n\t\f"+
		"\t\16\t\u00d6\13\t\3\t\3\t\3\t\3\t\7\t\u00dc\n\t\f\t\16\t\u00df\13\t\3"+
		"\t\7\t\u00e2\n\t\f\t\16\t\u00e5\13\t\3\t\3\t\5\t\u00e9\n\t\3\t\3\t\5\t"+
		"\u00ed\n\t\3\n\3\n\3\n\7\n\u00f2\n\n\f\n\16\n\u00f5\13\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\7\13\u00fd\n\13\f\13\16\13\u0100\13\13\5\13\u0102\n\13\3"+
		"\f\3\f\3\f\7\f\u0107\n\f\f\f\16\f\u010a\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\7\r\u0113\n\r\f\r\16\r\u0116\13\r\5\r\u0118\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u011f\n\16\f\16\16\16\u0122\13\16\3\16\3\16\3\17\3\17\3\17"+
		"\7\17\u0129\n\17\f\17\16\17\u012c\13\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0137\n\20\3\20\3\20\3\20\7\20\u013c\n\20\f\20\16"+
		"\20\u013f\13\20\3\20\5\20\u0142\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u014b\n\21\f\21\16\21\u014e\13\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\5\23\u0156\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0160\n"+
		"\23\f\23\16\23\u0163\13\23\3\23\3\23\5\23\u0167\n\23\3\24\3\24\3\24\3"+
		"\24\3\24\7\24\u016e\n\24\f\24\16\24\u0171\13\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\7\25\u0179\n\25\f\25\16\25\u017c\13\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\7\26\u0185\n\26\f\26\16\26\u0188\13\26\3\26\3\26\3\27\3"+
		"\27\3\27\7\27\u018f\n\27\f\27\16\27\u0192\13\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\7\30\u019c\n\30\f\30\16\30\u019f\13\30\3\30\3\30\3"+
		"\31\3\31\5\31\u01a5\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u01af\n\31\f\31\16\31\u01b2\13\31\3\31\3\31\5\31\u01b6\n\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u01c1\n\32\f\32\16\32\u01c4\13"+
		"\32\5\32\u01c6\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u01d6\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u01e7\n\33\f\33\16\33\u01ea"+
		"\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0200\n\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0211\n\34"+
		"\f\34\16\34\u0214\13\34\3\35\3\35\3\35\7\35\u0219\n\35\f\35\16\35\u021c"+
		"\13\35\5\35\u021e\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\6"+
		"\36\u0229\n\36\r\36\16\36\u022a\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u023b\n\36\f\36\16\36\u023e\13\36"+
		"\5\36\u0240\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u024d\n\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0290"+
		"\n\36\f\36\16\36\u0293\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\5\37\u029f\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \6 \u02aa\n \r \16"+
		" \u02ab\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u02be\n \f"+
		" \16 \u02c1\13 \3 \3 \3 \3 \3 \3 \3 \3 \6 \u02cb\n \r \16 \u02cc\3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \7 \u02d9\n \f \16 \u02dc\13 \3 \3 \5 \u02e0"+
		"\n \5 \u02e2\n \3 \3 \3 \3 \3 \3 \5 \u02ea\n \3 \3 \3 \3 \7 \u02f0\n "+
		"\f \16 \u02f3\13 \3!\3!\5!\u02f7\n!\3\"\3\"\7\"\u02fb\n\"\f\"\16\"\u02fe"+
		"\13\"\3\"\3\"\3\"\2\6\64\66:>#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@B\2\3\3\2\34\35\2\u036c\2K\3\2\2\2\4c\3\2\2"+
		"\2\6e\3\2\2\2\bt\3\2\2\2\n\u00a8\3\2\2\2\f\u00ad\3\2\2\2\16\u00b0\3\2"+
		"\2\2\20\u00bd\3\2\2\2\22\u00ee\3\2\2\2\24\u0101\3\2\2\2\26\u0103\3\2\2"+
		"\2\30\u0117\3\2\2\2\32\u0119\3\2\2\2\34\u0125\3\2\2\2\36\u0141\3\2\2\2"+
		" \u0143\3\2\2\2\"\u0151\3\2\2\2$\u0153\3\2\2\2&\u0168\3\2\2\2(\u0174\3"+
		"\2\2\2*\u017f\3\2\2\2,\u018b\3\2\2\2.\u0196\3\2\2\2\60\u01a2\3\2\2\2\62"+
		"\u01b7\3\2\2\2\64\u01d5\3\2\2\2\66\u01ff\3\2\2\28\u021d\3\2\2\2:\u024c"+
		"\3\2\2\2<\u029e\3\2\2\2>\u02e1\3\2\2\2@\u02f6\3\2\2\2B\u02fc\3\2\2\2D"+
		"J\5\4\3\2EJ\5\6\4\2FJ\5\20\t\2GJ\5$\23\2HJ\5\60\31\2ID\3\2\2\2IE\3\2\2"+
		"\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2"+
		"\2\2MK\3\2\2\2NO\7\3\2\2OP\5B\"\2PQ\7\4\2\2Qd\3\2\2\2RS\7\5\2\2ST\5B\""+
		"\2T_\7\3\2\2UZ\7U\2\2VW\7\6\2\2WY\7U\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[`\3\2\2\2\\Z\3\2\2\2]^\7\7\2\2^`\b\3\1\2_U\3\2\2\2_]\3\2"+
		"\2\2`a\3\2\2\2ab\7\4\2\2bd\3\2\2\2cN\3\2\2\2cR\3\2\2\2d\5\3\2\2\2ef\7"+
		"\b\2\2fg\5> \2gh\7\t\2\2hm\7U\2\2ij\7\6\2\2jl\7U\2\2ki\3\2\2\2lo\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\4\2\2q\7\3\2\2\2rs\7U\2"+
		"\2su\7\n\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7U\2\2w\t\3\2\2\2xy\5:\36"+
		"\2yz\7\13\2\2z|\3\2\2\2{x\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5:\36\2~\177\7"+
		"\4\2\2\177\u00a9\3\2\2\2\u0080\u0081\7\f\2\2\u0081\u0086\5\b\5\2\u0082"+
		"\u0083\7\6\2\2\u0083\u0085\5\b\5\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008a\7\4\2\2\u008a\u00a9\3\2\2\2\u008b\u008c\7\r"+
		"\2\2\u008c\u008d\5:\36\2\u008d\u008e\7\4\2\2\u008e\u00a9\3\2\2\2\u008f"+
		"\u0090\7\16\2\2\u0090\u0091\7\17\2\2\u0091\u0092\5:\36\2\u0092\u0098\7"+
		"\20\2\2\u0093\u0099\5\n\6\2\u0094\u0095\7\21\2\2\u0095\u0096\5\f\7\2\u0096"+
		"\u0097\7\22\2\2\u0097\u0099\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0094\3"+
		"\2\2\2\u0099\u00a2\3\2\2\2\u009a\u00a0\7\23\2\2\u009b\u00a1\5\n\6\2\u009c"+
		"\u009d\7\21\2\2\u009d\u009e\5\f\7\2\u009e\u009f\7\22\2\2\u009f\u00a1\3"+
		"\2\2\2\u00a0\u009b\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u009a\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a9\3\2\2\2\u00a4\u00a5\7\24"+
		"\2\2\u00a5\u00a6\5:\36\2\u00a6\u00a7\7\4\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"{\3\2\2\2\u00a8\u0080\3\2\2\2\u00a8\u008b\3\2\2\2\u00a8\u008f\3\2\2\2"+
		"\u00a8\u00a4\3\2\2\2\u00a9\13\3\2\2\2\u00aa\u00ac\5\n\6\2\u00ab\u00aa"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\r\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\25\2\2\u00b1\u00b6\5\22\n"+
		"\2\u00b2\u00b3\7\6\2\2\u00b3\u00b5\5\22\n\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\26\2\2\u00ba\17\3\2\2\2\u00bb\u00bc"+
		"\7\27\2\2\u00bc\u00be\b\t\1\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2"+
		"\u00be\u00bf\3\2\2\2\u00bf\u00c1\7\30\2\2\u00c0\u00c2\5\16\b\2\u00c1\u00c0"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7U\2\2\u00c4"+
		"\u00c5\7\17\2\2\u00c5\u00c6\5\24\13\2\u00c6\u00c9\7\20\2\2\u00c7\u00c8"+
		"\7\31\2\2\u00c8\u00ca\5> \2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00ec\3\2\2\2\u00cb\u00cc\6\t\2\3\u00cc\u00e3\7\21\2\2\u00cd\u00ce\7"+
		"\32\2\2\u00ce\u00d4\7\21\2\2\u00cf\u00d0\5\22\n\2\u00d0\u00d1\7\4\2\2"+
		"\u00d1\u00d3\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00e2\7\22\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00dd\7\21\2\2\u00da\u00dc"+
		"\5\n\6\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\7\22"+
		"\2\2\u00e1\u00cd\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e6\u00e8\7\22\2\2\u00e7\u00e9\5\62\32\2\u00e8\u00e7\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ed\3\2\2\2\u00ea\u00eb\6\t\3\3\u00eb\u00ed\7\4"+
		"\2\2\u00ec\u00cb\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\21\3\2\2\2\u00ee\u00f3"+
		"\7U\2\2\u00ef\u00f0\7\6\2\2\u00f0\u00f2\7U\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2"+
		"\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7\31\2\2\u00f7\u00f8\5> \2\u00f8"+
		"\23\3\2\2\2\u00f9\u00fe\5\22\n\2\u00fa\u00fb\7\6\2\2\u00fb\u00fd\5\22"+
		"\n\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u00f9\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\25\3\2\2\2\u0103\u0108\7U\2\2\u0104\u0105"+
		"\7\6\2\2\u0105\u0107\7U\2\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u010c\7\31\2\2\u010c\u010d\t\2\2\2\u010d\u010e\5> \2\u010e"+
		"\27\3\2\2\2\u010f\u0114\5\26\f\2\u0110\u0111\7\6\2\2\u0111\u0113\5\26"+
		"\f\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u010f\3\2"+
		"\2\2\u0117\u0118\3\2\2\2\u0118\31\3\2\2\2\u0119\u011a\7\32\2\2\u011a\u0120"+
		"\7\21\2\2\u011b\u011c\5\22\n\2\u011c\u011d\7\4\2\2\u011d\u011f\3\2\2\2"+
		"\u011e\u011b\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\22\2\2"+
		"\u0124\33\3\2\2\2\u0125\u0126\7\36\2\2\u0126\u012a\7\21\2\2\u0127\u0129"+
		"\5\36\20\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2"+
		"\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e"+
		"\7\22\2\2\u012e\35\3\2\2\2\u012f\u0130\5:\36\2\u0130\u0136\7\37\2\2\u0131"+
		"\u0132\7\21\2\2\u0132\u0133\5\f\7\2\u0133\u0134\7\22\2\2\u0134\u0137\3"+
		"\2\2\2\u0135\u0137\5\n\6\2\u0136\u0131\3\2\2\2\u0136\u0135\3\2\2\2\u0137"+
		"\u0142\3\2\2\2\u0138\u0139\7 \2\2\u0139\u013d\7\21\2\2\u013a\u013c\5\36"+
		"\20\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0142\7\22"+
		"\2\2\u0141\u012f\3\2\2\2\u0141\u0138\3\2\2\2\u0142\37\3\2\2\2\u0143\u0144"+
		"\7!\2\2\u0144\u014c\7\21\2\2\u0145\u0146\7U\2\2\u0146\u0147\7\31\2\2\u0147"+
		"\u0148\5\"\22\2\u0148\u0149\7\4\2\2\u0149\u014b\3\2\2\2\u014a\u0145\3"+
		"\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7\22\2\2\u0150!\3\2\2\2"+
		"\u0151\u0152\5\64\33\2\u0152#\3\2\2\2\u0153\u0155\7\"\2\2\u0154\u0156"+
		"\5\16\b\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2"+
		"\u0157\u0158\7U\2\2\u0158\u0159\7\17\2\2\u0159\u015a\5\30\r\2\u015a\u015b"+
		"\7\20\2\2\u015b\u0161\7\21\2\2\u015c\u0160\5\32\16\2\u015d\u0160\5\34"+
		"\17\2\u015e\u0160\5 \21\2\u015f\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2"+
		"\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0166\7\22\2\2\u0165"+
		"\u0167\5\62\32\2\u0166\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167%\3\2\2"+
		"\2\u0168\u0169\7#\2\2\u0169\u016f\7\21\2\2\u016a\u016b\5,\27\2\u016b\u016c"+
		"\7\4\2\2\u016c\u016e\3\2\2\2\u016d\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2"+
		"\2\2\u0172\u0173\7\22\2\2\u0173\'\3\2\2\2\u0174\u0175\7$\2\2\u0175\u017a"+
		"\7U\2\2\u0176\u0177\7\6\2\2\u0177\u0179\7U\2\2\u0178\u0176\3\2\2\2\u0179"+
		"\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2"+
		"\2\2\u017c\u017a\3\2\2\2\u017d\u017e\7\4\2\2\u017e)\3\2\2\2\u017f\u0180"+
		"\7%\2\2\u0180\u0186\7\21\2\2\u0181\u0182\5.\30\2\u0182\u0183\7\4\2\2\u0183"+
		"\u0185\3\2\2\2\u0184\u0181\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189"+
		"\u018a\7\22\2\2\u018a+\3\2\2\2\u018b\u0190\7U\2\2\u018c\u018d\7\6\2\2"+
		"\u018d\u018f\7U\2\2\u018e\u018c\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e"+
		"\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190\3\2\2\2\u0193"+
		"\u0194\7\31\2\2\u0194\u0195\5> \2\u0195-\3\2\2\2\u0196\u0197\5> \2\u0197"+
		"\u0198\7\17\2\2\u0198\u019d\5\b\5\2\u0199\u019a\7\6\2\2\u019a\u019c\5"+
		"\b\5\2\u019b\u0199\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a1\7\20"+
		"\2\2\u01a1/\3\2\2\2\u01a2\u01a4\7&\2\2\u01a3\u01a5\5\16\b\2\u01a4\u01a3"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7U\2\2\u01a7"+
		"\u01a8\7\17\2\2\u01a8\u01a9\5\30\r\2\u01a9\u01aa\7\20\2\2\u01aa\u01b0"+
		"\7\21\2\2\u01ab\u01af\5&\24\2\u01ac\u01af\5(\25\2\u01ad\u01af\5*\26\2"+
		"\u01ae\u01ab\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01ad\3\2\2\2\u01af\u01b2"+
		"\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b3\u01b5\7\22\2\2\u01b4\u01b6\5\62\32\2\u01b5\u01b4"+
		"\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\61\3\2\2\2\u01b7\u01b8\7\'\2\2\u01b8"+
		"\u01c5\7\21\2\2\u01b9\u01ba\7U\2\2\u01ba\u01bb\7\13\2\2\u01bb\u01c2\5"+
		":\36\2\u01bc\u01bd\7\6\2\2\u01bd\u01be\7U\2\2\u01be\u01bf\7\13\2\2\u01bf"+
		"\u01c1\5:\36\2\u01c0\u01bc\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5"+
		"\u01b9\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\7\22"+
		"\2\2\u01c8\63\3\2\2\2\u01c9\u01ca\b\33\1\2\u01ca\u01d6\5:\36\2\u01cb\u01cc"+
		"\7(\2\2\u01cc\u01d6\5\64\33\13\u01cd\u01ce\7)\2\2\u01ce\u01d6\5\66\34"+
		"\2\u01cf\u01d0\7*\2\2\u01d0\u01d6\5\66\34\2\u01d1\u01d2\7\17\2\2\u01d2"+
		"\u01d3\5\64\33\2\u01d3\u01d4\7\20\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01c9"+
		"\3\2\2\2\u01d5\u01cb\3\2\2\2\u01d5\u01cd\3\2\2\2\u01d5\u01cf\3\2\2\2\u01d5"+
		"\u01d1\3\2\2\2\u01d6\u01e8\3\2\2\2\u01d7\u01d8\f\b\2\2\u01d8\u01d9\7\37"+
		"\2\2\u01d9\u01e7\5\64\33\t\u01da\u01db\f\7\2\2\u01db\u01dc\7+\2\2\u01dc"+
		"\u01e7\5\64\33\b\u01dd\u01de\f\6\2\2\u01de\u01df\7,\2\2\u01df\u01e7\5"+
		"\64\33\7\u01e0\u01e1\f\5\2\2\u01e1\u01e2\7-\2\2\u01e2\u01e7\5\64\33\6"+
		"\u01e3\u01e4\f\4\2\2\u01e4\u01e5\7.\2\2\u01e5\u01e7\5\64\33\5\u01e6\u01d7"+
		"\3\2\2\2\u01e6\u01da\3\2\2\2\u01e6\u01dd\3\2\2\2\u01e6\u01e0\3\2\2\2\u01e6"+
		"\u01e3\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2"+
		"\2\2\u01e9\65\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\b\34\1\2\u01ec\u0200"+
		"\5\64\33\2\u01ed\u01ee\7(\2\2\u01ee\u0200\5\66\34\r\u01ef\u01f0\7/\2\2"+
		"\u01f0\u0200\5\66\34\7\u01f1\u01f2\7\60\2\2\u01f2\u0200\5\66\34\6\u01f3"+
		"\u01f4\7\61\2\2\u01f4\u0200\5\66\34\5\u01f5\u01f6\7\62\2\2\u01f6\u01f7"+
		"\5\66\34\2\u01f7\u01f8\7\63\2\2\u01f8\u01f9\5\66\34\2\u01f9\u01fa\7\64"+
		"\2\2\u01fa\u0200\3\2\2\2\u01fb\u01fc\7\17\2\2\u01fc\u01fd\5\66\34\2\u01fd"+
		"\u01fe\7\20\2\2\u01fe\u0200\3\2\2\2\u01ff\u01eb\3\2\2\2\u01ff\u01ed\3"+
		"\2\2\2\u01ff\u01ef\3\2\2\2\u01ff\u01f1\3\2\2\2\u01ff\u01f3\3\2\2\2\u01ff"+
		"\u01f5\3\2\2\2\u01ff\u01fb\3\2\2\2\u0200\u0212\3\2\2\2\u0201\u0202\f\f"+
		"\2\2\u0202\u0203\7\37\2\2\u0203\u0211\5\66\34\r\u0204\u0205\f\13\2\2\u0205"+
		"\u0206\7+\2\2\u0206\u0211\5\66\34\f\u0207\u0208\f\n\2\2\u0208\u0209\7"+
		",\2\2\u0209\u0211\5\66\34\13\u020a\u020b\f\t\2\2\u020b\u020c\7-\2\2\u020c"+
		"\u0211\5\66\34\n\u020d\u020e\f\b\2\2\u020e\u020f\7.\2\2\u020f\u0211\5"+
		"\66\34\t\u0210\u0201\3\2\2\2\u0210\u0204\3\2\2\2\u0210\u0207\3\2\2\2\u0210"+
		"\u020a\3\2\2\2\u0210\u020d\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2"+
		"\2\2\u0212\u0213\3\2\2\2\u0213\67\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u021a"+
		"\5:\36\2\u0216\u0217\7\6\2\2\u0217\u0219\5:\36\2\u0218\u0216\3\2\2\2\u0219"+
		"\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021e\3\2"+
		"\2\2\u021c\u021a\3\2\2\2\u021d\u0215\3\2\2\2\u021d\u021e\3\2\2\2\u021e"+
		"9\3\2\2\2\u021f\u0220\b\36\1\2\u0220\u0221\7\17\2\2\u0221\u0222\5:\36"+
		"\2\u0222\u0223\7\20\2\2\u0223\u024d\3\2\2\2\u0224\u0225\7\17\2\2\u0225"+
		"\u0228\5:\36\2\u0226\u0227\7\6\2\2\u0227\u0229\5:\36\2\u0228\u0226\3\2"+
		"\2\2\u0229\u022a\3\2\2\2\u022a\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u022d\7\20\2\2\u022d\u024d\3\2\2\2\u022e\u022f\7"+
		"\62\2\2\u022f\u0230\58\35\2\u0230\u0231\7\64\2\2\u0231\u024d\3\2\2\2\u0232"+
		"\u023f\7\21\2\2\u0233\u0234\7U\2\2\u0234\u0235\7\13\2\2\u0235\u023c\5"+
		":\36\2\u0236\u0237\7\6\2\2\u0237\u0238\7U\2\2\u0238\u0239\7\13\2\2\u0239"+
		"\u023b\5:\36\2\u023a\u0236\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023f"+
		"\u0233\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u024d\7\22"+
		"\2\2\u0242\u0243\7\65\2\2\u0243\u024d\5:\36\32\u0244\u0245\7(\2\2\u0245"+
		"\u024d\5:\36\31\u0246\u0247\5> \2\u0247\u0248\7\17\2\2\u0248\u0249\58"+
		"\35\2\u0249\u024a\7\20\2\2\u024a\u024d\3\2\2\2\u024b\u024d\5<\37\2\u024c"+
		"\u021f\3\2\2\2\u024c\u0224\3\2\2\2\u024c\u022e\3\2\2\2\u024c\u0232\3\2"+
		"\2\2\u024c\u0242\3\2\2\2\u024c\u0244\3\2\2\2\u024c\u0246\3\2\2\2\u024c"+
		"\u024b\3\2\2\2\u024d\u0291\3\2\2\2\u024e\u024f\f\25\2\2\u024f\u0250\7"+
		"\66\2\2\u0250\u0290\5:\36\26\u0251\u0252\f\24\2\2\u0252\u0253\7\7\2\2"+
		"\u0253\u0290\5:\36\25\u0254\u0255\f\23\2\2\u0255\u0256\7\67\2\2\u0256"+
		"\u0290\5:\36\24\u0257\u0258\f\22\2\2\u0258\u0259\78\2\2\u0259\u0290\5"+
		":\36\23\u025a\u025b\f\21\2\2\u025b\u025c\7\65\2\2\u025c\u0290\5:\36\22"+
		"\u025d\u025e\f\20\2\2\u025e\u025f\7\25\2\2\u025f\u0290\5:\36\21\u0260"+
		"\u0261\f\17\2\2\u0261\u0262\79\2\2\u0262\u0290\5:\36\20\u0263\u0264\f"+
		"\16\2\2\u0264\u0265\7\26\2\2\u0265\u0290\5:\36\17\u0266\u0267\f\r\2\2"+
		"\u0267\u0268\7:\2\2\u0268\u0290\5:\36\16\u0269\u026a\f\f\2\2\u026a\u026b"+
		"\7;\2\2\u026b\u0290\5:\36\r\u026c\u026d\f\13\2\2\u026d\u026e\7<\2\2\u026e"+
		"\u0290\5:\36\f\u026f\u0270\f\n\2\2\u0270\u0271\7=\2\2\u0271\u0290\5:\36"+
		"\13\u0272\u0273\f\t\2\2\u0273\u0274\7>\2\2\u0274\u0290\5:\36\n\u0275\u0276"+
		"\f\b\2\2\u0276\u0277\7?\2\2\u0277\u0290\5:\36\t\u0278\u0279\f\7\2\2\u0279"+
		"\u027a\7-\2\2\u027a\u0290\5:\36\b\u027b\u027c\f\6\2\2\u027c\u027d\7@\2"+
		"\2\u027d\u0290\5:\36\7\u027e\u027f\f\5\2\2\u027f\u0280\7.\2\2\u0280\u0290"+
		"\5:\36\6\u0281\u0282\f\4\2\2\u0282\u0283\7A\2\2\u0283\u0284\5:\36\2\u0284"+
		"\u0285\7\31\2\2\u0285\u0286\5:\36\5\u0286\u0290\3\2\2\2\u0287\u0288\f"+
		"\27\2\2\u0288\u0289\7\62\2\2\u0289\u028a\5:\36\2\u028a\u028b\7\64\2\2"+
		"\u028b\u0290\3\2\2\2\u028c\u028d\f\26\2\2\u028d\u028e\7\n\2\2\u028e\u0290"+
		"\7U\2\2\u028f\u024e\3\2\2\2\u028f\u0251\3\2\2\2\u028f\u0254\3\2\2\2\u028f"+
		"\u0257\3\2\2\2\u028f\u025a\3\2\2\2\u028f\u025d\3\2\2\2\u028f\u0260\3\2"+
		"\2\2\u028f\u0263\3\2\2\2\u028f\u0266\3\2\2\2\u028f\u0269\3\2\2\2\u028f"+
		"\u026c\3\2\2\2\u028f\u026f\3\2\2\2\u028f\u0272\3\2\2\2\u028f\u0275\3\2"+
		"\2\2\u028f\u0278\3\2\2\2\u028f\u027b\3\2\2\2\u028f\u027e\3\2\2\2\u028f"+
		"\u0281\3\2\2\2\u028f\u0287\3\2\2\2\u028f\u028c\3\2\2\2\u0290\u0293\3\2"+
		"\2\2\u0291\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292;\3\2\2\2\u0293\u0291"+
		"\3\2\2\2\u0294\u029f\7P\2\2\u0295\u029f\7Q\2\2\u0296\u029f\7R\2\2\u0297"+
		"\u029f\7S\2\2\u0298\u0299\5B\"\2\u0299\u029a\7\n\2\2\u029a\u029b\7T\2"+
		"\2\u029b\u029f\3\2\2\2\u029c\u029f\5B\"\2\u029d\u029f\7B\2\2\u029e\u0294"+
		"\3\2\2\2\u029e\u0295\3\2\2\2\u029e\u0296\3\2\2\2\u029e\u0297\3\2\2\2\u029e"+
		"\u0298\3\2\2\2\u029e\u029c\3\2\2\2\u029e\u029d\3\2\2\2\u029f=\3\2\2\2"+
		"\u02a0\u02a1\b \1\2\u02a1\u02a2\7\17\2\2\u02a2\u02a3\5> \2\u02a3\u02a4"+
		"\7\20\2\2\u02a4\u02e2\3\2\2\2\u02a5\u02a6\7\17\2\2\u02a6\u02a9\5> \2\u02a7"+
		"\u02a8\7\6\2\2\u02a8\u02aa\5> \2\u02a9\u02a7\3\2\2\2\u02aa\u02ab\3\2\2"+
		"\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae"+
		"\7\20\2\2\u02ae\u02e2\3\2\2\2\u02af\u02e2\7C\2\2\u02b0\u02b1\7C\2\2\u02b1"+
		"\u02b2\5:\36\2\u02b2\u02b3\7D\2\2\u02b3\u02b4\5:\36\2\u02b4\u02e2\3\2"+
		"\2\2\u02b5\u02e2\7E\2\2\u02b6\u02e2\7F\2\2\u02b7\u02e2\7G\2\2\u02b8\u02b9"+
		"\7H\2\2\u02b9\u02ba\7\21\2\2\u02ba\u02bf\7U\2\2\u02bb\u02bc\7\6\2\2\u02bc"+
		"\u02be\7U\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c1\3\2\2\2\u02bf\u02bd\3\2"+
		"\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c2"+
		"\u02e2\7\22\2\2\u02c3\u02c4\7I\2\2\u02c4\u02ca\7\21\2\2\u02c5\u02c6\7"+
		"U\2\2\u02c6\u02c7\7\31\2\2\u02c7\u02c8\5> \2\u02c8\u02c9\7\4\2\2\u02c9"+
		"\u02cb\3\2\2\2\u02ca\u02c5\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ca\3\2"+
		"\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u02cf\7\22\2\2\u02cf"+
		"\u02e2\3\2\2\2\u02d0\u02e2\7K\2\2\u02d1\u02e2\7L\2\2\u02d2\u02e2\5B\""+
		"\2\u02d3\u02df\5B\"\2\u02d4\u02d5\7\25\2\2\u02d5\u02da\5@!\2\u02d6\u02d7"+
		"\7\6\2\2\u02d7\u02d9\5@!\2\u02d8\u02d6\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da"+
		"\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dd\3\2\2\2\u02dc\u02da\3\2"+
		"\2\2\u02dd\u02de\7\26\2\2\u02de\u02e0\3\2\2\2\u02df\u02d4\3\2\2\2\u02df"+
		"\u02e0\3\2\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02a0\3\2\2\2\u02e1\u02a5\3\2"+
		"\2\2\u02e1\u02af\3\2\2\2\u02e1\u02b0\3\2\2\2\u02e1\u02b5\3\2\2\2\u02e1"+
		"\u02b6\3\2\2\2\u02e1\u02b7\3\2\2\2\u02e1\u02b8\3\2\2\2\u02e1\u02c3\3\2"+
		"\2\2\u02e1\u02d0\3\2\2\2\u02e1\u02d1\3\2\2\2\u02e1\u02d2\3\2\2\2\u02e1"+
		"\u02d3\3\2\2\2\u02e2\u02f1\3\2\2\2\u02e3\u02e4\f\7\2\2\u02e4\u02e5\7@"+
		"\2\2\u02e5\u02f0\5> \b\u02e6\u02e7\f\t\2\2\u02e7\u02e9\7\62\2\2\u02e8"+
		"\u02ea\5:\36\2\u02e9\u02e8\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2"+
		"\2\2\u02eb\u02f0\7\64\2\2\u02ec\u02ed\f\b\2\2\u02ed\u02ee\7J\2\2\u02ee"+
		"\u02f0\5:\36\2\u02ef\u02e3\3\2\2\2\u02ef\u02e6\3\2\2\2\u02ef\u02ec\3\2"+
		"\2\2\u02f0\u02f3\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2"+
		"?\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f4\u02f7\5> \2\u02f5\u02f7\5<\37\2\u02f6"+
		"\u02f4\3\2\2\2\u02f6\u02f5\3\2\2\2\u02f7A\3\2\2\2\u02f8\u02f9\7U\2\2\u02f9"+
		"\u02fb\7\n\2\2\u02fa\u02f8\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3\2"+
		"\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02ff\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff"+
		"\u0300\7U\2\2\u0300C\3\2\2\2OIKZ_cmt{\u0086\u0098\u00a0\u00a2\u00a8\u00ad"+
		"\u00b6\u00bd\u00c1\u00c9\u00d4\u00dd\u00e1\u00e3\u00e8\u00ec\u00f3\u00fe"+
		"\u0101\u0108\u0114\u0117\u0120\u012a\u0136\u013d\u0141\u014c\u0155\u015f"+
		"\u0161\u0166\u016f\u017a\u0186\u0190\u019d\u01a4\u01ae\u01b0\u01b5\u01c2"+
		"\u01c5\u01d5\u01e6\u01e8\u01ff\u0210\u0212\u021a\u021d\u022a\u023c\u023f"+
		"\u024c\u028f\u0291\u029e\u02ab\u02bf\u02cc\u02da\u02df\u02e1\u02e9\u02ef"+
		"\u02f1\u02f6\u02fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
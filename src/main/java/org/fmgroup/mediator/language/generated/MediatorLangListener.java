// Generated from /Users/liyi/Dropbox/Projects/Mediator/src-antlr/MediatorLang.g4 by ANTLR 4.7
package org.fmgroup.mediator.language.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MediatorLangParser}.
 */
public interface MediatorLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MediatorLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MediatorLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#dependency}.
	 * @param ctx the parse tree
	 */
	void enterDependency(MediatorLangParser.DependencyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#dependency}.
	 * @param ctx the parse tree
	 */
	void exitDependency(MediatorLangParser.DependencyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#typedef}.
	 * @param ctx the parse tree
	 */
	void enterTypedef(MediatorLangParser.TypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#typedef}.
	 * @param ctx the parse tree
	 */
	void exitTypedef(MediatorLangParser.TypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#portIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPortIdentifier(MediatorLangParser.PortIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#portIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPortIdentifier(MediatorLangParser.PortIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MediatorLangParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MediatorLangParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code synchronizingStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizingStatement(MediatorLangParser.SynchronizingStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code synchronizingStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizingStatement(MediatorLangParser.SynchronizingStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MediatorLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MediatorLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iteStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIteStatement(MediatorLangParser.IteStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iteStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIteStatement(MediatorLangParser.IteStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assertStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(MediatorLangParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assertStatement}
	 * labeled alternative in {@link MediatorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(MediatorLangParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MediatorLangParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MediatorLangParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#template}.
	 * @param ctx the parse tree
	 */
	void enterTemplate(MediatorLangParser.TemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#template}.
	 * @param ctx the parse tree
	 */
	void exitTemplate(MediatorLangParser.TemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MediatorLangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MediatorLangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#localVariableDef}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDef(MediatorLangParser.LocalVariableDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#localVariableDef}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDef(MediatorLangParser.LocalVariableDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#functionInterface}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInterface(MediatorLangParser.FunctionInterfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#functionInterface}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInterface(MediatorLangParser.FunctionInterfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#portsDecl}.
	 * @param ctx the parse tree
	 */
	void enterPortsDecl(MediatorLangParser.PortsDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#portsDecl}.
	 * @param ctx the parse tree
	 */
	void exitPortsDecl(MediatorLangParser.PortsDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#entityInterface}.
	 * @param ctx the parse tree
	 */
	void enterEntityInterface(MediatorLangParser.EntityInterfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#entityInterface}.
	 * @param ctx the parse tree
	 */
	void exitEntityInterface(MediatorLangParser.EntityInterfaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#variableSegment}.
	 * @param ctx the parse tree
	 */
	void enterVariableSegment(MediatorLangParser.VariableSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#variableSegment}.
	 * @param ctx the parse tree
	 */
	void exitVariableSegment(MediatorLangParser.VariableSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#transitionSegment}.
	 * @param ctx the parse tree
	 */
	void enterTransitionSegment(MediatorLangParser.TransitionSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#transitionSegment}.
	 * @param ctx the parse tree
	 */
	void exitTransitionSegment(MediatorLangParser.TransitionSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transitionSingle}
	 * labeled alternative in {@link MediatorLangParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransitionSingle(MediatorLangParser.TransitionSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transitionSingle}
	 * labeled alternative in {@link MediatorLangParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransitionSingle(MediatorLangParser.TransitionSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code transitionGroup}
	 * labeled alternative in {@link MediatorLangParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransitionGroup(MediatorLangParser.TransitionGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code transitionGroup}
	 * labeled alternative in {@link MediatorLangParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransitionGroup(MediatorLangParser.TransitionGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#propertySegment}.
	 * @param ctx the parse tree
	 */
	void enterPropertySegment(MediatorLangParser.PropertySegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#propertySegment}.
	 * @param ctx the parse tree
	 */
	void exitPropertySegment(MediatorLangParser.PropertySegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(MediatorLangParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(MediatorLangParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(MediatorLangParser.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(MediatorLangParser.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#componentSegment}.
	 * @param ctx the parse tree
	 */
	void enterComponentSegment(MediatorLangParser.ComponentSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#componentSegment}.
	 * @param ctx the parse tree
	 */
	void exitComponentSegment(MediatorLangParser.ComponentSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#internalSegment}.
	 * @param ctx the parse tree
	 */
	void enterInternalSegment(MediatorLangParser.InternalSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#internalSegment}.
	 * @param ctx the parse tree
	 */
	void exitInternalSegment(MediatorLangParser.InternalSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#connectionSegment}.
	 * @param ctx the parse tree
	 */
	void enterConnectionSegment(MediatorLangParser.ConnectionSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#connectionSegment}.
	 * @param ctx the parse tree
	 */
	void exitConnectionSegment(MediatorLangParser.ConnectionSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#componentDecl}.
	 * @param ctx the parse tree
	 */
	void enterComponentDecl(MediatorLangParser.ComponentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#componentDecl}.
	 * @param ctx the parse tree
	 */
	void exitComponentDecl(MediatorLangParser.ComponentDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customConnection}
	 * labeled alternative in {@link MediatorLangParser#connectionDecl}.
	 * @param ctx the parse tree
	 */
	void enterCustomConnection(MediatorLangParser.CustomConnectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customConnection}
	 * labeled alternative in {@link MediatorLangParser#connectionDecl}.
	 * @param ctx the parse tree
	 */
	void exitCustomConnection(MediatorLangParser.CustomConnectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicConnection}
	 * labeled alternative in {@link MediatorLangParser#connectionDecl}.
	 * @param ctx the parse tree
	 */
	void enterBasicConnection(MediatorLangParser.BasicConnectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicConnection}
	 * labeled alternative in {@link MediatorLangParser#connectionDecl}.
	 * @param ctx the parse tree
	 */
	void exitBasicConnection(MediatorLangParser.BasicConnectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#portCollection}.
	 * @param ctx the parse tree
	 */
	void enterPortCollection(MediatorLangParser.PortCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#portCollection}.
	 * @param ctx the parse tree
	 */
	void exitPortCollection(MediatorLangParser.PortCollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#connectionOptions}.
	 * @param ctx the parse tree
	 */
	void enterConnectionOptions(MediatorLangParser.ConnectionOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#connectionOptions}.
	 * @param ctx the parse tree
	 */
	void exitConnectionOptions(MediatorLangParser.ConnectionOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#connectionOption}.
	 * @param ctx the parse tree
	 */
	void enterConnectionOption(MediatorLangParser.ConnectionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#connectionOption}.
	 * @param ctx the parse tree
	 */
	void exitConnectionOption(MediatorLangParser.ConnectionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#connectionOptionItem}.
	 * @param ctx the parse tree
	 */
	void enterConnectionOptionItem(MediatorLangParser.ConnectionOptionItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#connectionOptionItem}.
	 * @param ctx the parse tree
	 */
	void exitConnectionOptionItem(MediatorLangParser.ConnectionOptionItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(MediatorLangParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(MediatorLangParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#meta}.
	 * @param ctx the parse tree
	 */
	void enterMeta(MediatorLangParser.MetaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#meta}.
	 * @param ctx the parse tree
	 */
	void exitMeta(MediatorLangParser.MetaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterNotPathFormulae(MediatorLangParser.NotPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitNotPathFormulae(MediatorLangParser.NotPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existsPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterExistsPathFormulae(MediatorLangParser.ExistsPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existsPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitExistsPathFormulae(MediatorLangParser.ExistsPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterBracketPathFormulae(MediatorLangParser.BracketPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitBracketPathFormulae(MediatorLangParser.BracketPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterAllPathFormulae(MediatorLangParser.AllPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitAllPathFormulae(MediatorLangParser.AllPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterBinaryPathFormulae(MediatorLangParser.BinaryPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitBinaryPathFormulae(MediatorLangParser.BinaryPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomicPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void enterAtomicPathFormulae(MediatorLangParser.AtomicPathFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomicPathFormulae}
	 * labeled alternative in {@link MediatorLangParser#pathFormulae}.
	 * @param ctx the parse tree
	 */
	void exitAtomicPathFormulae(MediatorLangParser.AtomicPathFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterNotStateFormulae(MediatorLangParser.NotStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitNotStateFormulae(MediatorLangParser.NotStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pathStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterPathStateFormulae(MediatorLangParser.PathStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitPathStateFormulae(MediatorLangParser.PathStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globallyStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterGloballyStateFormulae(MediatorLangParser.GloballyStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globallyStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitGloballyStateFormulae(MediatorLangParser.GloballyStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterBinaryStateFormulae(MediatorLangParser.BinaryStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitBinaryStateFormulae(MediatorLangParser.BinaryStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterBracketStateFormulae(MediatorLangParser.BracketStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitBracketStateFormulae(MediatorLangParser.BracketStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code finallyStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterFinallyStateFormulae(MediatorLangParser.FinallyStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code finallyStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitFinallyStateFormulae(MediatorLangParser.FinallyStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nextStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterNextStateFormulae(MediatorLangParser.NextStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nextStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitNextStateFormulae(MediatorLangParser.NextStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void enterUntilStateFormulae(MediatorLangParser.UntilStateFormulaeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilStateFormulae}
	 * labeled alternative in {@link MediatorLangParser#stateFormulae}.
	 * @param ctx the parse tree
	 */
	void exitUntilStateFormulae(MediatorLangParser.UntilStateFormulaeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(MediatorLangParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(MediatorLangParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterValueTerm(MediatorLangParser.ValueTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitValueTerm(MediatorLangParser.ValueTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iteTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIteTerm(MediatorLangParser.IteTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iteTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIteTerm(MediatorLangParser.IteTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOprTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOprTerm(MediatorLangParser.BinaryOprTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOprTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOprTerm(MediatorLangParser.BinaryOprTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elementTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterElementTerm(MediatorLangParser.ElementTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elementTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitElementTerm(MediatorLangParser.ElementTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBracketTerm(MediatorLangParser.BracketTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBracketTerm(MediatorLangParser.BracketTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterStructTerm(MediatorLangParser.StructTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitStructTerm(MediatorLangParser.StructTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTupleTerm(MediatorLangParser.TupleTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTupleTerm(MediatorLangParser.TupleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleOprTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSingleOprTerm(MediatorLangParser.SingleOprTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleOprTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSingleOprTerm(MediatorLangParser.SingleOprTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterListTerm(MediatorLangParser.ListTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitListTerm(MediatorLangParser.ListTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterCallTerm(MediatorLangParser.CallTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitCallTerm(MediatorLangParser.CallTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFieldTerm(MediatorLangParser.FieldTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldTerm}
	 * labeled alternative in {@link MediatorLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFieldTerm(MediatorLangParser.FieldTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(MediatorLangParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(MediatorLangParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(MediatorLangParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(MediatorLangParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStrValue(MediatorLangParser.StrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStrValue(MediatorLangParser.StrValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(MediatorLangParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(MediatorLangParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code portVarValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterPortVarValue(MediatorLangParser.PortVarValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code portVarValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitPortVarValue(MediatorLangParser.PortVarValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIdValue(MediatorLangParser.IdValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIdValue(MediatorLangParser.IdValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(MediatorLangParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link MediatorLangParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(MediatorLangParser.NullValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBracketType(MediatorLangParser.BracketTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBracketType(MediatorLangParser.BracketTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCharType(MediatorLangParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCharType(MediatorLangParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterDoubleType(MediatorLangParser.DoubleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitDoubleType(MediatorLangParser.DoubleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code templateType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTemplateType(MediatorLangParser.TemplateTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code templateType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTemplateType(MediatorLangParser.TemplateTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIdType(MediatorLangParser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIdType(MediatorLangParser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code abstractType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterAbstractType(MediatorLangParser.AbstractTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code abstractType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitAbstractType(MediatorLangParser.AbstractTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(MediatorLangParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(MediatorLangParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterEnumType(MediatorLangParser.EnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitEnumType(MediatorLangParser.EnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(MediatorLangParser.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(MediatorLangParser.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterInitType(MediatorLangParser.InitTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitInitType(MediatorLangParser.InitTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterListType(MediatorLangParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitListType(MediatorLangParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(MediatorLangParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(MediatorLangParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boundedIntType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoundedIntType(MediatorLangParser.BoundedIntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boundedIntType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoundedIntType(MediatorLangParser.BoundedIntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStructType(MediatorLangParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStructType(MediatorLangParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNullType(MediatorLangParser.NullTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNullType(MediatorLangParser.NullTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterUnionType(MediatorLangParser.UnionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionType}
	 * labeled alternative in {@link MediatorLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitUnionType(MediatorLangParser.UnionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#typeorvalue}.
	 * @param ctx the parse tree
	 */
	void enterTypeorvalue(MediatorLangParser.TypeorvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#typeorvalue}.
	 * @param ctx the parse tree
	 */
	void exitTypeorvalue(MediatorLangParser.TypeorvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MediatorLangParser#scopedID}.
	 * @param ctx the parse tree
	 */
	void enterScopedID(MediatorLangParser.ScopedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link MediatorLangParser#scopedID}.
	 * @param ctx the parse tree
	 */
	void exitScopedID(MediatorLangParser.ScopedIDContext ctx);
}
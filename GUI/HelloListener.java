package GitAntlrIDE.GUI;

// Generated from Hello.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(HelloParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(HelloParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HelloParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HelloParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(HelloParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(HelloParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(HelloParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(HelloParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(HelloParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(HelloParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(HelloParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(HelloParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(HelloParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(HelloParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(HelloParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(HelloParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(HelloParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(HelloParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HelloParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HelloParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HelloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HelloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(HelloParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(HelloParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(HelloParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(HelloParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#returnBlock}.
	 * @param ctx the parse tree
	 */
	void enterReturnBlock(HelloParser.ReturnBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#returnBlock}.
	 * @param ctx the parse tree
	 */
	void exitReturnBlock(HelloParser.ReturnBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(HelloParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(HelloParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(HelloParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(HelloParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#myIf}.
	 * @param ctx the parse tree
	 */
	void enterMyIf(HelloParser.MyIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#myIf}.
	 * @param ctx the parse tree
	 */
	void exitMyIf(HelloParser.MyIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(HelloParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(HelloParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(HelloParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(HelloParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#dotLocation}.
	 * @param ctx the parse tree
	 */
	void enterDotLocation(HelloParser.DotLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#dotLocation}.
	 * @param ctx the parse tree
	 */
	void exitDotLocation(HelloParser.DotLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#declaredVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaredVariable(HelloParser.DeclaredVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declaredVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaredVariable(HelloParser.DeclaredVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(HelloParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(HelloParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariable(HelloParser.ArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arrayVariable}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariable(HelloParser.ArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#expressionInP}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInP(HelloParser.ExpressionInPContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expressionInP}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInP(HelloParser.ExpressionInPContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#nExpression}.
	 * @param ctx the parse tree
	 */
	void enterNExpression(HelloParser.NExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#nExpression}.
	 * @param ctx the parse tree
	 */
	void exitNExpression(HelloParser.NExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(HelloParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(HelloParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpression(HelloParser.EqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#equalsExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpression(HelloParser.EqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpression(HelloParser.RelationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#relationExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpression(HelloParser.RelationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#addSubsExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubsExpression(HelloParser.AddSubsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#addSubsExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubsExpression(HelloParser.AddSubsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#mulDivExpression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpression(HelloParser.MulDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#mulDivExpression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpression(HelloParser.MulDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#prExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrExpression(HelloParser.PrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#prExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrExpression(HelloParser.PrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpression(HelloParser.BasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpression(HelloParser.BasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasic(HelloParser.BasicContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasic(HelloParser.BasicContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(HelloParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(HelloParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(HelloParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(HelloParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#as_op}.
	 * @param ctx the parse tree
	 */
	void enterAs_op(HelloParser.As_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#as_op}.
	 * @param ctx the parse tree
	 */
	void exitAs_op(HelloParser.As_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#md_op}.
	 * @param ctx the parse tree
	 */
	void enterMd_op(HelloParser.Md_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#md_op}.
	 * @param ctx the parse tree
	 */
	void exitMd_op(HelloParser.Md_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#pr_op}.
	 * @param ctx the parse tree
	 */
	void enterPr_op(HelloParser.Pr_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#pr_op}.
	 * @param ctx the parse tree
	 */
	void exitPr_op(HelloParser.Pr_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(HelloParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(HelloParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(HelloParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(HelloParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(HelloParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(HelloParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(HelloParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(HelloParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(HelloParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(HelloParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(HelloParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(HelloParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(HelloParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(HelloParser.Bool_literalContext ctx);
}
package GitAntlrIDE.GUI;

// Generated from Hello.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(HelloParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(HelloParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(HelloParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(HelloParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(HelloParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(HelloParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(HelloParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(HelloParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(HelloParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HelloParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HelloParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#assignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignation(HelloParser.AssignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#whileBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBlock(HelloParser.WhileBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#returnBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnBlock(HelloParser.ReturnBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(HelloParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(HelloParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#myIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyIf(HelloParser.MyIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(HelloParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(HelloParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#dotLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotLocation(HelloParser.DotLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#declaredVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredVariable(HelloParser.DeclaredVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HelloParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#arrayVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariable(HelloParser.ArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#expressionInP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInP(HelloParser.ExpressionInPContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#nExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNExpression(HelloParser.NExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(HelloParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#equalsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsExpression(HelloParser.EqualsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#relationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(HelloParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#addSubsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubsExpression(HelloParser.AddSubsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#mulDivExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(HelloParser.MulDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#prExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrExpression(HelloParser.PrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpression(HelloParser.BasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasic(HelloParser.BasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(HelloParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(HelloParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#as_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_op(HelloParser.As_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#md_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMd_op(HelloParser.Md_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#pr_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPr_op(HelloParser.Pr_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(HelloParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(HelloParser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(HelloParser.Cond_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(HelloParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(HelloParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(HelloParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(HelloParser.Bool_literalContext ctx);
}
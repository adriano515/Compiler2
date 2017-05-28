package GitAntlrIDE.GUI;

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class Icg extends HelloBaseVisitor<String>{

	public Map<String, Map<String, String[]>> mapTree = new HashMap<String ,Map<String, String[]>>();
	public Map<String, String[]> quadruple = new LinkedHashMap<String, String[]>();
	public Map<String, String> icgTable = new LinkedHashMap<String, String>();
	
	public int lineCounter;
	public int tempCounter;
	public int whileCounter;
	public int condCounter;
	public int ifCounter;
	
	
	public Icg(Map<String, Map<String, String[]>> mapTree){
		this.mapTree = mapTree;
		lineCounter = 0;
		tempCounter = 0;
		whileCounter = 0;
		
	}
	@Override 
	public String visitProgram(HelloParser.ProgramContext ctx) { 
		visitChildren(ctx);
		quadruple2Icg();
		return "done x 2";
	}
	@Override 
	public String visitDeclaration(HelloParser.DeclarationContext ctx) { 
				//System.out.println("I visited declaration");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitVarDeclaration(HelloParser.VarDeclarationContext ctx) { 
		
				//System.out.println("I visited varDeclaration");
				
				return visitChildren(ctx); 
	}
	@Override 
	public String visitStructDeclaration(HelloParser.StructDeclarationContext ctx) { 
				//System.out.println("I visited StructDeclaration");
				
				return visitChildren(ctx);
	}
	@Override 
	public String visitVarType(HelloParser.VarTypeContext ctx) { 
				//System.out.println("I visited varType");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMethodDeclaration(HelloParser.MethodDeclarationContext ctx) { 
				//System.out.println("I visited " + ctx.getText());
				String[] quadLine = {"FUNCTION ", ctx.getChild(1).getText() + ":"};
				quadruple.put(lineCounter + "", quadLine);
				lineCounter ++;
				visit(ctx.getChild(ctx.getChildCount() - 1));
				String[] quadLine2 = {"END FUNCTION ", ctx.getChild(1).getText()};
				quadruple.put(lineCounter + "", quadLine2);
				lineCounter ++;
				return "";
	}
	@Override 
	public String visitMethodType(HelloParser.MethodTypeContext ctx) { 
				//System.out.println("I visited methodType");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitParameter(HelloParser.ParameterContext ctx) { 
				//System.out.println("I visited Parameter");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitParameterType(HelloParser.ParameterTypeContext ctx) { 
				//System.out.println("I visited parameterType");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitBlock(HelloParser.BlockContext ctx) { 
				//System.out.println("I visited Block");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitStatement(HelloParser.StatementContext ctx) { 
				//System.out.println("I visited statement" + ctx.getText());
				return visitChildren(ctx); 
	}
	@Override 
	public String visitAssignation(HelloParser.AssignationContext ctx) { 
		//System.out.println("I visited " + ctx.getText());
				//System.out.println("I visited assignation");
				String temp = visit(ctx.getChild(2));
				if(temp.equals("method")){
					String[] quadLine = {ctx.getChild(1).getText(), "t" + (tempCounter - 1) ,
							null, ctx.getChild(0).getText()};
					quadruple.put(lineCounter + "", quadLine);
				}
				else{
					String[] quadLine = {ctx.getChild(1).getText(), temp,
							null, ctx.getChild(0).getText()};
					quadruple.put(lineCounter + "", quadLine);
				}
				
				lineCounter ++;
			return null;
				
	}
	@Override 
	public String visitWhileBlock(HelloParser.WhileBlockContext ctx) { 
		//System.out.println("I visited " + ctx.getText());
				//System.out.println("I visited while");
		//TODO
				int localWhile = whileCounter;
				String[] quadLine = {"STARTWHILE_" + localWhile +":"};
				quadruple.put(lineCounter + "", quadLine);
				whileCounter ++;
				lineCounter ++;
				
				String temp = visit(ctx.getChild(2));
				String[] quadLine2 = {"IF " + temp + " > 0 ", "GOTO LABEL_TRUE_" + condCounter};
				String[] quadLine3 = {"GOTO " + "ENDWHILE_" + localWhile };
				String[] quadLine4 = {"LABEL_TRUE_" + condCounter + ":"};
				
				quadruple.put(lineCounter + "", quadLine2);
				lineCounter ++;
				quadruple.put(lineCounter + "", quadLine3);
				lineCounter ++;
				quadruple.put(lineCounter + "", quadLine4);
				lineCounter ++;	
				condCounter ++;
				
				visit(ctx.getChild(ctx.getChildCount() - 1));
				String[] quadLine5 = {"GOTO " + "STARTWHILE_" + localWhile};
				quadruple.put(lineCounter + "", quadLine5);
				lineCounter ++;
				
				String[] quadLine6 = {"ENDWHILE_" + localWhile};
				quadruple.put(lineCounter + "", quadLine6);
				lineCounter ++;
				return "";
	}
	@Override 
	public String visitReturnBlock(HelloParser.ReturnBlockContext ctx) { 
		//System.out.println("I visited " + ctx.getText());
				//System.out.println("I visited returnBlock");
				String[] quadLine = {"RETURN ",ctx.getChild(1).getText()};
				quadruple.put(lineCounter + "", quadLine);
				lineCounter ++;
				return visit(ctx.getChild(1)); 
	}
	@Override 
	public String visitPrint(HelloParser.PrintContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitScan(HelloParser.ScanContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMyIf(HelloParser.MyIfContext ctx) { 
				//System.out.println("I visited if");
					String temp = visit(ctx.getChild(2));
					String[] quadLine = {"IF " + temp + " > 0 ", "GOTO LABEL_TRUE_" + condCounter};
					String[] quadLine2 = {"GOTO " + "LABEL_FALSE_" + condCounter };
					String[] quadLine3 = {"LABEL_TRUE_" + condCounter + ":"};
					
					quadruple.put(lineCounter + "", quadLine);
					lineCounter ++;
					quadruple.put(lineCounter + "", quadLine2);
					lineCounter ++;
					quadruple.put(lineCounter + "", quadLine3);
					lineCounter ++;	
					
					
					temp = visit(ctx.getChild(4));
					int localIf = ifCounter;
					String[] quadLine4 = {"GOTO " + "ENDIF_" + localIf};
					quadruple.put(lineCounter + "", quadLine4);
					lineCounter ++;
					ifCounter++;
					
					String[] quadLine5 = {"LABEL_FALSE_" + condCounter + ":"};
					quadruple.put(lineCounter + "", quadLine5);
					lineCounter ++;
					condCounter ++;
					if(ctx.getChildCount() >= 6){
						visit(ctx.getChild(5));
					}
					String[] quadLine6 = {"ENDIF_ " + localIf};
					quadruple.put(lineCounter + "", quadLine6);
					lineCounter ++;
					
					
					
					//visitChildren(ctx);
					return "";
				
				//whilevisitChildren(ctx);
	}
	@Override 
	public String visitElseBlock(HelloParser.ElseBlockContext ctx) { 
				//System.out.println("I visited else");
				
				return visitChildren(ctx);
	}
	@Override 
	public String visitLocation(HelloParser.LocationContext ctx) { 
				//System.out.println("I visited location");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitDotLocation(HelloParser.DotLocationContext ctx) { 
				//System.out.println("I visited dotLocation");
				
				return visitChildren(ctx);
				
				
	}
	@Override 
	public String visitDeclaredVariable(HelloParser.DeclaredVariableContext ctx) { 
				//System.out.println("I visited declaredVariable");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitVariable(HelloParser.VariableContext ctx) { 
				//System.out.println("I visited variable");
				
				return ctx.getChild(0).getText();
				
				
	}
	@Override 
	public String visitArrayVariable(HelloParser.ArrayVariableContext ctx) { 
				//System.out.println("I visited ");
		//TODO
				return visitChildren(ctx); 
	}
	@Override 
	public String visitExpressionInP(HelloParser.ExpressionInPContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitNExpression(HelloParser.NExpressionContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitExpression(HelloParser.ExpressionContext ctx) { 
				//System.out.println("I visited Expression");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitAndExpression(HelloParser.AndExpressionContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitEqualsExpression(HelloParser.EqualsExpressionContext ctx) { 
				//System.out.println("I visited equals");
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			
			String[] quadLine = {temp1, temp2,
					temp3, "t" + tempCounter};
			quadruple.put(lineCounter + "", quadLine);
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
				return visit(ctx.getChild(0));
	}
	@Override 
	public String visitRelationExpression(HelloParser.RelationExpressionContext ctx) { 
				//System.out.println("I visited relation");
			if(ctx.children.size() >= 2){
				String[] quadLine = {visit(ctx.getChild(1)), visit(ctx.getChild(0)),
						visit(ctx.getChild(2)), "t" + tempCounter};
				quadruple.put(lineCounter + "", quadLine);
				tempCounter ++;
				lineCounter ++;
				//visitChildren(ctx);
				return "t" + (tempCounter - 1);
			}
				return visit(ctx.getChild(0));
	}
	@Override 
	public String visitAddSubsExpression(HelloParser.AddSubsExpressionContext ctx) { 
		//System.out.println("I visited " + ctx.getText());
				//System.out.println("I visited add/sub expression");
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			
			String[] quadLine = {temp1, temp2,
					temp3, "t" + tempCounter};
			quadruple.put(lineCounter + "", quadLine);
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
				return visit(ctx.getChild(0));
				
	}
	@Override 
	public String visitMulDivExpression(HelloParser.MulDivExpressionContext ctx) { 
				//System.out.println("I visited mul/div");
		if(ctx.children.size() >= 2){
			String temp1 = visit(ctx.getChild(1));
			String temp2 = visit(ctx.getChild(0));
			String temp3 = visit(ctx.getChild(2));
			
			if(temp2.equals("method") && temp3.equals("method")){
				temp2 = "t" + (tempCounter - 1);
				temp3 = "t" + (tempCounter - 2);
			}
			else if(temp2.equals("method"))
				temp2 = "t" + (tempCounter - 1);
			else if(temp3.equals("method"))
				temp3 = "t" + (tempCounter - 1);
			
			String[] quadLine = {temp1, temp2,
					temp3, "t" + tempCounter};
			quadruple.put(lineCounter + "", quadLine);
			tempCounter ++;
			lineCounter ++;
			//visitChildren(ctx);
			return "t" + (tempCounter - 1);
		}
				return visit(ctx.getChild(0));			
	}
	@Override 
	public String visitPrExpression(HelloParser.PrExpressionContext ctx) { 
				//System.out.println("I visited PRexpression");
				
				return visitChildren(ctx); 
	}
	@Override 
	public String visitBasicExpression(HelloParser.BasicExpressionContext ctx) { 
				//System.out.println("I visited " + ctx.getText());
				return visitChildren(ctx); 
	}
	@Override 
	public String visitBasic(HelloParser.BasicContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitArg(HelloParser.ArgContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMethodCall(HelloParser.MethodCallContext ctx) { 
		//System.out.println("I visited " + ctx.getText());
				//System.out.println("I visited methodCall" + ctx.getText());
		
				if(ctx.getChildCount() - 3 > 0){
					String param = "";
					for(int i = 2; i < ctx.getChildCount() - 1; i++ ){
						param = param + ", " + ctx.getChild(i).getText();
					}
					String[] quadLine2 = {"PARAM ", param};
					quadruple.put(lineCounter + "", quadLine2);
					lineCounter ++;
				}
				String[] quadLine = {"CALL ", ctx.getChild(0).getText() + ",",
						(ctx.getChildCount() - 3) + ""};
				quadruple.put(lineCounter + "", quadLine);
				lineCounter ++;
				
				//check ST to see if return != void || null
				String[] quadLine3 = {"=", "R",null, "t" + tempCounter};
				quadruple.put(lineCounter + "", quadLine3);
				tempCounter ++;
				lineCounter ++;
				
				
				
				
				return "method";
	}
	@Override 
	public String visitAs_op(HelloParser.As_opContext ctx) { 
				return ctx.getChild(0).getText();
	}
	@Override 
	public String visitMd_op(HelloParser.Md_opContext ctx) { 
				//System.out.println("I visited ");
		return ctx.getChild(0).getText();
	}
	@Override 
	public String visitPr_op(HelloParser.Pr_opContext ctx) { 
				//System.out.println("I visited ");
		return ctx.getChild(0).getText();
	}
	@Override 
	public String visitRel_op(HelloParser.Rel_opContext ctx) { 
				//System.out.println("I visited ");
		return ctx.getChild(0).getText();
	}
	@Override 
	public String visitEq_op(HelloParser.Eq_opContext ctx) { 
				//System.out.println("I visited ");
		return ctx.getChild(0).getText();
	}
	@Override 
	public String visitCond_op(HelloParser.Cond_opContext ctx) { 
				//System.out.println("I visited cond_op");
		return ctx.getChild(0).getText(); 
	}
	@Override 
	public String visitLiteral(HelloParser.LiteralContext ctx) { 
				//System.out.println("I visited literal");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitInt_literal(HelloParser.Int_literalContext ctx) { 
				//System.out.println("I visited intLiteral");
				return ctx.getChild(0).getText();
	}
	@Override 
	public String visitChar_literal(HelloParser.Char_literalContext ctx) { 
				//System.out.println("I visited charLiteral");
				return ctx.getChild(0).getText();
	}
	@Override 
	public String visitBool_literal(HelloParser.Bool_literalContext ctx) { 
				//System.out.println("I visited Bool");
				return ctx.getChild(0).getText(); 
	}
	
	public void quadruple2Icg(){
		for (Map.Entry entry : quadruple.entrySet()) {
			String[] value = quadruple.get(entry.getKey());
			String icg;
			if(value[0].matches("[-+*/]")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].equals("==") || value[0].equals("!=")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put((String)(entry.getKey()), icg);
			}
				
			else if(value[0].equals("<") || value[0].equals(">") ||
					value[0].equals("<=") || value[0].equals("=>")){
				icg =	value[3] +
						":=" +
						value[1] +
						value[0] +
						value[2]; 
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].matches("[=]")){
				icg = 	value[3] +
						":=" +
						value[1];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].equals("FUNCTION ")){
				icg = 	value[0] +
						value[1];
				icgTable.put((String)(entry.getKey()), icg);		
			}
			else if(value[0].startsWith("END ")){
				icg = 	value[0] +
						value[1];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].equals("RETURN ")){
				icg = 	value[0] +
						value[1];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].equals("CALL ")){
				icg = 	value[0] +
						value[1] +
						value[2];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].equals("PARAM ")){
				icg = 	value[0] +
						value[1];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].startsWith("STARTWHILE_")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].startsWith("ENDWHILE_")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].startsWith("IF ")){
				icg = 	value[0]+
						value[1];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].startsWith("GOTO ")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}
			else if(value[0].startsWith("LABEL_TRUE_")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}		
			else if(value[0].startsWith("LABEL_FALSE_")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}		
			else if(value[0].startsWith("ENDIF_")){
				icg = 	value[0];
				icgTable.put((String)(entry.getKey()), icg);
			}		
			
		}
	}
	
	public Map<String, String[]> getQuadruple(){
		return quadruple;
	}
	
	public Map<String, String> getIcgTable(){
		return icgTable;
	}
}

//TODO check c = -1 case in assignation, return a temp
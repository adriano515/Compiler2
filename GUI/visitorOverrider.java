package GitAntlrIDE.GUI;

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class visitorOverrider extends HelloBaseVisitor<String>{

	public int scope =0;
	public Map<String, Map<String, String[]>> mapTree = new HashMap<String ,Map<String, String[]>>();
	public String currentScope = "globalTable";
	public int offset = 0;
	public int errorCounter;
	public Icg icg;
	//tableInfo = type,name,scope
	//map keys = name+scope
	
	//mapTree contains all the scopes hashMap tables, access the tables through the tree
	//for each map in mapTree save the name as table+scope+","+parentTableName, unless global
	
	//method for searching in currentScope and parentScopes
	//@parameters : currentScope name and key to search for
	//returns false if not found
	//searches in currentScope then parent and so on, stops after curScope name = globalTable
	public boolean searchScopes(String curScope, String key){
		if(mapTree.get(curScope).containsKey(key))
			return true;
		else if(curScope.equals("globalTable"))
			return false;
		
		curScope = getParentScope(curScope);
		return searchScopes(curScope, key);
	}
	public String searchKey(String curScope, String key){
		if(mapTree.get(curScope).containsKey(key))
			return curScope;
		else if(curScope.equals("globalTable"))
			return curScope;
		
		curScope = getParentScope(curScope);
		return searchKey(curScope, key);
	}
	
	public String renameCurrentScope(String curScope, int scope){
		String[] curScopeSplit;
		if(!curScope.equals("globalTable")){
			curScopeSplit = curScope.split(","); 
			curScope = "table"+scope+","+curScopeSplit[0];	
		}
		else{
			curScope = "table"+scope+","+curScope;
		}
		return curScope;
	}
	public String getParentScope(String curScope){
		if(!curScope.equals("globalTable")){
			String[] curScopeSplit = curScope.split(","); 
			for (Map.Entry entry : mapTree.entrySet()) {
				if (((String) entry.getKey()).startsWith(curScopeSplit[1])) {
					if(!curScopeSplit[1].equals("globalTable")){
						String[] parentScopeSplit = entry.getKey().toString().split(",");
						curScope = curScopeSplit[1]+","+parentScopeSplit[1];
					}
					else{
						curScope = curScopeSplit[1];
					}
				}
			}
		}
		return curScope;
	}
	
	public String[] getVar(String curScope, String key){
		String[] value;
		value = mapTree.get(curScope).get(key);
		if(!curScope.equals("globalTable")){
			if(value == null){
				curScope = getParentScope(curScope);
				return getVar(curScope, key);
			}
			else return value;
		}
		else if(value == null){
			return null;
		}
		else return value;		
	}
	
	public String getStructTable(String curScope, String key){
		String[] value;
		value = mapTree.get(curScope).get(key);
		if(!curScope.equals("globalTable")){
			if(value == null){
				curScope = getParentScope(curScope);
				return getStructTable(curScope, key);
			}
			else return curScope;
		}
		else if(value == null){
			return null;
		}
		else return curScope;		
	}
	
	
	public String getMethod(String curScope,HelloParser.MethodCallContext ctx,String name, String ctxString){
		String paramType = "";
		for (Map.Entry entry : mapTree.get(curScope).entrySet()) {
			if (((String) entry.getKey()).startsWith(name)) {
				String[] keys = mapTree.get(curScope).get(entry.getKey());
				String answer = ctxString.substring(ctxString.indexOf("(")+1,ctxString.indexOf(")"));
				String[] paramSplit = answer.split(",");
				for(int i = 0; i < paramSplit.length; i ++){
					if(paramSplit[i].contains("-") || paramSplit[i].contains("+") || 
							paramSplit[i].contains("*") || paramSplit[i].contains("/") ||
						paramSplit[i].contains("%")){
						paramType = paramType + ",int";
					}
					else{
						try{
							Integer.parseInt(paramSplit[i]);
							paramType = paramType + ",int";
						}
						catch(Exception e){
							if(paramSplit[i].startsWith("\'") && paramSplit[i].endsWith("\'"))
								paramType = paramType + ",char";
							else if(paramSplit[i].equals("true") || paramSplit[i].equals("false"))
								paramType = paramType + ",boolean";
							else
								
	 							paramType = paramType + "," + getVar(currentScope,paramSplit[i])[0];
						}
					}
					
				}
				//answer = answer.replaceAll(",", keys[2]+ ",");	
				//answer = answer + keys[2];
				//answer = "," + answer;
				
				//System.out.println(paramType);
				if(keys[2].equals(paramType)){
					return keys[1];
				}
			}
		}
		if(!curScope.equals("globalTable")){
			curScope = getParentScope(curScope);
			return getMethod(curScope,ctx,name,ctxString);
		}	
		System.out.println("Undeclared method on line " + ctx.getStart().getLine());
		errorCounter ++;
		return null;
	}
	
	public void doOffset(String type){
		if(type.equals("int"))
			offset += 8;
		else if(type.equals("char"))
			offset += 4;
		else if(type.equals("boolean"))
			offset += 1;
		else {
			doStructOffset(type);
		}
	}
	
	public void doOffset(String type, int arraySize){
		if(type.equals("int"))
			offset += (8 * arraySize);
		else if(type.equals("char"))
			offset += (4 * arraySize);
		else if(type.equals("boolean"))
			offset += (1 * arraySize);
		else doStructArrayOffset(type, arraySize);
	}
	
	//this will get structs offset, scope -1 needed to get the table before the assignment which would be a struct (if its indeed a struct type)
	public void doStructOffset(String type){
					offset += Integer.parseInt(mapTree.get("globalTable").get(type)[2]);
	}
	
	public void doStructArrayOffset(String type, int arraySize){
				
				offset += Integer.parseInt(mapTree.get("globalTable").get(type)[2]) * arraySize;
	}
	
	@Override 
	public String visitProgram(HelloParser.ProgramContext ctx) { 
				//System.out.println("I visited Program");
				//Global scope = 0
				mapTree.put(currentScope, new HashMap<String, String[]>());
				//int localOffset = doOffset(ctx.getChild(0).getText());
				//offset += localOffset;
				//String[] info = {ctx.getChild(0).getText(),ctx.getChild(1).getText(),localOffset + ""};
				if(mapTree.get(currentScope).containsKey(ctx.getChild(1).getText())){
					System.out.println("Variable "+ctx.getChild(1).getText() + " en linea " + ctx.getStart().getLine() + " ya declarada previamente");
					errorCounter ++;
				}
				
				//mapTree.get(currentScope).put(ctx.getChild(1).getText(),info );
				visitChildren(ctx); 
				if(errorCounter == 0){
					
					return "done with " + errorCounter + " errors";
				}
				else return "done with " + errorCounter + " errors";
				
	}
	@Override 
	public String visitDeclaration(HelloParser.DeclarationContext ctx) { 
				//System.out.println("I visited declaration");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitVarDeclaration(HelloParser.VarDeclarationContext ctx) { 
		
				//System.out.println("I visited varDeclaration");
				if(ctx.getChild(2).getText().equals(';')){
					//if array
					
					String[] info = {ctx.getChild(0).getText(),ctx.getChild(1).getText(),ctx.getChild(3).getText(),offset + ""};
					doOffset(ctx.getChild(0).getText(), Integer.parseInt(ctx.getChild(3).getText()));
					if(searchScopes(currentScope,ctx.getChild(1).getText())){
						System.out.println("Variable "+ctx.getChild(1).getText()+ " en linea " + ctx.getStart().getLine() + " ya declarada previamente");
						errorCounter ++;
					}
					mapTree.get(currentScope).put(ctx.getChild(1).getText(),info );
				}
				else{
					
					String[] info = {ctx.getChild(0).getText(),ctx.getChild(1).getText(),offset + ""};
					doOffset(ctx.getChild(0).getText());
					if(searchScopes(currentScope,ctx.getChild(1).getText())){
						System.out.println("Variable "+ctx.getChild(1).getText()+ " en linea " + ctx.getStart().getLine() + " ya declarada previamente");
						errorCounter ++;
					}
					mapTree.get(currentScope).put(ctx.getChild(1).getText(),info );
				}
				return visitChildren(ctx); 
	}
	@Override 
	public String visitStructDeclaration(HelloParser.StructDeclarationContext ctx) { 
				//System.out.println("I visited StructDeclaration");
				
				if(searchScopes(currentScope,(ctx.getChild(1).getText()))){
					System.out.println("Structura " + ctx.getChild(1).getText() + " en linea " + ctx.getStart().getLine() + " ya declarada previamente");
					errorCounter ++;
				}
				
				int gOffset = offset;
				
				scope ++;
				currentScope = renameCurrentScope(currentScope, scope);
				mapTree.put(currentScope, new HashMap<String, String[]>());
				
				visitChildren(ctx); 
				currentScope = getParentScope(currentScope);
				String[] info = {ctx.getChild(0).getText(),ctx.getChild(1).getText(),(offset - gOffset) + ""};
				mapTree.get(currentScope).put(ctx.getChild(1).getText(), info);
				
				return "";
	}
	@Override 
	public String visitVarType(HelloParser.VarTypeContext ctx) { 
				//System.out.println("I visited varType");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMethodDeclaration(HelloParser.MethodDeclarationContext ctx) { 
				//System.out.println("I visited methodDeclaration");
				scope ++;
				int arrayCounter = 0;
				String parameters = new String();
				//for of parameters
				int par1 = 0;
				currentScope = renameCurrentScope(currentScope, scope);
				mapTree.put(currentScope, new HashMap<String, String[]>());
				for (int i=3;i<ctx.children.size();i++){
					
					if(ctx.getChild(i).getText().equals("(")){
						par1 = i;
					}
					else if(ctx.getChild(i).getText().equals(","));
					else if(ctx.getChild(i).getText().equals(")")){
						
						i = ctx.children.size() + 1 ;
						//if it finds ) there are no more parameters (size +1 just in case)
					}
					else{
						if(ctx.getChild(i).getChild(0)!= null && ctx.getChild(i).getChild(1)!= null){
							String[] info = {ctx.getChild(i).getChild(0).getText(),ctx.getChild(i).getChild(1).getText()};
							if(searchScopes(currentScope,ctx.getChild(1).getText())){
								System.out.println("Metodo "+ctx.getChild(1).getText()+ " en linea " + ctx.getStart().getLine() +" ya declarado previamente");
								errorCounter ++;
							}
							mapTree.get(currentScope).put(ctx.getChild(i).getChild(1).getText(), info );
							parameters = parameters + ',' + ctx.getChild(i).getChild(0).getText();
						}
						else{								
								System.out.println("El parametro ha sido mal enviado en la linea " + ctx.getStart().getLine());
								errorCounter ++;							
						}
						
					}
					
				}
				currentScope = getParentScope(currentScope);
				
				String[] info = {ctx.getChild(0).getText(),ctx.getChild(1).getText(),parameters};
				if(searchScopes(currentScope,ctx.getChild(1).getText())){
					System.out.println("Metodo " + ctx.getChild(1).getText() + " en linea " + ctx.getStart().getLine() + " ya declarada previamente");
					errorCounter ++;
				}
				mapTree.get(currentScope).put(ctx.getChild(1).getText(),info );
				currentScope = renameCurrentScope(currentScope, scope);
				visitChildren(ctx);
				if(!info[0].equals("void")){
					ParseTree blockSon = ctx.getChild(ctx.children.size() - 1);
					String retType = visit(blockSon.getChild(ctx.getChild(ctx.children.size() - 1).getChildCount()-2));
					//System.out.println(retType + " Este es el return type");
					//System.out.println(blockSon.getChild(ctx.getChild(ctx.children.size() - 2).getChildCount()-2) + " Este es el childCount");
					if(retType == null || !retType.equals(info[0])){
						System.out.println ("Return no es del mismo tipo que el metodo " + info[1] + "Linea " + ctx.getStart().getLine());
						//System.out.println("RetType"+retType+"info en tabla"+info[0]+("void".equals(info[0])));
						errorCounter ++;
					}
					
				}
				currentScope = getParentScope(currentScope);
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
				//System.out.println("I visited Statement");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitAssignation(HelloParser.AssignationContext ctx) { 
				//System.out.println("I visited assignation");
				String child1 = visit(ctx.getChild(0));
				String child2 = visit(ctx.getChild(2));
				if(child1!=null && child2 != null && child1.equals(child2)){
					return child1;
				}
				else{
					System.out.println("Error en la asignacion linea " + ctx.getStart().getLine());
					errorCounter ++;
					return null;
				} 
	}
	@Override 
	public String visitWhileBlock(HelloParser.WhileBlockContext ctx) { 
				//System.out.println("I visited while");
		//TODO
				scope++;
				currentScope = renameCurrentScope(currentScope, scope);	
				mapTree.put(currentScope, new HashMap<String, String[]>());
				visitChildren(ctx); 
				currentScope = getParentScope(currentScope);
				return "";
	}
	@Override 
	public String visitReturnBlock(HelloParser.ReturnBlockContext ctx) { 
				//System.out.println("I visited returnBlock");
				
				String[] var = getVar(currentScope, ctx.getChild(1).getText());
				if(var != null)
					return var[0];
				else{
					String type = ctx.getChild(1).getText();
					try{
						Integer.parseInt(type);
						return "int";
					}
					catch(Exception t){
						if(type.equals("false") || type.equals("true"))
							return "boolean";
						else return "char";
					}
				}
				
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
				scope ++;
				currentScope = renameCurrentScope(currentScope, scope);
				mapTree.put(currentScope, new HashMap<String, String[]>());			
				visitChildren(ctx); 
				currentScope = getParentScope(currentScope);
				return "";
	}
	@Override 
	public String visitElseBlock(HelloParser.ElseBlockContext ctx) { 
				//System.out.println("I visited else");
				scope ++;
				currentScope = renameCurrentScope(currentScope, scope);
				mapTree.put(currentScope, new HashMap<String, String[]>());			
				visitChildren(ctx); 
				currentScope = getParentScope(currentScope);
				return "";
	}
	@Override 
	public String visitLocation(HelloParser.LocationContext ctx) { 
				//System.out.println("I visited location");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitDotLocation(HelloParser.DotLocationContext ctx) { 
				//System.out.println("I visited dotLocation");
				String[] var = null;
				try{
					String fatherTableName = getStructTable(currentScope,(ctx.getChild(0).getText()));
					var = mapTree.get(fatherTableName).get(ctx.getChild(2).getText());
					return var[1];
				}
				catch(Exception e){
					System.out.println("Variable "+ctx.getChild(1).getText()+"en linea "+ctx.getStart().getLine()+"no existe en la estructura");
					errorCounter ++;
					return null;
				}
				
	}
	@Override 
	public String visitDeclaredVariable(HelloParser.DeclaredVariableContext ctx) { 
				//System.out.println("I visited declaredVariable");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitVariable(HelloParser.VariableContext ctx) { 
				//System.out.println("I visited variable");
				String[] var = null;
				try{
			
					var = getVar(currentScope,(ctx.getChild(0).getText()));
					if (var.length>0){
						
						return var[0];
					}
					else{
						return visitChildren(ctx);
					}
				}
				catch(Exception e){
					
					System.out.println("Variable "+ctx.getChild(0).getText()+"en linea "+ctx.getStart().getLine()+"no ha sido declarada");
					errorCounter ++;
					return null;
				}
				
	}
	@Override 
	public String visitArrayVariable(HelloParser.ArrayVariableContext ctx) { 
				//System.out.println("I visited ");
		//TODO
				String[] var = getVar(currentScope, ctx.getChild(0).getText());
				visitChildren(ctx); 
				return var[0];
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
				if(ctx.children.size()>1){
					String child1 = visit(ctx.getChild(0));
					String child2 = visit(ctx.getChild(2));
					if(child1!= null && child2!= null && child1.equals(child2)){
						return child1;
					}
					else{
						System.out.println("Error en la asignacion linea " + ctx.getStart().getLine());
						errorCounter ++;
						return null;
					} 
				}
				
				return visitChildren(ctx); 
	}
	@Override 
	public String visitRelationExpression(HelloParser.RelationExpressionContext ctx) { 
				//System.out.println("I visited relation");
				if(ctx.children.size()>1){
					String child1 = visit(ctx.getChild(0));
					String child2 = visit(ctx.getChild(2));
					if(child1!=null && child2!=null && child1.equals(child2)){
						return child1;
					}
					else{
						System.out.println("Error en la asignacion linea " + ctx.getStart().getLine());
						errorCounter ++;
						return null;
					} 
				}
				return visitChildren(ctx); 
	}
	@Override 
	public String visitAddSubsExpression(HelloParser.AddSubsExpressionContext ctx) { 
				//System.out.println("I visited add/sub expression");
				String type = null;
				if(ctx.children.size()>1){
					for(int i =0;i<ctx.children.size();i++){
						if(i % 2 == 0){
							if(type==null){
								
								type = visit(ctx.getChild(i));
							}
							else if(type.equals(visit(ctx.getChild(i)))&&(!ctx.getChild(i).equals("boolean")));
							else{
								System.out.println("Error de tipos en la linea "+ctx.getStart().getLine());
								errorCounter ++;
								return null;
							}
						}
					}
					return type;
				}
				else{
					return visit(ctx.getChild(0));
				}
	}
	@Override 
	public String visitMulDivExpression(HelloParser.MulDivExpressionContext ctx) { 
				//System.out.println("I visited mul/div");
				String type = null;
				if(ctx.children.size()>1){
					for(int i =0;i<ctx.children.size();i++){
						if(i % 2 == 0){
							if(type==null){
								type = visit(ctx.getChild(i));
							}
							else if(type.equals(visit(ctx.getChild(i)))&&(!ctx.getChild(i).equals("boolean")));
							else{
								System.out.println("Error de tipos en la linea "+ctx.getStart().getLine());
								errorCounter ++;
								return null;
							}
						}
					}
					return type;
				}
				else{
					return visit(ctx.getChild(0));
				}
	}
	@Override 
	public String visitPrExpression(HelloParser.PrExpressionContext ctx) { 
				//System.out.println("I visited PRexpression");
				if(ctx.children.size()>1){
					String child1 = visit(ctx.getChild(0));
					String child2 = visit(ctx.getChild(2));
					if(child1!=null && child2!= null && child1.equals(child2)){
						return child1;
					}
					else{
						System.out.print("Error en la asignacion linea " + ctx.getStart().getLine());
						errorCounter ++;
						return null;
					} 
				}
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
				String type = visit(ctx.getChild(0));
				if(!type.equals("int") && !type.equals("char") && !type.equals("boolean") &&
						ctx.getChild(0).getChildCount() > 1){
					String[] temp = getVar(currentScope, type);
					return temp[0];
				}
				return visitChildren(ctx); 
	}
	@Override 
	public String visitArg(HelloParser.ArgContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMethodCall(HelloParser.MethodCallContext ctx) { 
				//System.out.println("I visited methodCall");
				String name = ctx.getChild(0).getText();
				visitChildren(ctx);
				String ctxString = ctx.getText();
				if(ctxString.contains("-") || ctxString.contains("+") || 
						ctxString.contains("*") || ctxString.contains("/") ||
						ctxString.contains("%")){
					return "int";
				}
				return getMethod(currentScope,ctx, name, ctxString);
	}
	@Override 
	public String visitAs_op(HelloParser.As_opContext ctx) { 
				//System.out.println("I visited plus/minus");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitMd_op(HelloParser.Md_opContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitPr_op(HelloParser.Pr_opContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitRel_op(HelloParser.Rel_opContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitEq_op(HelloParser.Eq_opContext ctx) { 
				//System.out.println("I visited ");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitCond_op(HelloParser.Cond_opContext ctx) { 
				//System.out.println("I visited cond_op");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitLiteral(HelloParser.LiteralContext ctx) { 
				//System.out.println("I visited literal");
				return visitChildren(ctx); 
	}
	@Override 
	public String visitInt_literal(HelloParser.Int_literalContext ctx) { 
				//System.out.println("I visited intLiteral");
				return "int";
	}
	@Override 
	public String visitChar_literal(HelloParser.Char_literalContext ctx) { 
				//System.out.println("I visited charLiteral");
				return "char"; 
	}
	@Override 
	public String visitBool_literal(HelloParser.Bool_literalContext ctx) { 
				//System.out.println("I visited Bool");
				return "boolean"; 
	}
	
	public Map<String, Map<String, String[]>> getMapTree(){
		return mapTree;
	}
}


//TODO check array, check dotLocation

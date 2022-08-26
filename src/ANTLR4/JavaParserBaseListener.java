package ANTLR4;

// Generated from JavaParser.g4 by ANTLR 4.7.1
import ANTLR4.JavaParser.*;
import ANTLR4.JavaParser.MethodDeclarationContext;
import ClasesTipo.Atributo;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import ClasesTipo.Clase;
import java.util.ArrayList;
import ClasesTipo.Metodo;
import java.io.File;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.antlr.v4.runtime.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.misc.Interval;
/**
 * This class provides an empty implementation of {@link JavaParserListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class JavaParserBaseListener implements JavaParserListener {
    
     int numMetodos = 0;
     String parametros = "";
     ArrayList<Clase> listaClases = new ArrayList<>();
     ArrayList<Metodo> listaMetodo = new ArrayList<>();
     Map<String, Metodo> mapMetodos2 = new HashMap<>();
     Map<String, String> mapVar = new HashMap<>();
     Clase oClase = new Clase();
     Metodo oMetodo = new Metodo();
     boolean claseAstracta = false;
     boolean esInterfaz = false;
     Map<String, String> mapPar = new HashMap<>();
     boolean entroAmetodo = false;
     String tipoAuxVariable = "";
     public int calcular(){
         return numMetodos;
     }
     
      public ArrayList<Clase> obtenerListaDeClases(){
         return listaClases;
     }
//      public List<Clase> obtenerListas(){
//         return listaClases;
//     }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        Obtener Paquete
	@Override public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        oClase = new Clase();
        claseAstracta = false;
        esInterfaz = false;
        oClase.metodos = new ArrayList<>();
        oClase.importaciones = new ArrayList<>();
        listaMetodo = new ArrayList<>();
        mapMetodos2 = new HashMap<>();
        mapVar = new HashMap<>();
        String cPaquete = "";
        parametros = "";
        cPaquete = ctx.getChild(1).getText();
        oClase.setPaquete(cPaquete);
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        obtener las importaciones
	@Override public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) 
      {
//          String var = ctx.getText();
          int numHijos = ctx.getChildCount();
          String importacion = "";
          for (int i = 0; i < numHijos; i++) {
              if(i == 0){
//                  System.err.println("0:"+ctx.getChild(i).getText());
                   importacion = importacion+ ctx.getChild(i).getText();
              }else{
//                  System.err.println("0:"+ctx.getChild(i).getText());
                   importacion = importacion+ " "+ ctx.getChild(i).getText();
              }
             
          }
//          importacion = ctx.getChild(0).getText() + "" + ctx.getChild(1).getText() + ctx.getChild(2).getText();
          oClase.importaciones.add(importacion);
        
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default im plementation does nothing.</p>
	 */
	@Override public void exitImportDeclaration(JavaParser.ImportDeclarationContext ctx) { 
        
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        calificador de alcance de la clase
	@Override public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) 
        { 
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (ctx.getChild(i).getText().equalsIgnoreCase("abstract")) {
                    claseAstracta = true;
                }
            }
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        calificador de alcance del metodo
	@Override public void enterModifier(JavaParser.ModifierContext ctx) { 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitModifier(JavaParser.ModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) { 

        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableModifier(JavaParser.VariableModifierContext ctx) {
//            String var = ctx.getText();
//            int g = 0;
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableModifier(JavaParser.VariableModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
         String nombre = ctx.IDENTIFIER().getText();
         oClase.setNombre(nombre);
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeParameters(JavaParser.TypeParametersContext ctx) {
            String var = ctx.getText();
            parametros = var;
            oClase.setParametros(parametros);
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeParameters(JavaParser.TypeParametersContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeParameter(JavaParser.TypeParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeParameter(JavaParser.TypeParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeBound(JavaParser.TypeBoundContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeBound(JavaParser.TypeBoundContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnumDeclaration(JavaParser.EnumDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnumConstants(JavaParser.EnumConstantsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnumConstants(JavaParser.EnumConstantsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnumConstant(JavaParser.EnumConstantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnumConstant(JavaParser.EnumConstantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnumBodyDeclarations(JavaParser.EnumBodyDeclarationsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) { 
         String nombre = ctx.IDENTIFIER().getText();
         oClase.setNombre(nombre);
         esInterfaz = true;
//            System.err.println("nombre de la interfaz:" + nombre);
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
        ArrayList<String> varRes = new ArrayList<>();
        
        uniVariables();

            for (String var : variables) {
                String v = var.substring(0, var.length() - 2);
                varRes.add(v);
            }
            if(!oClase.getClasePadre().equals("")){
                oClase.setHeredaDeClase(true);
            }
            obtenerVariablesClase(variablesAux);
            oClase.setMetodos(listaMetodo);
            oClase.setMetodos2(mapMetodos2);
            oClase.setVariables(varRes);
            oClase.setVar_b(mapVar);
            oClase.setVarNew(variablesAux);
            oClase.setAbstracta(claseAstracta);
            oClase.setEsInterfaz(esInterfaz);
            variables = new ArrayList<>();
            listaClases.add(oClase);
        }
        
        
       private void obtenerVariablesClase(ArrayList<String> listaVar) {
              
           for (String variable : listaVar) {
               ArrayList<String> listVariablesClase = new ArrayList<>();
               boolean buscarEnlista = false;
                variable = variable.replaceAll(";","").trim();
                String[] parts = variable.split(" ");
                String tipo = parts[parts.length - 2];
                String var = parts[parts.length - 1];
                if(var.contains(",")){
                    buscarEnlista = true;
                   String[] varC = var.split(","); 
                    for (int i = 0; i < varC.length; i++) {
                        listVariablesClase.add(varC[i]);
                    }
                }
                
                if (!buscarEnlista) {
                   if (!mapVar.containsKey(var)) {
                       mapVar.put(var, tipo);
//                       System.err.println("la varible" + var + "no se encuentra");
                   }
               } else if (buscarEnlista) {
                  
                    for (String v : listVariablesClase) {
                        v = v.trim();
                        if (!mapVar.containsKey(v)) {
                            mapVar.put(v, tipo);
                        }
//                        System.out.println(v);
                    }

               }
        }

    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassBody(JavaParser.ClassBodyContext ctx) { 
            String var = ctx.getText();
            Clase oC = new Clase();            
//            oC.setnombre(ctx.getText());
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassBody(JavaParser.ClassBodyContext ctx) { 
            ArrayList<String> varRes = new ArrayList<>();

            uniVariables();
            for (String var : variables) {
                String v = var.substring(0, var.length() - 2);
                varRes.add(v);
            }
            if(!oClase.getClasePadre().equals("")){
                oClase.setHeredaDeClase(true);
            }
            obtenerVariablesClase(variablesAux);
            oClase.setMetodos(listaMetodo);
            oClase.setMetodos2(mapMetodos2);
            oClase.setVariables(varRes);
            oClase.setVarNew(variablesAux);
            oClase.setVar_b(mapVar);
            oClase.setAbstracta(claseAstracta);
            variables = new ArrayList<>();
            variables2 = new ArrayList<>();
            variablesAux = new ArrayList<>();
            listaClases.add(oClase);
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceBody(JavaParser.InterfaceBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
          
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
        
//        quitar este codigo
	@Override public void enterMemberDeclaration(JavaParser.MemberDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        informacion del metodo nombre,tipo
	@Override public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
            
            entroAmetodo = true;
            
            ClassBodyDeclarationContext cbdc = (ClassBodyDeclarationContext) ctx.parent.parent; 
            
                      for (int i = 0; i < cbdc.modifier().size(); i++) {
                
                if (cbdc.modifier(i).getText().equalsIgnoreCase("private") || cbdc.modifier(i).getText().equalsIgnoreCase("protected") || cbdc.modifier(i).getText().equalsIgnoreCase("public")) {
                    oMetodo.setCalificador(cbdc.modifier(i).getText());
//                    System.out.println("------Calificador de alcance----------" + cbdc.modifier(i).getText());
                }
                
                else if (cbdc.modifier(i).getText().equalsIgnoreCase("abstract")){
                     oMetodo.setAbstracto(true);
                 }
                
                 else if (cbdc.modifier(i).getText().equalsIgnoreCase("static")){
                     oMetodo.setEstatico(true);
                 }
            }

            String nombreMetodo = "";
            String tipoMetodo = "";
            tipoMetodo = ctx.getChild(0).getText();
            nombreMetodo = ctx.getChild(1).getText();
            String cuerpoAux = "";

            oMetodo.setTipo(tipoMetodo);
            oMetodo.setNombre(nombreMetodo);

            ClassBodyDeclarationContext cAux = (ClassBodyDeclarationContext) ctx.parent.parent;
            if (cbdc.start == null || cbdc.stop == null || cbdc.start.getStartIndex() < 0 || cbdc.stop.getStopIndex() < 0) {
                cuerpoAux = cbdc.getText(); // Fallback
            } else {
                cuerpoAux = cbdc.start.getInputStream().getText(Interval.of(cbdc.start.getStartIndex(), cbdc.stop.getStopIndex()));
            }

            String cadb = "(";
            String cadb_d = ")";
            String llave = "{";
            
            int posicion = 0;
            int posicionParentesisF = 0;
            int posicion_SN = 0;
            char caracter = cadb.charAt(0);
            char parentesisF = cadb_d.charAt(0);
            char caracter_SN = llave.charAt(0);
            boolean posicionEncontrada = false;
            boolean llaveEncontrada = false;
            boolean parentesisFinalEncontrado = false;
            
            for (int i = 0; i < cuerpoAux.length(); i++) {

                if (cuerpoAux.charAt(i) == caracter) {
                    posicion = i;
                    posicionEncontrada = true;
                }
                
                if(cuerpoAux.charAt(i) == parentesisF ){
                    posicionParentesisF = i;
                    parentesisFinalEncontrado = true;
                }
                
                if (cuerpoAux.charAt(i) == caracter_SN) {
                    posicion_SN = i;
                    llaveEncontrada = true;
                }
                
                if(posicionEncontrada && parentesisFinalEncontrado && llaveEncontrada){
                    break;
                }
            }
            String priL = cuerpoAux.substring(posicion, cuerpoAux.length());
            oMetodo.setCuerpo(priL);   
            
            String priL_par = cuerpoAux.substring(posicion+1, posicionParentesisF);
            llenarParametros(priL_par); 
            
            String priL_SN = cuerpoAux.substring(posicion_SN + 1, cuerpoAux.length()-1);
            oMetodo.setCuerpoSNparametros(priL_SN);
            
            oMetodo.setParametros(mapPar);
        }
        
//         private void obtenerVariablesMetodo(ArrayList<String> listaVar) {
//              
//           for (String variable : listaVar) {
//               ArrayList<String> listVariablesClase = new ArrayList<>();
//               boolean buscarEnlista = false;
//                variable = variable.replaceAll(";","").trim();
//                String[] parts = variable.split(" ");
//                String tipo = parts[parts.length - 2];
//                String var = parts[parts.length - 1];
//                if(var.contains(",")){
//                    buscarEnlista = true;
//                   String[] varC = var.split(","); 
//                    for (int i = 0; i < varC.length; i++) {
//                        listVariablesClase.add(varC[i]);
//                    }
//                }
//                
//                if (!buscarEnlista) {
//                   if (!mapPar.containsKey(var)) {
//                       mapPar.put(var, tipo);
////                       System.err.println("la varible" + var + "no se encuentra");
//                   }
//               } else if (buscarEnlista) {
//                  
//                    for (String v : listVariablesClase) {
//                        v = v.trim();
//                        if (!mapPar.containsKey(v)) {
//                            mapPar.put(v, tipo);
//                        }
////                        System.out.println(v);
//                    }
//
//               }
//        }
//
//    }
        
        
        private void llenarParametros(String parametros){
        if (!parametros.equals("")) {
            if (parametros.contains(",")) {
                String[] par = parametros.split(",");
                for (int i = 0; i < par.length; i++) {
                    String[] p = par[i].split(" ");
                    String tipo = p[p.length - 2];
                    String n = p[p.length - 1];
                    mapPar.put(n, tipo);

                }

            } 
            
            else {
                String[] p = parametros.split(" ");
                String tipo = p[p.length - 2];
                String n = p[p.length - 1];
                mapPar.put(n, tipo);
            }

        }
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethodBody(JavaParser.MethodBodyContext ctx) { 
          numMetodos ++;
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodBody(JavaParser.MethodBodyContext ctx) {
        listaMetodo.add(oMetodo);
        mapMetodos2.put(oMetodo.getNombre(), oMetodo);
        oMetodo = new Metodo();
        mapPar = new HashMap<String, String>();
        variablesMM = new ArrayList<>(); 
        entroAmetodo = false;

        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeTypeOrVoid(JavaParser.TypeTypeOrVoidContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeTypeOrVoid(JavaParser.TypeTypeOrVoidContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx) {
         
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGenericMethodDeclaration(JavaParser.GenericMethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGenericConstructorDeclaration(JavaParser.GenericConstructorDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
            
            ClassBodyDeclarationContext cbdc = (ClassBodyDeclarationContext) ctx.parent.parent;
             entroAmetodo = true;

            for (int i = 0; i < cbdc.modifier().size(); i++) {
                
                if (cbdc.modifier(i).getText().equalsIgnoreCase("private") || cbdc.modifier(i).getText().equalsIgnoreCase("protected") || cbdc.modifier(i).getText().equalsIgnoreCase("public")) {
                    oMetodo.setCalificador(cbdc.modifier(i).getText());
//                    System.out.println("------Calificador de alcance----------" + cbdc.modifier(i).getText());
                }
                 }

            String nombreMetodo = "";
            nombreMetodo = ctx.getChild(0).getText();
//            nombreMetodo = ctx.getChild(1).getText();
            String cuerpoAux = "";

            oMetodo.setTipo("");//el contructor no retorna ningun valor ni void
            oMetodo.setNombre(nombreMetodo);

            ClassBodyDeclarationContext cAux = (ClassBodyDeclarationContext) ctx.parent.parent;
            if (cbdc.start == null || cbdc.stop == null || cbdc.start.getStartIndex() < 0 || cbdc.stop.getStopIndex() < 0) {
                cuerpoAux = cbdc.getText(); // Fallback
            } else {
                cuerpoAux = cbdc.start.getInputStream().getText(Interval.of(cbdc.start.getStartIndex(), cbdc.stop.getStopIndex()));
            }

            String cadb = "(";
            int posicion = 0;
            char caracter = cadb.charAt(0);
            for (int i = 0; i < cuerpoAux.length(); i++) {

                if (cuerpoAux.charAt(i) == caracter) {
                    posicion = i;
                    break;
                }
            }
            String priL = cuerpoAux.substring(posicion, cuerpoAux.length());
            oMetodo.setCuerpo(priL);        
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) { 
            listaMetodo.add(oMetodo);
             mapMetodos2.put(oMetodo.getNombre(), oMetodo);
            oMetodo = new Metodo();
            mapPar = new HashMap<String, String>();
            variablesMM = new ArrayList<>(); 
            entroAmetodo = true;

        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
        String infoCuerpo = "";
        ArrayList<String> variables = new ArrayList<>(); 
        ArrayList<String> variables2 = new ArrayList<>(); 
        ArrayList<String> variablesAux = new ArrayList<>(); 
        ArrayList<String> variablesMM = new ArrayList<>(); 
        int contador = 0;
        ArrayList<String> variablesMPP = new ArrayList<>(); 
        
	@Override public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
            int num = ctx.getChildCount();
            String varN = "";
                        
            for (int i = 0; i < num; i++) {
                if ("".equals(varN)) {
                    varN = ctx.getChild(i).getText();
                }
                else if (i == (num - 1)) {
                    varN = varN + ctx.getChild(i).getText();
                } else {
                    varN = varN + " " + ctx.getChild(i).getText();
                }
            }
            
            variables2.add(varN);
            
            ClassBodyDeclarationContext cbdc = (ClassBodyDeclarationContext) ctx.parent.parent;
            
            for (int b = 0  ; b < cbdc.getChildCount(); b++) {
                
                if((b+1) == cbdc.getChildCount() ){
                    variables.addAll(convierteArbolListaImpl(cbdc.getChild(b)));
                    infoCuerpo = "";
                }
                else{
                    convierteArbolListaImpl(cbdc.getChild(b));
                }
                
            }
                
        }
         
        
        private ArrayList<String> convierteArbolListaImpl(ParseTree prsTree) {
        infoCuerpo = convierteArbolString(prsTree);
        String[] _listaImplementacion = infoCuerpo.split("(?<=\\{)|(?<=\\;)");
        ArrayList<String> listaAuxCP = new ArrayList<String>();
        listaAuxCP.addAll(Arrays.asList(_listaImplementacion));
        return listaAuxCP;

    }

    private String convierteArbolString(ParseTree prsTree) {
        int cantHijos = prsTree.getChildCount();
        for (int c = 0; c < cantHijos; c++) {
            if (prsTree.getChild(c) instanceof TerminalNodeImpl) {
                infoCuerpo += " " + prsTree.getChild(c).getText(); //Agrega un espacio en blanco a la cadena entre nodos terminales.        
            }
            convierteArbolString(prsTree.getChild(c));
        }
        return infoCuerpo;
    }
    
    private void uniVariables() {
        
        int contador = 0;

        for (String var : variables) {
            String n = "";
            if (var.contains("static")) {
                n = "static";
            }
            if (var.contains("final")) {
                n = "final";
            }
            if (var.contains("private")) {
                n = n + " " + "private";
            } else if (var.contains("public")) {
                n = n + " " + "public";
            } else if (var.contains("protected")) {
                n = n + " " + "protected";
            }

            n = n + " " + variables2.get(contador);
            variablesAux.add(n);
            contador++;
        }
    }
        
    
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceBodyDeclaration(JavaParser.InterfaceBodyDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) {}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceMemberDeclaration(JavaParser.InterfaceMemberDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConstDeclaration(JavaParser.ConstDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConstDeclaration(JavaParser.ConstDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) { 
        InterfaceBodyDeclarationContext cbdc = (InterfaceBodyDeclarationContext) ctx.parent.parent;

            for (int i = 0; i < cbdc.modifier().size(); i++) {
                
                if (cbdc.modifier(i).getText().equalsIgnoreCase("private") || cbdc.modifier(i).getText().equalsIgnoreCase("protected") || cbdc.modifier(i).getText().equalsIgnoreCase("public")) {
                    oMetodo.setCalificador(cbdc.modifier(i).getText());
//                    System.out.println("------Calificador de alcance----------" + cbdc.modifier(i).getText());
                }
                
                else if (cbdc.modifier(i).getText().equalsIgnoreCase("abstract")){
                     oMetodo.setAbstracto(true);
                 }
                
                 else if (cbdc.modifier(i).getText().equalsIgnoreCase("static")){
                     oMetodo.setEstatico(true);
                 }
            }

            String nombreMetodo = "";
            String tipoMetodo = "";
            tipoMetodo = ctx.getChild(0).getText();
            nombreMetodo = ctx.getChild(1).getText();
            String cuerpoAux = "";

            oMetodo.setTipo(tipoMetodo);
            oMetodo.setNombre(nombreMetodo);

            InterfaceBodyDeclarationContext cAux = (InterfaceBodyDeclarationContext) ctx.parent.parent;
            if (cbdc.start == null || cbdc.stop == null || cbdc.start.getStartIndex() < 0 || cbdc.stop.getStopIndex() < 0) {
                cuerpoAux = cbdc.getText(); // Fallback
            } else {
                cuerpoAux = cbdc.start.getInputStream().getText(Interval.of(cbdc.start.getStartIndex(), cbdc.stop.getStopIndex()));
            }

            String cadb = "(";
            int posicion = 0;
            char caracter = cadb.charAt(0);
            for (int i = 0; i < cuerpoAux.length(); i++) {

                if (cuerpoAux.charAt(i) == caracter) {
                    posicion = i;
                    break;
                }
            }
            String priL = cuerpoAux.substring(posicion, cuerpoAux.length());
            oMetodo.setCuerpo(priL);        
        
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
//        listaMetodo.add(oMetodo);
//        oMetodo = new Metodo();
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceMethodModifier(JavaParser.InterfaceMethodModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceMethodModifier(JavaParser.InterfaceMethodModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitGenericInterfaceMethodDeclaration(JavaParser.GenericInterfaceMethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) {
//            if (entroAmetodo) {
//                if (oClase.getNombre().equals("cBuble") && oMetodo.getNombre().equals("ordena")) {
//                    String var = ctx.getText();
//                    int y = ctx.getChildCount();
//                    int g = 0;
//                }
//            }
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableDeclarators(JavaParser.VariableDeclaratorsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
            String var1 = "";
            String var2 = "";
            boolean activaVarDos = false;
            if (entroAmetodo) {
//                if(oClase.getNombre().equals("cBuble") && oMetodo.getNombre().equals("ordena")){
//                    System.err.println("verificar");
//                }
                String var = ctx.getText();
                int y = ctx.getChildCount();
                for (int i = 0; i < y; i++) {
                  if(i>0){
                      var2 = var2 + ctx.getChild(i).getText();
                  }else{
                      var1 = ctx.getChild(i).getText();
                  }
                }
                if(var2.isEmpty()){
                    var2 = tipoAuxVariable;
                }
                mapPar.put(var1, var2);
            }
            
            
//        neli aqui estan las variables que nececitas ya las encontraste
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableInitializer(JavaParser.VariableInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableInitializer(JavaParser.VariableInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayInitializer(JavaParser.ArrayInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayInitializer(JavaParser.ArrayInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
            String var = ctx.getText();
            int bo = ctx.getChildCount();
            if (ctx.getParent().getParent() instanceof JavaParser.ClassDeclarationContext) {
                 oClase.setClasePadre(var);
//                probando si no funciona descomentar la linea  de abajo
//                oClase.setClasePadre(ctx.IDENTIFIER(0).getText());
            }
         }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeArgument(JavaParser.TypeArgumentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeArgument(JavaParser.TypeArgumentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterQualifiedNameList(JavaParser.QualifiedNameListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFormalParameters(JavaParser.FormalParametersContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFormalParameters(JavaParser.FormalParametersContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	   @Override
    public void enterFormalParameterList(JavaParser.FormalParameterListContext ctx) {}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFormalParameterList(JavaParser.FormalParameterListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFormalParameter(JavaParser.FormalParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFormalParameter(JavaParser.FormalParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLastFormalParameter(JavaParser.LastFormalParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLastFormalParameter(JavaParser.LastFormalParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterQualifiedName(JavaParser.QualifiedNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitQualifiedName(JavaParser.QualifiedNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLiteral(JavaParser.LiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLiteral(JavaParser.LiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntegerLiteral(JavaParser.IntegerLiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntegerLiteral(JavaParser.IntegerLiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFloatLiteral(JavaParser.FloatLiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFloatLiteral(JavaParser.FloatLiteralContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotation(JavaParser.AnnotationContext ctx) {
            String var = ctx.getText();
            if (var.equals("@Override")) {
                oMetodo.setEsOverride(true);
            }
      
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotation(JavaParser.AnnotationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElementValuePairs(JavaParser.ElementValuePairsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElementValuePairs(JavaParser.ElementValuePairsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElementValuePair(JavaParser.ElementValuePairContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElementValuePair(JavaParser.ElementValuePairContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElementValue(JavaParser.ElementValueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElementValue(JavaParser.ElementValueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElementValueArrayInitializer(JavaParser.ElementValueArrayInitializerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationTypeDeclaration(JavaParser.AnnotationTypeDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationTypeBody(JavaParser.AnnotationTypeBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationTypeElementDeclaration(JavaParser.AnnotationTypeElementDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationTypeElementRest(JavaParser.AnnotationTypeElementRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationMethodOrConstantRest(JavaParser.AnnotationMethodOrConstantRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationMethodRest(JavaParser.AnnotationMethodRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnnotationConstantRest(JavaParser.AnnotationConstantRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDefaultValue(JavaParser.DefaultValueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDefaultValue(JavaParser.DefaultValueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlock(JavaParser.BlockContext ctx) { 
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlock(JavaParser.BlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
//        revisando
	@Override public void enterBlockStatement(JavaParser.BlockStatementContext ctx) {
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlockStatement(JavaParser.BlockStatementContext ctx) {
        
      
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) {
               int num = ctx.getChildCount();
            String varN = "";
                        
            for (int i = 0; i < num; i++) {
                if ("".equals(varN)) {
                    varN = ctx.getChild(i).getText();
                }
                else if (i == (num - 1)) {
                    varN = varN+ " " +  ctx.getChild(i).getText();
                } else {
                    varN = varN + " " + ctx.getChild(i).getText();
                }
            }
            
            variablesMM.add(varN);
            
//           ClassBodyDeclarationContext cbdc = (ClassBodyDeclarationContext) ctx.parent.parent;
//            
//            for (int b = 0  ; b < cbdc.getChildCount(); b++) {
//                
//                if((b+1) == cbdc.getChildCount() ){
//                    variablesMPP.addAll(convierteArbolListaImpl(cbdc.getChild(b)));
//                    infoCuerpo = "";
//                }
//                else{
//                    convierteArbolListaImpl(cbdc.getChild(b));
//                }
                
//            }
          
//            descomentar lo de abajo 12 de mayo del 2020
//          int hijos = ctx.getChildCount();
//            if(hijos >=2){
//                mapPar.put(ctx.getChild(1).getText(), ctx.getChild(0).getText());
//            }
       
        
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLocalVariableDeclaration(JavaParser.LocalVariableDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLocalTypeDeclaration(JavaParser.LocalTypeDeclarationContext ctx) { 
            String var = ctx.getText();
//            System.err.println("nelilikfkfkfkfkf+" + var);
           
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLocalTypeDeclaration(JavaParser.LocalTypeDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(JavaParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(JavaParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCatchClause(JavaParser.CatchClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCatchClause(JavaParser.CatchClauseContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCatchType(JavaParser.CatchTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCatchType(JavaParser.CatchTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFinallyBlock(JavaParser.FinallyBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFinallyBlock(JavaParser.FinallyBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterResourceSpecification(JavaParser.ResourceSpecificationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitResourceSpecification(JavaParser.ResourceSpecificationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterResources(JavaParser.ResourcesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitResources(JavaParser.ResourcesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterResource(JavaParser.ResourceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitResource(JavaParser.ResourceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSwitchLabel(JavaParser.SwitchLabelContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForControl(JavaParser.ForControlContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForControl(JavaParser.ForControlContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForInit(JavaParser.ForInitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForInit(JavaParser.ForInitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEnhancedForControl(JavaParser.EnhancedForControlContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEnhancedForControl(JavaParser.EnhancedForControlContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParExpression(JavaParser.ParExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParExpression(JavaParser.ParExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionList(JavaParser.ExpressionListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionList(JavaParser.ExpressionListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethodCall(JavaParser.MethodCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodCall(JavaParser.MethodCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(JavaParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(JavaParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLambdaExpression(JavaParser.LambdaExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLambdaExpression(JavaParser.LambdaExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLambdaParameters(JavaParser.LambdaParametersContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLambdaParameters(JavaParser.LambdaParametersContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLambdaBody(JavaParser.LambdaBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLambdaBody(JavaParser.LambdaBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrimary(JavaParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrimary(JavaParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassType(JavaParser.ClassTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassType(JavaParser.ClassTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCreator(JavaParser.CreatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCreator(JavaParser.CreatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCreatedName(JavaParser.CreatedNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCreatedName(JavaParser.CreatedNameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInnerCreator(JavaParser.InnerCreatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInnerCreator(JavaParser.InnerCreatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayCreatorRest(JavaParser.ArrayCreatorRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassCreatorRest(JavaParser.ClassCreatorRestContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExplicitGenericInvocation(JavaParser.ExplicitGenericInvocationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeArgumentsOrDiamond(JavaParser.TypeArgumentsOrDiamondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNonWildcardTypeArgumentsOrDiamond(JavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNonWildcardTypeArgumentsOrDiamond(JavaParser.NonWildcardTypeArgumentsOrDiamondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNonWildcardTypeArguments(JavaParser.NonWildcardTypeArgumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeList(JavaParser.TypeListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeList(JavaParser.TypeListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeType(JavaParser.TypeTypeContext ctx) {
             if (entroAmetodo) {
                    tipoAuxVariable = ctx.getText();
                }
            
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeType(JavaParser.TypeTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrimitiveType(JavaParser.PrimitiveTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeArguments(JavaParser.TypeArgumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeArguments(JavaParser.TypeArgumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSuperSuffix(JavaParser.SuperSuffixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSuperSuffix(JavaParser.SuperSuffixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExplicitGenericInvocationSuffix(JavaParser.ExplicitGenericInvocationSuffixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArguments(JavaParser.ArgumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArguments(JavaParser.ArgumentsContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
        
        
}
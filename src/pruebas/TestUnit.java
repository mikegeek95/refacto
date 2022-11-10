package pruebas;

import java.io.IOException;
import java.util.ArrayList;

import ClasesTipo.Clase;
import ClasesTipo.objetoRespuesta;
import Refactorizar.GenerarCodigoRefactorizado;
import Refactorizar.ManejoArchivos;
import Refactorizar.OclasesDerivadas;
import Refactorizar.Refactorizar;
import junit.framework.TestCase;

public class TestUnit extends TestCase{
	
	  ManejoArchivos oMArchivos = new ManejoArchivos();
  	  GenerarCodigoRefactorizado gCodigoR = new GenerarCodigoRefactorizado();
  	  OclasesDerivadas rm2 = new OclasesDerivadas(); 
  	  ArrayList<Clase> listaC = new ArrayList<>();
  	  //Refactorizar oR = new Refactorizar();
  	  
  	  
  	public void objetos() throws IOException {
  		 oMArchivos.seleccionar_archivos();
         objetoRespuesta obj = new objetoRespuesta();
         listaC = (ArrayList<Clase>) oMArchivos.listaClases.clone();
         listaC= rm2.obtenerClasesDerivadas(listaC);
         //listaC = oR.refactorizar(listaC);
         gCodigoR.generarCodigo(listaC);
  	}
  	  
  	  
	public void testEstructuraPaquete() throws IOException {
		int n;
		objetos();
        for (n=0;n<listaC.size();n++) {

        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getPaquete(),"Calculator");
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getPaquete(),"Calculator");
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getPaquete(),"Calculator");
	        		break;
	        	}
	        	case 3:{
	        		assertEquals(listaC.get(n).getPaquete(),"computar");
	        		break;
	        	}
	        	case 4:{
	        		assertEquals(listaC.get(n).getPaquete(),"computar");
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getPaquete(),"computar");
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getPaquete(),"computar");
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getPaquete(),"inicio");
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraImportaciones() throws IOException {
		int n;
		ArrayList<String> imports=new ArrayList();
		objetos();
        for (n=0;n<listaC.size();n++) {
        	imports.clear();
        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 3:{
	        		imports.add("import java.text.DecimalFormat ;");
	        		imports.add("import java.util.LinkedList ;");
	        		imports.add("import Calculator.CalculadorE ;");
	        		imports.add("import Calculator.CalculadorX ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 4:{
	        		imports.add("import java.io . * ;");
	        		imports.add("import java.util.regex . * ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 5:{
	        		imports.add("import java.util . * ;");
	        		imports.add("import java.io . * ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 7:{
	        		imports.add("import java.io . * ;");
	        		imports.add("import computar.Correlacion ;");
	        		imports.add("import computar.LectorDeArchivo ;");
	        		imports.add("import computar.OrdenadorDeArchivo ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraNombreClase() throws IOException {
		int n;
		objetos();
        for (n=0;n<listaC.size();n++) {

        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getNombre(),"CalculadorE");
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getNombre(),"CalculadorP");
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getNombre(),"CalculadorX");
	        		break;
	        	}
	        	case 3:{
	        		assertEquals(listaC.get(n).getNombre(),"Correlacion");
	        		break;
	        	}
	        	case 4:{
	        		assertEquals(listaC.get(n).getNombre(),"LectorDeArchivo");
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getNombre(),"OrdenadorDeArchivo");
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getNombre(),"Parte");
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getNombre(),"PSP3");
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraNombreClasePadre() throws IOException {
		int n;
		objetos();
        for (n=0;n<listaC.size();n++) {

        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 3:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 4:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getClasePadre(),"");
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraAtributosDeClase() throws IOException {
		int n;
		ArrayList<String> variables=new ArrayList();
		objetos();
        for (n=0;n<listaC.size();n++) {
        	variables.clear();
        	switch(n) {
        	
	        	case 0:{
	        		variables.add(" double dP1");
	        		variables.add(" double dP2");
	        		variables.add(" double dE");
	        		variables.add(" public double dX");
	        		variables.add(" public int iDof");
	        		variables.add(" int iNum_seg");
	        		variables.add(" public double dP");
	        		variables.add(" CalculadorP cpCalcP = new CalculadorP ( )");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 1:{
	        		variables.add(" double dSumP");
	        		variables.add(" int iDof");
	        		variables.add(" double dX");
	        		variables.add(" int iNum_seg");
	        		variables.add(" double dGammaConst");
	        		variables.add(" double dPotenciaDof");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 2:{
	        		variables.add(" CalculadorE ceCalcE = new CalculadorE ( )");
	        		variables.add(" double dX1");
	        		variables.add(" double dX2");
	        		variables.add(" double dP1");
	        		variables.add(" double dP2");
	        		variables.add(" double dD");
	        		variables.add(" double dE");
	        		variables.add(" public double dP");
	        		variables.add(" public int iDof");
	        		variables.add(" public double dX");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 3:{
	        		variables.add(" float fPromx");
	        		variables.add(" float fPromy");
	        		variables.add(" float fSumx");
	        		variables.add(" float fSumy");
	        		variables.add(" float fSumx2");
	        		variables.add(" float fSumy2");
	        		variables.add(" float fSumxy");
	        		variables.add(" int iNumParejas");
	        		variables.add(" float fxk");
	        		variables.add(" float fBeta1");
	        		variables.add(" float fBeta0");
	        		variables.add(" float fr");
	        		variables.add(" float fr2");
	        		variables.add(" float fyk");
	        		variables.add(" double dSignificancia");
	        		variables.add(" double dRango");
	        		variables.add(" double dLimSup");
	        		variables.add(" double dLimInf");
	        		variables.add(" CalculadorE ceCalcE = new CalculadorE ( )");
	        		variables.add(" CalculadorX cxCalcX = new CalculadorX ( )");
	        		variables.add(" LinkedList < Float > dLinkedListX");
	        		variables.add(" LinkedList < Float > dLinkedListY");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 4:{
	        		variables.add(" public FileReader frArchivo");
	        		variables.add(" public int iCantLineasBlanco");
	        		variables.add(" public int iCantLineasInfo");
	        		variables.add(" public String sNombreArchivo");
	        		variables.add(" public OrdenadorDeArchivo odaOrdenador");
	        		variables.add(" public Correlacion coCalculador");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 5:{
	        		variables.add(" LinkedList < LectorDeArchivo > ldaLinkListArchivos");
	        		variables.add(" LinkedList < Parte > ptLinkListPartes");
	        		variables.add(" int iCantLineasTotales");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 6:{
	        		variables.add(" int iCantItems");
	        		variables.add(" int iLDCTotales");
	        		variables.add(" int iLDCBase");
	        		variables.add(" int iLDCBorradas");
	        		variables.add(" int iLDCModificadas");
	        		variables.add(" int iLDCAgregadas");
	        		variables.add(" char cTipoParte");
	        		variables.add(" String sNombreParte");
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getVariables(),variables);
	        		break;
	        	}
        	}
        }
	}
	
}

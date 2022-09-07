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
  	  //GenerarCodigoRefactorizado gCodigoR = new GenerarCodigoRefactorizado();
  	  OclasesDerivadas rm2 = new OclasesDerivadas(); 
  	  ArrayList<Clase> listaC = new ArrayList<>();
  	  //Refactorizar oR = new Refactorizar();
  	  
  	  
  	public void objetos() {
  		 oMArchivos.seleccionar_archivos();
         objetoRespuesta obj = new objetoRespuesta();
         listaC = (ArrayList<Clase>) oMArchivos.listaClases.clone();
         listaC= rm2.obtenerClasesDerivadas(listaC);
         //listaC = oR.refactorizar(listaC);
         //gCodigoR.generarCodigo(listaC);
  	}
  	  
  	  
	public void testEstructuraPaquete() {
		int n;
		objetos();
        for (n=0;n<listaC.size();n++) {

        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getPaquete(),"Template");
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getPaquete(),"Template");
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getPaquete(),"Iterator");
	        		break;
	        	}
	        	case 3:{
	        		assertEquals(listaC.get(n).getPaquete(),"Factory");
	        		break;
	        	}
	        	case 4:{
	        		assertEquals(listaC.get(n).getPaquete(),"Main");
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getPaquete(),"Iterator");
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getPaquete(),"Template");
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getPaquete(),"Iterator");
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraImportaciones() {
		int n;
		ArrayList<String> imports=new ArrayList();
		objetos();
        for (n=0;n<listaC.size();n++) {
        	imports.clear();
        	switch(n) {
        	
	        	case 0:{
	        		imports.add("import java.util.Scanner ;");
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
	        		imports.add("import Iterator . * ;");
	        		imports.add("import Template . * ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 4:{
	        		imports.add("import java.util.Scanner ;");
	        		imports.add("import Factory.Factory ;");
	        		imports.add("import Template . * ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 6:{
	        		imports.add("import Factory.Factory ;");
	        		imports.add("import Iterator.Contenedor ;");
	        		imports.add("import Iterator.Iterador ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
	        	case 7:{
	        		imports.add("import java.util.Scanner ;");
	        		assertEquals(listaC.get(n).getImportaciones(),imports);
	        		break;
	        	}
        	}
        }
	}
	
	public void testEstructuraNombreClase() {
		int n;
		objetos();
        for (n=0;n<listaC.size();n++) {

        	switch(n) {
        	
	        	case 0:{
	        		assertEquals(listaC.get(n).getNombre(),"Array");
	        		break;
	        	}
	        	case 1:{
	        		assertEquals(listaC.get(n).getNombre(),"Calculos");
	        		break;
	        	}
	        	case 2:{
	        		assertEquals(listaC.get(n).getNombre(),"Contenedor");
	        		break;
	        	}
	        	case 3:{
	        		assertEquals(listaC.get(n).getNombre(),"Factory");
	        		break;
	        	}
	        	case 4:{
	        		assertEquals(listaC.get(n).getNombre(),"Inicio");
	        		break;
	        	}
	        	case 5:{
	        		assertEquals(listaC.get(n).getNombre(),"Iterador");
	        		break;
	        	}
	        	case 6:{
	        		assertEquals(listaC.get(n).getNombre(),"Listas");
	        		break;
	        	}
	        	case 7:{
	        		assertEquals(listaC.get(n).getNombre(),"NameIterator");
	        		break;
	        	}
        	}
        }
	}
	
}

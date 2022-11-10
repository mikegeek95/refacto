package Refactorizar;

import ClasesTipo.Clase;
import ClasesTipo.objetoRespuesta;
import java.io.IOException;
import java.util.ArrayList;

public class Orquestador {
    
 
    public static void main (String [] args) throws IOException {
    	
    	  ManejoArchivos oMArchivos = new ManejoArchivos();
    	  GenerarCodigoRefactorizado gCodigoR = new GenerarCodigoRefactorizado();
    	  OclasesDerivadas rm2 = new OclasesDerivadas(); 
    	  ArrayList<Clase> listaC = new ArrayList<>();
    	  Refactorizar oR = new Refactorizar();

    	    
    	    
          oMArchivos.seleccionar_archivos();
          objetoRespuesta obj = new objetoRespuesta();
          listaC = (ArrayList<Clase>) oMArchivos.listaClases.clone();
          listaC= rm2.obtenerClasesDerivadas(listaC);
          listaC = oR.refactorizar(listaC);
          gCodigoR.generarCodigo(listaC);
          
    }
    
  
    
}

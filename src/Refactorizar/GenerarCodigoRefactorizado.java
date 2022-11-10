package Refactorizar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STRawGroupDir;
import org.stringtemplate.v4.StringRenderer;
import ClasesTipo.*;

public class GenerarCodigoRefactorizado {

    public void generarCodigo(ArrayList<Clase> listaDeClasesObjetos) throws IOException {

        File file;
        for (Clase clase : listaDeClasesObjetos) {
        	STGroup g = new STRawGroupDir("D:/WorkSpace/REFACTO/src/Plantilla");
            g.registerRenderer(String.class, new StringRenderer());
            ST st = g.getInstanceOf("plantilla");
            st.add("paquete",clase.getPaquete());
            st.add("clase",clase);
            creardirectorio(clase.getPaquete());
            file = new File("D:/Pruebas/ST/"+clase.getPaquete()+"/" + clase.getNombre() + ".java");
            FileWriter w = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(st.render());
            wr.close();
            bw.close();
  //        clase.add(file);
        }

    }
    
    private void creardirectorio(String ruta){

    	
        File directorio = new File("D:/Pruebas/ST/"+ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
            } else {
            }
        }
        
    }

}

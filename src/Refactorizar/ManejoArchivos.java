package Refactorizar;

import ANTLR4.JavaLexer;
import ClasesTipo.Clase;
import ANTLR4.JavaParser;
import ANTLR4.JavaParserBaseListener;
import ClasesTipo.Extra;
import ClasesTipo.Metodo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ManejoArchivos {

    JavaParserBaseListener Oparser = new JavaParserBaseListener();
    ArrayList<Clase> listaClases = new ArrayList<Clase>();
    ArrayList<File> archivosJava = new ArrayList<>();

    void seleccionar_archivos() {
        List<File> listaDeArchivos = new ArrayList<>();
        Scanner entrada = null;
        //Se crea el JFileChooser. Se le indica que la ventana se abra en el directorio actual
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setMultiSelectionEnabled(true);
        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
        //el segundo es la extensión de los ficheros que se van a mostrar      
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos java (.java)", "java");
        //Se le asigna al JFileChooser el filtro
        fileChooser.setFileFilter(filtro);

        //para seleccionar solo carpetas
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //se muestra la ventana
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            listaDeArchivos.addAll(Arrays.asList(fileChooser.getSelectedFiles()));

            for (File carpetaOdocumento : listaDeArchivos) {
                buscarArchivos(carpetaOdocumento);
            }

            for (File archivo : archivosJava) {
                try {
                    FileInputStream archivo1 = new FileInputStream(archivo.getAbsolutePath());
                    recorreArchivos(archivo1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Orquestador.class.getName()).log(Level.SEVERE, null, ex);
                }
//                System.out.println("");

            }

        } else {
            System.out.println("No se ha seleccionado ningún fichero");
        }
       
        
        listaClases = Oparser.obtenerListaDeClases();
        
    }

    private void buscarArchivos(File carpeta) {
        File[] archivos = null;

        if (carpeta.isDirectory()) {
            archivos = carpeta.listFiles();
        } else {
            File[] aux = new File[1];
            aux[0] = carpeta;
            archivos = aux;
        }

        if (archivos != null || archivos.length > 0) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    buscarArchivos(archivo);
                } else {
                    if (archivo.getPath().endsWith(".java")) {
                        archivosJava.add(archivo);
                    }
                }
            }

        }

    }//termina metodo

    private void recorreArchivos(FileInputStream archivo) {
        try {
            CharStream cs = CharStreams.fromStream(archivo);
            JavaLexer lexer = new JavaLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JavaParser parser = new JavaParser(tokens);
            RuleContext tree = parser.compilationUnit();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(Oparser, tree);
          
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

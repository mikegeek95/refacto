package ClasesTipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Clase {

    private boolean refact=false;
	private String nombre;
    private String calificador;
    private String paquete;
    public ArrayList<Metodo> metodos;
    public Map <String,Metodo> metodos2;
    public ArrayList<String> importaciones;
    private String clasePadre;
    public ArrayList<String> variables;
    private boolean abstracta;
    private boolean esInterfaz;
    private boolean heredaDeClase;
    private boolean ImplementaDeClase;
    private String ClaseImplementada;
    public Map <String,ArrayList<Clase>> familia;
    public boolean refactorizada;
    private String parametros;
    public ArrayList<String> varNew;
    public Map<String, String> var_b;
    public Map <String,Clase> fam_mapa;
    

    public Clase() {
        nombre = "";
        calificador = "";
        paquete = "";
        metodos = new ArrayList<>();
        importaciones = new ArrayList<>();
        variables = new ArrayList<>();
        clasePadre = "";
        abstracta = false;
        esInterfaz = false;
        heredaDeClase = false;
        familia = new HashMap<>();
        parametros = "";
        varNew = new ArrayList<>();
        var_b = new HashMap<>();
        metodos2 = new HashMap<>();
        fam_mapa = new HashMap<>();

    }

    public void setrefact(boolean valorrefact) {
    	refact = valorrefact;
    }

    public boolean getRefact() {
        return refact;
    }
    
    public void setNombre(String valornombre) {
        nombre = valornombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificador(String valorCalificador) {
        calificador = valorCalificador;
    }

    public String getCalificador() {
        return calificador;
    }

    public void setPaquete(String valorPaquete) {
        paquete = valorPaquete;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setClasePadre(String valorClaseP) {
        clasePadre = valorClaseP;
    }

    public String getClasePadre() {
        return clasePadre;
    }

    public void setMetodos(ArrayList<Metodo> valorMetodos) {
        metodos = valorMetodos;
    }

    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }

    public void setImportaciones(ArrayList<String> valorImportacion) {
        importaciones = valorImportacion;
    }

    public ArrayList<String> getImportaciones() {
        return importaciones;
    }

    public void setVariables(ArrayList<String> varRes) {
        variables = varRes;
    }

    public ArrayList<String> getVariables() {
        return variables;
    }
    public void setAbstracta(boolean valorAbsracta) {
        abstracta = valorAbsracta;
    }

    public boolean getAbstracta() {
        return abstracta;
    }
    
    public void setHeredaDeClase(boolean valorHereda) {
        heredaDeClase = valorHereda;
    }

    public boolean getHeredaDeClase() {
        return heredaDeClase;
    }
    
    public void setFamilia(Map<String, ArrayList<Clase>> valorFam) {
        familia = valorFam;
    }

    public Map<String,ArrayList<Clase>> getFamilia() {
        return familia;
    }
    public void setRafactorizada(boolean valorRefactorizada) {
        refactorizada = valorRefactorizada;
    }

    public boolean getRefactorizada() {
        return refactorizada;
    }
    
      public void setEsInterfaz(boolean valorInterfaz) {
        esInterfaz = valorInterfaz;
    }

    public boolean getEsInterfaz() {
        return esInterfaz;
    }
    
     public void setParametros(String valorParametros) {
        parametros = valorParametros;
    }

    public String getParametros() {
        return parametros;
    }
    
    public void setVarNew(ArrayList<String> valorvarNew) {
        varNew = valorvarNew;
    }

    public ArrayList<String> getVarNew() {
        return varNew;
    }
    
    public void setVar_b(Map<String, String> mapVar) {
        var_b = mapVar;
    }

    public Map<String, String> getVar_b() {
        return var_b;
    }
    
    public void setMetodos2(Map<String, Metodo> valorMetodos2) {
        metodos2 = valorMetodos2;
    }

    public Map<String,Metodo> getMetodos2() {
        return metodos2;
    }
    
      public void setFam_Mapa(Map<String, Clase> valorFamMapa) {
        fam_mapa = valorFamMapa;
    }

    public Map<String,Clase> getFam_Mapa() {
        return fam_mapa;
    }

	public void setClaseImplementada(String ClaseImplementada) {
		this.ClaseImplementada=ClaseImplementada;
		
	}
	
	public String getClaseImplementada() {
		return ClaseImplementada;
	}

	public void setImplementaDeClase(boolean ImplementaDeClase) {
		this.ImplementaDeClase=ImplementaDeClase;
		
	}
	
	public boolean getImplementaDeClase() {
		return ImplementaDeClase;
	}
    
}

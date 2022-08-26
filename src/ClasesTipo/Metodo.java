package ClasesTipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metodo {

    private String nombre;
    private String calificador;
    public List<String> atributos;
    private String tipo;
    private boolean estatico;
    private boolean abstracto;
    private String cuerpo;
    private boolean esFriendly;
    private boolean esOverride;
    private String cuerpoSNparametros;
    public Map <String,String> parametros;
   

    public Metodo() {
        cuerpo = "";
        calificador = "";
        nombre = "";
        tipo = "";
        estatico = false;
        abstracto = false;
        atributos = new ArrayList<String>();
        esFriendly = false;
        esOverride = false;
        cuerpoSNparametros = "";
        parametros = new HashMap<String, String>();

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

    public void setTipo(String valorTipo) {
        tipo = valorTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEstatico(boolean valorEstatico) {
        estatico = valorEstatico;
    }

    public boolean getEstatico() {
        return estatico;
    }

    public void setCuerpo(String valorCuerpo) {
        cuerpo = valorCuerpo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setAtributos(List<String> valorAtributos) {
        atributos = valorAtributos;
    }

    public List<String> getAtributos() {
        return atributos;
    }
    
    public void setAbstracto(boolean valorAbsracto) {
        abstracto = valorAbsracto;
    }

    public boolean getAbstracto() {
        return abstracto;
    }
    
     public void setEsFRiendly(boolean valorFrienfly) {
        esFriendly = valorFrienfly;
    }

    public boolean getEsFRiendly() {
        return esFriendly;
    }
    
    public void setEsOverride(boolean valorOverride)
    {
        esOverride = valorOverride;
    }
    
    public boolean getEsOverride()
    {
        return esOverride;
    }
    
     public void setCuerpoSNparametros(String valorCuerpoSP) {
        cuerpoSNparametros = valorCuerpoSP;
    }

    public String getCuerpoSNparametros() {
        return cuerpoSNparametros;
    }
    
     public void setParametros(Map<String, String> valorParametros) {
        parametros = valorParametros;
    }

    public Map<String,String> getParametros() {
        return parametros;
    }

}

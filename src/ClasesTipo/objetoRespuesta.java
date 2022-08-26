package ClasesTipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class objetoRespuesta {
    
    private Map mapaDeClases;
    private ArrayList<Clase> listaDeClases;

    public objetoRespuesta() {
        mapaDeClases = new HashMap<>();
        listaDeClases = new ArrayList<>();
    }
    
     public void setListaClases(ArrayList<Clase> valorClases) {
        listaDeClases = valorClases;
    }

    public ArrayList<Clase> getListaClases() {
        return listaDeClases;
    }
    
     public void setMapaClases(Map valorMapa) {
        mapaDeClases = valorMapa;
    }

    public Map getMapaClases() {
        return mapaDeClases;
    }
    
    
     

}

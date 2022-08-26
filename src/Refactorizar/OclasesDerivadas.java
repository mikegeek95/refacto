package Refactorizar;

import ClasesTipo.Clase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OclasesDerivadas {

    ArrayList<Clase> listaDeClasesPapa = new ArrayList<>();
    ArrayList<Clase> listaFamilia = new ArrayList<>();
    ArrayList<Clase> listaAuxHijos = new ArrayList<>();
    Map<String, ArrayList<Clase>> map = new HashMap<>();
    Map<String, Clase> mapH= new HashMap<>();
//    ArrayList<Integer> listaIndices = new ArrayList<>();

    public ArrayList<Clase> obtenerClasesDerivadas(ArrayList<Clase> listaDeClases) {

        ArrayList<Clase> listaCopia = new ArrayList<>();
        listaCopia = (ArrayList<Clase>) listaDeClases.clone();

        for (Clase claseP : listaDeClases) {
            if (claseP.getNombre().equals("aDistribution")) {
                System.err.println("aDistribution");
            }
            listaFamilia = new ArrayList<>();
            mapH= new HashMap<>();
            map = new HashMap<>();
            obtenerHijos(claseP, listaDeClases, null);
            if(!listaFamilia.isEmpty()){
            map.put(claseP.getNombre(), listaFamilia);
            int index = listaDeClases.indexOf(claseP);
            listaCopia.get(index).setFamilia(map); 
            listaCopia.get(index).setFam_Mapa(mapH); 
            }
        }

        return listaDeClases;
    }

    private void obtenerClasesPapa(ArrayList<Clase> listaDeClases) {

        for (Clase clase : listaDeClases) {
            if (clase.getClasePadre().equals("")) {
                listaDeClasesPapa.add(clase);
            }
        }
    }

    private void obtenerHijos(Clase clasePapa, ArrayList<Clase> listaDeClases, ArrayList<Clase> listaAux) {
        ArrayList<Clase> listaCopia = new ArrayList<>();
        listaCopia = (ArrayList<Clase>) listaDeClases.clone();

        if (listaAux!= null && !listaAux.isEmpty()) {
            listaAuxHijos = new ArrayList<>();
            for (Clase cH : listaAux) {
                for (Clase cN : listaDeClases) {
                    if (cN.getClasePadre().equals(cH.getNombre())) {
                        listaFamilia.add(cN);
                        mapH.put(cN.getNombre(), cN);
                        listaAuxHijos.add(cN);
                        listaCopia.remove(cN);
                    }
                }
            }
        } else if (listaAux == null) {
            listaAuxHijos = new ArrayList<>();
            for (Clase cH : listaDeClases) {
                if (cH.getClasePadre().equals(clasePapa.getNombre())) {
                    listaFamilia.add(cH);
                    mapH.put(cH.getNombre(), cH);
                    listaAuxHijos.add(cH);
                    listaCopia.remove(cH);
                }
            }
        }
        if (!listaAuxHijos.isEmpty()) {
            obtenerHijos(null, listaCopia, listaAuxHijos);
        }
    }

}
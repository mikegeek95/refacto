package Refactorizar;

import ClasesTipo.Clase;
import ClasesTipo.Metodo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Refactorizar {

 
    private Map<String, Clase> mapClasesAux = new HashMap<String, Clase>();
    
	private ArrayList<ArrayList<Clase>> jerarquias=new ArrayList<ArrayList<Clase>>();
	private ArrayList<Clase> jerarquia=new ArrayList<Clase>();
	private ArrayList<Clase> clasesBaseP =new ArrayList<Clase>();
    private ArrayList<Clase> cHijas = new ArrayList<Clase>();

    
    public ArrayList<Clase> refactorizar(ArrayList<Clase> listaDeClases) {
    	
    crearMapaDeClasesAux(listaDeClases);
    armarJerarquia(listaDeClases);
    ArrayList<Clase> listaCopia =  listaDeClases;
    


    
        for (Clase cA : listaDeClases) {

            
        	for (Map.Entry<String, String> entry : cA.getVar_b().entrySet()) {
        		//System.out.println("variable "+entry.getKey()+" de tipo "+entry.getValue()+" de la clase "+cA.getNombre());
	            if(esPublic(cA, listaCopia, entry.getKey())){
	            	//System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango publico");
	            	cA.setVariables(refact(cA.getVariables(),entry.getKey(), "public",entry.getValue()));
	            	//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "public",entry.getValue()));
	            	continue;
	            }
				else if(esProtectec(cA, listaCopia, entry.getKey())) {
					//System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+"encontrado en rango protectec");
					cA.setVariables(refact(cA.getVariables(),entry.getKey(), "protected",entry.getValue())); 
					//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "protected",entry.getValue()));
					continue;
			    }
	            else if(esfriendly(cA, listaCopia, entry.getKey())) {
	            	//System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango friendly");
	            	cA.setVariables(refact(cA.getVariables(),entry.getKey(), "",entry.getValue()));
	            	//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "",entry.getValue()));
	            	continue;
	            } 
				else if(esPrivate(cA, entry.getKey())) {
					//System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango private");
					cA.setVariables(refact(cA.getVariables(),entry.getKey(), "private",entry.getValue()));
					//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "private",entry.getValue()));
					continue;
				}
				else {
					//System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" moviendo a local");
					cA=moverLocal(cA,entry.getKey(),entry.getValue());
					continue;
				}
        	}
        }
 
        return listaDeClases;
  }






	private boolean esPublic(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
    	boolean verif= false;
    	nombrevar=obtenernombre(nombrevar); 
    	for (Clase cC : listaCopia) {
    		if(cC.getPaquete()!=cA.getPaquete() && !cC.getEsInterfaz() && (buscarEnImportaciones(cA,cC)|| hijosImportados(cA,cC)) && !cA.getNombre().equals(cC.getClasePadre())) {
	    			 if(reglasBusqueda(cA, cC,nombrevar)) {
	    				verif=true;
	    				break;
	    			}else if (accesoJerarky(cA, cC,nombrevar)) {
	    				verif=true;
	    				break;
	    			}
    			
    		}
    	}
		return verif;
	}



	private boolean accesoJerarky(Clase cA, Clase cC, String nombrevar) {
		boolean verif=false;
		for(ArrayList<Clase> j : jerarquias ) {
			for(Clase cj: j) {
				if(comprobacion(cA,j))
				if(reglasBusqueda(cj, cC,nombrevar)) {
					verif=true;
					break;
				}
			}
		}
		
		return verif;
	}






	private boolean hijosImportados(Clase cA, Clase cC) {
		boolean verif=false;
		for(ArrayList<Clase> j : jerarquias ) {
			for(Clase cj: j) {
				if(comprobacion(cA,j))
				if(buscarEnImportaciones(cj, cC)) {
					verif=true;
				}
			}
		}

		return verif;
	}






	private boolean esfriendly(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
		boolean verif=false;
		nombrevar=obtenernombre(nombrevar); 

		for (Clase cC : listaCopia) {
    		if(cC.getPaquete().equals(cA.getPaquete()) && !cC.getEsInterfaz() && cC.getNombre()!=cA.getNombre()&&!cC.getClasePadre().equals(cA.getNombre())) {
	    		if(reglasBusqueda(cA, cC,nombrevar)) {
	    			verif=true;
	    			break; 	
				}else if (accesoJerarky(cA, cC,nombrevar)) {
					verif=true;
					break;
					}
    			}
    		}
		return verif;
	}

	private boolean esProtectec(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
		boolean verif= false;
		nombrevar=obtenernombre(nombrevar); 


		for(Clase cC:listaCopia) {
			if( !cC.getEsInterfaz() && cC.getHeredaDeClase()&&cC.getClasePadre().equals(cA.getNombre())) {

					for(Metodo mtd:cC.getMetodos()) {
						String[] part=mtd.getCuerpo().split("\n");
						for(int x=0;x<part.length;x++) {
							if (reglas(part[x])) {
								if(buscarPalabra(nombrevar,part[x]) || buscarPalabra("this."+nombrevar,part[x])) {
									verif=true;
									break;
								}
							}
						}
					}
				}
			}
		
		
		return verif;
	}

	private boolean esPrivate(Clase cA, String nombrevar) {
		boolean verif=false;
		int cont=0;
		nombrevar=obtenernombre(nombrevar); 
		
		for(Metodo met : cA.getMetodos()) {
			if(!met.getAbstracto()) {
				String[] partc=met.getCuerpo().split("\n");
				for(int x=0;x<partc.length;x++) {
					if(reglas(partc[x])) {
						if(buscarPalabra(nombrevar,partc[x])) {
							cont++;
							
						}
					}
				}
			}
		}
		
		if(cont>1) {
			verif=true;
		}
		
		
		return verif;
	}

	private boolean reglasBusqueda(Clase cA, Clase cC, String nombrevar) {
    	boolean verif=false;
		String variableobjeto = null;
		boolean objetoatributo=false;
    	String[] comp;
		String[] obj;
		nombrevar=obtenernombre(nombrevar); 

		
		for(Map.Entry<String, String> entry: cC.getVar_b().entrySet() ) {
			//getkey variable---getvalue tipo
			if(entry.getValue().contains(cA.getNombre()) ) { 
					variableobjeto=obtenernombre(entry.getKey());
					objetoatributo=true;
					break;
			}
		}
		if(objetoatributo) {
			for(Metodo met: cC.getMetodos()) {
				if(!met.getAbstracto()) {
					String[] partc=met.getCuerpo().split("\n");
					for(int x=0;x<partc.length;x++) {
						if(reglas(partc[x].trim())) {
							if(buscarPalabra(variableobjeto+"."+nombrevar,partc[x]) || ( partc[x].contains(variableobjeto+".") && partc[x].contains("."+nombrevar) ) ) {
								verif= true;
								break;

							}
						}
					}
				}
				
			}
	    }
	else  {
		for(Metodo met: cC.getMetodos()) {
			if(!met.getAbstracto()) {
				String[] partc=met.getCuerpo().split("\n");
				for(int x=0;x<partc.length;x++) {
					partc[x]=partc[x].trim();
					if(reglas(partc[x])) {
					if(buscarPalabra("new "+cA.getNombre(),partc[x])|| buscarPalabra("new"+cA.getNombre(),partc[x])) {
						comp=partc[x].split("=");
						obj=comp[0].split(" ");    
						for(int y=0;y<obj.length;y++) {
							if(obj[y].equals(cA.getNombre())) {
								if(buscarPalabra(obj[y+1]+"."+nombrevar,met.getCuerpo())  ) {
									verif= true;
									break;
								}
							}	
						}
					}
					else if(buscarPalabra(cA.getNombre()+"."+nombrevar,partc[x])  ) {
						verif= true;
						break;
    					}
					}
				}
			}
		}
	}

		
	return verif;
	}


	private ArrayList<String> refact(ArrayList<String> variables, String variable, String calificador, String tipo) {
		String califact;
		String[] subsvar;
		String varnew;
		String copyvar=variable;
		String estatic="";
		String finaly="";
		ArrayList<String> variablesnew= new ArrayList<String>();
		variable=obtenernombre(variable);
		
		for(String var:variables) { 
			if(buscarPalabra(variable,var)) {
				califact=valifcalif(var);
				if (var.contains("=")) {
					subsvar=var.split("=");
					subsvar=subsvar[0].split(",");
				}else {
					subsvar=var.split(",");
				}
				
				if(subsvar.length==1) {
					if(califact.equals(calificador)) {
						variablesnew.add(var);
					}
					else {
						//if(levelprotectd(calificador) > levelprotectd(califact)) {
							if(califact.equals("")) {
								var=(calificador+" "+var);
								variablesnew.add(var);
							}
							else {
								var=var.replace(califact, calificador);
								variablesnew.add(var);
							}
						//}
					}
				}else {
				
					if(buscarPalabra("static",var)) {
						estatic="static ";
					}
					else if(buscarPalabra("final",var)) {
						finaly ="final ";
					}
					if(califact.equals(calificador)) {
						variablesnew.add(var);
					}else {
						
						//if(levelprotectd(calificador) > levelprotectd(califact)) {
						varnew=calificador+" "+estatic+""+finaly+""+tipo+" "+copyvar;
						variablesnew.add(varnew);
						varnew="";
						for(String v: subsvar) {
							v=obtenernombre(v);
							if(!v.equals(obtenernombre(copyvar))) {
							varnew=varnew+v+",";
							}
						}
						if(buscarPalabra(copyvar,varnew)) {
							varnew=varnew.replace(copyvar+",","");
						}
						varnew = varnew.substring(0, varnew.length()-1);
						variablesnew.add(varnew);
					//}

				}
				}
						
	
				
			}
			else {
				variablesnew.add(var);
			}
		}
		return variablesnew;
	}
	
	private int levelprotectd(String califact) {
		int level = 0;
		TreeMap<String, Integer> tree_map  = new TreeMap<String, Integer>();
		tree_map.put("private",100);
        tree_map.put("protected",75);
        tree_map.put("",50);
        tree_map.put("public",25);
        
        for (Entry<String, Integer> entry : tree_map.entrySet()) {
        	if (entry.getKey().equals(califact)) {
        		level=entry.getValue();
        	}
        }

		return level;
	}






	private String obtenernombre(String variable) {
		String[] nom=variable.split("=");
		return nom[0].trim();
	}
	
	private String valifcalif(String variable) {
		String resp=null;
		String[] calificadores={"public","protected","private"};
		
		for(String calif:calificadores) {
			if(buscarPalabra(calif, variable)) {
				resp=calif;
			}
		}
		if (resp==null) {
			resp="";
		}
		return resp;
	}
	


	private void crearMapaDeClasesAux(ArrayList<Clase> listaClases) {
        for (Clase c : listaClases) {
            String key = c.getNombre();
            if (!mapClasesAux.containsKey(key)) {
                mapClasesAux.put(key, c);
            }
        }
    }
	
	boolean buscarPalabra ( String palabra,  String frase) {
		boolean encontrado=false;
		String[] palabras;
		String[] subpalabra =palabra.split("\\W+");
		if(subpalabra.length==1) {
			palabras = frase.split("\\W+");
			for(String palb:palabras) {
				if(palb.equals(palabra)) {
					encontrado=true;
				}
			}

		}else {
			if(frase.contains(palabra)) {
				encontrado=true;
			}
		}
		return  encontrado;
	}
		

	private Clase moverLocal(Clase cA, String variable, String tipo) {
		String metodo="";
		String [] lineas;
		String nuevocuerpo="";
		String copyvar=variable;
		String varnew;
		ArrayList<String> variablesnew= new ArrayList<String>();
		String[] subsvar;
		int cl;
		
		variable=obtenernombre(variable);

		
		for(Metodo met: cA.getMetodos()) {
			if(!met.getAbstracto()) {
				String[] partc=met.getCuerpo().split("\n");
				for(int x=0;x<partc.length;x++) {
					if(reglas(partc[x])) {
						if(buscarPalabra(variable,partc[x]) && !buscarPalabra("this",partc[x])&& !buscarPalabra("return",partc[x])&& !buscarPalabra(tipo,partc[x])) {
							metodo=met.getNombre();
						}
					}
				}
			}
		}
		
		if(!metodo.equals("") ) {
			for(Metodo met : cA.getMetodos()) {
				if (met.getNombre().equals(metodo)) {
					lineas=met.getCuerpo().split("\n");
					
					for(cl=0;cl<lineas.length;cl++) {
						if(buscarPalabra("{",lineas[cl]) && (cl==0 || cl==1)) {
							if(!buscarPalabra("=",copyvar)) {
								copyvar=copyvar+" = null";
							}
							nuevocuerpo=nuevocuerpo+lineas[cl]+"\n"+tipo+" "+copyvar+";"+"\n";
						}
						else {
							nuevocuerpo=nuevocuerpo+lineas[cl]+"\n";
						}
					}
					met.setCuerpo(nuevocuerpo);
				}
				
				
			}
			//inicia eliminacion
			for(String var:cA.getVariables()) { 
				if(buscarPalabra(variable,var)) {
						subsvar=var.split(",");
						if(subsvar.length==1) {
							
					}else {
						varnew=var.replace(copyvar,"");
						if (buscarPalabra(",,",varnew)) {
							varnew=varnew.replace(",,", ",");
						}
						variablesnew.add(varnew);		

				}
				
				}else{
					variablesnew.add(var);
				}
			}
			//termian eliminacion
			cA.setVariables(variablesnew);
		}else {
		}
		
		return cA;
	}
	
	private boolean buscarEnImportaciones(Clase claseA, Clase ClaseB) {
        boolean verif = false;
        String paqueteNombre = claseA.getPaquete() + "." + claseA.getNombre();

        for (String importacion : ClaseB.getImportaciones()) {
            if (importacion.contains(paqueteNombre)) {
                verif = true;
                break;
            }
        }
        
        return verif;
    }
	
	

    
	public boolean reglas(String linea) { // metodo de tipo I/O
		linea=linea.trim();
		boolean comentario1 = linea.startsWith("/*");
		boolean comentario2 = linea.startsWith("//");
		boolean comentario3 = linea.startsWith("*/");
		boolean lineaVacia = (linea.length() == 0);
		
		if(!(comentario1 || comentario2 || comentario3 || lineaVacia)) {
			return true;
		}
		else {
			return false;
			}
		}
	
	private void armarJerarquia(ArrayList<Clase> listaC) {
		
		obtenerClasesBase(listaC);
		
			for(Clase h: cHijas) {	
				jerarquia.add(h);
				bucarpadre(h);
				jerarquias.add(new ArrayList<Clase>(jerarquia));
				jerarquia.clear();
			}
			
			//System.out.println("Nivel de protección modular protected del proyecto : "+TVPr+"/"+TACp+"="+PMAPr);
			
		}
	
	private void obtenerClasesBase(ArrayList<Clase> listaC) {
	    for (Clase cP : listaC) {
	    	for(Clase cH: listaC) {
	    		if((cH.getHeredaDeClase() )&& cH.getClasePadre().equals(cP.getNombre())) {
	    			cHijas.add(cH);
	    			clasesBaseP.add(cP);
	    		}
	    	}
	    }

	    limpiarlista(clasesBaseP);
	    lastgeneration();
	}
	
	private void bucarpadre(Clase h) {
		for(Clase cp: clasesBaseP) {
			if(h.getClasePadre().equals(cp.getNombre()) && ((h.getPaquete().equals(cp.getPaquete()) && !buscarEnImportaciones(cp,h))||( !h.getPaquete().equals(cp.getPaquete()) && buscarEnImportaciones(cp,h) ) ) ){
				if(!comprobacion(cp,jerarquia)) {
				jerarquia.add(cp);
				if(cp.getHeredaDeClase()) {
					bucarpadre(cp);
				}
				}
			}
		}
		
	}



	private boolean comprobacion(Clase cp, ArrayList<Clase> array) {
		boolean verif= false;
		for(Clase c: array) {
			if(c.equals(cp)) {
				verif=true;
			}
		}
		return verif;
	}



	private void limpiarlista(ArrayList<Clase> array) {
		
		for(int x=0;x<array.size();x++) {
			if( x<array.size()-1){
				if (array.get(x)==array.get(x+1)) {
					array.remove(x);
			}
			}
		}
		
		
	}


	private void lastgeneration() {
		
		for(int x=0;x<cHijas.size();x++) {
			for(int y=0;y<clasesBaseP.size();y++) {
				if(cHijas.get(x).equals(clasesBaseP.get(y))){
					cHijas.remove(x);
				}
			}
		}
		
		
	}
	
}

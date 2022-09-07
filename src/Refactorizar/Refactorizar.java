package Refactorizar;

import ClasesTipo.Clase;
import ClasesTipo.Metodo;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Refactorizar {

    Map<String, Clase> mapClases = new HashMap<String, Clase>();
    Map<String, Clase> mapClasesAux = new HashMap<String, Clase>();
    Map<String, Clase> mapPadreA = new HashMap<String, Clase>();
    Map<String, Clase> mapClasesNuevas = new HashMap<String, Clase>();
    ArrayList<Clase> listaFinal = new ArrayList<>();
    Map<String, String> mapMetodosEvaluados = new HashMap<String, String>();

    Map<Clase, String> mapPrueba = new HashMap<Clase, String>();
    public ArrayList<Clase> refactorizar(ArrayList<Clase> listaDeClases) {
    crearMapaDeClasesAux(listaDeClases);
    ArrayList<Clase> listaClasesNueva = new ArrayList<>();

        for (Clase cA : listaDeClases) {
        	
        	ArrayList<Metodo> listaMetodosN = new ArrayList<>();
            ArrayList<Clase> listaCopia = new ArrayList<>();
            listaCopia = (ArrayList<Clase>) listaDeClases.clone();
            
        	for (Map.Entry<String, String> entry : cA.getVar_b().entrySet()) {
        		
        		System.out.println("****************************************************");
        		System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" ");
        		System.out.println("****************************************************");
	            if(esPublic(cA, listaCopia, entry.getKey())){
	            	System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango publico");
	            	cA.setVariables(refact(cA.getVariables(),entry.getKey(), "public",entry.getValue()));
	            	//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "public",entry.getValue()));
	            	continue;
	            }
				else if(esProtectec(cA, listaCopia, entry.getKey())) {
					System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+"encontrado en rango protectec");
					cA.setVariables(refact(cA.getVariables(),entry.getKey(), "protected",entry.getValue())); 
					//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "protected",entry.getValue()));
					continue;
			    }
	            else if(esfriendly(cA, listaCopia, entry.getKey())) {
	            	System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango friendly");
	            	cA.setVariables(refact(cA.getVariables(),entry.getKey(), "",entry.getValue()));
	            	//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "",entry.getValue()));
	            	continue;
	            } 
				else if(esPrivate(cA, entry.getKey())) {
					System.out.println(entry.getKey()+" de la clase "+cA.getNombre()+" encontrado en rango private");
					cA.setVariables(refact(cA.getVariables(),entry.getKey(), "private",entry.getValue()));
					//cA.setVarNew(refact(cA.getVarNew(),entry.getKey(), "private",entry.getValue()));
				}
				else {
					cA=moverLocal(cA,entry.getKey(),entry.getValue());
				}
        	}   
    }
        
 
        
        return listaDeClases;
  }


	private boolean esPublic(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
    	boolean verif= false;
    	nombrevar=obtenernombre(nombrevar); 
    	for (Clase cC : listaCopia) {
    		if(cC.getPaquete()!=cA.getPaquete() && !cC.getEsInterfaz() && buscarEnImportaciones(cA,cC) && !cA.getNombre().equals(cC.getClasePadre())) {
    			verif=reglasBusqueda(cA, cC.getVariables(),nombrevar, cC.getMetodos());
    		}
    	}
		return verif;
	}

	private boolean esfriendly(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
		boolean verif=false;
		
		nombrevar=obtenernombre(nombrevar);
		
		for (Clase cC : listaCopia) {
    		if(cC.getPaquete().equals(cA.getPaquete()) && !cC.getEsInterfaz() && cC.getNombre()!=cA.getNombre()) {
    			verif=reglasBusqueda(cA, cC.getVariables(),nombrevar, cC.getMetodos());
    		}
    	}
		return verif;
	}

	private boolean esProtectec(Clase cA, ArrayList<Clase> listaCopia, String nombrevar) {
		boolean verif= false;
		
		nombrevar=obtenernombre(nombrevar);

		for(Clase cC:listaCopia) {
			if(cA.getPaquete()!=cC.getPaquete() && !cC.getEsInterfaz() && buscarEnImportaciones(cA,cC) && cC.getHeredaDeClase() && cA.getNombre().equals(cC.getClasePadre())) {
				for(Metodo mtd:cC.getMetodos()) {
					String[] part=mtd.getCuerpo().split("\n");
					for(int x=0;x<part.length;x++) {
						if (reglas(part[x])) {
							if(buscarPalabra(nombrevar,part[x])) {
								verif=true;
							}
						}
					}
				}
			}
		}
		
		return verif;
	}

	private boolean esPrivate(Clase cA, String nombrevar) {

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
		return (cont>1)? true:false;
	}

	private boolean reglasBusqueda(Clase cA, ArrayList<String> variables, String nombrevar, ArrayList<Metodo> metodos) {
    	boolean verif=false;
		String variableobjeto = null;
		boolean objetoatributo=false;
    	String[] comp;
		String[] obj;
		
		nombrevar=obtenernombre(nombrevar);
		
		for(String var:variables) {
			if(buscarPalabra("new "+cA.getNombre(),var) || buscarPalabra("new"+cA.getNombre(),var)) {
				comp=var.split("=");
				obj=comp[0].split(" ");    
				for(int x=0;x<obj.length;x++) {
					if(obj[x].equals(cA.getNombre())) {
						variableobjeto=obj[x+1]+"."+nombrevar;
						objetoatributo=true;
					}	
				}	
			}
		}
	if(objetoatributo) {
			for(Metodo met: metodos) {
				if(!met.getAbstracto()) {
					if(reglas(met.getCuerpo()))
					if(buscarPalabra(variableobjeto,met.getCuerpo())) {
						
					verif=true;
					}
				}
				
			}
	    }
	else  {
		for(Metodo met: metodos) {
			if(!met.getAbstracto()) {
				String[] partc=met.getCuerpo().split("\n");
				for(int x=0;x<partc.length;x++) {
					if(reglas(partc[x])) {
					if(buscarPalabra("new "+cA.getNombre(),partc[x])|| buscarPalabra("new"+cA.getNombre(),partc[x])) {
						comp=partc[x].split("=");
						obj=comp[0].split(" ");    
						for(int y=0;y<obj.length;y++) {
							if(obj[y].equals(cA.getNombre())) {
								variableobjeto=obj[y+1]+"."+nombrevar;
								if(buscarPalabra(variableobjeto,met.getCuerpo())) {
									verif=true;
								}
							}	
						}
					}
					else if(buscarPalabra(cA.getNombre()+"."+nombrevar,partc[x])) {
    						verif=true;
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
		String [] pats;
		ArrayList<String> variablesnew= new ArrayList<String>();
		
		variable=obtenernombre(variable);
		
		for(String var:variables) { 
			if(buscarPalabra(variable,var)) {
				califact=valifcalif(var);
				
				subsvar=var.split(",");
				if(subsvar.length==1) {
				System.out.println("solo hay 1");
					if(califact.equals(calificador)) {
						variablesnew.add(var);
						System.out.println("todo bien  "+var);
					}
					else {
						if(califact.equals("")) {
							var=(calificador+" "+var);
							variablesnew.add(var);
							System.out.println("agregando calificador  "+var);
						}
						else {
							var=var.replace(califact, calificador);
							variablesnew.add(var);
							System.out.println("cambiando calificador  "+var);
						}
					}
				}else {
				
					if(buscarPalabra("static",var)) {
						estatic="static ";
					}
					System.out.println("mas de 1");
					if(califact.equals(calificador)) {
						variablesnew.add(var);
						System.out.println("todo bien  "+var);
					}else {
						
						varnew=calificador+" "+estatic+""+tipo+" "+copyvar;
						System.out.println("nuevar varieable "+varnew); 
						variablesnew.add(varnew);
						varnew="";
						for(String v: subsvar) {
							v=obtenernombre(v);
							if(!v.equals(obtenernombre(copyvar))) {
								System.out.println(v+" "+variable+" "+copyvar);
							varnew=varnew+v+",";
							}
						}
						if(buscarPalabra(copyvar,varnew)) {
							varnew=varnew.replace(copyvar+",","");
						}
						varnew = varnew.substring(0, varnew.length()-1);
						System.out.println("variable separada "+varnew);
						variablesnew.add(varnew);
					}
				}
						
	
				
			}
			else {
				variablesnew.add(var);
			}
		}
		
		System.out.println("variables refacto "+variablesnew);
		return variablesnew;
	}
	
	private String obtenernombre(String variable) {
		String[] nom=variable.split("=");
		return variable=nom[0].trim();
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
	
	private boolean buscarPalabra (String palabra, String frase) {
		boolean encontrado=false;
		String[] palabras;
		if(frase.contains(palabra)) {
			palabras = frase.split("\\W+");
			for(String palb:palabras) {
				if(palb.equals(palabra)) {
					encontrado=true;
				}
			}
		}
		return  encontrado;
	}

	private Clase moverLocal(Clase cA, String variable, String tipo) {
		System.out.println("moviendo a metodo local");
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
						if(buscarPalabra(variable,partc[x])) {
							metodo=met.getNombre();
						}
					}
				}
			}
		}
		
		if(!metodo.equals("") && buscarPalabra("new",copyvar)) {
			for(Metodo met : cA.getMetodos()) {
				if (met.getNombre().equals(metodo)) {
					lineas=met.getCuerpo().split("\n");
					
					for(cl=0;cl<lineas.length;cl++) {
						if(buscarPalabra("{",lineas[cl]) && (cl==0 || cl==1)) {
							nuevocuerpo=nuevocuerpo+lineas[cl]+"\n"+tipo+" "+copyvar+";"+"\n";
							System.out.println("***movido al metodo "+metodo);
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
						System.out.println("solo hay 1 se elimna");
					}else {
						varnew=var.replace(copyvar,"");
						System.out.println(" hay mas de 1 se remplaza");
						if (buscarPalabra(",,",varnew)) {
							varnew=varnew.replace(",,", ",");
							System.out.println("se corrige");
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
			System.out.println("--se recomienda eliminar la variable "+variable+" de la clase "+cA.getNombre());
		}
		
		return cA;
	}
	
    private boolean buscarEnImportaciones(Clase claseA, Clase ClaseB) {
        boolean encontradoEnImportaciones = false;
        String paqueteNombre = claseA.getPaquete() + "." + claseA.getNombre();

        for (String importacion : ClaseB.getImportaciones()) {
            if (importacion.contains(paqueteNombre)) {
                encontradoEnImportaciones = true;
            }

            if (encontradoEnImportaciones) {
                break;
            }
        }
        return encontradoEnImportaciones;
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
	
}

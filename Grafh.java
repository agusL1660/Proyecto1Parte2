package Grafo;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

import java.util.logging.Level;

import java.util.logging.LogRecord;


import java.util.logging.Logger;
import java.util.logging.Filter;




public class Grafh  {
	
	protected List<DVertice> nodos;
	protected List<ArcoD> arcos;
	private static Logger logger;
	
	public Grafh() {
		nodos = new LinkedList<DVertice>();
		arcos = new LinkedList<ArcoD>();
		
		if (logger == null){
			
			logger = Logger.getLogger(Grafh.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void  addNode(int node){
		
		
		if(vertice(node)!=null) {
			logger.warning("El nodo ya se encuentra en el grafo");
		}
		
		else {
			DVertice nuevo=new DVertice(node);
			nodos.add(nuevo);
			logger.fine( "El nodo " + node +" se ha creado con exito");

		}	
	}
	

	public void addEgde(int node1, int node2)  {
		
		DVertice inser1= vertice(node1);
		DVertice inser2= vertice(node2);
		boolean creado=false;
		
		if(inser1==null||inser2==null){
			logger.warning("Por lo menos un nodo no se encuentra en el grafo");
		}
		else {
			logger.info( "El nodo " + node1 +" y el nodo "+node2+" se encuentran en el grafo");
			if(!arcos.isEmpty()) {
				for( ArcoD e : arcos ) {			
					if(e.getV1().getRotulo()==inser1.getRotulo()&&e.getV2().getRotulo()==inser2.getRotulo()) {		
						creado=true;
					}
				}
			}
			if(creado) {logger.warning("El arco ya se encuentra creado en el grafo");}
			else {
				ArcoD arco= new ArcoD(inser1,inser2);
				arcos.add(arco);
				logger.fine( "Se creo el arco que une el nodo " + node1 +" y el nodo "+node2);
			}
		}
	}


	
	public void removeNode(int node) {

		DVertice v=vertice(node);
		if(v==null){
			logger.warning("El nodo no se encuentra en el grafo");
		}
		else {
			if(arcos.isEmpty()) {logger.info("El grafo no tiene arcos");}
			else {
				for( ArcoD e : arcos ) {
					if(e.getV1().getRotulo()==v.getRotulo()||e.getV2().getRotulo()==v.getRotulo()) {				
						removeEdge(e.getV1().getRotulo(),e.getV2().getRotulo());
					}
				}
			}	
			nodos.remove( v );
			logger.fine( "Se elimino el nodo" + node +" del grafo");

		}
		
		
	}


	
	public void removeEdge(int node1, int node2)   {
		ArcoD arco=null;
		DVertice aux1=vertice(node1);
		DVertice aux2=vertice(node2);
		if(aux1==null||aux2==null){
			logger.warning("Por lo menos un nodo no se encuentra en el grafo");
		}
		else {
			if(arcos.isEmpty()) {logger.warning("El grafo no tiene arcos");}
			else {
				for( ArcoD e : arcos ) {
					if(e.getV1()==aux1&&e.getV2()==aux2) {
						arco=e;
						break;
					}
				}
				if(arco==null) {logger.warning("El arco no se encuentra en el grafo");}
				else {
					logger.info( "Se encontro el arco que une el nodo" + node1 +" y el nodo "+node2);
					arcos.remove(arco);
					arco=null;
					logger.fine( "Se elimino el arco que unia el nodo " + node1 +" y el nodo "+node2+" del grafo");
	
				}	
			}
		}
		
	}
	
	private DVertice vertice(int n)  {
		
		DVertice  retorna=null;
		boolean parar=false;
		Iterator<DVertice> it=  nodos.iterator(); 
		if(it==null) {logger.warning("No hay nodos en el grafo");}

		while (!parar&&it.hasNext()) {
			retorna=it.next();
			if(retorna.getRotulo()==n) {
				parar=true;
			}
			else {retorna=null;}
			
		}

		return retorna;
	}

}
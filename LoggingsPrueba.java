package Grafo;
import java.util.ArrayList;
import java.util.List;
public class LoggingsPrueba {
	public static void main(String[] args) {

	Grafh grafo=new Grafh();
	System.out.println("Trata de remover un nodo de un grafo sin nodos");
	grafo.removeNode(1);
	System.out.println("Crea un nodo");
	grafo.addNode(1);
	grafo.addNode(2);
	grafo.addNode(3);
	System.out.println("Trata de remover un nodo que no esta en el grafo");
	grafo.removeNode(4);
	System.out.println("Trata de remover un arco de un grafo sin arcos");
	grafo.removeEdge(1,2);
	System.out.println("Crear arco con un nodo que no esta en el grafo");
	grafo.addEgde(2, 4);
	System.out.println("Crear arco en el grafo");
	grafo.addEgde(1, 2);
	System.out.println("Trata de remover un arco que no se encuentra en el grafo");
	grafo.removeEdge(2,3);
	System.out.println("Crear arco que ya se encuentra en el grafo");
	grafo.addEgde(1, 2);
	System.out.println("Crear un nodo que ya se encuentra en el grafo");
	grafo.addNode(2);
	System.out.println("Remueve un nodo del grafo");
	grafo.removeNode(3);
	System.out.println("Remueve un arco del grafo");
	grafo.removeEdge(1,2);

	

	
	}

}

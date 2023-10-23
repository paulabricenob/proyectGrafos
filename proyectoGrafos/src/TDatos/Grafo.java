/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;


public class Grafo {
    private int numVertex;
    private Nodo Graph[];


    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    public Nodo[] getGraph() {
        return Graph;
    }

    public void setGraph(Nodo[] Graph) {
        this.Graph = Graph;
    }
    
    public Grafo(int numVertex){
		this.numVertex = numVertex;
		Graph = new Nodo[this.numVertex];
		for(int i = 0; i < this.numVertex; i++){
			Graph[i] = null;
		}
	}
    
    public boolean existEdge(int n, int n2)
	{
		if(Graph[n] == null) return false;
		Nodo actual = Graph[n];
		while(actual != null){
			if(actual.getData() == Graph[n2])return true;
			actual = actual.getNext();
		}
		return false;
	}

    public void insertEdge(int s1, int s2){
	
		if(!existEdge(s1, s2)){
			Nodo nuevo = new Nodo(s2);
			
			if(Graph[s1] == null){
				Graph[s1] = nuevo;
			}
			else{
				Nodo actual = Graph[s1];
				while(actual.getNext() !=  null){
					actual = actual.getNext();
				}
				
				 actual.setNext(nuevo);
			}			
		}
		else{
			System.out.println("Error, arista ya creada" + s1 + "" + s2);
		}
	}
    
    public void deleteGraph(){
		for(int i = 0; i < Graph.length; i++){			
			Graph[i] = null;		
		}
	}
    
    public void showGraph(){
		for(int i = 0; i < Graph.length; i++){
			Nodo actual = Graph[i];
			
			while(actual != null){
				System.out.printf("d -> ", i);
				System.out.printf("d(%d)\n", actual.getData());
				
				actual = actual.getNext();
			}
			System.out.println(Graph);
		}
	}
}

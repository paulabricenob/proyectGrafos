/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import TDatos.*;

public class GrafoVisualizador {
    
    
    public static void vergrafo(String args[]) {
		System.setProperty("org.graphstream.ui", "swing");
		Graph graph = new SingleGraph("Tutorial 1");
                graph.setAttribute("ui.stylesheet", "node { text-alignment: under; }");
                
                for (Node node : graph) {
                node.setAttribute("ui.label", node.getId());
                }
                
                for (Node node : graph) {
                node.setAttribute("ui.style", "text-size: 20;");
                }
                
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");

		graph.display();
	}
    
}

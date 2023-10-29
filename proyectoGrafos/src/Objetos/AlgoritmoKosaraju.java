package Objetos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**

 * Esta clase define la funcion del lgoritmo de kosaraju, con la cual tiene diferentes atributos y funciones que lo definen

 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso

 * @version: 24/10/2023/A

 */
import java.util.*;
import TDatos.*;

public class AlgoritmoKosaraju {
    Grafo graf = new Grafo();
    //Campos de la clase
    public void kosaraju(Grafo users) {
        
        Lista usuarios = users.getusuarios();
        Pila<Persona> stack = new Pila<>();
        boolean[] visited = new boolean[usuarios.len()];

        // Paso 1: Llenar la pila con el orden de los vértices visitados
        for (int i = 0; i < usuarios.len(); i++) {
            if (!visited[i]) {
                DFS(i, visited, stack, usuarios);
            }
        }

        // Paso 2: Crear un grafo transpuesto
        Grafo transposedGraph = getTransposedGraph(usuarios);

        // Paso 3: Reiniciar el arreglo de visitados
        Arrays.fill(visited, false);

        // Paso 4: Realizar DFS en el grafo transpuesto
        while (!stack.isEmpty()) {
            Nodo<Persona> vertex = stack.pop();
            Persona per = vertex.getData();
            int vertexIndex = graf.UbicacionUsuario(per.getName());
            if (!visited[vertexIndex]) {
                // Imprimir o almacenar el componente fuertemente conectado
                DFSUtil(vertexIndex, visited, transposedGraph.getusuarios());
                System.out.println();
            }
        }
    }

    // Paso 2: Crear un grafo transpuesto
    public Grafo getTransposedGraph(Lista<Persona> usuarios) {
        Grafo transposedGraph = new Grafo();

        // Iterar sobre cada usuario en el grafo original
        for (int i = 0; i < usuarios.len(); i++) {
            Persona user = usuarios.get(i);
            String name = user.getName();

            // Crear un nuevo usuario en el grafo transpuesto con el mismo nombre
            transposedGraph.addusuario(name);

            // Iterar sobre cada persona conocida del usuario en el grafo original
            Lista<Arco> conocidos = user.getconocidos();
            for (int j = 0; j < conocidos.len(); j++) {
                Arco arco = conocidos.get(j);
                String start = arco.getStart();
                String end = arco.getEnd();

                // Agregar una arista en el grafo transpuesto desde la persona conocida al usuario
                transposedGraph.AgregarArco(end, start);
            }
        }

        return transposedGraph;
    }
//Metodo DFS
    private void DFS(int v, boolean[] visited, Pila<Persona> stack, Lista<Persona> usuarios) {
        visited[v] = true;
        Persona vertex = usuarios.get(v);
        Lista<Arco> conocidos = vertex.getconocidos();
        for (int i = 0; i < conocidos.len(); i++) {
            Arco arco = conocidos.get(i);
            String nam = arco.getEnd();
            int adjacentVertexIndex = graf.UbicacionUsuario(nam);
            if (!visited[adjacentVertexIndex]) {
                DFS(adjacentVertexIndex, visited, stack, usuarios);
            }
        }
        stack.push(vertex);
    }
//Metodo DFSUtil
    private void DFSUtil(int v, boolean[] visited, Lista<Persona> usuarios) {
        visited[v] = true;
        Persona vertex = usuarios.get(v);
        System.out.print(vertex.getName() + " ");

        Lista<Arco> conocidos = vertex.getconocidos();
        for (int i = 0; i < conocidos.len(); i++) {
            Arco arco = conocidos.get(i);
            String nam = arco.getEnd();
            int adjacentVertexIndex = graf.UbicacionUsuario(nam);
            if (!visited[adjacentVertexIndex]) {
                DFSUtil(adjacentVertexIndex, visited, usuarios);
            }
        }
    }
}


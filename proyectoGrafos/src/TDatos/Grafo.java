/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;
//import Objetos.Funciones;
import Objetos.Arco;
import Objetos.Persona;
import javax.swing.JOptionPane;




/**

 * Esta clase define el objeto Grafo, con la cual tiene diferentes atributos y funciones que lo definen

 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso

 * @version: 24/10/2023/A

 */

public class Grafo {
    private Lista<Persona> Usuarios;
    private Lista<Arco> conocidos;
//Campos de la clase
    //constructor
    public Grafo() {
        this.Usuarios = new Lista();
    }  
//getter
    public Lista getusuarios() {
        return Usuarios;
    }
//setter
    public void setususarios(Lista Usuarios) {
        this.Usuarios = Usuarios;
    }

// Esta funcion de la clase sirve para retornar la ubicacion del usuario
    public int UbicacionUsuario(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            if(Usuarios.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }
// Esta funcion de la clase sirve para retornar y encontrar una persona
    public Persona EncontrarPersona(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            Persona person = Usuarios.get(x);
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
// Esta funcion de la clase sirve para coniocer si una arista existe   
    public boolean edgeExist(String start, String end, Persona person){
        Lista conocidos = person.getconocidos();
        if(conocidos.isEmpty() == true){
            return false;
        }
        else{
            for(int x = 0; x < conocidos.len(); x++){
                Arco Arco = (Arco) conocidos.get(x);
                if(Arco.getStart() == start && Arco.getEnd() == end){
                    return true;
                }
                else if(Arco.getStart() == end && Arco.getEnd() == start){
                    return true;
                }
            }
            return false;
        }
    }
    
 // Esta funcion de la clase sirve para añadir usuario  
    public boolean addusuario(String name){
        this.conocidos = new Lista();
        Persona person = new Persona(name, conocidos);       
        boolean run = true;
        if(Usuarios.isEmpty()){
            Usuarios.append(person);
        }
        else{
            for(int x = 0; x < Usuarios.len(); x++){
                Persona pAux = (Persona) Usuarios.get(x);
                if(pAux.getName().equals(name)){
                    run = false;
                }
            }
            if(run){
                Usuarios.append(person);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error: persona ya agregada");
            }
        }
        return run;
    }
//Este metodo sirve para agregar un arco"arista" al grafo
    public void AgregarArco(String start, String end){
        try{
            
            Persona personStart = Usuarios.get(UbicacionUsuario(start));
            Persona personEnd = Usuarios.get(UbicacionUsuario(end));
            
            if(start == end){
                JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
            }
            
            else if(Usuarios.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: no hay vertices");
            }
            
            else if(edgeExist(start, end, personStart) || edgeExist(start, end, personEnd)){
                JOptionPane.showMessageDialog(null, "Error: relacion ya establecida con anterioridad");
            }  
            
            else{
                for(int x = 0; x < Usuarios.len(); x++){
                    int position = x;
                    Persona pAux = (Persona) Usuarios.get(x);

                    if(pAux.getName().equals(start)){
                        Arco arco = new Arco(start, end);
                        Lista conocidos = pAux.getconocidos();
                        conocidos.append(arco);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(position, pAux);                             
                    }
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: dato ingresado incorrecto");
        }       
    }
//Este metodo sirve para agregar un arco"arista" invertida al grafo transpuesto

    public void AgregarArcoinvertido(String end1, String start1){
        try{
            
            Persona personStart = Usuarios.get(UbicacionUsuario(end1));
            Persona personEnd = Usuarios.get(UbicacionUsuario(start1));
            
            if(end1 == start1){
                JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
            }
            
            else if(Usuarios.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: no hay vertices");
            }
            
            else if(edgeExist(end1, start1, personStart) || edgeExist(end1, start1, personEnd)){
                JOptionPane.showMessageDialog(null, "Error: relacion ya establecida con anterioridad");
            }  
            
            else{
                for(int x = 0; x < Usuarios.len(); x++){
                    int position = x;
                    Persona pAux = (Persona) Usuarios.get(x);

                    if(pAux.getName().equals(end1)){
                        Arco arco = new Arco(end1, start1);
                        Lista conocidos = pAux.getconocidos();
                        conocidos.append(arco);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(position, pAux);                             
                    }
                    if(pAux.getName().equals(start1)){
                        Arco arco = new Arco(end1, start1);
                        Lista conocidos = pAux.getconocidos();
                        conocidos.append(arco);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(position, pAux);                          
                    }
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: dato ingresado incorrecto");
        }
    }
    
// Funcion que devuelve persona utilizando los indices    
    public Persona encontrarPersonaConIndice(int Indice){ 
       return Usuarios.get(Indice);
    
    }
// Funcion si existe relacion entre dos usuarios    
    public boolean edgeExist2(String start, String end) {
        for (int x = 0; x < Usuarios.len(); x++) {
            Persona persona = encontrarPersonaConIndice(x);
            if (persona.getName().equals(start)) {
                Lista<Arco> conocidos = persona.getconocidos();
                for (int y = 0; y < conocidos.len(); y++) {
                    Arco arco = conocidos.get(y);
                    if (arco.getStart().equals(start) && arco.getEnd().equals(end)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

 // Esta funcion de la clase sirve para retornar un grafo transpuesto   
    public Grafo getTransposedGraph() {
    Grafo transposedGraph = new Grafo();
    Lista<Persona> usuarios = this.getusuarios();

    // Itera sobre el grafo original
    for (int i = 0; i < usuarios.len(); i++) {
        Persona user = usuarios.get(i);
        String name = user.getName();

        // Crea un nuevo usuario en el grafo transpuesto
        transposedGraph.addusuario(name);

        // Itera sobre cada usuario
        Lista<Arco> conocidos = user.getconocidos();
        for (int j = 0; j < conocidos.len(); j++) {
            Arco arco = conocidos.get(j);
            String start = arco.getStart();
            String end = arco.getEnd();

            // Añade los arcos en el grafo transpuesto de cada usuario
            transposedGraph.AgregarArco(end, start);
        }
    }

    return transposedGraph;
    }
    
 //Este metodo sirve para eliminar un arco"Arista" del grafo

    public void EliminarArco(String personA, String personB){
        try{
            
            Persona pA = EncontrarPersona(personA);
            Persona pB = EncontrarPersona(personB);
            
            if(!edgeExist(personA, personB, pA)){
                JOptionPane.showMessageDialog(null, "Error: no existe relacion entre ambas personas");
            }

            Lista conocidosA = pA.getconocidos();
            for (int x = 0; x < conocidosA.len(); x++) {
                Arco e = (Arco) conocidosA.get(x);
                if(e.getStart().equals(personA) && e.getEnd().equals(personB)){
                    conocidosA.pop(x);
                    pA.setconocidos(conocidosA);
                    int position = UbicacionUsuario(pA.getName());
                    Usuarios.replace(position, pA);
                }
                
                if(e.getEnd().equals(personA) && e.getStart().equals(personB)){
                    conocidosA.pop(x);
                    pA.setconocidos(conocidosA);
                    int position = UbicacionUsuario(pA.getName());
                    Usuarios.replace(position, pA);
                }
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: data ingresado no valido");
        }
    }
 //Este metodo sirve para eliminar un usuario por nombre del grafo

    public void EliminarPorNombre(String name ){ 
        Persona Persona = null;
        for(int x = 0; x < Usuarios.len(); x++){          
            if(Usuarios.get(x).getName().equals(name)){
                Persona = Usuarios.get(x);
                Usuarios.pop(x);
            }            
        }
        
        if(Persona == null){
            JOptionPane.showMessageDialog(null, "Error: persona no encontrada en el grafo");
        }
        else{
            for (int x = 0; x < Usuarios.len(); x++) {
                Persona pAux = Usuarios.get(x);
                Lista conocidos = pAux.getconocidos();
                for(int y = 0; y < conocidos.len(); y++){
                    Arco Arco = (Arco) conocidos.get(y);
                    if(Arco.getStart().equals(Persona.getName()) || Arco.getEnd().equals(Persona.getName())){
                        conocidos.pop(y);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(x, pAux);
                    }
                }
            }
        }       
    }
 //Este metodo sirve para la imprecionPR del grafo

    public void ImprecionPR(){
        for(int x = 0; x < Usuarios.len(); x++){
            Persona vertice = Usuarios.get(x);
            System.out.print("El usuario " + vertice.getName()+" esta conectado con ");
            if(vertice.getconocidos().len() == 0){
                System.out.println(" nadie");
            }
            else if(vertice.getconocidos().len() > 1){
                for(int y = 0; y < vertice.getconocidos().len(); y++){
                    Arco arista = (Arco) vertice.getconocidos().get(y);
                    String name = arista.getEnd();
                    if(y == vertice.getconocidos().len()-1){
                        System.out.println(" y " + name);    
                    }
                    else if(y == vertice.getconocidos().len()-2){
                        System.out.print(name);
                    }
                    else{
                        System.out.print(name + ", ");
                    }
                }    
            }
            else{
                for(int y = 0; y < vertice.getconocidos().len(); y++){
                    Arco arista = (Arco) vertice.getconocidos().get(y);
                    System.out.println(arista.getEnd());
                }
            }
        }
    }
     //Este metodo sirve para mostrar los elemntos del grafo

    public void show_elements_Grafo(Grafo Usuarios){
        if(Usuarios.getusuarios().isEmpty()){
            JOptionPane.showMessageDialog(null, "El Grafo está vacío");
        }else{
            Nodo<Persona> chain ;
            chain = Usuarios.getusuarios().getHead() ;
            String show_elements = "";
            for(int i=0; i< Usuarios.getusuarios().len(); i++){
                show_elements += "Nombre: " + chain.getData().getName()+ "\n Relaciones: " + chain.getData().getconocidos()+"\n";
                chain = chain.getNext();
                JOptionPane.showMessageDialog(null, show_elements);
            }
        }
    }
    
}

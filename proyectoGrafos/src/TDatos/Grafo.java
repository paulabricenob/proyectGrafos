/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;
//import Objetos.Funciones;
import Objetos.Arco;
import Objetos.NodoPersona;
import javax.swing.JOptionPane;

public class Grafo {
    private Lista<NodoPersona> Usuarios;
    private Lista<Arco> conocidos;

    public Grafo() {
        this.Usuarios = new Lista();
    }  

    public Lista getusuarios() {
        return Usuarios;
    }

    public void setususarios(Lista Usuarios) {
        this.Usuarios = Usuarios;
    }


    public int UbicacionUsuario(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            if(Usuarios.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }

    public NodoPersona EncontrarPersona(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            NodoPersona person = Usuarios.get(x);
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    
    public boolean edgeExist(String start, String end, NodoPersona person){
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
    
    
    public boolean addusuario(String name){
        this.conocidos = new Lista();
        NodoPersona person = new NodoPersona(name, conocidos);       
        boolean run = true;
        if(Usuarios.isEmpty()){
            Usuarios.append(person);
        }
        else{
            for(int x = 0; x < Usuarios.len(); x++){
                NodoPersona pAux = (NodoPersona) Usuarios.get(x);
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

    public void AgregarArco(String start, String end){
        try{
            
            NodoPersona personStart = Usuarios.get(UbicacionUsuario(start));
            NodoPersona personEnd = Usuarios.get(UbicacionUsuario(end));
            
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
                    NodoPersona pAux = (NodoPersona) Usuarios.get(x);

                    if(pAux.getName().equals(start)){
                        Arco arco = new Arco(start, end);
                        Lista conocidos = pAux.getconocidos();
                        conocidos.append(arco);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(position, pAux);                             
                    }
                    if(pAux.getName().equals(end)){
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
    
    public void AgregarArcoinvertido(String end1, String start1){
        try{
            
            NodoPersona personStart = Usuarios.get(UbicacionUsuario(end1));
            NodoPersona personEnd = Usuarios.get(UbicacionUsuario(start1));
            
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
                    NodoPersona pAux = (NodoPersona) Usuarios.get(x);

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
    

    public void EliminarArco(String personA, String personB, int option){
        try{
            
            NodoPersona pA = EncontrarPersona(personA);
            NodoPersona pB = EncontrarPersona(personB);
            
            if(!edgeExist(personA, personB, pA) && !edgeExist(personA, personB, pB) && option == 0){
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

            Lista conocidosB = pB.getconocidos();
            for (int x = 0; x < conocidosB.len(); x++) {
                Arco e = (Arco) conocidosB.get(x);
                if(e.getStart().equals(personA) && e.getEnd().equals(personB)){
                    conocidosB.pop(x);
                    pB.setconocidos(conocidosB);
                    int position = UbicacionUsuario(pB.getName());
                    Usuarios.replace(position, pB);
                }
               
                if(e.getEnd().equals(personA) && e.getStart().equals(personB)){
                    conocidosB.pop(x);
                    pB.setconocidos(conocidosB);
                    int position = UbicacionUsuario(pB.getName());
                    Usuarios.replace(position, pB);
                }
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: data ingresado no valido");
        }
    }
    
    public void EliminarPorNombre(String name ){ 
        NodoPersona Persona = null;
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
                NodoPersona pAux = Usuarios.get(x);
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

    public void ImprecionPR(){
        for(int x = 0; x < Usuarios.len(); x++){
            NodoPersona vertice = Usuarios.get(x);
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
}
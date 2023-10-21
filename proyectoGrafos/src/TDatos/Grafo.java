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

    public int UbicacionUsuario(int id){
        for(int x = 0; x < Usuarios.len(); x++){
            if(Usuarios.get(x).getid() == id){
                return x;
            }
        }
        return -1;
    }    

    public int EncontrarPosisionNombre(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            if(Usuarios.get(x).getName().equals(name)){
                return x;
            }
        }
        return -1;
    }
    
    public int EncontrarPosisionID(int Vnum){
        for(int x = 0; x < Usuarios.len(); x++){
            if(Usuarios.get(x).getid() == Vnum){
                return x;
            }
        }
        return -1;
    }
    
    public NodoPersona EncontrarPersonaID(int Vnum){
        for(int x = 0; x < Usuarios.len(); x++){
            NodoPersona person = Usuarios.get(x);
            if(person.getid() == Vnum){
                return person;
            }
        }
        return null;
    }

    public NodoPersona EncontrarPersonaNombre(String name){
        for(int x = 0; x < Usuarios.len(); x++){
            NodoPersona person = Usuarios.get(x);
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    
    public boolean addusuario(int id, String name){
        this.conocidos = new Lista();
        NodoPersona person = new NodoPersona(name, conocidos, id);       
        boolean run = true;
        if(Usuarios.isEmpty()){
            Usuarios.append(person);
        }
        else{
            for(int x = 0; x < Usuarios.len(); x++){
                NodoPersona pAux = (NodoPersona) Usuarios.get(x);
                if(pAux.getid() == id){
                    run = false;
                }
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

    public void AgregarArco(int start, int end){
        try{
            
            NodoPersona personStart = Usuarios.get(UbicacionUsuario(start));
            NodoPersona personEnd = Usuarios.get(UbicacionUsuario(end));
            
            if(start == end){
                JOptionPane.showMessageDialog(null, "Error: no se admite relacion con un mismo vertice");
            }
            
            else if(Usuarios.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: no hay vertices");
            }
            
            else{
                for(int x = 0; x < Usuarios.len(); x++){
                    int position = x;
                    NodoPersona pAux = (NodoPersona) Usuarios.get(x);

                    if(pAux.getid() == start){
                        Arco arco = new Arco(start, end);
                        Lista conocidos = pAux.getconocidos();
                        conocidos.append(arco);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(position, pAux);                             
                    }
                    if(pAux.getid() == end){
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


    public void EliminarArco(int personA, int personB, int option){
        try{
            NodoPersona pA = EncontrarPersonaID(personA);
            NodoPersona pB = EncontrarPersonaID(personB);
            

            Lista conocidosA = pA.getconocidos();
            for (int x = 0; x < conocidosA.len(); x++) {
                Arco e = (Arco) conocidosA.get(x);
                if(e.getStart() == personA && e.getEnd() == personB){
                    conocidosA.pop(x);
                    pA.setconocidos(conocidosA);
                    int position = EncontrarPosisionID(pA.getid());
                    Usuarios.replace(position, pA);
                }
                
                if(e.getEnd() == personA && e.getStart() == personB){
                    conocidosA.pop(x);
                    pA.setconocidos(conocidosA);
                    int position = EncontrarPosisionID(pA.getid());
                    Usuarios.replace(position, pA);
                }
                
            }

            Lista conocidosB = pB.getconocidos();
            for (int x = 0; x < conocidosB.len(); x++) {
                Arco e = (Arco) conocidosB.get(x);
                if(e.getStart() == personA && e.getEnd() == personB){
                    conocidosB.pop(x);
                    pB.setconocidos(conocidosB);
                    int position = EncontrarPosisionID(pB.getid());
                    Usuarios.replace(position, pB);
                }
               
                if(e.getEnd() == personA && e.getStart() == personB){
                    conocidosB.pop(x);
                    pB.setconocidos(conocidosB);
                    int position = EncontrarPosisionID(pB.getid());
                    Usuarios.replace(position, pB);
                }
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: data ingresado no valido");
        }
    }
    
public void EliminarPorNombre(String name){ 
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
                    if(Arco.getStart() == Persona.getid() || Arco.getEnd() == Persona.getid()){
                        conocidos.pop(y);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(x, pAux);
                    }
                }
            }
        }       
    }
    

    public void EliminarPorID(int num){ 
        NodoPersona Persona = null;
        for(int x = 0; x < Usuarios.len(); x++){
            NodoPersona p = Usuarios.get(x);
            if(p.getid() == num){
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
                    if(Arco.getStart() == Persona.getid() || Arco.getEnd() == Persona.getid()){
                        conocidos.pop(y);
                        pAux.setconocidos(conocidos);
                        Usuarios.replace(x, pAux);
                    }
                }
            }       
        }       
    }
    
    
    
   

    
//   public void showGraph(){
//		for(int i = 0; i < Graph.length; i++){
//			Nodo actual = Graph[i];
//			
//			while(actual != null){
//				System.out.printf("%d -> ", i);
//				System.out.printf("%d(%d)\n", actual.getData());
//				
//				actual = actual.getNext();
//			}
//			System.out.println(Graph);
//		}
//	}
}

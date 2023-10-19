/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectografos;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ListaPersonas {
    private NodoPersona pFirst;
    private NodoPersona pLast;
    private int iN;

    public ListaPersonas() {
        this.pFirst = null;
        this.pLast = null;
        this.iN = 0;
    }
    
    public void empty_list(){
        setpFirst(null);
        setpLast(null);
        setiN(0);
    }
    
    
    public boolean isEmpty(){
        return getpFirst()== null;
    }
    
   
    public void insert_at_beginning(String name, String relations){
        NodoPersona new_users = new NodoPersona(name, relations);
        if (isEmpty()){
            setpFirst(new_users);
            setpLast(new_users);
            
        }else{
            new_users.setPnext(getpFirst());
            setpFirst(new_users);
        }
        setiN(getiN()+1);
    }
    
    public void insert_at_last(String name, String relations){
        NodoPersona new_user = new NodoPersona(name, relations);
        if(isEmpty()){
            insert_at_beginning(name, relations);
        }else{
            getpLast().setPnext(new_user);
            setpLast(new_user);
            setiN(getiN()+1);
            
        }
    }
    
    public void show_elements(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }else{
            NodoPersona chain ;
            chain = getpFirst();
            String show_element = "";
            for (int i=0; i<getiN(); i++){
                show_element += "Nombre:" + chain.getName()+ "\n Relaciones: " + chain.getRelations()+ "\n";
                chain = chain.getPnext();
                JOptionPane.showMessageDialog(null, show_element);
                
            }
        }
    }
    
    
    
    
    public NodoPersona getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoPersona pFirst) {
        this.pFirst = pFirst;
    }

    public NodoPersona getpLast() {
        return pLast;
    }

    public void setpLast(NodoPersona pLast) {
        this.pLast = pLast;
    }

    public int getiN() {
        return iN;
    }

    public void setiN(int iN) {
        this.iN = iN;
    }
    
}    
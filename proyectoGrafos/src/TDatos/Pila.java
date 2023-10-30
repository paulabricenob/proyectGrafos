/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;
import javax.swing.JOptionPane;

/**
 * Esta clase define el objeto pila, con la cual tiene diferentes atributos y funciones que lo definen 
 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso
 * @version: 24/10/2023/A
 */
public class Pila<T> {

    private Nodo top;
    private Nodo bottom;
    private int size;
    //Campos de la clase
    //constructor
    public Pila() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }
//getter del nodo de arriba  
    public Nodo getTop() {
        return top;
    }
//setter de nodo de arriba
    public void setTop(Nodo top) {
        this.top = top;
    }
//getter de nodo de abajo
    public Nodo getBottom() {
        return bottom;
    }
//setter de nodo de abajo
    public void setBottom(Nodo bottom) {
        this.bottom = bottom;
    }
//getter del tamaño de la pila
    public int getSize() {
        return size;
    }
//setter del tamaño de la pila
    public void setSize(int size) {
        this.size = size;
    }
//funcion de la clase Pila     
    public boolean isEmpty(){
        return top == null;
    }
//funcion de la clase Pilapara buscar informacion mas alta de la pila    
  
    public T peek(){
        if(isEmpty() == true){
            return null;
        }
        else{
            return (T) top.getData();
        }
    }
    
//meotodo de la clase Pila para introduciir informacion 
    public void push(T data){
        Nodo newNode = new Nodo(data);
        if(isEmpty() == true){
            top = newNode;
            bottom = newNode;
            size++;
        }
        else{
            top.setNext(newNode);
            top = newNode;
            size++;
        }
    }
    
//funcion de la clase Pila para eliminar y devolver como variable   

    public Nodo pop(){
        Nodo pAux = null;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Error: pila vacia");
        }
        else{
            Nodo pointer = bottom;
            while(pointer.getNext().getNext() != null){
                pointer = pointer.getNext();
            }
            pAux = top;
            pointer.setNext(null);
            top = pointer;
            size--;
        }
        return pAux;
    }
    
    
    
}


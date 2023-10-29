/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;

/**
 * Esta clase define el objeto nodo, con la cual tiene diferentes atributos y funciones que lo definen
 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso
 * @version: 24/10/2023/A
 */
public class Nodo<T> {
    
    private Nodo next;
    private T data;
    //Campos de la clase
    //constructor
    public Nodo(T data){
        this.next = null;
        this.data = data;
    }
//getter del siguiente nodo
    public Nodo getNext() {
        return next;
    }

//setter del siguiente nodo
    public void setNext(Nodo next) {
        this.next = next;
    }

//getter de la informacion
    public T getData() {
        return data;
    }

//setter de la informacion
    public void setData(T data) {
        this.data = data;
    }
}

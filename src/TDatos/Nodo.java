/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDatos;

/**
 *
 * @author Enzo
 */
public class Nodo<T> {
    
    private Nodo next;
    private T data;
    

    public Nodo(T data){
        this.next = null;
        this.data = data;
    }
    
    public Nodo getNext() {
        return next;
    }


    public void setNext(Nodo next) {
        this.next = next;
    }


    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }
}

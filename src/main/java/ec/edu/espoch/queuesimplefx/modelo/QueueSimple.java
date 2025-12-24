/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuesimplefx.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QueueSimple {
    private Node frente;
    private Node fin;
    private int tamaño;

    public QueueSimple() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    // insertar al final
    public void enqueue(int dato) {
        Node nuevo = new Node(dato);

        if (isEmpty()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    // Eliminar al frente
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }

        int dato = frente.dato;
        frente = frente.siguiente;
        tamaño--;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    // Ver el primer elemento
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return frente.dato;
    }

    // Verificar si esta vacia
    public boolean isEmpty() {
        return frente == null;
    }

    // Tamaño
    public int size() {
        return tamaño;
    }

    // Vaciar la cola
    public void clear() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    // Mostrar la cola
    public List<Integer> toList() {
    List<Integer> list = new ArrayList<>();
    Node actual = frente;

    while (actual != null) {
        list.add(actual.dato);
        actual = actual.siguiente;
    }
    return list;
}

}

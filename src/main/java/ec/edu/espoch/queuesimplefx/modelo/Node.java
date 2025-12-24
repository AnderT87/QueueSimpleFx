/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuesimplefx.modelo;

/**
 *
 * @author Admin
 */
public class Node {
    int dato;
    Node siguiente;

    public Node(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

package diodo.controller;

import diodo.model.Nodo;

import java.util.LinkedList;

public class NodoController {
    private Nodo<String> nodo = new Nodo<>(new LinkedList<String>(), new LinkedList<String>());

    public void push(String s) {
        if(nodo.disponibleDerecha()){
            nodo.agregarDerecha(s);
        } else {
            nodo.agregarIzquierda(s);
        }
    }
}

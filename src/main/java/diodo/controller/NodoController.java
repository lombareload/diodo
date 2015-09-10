package diodo.controller;

import diodo.App;
import diodo.model.Nodo;

import javax.swing.*;

public class NodoController {

    private final App app;

    public NodoController(App app) {
        this.app = app;
    }

    private Nodo<JLabel> nodo = new Nodo<>();

    public void push(String s) {
        if (nodo.disponibleDerecha()) {
            pushRight(s);
        } else if (nodo.disponibleIzquierda()) {
            pushLeft(s);
        } else {
            pushLeft(s);
        }
    }

    private void actualizarAppConEstadoDeNodo() {
        if (nodo.disponibleDerecha()) {
            activarBotonAddDerecho();
            activarBotonBorrarIzquierdo();
        } else if (nodo.disponibleIzquierda()) {
            activarBotonAddIzquierdo();
            activarBotonBorrarDerecho();
        } else {
            activarAmbosBotonesAdd();
            activarAmbosBotonesBorrar();
        }
        System.out.println(nodo.toString());
    }


    // funciones para botones agregar
    private void activarAmbosBotonesAdd() {
        app.setRightAddState(true);
        app.setLeftAddState(true);
    }

    private void activarBotonAddDerecho() {
        app.setRightAddState(true);
        app.setLeftAddState(false);
    }

    private void activarBotonAddIzquierdo() {
        app.setLeftAddState(true);
        app.setRightAddState(false);
    }

    // funciones para botones remover
    private void activarBotonBorrarIzquierdo() {
        app.setLeftRemoveState(true);
        app.setRightRemoveState(false);
    }

    private void activarBotonBorrarDerecho() {
        app.setRightRemoveState(true);
        app.setLeftRemoveState(false);
    }

    private void activarAmbosBotonesBorrar() {
        app.setLeftRemoveState(true);
        app.setRightRemoveState(true);
    }


    public void pushRight(String text) {
        JLabel label = new JLabel(text);
        nodo.agregarDerecha(label);
        app.agregarItemALaDerecha(label);
        actualizarAppConEstadoDeNodo();
        app.pack();
    }

    public void pushLeft(String text) {
        JLabel label = new JLabel(text);
        nodo.agregarIzquierda(label);
        app.agregarItemALaIzquierda(label);
        actualizarAppConEstadoDeNodo();
        app.pack();
    }

    public void removeRight() {
        JLabel label = nodo.removerDerecha();
        app.removerEnDerecha(label);
        actualizarAppConEstadoDeNodo();
        app.pack();
    }

    public void removeLeft() {
        JLabel label = nodo.removerIzquierda();
        app.removerEnIzquierda(label);
        actualizarAppConEstadoDeNodo();
        app.pack();
    }
}

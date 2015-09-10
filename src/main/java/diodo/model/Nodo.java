package diodo.model;

import java.util.Deque;
import java.util.LinkedList;

public class Nodo<T> {
    private final Deque<T> left;
    private final Deque<T> right;

    public Nodo() {
        this.left = new LinkedList<>();
        this.right = new LinkedList<>();
    }

    public void agregarDerecha(T item) {
        right.add(item);
    }

    public void agregarIzquierda(T item){
        left.add(item);
    }

    public boolean disponibleDerecha() {
        int leftSize = left.size();
        int rightSize = right.size();
        return rightSize < leftSize;
    }

    public boolean disponibleIzquierda() {
        int leftSize = left.size();
        int rightSize = right.size();
        return rightSize > leftSize;
    }

    public T removerIzquierda() {
        T t = left.pollLast();
        System.out.println(left);
        return t;
    }

    public T removerDerecha(){
        T t = right.pollLast();
        System.out.println(right);
        return t;
    }

    public boolean estaBalanceado() {
        int leftSize = left.size();
        int rightSize = right.size();
        return leftSize == rightSize;
    }
}

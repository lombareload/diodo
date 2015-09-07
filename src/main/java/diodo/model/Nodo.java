package diodo.model;

import java.util.Queue;

public class Nodo<T> {
    private final Queue<T> left;
    private final Queue<T> right;

    public Nodo(Queue<T> left, Queue<T> right) {
        this.left = left;
        this.right = right;
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
        return !disponibleDerecha();
    }

    private boolean estaBalanceado() {
        int leftSize = left.size();
        int rightSize = right.size();
        return leftSize == rightSize;
    }
}

package diodo.model;

public class Nodo<T> {
    private final Stack<T> left;
    private final Stack<T> right;

    public Nodo() {
        this.left = new Stack<>();
        this.right = new Stack<>();
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
        T t = left.pop();
        System.out.println(left);
        return t;
    }

    public T removerDerecha(){
        T t = right.pop();
        System.out.println(right);
        return t;
    }

    public boolean estaBalanceado() {
        int leftSize = left.size();
        int rightSize = right.size();
        return leftSize == rightSize;
    }

    @Override
    public String toString() {
        return left + ", " + right;
    }
}

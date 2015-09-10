package diodo.model;

public class StackNodo<T> {
    final private T value;
    private StackNodo<T> next;

    public StackNodo(T value, StackNodo<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue(){
        return value;
    }

    public StackNodo<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

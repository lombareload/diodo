package diodo.model;

public class Stack<T> {
    StackNodo<T> tail;

    public void add(T item){
        tail = new StackNodo<>(item, tail);
    }

    public T pop(){
        if(tail.getNext()==null){
            return null;
        }
        T current = tail.getValue();
        tail = tail.getNext();
        return current;
    }

    public int size(){
        int currentSize = 0;
        StackNodo<T> current = tail;
        while(current != null) {
            currentSize += 1;
            current = current.getNext();
        }
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackNodo<T> current = tail;
        while(current != null) {
            sb.append(current.toString()).append("-");
            current = current.getNext();
        }
        return sb.toString();
    }
}

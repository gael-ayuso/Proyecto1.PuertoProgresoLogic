package estructurasDeDatos.deques;

public interface Deque {
    int size();
    boolean isEmpty();
    void insertFirst(Object o);
    void insertLast(Object o);
    Object removeFirst();
    Object removeLast();
    Object first();
    Object last();
}

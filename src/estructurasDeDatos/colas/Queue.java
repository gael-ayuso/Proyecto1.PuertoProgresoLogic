package estructurasDeDatos.colas;

public interface Queue {
    void enqueue(Object o);
    Object dequeue();
    int size();
    Object front();
    boolean isEmpty();
}

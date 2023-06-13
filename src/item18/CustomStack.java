package item18;

import java.util.EmptyStackException;
import java.util.Vector;

public class CustomStack<E> {
    private final Vector<E> vector = new Vector<>();

    public CustomStack() {
    }

    public E push(E item) {
        vector.addElement(item);

        return item;
    }

    public synchronized E pop() {
        E obj;
        int len = vector.size();
        obj = peek();
        vector.removeElementAt(len - 1);
        return obj;
    }

    private E peek() {
        int len = vector.size();

        if (len == 0)
            throw new EmptyStackException();
        return vector.elementAt(len - 1);
    }

    public boolean empty() {
        return vector.size() == 0;
    }

    public synchronized int search(Object o) {
        int i = vector.lastIndexOf(o);

        if (i >= 0) {
            return vector.size() - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    private static final long serialVersionUID = 1224463164541339165L;

}

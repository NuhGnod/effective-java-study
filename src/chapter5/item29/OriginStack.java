package chapter5.item29;

import java.util.EmptyStackException;

public class OriginStack {
    public static void main(String[] args) {
        ObjectStack st = new ObjectStack();
        st.push("123");
        st.push(123);
        Object pop = st.pop();
        System.out.println("pop = " + pop);
        Object pop1 = st.pop();
        System.out.println("pop1 = " + pop1);
    }
}
class ObjectStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public ObjectStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
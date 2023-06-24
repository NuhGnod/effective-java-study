package item29;

import java.util.EmptyStackException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : args) {
            stack.push(arg);

        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}

class Stack<E> {
//        private E[] elements;
    private Object[] elements; // case 2
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

//    @SuppressWarnings("unchecked") //case 1
    public Stack() {
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; // case 1
        elements = new Object[DEFAULT_INITIAL_CAPACITY]; // case 2
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] =e;
    }

    private void ensureCapacity() {
        if(size >= elements.length){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
//        E result = elements[--size];
        @SuppressWarnings("unchecked") E result = (E) elements[--size]; // case 2
        elements[size] = null;

        return result;
    }

    public boolean isEmpty() {

        return size == 0;
    }
}
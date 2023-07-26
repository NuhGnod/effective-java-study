package chapter5.item29;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String[] array = getArray(10); // On Runtime, ClassCastException; Object -> String
//        String s = (String) new Object();
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        List list = integers;
//        Stack<String> objects = new Stack<String>(list); // 힙 오염(?) 근데 얘는, Stack의 힙 오염때문에 발생한 문제가 아닌, 로 타입 사용해서 발생한 힙 오염이라고 볼 수 있음.
//        String pop = objects.pop();
//        System.out.println("pop = " + pop);


//        Stack st = new Stack<>(); // Raw Type
//        st.push("asd");
//        Object pop1 = st.pop();
//        st.push(1);
//        System.out.println("pop1 = " + pop1);
//        Object pop2 = st.pop();
//        System.out.println("pop2 = " + pop2);
        //cast 성능 테스트.
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_000_000_000L; i++) {
            UP u = new DOWN();
            DOWN down = (DOWN) u;
        }
        long end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        start = System.currentTimeMillis();
        for (long i = 0; i < 10_000_000_000L; i++) {
            UP u = new DOWN();
            DOWN down = (DOWN) u;
        }
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));


        start = System.currentTimeMillis();
        for (long i = 0; i < 10_000_000_000L; i++) {
            DOWN d = new DOWN();
            UP up = d;
        }
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        start = System.currentTimeMillis();
        for (long i = 0; i < 10_000_000_000L; i++) {
            DOWN d = new DOWN();
            UP up = (UP) d;
        }
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));


//        Stack<String> stringSt = new Stack<>();
//        Stack<Integer> intSt = (Stack<Integer>) (Object) stringSt; // 이게 발생할 수 있는 Stack에서의 힙 오염!
//        intSt.push(1);
//        intSt.push(2);
//        String pop = stringSt.pop();
//        System.out.println("pop = " + pop);

//        Object[] store = (Object[]) new Long[10];
//        store[0] = new Long(1L);
//        store[1] = new String("11L"); // ArrayStoreException
//        Long o1 = (Long) store[0];
//        Long o2 = (Long) store[1];  // ClassCastException
//        System.out.println("o1 = " + o1);
//        System.out.println("o2 = " + o2);
////        Object o2 = store[1];
//        Stack<String> stack = new Stack<>();
//        for (String arg : new String[]{"hello", "java", "world"}) {
//            stack.push(arg);
//
//        }
//        Object o = new String("!@#");
//        stack.push(String.valueOf(o));
//        stack.push((String) o);

//        while (!stack.isEmpty()) {
//            System.out.println(String.valueOf(stack.pop())
//                    .toUpperCase());
//        }
//        while (!stack.isEmpty()) {
////            stack.pop();
//            String element =  stack.pop();
//            System.out.println("element = " + element);
//            System.out.println(element == o);
//
//        }
    }

    public static <T> T[] getArray(int size) {
        T[] arr = (T[]) new Object[size]; // DownCasting ; 아직 모르는 T로 캐스팅하는거라 가능
        // 그래서 컴파일러가 Unchecked Cast 경고 보여줌.
        return arr;
    }
}

//class Stack<E> {
//            public E[] elements; // case 1
////    private Object[] elements; // case 2
//    private int size = 0;
//    private static final int DEFAULT_INITIAL_CAPACITY = 16;
//
//    //    @SuppressWarnings("unchecked") //case 1
//    public Stack() {
////        elements = new E[DEFAULT_INITIAL_CAPACITY];
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; // case 1
////        elements = new Object[DEFAULT_INITIAL_CAPACITY]; // case 2
////        System.out.println("elements = " + elements.getClass());
//
//    }
////    public Stack(Collection<? extends E> c) {
////        Object[] a = c.toArray();
////        size = a.length;
////        if (c.getClass() == ArrayList.class) {
////            elements = (E[]) a;
////        } else {
////            elements = (E[]) Arrays.copyOf(a, size, Object[].class);
////        }
////    }
//
//    public void push(E e) {
//
//        if (e instanceof String) {
////            System.out.println("String");
//        }
//        ensureCapacity();
//        elements[size++] =  e;
////        System.out.println("elements = " + elements[size-1].getClass());
////        elements[size++] =  new Object(); // 이러한 행위는 잘못 설계되 API이다. 막을수 없다. 힙 오염 발생.
////        elements[size++] = (E) new Integer(1);
//
//    }
//
//    private void ensureCapacity() {
//        if (size >= elements.length) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//    }
//
//    public E pop() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        E result = elements[--size]; // case1
////        @SuppressWarnings("unchecked") E result = (E) elements[--size]; // case 2
//        elements[size] = null;
//
//        return result;
//    }
//
//    public boolean isEmpty() {
//
//        return size == 0;
//    }
//
//}
class Stack<E> {
    private Object[] elements; // case 2
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY]; // case 2
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked") E result = (E) elements[--size]; // case 2
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class UP {

}

class DOWN extends UP {
}
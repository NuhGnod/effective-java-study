package chapter5.item28;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Object[] objects = new Long[11];
//        objects[0] = "ASD"; //ArrayStoreException
//
//        List<Object> ol = new ArrayList<Long>(); // compile 타임에 불가능을 알게됨.
//        ol.add("ASD");
//
//        ArrayList<String>[] arrayLists = new ArrayList<String>[1];
//        ArrayList<?>[] arr = new ArrayList<?>[1];
//
//        ArrayList<String>[] list = new ArrayList[1];
//        list[0] = new ArrayList<String>();
//        list[0].add("ASd");
//        System.out.println("list = " + list);
//        System.out.println("list[0] = " + list[0]);
//        list[0].get(0);
        System.out.println("====================================");
        Collection<String> target = new ArrayList<>();
        target.add("A");
        target.add("AB");
        target.add("ABC");
        GenericArray<List> genericStringCollection = new GenericArray<List>();
        genericStringCollection.toArray(target, target.size(), target.getClass());
//        Arrays.copyOf(target);

//        GenericArray<String> genericStrings = new GenericArray<String>(new String[]{"a", "b", "c"});
//        ArrayList<String> target = new ArrayList<>();
//        target.add("A");
//        target.add("AB");
//        target.add("ABC");
//        String[] strings = genericStrings.toArray(target);
//        Object a = new Object();
//        String a1 = (String) a;
//        System.out.println("a1 = " + a1);
//        System.out.println("strings = " + strings);
    }

}

class GenericArray<T extends Collection> {
//    private final Collection<T> genericCollections;

    public <U> GenericArray() {

    }

    public <U,T> U[] toArray(Collection<U> collection, int newLength, Class<? extends Collection> newType) {
//        Arrays.copyOf()

        Iterator<U> iterator = collection.stream().iterator();
//        U[] arrr = new U[3];
        Object[] arrr = (U[]) new Object[newLength];
        while (iterator.hasNext()) {
            U next = iterator.next();
            System.out.println(next);
            arrr[0] = next;
        }
        System.out.println("arrr = " + arrr);
        System.out.println("arrr.getClass() = " + arrr.getClass());
//        T[] copy = ((Object) newType == (Object) Object[].class)
//                ? (T[]) new Object[newLength]
//                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
//        System.arraycopy(collection, 0, copy, 0,
//                Math.min(collection.size(), newLength));
////        Array.newInstance(collection.getClass(), )
//        U[] us = (U[]) collection.toArray();
        return null;
    }

}
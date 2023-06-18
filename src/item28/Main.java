package item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        GenericArray<List> genericStringCollection = new GenericArray<List>(target);
        List[] lists = genericStringCollection.toArray(target);
        System.out.println("lists = " + lists);
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
    private final Collection<T> genericCollections;

    public GenericArray(Collection<?> collection) {
        this.genericCollections = (Collection<T>) collection;

    }

    public T[] toArray(Collection<?> collection) {
        Class<? extends Collection> aClass = collection.getClass();
        System.out.println(aClass);
        return (T[]) collection.toArray();
    }

}
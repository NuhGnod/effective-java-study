package chapter3.item12;

import java.util.*;

public class item12 {
    public static void main(String[] args) {
//        item12enum.N;
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        System.out.println("map = " + hashMap.toString());

        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(11, 11);
        System.out.println("linkedHashMap = " + linkedHashMap.toString());

        EnumMap enumMap = new EnumMap(itemType.class);
        enumMap.put(itemType.one, itemType.one);
        enumMap.put(itemType.two, itemType.three);
        System.out.println("enumMap = " + enumMap.toString());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(10, 20);
        System.out.println("treeMap = " + treeMap.toString());


        WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(1, 1);
        weakHashMap.put(2, 22);
        System.out.println("weakHashMap = " + weakHashMap.toString());

        System.out.println();
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(new String("aa"));
        hashSet.add(new String("bb"));
        hashSet.add(new Object());
        System.out.println("set = " + hashSet.toString());

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println("linkedHashSet = " + linkedHashSet.toString());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(11);
        treeSet.add(22);
        System.out.println("treeSet = " + treeSet);

    }
}

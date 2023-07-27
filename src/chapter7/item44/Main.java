package chapter7.item44;

public class Main {
    public static void main(String[] args) {

        MyLinkedHashMap<Integer, Integer> myMap = new MyLinkedHashMap<>();
        myMap.put(1, 1);
        myMap.put(2, 2);
        myMap.put(3, 3);
        myMap.put(4, 4);
        myMap.put(5, 5);
        myMap.put(6, 6);
        System.out.println("myMap = " + myMap);
        myMap.afterNodeInsertion(true,
                (kvMap, eld) -> {
                    kvMap.remove(eld.getKey());
                    return true;
                });

    }
}

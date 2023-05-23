package item12;

import java.util.HashMap;
import java.util.HashSet;

public class item12 {
    public static void main(String[] args) {
//        item12enum.N;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.toString();
        System.out.println("map = " + map.toString());
        HashSet<Object> set = new HashSet<>();
        set.add(new String("aa"));
        set.add(new String("bb"));
        set.add(new Object());
        System.out.println("set = " + set.toString()
        );

    }
}

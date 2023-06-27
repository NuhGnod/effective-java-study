package item32;

import java.util.List;

public class HealPollution {
    public static void main(String[] args) {
        List<String> stringList = List.of("A");
        List<String> stringList2 = List.of("AB");
        List<String> stringList3 = List.of("ABC");
        List<String>[] arr = new List[3];
        arr[0] = stringList;
        arr[1] = stringList2;
        arr[2] = stringList3;
        method(stringList, stringList2, stringList3);
//        method(arr);
        Object c = new Object();
        c = "ASD";
        c = 123;
        System.out.println("c = " + c);

    }

    public static void method(List<String>... strs) {
        System.out.println(strs.getClass().getTypeName());
        System.out.println("strs = " + strs);
        List<Integer> intList = List.of(43);
        Object[] objects = strs;

//        System.out.println(objects.getClass().getTypeName());
//        System.out.println("objects = " + objects);
//        for (Object o : objects) {
//            System.out.println("o = " + o);
//        }
        objects[0] = intList;
//        String s = String.valueOf(strs[0].get(0));
//        System.out.println("s = " + s);

    }
}

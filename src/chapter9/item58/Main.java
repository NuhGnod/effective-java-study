package chapter9.item58;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");
//
//        for (String s : list) {
//            if (s.equals("c")) {
//                list.remove(3);
//            }
//            System.out.println("s = " + s);
//        }
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");

        for (String s : list) {
            if (s.equals("2")) {
                list.remove(s);
            }
            System.out.println(s);
        }
    }
}

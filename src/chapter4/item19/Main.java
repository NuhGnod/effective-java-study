package chapter4.item19;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractList<Object> objects1 = new ArrayList<>();
        LinkedList<Integer> objects = new LinkedList<>();
        objects1.add(1);
        objects1.add(2);
        objects1.add(3);
        objects1.add(4);
        objects1.add(5);
        objects1.add(6);
//        objects1.clear();
        List<Object> sub = objects1.subList(1, 4);
        sub.clear();
        System.out.println("objects1 = " + objects1.toString());


    }
}

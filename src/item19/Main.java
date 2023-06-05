package item19;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        AbstractList<Object> objects = new ArrayList<>();
        LinkedList<Integer> objects1 = new LinkedList<>();
        objects1.add(1);
        objects1.add(2);
        objects1.add(3);
        objects1.add(4);
        objects1.add(5);
        objects1.add(6);
        objects1.clear();
    }
}

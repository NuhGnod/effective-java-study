package item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Set<Lark> ex = new HashSet();
        ex.getClass();
//        Arrays.copyOf(new Number[]{}, 10, Number.class);
//
//        String s = (String) new Object();
        Class<? extends Set> aClass = ex.getClass();
//        Type
//        Lark lark = (aClass) new Object();
//        lark.print();
//        System.out.println(lark.getClass());

    }
}

class Lark {
    public void print() {
        System.out.println("ASD");

    }

}
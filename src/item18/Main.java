package item18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "택", "톡"));
        System.out.println("s.getAddCount() = " + s.getAddCount());

        InstrumentedSet<String> set = new InstrumentedSet(new HashSet(16));

        InstrumentedSet<String> set2 = new InstrumentedSet(new TreeSet());

        TreeSet treeSet = new TreeSet();
        treeSet.descendingIterator();

        set.addAll(List.of("가", "나", "다"));
        set.isEmpty();



        System.out.println("set.getAddCount() = " + ((InstrumentedSet<String>) set).getAddCount());

        //
//        Properties def =new Properties();
//        def.put("Hello", new Integer(1000));
//        Properties p = new Properties(def);
        Properties p = new Properties();

        p.put("Hello", new Integer(123));
        String getProperty = p.getProperty("Hello");
        System.out.println("--=-");
//        getProperty = "ASD";
        //        Object get = p.get("Hello");
        System.out.println("getProperty().hello = " + getProperty);
//        System.out.println("get().hello = " + get);
//        System.out.println("=============================");
//        Compile cp = new Compile();
//        cp.compile();
        // ====================================
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.set(1, 10);
        System.out.println(st);
        CustomStack<Integer> cst = new CustomStack<>();
        cst.push(1);
        cst.push(2);
        cst.push(3);
        cst.push(4);
        cst.push(5);
        System.out.println(cst);
    }
}

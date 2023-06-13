package item24;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
//        HashMap
//        LinkedList
//        WeakHashMap
        StaticTest st = new StaticTest();
        StaticTest.innerClass innerClass = new StaticTest().new innerClass();
        st.new innerClass();

    }

}

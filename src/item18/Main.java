package item18;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "택", "톡"));
        System.out.println("s.getAddCount() = " + s.getAddCount());

        InstrumentedSet<String> set = new InstrumentedSet(new HashSet(16));
        set.addAll(List.of("가", "나", "다"));

        System.out.println("set.getAddCount() = " + ((InstrumentedSet<String>) set).getAddCount());

        //
        Properties def =new Properties();
        def.put("Hello", "defualt World");
        Properties p = new Properties(def);
        p.put("Hello", "World");
        p.clear();
        String getProperty = p.getProperty("Hello");
        Object get = p.get("Hello");

        System.out.println("hello = " + getProperty);
        System.out.println("hello1 = " + get);

    }
}

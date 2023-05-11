package item7;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class item7 {
    public static void main(String[] args) throws InterruptedException {

//        https://mongsil1025.github.io/book/effective-java/item7/
//        https://stackoverflow.com/questions/18406703/when-will-a-string-be-garbage-collected-in-java
        Object key = new Object();
        Object value = new Object();

        Map<Object, Object> cache = new HashMap<>();
        cache.put(key, value);
        key = null;
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("cache.isEmpty() = " + cache.isEmpty());
        System.out.println("========================================");


        Object key2 = new Object();
        Object value2 = new Object();
        Map<Object, Object> cache2 = new WeakHashMap<>();
        cache2.put(key2, value2);
        key2 = null;
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("cache2.isEmpty() = " + cache2.isEmpty());
        System.out.println("========================================");




        Map<String, String> map = new WeakHashMap<>();

        // 아래처럼 선언할 경우, GC가 작동해서 ITEM 이 사라진다.
//        String s1 = new String("ITEM");
//        String s2 = new String("SITE_ITEM");

        // 아래 처럼 선언할 경우, GC가 작동하지 않는다.
        String s1 = "ITEM";
        String s2 = "SITE_ITEM";
        map.put(s1, "123");
        map.put(s2, "987");

        String ss = "ss";
        String ssO = new String("ss");
        System.out.println("ss == ssO = " + (ss == ssO));
        System.out.println("ss.equals(ssO) = " + ss.equals(ssO));

        String newss = "ss";
        String forIntern = "newInternString";
        String intern = forIntern.intern();
        System.out.println("intern = " + intern);
        String newssO = new String("ss");
        System.out.println("ss == newss = " + (ss == newss));
        System.out.println("ss.equals(newss) = " + ss.equals(newss));
        System.out.println("ssO == newssO = " + (ssO == newssO));
        System.out.println("ssO.equals(newssO) = " + ssO.equals(newssO));

        s1 = null;
        s2 = null;
        System.gc();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println("========================================");
    }

}
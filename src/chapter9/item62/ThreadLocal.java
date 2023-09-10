package chapter9.item62;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThreadLocal {
    private static Map<Key, Object> map = new HashMap<>();

    private ThreadLocal() {

    }

    public static class Key {
        Key() {

        }

        public static void set(Key key, Object val) {
            map.put(key, val);

        }

        public static Object get(Key key) {
            return map.get(key);

        }
    }

    public static Key getKey() {
        return new Key();
    }

}

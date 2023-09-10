package chapter9.item62;

import java.util.HashMap;
import java.util.Map;

public class Key {
    private static Map<Key, Object> map = new HashMap<>();
    public Key() {

    }
    public static void set(Key key, Object val) {
        map.put(key, val);

    }

    public static Object get(Key key) {
        return map.get(key);

    }
}

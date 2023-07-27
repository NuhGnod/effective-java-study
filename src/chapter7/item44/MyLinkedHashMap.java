package chapter7.item44;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    @FunctionalInterface
    public interface EldestEntryRemovalFunction<K, V> {
        boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
    }


    @Override
    public V put(K key, V value) {
        // putVal() 의 afterNodeInsertion()를 재정의 할 수 잇었다면,
        afterNodeInsertion(true, (kvMap, eld) -> { // EldestEntryRemovalFunction의 remove를 재정의(?)
            kvMap.remove(eld.getKey());
            return true;
        });
        return super.put(key, value);
    }
    // v1
    public void afterNodeInsertion(boolean evict, EldestEntryRemovalFunction function) {
        //        LinkedHashMap.Entry<K,V> first = head;
        if (size() > 100) {
//        function.remove(this, first);
        }
    }

    // 표준 인터페이스 BiPredicate 사용.
    public void afterNodeInsertion(Boolean evict, BiPredicate<Map<K, V>, Map.Entry<K, V>> function) {
//        function.test(this, first);
    }

//    @Override
//    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return size() > 5;
//    }
}


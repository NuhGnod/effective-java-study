package chapter6.item37;

//import jdk.internal.access.SharedSecrets;

import java.util.*;

/**
 * A specialized {@link Map} implementation for use with enum type keys.  All
 * of the keys in an enum map must come from a single enum type that is
 * specified, explicitly or implicitly, when the map is created.  Enum maps
 * are represented internally as arrays.  This representation is extremely
 * compact and efficient.
 *
 * <p>Enum maps are maintained in the <i>natural order</i> of their keys
 * (the order in which the enum constants are declared).  This is reflected
 * in the iterators returned by the collections views ({@link #keySet()},
 * {@link #entrySet()}, and {@link #values()}).
 *
 * <p>Iterators returned by the collection views are <i>weakly consistent</i>:
 * they will never throw {@link ConcurrentModificationException} and they may
 * or may not show the effects of any modifications to the map that occur while
 * the iteration is in progress.
 *
 * <p>Null keys are not permitted.  Attempts to insert a null key will
 * throw {@link NullPointerException}.  Attempts to test for the
 * presence of a null key or to remove one will, however, function properly.
 * Null values are permitted.
 *
 * <P>Like most collection implementations {@code EnumMap} is not
 * synchronized. If multiple threads access an enum map concurrently, and at
 * least one of the threads modifies the map, it should be synchronized
 * externally.  This is typically accomplished by synchronizing on some
 * object that naturally encapsulates the enum map.  If no such object exists,
 * the map should be "wrapped" using the {@link Collections#synchronizedMap}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access:
 *
 * <pre>
 *     Map&lt;EnumKey, V&gt; m
 *         = Collections.synchronizedMap(new EnumMap&lt;EnumKey, V&gt;(...));
 * </pre>
 *
 * <p>Implementation note: All basic operations execute in constant time.
 * They are likely (though not guaranteed) to be faster than their
 * {@link HashMap} counterparts.
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/java.base/java/util/package-summary.html#CollectionsFramework">
 * Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @see EnumSet
 * @since 1.5
 */
public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V>
        implements java.io.Serializable, Cloneable {
    /**
     * The {@code Class} object for the enum type of all the keys of this map.
     *
     * @serial
     */
    private final Class<K> keyType;
    private transient K[] keyUniverse;

    /**
     * All of the values comprising K.  (Cached for performance.)
     */

    /**
     * Array representation of this map.  The ith element is the value
     * to which universe[i] is currently mapped, or null if it isn't
     * mapped to anything, or NULL if it's mapped to null.
     */
    private transient Object[] vals;
    private transient int size = 0;

    /**
     * The number of mappings in this map.
     */

    /**
     * Distinguished non-null value for representing null values.
     */
    private static final Object NULL = new Object() {
        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "java.util.EnumMap.NULL";
        }
    };

    private Object maskNull(Object value) {
        return (value == null ? NULL : value);
    }

    @SuppressWarnings("unchecked")
    private V unmaskNull(Object value) {
        return (V) (value == NULL ? null : value);
    }

    public EnumMap(Class<K> keyType) {
        this.keyType = keyType;
        keyUniverse = (K[]) new Enum[]{Issue122test1.A, Issue122test1.B, Issue122test1.C};
        vals = new Object[10];
    }
    private transient Set<Map.Entry<K,V>> entrySet;


    // Query Operations

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     *
     * @param value the value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to this value
     */
    public boolean containsValue(Object value) {
        value = maskNull(value);

        for (Object val : vals)
            if (value.equals(val))
                return true;

        return false;
    }

    /**
     * Returns {@code true} if this map contains a mapping for the specified
     * key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key
     */
    public boolean containsKey(Object key) {
        return isValidKey(key) && vals[((Enum<?>) key).ordinal()] != null;
    }

    private boolean containsMapping(Object key, Object value) {
        return isValidKey(key) &&
                maskNull(value).equals(vals[((Enum<?>) key).ordinal()]);
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key == k)},
     * then this method returns {@code v}; otherwise it returns
     * {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     */
//    public V get(Object key) {
//        return (isValidKey(key) ?
//                unmaskNull(vals[((Enum<?>)key).ordinal()]) : null);
//    }
    public V get(K key) {
        return unmaskNull(vals[key.ordinal()]);
    }
    // Modification Operations

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for this key, the old
     * value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with specified key, or
     * {@code null} if there was no mapping for key.  (A {@code null}
     * return can also indicate that the map previously associated
     * {@code null} with the specified key.)
     * @throws NullPointerException if the specified key is null
     */
    public V put(K key, V value) {
        typeCheck(key);

        int index = key.ordinal();
        Object oldValue = vals[index];
        vals[index] = maskNull(value);
        if (oldValue == null)
            size++;
        return unmaskNull(oldValue);
    }

    /**
     * Removes the mapping for this key from this map if present.
     *
     * @param key the key whose mapping is to be removed from the map
     * @return the previous value associated with specified key, or
     * {@code null} if there was no entry for key.  (A {@code null}
     * return can also indicate that the map previously associated
     * {@code null} with the specified key.)
     */
    public V remove(Object key) {
        if (!isValidKey(key))
            return null;
        int index = ((Enum<?>) key).ordinal();
        Object oldValue = vals[index];
        vals[index] = null;
        if (oldValue != null)
            size--;
        return unmaskNull(oldValue);
    }

    private boolean removeMapping(Object key, Object value) {
        if (!isValidKey(key))
            return false;
        int index = ((Enum<?>) key).ordinal();
        if (maskNull(value).equals(vals[index])) {
            vals[index] = null;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Returns true if key is of the proper type to be a key in this
     * enum map.
     */
    private boolean isValidKey(Object key) {
        if (key == null)
            return false;

        // Cheaper than instanceof Enum followed by getDeclaringClass
//        Class<?> keyClass = key.getClass();
//        return keyClass == keyType || keyClass.getSuperclass() == keyType;
        // use Reflection

        Class<?> declaringClass = key.getClass().getDeclaringClass();
        if (keyType.isAssignableFrom(declaringClass)) {

        }
        return false;
    }

    // Bulk Operations

    /**
     * Copies all of the mappings from the specified map to this map.
     * These mappings will replace any mappings that this map had for
     * any of the keys currently in the specified map.
     *
     * @param m the mappings to be stored in this map
     * @throws NullPointerException the specified map is null, or if
     *                              one or more keys in the specified map are null
     */
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m instanceof EnumMap) {
            EnumMap<?, ?> em = (EnumMap<?, ?>) m;
            if (em.keyType != keyType) {
                if (em.isEmpty())
                    return;
                throw new ClassCastException(em.keyType + " != " + keyType);
            }

            for (int i = 0; i < 10; i++) {
                Object emValue = em.vals[i];
                if (emValue != null) {
                    if (vals[i] == null)
                        size++;
                    vals[i] = emValue;
                }
            }
        } else {
            super.putAll(m);
        }
    }

    /**
     * Removes all mappings from this map.
     */
    public void clear() {
        Arrays.fill(vals, null);
        size = 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = entrySet;
        if (es != null)
            return es;
        else
            return entrySet = new EnumMap.EntrySet();
    }


    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public Iterator<Map.Entry<K,V>> iterator() {
            return new EnumMap.EntryIterator();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> entry = (Map.Entry<?,?>)o;
            return containsMapping(entry.getKey(), entry.getValue());
        }
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> entry = (Map.Entry<?,?>)o;
            return removeMapping(entry.getKey(), entry.getValue());
        }
        public int size() {
            return size;
        }
        public void clear() {
            EnumMap.this.clear();
        }
        public Object[] toArray() {
            return fillEntryArray(new Object[size]);
        }
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                a = (T[])java.lang.reflect.Array
                        .newInstance(a.getClass().getComponentType(), size);
            if (a.length > size)
                a[size] = null;
            return (T[]) fillEntryArray(a);
        }
        private Object[] fillEntryArray(Object[] a) {
            int j = 0;
            for (int i = 0; i < vals.length; i++)
                if (vals[i] != null)
                    a[j++] = new AbstractMap.SimpleEntry<>(
                            keyUniverse[i], unmaskNull(vals[i]));
            return a;
        }
    }


    private class EntryIterator extends EnumMapIterator<Map.Entry<K,V>> {
        private EnumMap.EntryIterator.Entry lastReturnedEntry;

        public Map.Entry<K,V> next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturnedEntry = new EnumMap.EntryIterator.Entry(index++);
            return lastReturnedEntry;
        }

        public void remove() {
            lastReturnedIndex =
                    ((null == lastReturnedEntry) ? -1 : lastReturnedEntry.index);
            super.remove();
            lastReturnedEntry.index = lastReturnedIndex;
            lastReturnedEntry = null;
        }

        private class Entry implements Map.Entry<K,V> {
            private int index;

            private Entry(int index) {
                this.index = index;
            }

            public K getKey() {
                checkIndexForEntryUse();
                return keyUniverse[index];
            }

            public V getValue() {
                checkIndexForEntryUse();
                return unmaskNull(vals[index]);
            }

            public V setValue(V value) {
                checkIndexForEntryUse();
                V oldValue = unmaskNull(vals[index]);
                vals[index] = maskNull(value);
                return oldValue;
            }

            public boolean equals(Object o) {
                if (index < 0)
                    return o == this;

                if (!(o instanceof Map.Entry))
                    return false;

                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                V ourValue = unmaskNull(vals[index]);
                Object hisValue = e.getValue();
                return (e.getKey() == keyUniverse[index] &&
                        (ourValue == hisValue ||
                                (ourValue != null && ourValue.equals(hisValue))));
            }

            public int hashCode() {
                if (index < 0)
                    return super.hashCode();

                return entryHashCode(index);
            }

            public String toString() {
                if (index < 0)
                    return super.toString();

                return keyUniverse[index] + "="
                        + unmaskNull(vals[index]);
            }

            private void checkIndexForEntryUse() {
                if (index < 0)
                    throw new IllegalStateException("Entry was removed");
            }
        }
    }
    private int entryHashCode(int index) {
        return (keyUniverse[index].hashCode() ^ vals[index].hashCode());
    }
    private abstract class EnumMapIterator<T> implements Iterator<T> {
        // Lower bound on index of next element to return
        int index = 0;

        // Index of last returned element, or -1 if none
        int lastReturnedIndex = -1;

        public boolean hasNext() {
            while (index < vals.length && vals[index] == null)
                index++;
            return index != vals.length;
        }

        public void remove() {
            checkLastReturnedIndex();

            if (vals[lastReturnedIndex] != null) {
                vals[lastReturnedIndex] = null;
                size--;
            }
            lastReturnedIndex = -1;
        }

        private void checkLastReturnedIndex() {
            if (lastReturnedIndex < 0)
                throw new IllegalStateException();
        }
    }
    /**
     * Throws an exception if e is not of the correct type for this enum set.
     */
    private void typeCheck(K key) {
        Class<?> keyClass = key.getClass();
        if (keyClass != keyType && keyClass.getSuperclass() != keyType)
            throw new ClassCastException(keyClass + " != " + keyType);
    }

    /**
     * Returns all of the values comprising K.
     * The result is uncloned, cached, and shared by all callers.
     */
//    private static <K extends Enum<K>> K[] getKeyUniverse(Class<K> keyType) {
//        return SharedSecrets.getJavaLangAccess()
//                .getEnumConstantsShared(keyType);
//    }

    private static final long serialVersionUID = 458661240069192865L;

    /**
     * Save the state of the {@code EnumMap} instance to a stream (i.e.,
     * serialize it).
     *
     * @serialData The <i>size</i> of the enum map (the number of key-value
     *             mappings) is emitted (int), followed by the key (Object)
     *             and value (Object) for each key-value mapping represented
     *             by the enum map.
     */

}

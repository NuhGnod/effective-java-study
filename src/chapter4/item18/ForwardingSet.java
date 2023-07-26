package chapter4.item18;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E>{
    private final Set<E> set;

    public ForwardingSet(Set<E> set) {
        this.set = set;
    }

    public void clear() {
        set.clear();
    }

    //    @Override
//    public void clear() {
//        set.clear();
//
//    }
    public boolean contains(Object o) {
        return set.contains(o);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }

    public Iterator<E> iterator() {
        return set.iterator();
    }

    //    public boolean add(E e) {
//        return set.add(e);
//    }

    public boolean add(E e) {
        return set.add(e);
    }

    public boolean remove(Object o) {
        return set.remove(o);
    }


    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }


    public Object[] toArray() {
        return set.toArray();
    }


    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }


    //    public boolean addAll(Collection<? extends E> c) {
//        return set.addAll(c);
//    }

    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }


    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return set.equals(obj);
    }

    @Override
    public String toString() {
        return set.toString();
    }
}

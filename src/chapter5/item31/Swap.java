package chapter5.item31;

import java.util.ArrayList;
import java.util.List;

public class Swap {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        swap(list,1,2);
        System.out.println("list = " + list);
        swapType(list, 1, 2);
        System.out.println("list = " + list);

        List list2 = new ArrayList();
        list2.add(11);
        list2.add(12);
        list2.add(13);
        list2.add(14);
        swap(list2,1,2);
        System.out.println("list = " + list2);
        swapType(list2, 1, 2);
        System.out.println("list = " + list2);


    }

    public static void swap(List<?> list, int i, int j) {
        Object o = list.get(i);
        list.add(null);
//        list.set(i, list.set(j, o);

//        helper(list, i, j);
    }

    private static <E> void helper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void swapType(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));

    }

}
class QWE<T>{
    public <T>  void swap(List<?> list, int i, int j) {
//        Object o = list.get(i);
        List<T> result = (List<T>) list;
//        list.add(null);
//        list.set(i, list.set(j, o);

//        helper(list, i, j);
    }

    private static <E> void helper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void swapType(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));

    }
}

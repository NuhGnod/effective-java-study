package chapter5.item27;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Set<Lark> ex = new HashSet();
        ex.getClass();
//        Arrays.copyOf(new Number[]{}, 10, Number.class);
//
//        String s = (String) new Object();
        Class<? extends Set> aClass = ex.getClass();
//        Type
//        Lark lark = (aClass) new Object();
//        lark.print();
//        System.out.println(lark.getClass());

        Lark[] arrLarks = new Lark[10];
        Object[] obj = new Object[4];

        ArrayList<Lark> larks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lark lark = new Lark(i);

            if (i < 4) {
                larks.add(lark);

                obj[i] = lark;
            }
            if (i >= 5) {
                arrLarks[i] = lark;

            }
        }
        Object[] objects = larks.toArray();
        Lark[] larks1 = larks.toArray(arrLarks);
        System.out.println("larks1 = " + larks1);
        Lark[] larks2 = toArray(arrLarks, obj);
        System.out.println("larks2 = " + larks2);
        Lark[] larks3 = toArray(arrLarks, obj);
        @SuppressWarnings("unchecked")
        List<String> rawList = getRawList();
        System.out.println("rawList = " + rawList);

        @SuppressWarnings("unchecked")
        List<String> rawListWithMixedTypes = getRawListWithMixedTypes();
        String s = rawListWithMixedTypes.get(3);

        System.out.println("s = " + s);
    }
    public static List getRawListWithMixedTypes() {
        List result = new ArrayList();
        result.add("I am the 1st String.");
        result.add("I am the 2nd String.");
        result.add("I am the 3rd String.");
        result.add(new Date());
        return result;
    }
    public static List getRawList() {
        List result = new ArrayList();
        result.add("I am the 1st String.");
        result.add("I am the 2nd String.");
        result.add("I am the 3rd String.");
        return result;
    }
    public static <T> T[] toArray(T[] a, Object[] obj) {
        if (a.length < 4) {
//            @SuppressWarnings("unchecked") T[] objects = (T[]) Arrays.copyOf(obj, 4, a.getClass());
//            return objects; //비검사경고 발생. 왜? (T[]) 로 형변환시.
            return (T[]) Arrays.copyOf(obj, 4, a.getClass());

        }
        System.arraycopy(obj, 0, a, 0, 4);
        if (a.length > 4) {
            a[4] = null;
        }
        return a;
    }

}

class Lark {
    private int index;

    public void print() {
        System.out.println("ASD");

    }

    public Lark(int index) {
        this.index = index;
    }
}
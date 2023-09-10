package chapter9.item62;

public class Main {
    public static void main(String[] args) {
        ThreadLocal.Key key = ThreadLocal.getKey();
        key.set(key, "HELLO");
        Object o1 = key.get(key);
        System.out.println("o1 = " + o1);
        Key key1 = new Key();
        key1.set(key1, "JAVA");
        Object o = key1.get(key1);
        System.out.println("o = " + o);

    }
}

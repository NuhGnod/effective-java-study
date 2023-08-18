package chapter8.item52;

public class StringValueOf {
    public static void main(String[] args) {

        String s = "Hello";
        String hello = new String("Hello");
        String hello1 = String.valueOf("Hello");
        char[] cs = new char[]{'H', 'e', 'l', 'l', 'o'};
        String s1 = new String(cs);
        String s2 = String.valueOf(cs);
        System.out.println();
    }
}

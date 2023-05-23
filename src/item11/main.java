package item11;

public class main {
    public static void main(String[] args) {
        Parent pr = new Parent("parent", 40);
        Parent pr2 = new Parent("parent", 40);
        Child ch = new Child(pr.parentName, pr.parentAge,"child", 10);
        Child ch2 = new Child(pr2.parentName, pr2.parentAge,"child", 10);
        int i = ch.hashCode();
        System.out.println("i = " + i);
        System.out.println("ch.equals(ch2) = " + ch.equals(ch2));
        System.out.println("(ch==ch2) = " + (ch==ch2));
    }
}

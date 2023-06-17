package item24;

public class Outer {
    private int[] arr;

    // 내부 클래스
    class Inner_Class {
        public void print() {
            System.out.println(Outer.this);
        }
    }
    public static class 도우미클래스{
        int a = 1;
        private int b = 2;
        final int c = 3;
        static final int d = 4;
        public void 도우미(){
            System.out.println("도우미 public static class");
        }
        public static void 정적도우미() {
            System.out.println("public static class static method");

        }
    }
    private static class 정적멤버클래스{
        public void 도우미아님(){
            System.out.println("private static class method");
        }
    }

    // 외부 클래스 생성자
    public Outer(int size) {
        arr = new int[size];
        System.out.println("Outer 인스턴스 생성 : " +this);
    }
    public void print() {
        System.out.println("Outer 인스턴스");
        도우미클래스.정적도우미();
        int d = 도우미클래스.d;

    }

}
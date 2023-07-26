package chapter3.item13;

public class item13 {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cTest = new CloneTest(1, 2);

        cTest.arr[0] = 0;
        cTest.arr[1] = 1;
        cTest.arr[2] = 2;
        System.out.println("cTest.toString() = " + cTest.toString());
        CloneTest clone = cTest.clone();
        System.out.println("clone.toString() = " + clone.toString());
        System.out.println("clone 수정===========");
        clone.arr[0] = 100;
        clone.arr[1] = 100;
        clone.arr[2] = 100;
        System.out.println("cTest.toString() = " + cTest.toString());
        System.out.println("clone.toString() = " + clone.toString());
        CloneTest clone2 = cTest.clone();
        System.out.println("clone2.toString() = " + clone2.toString());
        System.out.println("불변 필드 수정===========");
        CloneTestChild ctc = new CloneTestChild(10, 20);
        CloneTest clone1 = ctc.clone();
        System.out.println(clone1.x);
    }
}

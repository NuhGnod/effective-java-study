package chapter3.item13;

import java.util.Arrays;

public class CloneTest implements Cloneable {
    int x, y;
    int arr[];

    public CloneTest(int x, int y) {
        this.x = x;
        this.y = y;
        this.arr = new int[x + y];
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
//
        CloneTest result = (CloneTest)super.clone();
        result.arr = arr.clone();
        return result;
//        return (CloneTest) super.clone();
    }
}

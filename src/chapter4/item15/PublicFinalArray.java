package chapter4.item15;

public class PublicFinalArray {
    private final int array[];

    public PublicFinalArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return this.array;
    }

    @Override
    public String toString() {
        System.out.println("pfArray : ");
        for (int n : array) {
            System.out.print(n + " ");
        }
        return "";
    }
}

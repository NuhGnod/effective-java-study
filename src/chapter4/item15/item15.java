package chapter4.item15;

public class item15 {
    public int publicX=1;
    private int privateY=2;
    int defaultZ=3;
    protected int protectW=4;
    public static void main(String[] args) {

        PackPrivateChild ppc = new PackPrivateChild(11);
        ppc.method();

    }
    protected  void star(){
        System.out.println(toString());
        System.out.println("star");
    }

    @Override
    public String toString() {
        return "chapter4.item15{" +
                "publicX=" + publicX +
                ", privateY=" + privateY +
                ", defaultZ=" + defaultZ +
                ", protectW=" + protectW +
                '}';
    }

    public void circle() {
        System.out.println("circle");
    }
}

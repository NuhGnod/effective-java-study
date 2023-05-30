package item15;

public class item15 {
    public int x=1;
    private int y=2;
    int d=3;
    protected int e=4;
    public static void main(String[] args) {

        PackPrivateChild ppc = new PackPrivateChild(11);
        ppc.method();


    }
    protected  void star(){
        System.out.println("star");
    }

    public void circle() {
        System.out.println("circle");
    }
}

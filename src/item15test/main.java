package item15test;


import item15.PackPrivateChild;
import item15.item15;

public class main extends item15{
    public static void main(String[] args) {
//        PackPrivate pp = new PackPrivate(2);
        PackPrivateChild packPrivateChild = new PackPrivateChild(2);
        packPrivateChild.method();
        main m = new main();
        m.method();
    }
    public void method(){
        item15 item15 = new main();
        main item151 = (main) item15;
        item151.star();

    }
}

package item15test;


import item15.PackPrivateChild;
import item15.item15;

public class main extends PackPrivateChild{
    public main(int x) {
        super(x);
    }

    public static void main(String[] args) {
//        PackPrivate pp = new PackPrivate(2);
        PackPrivateChild packPrivateChild = new PackPrivateChild(2);
//        packPrivateChild.printProtect();
        PackPrivateChild sd = new main(123);
        main adsasd = (main) sd;

        int i = adsasd.printProtect();
        System.out.println("i = " + i);
        int method = packPrivateChild.method();
        System.out.println("method = " + method);

//        main m = new main();
//        m.method();
//        int asddas = asddas();

    }

//    @Override
//    protected int printProtect() {
//        return super.printProtect();
//    }
    //    public void method(){
//        item15 item15 = new main();
//        main item151 = (main) item15;
//        item151.star();
//
//    }

    public int asddas(){
        printProtect();
        return super.printProtect();
    }
}

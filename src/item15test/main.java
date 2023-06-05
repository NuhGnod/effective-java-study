package item15test;

import item15.item15;

public class main extends item15{

    public static void main(String[] args) {
        item15 item15 = new main();
//        item15.star(); // 불가능
        main item151 = (main) item15;
        item151.star();

        main main = new main();
        main.star();
//        PackPrivate pp = new PackPrivate(2);
//        PackPrivateChild packPrivateChild = new PackPrivateChild(2);
//        packPrivateChild.printProtect();
//        PackPrivateChild sd = new main(123);
//        main adsasd = (main) sd;
//
//        int i = adsasd.printProtect();
//        System.out.println("i = " + i);
//        int method = packPrivateChild.method();
//        System.out.println("method = " + method);

//        main m = new main();
//        m.method();

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

}

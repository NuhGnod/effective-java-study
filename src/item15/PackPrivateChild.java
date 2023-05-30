package item15;

public class PackPrivateChild extends PackPrivate{

    public PackPrivateChild(int x) {
        super(x);
    }
    public void method(){
//        PackPrivateChild packPrivate =  new PackPrivate(1);
        PackPrivate packPrivate1 = new PackPrivate(22);
        packPrivate1.printProtect();
//        packPrivate.printProtect();
    }
}

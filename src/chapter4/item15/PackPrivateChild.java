package chapter4.item15;

public class PackPrivateChild extends PackPrivate{

    public PackPrivateChild(int x) {
        super(x);
    }

    @Override
    protected int printProtect() {
        return super.printProtect();
    }

    public int method(){
//        PackPrivateChild packPrivate =  new PackPrivate(1);
        PackPrivate packPrivate1 = new PackPrivate(22);
        return packPrivate1.printProtect();
//        packPrivate.printProtect();
    }
}

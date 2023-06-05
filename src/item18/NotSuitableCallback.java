package item18;

public class NotSuitableCallback {

    public static void main(String[] args) {
        SomeService   service       = new SomeService();
        WrappedObject wrappedObject = new WrappedObject(service);
        Wrapper       wrapper       = new Wrapper(wrappedObject);
        wrapper.doSomething(wrapper);
    }
}
interface SomethingWithCallback {

    void doSomething(SomethingWithCallback c);

    void call();

}


class WrappedObject implements SomethingWithCallback {

    private final SomeService service;

    WrappedObject(SomeService service) {
        this.service = service;
    }

    @Override
    public void doSomething(SomethingWithCallback c) {
        service.performAsync(c);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}


class Wrapper implements SomethingWithCallback {

    private final WrappedObject wrappedObject;

    Wrapper(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void doSomething(SomethingWithCallback c) {
        wrappedObject.doSomething(this);
    }

    void doSomethingElse() {
        System.out.println("We can do everything the wrapped object can, and more!");
    }

    @Override
    public void call() {
        System.out.println("Wrapper callback!");
    }
}

final class SomeService {

    void performAsync(SomethingWithCallback callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }

    void perform() {
        System.out.println("Service is being performed.");
    }
}
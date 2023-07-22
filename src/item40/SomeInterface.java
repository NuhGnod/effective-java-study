package item40;

public interface SomeInterface {
    void interfaceMethod();

    default void defaultMethod() {
        System.out.println("디폴트 메소드");
    }
}

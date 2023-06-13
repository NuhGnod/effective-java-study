package item20;

public class American extends AbstractPerson {

    public American(int origin) {
        super(origin);
    }

    @Override
    public void talk() {
        System.out.println("Hello");
    }

    @Override
    public void nativeLanguage() {
        System.out.println("Enghlish");
    }
}

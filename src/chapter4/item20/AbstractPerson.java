package chapter4.item20;

public abstract class AbstractPerson implements Person {

    private int origin;
    public static final String aa = "ASD";
    @Override
    public int getOrigin() {
        return origin;
    }

    public AbstractPerson(int origin) {

        this.origin = origin;
    }

    @Override
    public void eat() {
        System.out.println("냠yam");
    }

    @Override
    public void run() {
        System.out.println("헥huk");
    }

    @Override
    public Person getInstance() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        AbstractPerson obj1 = (AbstractPerson) obj;
        System.out.println("AbstractionPerson 의 equals() : " );
        return this.getOrigin() == obj1.getOrigin();
    }
}

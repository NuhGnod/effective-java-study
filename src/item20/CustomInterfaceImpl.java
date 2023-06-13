package item20;

public class CustomInterfaceImpl implements CustomInterface {
    private int x;
    @Override
    public void print() {

    }

    public CustomInterfaceImpl(int x) {
        this.x = x;
    }
    @Override
    public void defualtPrint(int n) {
        System.out.println(this.x == n);
        CustomInterface.super.defualtPrint(n);
    }

    @Override
    public int getFieldValue() {
        return this.x;
    }

    @Override
    public CustomInterface getInstance() {
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hh() {
        return CustomInterface.super.hh();
    }
}

package item13;

public class CloneTestChild extends CloneTest{
    public CloneTestChild(int x, int y) {
        super(x, y);
    }

    @Override
    protected CloneTestChild clone() throws CloneNotSupportedException {
        return (CloneTestChild) super.clone();
    }
}

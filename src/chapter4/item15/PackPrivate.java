package chapter4.item15;

class PackPrivate {
    int x;
    public PackPrivate(int x) {
        this.x = x;
    }
    protected int printProtect() {
        System.out.println("PP print2 protected method");
        return x;

    }
    public void print() {
        System.out.println("public method");
    }
}

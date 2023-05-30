package item15;

class PackPrivate {
    int x;
    public PackPrivate(int x) {
        this.x = x;
    }
    protected void printProtect() {
        System.out.println("PP print2 protected method");
    }
    public void print() {
        System.out.println("public method");
    }
}

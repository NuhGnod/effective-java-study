package item20;

public interface Person {
    public int x = 0; // final임.

    public void eat();

    public void run();

//    public void talk();
    default public void talk(String i){
        return ;
    }
    default public void talk(){
        return;
    }
    public void nativeLanguage();

    public Person getInstance();

    public int getOrigin();
    public static int xxx = 1;
//    private static int yyy =2;
    private static int YYY() {
        return x;
    }
    public static int XX() {
        return YYY();
    }
    default boolean isSame(int target) {
        Person instance = this.getInstance();
        int origin = instance.getOrigin();
        return origin == target;
    }
}

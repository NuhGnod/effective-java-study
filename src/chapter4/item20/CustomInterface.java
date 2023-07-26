package chapter4.item20;

public interface CustomInterface {
    public static int a = 0;
    static int b = 1;

    void print();

    private void pprint() {
        System.out.println();
    }

    static void staticPrint() {
        System.out.println("static print@@");
    }

    default public void defualtPrint(int n) {
        CustomInterface instance = getInstance();
        int fieldValue = instance.getFieldValue();
        System.out.println("equals() = " + ( fieldValue == n));
//        int i = hashCode();
        boolean equals = this.equals(n);
        System.out.println("equals = " + equals);
        System.out.println("default print!!");
    }

    int getFieldValue();
    CustomInterface getInstance();
    /**
     * @return 0;
     */
//    default boolean equals(Object obj) {
//        return true;
//    }

    /**
     * @return 0;
     */
//    default int hashCode(){

//    }

    default int hh(){
        return 0;
    }
}

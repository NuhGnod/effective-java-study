package item20;

import java.util.AbstractList;

public class Main {
    public static void main(String[] args) {
//        CustomInterface impl = new CustomInterfaceImpl(100);
//
//        CustomInterface.staticPrint();
//        impl.defualtPrint(100);
        Person korea = new Korean(1234);
        Person korea2 = new Korean(1234);
        Person america = new American(1234);
        boolean same = korea.isSame(america.getOrigin());
        System.out.println("same = " + same);
        boolean equals = korea.equals(korea2);
        System.out.println("equals = " + equals);
//        Person.YYY();
    }
}

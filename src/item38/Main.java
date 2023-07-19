package item38;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 3.0;
        test(ExtendedOperation.class, x, y);
        test(BasicOperation.class, x, y);
        System.out.println();
        test(Arrays.asList(ExtendedOperation.values()),x,y);
        test(Arrays.asList(BasicOperation.values()),x,y);
        EnumMap<BasicOperation, BasicOperation> enumMap = new EnumMap(Operation.class);
        System.out.println();

    }

    // ======================= v1 =====================
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {

        for (Operation op : opEnumType.getEnumConstants()
        ) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    // ========================= v2 =======================
    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet
        ) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

        }
    }
}

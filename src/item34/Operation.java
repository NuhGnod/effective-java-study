package item34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+") {// public static final field이다. -> public static final PLUS = new PLUS();
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;
    private static final Map<String, String> stringToEnum =
//            Stream.of(values()).collect(
//                    toMap(Object::toString, e -> e));
            new HashMap<>();
    Operation(String symbol) {
        System.out.println("Operation.Operation");
        System.out.println(this.toString());
        this.symbol = symbol;
//        stringToEnum
//        stringToEnum.put("+", this.PLUS);
    }

    @Override
    public String toString() {
        int a = num;
        return symbol;
    }

    public abstract double apply(double x, double y);

    // 코드 34-7 열거 타입용 fromString 메서드 구현하기 (216쪽)

    public static final int num = 100;
    // 지정한 문자열에 해당하는 Operation을 (존재한다면) 반환한다.
    public static Optional<Operation> fromString(String symbol) {
        System.out.println("Hello");
//        return Optional.ofNullable(stringToEnum.get(symbol));
        return Optional.ofNullable(Operation.PLUS);
    }

//    public static void main(String[] args) {
//        double x = Double.parseDouble(args[0]);
//        double y = Double.parseDouble(args[1]);
//        for (Operation op : Operation.values())
//            System.out.printf("%f %s %f = %f%n",
//                    x, op, y, op.apply(x, y));
//    }
}
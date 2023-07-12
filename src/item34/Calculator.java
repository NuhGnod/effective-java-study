package item34;

import java.util.AbstractList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Calculator {


    private final String symbol;

    private int battery;
    private static int a = 1;

    public Calculator() {
        System.out.println("Calculator.Calculator");
        System.out.println(this);
        this.symbol = "";
        this.battery = 100;
    }

    public double calculate(Operation op, double x, double y) {
        if (this.battery == 0) throw new RuntimeException("배터리 없음.");
        this.battery -= 1;
        int instance = a;
        return op.apply(x, y);
    }

    void method() {
        int instance = a;
        System.out.println("instance = " + instance);
    }

    static void staticMethod() {
//         int bb = battery; // 안됨.
        int ccc = a;
    }

    public enum Operation {

        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        ;
        private enum PLUS{

        }
        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public abstract double apply(double x, double y);

        @Override
        public String toString() {
            return symbol;
        }
    }
}

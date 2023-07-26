package chapter7.item42;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+", Operation::applyAsDouble),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x,y) -> Double.parseDouble(x + MINUS.object.toString())),
    DIVIDE("/", (x, y) -> x / y) {
        public double apply(double a, double b) {
            String ss = DIVIDE.symbol;
            System.out.println("ss = " + ss);
            return a * b;
        }
    },
    ;

    private final String symbol;
    private final DoubleBinaryOperator operator;
    public static Object object;
    Operation(String symbol, DoubleBinaryOperator operator) {
        System.out.println(operator.toString());
        this.symbol = symbol;
        this.operator = operator;
    }

    private static double applyAsDouble(double x, double y) {
        Operation plus = PLUS;
        return x + y;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }

    public void strongMethod(Operation operation) {
        DoubleBinaryOperator operator2 = this.operator;

//        operator2.applyAsDouble();
    }
}
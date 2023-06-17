package item34;

public class Calculator {
    private int battery;

    public Calculator() {
        this.battery = 100;
    }
    public double calculate(Operation op, double x, double y) {
        if(this.battery == 0) throw new RuntimeException("배터리 없음.");
        this.battery -= 1;
        return op.apply(x,y);
    }
    public static enum Operation {
        PLUS,
        MINUS,
        TIMES,
        DIVIDE,
        ;
        public double apply(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
            }
            throw new AssertionError("알수없는 연산 : " + this);
        }
    }
}

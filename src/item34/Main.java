package item34;
public class Main {
    public static void main(String[] args) {
        //계산기 수행.
        Calculator calculator = new Calculator();
        double calculate = calculator.calculate(Calculator.Operation.PLUS, 1.3, 1.7);
        System.out.println("calculate = " + calculate);

        //가능
        double apply = Calculator.Operation.DIVIDE.apply(3, 2);
        System.out.println("apply = " + apply);

    }
}

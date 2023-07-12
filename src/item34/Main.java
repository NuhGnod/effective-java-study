package item34;

import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //계산기 수행.

//        new Calculator.ONE(); //private 이라서 접근 불가. p209 사실상 final

//        double calculate = calculator.calculate(Calculator.Operation.PLUS, 1.3, 1.7);
//        System.out.println("calculate = " + calculate);
//        Calculator.ONE one = calculator.ONE;

        //가능
//        Calculator cc = new Calculator();
//        cc.method();
//        double apply = Calculator.Operation.DIVIDE.apply(3, 2);
//        System.out.println("apply = " + apply);
        //=========================================


//        int num = Operation.num;
//        System.out.println("num = " + num);
//        Map<String, Operation> stringToEnum = Operation.stringToEnum;
//        System.out.println("stringToEnum = " + stringToEnum);
        RawEnum one = RawEnum.ONE;
        System.out.println("one = " + one);
        Operation plus = Operation.PLUS;

        System.out.println("plus = " + plus);
        Optional<Operation> operation = Operation.fromString("+");
        System.out.println("operation = " + operation.get());
    }
}

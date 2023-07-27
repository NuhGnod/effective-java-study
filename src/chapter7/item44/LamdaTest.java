package chapter7.item44;

import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LamdaTest {
    public static void main(String[] args) {
        // [Java Lambda Tutorials](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer consumer = (n) -> {
            System.out.print(n);
        };

        Consumer<Integer> method = (n) -> {
            System.out.print(n);
        };
        numbers.forEach(
                method.andThen(method));
        System.out.println();
        numbers.forEach(method);
        System.out.println();
        numbers.forEach(consumer);

        //Predicate

        Predicate<Integer> predicate = (n) -> n == 10;
        boolean test = predicate.test(10);
        System.out.println("test = " + test);
        Predicate<Integer> negate = predicate.negate();
        boolean test1 = negate.test(10);
        System.out.println("test1 = " + test1);
        Predicate<Integer> or = predicate.or(negate);
        boolean test2 = or.test(10);
        System.out.println("test2 = " + test2);

        // UnarayOperator
        UnaryOperator<Integer> unaryOperator = integer -> {
            return integer * 10;
        };
        Integer apply = unaryOperator.apply(10);
        System.out.println("unaryOperator.apply = " + apply);

        //BinaryOperator
        BinaryOperator<Integer> binaryOperator = (x,y) -> {
            return (x+y)/2;
        };
        Integer apply1 = binaryOperator.apply(10, 8);
        System.out.println("apply1 = " + apply1);

    }

}

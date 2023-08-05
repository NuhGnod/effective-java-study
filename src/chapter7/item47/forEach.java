package chapter7.item47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class forEach {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubledNumbers = new ArrayList<>();

        numbers.forEach(num -> doubledNumbers.add(num * 2));

        System.out.println(doubledNumbers); // 출력: [2, 4, 6, 8, 10]


        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        // Stream의 forEach로는 해당 작업을 할 수 없음 -> 불변성, 상태가 없음.
        List<Integer> doubledNumbers2 = numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());

        System.out.println(doubledNumbers); // 출력: [2, 4, 6, 8, 10]



    }
}

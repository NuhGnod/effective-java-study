package chapter7.item46;

import chapter6.item37.Phase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        // 46-2
        Map<String, Long> freq;
        String[] files = new String[]{"gk", "sk", "Rk", "Sk", "EK", "ek", "fK", "FK", "fk", "Fk",
                "GK", "sk", "Rk", "Sk", "EK", "ek", "fK", "FK", "fk", "Fk"};
        freq
                = Arrays.stream(files)
                .collect(groupingBy(word -> word.toLowerCase(), Collectors.counting()));//                .forEach((key,value) -> {
//                    System.out.println(key + " " + value);
//                })
// 46-3
        List<String> topTen = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("topTen = " + topTen);

//        Map<String, String> collect = Arrays.stream(files).collect(toMap(Objects::toString, e -> e));
        Map<String, String> collect = Arrays.stream(files).collect(toMap(String::toLowerCase, e -> e, (oldV, newV) -> newV));
        System.out.println("collect = " + collect);

        // 46-5
        Artist 가 = new Artist("가");
        Artist 나 = new Artist("나");
        Artist 다 = new Artist("다");
        Artist 라 = new Artist("라");
        Artist 마 = new Artist("마");
        Artist 바 = new Artist("바");
        Artist 사 = new Artist("사");
        Artist 아 = new Artist("아");
        Album[] albums = new Album[]{new Album(가, 100, "가의 앨범")
                , new Album(나, 100, "나의 앨범")
                , new Album(나, 200, "나의 앨범200")
                , new Album(다, 100, "다의 앨범")
                , new Album(라, 100, "라의 앨범")
                , new Album(마, 100, "마의 앨범")
                , new Album(바, 100, "바의 앨범")
                , new Album(사, 100, "사의 앨범")
                , new Album(아, 100, "아의 앨범")
        };
        Map<Artist, Album> topHits =
                Arrays.stream(albums)
                        .collect(toMap(Album::artist, a -> a, BinaryOperator.maxBy(Comparator.comparing(Album::sales))));
        topHits.forEach((key, value) -> System.out.println(key.name + " : " + value.name));
        System.out.println();
        // 이전 방식.
        Map<Artist, Album> originMap = new HashMap<>();
        for (Album album : albums) {
            Artist key = album.artist();

            Album newValue = album;
            if (originMap.containsKey(key)) {
                Album oldValue = originMap.get(key);
                if (oldValue.sales < newValue.sales) {
                    originMap.put(key, newValue);
                    continue;
                }
            }
            originMap.put(key, newValue);

        }
        originMap.forEach((key, value) -> System.out.println(key.name + " : " + value.name));

        //groupingBy
        System.out.println();
        //Album의 artist라는  key로 분류하는데, 생성된 결과를 TreeMap 구조로 되어있고, 각 key-value의 value는 set형태이다.
        TreeMap<Artist, Set<Long>> collect1 = Arrays.stream(albums).
                collect(groupingBy(Album::artist, TreeMap::new, mapping(Album::sales, toSet())));
        collect1.forEach((k, v) -> System.out.println(k.name + " : " + v));
        System.out.println("collect1 = " + collect1);

        //partitionBy
        System.out.println();
        Arrays.stream(albums).collect(partitioningBy(album -> {
            return album.sales == 100;

        })).forEach((k,v) -> System.out.println(k + " : " + v));

        //joining
        System.out.println();
        String collect2 = Arrays.stream(files).collect(joining(",", "Joining -> ", " //"));
        System.out.println(collect2);

        // 함수형 프로그래밍 고차함수
        Function<Integer, Function<Integer, Integer>> addCurried = x -> (y -> x % y);
        Function<Integer, Integer> addFive = addCurried.apply(5);
        int result = addFive.apply(3);
        System.out.println("Result: " + result); // Output: Result: 8
    }
}

package item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Main {
    public static void main(String[] args) {
        Plant[] garden = new Plant[]{new Plant("first", Plant.LifeCycle.ANUAL),
                new Plant("second", Plant.LifeCycle.BIENNIAL),
                new Plant("third", Plant.LifeCycle.PERENNIAL),
                new Plant("fourth", Plant.LifeCycle.PERENNIAL)};
        //==================================== v1 ===================================

//        Set<Plant>[] plantsByLifeCycle = new Set[Plant.LifeCycle.values().length]; // 비검사 형변환 경고 발생!
//        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length]; // 비검사 형변환 경고 발생 해결
//        for (int i = 0; i < plantsByLifeCycle.length; i++) {
//            plantsByLifeCycle[i] = new HashSet<>();
//        }
//        for (Plant p : garden) {
//            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
//        }
//        for (int i = 0; i < plantsByLifeCycle.length; i++) {
//            System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
//        }
//        Set<Plant> plants = plantsByLifeCycle[Plant.LifeCycle.PERENNIAL.ordinal()];
//        for (Plant p : plants
//        ) {
//            if (p.lifeCycle == Plant.LifeCycle.PERENNIAL) System.out.println("p = " + p);
//        }
        /**
         *  pros :
         *  위의 방식처럼 oridinal() 를 사용한다
         *  하지만, 차이점은 put,get메소드를 사용할 때 직접 정수를 사용하여 순서를 고려하지 않아도 된다.
         *  => 내부적으로 oridinal()를 통해 순서를 고려하여 동작하고 있음.
         *  가정 1)
         *  기존방식에서는 plantsByLifeCycle[0].add(Plant.LifeCycle.PERENNIAL); 과 같이 정수를 사용하여 삽입할수도,
         *  Plant.LifeCycle lc = plantsByLifeCycle[0];
         *  if(lc == Plant.LifeCycle.PERENNIAL) 과 같이 직접 원소를 꺼내올 수 있다.
         *  물론 이런짓은 안하겠지만, 실수로 가능하다. 이렇게 정확한 정숫값을 사용함을 보증하기는 힘들다.
         *  Plant Enum의 사용자(?)들이 어떠한 실수를 할지 막지 못한다.
         *
         *  하지만 EnumMap은 내부적으로 한정적 타입 체크를 통해 다른 열거 상수가 들어옴을 방지하고,
         *  직적접인 정수 사용을 방지하여 정확한 순서를 보장한다.
         *
         */

        // ============================ v2 =====================================
//        EnumMap<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class); // EnumMap + 한정적 타입 토큰 이용
//
//        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
//            plantsByLifeCycle.put(lc, new HashSet<>());
//        }
//        for (Plant p : garden
//        ) {
//            plantsByLifeCycle.get(p.lifeCycle).add(p);
//        }
//        System.out.println(plantsByLifeCycle);

        // =========================== v3 ==============================

        System.out.println(Arrays.stream(garden).collect(groupingBy(p -> p.lifeCycle)));
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class),
                        toSet())));

        // =========================
        Phase.Transition from = Phase.Transition.from(Phase.SOLID, Phase.LIQUID);
        System.out.println("from = " + from);
    }
}

class Plant {
    enum LifeCycle {
        ANUAL,
        PERENNIAL,
        BIENNIAL,
    }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
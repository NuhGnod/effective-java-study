package chapter7.item47;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class forEach {
//    public static void main(String[] args) {
//        List<String> stringList = new ArrayList<>();
//        stringList.add("Hello");
//
//        // 제네릭 타입을 사용한 형변환 (Checked Cast)
////        List<String> checkedCastList = castToCheckedType(stringList);
//        try{
//            검사 예외 발생.
//        }catch (Exception e){
//            // 올바를 예외 처리
//        }
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> doubledNumbers = new ArrayList<>();
//
//        numbers.forEach(num -> doubledNumbers.add(num * 2));
//
//        System.out.println(doubledNumbers); // 출력: [2, 4, 6, 8, 10]
//
//
//        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
//        // Stream의 forEach로는 해당 작업을 할 수 없음 -> 불변성, 상태가 없음.
//        List<Integer> doubledNumbers2 = numbers.stream()
//                .map(num -> num * 2)
//                .collect(Collectors.toList());
//
//        System.out.println(doubledNumbers); // 출력: [2, 4, 6, 8, 10]
//        String[] arr = new String[]{"a", "b"};
//        for (String arg : (Iterable<String>) Arrays.stream(arr)::iterator) {
//            System.out.println(arg);
//        }
//        for (String arg : of(Arrays.stream(arr))) {
//            System.out.println(arg);
//        }
//        Iterable<String> iterator = Arrays.stream(arr)::iterator;
//
//        BInterface bInterface = AtoB(new AInterface() {
//        });
//        System.out.println(bInterface);
//
//
//        for (String s : functional(Arrays.stream(arr))) {
//            System.out.println(s);
//        }
//
//    }
//
//    public static BInterface AtoB(AInterface a) {
//        return (BInterface) a;
//    }
//
//    public static <E> Iterable<E> of(Stream<E> stream) {
//        return (Iterable<E>) stream::iterator;
//    }
//
//    public static <E> Iterable<E> functional(Stream<E> stream) {
//        return (Iterable<E>) stream.iterator();
////        return stream::iterator;
//
//    }
//    // 제네릭 타입을 사용한 형변환 메서드 (Checked Cast)
//    public static  <T> List<?> castToCheckedType(List<T> list) {
//        return List.of("ASd");
//    }
public static void main(String[] args) {

    Person p1 = new Person(1);
    p1.setName("jieun");
    p1.setJob("developer");
    Person p2 = new Person(2);
    p1.setName("Stop");
    List<Person> people = Arrays.asList(p1,p2);
    people.stream()
            .map(Person::haveJob1)
            .forEach(System.out::println);
//    Person.haveJob();

//    people.stream()
//            .map(Person::haveJob)    //컴파일 에러
//            .forEach(System.out::println);
}
    static class Person{
        private final int id;
        private String name;
        private String job;
        public Person(int id){
            this.id=id;
        }
        public void setName(String name){
            this.name=name;
        }
        public String setJob(String job){
            this.job = job;
            return "";
        }
        public String haveJob1(){
            if(job==null){
                job = "default job";
            }
            return String.valueOf(id)+" "+name+" "+job;
        }
        public static String haveJob() throws Exception {
            throw new Exception();
        }
//            if(job==null){
//                throw new Exception("직업을 입력하지 않았습니다.");
//            }
//            return String.valueOf(id)+" "+name+" "+job;
        }
}

package chapter4.item24;

public class Main {
    public static void main(String[] args) {
//        AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry("key1", "value2");
//        Object value = simpleEntry.getValue();
//        System.out.println("value = " + value);

//        LinkedList
//        WeakHashMap
//        StaticTest st = new StaticTest();
//        StaticTest.innerClass innerClass = new StaticTest().new innerClass();
//        st.new innerClass();

//        Outer.Inner_Class inner_class = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class1 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class2 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class3 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class4 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class5 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class6 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class7 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class8 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class9 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class11 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class12 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class13 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class14 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class15 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class16 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class17 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class18 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class19 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class20 = new Outer(100_000_000).new Inner_Class();
//        Outer.Inner_Class inner_class21 = new Outer(100_000_000).new Inner_Class();
//        inner_class.print();

//        Outer.도우미클래스.정적도우미();
        Outer.도우미클래스 도우미클래스 = new Outer.도우미클래스();
//        도우미클래스.도우미();
        Outer outer = new Outer(100);
        outer.push(도우미클래스);
        System.out.println(outer.getHelper()[0].a);
        도우미클래스.a = -1;
        System.out.println(outer.getHelper()[0].a);
        Anonymous an = new Anonymous();
        an.say();
        an.an.print();
        Animal dog = new Animal() {
            // @Override 메소드
            public String bark() {
                return "개가 짖습니다";
            }

            // 새로 정의한 메소드
            public String run() {
                return "달리기 ㄱㄱ싱";
            }
        };
        System.out.println(dog.bark());
//        dog.run(); // ! Error - 외부에서 호출 불가능
    }

}

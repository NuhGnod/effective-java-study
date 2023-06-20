package item24;
// 부모 클래스
class Animal {
    public String bark() {
        return "동물이 웁니다";
    }
}
class Creature {
    // 필드에 익명자식 객체를 생성 하여 이용
    Animal dog = new Animal() {
        public String bark() {
            return "멍멍";
        }
    };

    public void method() {
        dog.bark();
    }

    public void method2() {
        dog.bark();
    }
}
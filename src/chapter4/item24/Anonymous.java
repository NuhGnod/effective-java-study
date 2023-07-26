package chapter4.item24;

public class Anonymous {

    SuperC an = new SuperC() {
        @Override
        public void print() {
            super.print();
            say();
            Anonymous.this.say();
        }
        public void say() {
            System.out.println("say~~~ 익명~~!");
        }

    };
    void say() {

        SuperC an = new SuperC() {
            @Override
            public void print() {
                super.print();
            }
            public void say() {
                System.out.println("say~~~ 익명~~!");

            }

        };
        an.print();
    }
}

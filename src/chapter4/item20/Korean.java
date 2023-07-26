package chapter4.item20;

public class Korean extends AbstractPerson {
    public Korean(int origin) {
        super(origin);
    }

    @Override
    public void talk() {
        System.out.println(aa);
        String aa = "123";
        System.out.println(aa);
//        System.out.println("안녕하세요.");
    }

    @Override
    public void nativeLanguage() {
        System.out.println("한국어");
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Korean)) {
//            return false;
//        }
//        Korean obj1 = (Korean) obj;
//        int origin = obj1.getOrigin();
//        return this.getOrigin() == origin;
//    }
}

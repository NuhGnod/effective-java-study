package item11;

public class Child extends Parent {
    String childName;
    int childAge;

    public Child(String parentName,int parentAge, String childName, int childAge) {
        super(parentName, parentAge);
        this.childName = childName;
        this.childAge = childAge;
    }

}

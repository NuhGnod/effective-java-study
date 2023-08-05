package chapter7.item44.ComparableTest;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age == o.age){
            return this.name.hashCode() - o.name.hashCode();
        }
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return String.format("나이 : %d, 이름 : %s%n", age,name);
    }
}

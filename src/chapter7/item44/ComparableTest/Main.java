package chapter7.item44.ComparableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(20, "a");
        Student s2 = new Student(20, "b");
        Student s3 = new Student(20, "c");
        Student s4 = new Student(19, "a");
        Student s5 = new Student(19, "b");
        Student s6 = new Student(18, "a");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        Collections.sort(students);
        System.out.println("students = " + students);
    }
}

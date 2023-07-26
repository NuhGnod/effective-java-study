package chapter4.item15;

import java.util.TreeSet;

public class Account {
    static long balance = 10000;
    TreeSet<Integer> ts = new TreeSet();
    Integer a = 3;
    Integer b = 34;

    public void deposit(long amount) {
        balance = balance + amount;
    }

    public void withdraw(long amount) {
        balance = balance - amount;
    }

    public void inquiry() {
        System.out.println("현재 잔액은 " + balance + "원 입니다");
    }
}
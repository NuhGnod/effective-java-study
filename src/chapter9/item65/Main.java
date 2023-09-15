package chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        args = new String[]{"HashSet", "HashMap"};
        new HashSet<String>();
        try {
            Class<? extends Set<String>> forName1 = (Class<? extends Set<String>>) Class.forName("java.util.HashSet");
            System.out.println("forName1 = " + forName1);
            Constructor<? extends Set<String>> constructor1 = forName1.getConstructor();
            Set<String> set = constructor1.newInstance();
            set.add("asd");
            System.out.println("set = " + set);
            Class<? extends Set<String>> forName2 = (Class<? extends Set<String>>) Class.forName("java.util.HashMap");
            Constructor<? extends Set<String>> constructor2 = forName2.getConstructor();
            Set<String> set1 = constructor2.newInstance();
            set1.add("error");
            System.out.println("set1 = " + set1);
            System.out.println("forName2 = " + forName2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

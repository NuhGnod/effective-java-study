package item7;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class soft {
    public static void main(String[] args) {
        for(;;){
//            SoftReference<List<String>> listReference = new SoftReference<List<String>>(new ArrayList<String>());
            ArrayList<Object> objects = new ArrayList<>();
            objects.add(new Object());
            String obj = new String("QWEQWEWEQEQWEEQ");
            System.out.println("+");
        }

    }

}

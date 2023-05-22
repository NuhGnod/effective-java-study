package item7;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import static java.lang.Thread.sleep;

public class GFG {
    public static void main(String[] args) throws InterruptedException {
        // Strong Reference
        Gfg gfg = new Gfg();

        ReferenceQueue<Gfg> q = new ReferenceQueue<Gfg>();

        // Creating Soft Reference to Gfg-type object to
        // which 'g' is also pointing and registering it
        // with q
        Reference<Gfg> softref
                = new WeakReference<
                >(gfg, q);
        gfg = null;
//        softref.clear();
        System.gc();
        sleep(5000);
        // enqueue softref to its registered queue i.e q

        if (softref.enqueue()) {
            System.out.println(
                    "Object successfully enqueued");
        }
        else {
            System.out.println("Object not enqueued");
        }

        // checking if softref is enqueued or not
        if (softref.isEnqueued()) {
            System.out.println("Object is enqueued");
        }
        else {
            System.out.println("Object not enqueued");
        }

        // clearing this reference object
        softref.clear();
        System.out.println("Object cleared");

        // trying to enqueue after clearing
        if (softref.enqueue()) {
            System.out.println(
                    "Object successfully enqueued");
        }
        else {
            System.out.println("Object not enqueued");
        }

        WeakHashMap<Object, Object> weakHashMap = new WeakHashMap();

//        weakHashMap.put()
    }

    private static class Gfg {
    }
}

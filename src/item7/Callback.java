package item7;


import java.util.HashMap;
import java.util.WeakHashMap;

interface Listener {
    void event();
}
public class Callback {
    public static void main(String[] args) {
        ApiUser user = new ApiUser();
        user.registerListener();
        System.out.println("user = " + user);
        user= null;
        System.gc();
        API.fireListeners();

    }
}
class ApiUser{
    Listener listener = null;
    public void registerListener() {
        listener = new Listener() {
            @Override
            public void event() {
                System.out.println("Some task was working~~");
            }
        };
        API.registerListener(listener);
    }
}

class API {
    static HashMap<Listener, Object> listeners = new HashMap();

    static void registerListener(Listener listener) {
        listeners.put(listener, null);
    }
    static void fireListeners() {
        for (Listener listener : listeners.keySet()) {
            if (listener != null) {
                listener.event();

            }
        }
    }
}


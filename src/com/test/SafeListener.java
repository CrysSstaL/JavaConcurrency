package src.com.test;

import com.sun.jdi.event.Event;

import java.util.EventListener;
import src.com.test.ThisEscape;

public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e){
                System.out.println(e);
            }
        };
    }
    public static SafeListener newInstance(ThisEscape.EventSource source){
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }
}

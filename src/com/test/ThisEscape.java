package src.com.test;

import com.sun.jdi.event.Event;

import java.util.EventListener;

public class ThisEscape {
    /// `Когда класс публикует слушателя Event-listener
    /// он неявно публикует и окаймляющий его экземпляр ThisEscape
    /// так как экземпляры внутреннего класса содержат скрытую ссылку на него
    public ThisEscape(EventSource source){
        source.registerListener(new EventListener() {
            public void onEvent(Event e){
                System.out.println(e);
            }
        });
    }

    public static class EventSource {
        private static EventListener eventListener;
        private void registerListener(EventListener e){
            eventListener = e;
        }
    }
}

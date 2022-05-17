package observer.ex2.publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import observer.ex2.listeners.EventListener;

public class EventManager {
	
	private Map<String, List<EventListener>> listeners;

    public EventManager(String... eventTypes) {
        this.listeners = new HashMap<>();
        for (String eventType : eventTypes)
            this.listeners.put(eventType, new ArrayList<>());
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users =  this.listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users =  this.listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, String displayName, String url) {
        List<EventListener> users =  this.listeners.get(eventType);
        for (EventListener listener : users)
            listener.update(eventType, displayName, url);
    }

}

package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

	Map<TypeOfReports, List<EventListener>> smsListeners = new HashMap<>();
	Map<TypeOfReports, List<EventListener>> emailListeners = new HashMap<>();

	public EventManager(TypeOfReports... operations) {

		for (TypeOfReports operation : operations) {
			smsListeners.put(operation, new ArrayList<>());
			emailListeners.put(operation, new ArrayList<>());
		}
	}

	public void subscribe(TypeOfReports typeRep, SmsListener listener) {
		List<EventListener> users = smsListeners.get(typeRep);
		users.add(listener);

	}

	public void subscribe(TypeOfReports typeRep, EmailListener listener) {
		List<EventListener> users = emailListeners.get(typeRep);
		users.add(listener);

	}

	public void unSubscribe(TypeOfReports typeRep, SmsListener listener) {
		 List<EventListener> users = smsListeners.get(typeRep);
	        users.remove(listener);

	}

	public void unSubscribe(TypeOfReports typeRep, EmailListener listener) {
		 List<EventListener> users = emailListeners.get(typeRep);
	        users.remove(listener);

	}
	public void notify( TypeOfReports typeOfReports, Report report) {
		
		 List<EventListener> usersSms = smsListeners.get(typeOfReports);
		 usersSms = smsListeners.get(typeOfReports);
		 
		 List<EventListener> usersEmail = emailListeners.get(typeOfReports);
		 usersEmail = emailListeners.get(typeOfReports);
		 
		 for(EventListener listener : usersSms) {
			 listener.update(report);
		 }
		 for(EventListener listener : usersEmail) {
			 listener.update(report);
		 }
		 
	}

}

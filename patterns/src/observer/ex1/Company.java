package observer.ex1;

public class Company {
	public EventManager events;
	
	public Company() {
		this.events = new EventManager(TypeOfReports.values());
	}
	
	public void sendReport(TypeOfReports typeOfReports,Report report) {
		events.notify(typeOfReports,report);
	}
	

}

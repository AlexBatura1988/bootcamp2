package observer;

public class Runner {

	public static void main(String[] args) {
		Company editor = new Company();
		editor.events.subscribe(TypeOfReports.SPORT, new SmsListener("12345"));
		Report sportReport = new Report("Wariors Won!!", TypeOfReports.SPORT);
		
		editor.events.subscribe(TypeOfReports.SPORT, new EmailListener("admin@example.com"));
		editor.sendReport(TypeOfReports.SPORT, sportReport);
		
		editor.events.subscribe(TypeOfReports.GENERAL, new SmsListener("123234234"));
		editor.events.subscribe(TypeOfReports.GENERAL, new EmailListener("123234234"));
		Report newsReport = new Report("Peace finally arrived to the middle east", TypeOfReports.GENERAL);
        editor.sendReport(TypeOfReports.GENERAL,newsReport);
        
        editor.events.subscribe(TypeOfReports.WEATHER, new EmailListener("admin@example.com"));
        editor.events.subscribe(TypeOfReports.WEATHER, new SmsListener("432432438"));
        Report weatherReport = new Report("Volcano errapted in Hawaii", TypeOfReports.WEATHER);
        editor.sendReport(TypeOfReports.WEATHER, weatherReport);
		

	}

}

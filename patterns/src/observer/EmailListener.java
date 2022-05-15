package observer;

public class EmailListener implements EventListener {
	
	private String email;
	
	public EmailListener(String email) {
		this.email = email;
	}

	@Override
	public void update(Report report) {
		System.out.println(report.getTypeOfReports() + " news report sent to email: "
				+ email + " " + report.getMsg());
		
		
	}

}

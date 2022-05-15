package observer;

public class SmsListener implements EventListener {
	private String sms;

	public SmsListener(String sms) {
		this.sms = sms;
	}

	@Override
	public void update(Report report) {
		System.out
				.println(report.getTypeOfReports() + " news report sent SMS to number: " + sms + " " + report.getMsg());

	}

}

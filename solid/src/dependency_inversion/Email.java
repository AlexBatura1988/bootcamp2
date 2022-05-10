package dependency_inversion;

public class Email implements WeatherDescription {
	

	@Override
	public String description() {
		String alert = "It is  sunny" ;
        return alert;
	}

}

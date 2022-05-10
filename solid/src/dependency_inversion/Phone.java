package dependency_inversion;

public class Phone implements WeatherDescription  {
	

	@Override
	public String description() {
		
		String alert = "It is  rainy" ;
        return alert;
	}

}

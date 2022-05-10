package dependency_inversion;

public class WeatherTracker {
	private WeatherDescription weathDescription;

	public WeatherTracker(WeatherDescription description) {
		
		this.weathDescription = description;
	}
	
	public String read() {
		return weathDescription.description();
	}
	
	

}

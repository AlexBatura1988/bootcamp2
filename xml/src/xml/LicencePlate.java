package xml;

public class LicencePlate {
	private final int plate;
	private String color;
	
	public LicencePlate(int plate, String color) {
		this.plate = plate;
		this.color = color;
	}

	@Override
	public String toString() {
		return "LicencePlate [plate=" + plate + ", color=" + color + "]";
	}
	
	
	
	

}

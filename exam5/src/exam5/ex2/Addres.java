package exam5.ex2;

public class Addres {

	private String street;
	private int number;
	private String state;
	private String city;

	public Addres() {
	}

	public Addres(String street, int number, String state, String city) {

		this.street = street;
		this.number = number;
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", state=" + state + ", city=" + city + "]";
	}

}

package decorator;

public class BasicDress implements Dress {
	
	private String color;
	private int size;
	
	public BasicDress(String color, int size) {
		this.color = color;
		this.size = size;
	}



	@Override
	public void create() {
		
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "BasicDress [color=" + color + ", size=" + size + "]";
	}
	

}

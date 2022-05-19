package exam5.ex2;

public class Room {
	
	private double width;
	private double length;
	private boolean hasAC;
	
	
	public Room() {
		
	}
	
	public Room(double width, double length, boolean hasAC) {
		
		this.width = width;
		this.length = length;
		this.hasAC = hasAC;
	}

	@Override
	public String toString() {
		return "Room [width=" + width + ", length=" + length + ", hasAC=" + hasAC + "]";
	}
	

}

package tshirt;

public class Color {
	private static short MIN;
	private static short MAX;
	
	static {
		MIN = 0;
		MAX = 255;
	}
	protected short red;
	protected short green;
	protected short blue;
	
	public Color(short red, short green, short blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	public Color() {
		this(MIN,MIN,MIN);
	}
	public Color(int red,int green, int blue) {
		setRed((short) red);
		setGreen((short)green);
		setBlue((short) blue);
		
	}

	public void setRed(short red) {
		if(Utils.isRange(red, MIN, MAX))
			this.red = red;
	}

	public void setGreen(short green) {
		if(Utils.isRange(green, MIN, MAX))
		this.green = green;
	}

	public void setBlue(short blue) {
		if(Utils.isRange(blue, MIN, MAX))
		this.blue = blue;
	}
	
	public short getRed() {
		return red;
	}

	public short getGreen() {
		return green;
	}

	public short getBlue() {
		return blue;
	}

	public String getDominant() {
		int max = Math.max(red, Math.max(green, blue));
		if (max == red) {
			return "Red";
		}
		return max == green ? "Green" : "Blue";
	}
	
	public float[] normalized() {
		return new float[] {(float)red/MAX, (float)green/MAX, (float)blue/MAX};
	}

	@Override
	public String toString() {
		return "Color [red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}
	

}

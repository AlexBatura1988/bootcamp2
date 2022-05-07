package tshirt;

public class Design {
	private static final double WIDTH_MIN, WIDTH_MAX, HEIGHT_MIN, HEIGHT_MAX, COMPLEX_MIN, COMPLEX_MAX;
	private static final String DEF_SLOGAN;

	static {
		WIDTH_MIN = 20;
		WIDTH_MAX = 30;
		HEIGHT_MIN = 10;
		HEIGHT_MAX = 25;
		COMPLEX_MIN = 1;
		COMPLEX_MAX = 100;
		DEF_SLOGAN = "T-Shirts";
	}
	protected double width;
	protected double height;
	protected String slogan;
	protected Color color;
	protected double complexity;

	public Design(double width, double height, String slogan, Color color, double complexity) {
		setWidth(width);
		setHeight(height);
		setSlogan(slogan);
		setColor(color);
		setComplexity(complexity);
	}

	public Design() {
		this(WIDTH_MIN, HEIGHT_MIN, DEF_SLOGAN, new Color(), COMPLEX_MIN);

	}

	public void setWidth(double width) {
		if (Utils.isRange(width, WIDTH_MIN, WIDTH_MAX))
			this.width = width;
		else {
			this.width = WIDTH_MIN;
		}
	}

	public void setHeight(double height) {
		if (Utils.isRange(height, HEIGHT_MIN, HEIGHT_MAX))
			this.height = height;
		else {
			this.height = HEIGHT_MIN;
		}
	}

	public void setSlogan(String slogan) {
		if (Utils.isLeeterDigits(slogan))
			this.slogan = slogan;
		else
			this.slogan = DEF_SLOGAN;
	}

	public void setComplexity(double complexity) {
		if (Utils.isRange(complexity, COMPLEX_MIN, COMPLEX_MAX))
			this.complexity = complexity;
		else {
			this.complexity = COMPLEX_MIN;
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getSlogan() {
		return slogan;
	}

	public Color getColor() {
		return color;
	}

	public double getComplexity() {
		return complexity;
	}

	public double calcArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", height=" + height + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}

}

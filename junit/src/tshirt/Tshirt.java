package tshirt;

public class Tshirt {
	private final static double FACTOR_MIN, FACTOR_MAX, BASE_PRICE_MIN, EXPENSIVE_PRICE;

	static {
		FACTOR_MIN = 0.1;
		FACTOR_MAX = 1;
		BASE_PRICE_MIN = 3;
		EXPENSIVE_PRICE = 10000;
	}

	protected Size size;
	protected Design design;
	protected double factor;
	protected double basePrice;
	
	

	public Tshirt(Size size, Design design, double factor, double basePrice) {
		setSize(size);
		setDesign(design);
		setFactor(factor);
		setBasePrice(basePrice);
	}
	public Tshirt() {
		this(Size.M, new Design(), FACTOR_MIN, BASE_PRICE_MIN);
	}

	public void setSize(Size size) {
		if (size == null) {
			this.size = Size.S;
		} else
			this.size = size;
	}

	public void setDesign(Design design) {
		if (design == null) {
			this.design = new Design();
		} else
			this.design = design;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public void setBasePrice(double basePrice) {
		if (Utils.isRange(basePrice, BASE_PRICE_MIN, Double.MAX_VALUE))
			this.basePrice = basePrice;
		else {
			this.basePrice = BASE_PRICE_MIN;
		}
	}

	public double calculateFinalPrice() {
		return (basePrice + design.getComplexity()) * design.calcArea() / factor;
	}

	public boolean isExpensive() {
		return calculateFinalPrice() >= EXPENSIVE_PRICE;
	}
	

	@Override
	public String toString() {
		return "Tshirt [size=" + size + ", design=" + design + ", factor=" + factor + ", basePrice=" + basePrice + "]";
	}


	enum Size {
		XS, S, M, L, XL;
	}

}

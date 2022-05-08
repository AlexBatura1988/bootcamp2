package exam3;

import java.io.Serializable;
import java.util.Locale;

public class Food implements Serializable {
	private String name;
	private Taste taste;
	private MacronutrientsCategory mCategory;

	public Food(String name, Taste taste, MacronutrientsCategory mCategory) throws NonCapatilizedException {
		setName(name);
		this.taste = taste;
		this.mCategory = mCategory;
	}

	public boolean isDesert() {
		return (taste == Taste.SWEET && mCategory == MacronutrientsCategory.CARBOHYDRATE);
	}

	public void setName(String name) throws NonCapatilizedException {
		if (name.charAt(0) != name.toUpperCase().charAt(0)) {
			throw new NonCapatilizedException();
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", mCategory=" + mCategory + "]";
	}

}

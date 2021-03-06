package tshirt;

public class Utils {
	public static boolean isRange(int value, int min, int max) {
		return value >= min && value <= max;
	}
	
	public static boolean isRange(double value, double min, double max) {
		return value >= min && value <= max;
	}
	
	public static boolean isRange(short value, short min, short max) {
		return value >= min && value <= max;
	}
	public static boolean isLeeterDigits(String str) {
		if(str == null) {
			return false;
		}
		str = str.replaceAll("\\s", "");
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!(Character.isLetter(ch) || Character.isDigit(ch))) {
				return false;
			}
		}
		return true;
		
	}

}

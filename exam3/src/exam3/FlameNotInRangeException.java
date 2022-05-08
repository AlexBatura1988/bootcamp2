package exam3;

public class FlameNotInRangeException extends Exception {

	public FlameNotInRangeException() {
		super("Flame intensity is not in range from 0 to 10");
	}

}

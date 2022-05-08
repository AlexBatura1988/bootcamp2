package exam3;

public class TooYoungException extends RuntimeException {
	
	public TooYoungException() {
        super("the birth date is after 8/8/888");
    }
	
}

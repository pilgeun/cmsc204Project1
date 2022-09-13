/**
 * Thrown if typed and re-typed passwords don't match.
 * @author PHILIP SONG
 */
public class UnmatchedException extends Exception {
	/**
	 * Constructor.
	 */
	public UnmatchedException() {
		this("Passwords do not match");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}

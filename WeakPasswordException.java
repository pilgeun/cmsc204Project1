/**
 * Thrown if a password contains 6-9 characters but is otherwise valid.
 * @author PHILIP SONG
 */
public class WeakPasswordException extends Exception {
	/**
	 * Constructor.
	 */
	public WeakPasswordException() {
		this("The password is OK but weak - it contains fewer than 10 characters");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}

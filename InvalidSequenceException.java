/**
 * Thrown if a password contains more than 2 of the same character in sequence.
 * @author PHILIP SONG
 */
public class InvalidSequenceException extends Exception {
	/**
	 * Constructor.
	 */
	public InvalidSequenceException() {
		this("The password cannot contain more than two of the same character in sequence");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}

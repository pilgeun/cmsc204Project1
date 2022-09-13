/**
 * Thrown if a password  doesn't contain a lowercase alphabetic character.
 * @author PHILIP SONG
 */
public class NoLowerAlphaException extends Exception {
	/**
	 * Constructor.
	 */
	public NoLowerAlphaException() {
		this("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}

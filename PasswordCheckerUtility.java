/**
 *
 * @author PHILIP SONG
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Project 1C-Release (Ver 2, 082822)\doc\PasswordCheckerUtility.html

public class PasswordCheckerUtility {
	
	/**
	 * Compare equality of two passwords
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!comparePasswordsWithReturn(password, passwordConfirm))
			throw new UnmatchedException();
	}
	
	/**
	 * Compare equality of two passwords
	 * @param passwordString
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.compareTo(passwordConfirm) == 0)
			return true;

		return false;
	}


	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		boolean validLength = false;
		
		if(password.length() >= 6)
			validLength = true;
		
		if(!validLength)
			throw new LengthException();
		
		return validLength;
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		boolean hasUpper = false;
		
		for (int c = 0; c < password.length(); c++) {
			if (password.charAt(c) >= 65 && password.charAt(c) <= 90) {
				hasUpper = true;
				break;
			}
		}
		
		if (!hasUpper)
			throw new NoUpperAlphaException();
		
		return hasUpper;
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		boolean hasLower = false;
		
		for (int c = 0; c < password.length(); c++) {
			if (password.charAt(c) >= 97 && password.charAt(c) <= 122)
			{
				hasLower = true;
				break;
			}
		}
		
		if(!hasLower)
			throw new NoLowerAlphaException();
		
		return hasLower;
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		boolean hasNumber = false; 
		
		for (int c = 0; c < password.length(); c++) {
			if (password.charAt(c) >= 48 && password.charAt(c) <= 57)
			{
				hasNumber = true;
				break;
			}
		}
		
		if(!hasNumber)
			throw new NoDigitException();
		
		return hasNumber;
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		boolean hasSpecial = false;
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		hasSpecial = (!matcher.matches());
		
		if(!hasSpecial)
			throw new NoSpecialCharacterException();
			
		return hasSpecial;
	}
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		boolean isSequence = false;
		
		for (int c = 0; c < password.length()-2; c++) {
			if (password.charAt(c) == password.charAt(c+1) && 
				password.charAt(c+1) == password.charAt(c+2))
			{
				isSequence = true;
				break;
			}
		}		
		
		if(isSequence)
			throw new InvalidSequenceException();
		
		return isSequence;
	}
	
	/**
	 * 
	 * @param password
	 * @return true if valid password, false if an invalid password
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, 
																NoDigitException, NoSpecialCharacterException, InvalidSequenceException { 
		
		boolean isValid = true; 
		
		try {
			if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password))
				return true;
		} catch (LengthException e) {
			throw new LengthException();
		} catch (NoUpperAlphaException e) {
			throw new NoUpperAlphaException();
		} catch (NoLowerAlphaException e) {
			throw new NoLowerAlphaException();
		} catch (NoDigitException e) {
			throw new NoDigitException();
		} catch (NoSpecialCharacterException e) {
			throw new NoSpecialCharacterException();
		} catch (InvalidSequenceException e) {
			throw new InvalidSequenceException();
		} 
		
		return isValid;
	}
	
	/**
	 * 
	 * @param passwords
	 * @return ArrayList of invalid passwords 
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for (String password : passwords) {
				try {
					if(isValidPassword(password))
						continue;
				} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
						| NoSpecialCharacterException | InvalidSequenceException e) {
					invalidPasswords.add(password +" -> "+ e.getMessage());		// e.getMessage() returns error message without name of Exception
				}
		}
		
		return invalidPasswords;
	}
	
	/**
	 * Checks if the password contains 6 to 9 characters
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		
		return false;
	}
	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		boolean isValid = false, 	// redundant code?
				isWeak = false;		
		
		try 
		{
			if (isValidPassword(password)) 
				isValid = true;
			
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {
			isValid = false;
		} 
		
		if(hasBetweenSixAndNineChars(password)) {
			isWeak = true;
			throw new WeakPasswordException();
		}
		
		return isWeak;
	}
}

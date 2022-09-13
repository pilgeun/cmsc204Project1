
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Philip Song
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String validPassword = "@Bcdefgh10",
			weakPassword = "1234@aA",
			shortPassword = "abc",
			noUpper = "@bcdefgh10",
			noLower = "@BCDEFGH10",
			noDigit = "@Bcdefghij",
			noSpecial = "Abcdefgh10",
			withSequence = "@Bbbbbb10";
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		String [] pArray = {"1234@aA", "Abcdefgh10", "@Bbbbbb10"};
		passwords.addAll(Arrays.asList(pArray));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
		validPassword = weakPassword = shortPassword = noUpper = noLower = noDigit = noSpecial = withSequence = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(shortPassword));
		} catch (LengthException e) {
			assertTrue("Threw Length Exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(noUpper));
		} catch (NoUpperAlphaException e) {
			assertTrue("Threw No Upper Alpha Exception",true);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(noLower));
		} catch (NoLowerAlphaException e) {
			assertTrue("Threw No Lower Alpha Exception",true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.isWeakPassword(weakPassword));
		} catch (WeakPasswordException e) {
			assertTrue("Did not throw Weak Password Exception",true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(withSequence));
		} catch (InvalidSequenceException e) {
			assertTrue("Threw Invalid Sequence Exception",true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(noDigit));
		} catch (NoDigitException e) {
			assertTrue("Threw No Digit Exception",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(validPassword));
		} catch (LengthException e) {
			assertTrue("Threw Length Exception",true);
		} catch (NoUpperAlphaException e) {
			assertTrue("Threw No Upper Alpha Exception",true);
		} catch (NoLowerAlphaException e) {
			assertTrue("Threw No Lower Alpha Exception",true);
		} catch (NoDigitException e) {
			assertTrue("Threw No Digit Exception",true);
		} catch (NoSpecialCharacterException e) {
			assertTrue("Threw No Special Exception",true);
		} catch (InvalidSequenceException e) {
			assertTrue("Threw Invalid Sequence Exception",true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPasswords;
		invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(invalidPasswords.size(), 2);
		assertEquals(invalidPasswords.get(0), "Abcdefgh10 -> The password must contain at least one special character");
		assertEquals(invalidPasswords.get(1), "@Bbbbbb10 -> The password cannot contain more than two of the same character in sequence");
	}
	
}

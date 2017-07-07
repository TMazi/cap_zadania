package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zadanie1.PallindromChecker;

public class PalindromTest {
	
	String correctPall, wrongPall, empty, single, bigcorrect, extraCharacters;
	
	@Before
	public void testSet() {
		correctPall = "aabbaa";
		wrongPall = "aaaab";
		empty = "";
		single = "a";
		bigcorrect = "aaaassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssaaaa";
		extraCharacters = "hhh ,,.    hhh";
	}

	@Test
	public void testPallindromCorrect() {
		
		assertTrue(PallindromChecker.isPalindrom(correctPall));
	}
	

	@Test
	public void testPallindromWrong() {
		assertFalse(PallindromChecker.isPalindrom(wrongPall));
	}

	@Test
	public void testEmptyCorrect() {
		assertTrue(PallindromChecker.isPalindrom(empty));
	}
	
	@Test
	public void testSingleCorrect() {
		assertTrue(PallindromChecker.isPalindrom(single));
	}
	
	@Test
	public void testExtraCharactersCorrect() {
		assertTrue(PallindromChecker.isPalindrom(extraCharacters));
	}
	
	@Test
	public void testBigCorrect() {
		assertTrue(PallindromChecker.isPalindrom(bigcorrect));
	}

}

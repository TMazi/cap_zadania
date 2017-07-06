package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zadanie1.PallindromChecker;

public class Tests {
	
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
	public void testPallindrom() {
		
		assertTrue(PallindromChecker.isPalindrom(correctPall));
		assertFalse(PallindromChecker.isPalindrom(wrongPall));
		assertTrue(PallindromChecker.isPalindrom(empty));
		assertTrue(PallindromChecker.isPalindrom(single));
		assertTrue(PallindromChecker.isPalindrom(bigcorrect));
		assertTrue(PallindromChecker.isPalindrom(extraCharacters));


	}

}

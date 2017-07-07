package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import zadanie2.Participian;
import zadanie2.Person;


public class ConferenceTest {
	
	Person examplePerson;
	
	@Before
	void testSet() {
		examplePerson = new Participian("Jan", "Kowalski", "1990-10-10");
		
	}

}

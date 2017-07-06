import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zadanie1.PallindromChecker;
import zadanie2.Conference;
import zadanie2.Person;

public class mainClass {
	
	

	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		/*char confirm;
		String pall = new String();
		scan = new Scanner(System.in);
		System.out.println("Witam, chcesz sprawdzic jakies palindromy? (y/n)");
		
		confirm = (char) System.in.read();
		scan.nextLine();
		
		while(confirm == 'y')
		{
			System.out.println("Podaj palindrom i potwierdz enterem");
			pall = scan.nextLine();
			if(PallindromChecker.isPalindrom(pall))
			{
				System.out.println("Palindrom!");
			}
			else
				System.out.println("Nie Palindrom!");
			
			System.out.println("Chcesz kontynuowac? (y/n)");
			confirm = (char) System.in.read();
			scan.nextLine();
		}
		System.out.println("Do zobaczenia!");*/
		
		Conference conf = new Conference();
		conf.loadPeople("C:/users/tmazurek/desktop/konferencja.csv");
		System.out.println(conf.countParticipians());
		ArrayList<Person> people = conf.giveMePeople();
		conf.sortItQuickDumbass(people, 0, people.size()-1);
		System.out.println(people.size());
		for(Person p: people)
		{
			System.out.println(p.toString());
		}
		
		
		
	}

}

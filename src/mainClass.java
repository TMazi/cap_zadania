import java.io.IOException;
import java.util.Scanner;

import zadanie1.PallindromChecker;

public class mainClass {
	
	

	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		char confirm;
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
		System.out.println("Do zobaczenia!");
		

	}

}

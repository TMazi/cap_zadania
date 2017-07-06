import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import zadanie1.PallindromChecker;
import zadanie2.Conference;
import zadanie2.Person;

public class mainClass {

	private static Scanner scan;

	public static void main(String[] args) throws IOException {
		scan = new Scanner(System.in);
		System.out.println("Uszanowanko! Co robimy?");
		System.out.println("1. Palindromki");
		System.out.println("2. Konferencja");
		String result = scan.nextLine();

		switch (result) {
		case "1":
			char confirm;
			String pall = new String();
			System.out.println("Witam, chcesz sprawdzic jakies palindromy? (y/n)");

			confirm = (char) System.in.read();
			scan.nextLine();

			while (confirm == 'y') {
				System.out.println("Podaj palindrom i potwierdz enterem");
				pall = scan.nextLine();
				if (PallindromChecker.isPalindrom(pall)) {
					System.out.println("Palindrom!");
				} else
					System.out.println("Nie Palindrom!");

				System.out.println("Chcesz kontynuowac? (y/n)");
				confirm = (char) System.in.read();
				scan.nextLine();
			}
			break;

		case "2":
			Conference conf = new Conference();
			String order;
			System.out.println(
					"No jak tam sobie chcesz.\nAby wybrac osoby o nazwiskach na dana litere, wpisz ja i potwierdz enterem");
			System.out.println("Aby podzielic ludzi na grupy o danej wielkosci, wpisz liczbe i potwierdz enterem");
			order = scan.nextLine();

			while (!conf.doSomething(order)) {
				System.out.println("Pan tego kompletnie nie rozumie! Wprowadz jeszcze raz");
				order = scan.nextLine();
			}
			break;

		}

		System.out.println("Do zobaczenia!");

	}

}

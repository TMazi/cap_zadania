package zadanie2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Conference {

	BufferedReader br;
	final String filePath = "C:/users/tmazurek/desktop/konferencja.csv";
	final String saveFilePath = "C:/users/tmazurek/desktop/uczestnicy_";
	final String saveGroupFilePath = "C:/users/tmazurek/desktop/grupy/uczestnicy_";
	private List<Person> participians;

	public Conference() {
		participians = new ArrayList<Person>();
		loadPeople(filePath);
	}
	
	public boolean doSomething(String input) {
		boolean result = false;
		if(input.matches("\\d+")) {
			groupByCount(new Integer(input));
			result = true;
		}
		else if(input.matches("[a-z]")) {
			groupByLastName(input.charAt(0));
			result = true;
		}
		return result;
			
	}

	public void groupByLastName(char letter) {
		Comparator fnm = new FirstNameComparator();
		List<Person> groupedPeople = peopleLastNameStartWith(letter);
		sortItQuickDumbass(groupedPeople, 0, groupedPeople.size() - 1, fnm);
		display(groupedPeople);
		savePeopleToCSV(groupedPeople, saveFilePath+Character.toString(letter)+".csv");
		System.out.println("Osoby o nazwisko zaczynajacym sie na " + letter + " zapisano do nowego pliku "
				+ saveFilePath + letter + ".csv");

	}

	public void groupByCount(int count) {
		if ((participians.size() % count) != 0) {
			System.out.println("To sie nie uda. Wybierz dzielnik liczby " + participians.size());
		}
		else {
			Comparator lnm = new LastNameComparator();
			List<Person> groupedPeople = participians;
			sortItQuickDumbass(groupedPeople, 0, groupedPeople.size() - 1, lnm);
			List<Person> temp = new ArrayList<>();
			for (int i = 0; i < groupedPeople.size()/count; i++) {
				for (int j = 0; j < count; j++) {
					temp.add(groupedPeople.get(i*count+j));
				}
				savePeopleToCSV(temp,  saveGroupFilePath+Integer.toString(i+1)+".csv");
				temp.clear();
			}
		}
		System.out.println("Pogrupowano osoby w " + participians.size() / count + " grup zapisanych w " + saveFilePath);
	}

	public void loadPeople(String filePath) {
		try {
			br = new BufferedReader(new FileReader(filePath));
			String nLine;
			String[] personData;
			while ((nLine = br.readLine()) != null) {
				personData = nLine.split(",");
				Person person = new Participian(personData[0], personData[1], personData[2]);
				participians.add(person);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Blad! Nie ma takiego pliku");

		} catch (IOException e) {
			System.out.println("Blad przy wczytywaniu pliku!");
		}
	}

	public boolean savePeopleToCSV(List<Person> people, String path) {
		boolean result;
		try {
			File destination = new File(path);
			FileWriter fw = new FileWriter(destination);
			BufferedWriter bf = new BufferedWriter(fw);
			for (Person p : people) {
				bf.write(p.toString());
				bf.newLine();
			}
			result = true;
			bf.close();
		} catch (IOException e) {
			System.out.println("Nie udalo sie zapisac do pliku!");
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public List<Person> peopleLastNameStartWith(char letter) {
		if (Character.isLowerCase(letter))
			letter = Character.toUpperCase(letter);
		List<Person> result = new ArrayList<Person>();
		for (Person p : participians) {
			if (p.getLastName().charAt(0) == letter) {
				result.add(p);
			}
		}
		return result;
	}

	public void sortItQuickDumbass(List<Person> nonSorted, int start, int end, Comparator comparator) {
		int left = start;
		int right = end;
		int pivot = (start + end) / 2;
		Person pivotValue = nonSorted.get(pivot);
		while (left <= right) {
			while (left < end && comparator.compare(pivotValue, nonSorted.get(left)) > 0)
				left++;
			while (right > start && comparator.compare(pivotValue, nonSorted.get(right)) < 0)
				right--;
			if (left <= right) {
				Collections.swap(nonSorted, left, right);
				left++;
				right--;
			}
		}
		if (start < right)
			sortItQuickDumbass(nonSorted, start, right, comparator);
		if (left < end)
			sortItQuickDumbass(nonSorted, left, end, comparator);
	}

	public ArrayList<Person> giveMePeople() {
		return (ArrayList<Person>) participians;
	}

	public void display(List<Person> groupedPeople) {
		for (Person p : groupedPeople) {
			System.out.println(p.toString());
		}
	}

	public int countParticipians() {
		return participians.size();
	}

}

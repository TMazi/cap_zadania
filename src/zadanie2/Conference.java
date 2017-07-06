package zadanie2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conference {
	
	BufferedReader br;
	String filePath = "konferencja.csv";
	private List<Person> participians;
	
	public Conference() {
		participians = new ArrayList<Person>();
	}
	
	
	
	public void loadPeople(String filePath) {
		try {
			br = new BufferedReader(new FileReader(filePath));
			String nLine;
			String[] personData;
			while(( nLine = br.readLine()) != null) {
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
	
	public List<Person> findPeople(char letter) {
		if(Character.isLowerCase(letter))
			letter = Character.toUpperCase(letter);
		List<Person> result = new ArrayList<Person>();
		for(Person p : participians)
		{
			if(p.getLastName().charAt(0) == letter)
				result.add(p);
		}
		return result;
	}

	public void sortItQuickDumbass(List<Person> nonSorted, int start, int end) {
		int left = start;
		int right = end;
		int pivot = (start + end)/2;
		String pivotValue = nonSorted.get(pivot).getFirstName();
		while(left <= right) {
			while (left < end && pivotValue.compareTo(nonSorted.get(left).getFirstName()) > 0)
				left++;
			while(right > start && pivotValue.compareTo(nonSorted.get(right).getFirstName()) < 0)
				right--;
			if(left <= right) {
				Collections.swap(nonSorted, left, right);
				left++;
				right--;
			}
		}
        if(start < right)
        	sortItQuickDumbass(nonSorted, start, right);
        if(left < end)
        	sortItQuickDumbass(nonSorted, left, end);
	}
	
	public ArrayList<Person> giveMePeople()
	{
		return (ArrayList<Person>) participians;
	}
	
	
	
	
	public int countParticipians() {
		return participians.size();
	}

}

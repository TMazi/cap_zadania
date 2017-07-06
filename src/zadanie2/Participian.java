package zadanie2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Participian implements Person {

	private String firstName, lastName;
	private Date birthDate;
	
	public Participian(String firstName, String lastName, String birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		try {
			this.birthDate = new SimpleDateFormat("yyyy-MM-DD").parse(birthDate);
		} catch (ParseException e) {
			System.out.println("Nieprawidlowy format daty urodzin" + birthDate);
			e.printStackTrace();
		}
	}
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public Date getBirthDate() {
		return birthDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		return firstName + " " + lastName + " " + sdf.format(birthDate);
	}

}

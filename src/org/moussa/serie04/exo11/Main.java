package org.moussa.serie04.exo11;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comparator<String> compareString = (str1, str2) -> str1.length()-str2.length();
		
		Comparator<Person> compareperson = (person1, person2) -> {
			String firstName1 = person1.getFirstName();
			String firstName2 = person2.getFirstName();
			return firstName1.compareTo(firstName2);
		};
		
	}

}

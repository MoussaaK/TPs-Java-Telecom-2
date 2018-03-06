package org.moussa.serie04.exo11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Comparateur de chaine de caractère en fonction de leur longeur
		Comparator<String> compareString = (str1, str2) -> str1.length() - str2.length();
		System.out.println("Comparing string 'Moussa' et 'Mou', diff = " + compareString.compare("Moussa", "Mou"));

		Function<String,String> notNull = (String s) -> s == null ? "" : s;


		//Lambda pour recupérer le nom en tenant compte du fait que Person peut etre null ou pas
		Function<Person, String> getFirstName = p-> notNull.apply(p.getFirstName());
		Function<Person, String> getLastName = p-> notNull.apply(p.getLastName());
		Comparator<Person> comparatorFirstName = Comparator.comparing(getFirstName);
		Comparator<Person> comparatorFirstNameBis = (Person p1, Person p2) -> p1.getFirstName().compareTo(p2.getFirstName());

		Comparator<Person> comparatorLastName = Comparator.comparing(getLastName);
		Comparator<Person> comparatorPerson = comparatorLastName.thenComparing(comparatorFirstName);
		Comparator<Person> reverseComparatorPerson = comparatorPerson.reversed();

		//		//Comparateur de Person
		//		Comparator<Person> comparePerson = (person1, person2) -> {
		//			String firstName1 = null, lastName1 = null, firstName2 = null, lastName2 = null;
		//			if(person1 != null) {
		//				firstName1 = getFirstName.apply(person1); 
		//				lastName1 = getLastName.apply(person1);
		//			}
		//			if(person2 != null) {
		//				firstName2 = getFirstName.apply(person2);
		//				lastName2 = getLastName.apply(person2);
		//			}
		//			
		//			if(person1 == null && person2 != null)
		//				return 1;
		//			else if(person1 != null && person2 == null)
		//				return -1;
		//			else if(person1 == null && person2 == null)
		//				return 0;
		//			else if(lastName1.equals(lastName2))
		//				return compareString.compare(firstName1, firstName2);
		//			else
		//				return compareString.compare(lastName1, lastName2);
		//		};
		//
		//		Comparator<Person> comparePersonReverse = (person1, person2) -> {
		//			String firstName1 = getFirstName.apply(person1), 
		//					lastName1 = getLastName.apply(person1);
		//			String firstName2 = getFirstName.apply(person2),
		//					lastName2 = getLastName.apply(person2);
		//			if(firstName1.equals(firstName2))
		//				return compareString.compare(lastName1, lastName2);
		//			else
		//				return compareString.compare(firstName1, firstName2);
		//		};


		Person person1 = new Person("Moussa", "Konate");
		Person person2 = new Person("King", "KJ");
		System.out.println("Comparing (between lastNames) person1 et person2, diff = " + comparatorPerson.compare(person1, person2));
		System.out.println("Reverse Comparison (between firstNames) between person1 et person2, diff = " + reverseComparatorPerson.compare(person1, person2));

		List<Person> persons = new ArrayList<Person>();
		persons.add(null);
		persons.add(person1);
		persons.add(null);
		persons.add(person2);
		persons.add(null);

		System.out.println(persons);
		/*Comparator<Person> sortedList = (persons) -> {

		}*/

		Collections.sort(persons, Comparator.nullsLast(comparatorPerson));
		System.out.println("After being sorted :\n" + persons);
	}

}

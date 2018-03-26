package org.moussa.serie08.exo17;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Sundar", "Pichai", 45));
		people.add(new Person("Jeff", "Bezos", 54));
		people.add(new Person("Andi", "Rubin", 55));
		people.add(new Person("Andi", "Rubin", 55));
		people.add(null);
		
		PersonWriter  pw = new PersonWriter();
		pw.writeBinaryObject(people, "files/BinaryPerson2");
		
		PersonReader  pr= new PersonReader();
		List<Person> peopleRead = pr.readBinaryObject("files/BinaryPerson2");
		
		for (Person person : peopleRead) {
			System.out.println(person);
		}
		
	}

}

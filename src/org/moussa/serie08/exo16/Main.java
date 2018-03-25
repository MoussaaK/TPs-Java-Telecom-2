package org.moussa.serie08.exo16;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonWriter pw = new PersonWriter();
		PersonReader pr = new PersonReader();
		String fileName = "files/BinaryPerson";
		List<Person> people = new ArrayList<>();
		//people.add(new Person("######", "######"));
		people.add(new Person("Sundar", "Pichai", 45));
		people.add(new Person("Jeff", "Bezos", 54));
		people.add(new Person("Andi", "Rubin", 55));
		
		pw.writeBinaryFields(people, fileName, people.size());
		List<Person> peopleRead = pr.readBinaryFields(fileName);
		System.out.println("After reading the file... ");
		System.out.println("Those People were found inside :");
		peopleRead.forEach(p -> System.out.println(p));
	}
}

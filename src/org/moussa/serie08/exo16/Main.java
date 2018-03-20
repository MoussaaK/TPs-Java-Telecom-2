package org.moussa.serie08.exo16;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonWriter pw = new PersonWriter();
		List<Person> people = new ArrayList<>();
		people.add(new Person("######", "######"));
		people.add(new Person("Sundar", "Punchai", 45));
		people.add(new Person("Jeff", "Bezos", 54));
		people.add(new Person("Andi", "Rubin", 55));
		
		pw.writeBinaryFields(people, "files/BinaryPerson", people.size());
	}
}

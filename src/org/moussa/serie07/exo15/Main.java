package org.moussa.serie07.exo15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PersonReader pr = new PersonReader();
		PersonWriter pw = new PersonWriter();
		
		List<Person> listOfPerson = null;
		try {
			listOfPerson = pr.read("Person.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfPerson.forEach(s -> System.out.println(s));
		
		List<Person> newListOfPerson = new ArrayList<>();
		newListOfPerson.add(new Person("######", "######"));
		newListOfPerson.add(new Person("Sundar", "Punchai", 45));
		newListOfPerson.add(new Person("Jeff", "Bezos", 54));
		newListOfPerson.add(new Person("Andi", "Rubin", 55));
		
		//added the already read listOfPerson to the File 
		pw.write(newListOfPerson, "Person.txt");
		
		//
		try {
			listOfPerson = pr.read("Person.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfPerson.forEach(s -> System.out.println(s));
	}

}

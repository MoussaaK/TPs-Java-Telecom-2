package org.moussa.serie07.exo15;

import java.io.IOException;
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
		
		//added the already read listOfPerson to the File 
		pw.write(listOfPerson, "Person.txt");
	}

}

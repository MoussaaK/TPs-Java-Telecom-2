package org.moussa.serie08.exo16;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	
	List<Person> readBinaryFields(String fileName) {
		File file = new File(fileName);
		List<Person> people = new ArrayList<Person>();
		
		try (FileInputStream fis = new FileInputStream(file);
			 DataInputStream dis = new DataInputStream(fis);) {
			
			int numberOfPerson = dis.readInt();
			//System.out.println(numberOfPerson + " Persons to read");
			
			for(int count = numberOfPerson; count > 0; count--) {
				int age = dis.readInt();
				String lastName = dis.readUTF();
				String firstName = dis.readUTF();

				people.add(new Person(firstName, lastName, age));
				//numberOfPerson--;
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return people;
	}
}

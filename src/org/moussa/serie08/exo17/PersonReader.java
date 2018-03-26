package org.moussa.serie08.exo17;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	public List<Person> readBinaryObject(String fileName) {
		File file = new File(fileName);
		Person person = new Person();
		List<Person> people = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			// number of persons in the file
			try {
				while(ois != null) {
					person = (Person) ois.readObject();
					people.add(person);
				}
			} catch (EOFException  e) {
				// TODO Auto-generated catch block
			   // here we do nothing, not really good but allows to know the end of file
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return people;
	}
}

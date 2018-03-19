package org.moussa.serie07.exo15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	
	Function<Person, String> personToLine =
			(person) -> "\n" + person.getFirstName() + ","
													 + person.getLastName() + ","
													 + person.getAge();
		
	public void write(List<Person> people, String fileName) throws IOException {
		
		File file = new File(fileName);
		try (FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);) {
			for (Person person : people) {
				br.write(personToLine.apply(person));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

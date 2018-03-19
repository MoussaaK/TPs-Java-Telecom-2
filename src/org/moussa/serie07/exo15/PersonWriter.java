package org.moussa.serie07.exo15;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	
	Function<Person, String> personToLine =
			(person) -> person.getFirstName() + ","
											  + person.getLastName() + ","
											  + person.getAge() + ",";
		
	public void write(List<Person> people, String fileName) throws IOException {
		
	}
}

package org.moussa.serie07.exo15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonReader {
	
	Predicate<String> isComment = string -> string.startsWith("#");
	
	Function<String, Stream<Person>> lineToStreamPerson = 
			string -> isComment.test(string) ? Stream.empty() 
											 : Stream.of(new Person(string.split(", ")[0],
																	string.split(", ")[1],
																	Integer.parseInt(string.split(", ")[2])));
	Function<String, Person> lineToPerson = 
			string -> new Person(string.split(", ")[0],
								 string.split(", ")[1],
								 Integer.parseInt(string.split(", ")[2]));

	public List<Person> read(String fileName) throws IOException {

		File file = new File(fileName);
		List<Person> listOfPerson = new ArrayList<>();
		List<Person> listOfPersonBis = new ArrayList<>();
		//If the file is not null processing
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {

				listOfPerson = br.lines().filter(s -> !isComment.test(s))
										 .map(lineToPerson)
										 .collect(Collectors.toList());
				
				//To test the flatmap approach
				/*listOfPersonBis = br.lines()
									.flatMap(lineToStreamPerson)
									.collect(Collectors.toList());*/

		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return listOfPerson;
	}
}

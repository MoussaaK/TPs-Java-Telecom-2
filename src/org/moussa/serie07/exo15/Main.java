package org.moussa.serie07.exo15;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 //Function which convert a line of file into instance of Person
		//Exceptions will be handled when calling this function
		Function<String, Person> lineToPerson = 
				(string) -> new Person(string.split(", ")[0],
									   string.split(", ")[1],
								       Integer.parseInt(string.split(", ")[2]));
		
		Person p = lineToPerson.apply("Moussa, Konate, 15");
		System.out.println(p);
	}

}

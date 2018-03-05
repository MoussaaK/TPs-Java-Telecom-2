package org.moussa.serie04.exo9;
import java.util.function.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test predicat qui verifie si une china est vide 
		Predicate<String> isEmpty = (String s) -> s.isEmpty();
		System.out.println("Is Moussa Empty : " + isEmpty.test("Mousse"));
		
		Predicate<String> isGretterThan4 = (String s) -> (s.length() > 4);
		System.out.println("Moussa length is gretter than 4 :" + isGretterThan4.test("Mousse"));
		
		Predicate<String> startWithJ = (String s) -> (s.charAt(0) == 'J');
		System.out.println("Moussa start with J ? : " + startWithJ.test("Mousse"));
		System.out.println("Java start with J ? : " + startWithJ.test("Java"));
	
		Predicate<String> isLength5 = (String s) -> (s.length() == 5);
		System.out.println("Is Java length 5 ? : " + isLength5.test("Java"));
		System.out.println("Is Java8 length 5 ? : " + isLength5.test("Java8"));
		
		//Et entre predicats
		Predicate<String> isLength5AndStartWithJ = isLength5.and(startWithJ); //!= null ? true : false ;
		System.out.println("Is Java8 length 5 and start with J ? : " + isLength5AndStartWithJ.test("Java8"));
		
	}

}

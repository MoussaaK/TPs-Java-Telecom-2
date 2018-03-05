package org.moussa.serie04.exo10;
import java.util.function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Convert to upperCase
		Function<String, String> myUpperCase = (String s) -> s.toUpperCase();
		System.out.println("'Moussa' in upper Case is : " + myUpperCase.apply("Moussa"));
		
		//Prend une chaine et la retourne sans modification
		Function<String, String> identity = (String s) -> s != null ? s : "";
		System.out.println("Copying 'Moussa' ... --> " + identity.apply("Moussa"));
		System.out.println("Copying null string ('') ... --> " + identity.apply(null));
		
		Function<String, Integer> StringLength = (String s) -> s != null ? s.length() : 0;
		System.out.println("Moussa length == " + StringLength.apply("Moussa"));
		System.out.println("Null string ('') length == " + StringLength.apply(null));
		
		Function<String, String> copyInParenthesis = (String s) -> s != null ? "(" + s + ")" : "()";
		System.out.println("Copying 'Moussa' between parenthesis ... --> " + copyInParenthesis.apply("Moussa"));
		System.out.println("Copying null string ('') ... --> " + copyInParenthesis.apply(null));
		
		BiFunction<String, String, Integer> biFunction = (String s1, String s2) -> s1.indexOf(s2);
		System.out.println("Indexof 'sa' in 'Moussa' : " + biFunction.apply("Moussa", "sa"));
		
		Function<String, Integer> indexOfS = (String s) -> biFunction.apply("abcdefghi", s);
		System.out.println("Indexof 'Moussa' in 'abcdefghi' : " + indexOfS.apply("Moussa"));
		System.out.println("Indexof 'def' in 'abcdefghi' : " + indexOfS.apply("def"));
	
	}

}

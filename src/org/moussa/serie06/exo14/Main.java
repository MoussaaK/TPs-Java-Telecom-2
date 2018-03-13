package org.moussa.serie06.exo14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Germinal germinal = new Germinal();
		System.out.println("Length of the Novel : " + germinal.linesOfGerminal("7germ10.txt")
															  .size());
		
		//germinal.linesOfGerminal("7germ10.txt").forEach(System.out::println(s));
		
		//Counting of non-empty lines
		long countEmptyLines = germinal.linesOfGerminal("7germ10.txt")
							 		   .stream().filter(s -> !s.isEmpty())
							 		   .count();
		System.out.println(countEmptyLines + " non-empty lines are in the file");
		
		//Function<String, Stream<String>> spliter = s -> Pattern.compile(" ").splitAsStream(s);
		BiFunction<Stream<String>, String, Long> OccurenceInStream = 
				((stream, word) -> stream.map(String::toLowerCase)
										 .filter(s-> !s.isEmpty())
										 .filter(s -> s.contains("bonjour"))
										 .count());
		
		BiFunction<String, String, Integer> OccurenceInStreamBis = 
				(string,word)->string.concat(",")
									 .replaceAll(" ", "")
									 .toLowerCase()
									 .split(word).length-1;
		
		long countBonjour = OccurenceInStreamBis.apply(germinal.linesOfGerminal("7germ10.txt").toString(), "bonjour");
		System.out.println(countBonjour + " Bonjour(s) is in the file doing by first BiFunction");
		
		Integer countBonjourBis = 
				germinal.linesOfGerminal("7germ10.txt").stream()
						.map(s->OccurenceInStreamBis.apply(s, "bonjour"))
						.reduce(0, (int1,int2)->int1+int2)
						.intValue();
		System.out.println(countBonjourBis + " Bonjour(s) is in the file doing by second BiFunction");
		
		//Convert String to Stream of String
		Function<String, Stream<Character>> streamOfChar = (s -> s.chars()
																  .mapToObj(c -> (char)c));
		//Transform germinal's Stream of String to Stream of Character
		Stream<Character> germinalStreamOfChar = streamOfChar.apply(germinal.linesOfGerminal("7germ10.txt")
																			.toString());
		
		//Second Function to convert Stream of string to Stream of Char 
		Function<String, Stream<Character>> streamOfCharBis = 
				(s) -> Arrays.stream(s.split(""))
							 .filter(i->!i.isEmpty())
							 .map(i->i.charAt(0));
				
		//Transform germinal's Stream of String to Stream of Character
		Stream<Character> germinalStreamOfChar2 = 
				germinal.linesOfGerminal("7germ10.txt").stream()
													   .map(s->streamOfChar.apply(s))
													   .flatMap(Function.identity());
		//List of germinal char
		Stream<Character> sortedGerminalStreamOfChar = germinalStreamOfChar.distinct()
																		   .sorted();
		System.out.println(" List of all char of germinal as ");
		sortedGerminalStreamOfChar.forEach(s->System.out.println(s));
		//String onlyLetters = sortedGerminalStreamOfChar.map(s-> s + "");
		BiFunction<String, String, Stream<String>> splitWordWithPattern = 
				(line, pattern) -> Pattern.compile("[" + pattern + "]").splitAsStream(line);
				
		
	}
	
}

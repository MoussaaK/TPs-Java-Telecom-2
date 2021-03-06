package org.moussa.serie06.exo14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Germinal germinal = new Germinal();
		//List<String> linesOfGerminal = germinal.readLinesFrom("files/mini-germinal.txt");
		List<String> linesOfGerminal = germinal.linesOfGerminal("files/7germ10.txt");
		
		System.out.println("Length of the Novel : " +  linesOfGerminal.size());
		
		//Counting non-empty lines
		long countEmptyLines =  linesOfGerminal
							 		   .stream()
							 		   .filter(s -> !s.isEmpty())
							 		   .count();
		System.out.println(countEmptyLines + " non-empty lines are in the file");
		
		//BiFunction to get the occurrences of a word in string
		BiFunction<String, String, Integer> OccurencesInStream = 
			 (string, word) -> string.concat(",")
									 .replaceAll(" ", "")
									 .toLowerCase()
									 .split(word).length-1;
				
		//Two Manners of counting 'Bonjour'
		long countBonjour = OccurencesInStream.apply(linesOfGerminal.toString(), "bonjour");
		Integer countBonjourBis = 
				linesOfGerminal.stream()
							   .map(s -> OccurencesInStream.apply(s, "bonjour"))
							   .reduce(0, (int1, int2) -> int1 + int2)
							   .intValue();
		
		System.out.println(countBonjour + " Bonjour(s) is(are) in the file");
		System.out.println(countBonjourBis + " Bonjour(s) is(are) in the file ( call to countBonjourBis)");
		
		//Convert String to Stream of String
		Function<String, Stream<Character>> streamOfChar = s -> s.chars()
																 .mapToObj(c -> (char)c);
		//Second Function to convert Stream of string to Stream of Char 
		Function<String, Stream<Character>> streamOfCharBis = 
				s -> Arrays.stream(s.split(""))
						   .filter(i->!i.isEmpty())
						   .map(i->i.charAt(0));

		//Transform germinal's Stream of String to Stream of Character
		Stream<Character> germinalStreamOfChar = streamOfChar.apply(linesOfGerminal
																	.toString());
		Stream<Character> germinalStreamOfChar2 = 
				linesOfGerminal.stream()
							   .map(s->streamOfChar.apply(s))
							   .flatMap(Function.identity());
		
		//List of Germinal characters sorted
		Stream<Character> sortedGerminalStreamOfChar = germinalStreamOfChar.distinct()
																		   .sorted();
		System.out.println(" List of all char of germinal as Stream of character");
		/*List<Character> germinalListOfChar = 
				         germinalStreamOfChar.distinct()
				   						     .sorted().collect(Collectors.toList());*/
		sortedGerminalStreamOfChar.forEach(s->System.out.println(s));
		
		//Using Map-Filter-Reduce approach to get char that are not letters
		String notLetters = germinalStreamOfChar2.distinct()
												 .filter(s -> String.valueOf(s)
														 			.matches("[^a-zA-Z\\-]"))
												 .map(s -> s + "")
												 .reduce("", (s1, s2) -> (s1 + s2));
		notLetters += "\\\\-";
		System.out.println("String wich are not letters : " + notLetters);
		
		//Given Pattern
		BiFunction<String, String, Stream<String>> splitWordWithPattern = 
				(line, pattern) -> Pattern.compile("[" + pattern + "]").splitAsStream(line);
		
		//Number of words inside the novel
		/*splitWordWithPattern
			.apply(linesOfGerminal.toString(), notLetters).distinct().forEach(System.out::println);*/
		//Number of word
		System.out.println("Number of words : " + splitWordWithPattern
												  .apply(linesOfGerminal.toString(), notLetters)
												  .filter(i->!i.isEmpty())
												  .count());
		
		//Number of distinct words
		System.out.println("Number of distinct words : " + splitWordWithPattern
				  .apply(linesOfGerminal.toString(), notLetters)
				  .distinct()
				  .filter(i->!i.isEmpty())
				  .count());
		
		//Length of longest words
		int longestWord = splitWordWithPattern
								  .apply(linesOfGerminal.toString(), notLetters)
								  .distinct()
								  .filter(i->!i.isEmpty())
								  .mapToInt(s->s.length())
								  .max().getAsInt();
		System.out.println("Length of longest words : " + longestWord);
		
		//Count word of length 'longestWord'
		Long CountLongestWord = splitWordWithPattern
								  .apply(linesOfGerminal.toString(), notLetters)
								  .distinct()
								  .filter(i->!i.isEmpty())
								  .filter(s -> (s.length() == longestWord))
								  .count();
		System.out.println("Counting words of length " + longestWord + " : " + CountLongestWord);
		System.out.println("Those words are : ");
		splitWordWithPattern
			  .apply(linesOfGerminal.toString(), notLetters)
			  .distinct()
			  .filter(i->!i.isEmpty())
			  .filter(s -> (s.length() == longestWord))
			  .forEach(s -> System.out.println("\t" + s));
		
		//Histogram of words which length are greater than 2
		Map<Integer, List<String>> histogramOnWords =  new HashMap<>();
		histogramOnWords =
				splitWordWithPattern
					  	.apply(linesOfGerminal.toString(), notLetters)
					  	.distinct()
					  	.filter(s -> (!s.isEmpty()) && (s.length() >= 2))
						.collect(Collectors.groupingBy(word -> word.length()));
		//System.out.println("\n==== Histogram on words which length are greater than 1 =======");
		//histogramOnWords.forEach((key, value) -> System.out.println(key + " | " + value));
		
		//Histogram on words lengths
		Map<Integer, Long> histogramOnWordsLength =  new HashMap<>();
		histogramOnWordsLength = 
				splitWordWithPattern
				  	.apply(linesOfGerminal.toString(), notLetters)
				  	.distinct()
				  	.filter(s -> (!s.isEmpty()) && (s.length() >= 2))
					.collect(Collectors.groupingBy(word -> word.length(), Collectors.counting()));
		//forEach for printing
		System.out.println("\n== Histogram on words Lengths ==");
		System.out.println("\n Length |   Occurences  |");
		System.out.println("-------------------------");
		histogramOnWordsLength.forEach((key, value) -> System.out.println(key + "\t|\t" + value + "\t|"));
		System.out.println("-------------------------");
		
		//For computing the median value of an odd list
		Function<Map<Integer, Long>, Long> medianOfOddList = map -> {
			Long medianKey = null;
			int position = map.size()/2 + 1, count = 0;
			Set<Integer> keys = map.keySet();
			for (Integer key : keys) {
				count++;
				if(position == count)
					medianKey = key.longValue();
			}
			return medianKey;
		};
		
		Long median = medianOfOddList.apply(histogramOnWordsLength);
		System.out.println("\nThe median is " + median
											+ " : and  " 
											+ histogramOnWordsLength.get(median.intValue()) 
											+ " words have this same length.");
	}
}

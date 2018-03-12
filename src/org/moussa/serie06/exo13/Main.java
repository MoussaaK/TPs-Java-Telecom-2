package org.moussa.serie06.exo13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import com.sun.activation.registries.MailcapTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<>();
		strings.add("one");
		strings.add("two");
		strings.add("three");
		strings.add("four");
		strings.add("five");
		strings.add("six");
		strings.add("seven");
		strings.add("eigth");
		strings.add("nine");
		strings.add("ten");
		strings.add("eleven");
		strings.add("twelve");
		
		Function<String, Integer> getLength = s -> s == null ? 0 : s.length();
		Comparator<String> compareLength = Comparator.comparing(getLength);
		
		//Longest String length
		int max = strings.stream()
						 .max(compareLength).get().length();
		System.out.println("\nLongest string in stream : " + max);
		
		System.out.println("\nString in stream wich length are Even : ");
		strings.stream()
			   .filter(s -> (s.length() % 2) == 0)
			   .forEach(s -> System.out.println(s));
		
		System.out.println("\nString in stream wich length are odd : ");
		Function<String, String> toUpper = s -> s.toUpperCase();
		List<String> oddString = strings.stream()
										.filter(s -> (s.length() % 2) != 0)
										.map(toUpper)
										.collect(Collectors.toList());
		oddString.forEach(s -> System.out.println(s));
		
		System.out.println("\nString in stream wich length are 5 : ");
		String stringConcat = strings.stream()
			   .filter(s -> s.length() < 5)
			   .sorted()
			   .collect(Collectors.joining(",","{","}"));
		System.out.println(stringConcat);
		
		//
		Map<Integer, List<String>> firstMap =  new HashMap<>();
		firstMap = strings.stream()
				.collect(Collectors.groupingBy(s -> s.length()));
		//forEach for printing
		System.out.println("\n================== First Map ===================");
		firstMap.forEach((key, value) -> System.out.println(key + " | " + value));

		Map<String, List<String>> secondMap =  new HashMap<>();
		secondMap = strings.stream()
						   .collect(Collectors.groupingBy(s -> String.valueOf(s.charAt(0))));
		//forEach for printing
		System.out.println("\n================== Second Map ===================");
		secondMap.forEach((key, value) -> System.out.println(key + " | " + value));

	}

}

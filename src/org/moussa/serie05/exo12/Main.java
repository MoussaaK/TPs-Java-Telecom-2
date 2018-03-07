package org.moussa.serie05.exo12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<String>();

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

		//Printing using forEach method feeded with a consumer
		System.out.println("Strings : ");
		strings.forEach(s -> System.out.println(s));

		List<String> stringsLength3 = new ArrayList<String>();
		Predicate<String> isLength3 = s -> s.length() == 3;

		for (String string : strings) {
			if(isLength3.test(string))
				stringsLength3.add(string);
		}

		System.out.println("Strings of length 3 : ");
		stringsLength3.forEach(s -> System.out.println(s));


		Function<String, Integer> getLength = s -> s == null ? 0 : s.length();
		Comparator<String> compareLength = Comparator.comparing(getLength);

		strings.sort(compareLength);

		System.out.println("strings after being sorted : ");
		strings.forEach(s -> System.out.println(s));

		//First Map 
		Map<Integer, List<String>> firsMap =  new HashMap<>();
		for (String word : strings) {
			firsMap.computeIfAbsent(getLength.apply(word), 
									key -> new ArrayList<String>()
									).add(word);
		}

		//forEach for printing
		System.out.println("================== First Map ===================");
		firsMap.forEach((key, value) -> System.out.println(key + " | " + value));

		//lambda wich return the first letter as a string instead of a char
		Function<String, String> getFirstLetter = s -> s == null ? "" : String.valueOf(s.charAt(0));
		//Second Map
		Map<String, List<String>> secondMap =  new HashMap<String, List<String>>();

		for (String word : strings) {
			secondMap.computeIfAbsent(getFirstLetter.apply(word), 
									  key -> new ArrayList<>()
									  ).add(word);
		}

		//forEach for printing
		System.out.println("================== Second Map =================== ");
		secondMap.forEach((key, value) -> System.out.println(key + " | " + value));

		//Third Map
		Map<String, Map<Integer, List<String>>> mapWichValuesAreMap =  new HashMap<>();

		for (String word : strings) {
			mapWichValuesAreMap.computeIfAbsent(getFirstLetter.apply(word),
												key -> new HashMap<>()
												).computeIfAbsent(getLength.apply(word),
																  key -> new ArrayList<String>()
																  ).add(word);
		}

		//forEach pour l'affichage
		System.out.println(" ============= Third Map, values are also a Map ============");
		mapWichValuesAreMap.forEach((key, value) -> System.out.println(key + " | " + value));

		//Last Map
		Map<Integer, String> mapMergeValues =  new HashMap<>();

		for (String word : strings) {
			mapMergeValues.merge(getLength.apply(word),  //key
								 word, 					//
								 (existingValue, addedValue) -> existingValue + "," + addedValue);
		}

		//forEach pour l'affichage
		System.out.println("================= Last Map ===================");
		mapMergeValues.forEach((key, value) -> System.out.println(key + " | " + value));
	}

}

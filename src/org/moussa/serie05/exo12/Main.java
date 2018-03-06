package org.moussa.serie05.exo12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.moussa.serie03.exo8.Marin;
import org.moussa.serie04.exo11.Person;

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
		
		//Affichage à l'aide de forEach qui prend un consumer
		System.out.println("Strings : ");
		strings.forEach(s -> System.out.println(s));
		
		List<String> stringsLength3 = new ArrayList<String>();
		for (String string : strings) {
			if(string.length() == 3)
				stringsLength3.add(string);
		}
		System.out.println("Strings of length 3 : ");
		stringsLength3.forEach(s -> System.out.println(s));
		
		Function<String, Integer> getLength = s -> s == null ? 0 : s.length();
		Comparator<String> compareLength = Comparator.comparing(getLength);
		
		//Collections.sort(stringsLength3, Comparator.nullsLast(compareLength));
		strings.sort(compareLength);
		
		System.out.println("strings sorted : ");
		strings.forEach(s -> System.out.println(s));
		
		//Table de hachage 1
		Map<Integer, List<String>> map =  new HashMap<Integer, List<String>>();
		for (String word : strings) {
			map.computeIfAbsent(getLength.apply(word), key -> new ArrayList<String>()).add(word);
		}
		//forEach pour l'affichage
		System.out.println("First Map : ");
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		//lambda qui retourne la premiere Lettre sous forme de chaine
		Function<String, String> getFirstLetter = s -> s == null ? "" : String.valueOf(s.charAt(0));
		
		//Table de hachage 2
		Map<String, List<String>> map2 =  new HashMap<String, List<String>>();
		for (String word : strings) {
			map2.computeIfAbsent(getFirstLetter.apply(word), key -> new ArrayList<>()).add(word);
		}
		//forEach pour l'affichage
		System.out.println("Second Map : ");
		map2.forEach((key, value) -> System.out.println(key + " " + value));
		
		
		Map<String, Map<Integer, List<String>>> map3 =  new HashMap<>();
		for (String word : strings) {
			map3.computeIfAbsent(getFirstLetter.apply(word), key -> new HashMap<>()).computeIfAbsent(getLength.apply(word), value -> new ArrayList<String>()).add(word);
		}
		//forEach pour l'affichage
		System.out.println("Third Map, values are also a Map : ");
		map3.forEach((key, value) -> System.out.println(key + " " + value));
		
		/*Map<Integer, List<String>> mergedValue =  new HashMap<Integer, List<String>>();
		for (String word : strings) {
			mergedValue.merge(getLength.apply(word), word, (existingValue, addedValue) -> existingValue + "," + addedValue);
		}
		//forEach pour l'affichage
		System.out.println("Last Map : ");
		mergedValue.forEach((key, value) -> System.out.println(key + " " + value));*/
		
	}

}

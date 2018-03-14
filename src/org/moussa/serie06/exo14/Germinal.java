package org.moussa.serie06.exo14;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Germinal {
	
	
	
	public List<String> readLinesFrom(String fileName) {
		Path path = Paths.get(fileName);
		try (Stream<String> lines = Files.lines(path)) {
			return lines.collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<String> linesOfGerminal(String fileName) {
		List<String> lines = readLinesFrom(fileName);
		lines = lines.stream()
				.limit(lines.size() - 322)
				.skip(70)
			 	.collect(Collectors.toList());
		
		return lines;
	}
}

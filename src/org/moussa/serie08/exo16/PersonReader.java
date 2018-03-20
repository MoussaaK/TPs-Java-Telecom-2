package org.moussa.serie08.exo16;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
	
	List<Person> readBinaryFields(String fileName) {
		File file = new File(fileName);
		List<Person> people = new ArrayList<Person>();
		
		try (FileInputStream fis = new FileInputStream(file);
			 DataInputStream dis = new DataInputStream(fis);) {
			
			int number = dis.read();
			//byte[] buffer = new byte[1024];
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
}

package org.moussa.serie08.exo17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersonWriter {

	public void writeBinaryObject(List<Person> people, String fileName) {
		File file = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			for (Person person : people) {
				try {
					oos.writeObject(person);
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package org.moussa.serie08.exo16;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	
	Function<Person, byte[]> personToBytes = person -> {
		byte[] byteArray = null;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 DataOutputStream dos = new DataOutputStream(baos);) {
			
			dos.writeInt(person.getAge());
			dos.writeUTF(person.getLastName());
			dos.writeUTF(person.getFirstName());
			byteArray = baos.toByteArray();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return byteArray;
	};
	
	public void writeBinaryFields(List<Person> people, String fileName, int number) {
		File file = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(file, true);
			 BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			bos.write(number);
			/*for (Person person : people) {
				byte [] bytes = personToBytes.apply(person);
				bos.write(bytes);
				//bos.flush(); handled by try-with-resources pattern
			}*/
			people.stream().map(personToBytes)
						   .forEach(person -> {
							   try {
								   bos.write(person);
							   } catch (IOException e) {
								   // TODO Auto-generated catch block
								   e.printStackTrace();
							   }});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

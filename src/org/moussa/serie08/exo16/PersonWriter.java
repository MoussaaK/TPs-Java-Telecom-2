package org.moussa.serie08.exo16;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class PersonWriter {
	Function<Person, byte[]> personToBytes = person -> {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeUTF(person.getLastName());
			dos.writeUTF(person.getFirstName());
			dos.writeInt(person.getAge());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return baos.toByteArray();
	};


	public void writeBinaryFields(List<Person> people, String fileName) {
		File file = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(fos);) {
			dos.writeInt(people.size());
			/*for (Person person : people) {
				byte [] bytes = personToBytes.apply(person);
				bos.write(bytes);
				//bos.flush(); handled by try-with-resources pattern
			}*/
			people.stream().map(personToBytes)
			.forEach(arrayPerson -> {
				try {
					dos.writeInt(arrayPerson.length);
					dos.write(arrayPerson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	public static void main(String[] args) {
		Function<Person, byte[]> personToBytes = person -> {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			try {
				dos.writeInt(person.getAge());
				dos.writeUTF(person.getLastName());
				dos.writeUTF(person.getFirstName());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return baos.toByteArray();
		};

		Person p = new Person("nom","prenom",12);
		System.out.println(personToBytes.apply(p));
	}
	 */

}

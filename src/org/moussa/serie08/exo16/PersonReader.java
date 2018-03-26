package org.moussa.serie08.exo16;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PersonReader {
	Function<byte[], Person> byteToPerson = byteArray -> {
		ByteArrayInputStream baos = new ByteArrayInputStream(byteArray);
		DataInputStream dis = new DataInputStream(baos);
		try {
			String firstName = dis.readUTF();
			String lastName = dis.readUTF();
			int age = dis.readInt();
			return(new Person(firstName,lastName,age));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	};

	List<Person> readBinaryFields(String fileName) {
		File file = new File(fileName);
		List<Person> people = new ArrayList<Person>();
		
		try (FileInputStream fis = new FileInputStream(file);
			 DataInputStream dis = new DataInputStream(fis);) {
			
			int numberOfPerson = dis.readInt();
			System.out.println(numberOfPerson + " Persons to read");
			
			for(int count = numberOfPerson; count > 0; count--) {
				int nbByte = dis.readInt();
				byte[] tmpArray = new byte[nbByte];
				//System.out.println(nbByte);
				int read = readArray(dis, nbByte, tmpArray);
				//System.out.println(read);
				people.add(byteToPerson.apply(tmpArray));

			}
		} catch (EOFException e) {
			
		}
		
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return people;
	}

	private int readArray(DataInputStream dis, int nbByte, byte[] tmpArray) throws IOException {
		return dis.read(tmpArray, 0, nbByte);
	}
}

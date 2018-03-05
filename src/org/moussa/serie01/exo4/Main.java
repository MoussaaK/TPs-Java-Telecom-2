package org.moussa.serie01.exo4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindrome pl = new Palindrome();
		String string = "Moussa KONATE";
		boolean b = pl.palindrome(string);
		if(b)
			System.out.println("'" + string + "'" + " " + "est un palindrome");
		else
			System.out.println("'" + string + "'" + " " + "n'est un palindrome");
		
		string = "Esope reste ici et se repose";
		b = pl.palindrome(string);
		if(b)
			System.out.println("'" + string + "'" + " " + "est un palindrome");
		else
			System.out.println("'" + string + "'" + " " + "n'est un palindrome");
		
		string = "Elu par cette crapule";
		b = pl.palindrome(string);
		if(b)
			System.out.println("'" + string + "'" + " " + "est un palindrome");
		else
			System.out.println("'" + string + "'" + " " + "n'est un palindrome");
		
		string = "Et la marine va venir a Malte";
		b = pl.palindrome(string);
		if(b)
			System.out.println("'" + string + "'" + " " + "est un palindrome");
		else
			System.out.println("'" + string + "'" + " " + "n'est un palindrome");
		
	}

}

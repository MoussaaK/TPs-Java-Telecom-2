package org.moussa.serie01.exo4;

public class Palindrome {
	public boolean palindrome(String palindrome) {
		String stringTmp = "";
		String palindromeTmp = "";
		int length = palindrome.length();
		for(int i=length-1; i>=0; i--) {
			if(palindrome.charAt(i) != ' ') 
				stringTmp += palindrome.charAt(i);
			else 
				stringTmp += "";
				
			if(palindrome.charAt((length-1) - i) != ' ')
				palindromeTmp += palindrome.charAt((length-1) - i); // On recupère le mot sans les espaces
			else
				palindromeTmp += "";
		}
		
		/*System.out.println("palindrome = " + palindrome);
		System.out.println("L'envers = " + stringTmp);
		System.out.println("palindrome tmp = " + palindromeTmp);*/
		
		//on met tout en majuscule pour comparer sans tenir compte de la casse
		if(stringTmp.toUpperCase().equals(palindromeTmp.toUpperCase())) 
			return true;
		else
			return false;
	}
}

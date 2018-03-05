package org.moussa.serie01.exo2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorielle fact = new Factorielle(); 
		
		System.out.println("intFactorielle de 10 = " + fact.intFactorielle(10));
		System.out.println("intFactorielle de 13 = " + fact.intFactorielle(13));
		System.out.println("intFactorielle de 25 = " + fact.intFactorielle(25));
		
		System.out.println("\ndoubleFactorielle de 10 = " + fact.doubleFactorielle(10));
		System.out.println("doubleFactorielle de 13 = " + fact.doubleFactorielle(13));
		System.out.println("doubleFactorielle de 25 = " + fact.doubleFactorielle(25));
		
		System.out.println("\nbigIntFactorielle de 10 = " + fact.bigIntFactorielle(10));
		System.out.println("bigIntFactorielle de 13 = " + fact.bigIntFactorielle(13));
		System.out.println("bigIntFactorielle de 25 = " + fact.bigIntFactorielle(25));
		
		System.out.println("\nEn conclusion on remarque un depassement de la taille de \nint quand on calcule la factorielle d'une varible superieure a 10  avec intFactorielle et doublefactorielle");
		
	}

}

package org.moussa.serie01.exo3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bissextile estBissextile = new Bissextile();
		System.out.println("1901 est il bissextile ? " + estBissextile.bissextile(1901));
		System.out.println("1996 est il bissextile ? " + estBissextile.bissextile(1996));
		System.out.println("1900 est il bissextile ? " + estBissextile.bissextile(1900));
		System.out.println("2000 est il bissextile ? " + estBissextile.bissextile(2000));
		
	}

}

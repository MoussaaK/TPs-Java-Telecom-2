package org.moussa.serie03.exo8;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Marin m1 = new Marin("Titouan", "lamazou", 1955);
	Marin m2 = new Marin("Alain", "Gautier", 1962);
	Marin m3 = new Marin("Christophe", "Augin", 1959);
	Marin m4 = new Marin("Armel", "Le Cléac'h", 1977);
	Marin m5 = new Marin("Michel", "Desjoyeaux", 1965);
	Marin m6 = new Marin("Vincent", "Riou", 1972);
	Marin m7 = new Marin("François", "Gabart", 1983);
	
	RegistreMarin registre = new RegistreMarin();
	
	//Test de la méthode addMap
	registre.addMap(m1);
	registre.addMap(m2);
	registre.addMap(m3);
	registre.addMap(m4);
	registre.addMap(m5);
	registre.addMap(m6);
	registre.addMap(m7);
	
	//Test de la sucharge de toString
	System.out.println(registre);
	
	//Test de method get
	System.out.println("\nListe des Marins nés en 1950 :\n" + registre.get(1950));
	
	//Test de la method count nombre Marin d'une decennie
	System.out.println("\nNombre de Marins nés en 1950 :\n" + registre.count(1950));
	
	}
}

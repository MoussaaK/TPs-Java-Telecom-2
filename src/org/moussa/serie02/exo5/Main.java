package org.moussa.serie02.exo5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marin m1 = new Marin("KONATE", "Moussa", 40000);
		Marin m2 = new Marin("NADELA", "Satia", 40000);
		
		Marin m3 = new Marin("BEZOS", "Jeff", 81840);
		
		//Tests de la surcharge de la methode .toString
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		//tests de la surcharge de equals
		boolean b = m1.equals(m2);
		System.out.println("\nm1 = m2 ? " + b);
		
		b = m1.equals(m3);
		System.out.println("m1 = m3 ? " + b);
		
		b = m2.equals(m3);
		System.out.println("m2 = m3 ? " + b);
		
		//Affichage des codes de hachage
		System.out.println("\nHashCode de m1 = " + m1.hashCode());
		System.out.println("HashCode de m2 = " + m2.hashCode());
		System.out.println("HashCode de m3 = " + m3.hashCode());
		
		//Test de la comparaison de deux Marins
		if(m1.getNom().compareTo(m2.getNom()) == 0) {
			if(m1.getPrenom().compareTo(m2.getPrenom()) == 0)
				System.out.println("\nm1 est egale à m2");
			else if(m1.getPrenom().compareTo(m2.getPrenom()) > 0)
				System.out.println("\nm1 est plus grand que m2");
			else
				System.out.println("\nm1 est inférieure à m2");
			
		} else if(m1.getNom().compareTo(m2.getNom()) > 0)
			System.out.println("\nm1 est plus grand que m2");
		else
			System.out.println("\nm1 est inférieure à m2");
		
		
	}

}

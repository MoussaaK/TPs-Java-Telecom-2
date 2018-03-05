package org.moussa.serie02.exo6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marin[] marins = new Marin[] {
				new Marin("KONATE", "Moussa", 2000),
				new Marin("Paumard", "Jose", 2000),
				new Marin("Bezos", "Jeff", 4000),
				new Marin("Nadella", "Satia", 3000),
				new Marin("Sundar", "Pachai", 3500)
		};
		MarinUtil marinUtil = new MarinUtil();
		for (Marin marin : marins) {
			System.out.println("Salaire " + marin.getNom() + " : " + marin.getSalaire());
		}

		marinUtil.augmenteSalaire(marins, 1000);
		for (Marin marin : marins) {
			System.out.println("Salaire Augmenté de " + marin.getNom() + " : " + marin.getSalaire());
		}

		System.out.println("\nSalaire Max = " + marinUtil.getMaxSalaire(marins));
		System.out.println("Salaire Moyen = " + marinUtil.getMoyenneSalaire(marins));
		System.out.println("Salaire Median = " + marinUtil.getMedianneSalaire(marins));
	}
}

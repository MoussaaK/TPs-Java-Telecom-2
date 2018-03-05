package org.moussa.serie03.exo7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marin[] marins = new Marin[] {
				new Marin("KONATE", "Moussa", 3000),
				new Marin("Paumard", "Jose", 4500),
				new Marin("Bezos", "Jeff", 25000),
				new Marin("Nadella", "Satia", 20000),
				new Marin("Sundar", "Pachai", 22000)
		};
		Equipage equipage = new Equipage(5);

		//Création de l'équipage
		int count = 0;
		for (Marin marin : marins) {
			if(equipage.addMarin(marin))
				System.out.println(++count + " " + "Marin ajouté à equipage 1");
		}

		System.out.println("\nTaille de l'équipage : " + equipage.getNombreMarins());

		//Verifie si Moussa est un marin
		if(equipage.isMarinPresent(new Marin("KONATE", "Moussa", 3000)))
			System.out.println("\nMoussa est un Marin");

		//Test de la méthode addMarin()
		if(!equipage.addMarin(new Marin("Linus", "Torval", 24000)))
			System.out.println("\nOups On est au complet ! Attendez qu'un Marin Flemmard rentre à la maison puis vous allez prendre sa place.");

		//Supprime Sundar Pichai de l'équipage
		if(equipage.removeMarin(new Marin("Sundar", "Pachai", 22000)))
			System.out.println("Marin Sundar Pichai sort de l'equipage et rentre à la maison");

		System.out.println("\nTaille de l'équipage après départ de Sundar: " + equipage.getNombreMarins());


		//Test de la méthode addMarin()
		if(equipage.addMarin(new Marin("Linus", "Torval", 24000)))
			System.out.println("Voilà Linus t'as été ajouté après le départ de Sundar");


		//Appel pour voir la surcharge de la méthode .toString
		System.out.println("\nTest surcharge de la method toString de Equipage : \n" + equipage.toString());

		/*Tests en tenant compte du nombre Max*/

		//Test de la méthode addAllMarin
		Equipage equipage2 = new Equipage(4);
		Equipage equipage3 = new Equipage(2);

		equipage3.addMarin(marins[4]); //doit etre ajouté car nouveau
		equipage3.addMarin(marins[0]); //ne doit pas etre ajouté car taille dépassée

		System.out.println("\nMarins de l'équipage 3");
		//for (Marin marin : equipage3.marins) {
			System.out.println(equipage3);
		//}

		//ajoute tous les éléments de l'équipage1 à l'équipage 2
		equipage2.addAllEquipage(equipage3);
		equipage2.addAllEquipage(equipage3); //teste si le non doublon marche

		equipage2.addAllEquipage(equipage);

		System.out.println("\nMarins de l'équipage 2");
		//for (Marin marin : equipage2.marins) {
			System.out.println(equipage2);
		//}


	}

}

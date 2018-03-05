package org.moussa.serie03.exo7;

import java.util.*;
/**
 * Classe Equipage permettant de g�rer une collection de Marins
 */
public class Equipage {

	/*Variable pour le nombre Max ne doit pas etre static sinon ttes les instances auront 
	 *acc�s et la variable contiendra la valeur pass�e en param�tre de la derni�re instance*/
	private int nombreMax;
	
	//Cr�ation de la collection
	private Collection<Marin> marins;

	public Equipage(int nombreMax) {
		this.nombreMax = nombreMax;
		this.marins = new ArrayList<Marin>();;
	}

	
	//Ajoute un marin � la collection marins
	public boolean addMarin(Marin marin) {
		if(marins.size() < nombreMax)
			return marins.add(marin);
		else
			return false;
	}

	//Supprime un marin � la collection marins
	public boolean removeMarin(Marin marin) {
		return marins.remove(marin);
	}

	//Verifie si un marinest pr�sent dans la collection marins
	public boolean isMarinPresent(Marin marin) {
		return marins.contains(marin);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		//L'interface ArrayList contient une m�thode toString
		return "Equipage [marins=" + marins + "]";
	}

	//Ajoute un �quipage � l'�quipage courant
	public void addAllEquipage(Equipage equipage) {
		for (Marin membre : equipage.marins) {
			if(marins.size() < nombreMax)		//verifie si on respecte le nombreMax
				if(!this.isMarinPresent(membre))
					this.marins.add(membre);
		}
	}

	//Supprime tous les Marins de l'equipage
	public void clear() {
		for (Marin marin : marins) {
			marins.remove(marin);
		}
	}

	//Nombre de Marins
	public int getNombreMarins() {
		return this.marins.size();
	}

	//Moyenne Salaire
	double getMoyenneSalaire() {
		double sum = 0;
		for (Marin marin : marins) {
			sum += marin.getSalaire();
		}
		return sum/this.marins.size();
	}

}

package org.moussa.serie02.exo6;

import java.util.Arrays;

public class MarinUtil {

	public void augmenteSalaire(Marin[] marins, int pourcentage) {
		for(Marin marin : marins) {
			marin.augmenteSalaire(pourcentage);
		}
	}

	public double getMaxSalaire(Marin[] marins) {
		double maxSalaire = 0;
		for (Marin marin : marins) {
			if(marin.getSalaire() > maxSalaire)
				maxSalaire = marin.getSalaire();
		}
		return maxSalaire;
	}

	public double getMoyenneSalaire(Marin[] marins) {
		double meanSalaire = 0;
		for (Marin marin : marins) {
			meanSalaire += marin.getSalaire();
		}
		return meanSalaire/marins.length;
	}

	public double getMedianneSalaire(Marin[] marins) {
		Arrays.sort(marins);
		int length = marins.length;

		//taille impaire
		if(length%2 == 1)  {
			return marins[(length/2 + 1)].getSalaire();
		}
		//taille paire
		return (marins[(length/2)].getSalaire() + marins[(length/2 + 1)].getSalaire())/2;
	}

}

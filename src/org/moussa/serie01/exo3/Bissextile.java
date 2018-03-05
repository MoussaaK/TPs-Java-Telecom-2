package org.moussa.serie01.exo3;

public class Bissextile {
	public boolean bissextile(int annee) {
		if(annee%4 == 0 && annee%100 != 0 || annee%400 == 0)
			return true;
		return false;
	}
}

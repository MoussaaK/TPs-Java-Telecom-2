package org.moussa.serie03.exo8;

public class Marin implements Comparable<Marin> {
	private String nom;
	private String prenom;
	private double salaire;
	private int annee;
	/**
	 * @param nom
	 * @param prenom
	 * @param salaire
	 */
	public Marin(String nom, String prenom, int annee) {
		super();	//appel constructeur de la superclass
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		//this.salaire = salaire;
	}

	/**
	 * @param nom
	 * @param salaire
	 */
	public Marin(String nom, int annee) {
		this(nom, "", annee);	 //Appel au premier constructeur
		this.prenom = "";
		this.nom = nom;
		//this.salaire = salaire;
	}

	/**
	 * Setters and Getters
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDecennie(int annee) {
		return (annee/10)*10;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String overrided = "";	  //super.toString();
		overrided += "\nNom : " + this.nom;
		overrided += "\nPrenom : " + this.prenom;
		overrided += "\nSalaire : " + this.salaire;

		return overrided;
	}

	/*
	 * Method augmente Salaire
	 */
	public void augmenteSalaire(int augmentation) {
		this.salaire += (double)augmentation;
	}

	@Override
	public int compareTo(Marin o) {
		// TODO Auto-generated method stub
		if(this.nom.equals(o.nom))
			return this.prenom.compareTo(o.prenom);
		else if(this.prenom.equals(o.prenom))
			return this.nom.compareTo(o.nom);
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salaire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marin other = (Marin) obj;
		if (annee != other.annee)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (Double.doubleToLongBits(salaire) != Double.doubleToLongBits(other.salaire))
			return false;
		return true;
	}
}

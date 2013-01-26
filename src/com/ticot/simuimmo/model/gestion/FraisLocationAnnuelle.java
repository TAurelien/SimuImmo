package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe FraisLocationAnnuelle
/**
 * @author Aurelien Ticot
 *
 */
public class FraisLocationAnnuelle {

	//Déclaration des variables
	//==============================================================================
	private double fraisGestionLocation = 0, chargesLocation;
	private boolean gestionParAgence = true;
	
	//Variables pour la prise en compte des valeurs réelles
	private double fraisGestionLocationReel, chargesLocationReel;
	//TODO Supprimer si les variables des valeurs réelles sont inutiles

	
	//Constructeurs
	//==============================================================================
	//Constructeur vide	
	/**
	 * 
	 */
	public FraisLocationAnnuelle() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisGestionLocation
	 * @param chargesLocation
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(double fraisGestionLocation,
			double chargesLocation, boolean gestionParAgence) {
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.chargesLocation = chargesLocation;
		this.gestionParAgence = gestionParAgence;
	}

	
	//TODO Modifier la javadoc des getters et setters de la classe FraisLocationAnnuelle
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the chargesLocation
	 */
	public double getChargesLocation() {
		return chargesLocation;
	}

	/**
	 * @return the chargesLocationReel
	 */
	public double getChargesLocationReel() {
		return chargesLocationReel;
	}

	/**
	 * @return the fraisGestionLocation
	 */
	public double getFraisGestionLocation() {
		return fraisGestionLocation;
	}

	/**
	 * @return the fraisGestionLocationReel
	 */
	public double getFraisGestionLocationReel() {
		return fraisGestionLocationReel;
	}

	/**
	 * @return the gestionParAgence
	 */
	public boolean isGestionParAgence() {
		return gestionParAgence;
	}
	

	//Setters
	//==============================================================================
		
	/**
	 * @param chargesLocation the chargesLocation to set
	 */
	public void setChargesLocation(double chargesLocation) {
		this.chargesLocation = chargesLocation;
	}

	/**
	 * @param chargesLocationReel the chargesLocationReel to set
	 */
	public void setChargesLocationReel(double chargesLocationReel) {
		this.chargesLocationReel = chargesLocationReel;
	}

	/**
	 * @param fraisGestionLocation the fraisGestionLocation to set
	 */
	public void setFraisGestionLocation(double fraisGestionLocation) {
		this.fraisGestionLocation = fraisGestionLocation;
	}

	/**
	 * @param fraisGestionLocationReel the fraisGestionLocationReel to set
	 */
	public void setFraisGestionLocationReel(double fraisGestionLocationReel) {
		this.fraisGestionLocationReel = fraisGestionLocationReel;
	}

	/**
	 * @param gestionParAgence the gestionParAgence to set
	 */
	public void setGestionParAgence(boolean gestionParAgence) {
		this.gestionParAgence = gestionParAgence;
	}

	//==============================================================================
	
	//TODO Faire le toString() de la classe FraisLocationAnnuelle
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Frais Annuels ------------------------------------------" +
				"\nLes frais de gestion sont de " + fraisGestionLocation +
				"\nLes charges de location sont de " + chargesLocation /*+
				"\nL'assurance habitation est de " + gestionParAgence	+ 
				"\nLes frais de travaux annuels sont de " + fraisGestionLocationReel +
				"\nLa taxe d'habitation est de "	+ chargesLocationReel */;	
	}

	//TODO Faire le equal() de la classe FraisLocationAnnuelle
}

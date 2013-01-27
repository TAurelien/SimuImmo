package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe FraisLocationAnnuelle
/**
 * @author Aurelien Ticot
 *
 */
public class FraisLocationAnnuelle {

	//Déclaration des variables
	//==============================================================================
	private double fraisGestionLocation = 0, fraisLocation;
	private boolean gestionParAgence = true;
	
	//Variables pour la prise en compte des valeurs réelles
	private double fraisGestionLocationReel, fraisLocationReel;
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

	//TODO Modifier les commentaires
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(boolean gestionParAgence) {
		super();
		this.gestionParAgence = gestionParAgence;
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisGestionLocation
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(double fraisGestionLocation, boolean gestionParAgence) {
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.gestionParAgence = gestionParAgence;
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisGestionLocation
	 * @param chargesLocation
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(double fraisGestionLocation,
			double fraisLocation, boolean gestionParAgence) {
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.fraisLocation = fraisLocation;
		this.gestionParAgence = gestionParAgence;
	}

	
	//TODO Modifier la javadoc des getters et setters de la classe FraisLocationAnnuelle
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the chargesLocation
	 */
	public double getFraisLocation() {
		return fraisLocation;
	}

	/**
	 * @return the chargesLocationReel
	 */
	public double getFraisLocationReel() {
		return fraisLocationReel;
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
	public void setFraisLocation(double fraisLocation) {
		this.fraisLocation = fraisLocation;
	}

	/**
	 * @param chargesLocationReel the chargesLocationReel to set
	 */
	public void setFraisLocationReel(double fraisLocationReel) {
		this.fraisLocationReel = fraisLocationReel;
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
		return "Frais Location annuels ----------------------------" +
				"\nLes frais de gestion sont de " + fraisGestionLocation +
				"\nLes charges de location sont de " + fraisLocation /*+
				"\nL'assurance habitation est de " + gestionParAgence	+ 
				"\nLes frais de travaux annuels sont de " + fraisGestionLocationReel +
				"\nLa taxe d'habitation est de "	+ chargesLocationReel */;	
	}

	//TODO Faire le equal() de la classe FraisLocationAnnuelle
}

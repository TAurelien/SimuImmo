package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe FraisLocationSaisonniere
/**
 * @author Aurelien Ticot
 * 
 */
public class FraisLocationSaisonniere {

	// Déclaration des variables
	// ==============================================================================
	private double fraisAccueil = 0, fraisMenage = 0,
			fraisGestionSaisonnier = 0, chargesLocationSaisonniere = 0;

	// Variables pour la prise en compte des valeurs réelles
	private double fraisAccueilReel, fraisMenageReel,
			fraisGestionSaisonnierReel, chargesLocationSaisonniereReel;

	// TODO Supprimer si les variables des valeurs réelles sont inutiles

	// Constructeurs
	// ==============================================================================
	// Constructeur vide
	/**
		 * 
		 */
	public FraisLocationSaisonniere() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisAccueil
	 * @param fraisMenage
	 * @param fraisGestionSaisonnier
	 * @param chargesLocationSaisonniere
	 */
	public FraisLocationSaisonniere(double fraisAccueil, double fraisMenage,
			double fraisGestionSaisonnier, double chargesLocationSaisonniere) {
		super();
		this.fraisAccueil = fraisAccueil;
		this.fraisMenage = fraisMenage;
		this.fraisGestionSaisonnier = fraisGestionSaisonnier;
		this.chargesLocationSaisonniere = chargesLocationSaisonniere;
	}

	// TODO Modifier la javadoc des getters et setters de la classe
	// XXX FraisLocationSaisonniere

	// Getters
	// ==============================================================================

	/**
	 * @return the chargesLocationSaisonniere
	 */
	public double getChargesLocationSaisonniere() {
		return chargesLocationSaisonniere;
	}

	/**
	 * @return the chargesLocationSaisonniereReel
	 */
	public double getChargesLocationSaisonniereReel() {
		return chargesLocationSaisonniereReel;
	}

	/**
	 * @return the fraisAccueil
	 */
	public double getFraisAccueil() {
		return fraisAccueil;
	}

	/**
	 * @return the fraisAccueilReel
	 */
	public double getFraisAccueilReel() {
		return fraisAccueilReel;
	}

	/**
	 * @return the fraisGestionSaisonnier
	 */
	public double getFraisGestionSaisonnier() {
		return fraisGestionSaisonnier;
	}

	/**
	 * @return the fraisGestionSaisonnierReel
	 */
	public double getFraisGestionSaisonnierReel() {
		return fraisGestionSaisonnierReel;
	}

	/**
	 * @return the fraisMenage
	 */
	public double getFraisMenage() {
		return fraisMenage;
	}

	/**
	 * @return the fraisMenageReel
	 */
	public double getFraisMenageReel() {
		return fraisMenageReel;
	}

	// Setters
	// ==============================================================================

	/**
	 * @param chargesLocationSaisonniere
	 *            the chargesLocationSaisonniere to set
	 */
	public void setChargesLocationSaisonniere(double chargesLocationSaisonniere) {
		this.chargesLocationSaisonniere = chargesLocationSaisonniere;
	}

	/**
	 * @param chargesLocationSaisonniereReel
	 *            the chargesLocationSaisonniereReel to set
	 */
	public void setChargesLocationSaisonniereReel(
			double chargesLocationSaisonniereReel) {
		this.chargesLocationSaisonniereReel = chargesLocationSaisonniereReel;
	}

	/**
	 * @param fraisAccueil
	 *            the fraisAccueil to set
	 */
	public void setFraisAccueil(double fraisAccueil) {
		this.fraisAccueil = fraisAccueil;
	}

	/**
	 * @param fraisAccueilReel
	 *            the fraisAccueilReel to set
	 */
	public void setFraisAccueilReel(double fraisAccueilReel) {
		this.fraisAccueilReel = fraisAccueilReel;
	}

	/**
	 * @param fraisGestionSaisonnier
	 *            the fraisGestionSaisonnier to set
	 */
	public void setFraisGestionSaisonnier(double fraisGestionSaisonnier) {
		this.fraisGestionSaisonnier = fraisGestionSaisonnier;
	}

	/**
	 * @param fraisGestionSaisonnierReel
	 *            the fraisGestionSaisonnierReel to set
	 */
	public void setFraisGestionSaisonnierReel(double fraisGestionSaisonnierReel) {
		this.fraisGestionSaisonnierReel = fraisGestionSaisonnierReel;
	}

	/**
	 * @param fraisMenage
	 *            the fraisMenage to set
	 */
	public void setFraisMenage(double fraisMenage) {
		this.fraisMenage = fraisMenage;
	}

	/**
	 * @param fraisMenageReel
	 *            the fraisMenageReel to set
	 */
	public void setFraisMenageReel(double fraisMenageReel) {
		this.fraisMenageReel = fraisMenageReel;
	}

	// ==============================================================================

	// TODO Faire le toString() de la classe FraisLocationSaisonniere
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Frais location saisonnière ------------------------------------------"
				+ "\nLes frais d'accueil sont de " + fraisAccueil
				+ "\nLes charges de ménage sont de " + fraisMenage
				+ "\nLes frais de gestion sont de " + fraisGestionSaisonnier
				+ "\nLe total des frais de location saisonnière sont de "
				+ chargesLocationSaisonniere;
	}

	// TODO Faire le equal() de la classe FraisLocationSaisonniere
}
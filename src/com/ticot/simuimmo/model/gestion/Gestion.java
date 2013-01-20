package com.ticot.simuimmo.model.gestion;

/**
 * @author Aurelien Ticot
 *
 */
public class Gestion {
	
	//TODO Structurer la classe Gestion
	
	// TODO Define the ENUM for the "Type de gestion"
	private FraisAnnuels fraisAnnuels;
	private FraisLocationAnnuelle fraisLocationAnnuelle;
	private FraisLocationSaisonniere fraisLocationSaisonniere;
	private RecetteLocative recetteLocative;
	
	// TODO Faire le constructeur de la classe Gestion
	
	/**
	 * @return Retourne les frais annuels
	 */
	public FraisAnnuels getFraisAnnuels() {
		return fraisAnnuels;
	}
	/**
	 * @return Retourne les frais de location annuelle
	 */
	public FraisLocationAnnuelle getFraisLocationAnnuelle() {
		return fraisLocationAnnuelle;
	}
	/**
	 * @return Retourne les frais de location saisonniere
	 */
	public FraisLocationSaisonniere getFraisLocationSaisonniere() {
		return fraisLocationSaisonniere;
	}
	/**
	 * @return Retourne la recette locative
	 */
	public RecetteLocative getRecetteLocative() {
		return recetteLocative;
	}
	/**
	 * @param Definit les frais annuels
	 */
	public void setFraisAnnuels(FraisAnnuels fraisAnnuels) {
		this.fraisAnnuels = fraisAnnuels;
	}
	/**
	 * @param Definit les frais de location annuelle
	 */
	public void setFraisLocationAnnuelle(FraisLocationAnnuelle fraisLocationAnnuelle) {
		this.fraisLocationAnnuelle = fraisLocationAnnuelle;
	}
	/**
	 * @param Definit les frais de location saisonniere
	 */
	public void setFraisLocationSaisonniere(
			FraisLocationSaisonniere fraisLocationSaisonniere) {
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}
	/**
	 * @param Definit la recette locative
	 */
	public void setRecetteLocative(RecetteLocative recetteLocative) {
		this.recetteLocative = recetteLocative;
	}
	
}


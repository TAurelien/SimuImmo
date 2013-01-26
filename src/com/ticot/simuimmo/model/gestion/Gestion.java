package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe Gestion
/**
 * @author Aurelien Ticot
 *
 */
public class Gestion {
	
	//TODO Structurer la classe Gestion
	
	//Déclaration des variables
	//==============================================================================
	//La classe Gesetion se compose des 4 classes FraisAnnuels, FraisLocationAnnuelle
	//FraisLocationSaisonnière et Recette Locative
	
	// TODO Define the ENUM for the "Type de gestion"
	private String typeGestion = "";
	private FraisAnnuels fraisAnnuels;
	private FraisLocationAnnuelle fraisLocationAnnuelle;
	private FraisLocationSaisonniere fraisLocationSaisonniere;
	private RecetteLocative recetteLocative;
	
	// TODO Faire le constructeur de la classe Gestion
	
	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	/**
	 * 
	 */
	public Gestion() {
		super();
	}
	
	//Constructeur avec toutes les variables
	/**
	 * @param fraisAnnuels
	 * @param fraisLocationAnnuelle
	 * @param fraisLocationSaisonniere
	 * @param recetteLocative
	 */
	public Gestion(String typeGestion, FraisAnnuels fraisAnnuels,
			FraisLocationAnnuelle fraisLocationAnnuelle,
			FraisLocationSaisonniere fraisLocationSaisonniere,
			RecetteLocative recetteLocative) {
		super();
		this.typeGestion = typeGestion;
		this.fraisAnnuels = fraisAnnuels;
		this.fraisLocationAnnuelle = fraisLocationAnnuelle;
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
		this.recetteLocative = recetteLocative;
	}	
	
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the typeGestion
	 */
	public String getTypeGestion() {
		return typeGestion;
	}
	
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
	
	
	//Setters
	//==============================================================================
	
	/**
	 * @param typeGestion the typeGestion to set
	 */
	public void setTypeGestion(String typeGestion) {
		this.typeGestion = typeGestion;
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


	//==============================================================================
}


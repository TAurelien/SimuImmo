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
	//La classe Gestion se compose des 4 classes ChargesAnnuelles, FraisLocationAnnuelle
	//FraisLocationSaisonnière et Recette Locative
	
	// TODO Define the ENUM for the "Type de gestion"
	private String typeGestion = "";
	private ChargesAnnuelles chargesAnnuelles;
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
	public Gestion(String typeGestion, ChargesAnnuelles chargesAnnuelles,
			FraisLocationAnnuelle fraisLocationAnnuelle,
			FraisLocationSaisonniere fraisLocationSaisonniere,
			RecetteLocative recetteLocative) {
		super();
		this.typeGestion = typeGestion;
		this.chargesAnnuelles = chargesAnnuelles;
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
	public ChargesAnnuelles getChargesAnnuelles() {
		return chargesAnnuelles;
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
	public void setChargesAnnuelles(ChargesAnnuelles chargesAnnuelles) {
		this.chargesAnnuelles = chargesAnnuelles;
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

	// ==============================================================================

	// TODO Faire le toString() de la classe Gestion
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gestion ---------------------------" +
				"\nLe type de gestion est " + typeGestion + 
				"\n" + chargesAnnuelles +
				"\n" + fraisLocationAnnuelle +
				"\n" + fraisLocationSaisonniere +
				"\n" + recetteLocative;
	}

	// TODO Faire le equal() de la classe FraisLocationSaisonniere	
}


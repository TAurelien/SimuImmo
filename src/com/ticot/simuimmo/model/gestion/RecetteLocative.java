package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe RecetteLocative
/**
 * @author Aurelien Ticot
 *
 */
public class RecetteLocative {

	// Déclaration des variables
	// ==============================================================================
	private double loyerNu = 0, loyerMeuble = 0,
			loyerNuit = 0, loyerSaisonnier = 0, recetteLocative = 0;
	private int vacLocAnnuelle = 0, vacLocSaisonnier = 0;
	
	
	// Constructeurs
	// ==============================================================================
	// Constructeur vide
	/**
	 * 
	 */
	public RecetteLocative() {
		super();
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param loyerNu
	 * @param loyerMeuble
	 * @param loyerNuit
	 * @param loyerSaisonnier
	 * @param recetteLocative
	 * @param vacLocAnnuelle
	 * @param vacLocSaisonnier
	 */
	public RecetteLocative(double loyerNu, double loyerMeuble,
			double loyerNuit, double loyerSaisonnier, double recetteLocative,
			int vacLocAnnuelle, int vacLocSaisonnier) {
		super();
		this.loyerNu = loyerNu;
		this.loyerMeuble = loyerMeuble;
		this.loyerNuit = loyerNuit;
		this.loyerSaisonnier = loyerSaisonnier;
		this.recetteLocative = recetteLocative;
		this.vacLocAnnuelle = vacLocAnnuelle;
		this.vacLocSaisonnier = vacLocSaisonnier;
	}

	// TODO Modifier la javadoc des getters et setters de la classe

	// Getters
	// ==============================================================================

	/**
	 * @return the loyerMeuble
	 */
	public double getLoyerMeuble() {
		return loyerMeuble;
	}
	
	/**
	 * @return the loyerNu
	 */
	public double getLoyerNu() {
		return loyerNu;
	}
	
	/**
	 * @return the loyerNuit
	 */
	public double getLoyerNuit() {
		return loyerNuit;
	}
	
	/**
	 * @return the loyerSaisonnier
	 */
	public double getLoyerSaisonnier() {
		return loyerSaisonnier;
	}
	
	/**
	 * @return the recetteLocative
	 */
	public double getRecetteLocative() {
		return recetteLocative;
	}
	
	/**
	 * @return the vacLocAnnuelle
	 */
	public int getVacLocAnnuelle() {
		return vacLocAnnuelle;
	}
	
	/**
	 * @return the vacLocSaisonnier
	 */
	public int getVacLocSaisonnier() {
		return vacLocSaisonnier;
	}

	
	// Setters
	// ==============================================================================

	/**
	 * @param loyerMeuble the loyerMeuble to set
	 */
	public void setLoyerMeuble(double loyerMeuble) {
		this.loyerMeuble = loyerMeuble;
	}
	
	/**
	 * @param loyerNu the loyerNu to set
	 */
	public void setLoyerNu(double loyerNu) {
		this.loyerNu = loyerNu;
	}
	
	/**
	 * @param loyerNuit the loyerNuit to set
	 */
	public void setLoyerNuit(double loyerNuit) {
		this.loyerNuit = loyerNuit;
	}
	
	/**
	 * @param loyerSaisonnier the loyerSaisonnier to set
	 */
	public void setLoyerSaisonnier(double loyerSaisonnier) {
		this.loyerSaisonnier = loyerSaisonnier;
	}
	
	/**
	 * @param recetteLocative the recetteLocative to set
	 */
	public void setRecetteLocative(double recetteLocative) {
		this.recetteLocative = recetteLocative;
	}
	
	/**
	 * @param vacLocAnnuelle the vacLocAnnuelle to set
	 */
	public void setVacLocAnnuelle(int vacLocAnnuelle) {
		this.vacLocAnnuelle = vacLocAnnuelle;
	}
	
	/**
	 * @param vacLocSaisonnier the vacLocSaisonnier to set
	 */
	public void setVacLocSaisonnier(int vacLocSaisonnier) {
		this.vacLocSaisonnier = vacLocSaisonnier;
	}

	// ==============================================================================

	// TODO Faire le toString() de la classe RecetteLocative
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recette locative ------------------------------------------"
		+ "\nLe loyer en location nue est de " + loyerNu
		+ "\nLe loyer en meublé est de " + loyerMeuble
		+ "\nLe loyer à la nuité est de " + loyerNuit
		+ "\nLe loyer mensuel en saisonnier est de"	+ loyerSaisonnier
		+ "\nLa recette locative mensuelle est de"	+ recetteLocative
		+ "\nLa vacance locative annuelle est de"	+ vacLocAnnuelle + " mois"
		+ "\nLa vacance locative mensuelle est de"	+ vacLocSaisonnier + " nuits";
	}

	// TODO Faire le equal() de la classe RecetteLocative	
}

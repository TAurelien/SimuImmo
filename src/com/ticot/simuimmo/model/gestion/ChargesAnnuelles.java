package com.ticot.simuimmo.model.gestion;

//TODO Modifier la javadoc de la classe ChargesAnnuelles
/**
 * @author Aurelien Ticot
 *
 */
public class ChargesAnnuelles {

	//Déclaration des variables
	//==============================================================================
	private double chargesFixes = 0, taxeFonciere = 0, assuranceLocation = 0,
			travauxAnnuels = 0, taxeHabitation = 0, charges = 0;

	//Variables pour la prise en compte des valeurs réelles
	private double chargesReel;
	//TODO Supprimer si les variables des valeurs réelles sont inutiles

	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	
	/**
	 * 
	 */
	public ChargesAnnuelles() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param chargesFixes
	 * @param taxeFonciere
	 * @param assuranceLocation
	 * @param travauxAnnuels
	 * @param taxeHabitation
	 */
	public ChargesAnnuelles(double chargesFixes, double taxeFonciere,
			double assuranceLocation, double travauxAnnuels,
			double taxeHabitation) {
		super();
		this.chargesFixes = chargesFixes;
		this.taxeFonciere = taxeFonciere;
		this.assuranceLocation = assuranceLocation;
		this.travauxAnnuels = travauxAnnuels;
		this.taxeHabitation = taxeHabitation;
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param chargesFixes
	 * @param taxeFonciere
	 * @param assuranceLocation
	 * @param travauxAnnuels
	 * @param taxeHabitation
	 * @param charges
	 */
	public ChargesAnnuelles(double chargesFixes, double taxeFonciere,
			double assuranceLocation, double travauxAnnuels,
			double taxeHabitation, double charges) {
		super();
		this.chargesFixes = chargesFixes;
		this.taxeFonciere = taxeFonciere;
		this.assuranceLocation = assuranceLocation;
		this.travauxAnnuels = travauxAnnuels;
		this.taxeHabitation = taxeHabitation;
		this.charges = charges;
	}

	
	//TODO Modifier la javadoc des getters et setters de la classe ChargesAnnuelles
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the assuranceLocation
	 */
	public double getAssuranceLocation() {
		return assuranceLocation;
	}

	/**
	 * @return the charges
	 */
	public double getCharges() {
		return charges;
	}

	/**
	 * @return the chargesFixes
	 */
	public double getChargesFixes() {
		return chargesFixes;
	}

	/**
	 * @return the chargesReel
	 */
	public double getChargesReel() {
		return chargesReel;
	}

	/**
	 * @return the taxeFonciere
	 */
	public double getTaxeFonciere() {
		return taxeFonciere;
	}

	/**
	 * @return the taxeHabitation
	 */
	public double getTaxeHabitation() {
		return taxeHabitation;
	}

	/**
	 * @return the travauxAnnuels
	 */
	public double getTravauxAnnuels() {
		return travauxAnnuels;
	}


	//Setters
	//==============================================================================
	
	/**
	 * @param assuranceLocation the assuranceLocation to set
	 */
	public void setAssuranceLocation(double assuranceLocation) {
		this.assuranceLocation = assuranceLocation;
	}

	/**
	 * @param charges the charges to set
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	/**
	 * @param chargesFixes the chargesFixes to set
	 */
	public void setChargesFixes(double chargesFixes) {
		this.chargesFixes = chargesFixes;
	}

	/**
	 * @param chargesReel the chargesReel to set
	 */
	public void setChargesReel(double chargesReel) {
		this.chargesReel = chargesReel;
	}

	/**
	 * @param taxeFonciere the taxeFonciere to set
	 */
	public void setTaxeFonciere(double taxeFonciere) {
		this.taxeFonciere = taxeFonciere;
	}

	/**
	 * @param taxeHabitation the taxeHabitation to set
	 */
	public void setTaxeHabitation(double taxeHabitation) {
		this.taxeHabitation = taxeHabitation;
	}

	/**
	 * @param travauxAnnuels the travauxAnnuels to set
	 */
	public void setTravauxAnnuels(double travauxAnnuels) {
		this.travauxAnnuels = travauxAnnuels;
	}
	
	//==============================================================================
	
	//TODO Faire le toString() de la classe ChargesAnnuelles
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Charges annuelles ---------------------------------" +
				"\nLes charges fixes sont de " + chargesFixes +
				"\nLa taxe foncière est de " + taxeFonciere +
				"\nL'assurance habitation est de " + assuranceLocation	+ 
				"\nLes frais de travaux annuels sont de " + travauxAnnuels +
				"\nLa taxe d'habitation est de "	+ taxeHabitation +
				"\nLes charges annuelles sont de " + charges /*+
				"\nLes charges annuelles réelles sont de " + chargesReel*/;
	}	
	
	//TODO Faire le equal() de la classe ChargesAnnuelles
}

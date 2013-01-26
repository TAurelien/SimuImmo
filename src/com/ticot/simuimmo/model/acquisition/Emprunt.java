package com.ticot.simuimmo.model.acquisition;

//TODO Modifier la javadoc de la classe Emprunt
/**
 * @author Aurelien Ticot
 *
 */
public class Emprunt {

	//Déclaration des variables
	//==============================================================================
	private double capitalEmprunte = 0, mensualiteCredit = 0, tauxCredit = 0,
			tauxAssuranceCredit = 0, tauxEndettement = 0;
	private int dureeCredit = 0, nbMensualiteCredit = 0;
	
	//Variables pour la prise en compte des valeurs réelles
	private double capitalEmprunteReel, tauxCreditReel, tauxAssuranceCreditReel;
	//TODO Supprimer si les variables des valeurs réelles sont inutiles
	
	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	/**
	 * 
	 */
	public Emprunt() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param dureeCredit
	 */
	public Emprunt(int dureeCredit) {
		super();
		this.dureeCredit = dureeCredit;
	}
	
	//Constructeur avec toutes les variables sauf les "Reel"
	/**
	 * @param capitalEmprunte
	 * @param mensualiteCredit
	 * @param tauxCredit
	 * @param tauxAssuranceCredit
	 * @param tauxEndettement
	 * @param dureeCredit
	 * @param nbMensualiteCredit
	 */
	public Emprunt(double capitalEmprunte, double mensualiteCredit,
			double tauxCredit, double tauxAssuranceCredit,
			double tauxEndettement, int dureeCredit, int nbMensualiteCredit) {
		super();
		this.capitalEmprunte = capitalEmprunte;
		this.mensualiteCredit = mensualiteCredit;
		this.tauxCredit = tauxCredit;
		this.tauxAssuranceCredit = tauxAssuranceCredit;
		this.tauxEndettement = tauxEndettement;
		this.dureeCredit = dureeCredit;
		this.nbMensualiteCredit = nbMensualiteCredit;
	}

	//TODO Modifier la javadoc des getters et setters de la classe Emprunt

	//Getters
	//==============================================================================
	/**
	 * @return the capitalEmprunte
	 */
	public double getCapitalEmprunte() {
		return capitalEmprunte;
	}

	/**
	 * @return the capitalEmprunteReel
	 */
	public double getCapitalEmprunteReel() {
		return capitalEmprunteReel;
	}

	/**
	 * @return the dureeCredit
	 */
	public int getDureeCredit() {
		return dureeCredit;
	}

	/**
	 * @return the mensualiteCredit
	 */
	public double getMensualiteCredit() {
		return mensualiteCredit;
	}

	/**
	 * @return the nbMensualiteCredit
	 */
	public int getNbMensualiteCredit() {
		return nbMensualiteCredit;
	}

	/**
	 * @return the tauCreditReel
	 */
	public double getTauxCreditReel() {
		return tauxCreditReel;
	}

	/**
	 * @return the tauxAssuranceCredit
	 */
	public double getTauxAssuranceCredit() {
		return tauxAssuranceCredit;
	}

	/**
	 * @return the tauxAssuranceCreditReel
	 */
	public double getTauxAssuranceCreditReel() {
		return tauxAssuranceCreditReel;
	}

	/**
	 * @return the tauxCredit
	 */
	public double getTauxCredit() {
		return tauxCredit;
	}

	/**
	 * @return the tauxEndettement
	 */
	public double getTauxEndettement() {
		return tauxEndettement;
	}

	//Setters
	//==============================================================================
		/**
	 * @param capitalEmprunte the capitalEmprunte to set
	 */
	public void setCapitalEmprunte(double capitalEmprunte) {
		this.capitalEmprunte = capitalEmprunte;
	}

	/**
	 * @param capitalEmprunteReel the capitalEmprunteReel to set
	 */
	public void setCapitalEmprunteReel(double capitalEmprunteReel) {
		this.capitalEmprunteReel = capitalEmprunteReel;
	}

	/**
	 * @param dureeCredit the dureeCredit to set
	 */
	public void setDureeCredit(int dureeCredit) {
		this.dureeCredit = dureeCredit;
	}

	/**
	 * @param mensualitéCredit the mensualitéCredit to set
	 */
	public void setMensualiteCredit(double mensualiteCredit) {
		this.mensualiteCredit = mensualiteCredit;
	}

	/**
	 * @param nbMensualiteCredit the nbMensualiteCredit to set
	 */
	public void setNbMensualiteCredit(int nbMensualiteCredit) {
		this.nbMensualiteCredit = nbMensualiteCredit;
	}

	/**
	 * @param tauCreditReel the tauCreditReel to set
	 */
	public void setTauxCreditReel(double tauxCreditReel) {
		this.tauxCreditReel = tauxCreditReel;
	}

	/**
	 * @param tauxAssuranceCredit the tauxAssuranceCredit to set
	 */
	public void setTauxAssuranceCredit(double tauxAssuranceCredit) {
		this.tauxAssuranceCredit = tauxAssuranceCredit;
	}

	/**
	 * @param tauxAssuranceCreditReel the tauxAssuranceCreditReel to set
	 */
	public void setTauxAssuranceCreditReel(double tauxAssuranceCreditReel) {
		this.tauxAssuranceCreditReel = tauxAssuranceCreditReel;
	}

	/**
	 * @param tauxCredit the tauxCredit to set
	 */
	public void setTauxCredit(double tauxCredit) {
		this.tauxCredit = tauxCredit;
	}

	/**
	 * @param tauxEndettement the tauxEndettement to set
	 */
	public void setTauxEndettement(double tauxEndettement) {
		this.tauxEndettement = tauxEndettement;
	}
	//==============================================================================
	
	//TODO Faire le toString() de la classe Emprunt 

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprunt ------------------------------------------" +
				"\nLa durée du credit est de " + dureeCredit +
				"\nLe nombre de mensualité est de " + nbMensualiteCredit +
				"\nLe capital emprunté est de " + capitalEmprunte	+ 
				"\nLa mensualité de credit est de " + mensualiteCredit +
				"\nLe taux de credit est de "	+ tauxCredit +
				"\nLe taux d'assurance est de " + tauxAssuranceCredit /*+
				"\nLe taux d'endettement est de NA" + tauxEndettement +
				"\nLe capital emprunté réel est de =" + capitalEmprunteReel +
				"\nLe taux de credit réel est de =" + tauxCreditReel	+
				"\nLe taux d'assurance réel est de =" + tauxAssuranceCreditReel*/;
	}	
	
	//TODO Faire le equal() de la classe Emprunt
	
}

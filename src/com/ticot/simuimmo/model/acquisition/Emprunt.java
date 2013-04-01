/*
 * Copyright (C) 2013 Aurélien Ticot
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ticot.simuimmo.model.acquisition;

/**
 * The class Emprunt represents the details of the loan for a real estate transaction.
 * <p>It's characterized by several variables:
 * <ul>
 * <li>capitalEmprunte: the borrowed capital</li>
 * <li>mensualiteCredit: the monthly credit</li> 
 * <li>tauxCredit: the rate of the loan</li>
 * <li>tauxAssuranceCredit: the credit insurrance rate</li>
 * <li>dureeCredit: the duration of the loan</li>
 * <li>nbMensualiteCredit: the number of monthly credit</li>
 * <li>credit: a table representing the complete credit over the duration</li>
 * <li>creditAn: a synthesis table of the loan per year</li>
 * </ul>
 * </p>
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Emprunt {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	private double capitalEmprunte = 0, mensualiteCredit = 0, tauxCredit = 0,
			tauxAssuranceCredit = 0, tauxEndettement = 0, credit[][], creditAn[][];
	private int dureeCredit = 0, nbMensualiteCredit = 0;
	
	//Variables pour la prise en compte des valeurs réelles
	private double capitalEmprunteReel, tauxCreditReel, tauxAssuranceCreditReel;
	
	
	
	//==============================================================================
	//Constructors
	//==============================================================================

	/**
	 * 
	 */
	public Emprunt() {
		super();
	}

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
	
	
	
	//==============================================================================
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
	 * @return the credit
	 */
	public double[][] getCredit() {
		return credit;
	}

	/**
	 * @return the credit
	 */
	public double[][] getCreditAn() {
		return creditAn;
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

	
	
	//==============================================================================
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
	 * @param credit the credit to set
	 */
	public void setCredit(double credit[][]) {
		this.credit = credit;
	}

	/**
	 * @param credit the creditAn to set
	 */
	public void setCreditAn(double creditAn[][]) {
		this.creditAn = creditAn;
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
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return "Emprunt ------------------------------------------" +
				"\nLa durée du credit est de " + dureeCredit +
				"\nLe nombre de mensualité est de " + nbMensualiteCredit +
				"\nLe capital emprunté est de " + capitalEmprunte	+ 
				"\nLa mensualité de credit est de " + mensualiteCredit +
				"\nLe taux de credit est de "	+ tauxCredit +
				"\nLe taux d'assurance est de " + tauxAssuranceCredit /*+
				"\nLe taux d'endettement est de NA" + tauxEndettement*/;
	}	
	
	//TODO Define the methods equal() of the class Bien
	
}

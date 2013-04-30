/*
 * Copyright (C) 2013 Aurelien Ticot
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
 * <p>The class Emprunt is part of the class Acquisition. </br>The additional costs of acquisition are represented by the class FraisAcquisition.</p> 
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
 * @see Acquisition
 * @see FraisAcquisition
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Emprunt {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**The borrowed capital.*/
	private double capitalEmprunte = 0;
	
	/**The monthly credit.*/
	private double mensualiteCredit = 0;
	
	/**The rate of the loan.*/
	private double tauxCredit = 0;
	
	/**The credit insurrance rate.*/
	private double tauxAssuranceCredit = 0;
	
	/**The debt ratio.*/
	private double tauxEndettement = 0;
	
	/**A table representing the complete credit over the duration.*/
	private double credit[][];
	
	/**A synthesis table of the loan per year.*/
	private double creditAn[][];
	
	/**The duration of the loan.*/
	private int dureeCredit = 0;
	
	/**The number of monthly credit.*/
	private int nbMensualiteCredit = 0;
	
	/*** The real borrowed capital.
	 * @deprecated
	 */
	private double capitalEmprunteReel;
	
	/**The real rate of the loan.
	 * @deprecated
	 */
	private double tauxCreditReel;
	
	/**The real credit insurance rate.
	 * @deprecated
	 */
	private double tauxAssuranceCreditReel;
	
	
	
	//==============================================================================
	//Constructors
	//==============================================================================

	/**
	 * Constructor of Emprunt.
	 * <p>Empty constructor.</p>
	 */
	public Emprunt() {
		super();
	}

	/**
	 * Constructor of Emprunt.
	 * <p>Constructor with the variable dureeCredit.</p>
	 * 
	 * @param dureeCredit
	 */
	public Emprunt(int dureeCredit) {
		super();
		this.dureeCredit = dureeCredit;
	}
	
	/**
	 * Constructor of Emprunt.
	 * <p>Constructor with all variables except the real variables</p>
	 * 
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
	 * Return the borrowed capital.
	 * @return a double representing the borrowed capital (capitalEmprunte).
	 */
	public double getCapitalEmprunte() {
		return capitalEmprunte;
	}

	/**
	 * Return the real borrowed capital.
	 * @return a double representing the real borrowed capital (capitalEmprunteReel).
	 * @deprecated
	 */
	public double getCapitalEmprunteReel() {
		return capitalEmprunteReel;
	}

	/**
	 * Return the details of the loan per month (credit).
	 * @return a table of double representing the loan (credit).
	 */
	public double[][] getCredit() {
		return credit;
	}

	/**
	 * Return the details of the loan per year (creditAn).
	 * @return a table of double representing the loan per year (creditAn).
	 */
	public double[][] getCreditAn() {
		return creditAn;
	}
	
	/**
	 * Return the duration of the loan. 
	 * @return an integer representing the duration in year of the loan (dureeCredit).
	 */
	public int getDureeCredit() {
		return dureeCredit;
	}

	/**
	 * Return the monthly credit.
	 * @return a double representing the monthly credit (mensualiteCredit).
	 */
	public double getMensualiteCredit() {
		return mensualiteCredit;
	}

	/**
	 * Return the number of montly credit.
	 * @return an integer representing the number of monthly  credit (nbMensualiteCredit).
	 */
	public int getNbMensualiteCredit() {
		return nbMensualiteCredit;
	}

	/**
	 * Return the real rate of the loan.
	 * @return a double representing the real rate of the loan (tauxCreditReel).
	 * @deprecated
	 */
	public double getTauxCreditReel() {
		return tauxCreditReel;
	}

	/**
	 * Return the credit insurance rate.
	 * @return a double representing the credit insurance rate (tauxAssuranceCredit).
	 */
	public double getTauxAssuranceCredit() {
		return tauxAssuranceCredit;
	}

	/**
	 * Return the real credit insurance rate.
	 * @return a double representing the real credit insurance rate (tauxAssuranceCreditReel).
	 * @deprecated
	 */
	public double getTauxAssuranceCreditReel() {
		return tauxAssuranceCreditReel;
	}

	/**
	 * Return the rate of the loan.
	 * @return a double representing the rate of the loan (tauxCredit).
	 */
	public double getTauxCredit() {
		return tauxCredit;
	}

	/**
	 * Return the debt ratio.
	 * @return a double representing the debt ratio (tauxEndettement).
	 */
	public double getTauxEndettement() {
		return tauxEndettement;
	}

	
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the borrowed capital of the loan.
	 * @param capitalEmprunte the double of borrowed capital to set.
	 */
	public void setCapitalEmprunte(double capitalEmprunte) {
		this.capitalEmprunte = capitalEmprunte;
	}

	/**
	 * Define the real borrowed capital of the loan.
	 * @param capitalEmprunteReel the double of borrowed capital to set.
	 * @deprecated
	 */
	public void setCapitalEmprunteReel(double capitalEmprunteReel) {
		this.capitalEmprunteReel = capitalEmprunteReel;
	}

	/**
	 * Define the details of the loan, per month.
	 * @param credit the table of double of the details of the loan to set.
	 */
	public void setCredit(double credit[][]) {
		this.credit = credit;
	}

	/**
	 * Define the details of the loan, per year.
	 * @param creditAn the table of double of the details of the loan to set.
	 */
	public void setCreditAn(double creditAn[][]) {
		this.creditAn = creditAn;
	}
	
	/**
	 * Define the duration of the loan.
	 * @param dureeCredit the integer of the duration of the loan to set.
	 */
	public void setDureeCredit(int dureeCredit) {
		this.dureeCredit = dureeCredit;
	}

	/**
	 * Define the monthly credit.
	 * @param mensualiteCredit the double of the monthly credit to set.
	 */
	public void setMensualiteCredit(double mensualiteCredit) {
		this.mensualiteCredit = mensualiteCredit;
	}

	/**
	 * Define the number of monthly credit.
	 * @param nbMensualiteCredit the integer of the number of monthly credit to set.
	 */
	public void setNbMensualiteCredit(int nbMensualiteCredit) {
		this.nbMensualiteCredit = nbMensualiteCredit;
	}

	/**
	 * Define the real rate of the loan.
	 * @param tauxCreditReel the double of the real rate of the loan to set.
	 * @deprecated
	 */
	public void setTauxCreditReel(double tauxCreditReel) {
		this.tauxCreditReel = tauxCreditReel;
	}

	/**
	 * Define the credit insurance rate.
	 * @param tauxAssuranceCredit the double of the credit insurance rate to set.
	 */
	public void setTauxAssuranceCredit(double tauxAssuranceCredit) {
		this.tauxAssuranceCredit = tauxAssuranceCredit;
	}

	/**
	 * Define the real credit insurance rate.
	 * @param tauxAssuranceCreditReel the double of the real credit insurance rate to set.
	 * @deprecated
	 */
	public void setTauxAssuranceCreditReel(double tauxAssuranceCreditReel) {
		this.tauxAssuranceCreditReel = tauxAssuranceCreditReel;
	}

	/**
	 * Define the rate of the loan.
	 * @param tauxCredit the double of the rate of the loan to set.
	 */
	public void setTauxCredit(double tauxCredit) {
		this.tauxCredit = tauxCredit;
	}

	/**
	 * Define the debt ratio.
	 * @param tauxEndettement the double of the debt ratio to set.
	 */
	public void setTauxEndettement(double tauxEndettement) {
		this.tauxEndettement = tauxEndettement;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return "=== Emprunt ===" +
				"\nLa duree du credit est de " + dureeCredit +
				"\nLe nombre de mensualite est de " + nbMensualiteCredit +
				"\nLe capital emprunte est de " + capitalEmprunte	+ 
				"\nLa mensualite de credit est de " + mensualiteCredit +
				"\nLe taux de credit est de "	+ tauxCredit +
				"\nLe taux d'assurance est de " + tauxAssuranceCredit /*+
				"\nLe taux d'endettement est de NA" + tauxEndettement*/;
	}	
	
	//TODO Define the methods equal() of the class Bien
	
}

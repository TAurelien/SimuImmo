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

package com.ticot.simuimmo.model.gestion;

/**
 * The class ChargesAnnuelles represents the details of the annual expenses for a real estate.
 * <p>The class ChargesAnnuelles is part of the class Gestion.</p> 
 * <p>It's characterized by several variables:
 * <ul>
 * <li>chargesFixes: the fixed expenses (condominium)</li>
 * <li>taxeFonciere: the French property tax</li> 
 * <li>assuranceLocation: the rental insurance costs</li>
 * <li>travauxAnnuels: the annual work costs</li>
 * <li>taxeHabitation: the French housing tax</li>
 * <li>charges: the total annual expenses</li>
 * </ul>
 * </p>
 * 
 * @see Gestion
 * @see FraisLocationAnnuelle
 * @see FraisLocationSaisonniere
 * @see RecetteLocative
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class ChargesAnnuelles {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**The fixed expenses (condominium).*/
	private double chargesFixes = 0;
	
	/**The French property tax.*/
	private double taxeFonciere = 0;
	
	/**The rental insurance costs.*/
	private double assuranceLocation = 0;
	
	/**The annual work costs.*/
	private double travauxAnnuels = 0;
	
	/**The French housing tax.*/
	private double taxeHabitation = 0;
	
	/**The total annual expenses.*/
	private double charges = 0;

	/**The real total annual expenses.
	 * @deprecated
	 */
	private double chargesReel;
	
	
	
	//==============================================================================
	//Constructors
	//==============================================================================

	/**
	 * Constructor of ChargesAnnuelles.
	 * <p>Empty constructor.</p>
	 */
	public ChargesAnnuelles() {
		super();
	}

	/**
	 * Constructor of ChargesAnnuelles.
	 * <p>Constructor with all variables except charges.</p>
	 * 
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
	
	/**
	 * Constructor of ChargesAnnuelles.
	 * <p>Constructor with all variables.</p>
	 * 
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
	
	
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the rental insurance cost.
	 * @return a double representing the rental insurance costs(assuranceLocation).
	 */
	public double getAssuranceLocation() {
		return assuranceLocation;
	}

	/**
	 * Return the total annual expenses.
	 * @return a double representing the total annual expenses (charges).
	 */
	public double getCharges() {
		return charges;
	}

	/**Return the fixed expenses.
	 * @return a double representing the fixed expenses (chargesFixes).
	 */
	public double getChargesFixes() {
		return chargesFixes;
	}

	/**
	 * Return the real total expenses.
	 * @return a double representing the real total expenses (chargesReel).
	 * @deprecated
	 */
	public double getChargesReel() {
		return chargesReel;
	}

	/**
	 * Return the French property tax.
	 * @return a double representing the French property tax (taxeFonciere).
	 */
	public double getTaxeFonciere() {
		return taxeFonciere;
	}

	/**
	 * Return the French housing tax.
	 * @return a double representing the French housing tax (taxeHabitation).
	 */
	public double getTaxeHabitation() {
		return taxeHabitation;
	}

	/**
	 * Return the annual work costs.
	 * @return a double representing the annual work costs (travauxAnnuels).
	 */
	public double getTravauxAnnuels() {
		return travauxAnnuels;
	}
	
	
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the rental insurance cost. 
	 * @param assuranceLocation the double of rental insurance cost to set.
	 */
	public void setAssuranceLocation(double assuranceLocation) {
		this.assuranceLocation = assuranceLocation;
	}

	/**
	 * Define the total annual expenses.
	 * @param charges the double of total annual expenses to set.
	 */
	public void setCharges(double charges) {
		this.charges = charges;
	}

	/**
	 * Define the fixed expenses.
	 * @param chargesFixes the double of the fixed expenses to set.
	 */
	public void setChargesFixes(double chargesFixes) {
		this.chargesFixes = chargesFixes;
	}

	/**
	 * Define the real total annual expenses. 
	 * @param chargesReel the double of the real total expenses to set.
	 * @deprecated
	 */
	public void setChargesReel(double chargesReel) {
		this.chargesReel = chargesReel;
	}

	/**
	 * Define the French property tax.
	 * @param taxeFonciere the double of the French property tax to set.
	 */
	public void setTaxeFonciere(double taxeFonciere) {
		this.taxeFonciere = taxeFonciere;
	}

	/**
	 * Define the French housing tax.
	 * @param taxeHabitation the double of the French housing tax to set.
	 */
	public void setTaxeHabitation(double taxeHabitation) {
		this.taxeHabitation = taxeHabitation;
	}

	/**
	 * Defint the rental work costs.
	 * @param travauxAnnuels the double of the rental work costs to set.
	 */
	public void setTravauxAnnuels(double travauxAnnuels) {
		this.travauxAnnuels = travauxAnnuels;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return "=== Charges annuelles ===" +
				"\nLes charges fixes sont de " + chargesFixes +
				"\nLa taxe fonciere est de " + taxeFonciere +
				"\nL'assurance habitation est de " + assuranceLocation	+ 
				"\nLes frais de travaux annuels sont de " + travauxAnnuels +
				"\nLa taxe d'habitation est de "	+ taxeHabitation +
				"\nLes charges annuelles sont de " + charges;
	}	
	
	//TODO Define the methods equal() of the class Bien
}

/*
 * Copyright (C) 2013 Aurelien Ticot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ticot.simuimmo.model.gestion;

/**
 * The class RecetteLocative represents the details of the rental income for a real
 * estate.
 * <p>
 * The class RecetteLocative is part of the class Gestion.
 * </p>
 * <p>
 * It's characterized by several variables:
 * <ul>
 * <li>loyerNu: the plain rent, per month</li>
 * <li>loyerMeuble: the furnished rent, per month</li>
 * <li>loyerNuit: the seasonal rent, per night</li>
 * <li>loyerSaisonnier: the seasonal rent, per month</li>
 * <li>recetteLocative: the rental income, for a year</li>
 * <li>vacLocAnnuelle: the rental vacancy, in month per year</li>
 * <li>vacLocSaisonnier: the rental vacancy in seasonal rent, in night per month</li>
 * </ul>
 * </p>
 * 
 * @see Gestion
 * @see FraisLocationAnnuelle
 * @see FraisLocationSaisonniere
 * @see ChargesAnnuelles
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class RecetteLocative {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/** The plain rent, per month. */
	private double loyerNu = 0;
	
	/** The furnished rent, per month. */
	private double loyerMeuble = 0;
	
	/** The seasonal rent, per night. */
	private double loyerNuit = 0;
	
	/** The seasonal rent, per month. */
	private double loyerSaisonnier = 0;
	
	/** The rental income, for a year. */
	private double recetteLocative = 0;
	
	/**
	 * The rental vacancy, in month per year.
	 * <p>
	 * Not used for seasonal rental.
	 * </p>
	 */
	private int vacLocAnnuelle = 0;
	
	/**
	 * The rental vacancy in seasonal rent, in night per month.
	 * <p>
	 * Not used for plain and furnished rental.
	 * </p>
	 */
	private int vacLocSaisonnier = 0;
	
	//==============================================================================
	//Constructors
	//==============================================================================
	
	/**
	 * Constructor of RecetteLocative.
	 * <p>
	 * Empty constructor.
	 * </p>
	 */
	public RecetteLocative() {
	
		super();
	}
	
	/**
	 * Constructor of RecetteLocative.
	 * <p>
	 * Constructor with the user's varaibles.
	 * </p>
	 * 
	 * @param loyerNu
	 * @param loyerMeuble
	 * @param loyerNuit
	 * @param vacLocAnnuelle
	 * @param vacLocSaisonnier
	 */
	public RecetteLocative(double loyerNu, double loyerMeuble, double loyerNuit,
			int vacLocAnnuelle, int vacLocSaisonnier) {
	
		super();
		this.loyerNu = loyerNu;
		this.loyerMeuble = loyerMeuble;
		this.loyerNuit = loyerNuit;
		this.vacLocAnnuelle = vacLocAnnuelle;
		this.vacLocSaisonnier = vacLocSaisonnier;
	}
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the furnished rent.
	 * 
	 * @return a double representing the furnished rent (loyerMeuble).
	 */
	public double getLoyerMeuble() {
	
		return loyerMeuble;
	}
	
	/**
	 * Return the plain rent.
	 * 
	 * @return a double representing the plain rent (loyerNu).
	 */
	public double getLoyerNu() {
	
		return loyerNu;
	}
	
	/**
	 * Return the seasonal rent, per night.
	 * 
	 * @return a double representing the seasonal rent, per night (loyerNuit).
	 */
	public double getLoyerNuit() {
	
		return loyerNuit;
	}
	
	/**
	 * Return the seasonal rent, per month.
	 * 
	 * @return a double representing the seasonal rent, per month (loyerSaisonnier).
	 */
	public double getLoyerSaisonnier() {
	
		return loyerSaisonnier;
	}
	
	/**
	 * Return the rental income, per year.
	 * 
	 * @return a double representing the rental income (recetteLocative).
	 */
	public double getRecetteLocative() {
	
		return recetteLocative;
	}
	
	/**
	 * Return the rental vacancy, in month per year.
	 * 
	 * @return an integer representing the rental vacancy, in month per year
	 * (vacLocAnnuelle).
	 */
	public int getVacLocAnnuelle() {
	
		return vacLocAnnuelle;
	}
	
	/**
	 * Return the rental vacancy, in night per month.
	 * 
	 * @return an integer representing the rental vacancy, in night per month
	 * (vacLocSaisonnier).
	 */
	public int getVacLocSaisonnier() {
	
		return vacLocSaisonnier;
	}
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the furnished rent.
	 * 
	 * @param loyerMeuble the double of the furnished rent to set.
	 */
	public void setLoyerMeuble(double loyerMeuble) {
	
		this.loyerMeuble = loyerMeuble;
	}
	
	/**
	 * Define the plain rent.
	 * 
	 * @param loyerNu the double of the plain rent to set.
	 */
	public void setLoyerNu(double loyerNu) {
	
		this.loyerNu = loyerNu;
	}
	
	/**
	 * Define the seasonal rent, per night.
	 * 
	 * @param loyerNuit the double of the seasonal rent, per night to set.
	 */
	public void setLoyerNuit(double loyerNuit) {
	
		this.loyerNuit = loyerNuit;
	}
	
	/**
	 * Define the seasonal rent, per month.
	 * 
	 * @param loyerSaisonnier the double of the seasonal rent, per month to set.
	 */
	public void setLoyerSaisonnier(double loyerSaisonnier) {
	
		this.loyerSaisonnier = loyerSaisonnier;
	}
	
	/**
	 * Define the rental income, per year.
	 * 
	 * @param recetteLocative the double of the rental income to set.
	 */
	public void setRecetteLocative(double recetteLocative) {
	
		this.recetteLocative = recetteLocative;
	}
	
	/**
	 * Define the rental vacancy, in month per year.
	 * 
	 * @param vacLocAnnuelle the integer of the rental vacancy to set.
	 */
	public void setVacLocAnnuelle(int vacLocAnnuelle) {
	
		this.vacLocAnnuelle = vacLocAnnuelle;
	}
	
	/**
	 * Define the rental vacancy, in night per month.
	 * 
	 * @param vacLocSaisonnier the double of the rental vacancy, in night per month to
	 * set.
	 */
	public void setVacLocSaisonnier(int vacLocSaisonnier) {
	
		this.vacLocSaisonnier = vacLocSaisonnier;
	}
	
	//==============================================================================
	//Other methods
	//==============================================================================
	
	@Override
	public String toString() {
	
		return "=== Recette locative ===" + "\nLe loyer en location nue est de "
				+ loyerNu + "\nLe loyer en location meublee est de " + loyerMeuble
				+ "\nLe loyer à la nuitee est de " + loyerNuit
				+ "\nLe loyer mensuel en saisonnier est de " + loyerSaisonnier
				+ "\nLa recette locative annuelle est de " + recetteLocative
				+ "\nLa vacance locative annuelle est de " + vacLocAnnuelle + " mois"
				+ "\nLa vacance locative mensuelle, en saisonnier est de "
				+ vacLocSaisonnier + " nuits";
	}
	
	// TODO Define the methods equal() of the class Bien	
}

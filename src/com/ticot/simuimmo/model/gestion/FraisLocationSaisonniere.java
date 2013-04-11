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

package com.ticot.simuimmo.model.gestion;

/**
 * The class FraisLocationSaisonniere represents the details of the annual rental expenses in seasonal rent.
 * <p>The class FraisLocationSaisonniere is part of the class Gestion.</p> 
 * <p>It's characterized by several variables:
 * <ul>
 * <li>fraisAccueil: the welcoming expense</li>
 * <li>fraisMenage: the cleaning expense</li> 
 * <li>fraisGestionSaisonnier: the management expense, in seasonal</li>
 * <li>fraisLocationSaisonniere: the overal cost</li>
 * </ul>
 * </p>
 * 
 * @see Gestion
 * @see ChargesAnnuelles
 * @see FraisLocationAnnuelle
 * @see RecetteLocative
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class FraisLocationSaisonniere {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**The welcoming expense.*/
	private double fraisAccueil = 0;
	
	/**The cleaning expense.*/
	private double fraisMenage = 0;
	
	/**The management expense, in seasonal.*/
	private double fraisGestionSaisonnier = 0;
	
	/**The overal cost.*/
	private double fraisLocationSaisonniere = 0;
	
	/**The real welcoming expense.
	 * @deprecated
	 */
	private double fraisAccueilReel;
	
	/**The real cleaning expense.
	 * @deprecated
	 */
	private double fraisMenageReel;
	
	/**The real management expense, in seasonal.
	 * @deprecated
	 */
	private double fraisGestionSaisonnierReel;
	
	/**The real overal cost.
	 * @deprecated
	 */
	private double fraisLocationSaisonniereReel;
	
	
	
	//==============================================================================
	//Constructors
	//==============================================================================

	/**
	 * Constructor of FraisLocationSaisonniere.
	 * <p>Empty constructor.</p>
	 */
	public FraisLocationSaisonniere() {
		super();
	}

	/**
	 * Constructor of FraisLocationSaisonniere.
	 * <p>Constructor with all variables.</p>
	 * 
	 * @param fraisAccueil
	 * @param fraisMenage
	 * @param fraisGestionSaisonnier
	 * @param fraisLocationSaisonniere
	 */
	public FraisLocationSaisonniere(double fraisAccueil, double fraisMenage,
			double fraisGestionSaisonnier, double fraisLocationSaisonniere) {
		super();
		this.fraisAccueil = fraisAccueil;
		this.fraisMenage = fraisMenage;
		this.fraisGestionSaisonnier = fraisGestionSaisonnier;
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}
	
	
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the overal cost.
	 * @return a double representing the overall cost (fraisLocationSaisonniere).
	 */
	public double getFraisLocationSaisonniere() {
		return fraisLocationSaisonniere;
	}

	/**
	 * Return the real overall cost.
	 * @return a double representing the real overall cost (fraisLocationSaisonniereReel).
	 * @deprecated
	 */
	public double getFraisLocationSaisonniereReel() {
		return fraisLocationSaisonniereReel;
	}

	/**
	 * Return the welcoming expense.
	 * @return a double representing the welcoming expense (fraisAccueil).
	 */
	public double getFraisAccueil() {
		return fraisAccueil;
	}

	/**
	 * Return the real welcoming expense.
	 * @return a double representing the welcoming expense (fraisAccueilReel).
	 * @deprecated
	 */
	public double getFraisAccueilReel() {
		return fraisAccueilReel;
	}

	/**
	 * Return the management expense.
	 * @return a double representing the management expense (fraisGestionSaisonnier)
	 */
	public double getFraisGestionSaisonnier() {
		return fraisGestionSaisonnier;
	}

	/**
	 * Return the real management expense.
	 * @return a double representing the real management expense (fraisGestionSaisonnierReel).
	 * @deprecated
	 */
	public double getFraisGestionSaisonnierReel() {
		return fraisGestionSaisonnierReel;
	}

	/**
	 * Return the cleaning expense.
	 * @return a double representing the cleaning expense (fraisMenage).
	 */
	public double getFraisMenage() {
		return fraisMenage;
	}

	/**
	 * Return the real cleaning expense.
	 * @return a double representing the real cleaning expense (fraisMenageReel).
	 * @deprecated
	 */
	public double getFraisMenageReel() {
		return fraisMenageReel;
	}
	
	
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the overall cost. 
	 * @param fraisLocationSaisonniere the double of the overall cost to set.
	 */
	public void setFraisLocationSaisonniere(double fraisLocationSaisonniere) {
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}

	/**
	 * Define the real overall cost.
	 * @param fraisLocationSaisonniereReel the double of the real overall cost to set.
	 * @deprecated
	 */
	public void setFraisLocationSaisonniereReel(double fraisLocationSaisonniereReel) {
		this.fraisLocationSaisonniereReel = fraisLocationSaisonniereReel;
	}

	/**
	 * Define the welcoming expense.
	 * @param fraisAccueil the double of the welcoming expense to set.
	 */
	public void setFraisAccueil(double fraisAccueil) {
		this.fraisAccueil = fraisAccueil;
	}

	/**
	 * Define the real welcoming expense.
	 * @param fraisAccueilReel the double of the real welcoming expense to set.
	 * @deprecated
	 */
	public void setFraisAccueilReel(double fraisAccueilReel) {
		this.fraisAccueilReel = fraisAccueilReel;
	}

	/**
	 * Define the management expense.
	 * @param fraisGestionSaisonnier the double of the management expense to set.
	 */
	public void setFraisGestionSaisonnier(double fraisGestionSaisonnier) {
		this.fraisGestionSaisonnier = fraisGestionSaisonnier;
	}

	/**
	 * Define the real management expense.
	 * @param fraisGestionSaisonnierReel the double of the real management expense to set.
	 * @deprecated
	 */
	public void setFraisGestionSaisonnierReel(double fraisGestionSaisonnierReel) {
		this.fraisGestionSaisonnierReel = fraisGestionSaisonnierReel;
	}

	/**
	 * Define the cleaning expense.
	 * @param fraisMenage the double of the cleaning expense to set.
	 */
	public void setFraisMenage(double fraisMenage) {
		this.fraisMenage = fraisMenage;
	}

	/**
	 * defin the real cleaning expense.
	 * @param fraisMenageReel the double of the real cleaning expense to set.
	 * @deprecated
	 */
	public void setFraisMenageReel(double fraisMenageReel) {
		this.fraisMenageReel = fraisMenageReel;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return "Frais location saisonnière -------------------------"
				+ "\nLes frais d'accueil sont de " + fraisAccueil
				+ "\nLes charges de ménage sont de " + fraisMenage
				+ "\nLes frais de gestion sont de " + fraisGestionSaisonnier
				+ "\nLe total des frais de location saisonnière sont de "
				+ fraisLocationSaisonniere;
	}

	// TODO Define the methods equal() of the class Bien
}
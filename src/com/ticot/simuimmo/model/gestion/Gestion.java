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
 * The class Gestion represents the management of the real estate.
 * <p>It's characterized by 5 variables:
 * <ul>
 * <li>typeGestion: the type of management</li>
 * <li>chargesAnnuelles: the annual expenses</li>
 * <li>fraisLocationAnnuelle: the annual renting expenses</li>
 * <li>fraisLocationSaisonniere: the annual seasonal renting expenses</li>
 * <li>recetteLocative: the rental income</li>
 * </ul>
 * </p>
 * 
 * @see ChargesAnnuelles
 * @see FraisLocationAnnuelle
 * @see FraisLocationSaisonniere
 * @see RecetteLocative
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Gestion {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**The type of management.*/
	private int typeGestion;
	// TODO Change the type of typeGestion
	
	/**
	 * The annual expenses.
	 * <p>For additional information refer to the ChargesAnnuelles class.</p>
	 * @see ChargesAnnuelles
	 */
	private ChargesAnnuelles chargesAnnuelles;
	
	/**
	 * The annual renting expenses.
	 * <p>For additional information refer to the FraisLocationAnnuelle class.</p>
	 * @see FraisLocationAnnuelle
	 */
	private FraisLocationAnnuelle fraisLocationAnnuelle;
	
	/**
	 * The annual seasonal renting expenses.
	 * <p>For additional information refer to the FraisLocationSaisonniere class.</p>
	 * @see FraisLocationSaisonniere
	 */
	private FraisLocationSaisonniere fraisLocationSaisonniere;
	
	/**
	 * The rental income.
	 * <p>For additional information refer to the RecetteLocative class.</p>
	 * @see RecetteLocative
	 */
	private RecetteLocative recetteLocative;
	
	
	
	//==============================================================================
	//Constructeurs
	//==============================================================================

	/**
	 * Constructor of Gestion.
	 * <p>Empty constructor.</p>
	 */
	public Gestion() {
		super();
	}
	
	/**
	 * Constructor of Gestion.
	 * <p>Constructor with all variables.</p>
	 * 
	 * @see ChargesAnnuelles
	 * @see FraisLocationAnnuelle
	 * @see FraisLocationSaisonniere
	 * @see RecetteLocative
	 * 
	 * @param typeGestion
	 * @param fraisAnnuels
	 * @param fraisLocationAnnuelle
	 * @param fraisLocationSaisonniere
	 * @param recetteLocative
	 */
	public Gestion(int typeGestion, ChargesAnnuelles chargesAnnuelles,
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
	
	
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the type of management.
	 * @return an integer representing the type of management (typeGestion).
	 */
	public int getTypeGestion() {
		return typeGestion;
	}
	
	/**
	 * Return the estimation of the annual expenses.
	 * @return an instance of ChargesAnnuelles.
	 * @see ChargesAnnuelles
	 */
	public ChargesAnnuelles getChargesAnnuelles() {
		return chargesAnnuelles;
	}

	/**
	 * Return the estimation of the annual renting expenses.
	 * @return an instance of FraisLocationAnnuelle.
	 * @see FraisLocationAnnuelle
	 */
	public FraisLocationAnnuelle getFraisLocationAnnuelle() {
		return fraisLocationAnnuelle;
	}
	
	/**
	 * Return the estimation of the annual seasonal renting expenses.
	 * @return an instance of FraisLocationSaisonniere.
	 * @see FraisLocationSaisonniere
	 */
	public FraisLocationSaisonniere getFraisLocationSaisonniere() {
		return fraisLocationSaisonniere;
	}
	
	/**
	 * Return the estimation of the rental income.
	 * @return an instance of RecetteLocative.
	 * @see RecetteLocative
	 */
	public RecetteLocative getRecetteLocative() {
		return recetteLocative;
	}
	
	
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the type of management (typeGestion).
	 * @param typeGestion the integer of the type of management to set.
	 */
	public void setTypeGestion(int typeGestion) {
		this.typeGestion = typeGestion;
	}
	
	/**
	 * Define the annual expenses.
	 * @param chargesAnnuelles the instance of ChargesAnnuelles to set.
	 * @see ChargesAnnuelles
	 */
	public void setChargesAnnuelles(ChargesAnnuelles chargesAnnuelles) {
		this.chargesAnnuelles = chargesAnnuelles;
	}
	
	/**
	 * Define the annual renting expenses.
	 * @param fraisLocationAnnuelle the instance of FraisLocationAnnuelle to set.
	 * @see FraisLocationAnnuelle
	 */
	public void setFraisLocationAnnuelle(FraisLocationAnnuelle fraisLocationAnnuelle) {
		this.fraisLocationAnnuelle = fraisLocationAnnuelle;
	}
	
	/**
	 * Define the annual seasonal renting expenses.
	 * @param fraisLocationSaisonniere the instance of FraisLocationSaisonniere to set.
	 * @see FraisLocationSaisonniere
	 */
	public void setFraisLocationSaisonniere(FraisLocationSaisonniere fraisLocationSaisonniere) {
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}
	
	/**
	 * Define the rental income.
	 * @param recetteLocative the instance of RecetteLocative to set.
	 * @see RecetteLocative
	 */
	public void setRecetteLocative(RecetteLocative recetteLocative) {
		this.recetteLocative = recetteLocative;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return "=== Gestion ===" +
				"\nLe type de gestion est " + typeGestion + 
				"\n\n" + chargesAnnuelles +
				"\n\n" + fraisLocationAnnuelle +
				"\n\n" + fraisLocationSaisonniere +
				"\n\n" + recetteLocative;
	}

	// TODO Define the methods equal() of the class Bien	
}


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
 * The class FraisLocationAnnuelle represents the details of the annual rental expenses
 * for a real estate.
 * <p>
 * The class FraisLocationAnnuelle is part of the class Gestion.
 * </p>
 * <p>
 * It's characterized by several variables:
 * <ul>
 * <li>fraisGestionLocation: the expenses for the management through estate agency</li>
 * <li>fraisLocation: the total expenses for the rental</li>
 * <li>gestionParAgence: the decision to manage through estate agency</li>
 * </ul>
 * </p>
 * 
 * @see Gestion
 * @see ChargesAnnuelles
 * @see FraisLocationSaisonniere
 * @see RecetteLocative
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class FraisLocationAnnuelle {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/** The expenses for the management through estate agency. */
	private double fraisGestionLocation = 0;
	
	/** The total expenses for the rental. */
	private double fraisLocation = 0;
	
	/** The decision to manage through estate agency. */
	private boolean gestionParAgence = true;
	
	/**
	 * The real expenses for the management through estate agency.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double fraisGestionLocationReel;
	
	/**
	 * The real expenses for the rental (ad).
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double fraisLocationReel;
	
	//==============================================================================
	//Constructors
	//==============================================================================
	
	/**
	 * Constructor of FraisLocationAnnuelle.
	 * <p>
	 * Empty constructor.
	 * </p>
	 */
	public FraisLocationAnnuelle() {
	
		super();
	}
	
	/**
	 * Constructor of FraisLocationAnnuelle.
	 * 
	 * @param gestionParAgence
	 * 
	 * @deprecated
	 */
	@Deprecated
	public FraisLocationAnnuelle(boolean gestionParAgence) {
	
		super();
		this.gestionParAgence = gestionParAgence;
	}
	
	/**
	 * Constructor of FraisLocationAnnuelle.
	 * 
	 * @param fraisGestionLocation
	 * @param gestionParAgence
	 * 
	 * @deprecated
	 */
	@Deprecated
	public FraisLocationAnnuelle(double fraisGestionLocation, boolean gestionParAgence) {
	
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.gestionParAgence = gestionParAgence;
	}
	
	/**
	 * Constructor of FraisLocationAnnuelle.
	 * 
	 * @param fraisGestionLocation
	 * @param chargesLocation
	 * @param gestionParAgence
	 * 
	 * @deprecated
	 */
	@Deprecated
	public FraisLocationAnnuelle(double fraisGestionLocation, double fraisLocation,
			boolean gestionParAgence) {
	
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.fraisLocation = fraisLocation;
		this.gestionParAgence = gestionParAgence;
	}
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the rental expenses.
	 * 
	 * @return a double representing the rental expenses (chargesLocation).
	 */
	public double getFraisLocation() {
	
		return fraisLocation;
	}
	
	/**
	 * Return the real rental expenses.
	 * 
	 * @return a double representing the real rental expenses (chargesLocationReel).
	 * @deprecated
	 */
	@Deprecated
	public double getFraisLocationReel() {
	
		return fraisLocationReel;
	}
	
	/**
	 * Return the rental management expenses (through estate agency).
	 * 
	 * @return a double representing the rental manageemnt expenses
	 * (fraisGestionLocation).
	 */
	public double getFraisGestionLocation() {
	
		return fraisGestionLocation;
	}
	
	/**
	 * Return the real rental management expenses (through estate agency).
	 * 
	 * @return a double representing the real rental management expenses
	 * (fraisGestionLocationReel).
	 * @deprecated
	 */
	@Deprecated
	public double getFraisGestionLocationReel() {
	
		return fraisGestionLocationReel;
	}
	
	/**
	 * Return the decision of managing the rental by estate agency.
	 * 
	 * @return a boolean representing the decision of managing the rental through estate
	 * agency(gestionParAgence).
	 */
	public boolean isGestionParAgence() {
	
		return gestionParAgence;
	}
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the rental expenses.
	 * 
	 * @param fraisLocation the double of the rental expenses to set.
	 */
	public void setFraisLocation(double fraisLocation) {
	
		this.fraisLocation = fraisLocation;
	}
	
	/**
	 * Define the real rental expenses.
	 * 
	 * @param fraisLocationReel the double of the real rental expenses to set.
	 * @deprecated
	 */
	@Deprecated
	public void setFraisLocationReel(double fraisLocationReel) {
	
		this.fraisLocationReel = fraisLocationReel;
	}
	
	/**
	 * Define the rental management expenses.
	 * 
	 * @param fraisGestionLocation the double of the rental management expenses to set.
	 */
	public void setFraisGestionLocation(double fraisGestionLocation) {
	
		this.fraisGestionLocation = fraisGestionLocation;
	}
	
	/**
	 * Define the real rental management expenses.
	 * 
	 * @param fraisGestionLocationReel the double of the real rental management expenses
	 * to set.
	 * @deprecated
	 */
	@Deprecated
	public void setFraisGestionLocationReel(double fraisGestionLocationReel) {
	
		this.fraisGestionLocationReel = fraisGestionLocationReel;
	}
	
	/**
	 * Define the decision to manage the rental through estate agency.
	 * 
	 * @param gestionParAgence the boolean of the decision to set.
	 */
	public void setGestionParAgence(boolean gestionParAgence) {
	
		this.gestionParAgence = gestionParAgence;
	}
	
	//==============================================================================
	//Other methods
	//==============================================================================
	
	@Override
	public String toString() {
	
		return "Frais Location annuels ----------------------------"
				+ "\nLes frais de gestion sont de " + fraisGestionLocation
				+ "\nLes charges de location sont de " + fraisLocation /*
																		 * +
																		 * "\nL'assurance habitation est de "
																		 * +
																		 * gestionParAgence
																		 */;
	}
	
	//TODO Define the methods equal() of the class Bien
}

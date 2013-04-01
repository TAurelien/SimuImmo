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

//TODO Modify the javadoc
/**
 * @author Aurelien Ticot
 *
 */
public class FraisLocationAnnuelle {

	//Déclaration des variables
	//==============================================================================
	private double fraisGestionLocation = 0, fraisLocation;
	private boolean gestionParAgence = true;
	
	//Variables pour la prise en compte des valeurs réelles
	private double fraisGestionLocationReel, fraisLocationReel;

	
	//Constructeurs
	//==============================================================================
	//Constructeur vide	
	/**
	 * 
	 */
	public FraisLocationAnnuelle() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(boolean gestionParAgence) {
		super();
		this.gestionParAgence = gestionParAgence;
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisGestionLocation
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(double fraisGestionLocation, boolean gestionParAgence) {
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.gestionParAgence = gestionParAgence;
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param fraisGestionLocation
	 * @param chargesLocation
	 * @param gestionParAgence
	 */
	public FraisLocationAnnuelle(double fraisGestionLocation,
			double fraisLocation, boolean gestionParAgence) {
		super();
		this.fraisGestionLocation = fraisGestionLocation;
		this.fraisLocation = fraisLocation;
		this.gestionParAgence = gestionParAgence;
	}

	
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the chargesLocation
	 */
	public double getFraisLocation() {
		return fraisLocation;
	}

	/**
	 * @return the chargesLocationReel
	 */
	public double getFraisLocationReel() {
		return fraisLocationReel;
	}

	/**
	 * @return the fraisGestionLocation
	 */
	public double getFraisGestionLocation() {
		return fraisGestionLocation;
	}

	/**
	 * @return the fraisGestionLocationReel
	 */
	public double getFraisGestionLocationReel() {
		return fraisGestionLocationReel;
	}

	/**
	 * @return the gestionParAgence
	 */
	public boolean isGestionParAgence() {
		return gestionParAgence;
	}
	

	//Setters
	//==============================================================================
		
	/**
	 * @param chargesLocation the chargesLocation to set
	 */
	public void setFraisLocation(double fraisLocation) {
		this.fraisLocation = fraisLocation;
	}

	/**
	 * @param chargesLocationReel the chargesLocationReel to set
	 */
	public void setFraisLocationReel(double fraisLocationReel) {
		this.fraisLocationReel = fraisLocationReel;
	}

	/**
	 * @param fraisGestionLocation the fraisGestionLocation to set
	 */
	public void setFraisGestionLocation(double fraisGestionLocation) {
		this.fraisGestionLocation = fraisGestionLocation;
	}

	/**
	 * @param fraisGestionLocationReel the fraisGestionLocationReel to set
	 */
	public void setFraisGestionLocationReel(double fraisGestionLocationReel) {
		this.fraisGestionLocationReel = fraisGestionLocationReel;
	}

	/**
	 * @param gestionParAgence the gestionParAgence to set
	 */
	public void setGestionParAgence(boolean gestionParAgence) {
		this.gestionParAgence = gestionParAgence;
	}

	//==============================================================================
	
	@Override
	public String toString() {
		return "Frais Location annuels ----------------------------" +
				"\nLes frais de gestion sont de " + fraisGestionLocation +
				"\nLes charges de location sont de " + fraisLocation /*+
				"\nL'assurance habitation est de " + gestionParAgence	+ 
				"\nLes frais de travaux annuels sont de " + fraisGestionLocationReel +
				"\nLa taxe d'habitation est de "	+ chargesLocationReel */;	
	}

	//TODO Define the methods equal() of the class Bien
}

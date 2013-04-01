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
public class FraisLocationSaisonniere {

	// Déclaration des variables
	// ==============================================================================
	private double fraisAccueil = 0, fraisMenage = 0,
			fraisGestionSaisonnier = 0, fraisLocationSaisonniere = 0;

	// Variables pour la prise en compte des valeurs réelles
	private double fraisAccueilReel, fraisMenageReel,
			fraisGestionSaisonnierReel, fraisLocationSaisonniereReel;


	// Constructeurs
	// ==============================================================================
	// Constructeur vide
	/**
		 * 
		 */
	public FraisLocationSaisonniere() {
		super();
	}

	//Constructeur avec les valeurs utilisateurs
	/**
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

	// XXX FraisLocationSaisonniere

	// Getters
	// ==============================================================================

	/**
	 * @return the chargesLocationSaisonniere
	 */
	public double getFraisLocationSaisonniere() {
		return fraisLocationSaisonniere;
	}

	/**
	 * @return the chargesLocationSaisonniereReel
	 */
	public double getFraisLocationSaisonniereReel() {
		return fraisLocationSaisonniereReel;
	}

	/**
	 * @return the fraisAccueil
	 */
	public double getFraisAccueil() {
		return fraisAccueil;
	}

	/**
	 * @return the fraisAccueilReel
	 */
	public double getFraisAccueilReel() {
		return fraisAccueilReel;
	}

	/**
	 * @return the fraisGestionSaisonnier
	 */
	public double getFraisGestionSaisonnier() {
		return fraisGestionSaisonnier;
	}

	/**
	 * @return the fraisGestionSaisonnierReel
	 */
	public double getFraisGestionSaisonnierReel() {
		return fraisGestionSaisonnierReel;
	}

	/**
	 * @return the fraisMenage
	 */
	public double getFraisMenage() {
		return fraisMenage;
	}

	/**
	 * @return the fraisMenageReel
	 */
	public double getFraisMenageReel() {
		return fraisMenageReel;
	}

	// Setters
	// ==============================================================================

	/**
	 * @param fraisLocationSaisonniere
	 *            the fraisLocationSaisonniere to set
	 */
	public void setFraisLocationSaisonniere(double fraisLocationSaisonniere) {
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}

	/**
	 * @param fraisLocationSaisonniereReel
	 *            the fraisLocationSaisonniereReel to set
	 */
	public void setFraisLocationSaisonniereReel(
			double fraisLocationSaisonniereReel) {
		this.fraisLocationSaisonniereReel = fraisLocationSaisonniereReel;
	}

	/**
	 * @param fraisAccueil
	 *            the fraisAccueil to set
	 */
	public void setFraisAccueil(double fraisAccueil) {
		this.fraisAccueil = fraisAccueil;
	}

	/**
	 * @param fraisAccueilReel
	 *            the fraisAccueilReel to set
	 */
	public void setFraisAccueilReel(double fraisAccueilReel) {
		this.fraisAccueilReel = fraisAccueilReel;
	}

	/**
	 * @param fraisGestionSaisonnier
	 *            the fraisGestionSaisonnier to set
	 */
	public void setFraisGestionSaisonnier(double fraisGestionSaisonnier) {
		this.fraisGestionSaisonnier = fraisGestionSaisonnier;
	}

	/**
	 * @param fraisGestionSaisonnierReel
	 *            the fraisGestionSaisonnierReel to set
	 */
	public void setFraisGestionSaisonnierReel(double fraisGestionSaisonnierReel) {
		this.fraisGestionSaisonnierReel = fraisGestionSaisonnierReel;
	}

	/**
	 * @param fraisMenage
	 *            the fraisMenage to set
	 */
	public void setFraisMenage(double fraisMenage) {
		this.fraisMenage = fraisMenage;
	}

	/**
	 * @param fraisMenageReel
	 *            the fraisMenageReel to set
	 */
	public void setFraisMenageReel(double fraisMenageReel) {
		this.fraisMenageReel = fraisMenageReel;
	}

	// ==============================================================================

	// 
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
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
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

//TODO Modify the javadoc
/**
 * @author Aurelien Ticot
 *
 */
public class FraisAcquisition {
	
	//Déclaration des variables
	//==============================================================================
	private double prixFAI = 0, netVendeur = 0, fraisAgence = 0, fraisNotaire = 0,
			travaux = 0, amenagement = 0, honoraireConseil = 0, autresFrais = 0,
			coutTotal = 0, apport = 0, sequestre = 0;
	private boolean agence = false, conseil = false;
	
	//variables pour la prise en compte des valeurs réelles
	private double netVendeurReel, fraisAgenceReel, fraisNotaireReel,
			honoraireConseilReel, apportReel;

	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	/**
	 * 
	 */
	public FraisAcquisition() {
		super();
	}
	
	//Constructeur avec les valeurs utilisateurs
	/**
	 * @param prixFAI
	 * @param agence
	 * @param travaux
	 * @param amenagement
	 * @param autresFrais
	 * @param apport
	 * @param conseil
	 */
	public FraisAcquisition(double prixFAI, boolean agence, double travaux, double amenagement,
			double autresFrais, double apport, boolean conseil) {
		super();
		this.prixFAI = prixFAI;
		this.agence = agence;
		this.travaux = travaux;
		this.amenagement = amenagement;
		this.autresFrais = autresFrais;
		this.apport = apport;
		this.conseil = conseil;
	}
	//Constructeur avec toutes les variables sauf les "Reel"
	/**
	 * @param prixFAI
	 * @param agence
	 * @param netVendeur
	 * @param fraisAgence
	 * @param fraisNotaire
	 * @param travaux
	 * @param amenagement
	 * @param conseil
	 * @param honoraireConseil
	 * @param autresFrais
	 * @param coutTotal
	 * @param apport
	 * @param sequestre
	 */
	public FraisAcquisition(double prixFAI, boolean agence, double netVendeur,
			double fraisAgence, double fraisNotaire, double travaux,
			double amenagement, boolean conseil, double honoraireConseil, double autresFrais,
			double coutTotal, double apport, double sequestre) {
		super();
		this.prixFAI = prixFAI;
		this.agence = agence;
		this.netVendeur = netVendeur;
		this.fraisAgence = fraisAgence;
		this.fraisNotaire = fraisNotaire;
		this.travaux = travaux;
		this.amenagement = amenagement;
		this.conseil = conseil;
		this.honoraireConseil = honoraireConseil;
		this.autresFrais = autresFrais;
		this.coutTotal = coutTotal;
		this.apport = apport;
		this.sequestre = sequestre;
	}

	
	
	//Getters
	//==============================================================================

	/**
	 * @return the agence
	 */
	public boolean getAgence() {
		return agence;
	}
	
	/**
	 * @return the amenagement
	 */
	public double getAmenagement() {
		return amenagement;
	}

	/**
	 * @return the apport
	 */
	public double getApport() {
		return apport;
	}

	/**
	 * @return the apportReel
	 */
	public double getApportReel() {
		return apportReel;
	}

	/**
	 * @return the autresFrais
	 */
	public double getAutresFrais() {
		return autresFrais;
	}

	/**
	 * @return the coutTotal
	 */
	public double getCoutTotal() {
		return coutTotal;
	}

	/**
	 * @return the conseil
	 */
	public boolean getConseil() {
		return conseil;
	}	
	
	/**
	 * @return the fraisAgence
	 */
	public double getFraisAgence() {
		return fraisAgence;
	}

	/**
	 * @return the fraisAgenceReel
	 */
	public double getFraisAgenceReel() {
		return fraisAgenceReel;
	}

	/**
	 * @return the fraisNotaire
	 */
	public double getFraisNotaire() {
		return fraisNotaire;
	}

	/**
	 * @return the fraisNotaireReel
	 */
	public double getFraisNotaireReel() {
		return fraisNotaireReel;
	}

	/**
	 * @return the honoraireConseil
	 */
	public double getHonoraireConseil() {
		return honoraireConseil;
	}

	/**
	 * @return the honoraireConseilReel
	 */
	public double getHonoraireConseilReel() {
		return honoraireConseilReel;
	}

	/**
	 * @return the netVendeur
	 */
	public double getNetVendeur() {
		return netVendeur;
	}

	/**
	 * @return the netVendeurReel
	 */
	public double getNetVendeurReel() {
		return netVendeurReel;
	}

	/**
	 * @return the prixFAI
	 */
	public double getPrixFAI() {
		return prixFAI;
	}

	/**
	 * @return the sequestre
	 */
	public double getSequestre() {
		return sequestre;
	}

	/**
	 * @return the travaux
	 */
	public double getTravaux() {
		return travaux;
	}
	
	
	//Setters
	//==============================================================================

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(boolean agence) {
		this.agence = agence;
	}
	
	/**
	 * @param amenagement the amenagement to set
	 */
	public void setAmenagement(double amenagement) {
		this.amenagement = amenagement;
	}

	/**
	 * @param apport the apport to set
	 */
	public void setApport(double apport) {
		this.apport = apport;
	}

	/**
	 * @param apportReel the apportReel to set
	 */
	public void setApportReel(double apportReel) {
		this.apportReel = apportReel;
	}

	/**
	 * @param autresFrais the autresFrais to set
	 */
	public void setAutresFrais(double autresFrais) {
		this.autresFrais = autresFrais;
	}

	/**
	 * @param coutTotal the coutTotal to set
	 */
	public void setCoutTotal(double coutTotal) {
		this.coutTotal = coutTotal;
	}

	/**
	 * @param conseil the conseil to set
	 */
	public void setConseil(boolean conseil) {
		this.conseil = conseil;
	}
	
	/**
	 * @param fraisAgence the fraisAgence to set
	 */
	public void setFraisAgence(double fraisAgence) {
		this.fraisAgence = fraisAgence;
	}

	/**
	 * @param fraisAgenceReel the fraisAgenceReel to set
	 */
	public void setFraisAgenceReel(double fraisAgenceReel) {
		this.fraisAgenceReel = fraisAgenceReel;
	}

	/**
	 * @param fraisNotaire the fraisNotaire to set
	 */
	public void setFraisNotaire(double fraisNotaire) {
		this.fraisNotaire = fraisNotaire;
	}

	/**
	 * @param fraisNotaireReel the fraisNotaireReel to set
	 */
	public void setFraisNotaireReel(double fraisNotaireReel) {
		this.fraisNotaireReel = fraisNotaireReel;
	}

	/**
	 * @param honoraireConseil the honoraireConseil to set
	 */
	public void setHonoraireConseil(double honoraireConseil) {
		this.honoraireConseil = honoraireConseil;
	}

	/**
	 * @param honoraireConseilReel the honoraireConseilReel to set
	 */
	public void setHonoraireConseilReel(double honoraireConseilReel) {
		this.honoraireConseilReel = honoraireConseilReel;
	}

	/**
	 * @param netVendeur the netVendeur to set
	 */
	public void setNetVendeur(double netVendeur) {
		this.netVendeur = netVendeur;
	}

	/**
	 * @param netVendeurReel the netVendeurReel to set
	 */
	public void setNetVendeurReel(double netVendeurReel) {
		this.netVendeurReel = netVendeurReel;
	}

	/**
	 * @param prixFAI the prixFAI to set
	 */
	public void setPrixFAI(double prixFAI) {
		this.prixFAI = prixFAI;
	}

	/**
	 * @param sequestre the sequestre to set
	 */
	public void setSequestre(double sequestre) {
		this.sequestre = sequestre;
	}

	/**
	 * @param travaux the travaux to set
	 */
	public void setTravaux(double travaux) {
		this.travaux = travaux;
	}

	//==============================================================================
	
	@Override
	public String toString() {
		return "Frais d'acquisitions -------------------------------" +
				"\nLe prix FAI est de " + prixFAI +
				"\nLe prix net vendeur est de " + netVendeur +
				"\nLes frais d'agence sont de " + fraisAgence +
				"\nLes frais de notaire sont de " + fraisNotaire +
				"\nLe montant des travaux est de " + travaux +
				"\nLe cout d'amenagement est de " + amenagement +
				"\nLes honoraires de conseil sont de " + honoraireConseil +
				"\nLes autres frais sont de " + autresFrais +
				"\nLe cout total est de " + coutTotal +
				"\nAvec un apport de " + apport +
				"\nLe sequestre sera de " + sequestre /*+
				", netVendeurReel=" + netVendeurReel + ", fraisAgenceReel="
				+ fraisAgenceReel + ", fraisNotaireReel=" + fraisNotaireReel
				+ ", honoraireConseilReel=" + honoraireConseilReel
				+ ", apportReel=" + apportReel + "]"*/;

	}
	
	//TODO Define the methods equal() of the class Bien
	
}

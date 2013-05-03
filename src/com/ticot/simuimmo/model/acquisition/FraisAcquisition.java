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

package com.ticot.simuimmo.model.acquisition;

/**
 * The class FraisAcquisition represents all acquisition costs in a real estate
 * transaction.
 * <p>
 * The class FraisAcquisition is part of the class Acquisition. </br>The loan is
 * represented by the class Emprunt.
 * </p>
 * <p>
 * It's characterized by several variables:
 * <ul>
 * <li>prixFAI: the price of the real estate, agency fees included</li>
 * <li>netVendeur: the net seller price</li>
 * <li>fraisAgence: the agency fees</li>
 * <li>fraisNotaire: the notary fees</li>
 * <li>travaux: the real estate work</li>
 * <li>amenagement: the furnishing of the real estate</li>
 * <li>honoraireConseil: the real estate hunter fees</li>
 * <li>autresFrais: the other costs</li>
 * <li>coutTotal: the overall cost</li>
 * <li>apport: the buyer own contribution</li>
 * <li>sequestre: the deposit</li>
 * <li>agence: the decision to go through real estate agency or not</li>
 * <li>conseil: the decision to go through a real estate hunter or not</li>
 * </ul>
 * </p>
 * 
 * @see Acquisition
 * @see Emprunt
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class FraisAcquisition {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/** The price of the real estate, agency fees included. */
	private double prixFAI = 0;
	
	/** The net seller price. */
	private double netVendeur = 0;
	
	/** The agency fees. */
	private double fraisAgence = 0;
	
	/** The notary fees. */
	private double fraisNotaire = 0;
	
	/** The real estate work. */
	private double travaux = 0;
	
	/** The furnishing of the real estate. */
	private double amenagement = 0;
	
	/** The real estate hunter fees. */
	private double honoraireConseil = 0;
	
	/** The other costs. */
	private double autresFrais = 0;
	
	/** The overall cost. */
	private double coutTotal = 0;
	
	/** The buyer own contribution. */
	private double apport = 0;
	
	/** The deposit. */
	private double sequestre = 0;
	
	/** The decision to go through real estate agency or not. */
	private boolean agence = false;
	
	/** The decision to go through a real estate hunter or not. */
	private boolean conseil = false;
	
	/**
	 * The real net seller price.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double netVendeurReel;
	
	/**
	 * The real agency fees.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double fraisAgenceReel;
	
	/**
	 * The real notary fees.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double fraisNotaireReel;
	
	/**
	 * The real estate hunter real fees.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double honoraireConseilReel;
	
	/**
	 * The real buyer own contribution.
	 * 
	 * @deprecated
	 */
	@Deprecated
	private double apportReel;
	
	//==============================================================================
	//Constructors
	//==============================================================================
	
	/**
	 * Constructor of FraisAcquisition.
	 * <p>
	 * Empty constructor.
	 * </p>
	 */
	public FraisAcquisition() {
	
		super();
	}
	
	/**
	 * Constructor of FraisAcquisition.
	 * <p>
	 * Constructor with all user's inputs.
	 * </p>
	 * 
	 * @param prixFAI
	 * @param agence
	 * @param travaux
	 * @param amenagement
	 * @param autresFrais
	 * @param apport
	 * @param conseil
	 */
	public FraisAcquisition(double prixFAI, boolean agence, double travaux,
			double amenagement, double autresFrais, double apport, boolean conseil) {
	
		super();
		this.prixFAI = prixFAI;
		this.agence = agence;
		this.travaux = travaux;
		this.amenagement = amenagement;
		this.autresFrais = autresFrais;
		this.apport = apport;
		this.conseil = conseil;
	}
	
	/**
	 * Constructor of FraisAcquisition.
	 * <p>
	 * Constructor with all variables except the real variables
	 * </p>
	 * 
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
			double fraisAgence, double fraisNotaire, double travaux, double amenagement,
			boolean conseil, double honoraireConseil, double autresFrais,
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
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the decision to go through a real estate agency.
	 * 
	 * @return a boolean representing the decision to go through a real estate agency
	 * (agence).
	 */
	public boolean getAgence() {
	
		return agence;
	}
	
	/**
	 * Return the furnishing of the real estate.
	 * 
	 * @return a double representing the furnishing of the real estate (amenagement).
	 */
	public double getAmenagement() {
	
		return amenagement;
	}
	
	/**
	 * Return the buyer contribution.
	 * 
	 * @return a double representing the buyer contribution (apport).
	 */
	public double getApport() {
	
		return apport;
	}
	
	/**
	 * Return the real buyer contribution.
	 * 
	 * @return a double representing the real buyer contribution (apportReel).
	 * @deprecated
	 */
	@Deprecated
	public double getApportReel() {
	
		return apportReel;
	}
	
	/**
	 * Return the other costs.
	 * 
	 * @return a double representing the other costs (autresFrais).
	 */
	public double getAutresFrais() {
	
		return autresFrais;
	}
	
	/**
	 * Return the overall cost.
	 * 
	 * @return a double representing the overall cost (coutTotal).
	 */
	public double getCoutTotal() {
	
		return coutTotal;
	}
	
	/**
	 * Return the decision to go through a real estate hunter.
	 * 
	 * @return a boolean representing the decision to go through a real estate hunter
	 * (conseil).
	 */
	public boolean getConseil() {
	
		return conseil;
	}
	
	/**
	 * Return the agency fees.
	 * 
	 * @return a double representing the agency fees (fraisAgence).
	 */
	public double getFraisAgence() {
	
		return fraisAgence;
	}
	
	/**
	 * Return the real agency fees.
	 * 
	 * @return a double representing the real agency fees (fraisAgenceReel).
	 * @deprecated
	 */
	@Deprecated
	public double getFraisAgenceReel() {
	
		return fraisAgenceReel;
	}
	
	/**
	 * Return the notary fees.
	 * 
	 * @return a double representing the notary fees (fraisNotaire).
	 */
	public double getFraisNotaire() {
	
		return fraisNotaire;
	}
	
	/**
	 * Return the real notary fees.
	 * 
	 * @return a double representing the real notary fees (fraisNotaireReel).
	 * @deprecated
	 */
	@Deprecated
	public double getFraisNotaireReel() {
	
		return fraisNotaireReel;
	}
	
	/**
	 * Return the real estate hunter fees.
	 * 
	 * @return a double representing the real estate hunter fees (honoraireConseil).
	 */
	public double getHonoraireConseil() {
	
		return honoraireConseil;
	}
	
	/**
	 * Return the real estate hunter real fees.
	 * 
	 * @return a double representing the real estate hunter real fees
	 * (honoraireConseilReel).
	 * @deprecated
	 */
	@Deprecated
	public double getHonoraireConseilReel() {
	
		return honoraireConseilReel;
	}
	
	/**
	 * Return the net seller price.
	 * 
	 * @return a double representing the net seller price (netVendeur).
	 */
	public double getNetVendeur() {
	
		return netVendeur;
	}
	
	/**
	 * Return the real net seller price.
	 * 
	 * @return a double representing the real net seller price (netVendeurReel).
	 * @deprecated
	 */
	@Deprecated
	public double getNetVendeurReel() {
	
		return netVendeurReel;
	}
	
	/**
	 * Return the price of the real estate, agency fees included.
	 * 
	 * @return a double representing the price of the real estate, agency fees included
	 * (prixFAI).
	 */
	public double getPrixFAI() {
	
		return prixFAI;
	}
	
	/**
	 * Return the deposit.
	 * 
	 * @return a double representing the deposit (sequestre).
	 */
	public double getSequestre() {
	
		return sequestre;
	}
	
	/**
	 * Return the real estate necessary work.
	 * 
	 * @return a double representing the necessary work in the real estate (travaux).
	 */
	public double getTravaux() {
	
		return travaux;
	}
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the decision to go through a real estate agency.
	 * 
	 * @param agence the boolean of the decision to set.
	 */
	public void setAgence(boolean agence) {
	
		this.agence = agence;
	}
	
	/**
	 * Define the furnishing of the real estate.
	 * 
	 * @param amenagement the double of the furnishing to set.
	 */
	public void setAmenagement(double amenagement) {
	
		this.amenagement = amenagement;
	}
	
	/**
	 * Define the buyer contribution.
	 * 
	 * @param apport the double of the buyer conrtribution to set.
	 */
	public void setApport(double apport) {
	
		this.apport = apport;
	}
	
	/**
	 * Define the real buyer contribution.
	 * 
	 * @param apportReel the double of the buyer contribution to set.
	 * @deprecated
	 */
	@Deprecated
	public void setApportReel(double apportReel) {
	
		this.apportReel = apportReel;
	}
	
	/**
	 * define the other costs.
	 * 
	 * @param autresFrais the double of the other costs to set.
	 */
	public void setAutresFrais(double autresFrais) {
	
		this.autresFrais = autresFrais;
	}
	
	/**
	 * Define the overall cost.
	 * 
	 * @param coutTotal the double of the overall cost to set.
	 */
	public void setCoutTotal(double coutTotal) {
	
		this.coutTotal = coutTotal;
	}
	
	/**
	 * define the decision to go through a real estate hunter.
	 * 
	 * @param conseil the boolean of the decision to set.
	 */
	public void setConseil(boolean conseil) {
	
		this.conseil = conseil;
	}
	
	/**
	 * Define the agency fees.
	 * 
	 * @param fraisAgence the double of the agency fees to set.
	 */
	public void setFraisAgence(double fraisAgence) {
	
		this.fraisAgence = fraisAgence;
	}
	
	/**
	 * Define the real agency fees.
	 * 
	 * @param fraisAgenceReel the double of the real agency fees to set.
	 * @deprecated
	 */
	@Deprecated
	public void setFraisAgenceReel(double fraisAgenceReel) {
	
		this.fraisAgenceReel = fraisAgenceReel;
	}
	
	/**
	 * Define the notary fees.
	 * 
	 * @param fraisNotaire the double of the notary fees to set.
	 */
	public void setFraisNotaire(double fraisNotaire) {
	
		this.fraisNotaire = fraisNotaire;
	}
	
	/**
	 * Define the real notary fees.
	 * 
	 * @param fraisNotaireReel the double of the real notary fees to set.
	 * @deprecated
	 */
	@Deprecated
	public void setFraisNotaireReel(double fraisNotaireReel) {
	
		this.fraisNotaireReel = fraisNotaireReel;
	}
	
	/**
	 * Define the real estate hunter fees.
	 * 
	 * @param honoraireConseil the double of the real estate fees to set.
	 */
	public void setHonoraireConseil(double honoraireConseil) {
	
		this.honoraireConseil = honoraireConseil;
	}
	
	/**
	 * Define the real estate hunter real fees.
	 * 
	 * @param honoraireConseilReel the double of the real estate hunter real fees to set.
	 * @deprecated
	 */
	@Deprecated
	public void setHonoraireConseilReel(double honoraireConseilReel) {
	
		this.honoraireConseilReel = honoraireConseilReel;
	}
	
	/**
	 * Define the net seller price.
	 * 
	 * @param netVendeur the double of the net seller price to set.
	 */
	public void setNetVendeur(double netVendeur) {
	
		this.netVendeur = netVendeur;
	}
	
	/**
	 * Define the real net seller price.
	 * 
	 * @param netVendeurReel the double of the real net seller price to set.
	 * @deprecated
	 */
	@Deprecated
	public void setNetVendeurReel(double netVendeurReel) {
	
		this.netVendeurReel = netVendeurReel;
	}
	
	/**
	 * Define the price of the real estate, agency fees included.
	 * 
	 * @param prixFAI the double of the price of the real estate to set.
	 */
	public void setPrixFAI(double prixFAI) {
	
		this.prixFAI = prixFAI;
	}
	
	/**
	 * Define the deposit of the transaction.
	 * 
	 * @param sequestre the double of the deposit to set.
	 */
	public void setSequestre(double sequestre) {
	
		this.sequestre = sequestre;
	}
	
	/**
	 * Define the necessary work of the real estate.
	 * 
	 * @param travaux the double of the necessary work to set.
	 */
	public void setTravaux(double travaux) {
	
		this.travaux = travaux;
	}
	
	//==============================================================================
	//Other methods
	//==============================================================================
	
	@Override
	public String toString() {
	
		return "=== Frais d'acquisitions ===" + "\nLe prix FAI est de " + prixFAI
				+ "\nLe prix net vendeur est de " + netVendeur
				+ "\nLes frais d'agence sont de " + fraisAgence
				+ "\nLes frais de notaire sont de " + fraisNotaire
				+ "\nLe montant des travaux est de " + travaux
				+ "\nLe cout d'amenagement est de " + amenagement
				+ "\nLes honoraires de conseil sont de " + honoraireConseil
				+ "\nLes autres frais sont de " + autresFrais + "\nLe cout total est de "
				+ coutTotal + "\nAvec un apport de " + apport + "\nLe sequestre sera de "
				+ sequestre;
		
	}
	
	//TODO Define the methods equal() of the class Bien
	
}

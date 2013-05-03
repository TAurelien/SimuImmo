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

package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.Settings;
import com.ticot.simuimmo.model.gestion.ChargesAnnuelles;
import com.ticot.simuimmo.model.gestion.FraisLocationAnnuelle;
import com.ticot.simuimmo.model.gestion.FraisLocationSaisonniere;
import com.ticot.simuimmo.model.gestion.Gestion;
import com.ticot.simuimmo.model.gestion.RecetteLocative;

/**
 * The class CalculsGestion aggregates all the necessary calculations for the management
 * part of the real estate.
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class CalculsGestion {
	
	
	//==============================================================================
	//Fonctions pour la la classe Gestion
	//==============================================================================
	
	/**
	 * Method to launch the calcul of "ChargesAnnuelles", "FraisLocationAnnuelle",
	 * "FraisLocationSaisonniere" and "RecetteLocative".
	 * 
	 * @return an instance of Gestion.
	 * 
	 * @see ChargesAnnuelles
	 * @see FraisLocationAnnuelle
	 * @see FraisLocationSaisonniere
	 * @see RecetteLocative
	 * 
	 * @since 1.0
	 */
	public static Gestion initialiser() {
	
		final ChargesAnnuelles chargesAnnuelles = calculerChargesAnnuelles();
		final FraisLocationAnnuelle fraisLocationAnnuelle = calculerFraisLocationAnnuelle();
		final FraisLocationSaisonniere fraisLocationSaisonniere = calculerFraisLocationSaisonniere();
		final RecetteLocative recetteLocative = calculerRecetteLocative();
		return new Gestion(Inputs.typeGestion, chargesAnnuelles, fraisLocationAnnuelle,
				fraisLocationSaisonniere, recetteLocative);
	}
	
	/**
	 * Method to compute RecetteLocative.
	 * 
	 * @return an instance of RecetteLocative.
	 * 
	 * @see RecetteLocative
	 * 
	 * @since 1.0
	 */
	public static RecetteLocative calculerRecetteLocative() {
	
		final RecetteLocative rl = new RecetteLocative(Inputs.loyerNu,
				Inputs.loyerMeuble, Inputs.loyerNuit, Inputs.vacLocAnnuelle,
				Inputs.vacLocSaisonnier);
		rl.setLoyerSaisonnier(calculLoyerSaisonnier(rl.getLoyerNuit(),
				rl.getVacLocSaisonnier()));
		rl.setRecetteLocative(calculRecetteLocative(Inputs.typeGestion, rl.getLoyerNu(),
				rl.getLoyerMeuble(), rl.getLoyerNuit(), rl.getVacLocAnnuelle(),
				rl.getVacLocSaisonnier()));
		return rl;
	}
	
	/**
	 * Method to compute ChargesAnnuelles.
	 * 
	 * @return an instance of ChargesAnnuelles.
	 * 
	 * @see ChargesAnnuelles
	 * 
	 * @since 1.0
	 */
	public static ChargesAnnuelles calculerChargesAnnuelles() {
	
		final ChargesAnnuelles ca = new ChargesAnnuelles(Inputs.chargesFixes,
				Inputs.taxeFonciere, Inputs.assuranceLocation, Inputs.travauxAnnuels,
				Inputs.taxeHabitation);
		ca.setCharges(calculChargesAnnuelles(ca.getChargesFixes(), ca.getTaxeFonciere(),
				ca.getAssuranceLocation(), ca.getTravauxAnnuels(), ca.getTaxeHabitation()));
		return ca;
	}
	
	/**
	 * Method to compute FraisLocationAnnuelle.
	 * 
	 * @return an instance of FraisLocationAnnuelle.
	 * 
	 * @see FraisLocationAnnuelle
	 * 
	 * @since 1.0
	 */
	public static FraisLocationAnnuelle calculerFraisLocationAnnuelle() {
	
		final FraisLocationAnnuelle fla = new FraisLocationAnnuelle(
				Inputs.gestionParAgence);
		//TODO evaluer s'il est judicieux de mettre le type de gestion dans le fonction de calcul 
		fla.setFraisGestionLocation(calculFraisGestion(Inputs.loyerNu,
				Inputs.loyerMeuble, Inputs.vacLocAnnuelle));
		fla.setFraisLocation(calculFraisLocationAnnuelle(Inputs.typeGestion,
				fla.getFraisGestionLocation(), Inputs.taxeHabitation)); //TODO Prendre la taxe d'habitation depuis l'objet ChargesAnnuelles
		return fla;
	}
	
	/**
	 * Method to compute FraisLocationSaisonniere.
	 * 
	 * @return an instance of FraisLocationSaisonniere.
	 * 
	 * @see FraisLocationSaisonniere
	 * 
	 * @since 1.0
	 */
	public static FraisLocationSaisonniere calculerFraisLocationSaisonniere() {
	
		final FraisLocationSaisonniere fls = new FraisLocationSaisonniere();
		fls.setFraisAccueil(calculFraisAccueil(Inputs.vacLocSaisonnier));
		fls.setFraisMenage(calculFraisMenage(Inputs.vacLocSaisonnier));
		fls.setFraisGestionSaisonnier(calculFraisGestionSaisonnier());
		fls.setFraisLocationSaisonniere(calculFraisLocationSaisonier(
				fls.getFraisAccueil(), fls.getFraisMenage(),
				fls.getFraisGestionSaisonnier()));
		return fls;
	}
	
	//==============================================================================
	//Functions for the RecetteLocative 
	//==============================================================================
	
	/**
	 * Method to compute the seasonal rent, per month.
	 * 
	 * @param loyerNuit a double of the seasonal rent, per night.
	 * @param vacLocSaisonnier an integer of the rental vacancy in seasonal rent, in night
	 * per month.
	 * 
	 * @return a double representing the seasonal rent, per month (loyerSaisonnier).
	 * 
	 * @see RecetteLocative
	 * 
	 * @since 1.0
	 */
	public static double calculLoyerSaisonnier(double loyerNuit, int vacLocSaisonnier) {
	
		double ls = 0;
		if (vacLocSaisonnier < Settings.nuitsParMois) {
			ls = loyerNuit * (Settings.nuitsParMois - vacLocSaisonnier);
		}
		return ls;
	}
	
	/**
	 * Method to compute the rental income, for a year.
	 * 
	 * @param typeGestion an integer of the type of management.
	 * @param loyerNu a double of the plain rent, per month.
	 * @param loyerMeuble a double of the furnished rent, per month.
	 * @param loyerNuit a double of the seasonal rent, per night.
	 * @param vacLocAnnuelle an integer of the rental vacancy, in month per year.
	 * @param vacLocSaisonnier an integer of the rental vacancy in seasonal rent, in night
	 * per month.
	 * 
	 * @return a double representing the rental income, for a year (recetteLocative).
	 * 
	 * @see RecetteLocative
	 * 
	 * @since 1.0
	 */
	public static double calculRecetteLocative(int typeGestion, double loyerNu,
			double loyerMeuble, double loyerNuit, int vacLocAnnuelle, int vacLocSaisonnier) {
	
		double rl = 0;
		
		//TODO Check whether it's a good idea to use the type of management in the methode 
		switch (typeGestion) {
			case 0: //0 = "Location nue"
				rl = loyerNu * (Settings.moisParAn - vacLocAnnuelle);
				break;
			case 1: //1 = "Location meublee"
				rl = loyerMeuble * (Settings.moisParAn - vacLocAnnuelle);
				break;
			case 2: //2 = "Location saisonniere"
				rl = loyerNuit * (Settings.nuitsParMois - vacLocSaisonnier)
						* Settings.moisParAn;
				break;
			case 3: //3 = "Residence principale"
				rl = 0;
				break;
			default: //Au cas ou, je redefinis en location meublee
				Inputs.typeGestion = 1;
				rl = loyerMeuble * (Settings.moisParAn - vacLocAnnuelle);
				break;
		}
		
		return rl;
	}
	
	//==============================================================================
	//Functions for the ChargesAnnuelles
	//==============================================================================
	
	/**
	 * Method to compute the total annual expenses.
	 * 
	 * @param chargesFixes a double of the fixed expenses (condominium).
	 * @param taxeFonciere a double of the French property tax.
	 * @param assuranceLocation a double of the rental insurance costs.
	 * @param travauxAnnuels a double of the annual work costs.
	 * @param taxeHabitation a double of the French housing tax.
	 * 
	 * @return a double representing the total annual expenses (charges).
	 * 
	 * @see ChargesAnnuelles
	 * 
	 * @since 1.0
	 */
	public static double calculChargesAnnuelles(double chargesFixes, double taxeFonciere,
			double assuranceLocation, double travauxAnnuels, double taxeHabitation) {
	
		return chargesFixes + taxeFonciere + assuranceLocation + travauxAnnuels
				+ taxeHabitation;
	}
	
	//==============================================================================
	//Functions for the FraisLocationAnnuelles
	//==============================================================================
	
	/**
	 * Method to compute the expenses for the management through estate agency.
	 * 
	 * @param loyerNu a double of the plain rent, per month.
	 * @param loyerMeuble a double of the furnished rent, per month.
	 * @param vacanceLoc an integer of the rental vacancy, in month per year.
	 * 
	 * @return a double representing the expenses for the management through estate agency
	 * (fraisGestionLocation).
	 * 
	 * @see FraisLocationAnnuelles
	 * 
	 * @since 1.0
	 */
	public static double calculFraisGestion(double loyerNu, double loyerMeuble,
			int vacanceLoc) {
	
		double fa = 0;
		if (Inputs.typeGestion == 0) {
			fa = Settings.fraisGestionAgence * loyerNu
					* (Settings.moisParAn - vacanceLoc);
		}
		else if (Inputs.typeGestion == 1) {
			fa = Settings.fraisGestionAgence * loyerMeuble
					* (Settings.moisParAn - vacanceLoc);
		}
		else {
			fa = 0;
		}
		return fa;
	}
	
	/**
	 * Method to compute the total expense of the rental.
	 * 
	 * @param typeGestion an integer of the type of management.
	 * @param fraisGestionAgence a double of the expense for the management through estate
	 * agency.
	 * @param taxeHabitation a double of the French housing tax.
	 * 
	 * @return a double representing the total expense of th rental (fraisLocation).
	 * 
	 * @see FraisLocationAnnuelle
	 * 
	 * @since 1.0
	 */
	public static double calculFraisLocationAnnuelle(int typeGestion,
			double fraisGestionAgence, double taxeHabitation) {
	
		double cla = 0;
		if ((typeGestion == 0) || (typeGestion == 1)) {
			cla = fraisGestionAgence - taxeHabitation;
		}
		return cla;
	}
	
	//==============================================================================
	//Functions for the FraisLocationSaisonniere
	//==============================================================================
	
	/**
	 * Method to compute the welcoming expense in seasonal rental.
	 * 
	 * @param vacanceLoc a double of the rental vacancy in seasonal rent, in night per
	 * month.
	 * 
	 * @return a double representing the welcoming expense (fraisAccueil).
	 * 
	 * @see FraisLocationSaisonniere
	 * 
	 * @since 1.0
	 */
	public static double calculFraisAccueil(int vacanceLoc) {
	
		return ((Settings.moisParAn * (Settings.nuitsParMois - vacanceLoc)) / Settings.dureeSejourSaisonnier)
				* Settings.fraisAccueilSaisonnier;
	}
	
	/**
	 * Method to compute the cleaning expense in seasonal rental.
	 * 
	 * @param vacanceLoc a double of the rental vacancy in seasonal rent, in night per
	 * month.
	 * 
	 * @return a double reprenseting the cleaning expense (fraisMenage).
	 * 
	 * @see FraisLocationSaisonniere
	 * 
	 * @since 1.0
	 */
	public static double calculFraisMenage(int vacanceLoc) {
	
		return ((Settings.moisParAn * (Settings.nuitsParMois - vacanceLoc)) / Settings.dureeSejourSaisonnier)
				* Settings.fraisMenageSaisonnier;
	}
	
	/**
	 * Method to compute the management expense, in seasonal rental.
	 * 
	 * @return a double representing the management expense, in seasonal rental.
	 * 
	 * @see FraisLocationSaisonniere
	 * 
	 * @since 1.0
	 */
	public static double calculFraisGestionSaisonnier() {
	
		return Settings.moisParAn * Settings.fraisGestionMensuel;
	}
	
	/**
	 * Method to compute the overall cost of the seasonal rental.
	 * 
	 * @param fraisAccueil a double of the welcoming expense in seasonal rental.
	 * @param fraisMenage a dbouel of the cleaning expense in seasonal rental.
	 * @param fraisGestionSaisonnier a double of the management expense, in seasonal
	 * rental.
	 * 
	 * @return a double representing the overal cost in seasonal rental
	 * (fraisLocationSaisonniere).
	 * 
	 * @see FraisLocationSaisonniere
	 * 
	 * @since 1.0
	 */
	public static double calculFraisLocationSaisonier(double fraisAccueil,
			double fraisMenage, double fraisGestionSaisonnier) {
	
		double fls = 0;
		if (Inputs.typeGestion == 2) {
			fls = fraisAccueil + fraisMenage + fraisGestionSaisonnier;
		}
		return fls;
	}
}

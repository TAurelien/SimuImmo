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

package com.ticot.simuimmo.model;

/**
 * The class Settings is used to store some variables from preferences while running.
 * <p>All computation are done based on value from this Settings class.</br>
 * This is not the SharedPreferences, even though all values come from the SharedPreferences.</p>
 * <p>The variables don't represent the user's inputs, there is a dedicated class Inputs for them.</p>
 * 
 * @see Inputs
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Settings {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	//=== Acquisition ==============================================================
	
	/**Percentage of the estate agency fees while buying a real estate.*/
	public static double pourcentageFraisAgence = 0.075;
	
	/**Percentage of the notary fees while buying a real estate.*/
	public static double pourcentageFraisNotaire = 0.075;
	
	/**Percentage of the real estate hunter while buying a real estate.*/
	public static double pourcentageHonorairesConseil = 0.08;
	
	/**Rate of the loan with a duration of 15 years.*/
	public static double taux15ans = 0.0318;
	
	/**Rate of the loan with a duration of 20 years.*/
	public static double taux20ans = 0.034;
	
	/**Rate of the loan with a duration of 25 years.*/
	public static double taux25ans = 0.0365;
	
	/**Rate of the loan with a duration of 30 years.*/
	public static double taux30ans = 0.044;
	
	/**Rate of the credit insurance.*/
	public static double tauxAssuranceCredit = 0.0036;
	
	/**Percentage of the deposit while buying a real estate.*/
	public static double pourcentageSequestre = 0.1;
	
	/**Percentage of buying below the market.*/
	public static double achatSousMarche = 0.3;
	
	/**Net monthly income used to compute the debt ratio*/
	public static double revenuMensuelNet = 2500;
	
	/**Other monthly income used to compute the debt ratio.*/
	public static double autresRevenus = 0;
	
	/**Other monthly credit used to compute the debt ratio.*/
	public static double autresCredit = 0;
	
	//=== Gestion ==================================================================
	
	/**Number of months per year.*/
	public static int moisParAn = 12;
	
	/**Number of nights per month, used in seasonal rental.*/
	public static int nuitsParMois = 30;
	
	/**Number of nights per year, used in seasonal rental.*/
	public static int nuitsParAn = 365;
	
	/**Average length of stay, in days.*/
	public static int dureeSejourSaisonnier = 5;
	
	/**Unitary costs of welcome in seasonal rental.*/
	public static double fraisAccueilSaisonnier = 25;
	
	/**Unitary costs of cleaning in seasonal rental.*/
	public static double fraisMenageSaisonnier = 10;
	
	/**Monthly management costs in seasonal rental.*/
	public static double fraisGestionMensuel = 20;
	
	/**Annual evolution of the rent.*/
	public static double augmentationLoyer = 0.01;
	
	/**Annual evolution of the expenses.*/
	public static double augmentationCharges = 0.02;
	
	/**Rental management by an estate agency.*/
	public static double fraisGestionAgence = 0.06;
	
	/**Maximum monthly credit expected in Main Home.*/
	public static double maxMensualitéRP = 900;
	
	//=== Imposition ===============================================================
	
	/**Tax allowance of income in the French regim "micro foncier".*/
	public static double abattementMicroFoncier = 0.3;
	
	/**Limit of income in the French regim "microBIC".*/
	public static double limiteRegimeMicro = 32000;
	
	/**Limit of income in the French regim "micro foncier".*/
	public static double limiteRegimeMicroFoncier = 15000;
	
	/**Tax allowance of income in the French regim "micro BIC".*/
	public static double abattementMicroBIC = 0.5;
	
	/**Tax allowance of income in the French regim "meublé classé de tourisme".*/
	public static double abattementClasseTourisme = 0.71;
	
	/**Tax rate for the French "CSG CRDS".*/
	public static double tauxCSG = 0.155;
	
	/**Depreciation rate of real estate = 85% of the value.*/
	public static double tauxAmortissementBien = 0.85;
	
	/**Depreciation duration of real estate = usualy 30 years.*/
	public static int dureeAmortissementBien = 30;
	
	/**Depreciation duration of the furnishing = usualy 10 years.*/
	public static int dureeAmortissmentMeubles = 10;
	
	/**decision to take into account the French regim "classé de tourisme". True = Yes.*/
	public static boolean priseEnCompteClasseTourisme = false;
	
	//=== CashFlow =================================================================
	
	/**Maximum of monthly negative cash flow. (positive value to set)*/
	public static double maxCashFlowNeg = 500;
	
	//=== Revente ==================================================================
	
	/**Evolution of the real estate prices, in percentage per year.*/
	public static double evoPrixImmobilier = 0.01;
	
	/**Estimation of the sell above the market.*/
	public static double reventeAuDessusMarche = 0.1;
	
	/**Minimum of capital gain expected while selling in Main Home.*/
	public static double minPlusValueRP = 20000;
	
	/**Tax rate of the capital gain.*/
	public static double tauxImpotPlusValue = 0.19;
	
}

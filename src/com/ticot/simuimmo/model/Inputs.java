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
 * The class Inputs is used as a temporary class to store the user's inputs.
 * <p>All computations are base on values from this inputs class.</p>
 * <p><The variables don't represent the user's preferences, there is a dedicated Settings class for them.</p>
 * 
 * @see Settings
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Inputs {

	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	//=== Acquisition ==============================================================
	
	/**Temporary: user's input.</br>
	 * The price of the real estate, agency fees included.*/
	public static double prixFAI = 0;
	
	/**Temporary: user's input.</br>
	 * Choice to buy through an estate agency*/
	public static boolean agence = false; 
	
	/**Temporary: user's input.</br>
	 * The real estate work.*/
	public static double travaux = 0;
	
	/**Temporary: user's input.</br>
	 * The furnishing of the real estate.*/
	public static double amenagement = 0;
	
	/**Temporary: user's input.</br>
	 * The decision to go through a real estate hunter or not.*/
	public static boolean conseil = false;
	
	/**Temporary: user's input.</br>
	 * The buyer own contribution.*/
	public static double apport = 0;
	
	/**Temporary: user's input.</br>
	 * The other costs.*/
	public static double autresFrais = 0;
	
	/**Temporary: user's input.</br>
	 * The duration of the loan.*/
	public static int dureeCredit = 0;

	/**Temporary: user's input.</br>
	 * The net seller price.*/
	public static double netVendeur = 0; 
	
	/**Temporary: user's input.</br>
	 * The agency fees.*/
	public static double fraisAgence = 0;
	
	/**Temporary: user's input.</br>
	 * The notary fees.*/
	public static double fraisNotaire = 0;
	
	/**Temporary: user's input.</br>
	 * The real estate hunter fees.*/
	public static double honoraireConseil = 0;
	
	/**Temporary: user's input.</br>
	 * The borrowed capital.*/
	public static double capitalEmprunte = 0;
	
	/**Temporary: user's input.</br>
	 * The rate of the loan.*/
	public static double tauxCredit = 0;
	
	/**Temporary: user's input.</br>
	 * The credit insurrance rate.*/
	public static double tauxAssuranceCredit = 0;
	
	/**Temporary: user's input.</br>
	 * Real value for net seller price.*/
	public static boolean reelNetvendeur = false;
	
	/**Temporary: user's input.</br>
	 * Real value for agency fees.*/
	public static boolean reelFraisAgence = false;
	
	/**Temporary: user's input.</br>
	 * Real value for notary fees.*/
	public static boolean reelFraisNotaire = false;
	
	/**Temporary: user's input.</br>
	 * Real value for hunter fees.*/
	public static boolean reelHonoraireConseil = false;
	
	/**Temporary: user's input.</br>
	 * Real value for borrowed capital.*/
	public static boolean reelCapitalEmrpunte = false;
	
	/**Temporary: user's input.</br>
	 * Real value for loan rate.*/
	public static boolean reelTauxCredit = false;
	
	/**Temporary: user's input.</br>
	 * Real value for loan insurance rate.*/
	public static boolean reelTauxAssurance = false;
	
	//=== Gestion ==================================================================
	
	/**Temporary: user's input.</br>
	 * Type of management.
	 * (plain rental - 0, furnished rental - 1, seasonal rental - 2 or main home - 3)*/
	public static int typeGestion = 1;
	
	/**Temporary: user's input.</br>
	 * The plain rent, per month.*/
	public static double loyerNu = 850;
	
	/**Temporary: user's input.</br>
	 * The furnished rent, per month.*/
	public static double loyerMeuble = 1150;
	
	/**Temporary: user's input.</br>
	 * The seasonal rent, per night.*/
	public static double loyerNuit = 100;
	
	/**Temporary: user's input.</br>
	 * The rental vacancy, in month per year.
	 * <p>Not used for seasonal rental.</p>*/
	public static int vacLocAnnuelle = 1;
	
	/**Temporary: user's input.</br>
	 * The rental vacancy in seasonal rent, in night per month.
	 * <p>Not used for plain and furnished rental.</p>*/
	public static int vacLocSaisonnier = 10;
	
	/**Temporary: user's input.</br>
	 * The fixed expenses (condominium).*/
	public static double chargesFixes = 1176;
	
	/**Temporary: user's input.</br>
	 * The French property tax.*/
	public static double taxeFonciere = 300;
	
	/**Temporary: user's input.</br>
	 * The rental insurance costs.*/
	public static double assuranceLocation = 60; 
	
	/**Temporary: user's input.</br>
	 * The annual work costs.*/
	public static double travauxAnnuels = 0;
	
	/**Temporary: user's input.</br>
	 * The French housing tax.*/
	public static double taxeHabitation = 300;
	
	/**Temporary: user's input.</br>
	 * The decision to manage through estate agency*/
	public static boolean gestionParAgence = true;
	
	/**Temporary: user's input.</br>
	 * The total annual expenses.*/
	public static double charges = 0;
	
	/**Temporary: user's input.</br>
	 * The expenses for the management through estate agency.*/
	public static double fraisGestionLocation = 0;
	
	/**Temporary: user's input.</br>
	 * The expenses for the rental (ad).*/
	public static double fraisLocation = 0;
	
	/**Temporary: user's input.</br>
	 * The welcoming expense.*/
	public static double fraisAccueil = 0; 
	
	/**Temporary: user's input.</br>
	 * The cleaning expense.*/
	public static double fraisMenage = 0;
	
	/**Temporary: user's input.</br>
	 * The management expense, in seasonal.*/
	public static double fraisGestionSaisonnier = 0;
	
	/**Temporary: user's input.</br>
	 * The overal cost.*/
	public static double fraisLocationSaisonniere = 0;
	
	//=== Imposition ===============================================================
	
	/**Temporary: user's input.</br>
	 * The tax rate.
	 */
	public static double tauxMarginal = 0;
	
	/**Temporary: user's input.</br>
	 * The accountant fees.
	 */
	public static double fraisComptable = 0;
	
	//=== CashFlow =================================================================
	
	/**Temporary: user's input.</br>
	 * The current rent.
	 */
	public static double loyerActuel = 0;
	
	//=== Revente ==================================================================
	
	/**Temporary: user's input.</br>
	 * The estimated sell after ..years.
	 */
	public static int reventeAprès = 0; 
	
	/**Temporary: user's input.</br>
	 * The estimated value of the real estate while selling. 
	 */
	public static double valeurRevente = 0;
	
}
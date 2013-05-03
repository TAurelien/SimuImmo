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
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

/**
 * The class CalculsAcquisition aggregates all the necessary calculations for the
 * Acquisition part of the transaction.
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class CalculsAcquisition {
	
	
	//==============================================================================
	//Functions for the class Acquisition
	//==============================================================================
	
	/**
	 * Method to launch the calcul of "FraisAcquisition" and "Emprunt"
	 * 
	 * @return an instance of Acquisition.
	 * 
	 * @since 1.0
	 */
	public static Acquisition initialiser() {
	
		final FraisAcquisition fraisAcquisition = calculerFraisAcquisitions();
		final Emprunt emprunt = calculerEmprunt(fraisAcquisition);
		return new Acquisition(fraisAcquisition, emprunt);
	}
	
	/**
	 * Function to compute FraisAcquisition.
	 * 
	 * @return an instance of FraisAcquisition.
	 * 
	 * @since 1.0
	 */
	public static FraisAcquisition calculerFraisAcquisitions() {
	
		//constructor for FraisAcquisition
		final FraisAcquisition fa = new FraisAcquisition(Inputs.prixFAI, Inputs.agence,
				Inputs.travaux, Inputs.amenagement, Inputs.autresFrais, Inputs.apport,
				Inputs.conseil);
		
		if (Inputs.reelNetvendeur && !Inputs.reelFraisAgence) {
			fa.setNetVendeur(Inputs.netVendeur);
			fa.setFraisAgence(fa.getPrixFAI() - fa.getNetVendeur());
		}
		
		if (Inputs.reelFraisAgence && !Inputs.reelNetvendeur) {
			fa.setFraisAgence(Inputs.fraisAgence);
			fa.setNetVendeur(fa.getPrixFAI() - fa.getFraisAgence());
		}
		
		if (!Inputs.reelNetvendeur && !Inputs.reelFraisAgence) {
			fa.setNetVendeur(calculNetVendeur(Inputs.prixFAI, fa.getAgence(),
					Settings.pourcentageFraisAgence));
			fa.setFraisAgence(calculFraisAgence(fa.getNetVendeur(), fa.getAgence(),
					Settings.pourcentageFraisAgence));
		}
		
		if (Inputs.reelNetvendeur && Inputs.reelFraisAgence) {
			fa.setNetVendeur(Inputs.netVendeur);
			fa.setFraisAgence(Inputs.fraisAgence);
			fa.setPrixFAI(fa.getNetVendeur() + fa.getFraisAgence()); //TODO Could be simplified
		}
		
		//Set FraisNotaire according to computed or user filled
		if (Inputs.reelFraisNotaire) {
			fa.setFraisNotaire(Inputs.fraisNotaire);
		}
		else {
			fa.setFraisNotaire(calculFraisNotaire(fa.getNetVendeur(),
					Settings.pourcentageFraisNotaire));
		}
		
		//Set HonoraireConseil according to computed or user filled
		if (Inputs.reelHonoraireConseil) {
			fa.setHonoraireConseil(Inputs.honoraireConseil);
		}
		else {
			fa.setHonoraireConseil(calculHonorairesConseil(fa.getConseil(),
					fa.getNetVendeur(), fa.getTravaux(), fa.getAmenagement(),
					Settings.pourcentageHonorairesConseil));
		}
		
		//Set CoutTotal according to formula
		fa.setCoutTotal(calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),
				fa.getFraisNotaire(), fa.getTravaux(), fa.getAmenagement(),
				fa.getHonoraireConseil(), fa.getAutresFrais()));
		
		//Set Sequestre according to formula
		fa.setSequestre(calculSequestre(fa.getPrixFAI(), Settings.pourcentageSequestre));
		return fa;
	}
	
	/**
	 * Function to compute Emprunt.
	 * 
	 * @param fa an instance of FraisAcquisition.
	 * 
	 * @return an instance of Emprunt.
	 * 
	 * @since 1.0
	 */
	public static Emprunt calculerEmprunt(FraisAcquisition fa) {
	
		//Constructor for Emprunt
		final Emprunt emprunt = new Emprunt(Inputs.dureeCredit);
		
		//
		if (Inputs.reelTauxAssurance) {
			emprunt.setTauxAssuranceCredit(Inputs.tauxAssuranceCredit);
		}
		else {
			emprunt.setTauxAssuranceCredit(Settings.tauxAssuranceCredit);
		}
		
		emprunt.setNbMensualiteCredit(calculNbMensualiteCredit(emprunt.getDureeCredit()));
		
		if (Inputs.reelCapitalEmrpunte) {
			emprunt.setCapitalEmprunte(Inputs.capitalEmprunte);
		}
		else {
			emprunt.setCapitalEmprunte(calculCapitalEmprunte(fa.getCoutTotal(),
					fa.getApport()));
		}
		
		if (Inputs.reelTauxCredit) {
			emprunt.setTauxCredit(Inputs.tauxCredit);
		}
		else {
			emprunt.setTauxCredit(calculTauxCredit(emprunt.getDureeCredit()));
		}
		
		emprunt.setMensualiteCredit(calculMensualiteCredit(emprunt.getCapitalEmprunte(),
				emprunt.getNbMensualiteCredit(), emprunt.getTauxCredit(),
				emprunt.getTauxAssuranceCredit()));
		
		emprunt.setTauxEndettement(0); //TODO Update after creation of the method for TauxEndettement 
		
		emprunt.setCredit(calculCredit(emprunt.getCapitalEmprunte(),
				emprunt.getNbMensualiteCredit(), emprunt.getTauxCredit(),
				emprunt.getTauxAssuranceCredit(), emprunt.getMensualiteCredit()));
		emprunt.setCreditAn(calculCreditAn(emprunt.getCredit(), emprunt.getDureeCredit()));
		
		return emprunt;
	}
	
	//==============================================================================
	//Functions for the FraisAcquisition
	//==============================================================================
	
	/**
	 * Method to compute the overall cost of the transaction (CoutTotal).
	 * 
	 * @param netVendeur a double of the net seller price.
	 * @param fraisAgence a double of the agency fees.
	 * @param fraisNotaire a double of the notary fees.
	 * @param travaux a double of the necessary work for the real estate.
	 * @param amenagement a double of the furnishing of the real estate.
	 * @param honoraireConseil a double of the real estate hunter fees.
	 * @param autresFrais a double of the other fees.
	 * 
	 * @return a double of the overall cost of the transaction.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculCoutTotal(double netVendeur, double fraisAgence,
			double fraisNotaire, double travaux, double amenagement,
			double honoraireConseil, double autresFrais) {
	
		return netVendeur + fraisAgence + fraisNotaire + travaux + amenagement
				+ honoraireConseil + autresFrais;
	}
	
	/**
	 * Method to compute the net seller price (NetVendeur).
	 * 
	 * @param prixFAI a double of the price of the real estate.
	 * @param agence a boolean of the decision to go through an estate agency.
	 * @param pourcentageFraisAgence a double of the agency fees rate.
	 * 
	 * @return a double representing the net seller price.
	 * 
	 * @see FraisAcquisition
	 */
	public static double calculNetVendeur(double prixFAI, boolean agence,
			double pourcentageFraisAgence) {
	
		if (agence) {
			return prixFAI / (1 + pourcentageFraisAgence);
		}
		else {
			return prixFAI;
		}
	}
	
	/**
	 * Method to compute the agency fees (FraisAgence).
	 * 
	 * @param netVendeur a double of the net seller price.
	 * @param agence a boolean of the decision to go through an estate agency.
	 * @param pourcentageFraisAgence a double of the agency fees rate.
	 * 
	 * @return a double representing the agency fees.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculFraisAgence(double netVendeur, boolean agence,
			double pourcentageFraisAgence) {
	
		//According to the choice of going through estate agency or not
		if (agence) {
			return netVendeur * pourcentageFraisAgence;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Method to compute PrixFAI
	 * 
	 * @param netVendeur a double of the net seller price.
	 * @param fraisAgence a double of the agency fees.
	 * 
	 * @return a double representing the price of the real estate, agency fees included.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculPrixFAI(double netVendeur, double fraisAgence) {
	
		return netVendeur + fraisAgence;
	}
	
	/**
	 * Method to compute the notary fees (FraisNotaire).
	 * 
	 * @param netVendeur a double of the net seller price of the real estate.
	 * @param pourcentageFraisNotaire a double of the rate of the notary fees.
	 * 
	 * @return a double representing the notary fees.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculFraisNotaire(double netVendeur,
			double pourcentageFraisNotaire) {
	
		return netVendeur * pourcentageFraisNotaire;
	}
	
	/**
	 * Method to compute the fees of the real estate hunter (HonorairesConseil).
	 * 
	 * @param conseil a boolean of the decision to go through a real estate hunter.
	 * @param netVendeur a double of the the net seller price.
	 * @param travaux a double of the necessary work of the real estate.
	 * @param amenagement a double of the necessary furnishing for the real estate.
	 * @param pourcentageHonorairesConseil a double of the percentage for the fees of the
	 * hunter.
	 * 
	 * @return a double representing the fezes of the real estate hunter.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculHonorairesConseil(boolean conseil, double netVendeur,
			double travaux, double amenagement, double pourcentageHonorairesConseil) {
	
		//According to the decision to go through a real estate hunter
		if (conseil == true) {
			//If yes, the fees is the rate times the total of net seller price + the work + the furnishing
			//I consider the hunter also help for the work and the furnishing as well as the purchase.
			return (netVendeur + travaux + amenagement) * pourcentageHonorairesConseil;
		}
		else {
			return 0d;
		}
	}
	
	/**
	 * Method to compute the deposit while buying a real estate (Sequestre).
	 * 
	 * @param prixFAI a double of the price of the real estate, agency fees included.
	 * @param pourcentageSequestre a double of the percentage of deposit.
	 * 
	 * @return a double representing the deposit.
	 * 
	 * @see FraisAcquisition
	 * 
	 * @since 1.0
	 */
	public static double calculSequestre(double prixFAI, double pourcentageSequestre) {
	
		return prixFAI * pourcentageSequestre;
	}
	
	//==============================================================================
	//Functions for the Emprunt
	//==============================================================================
	
	/**
	 * Method to get an estimated value of the loan rate (TauxCredit).
	 * <p>
	 * Based on the settings values.
	 * </p>
	 * 
	 * @param dureeCredit an integer of the duration of the loan.
	 * 
	 * @return a double representing the loan rate.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double calculTauxCredit(int dureeCredit) {
	
		//TODO Change the calculation by setting the more close value according to the duration
		switch (dureeCredit) {
		//According to the value of DureeCredit
			case 15:
				return Settings.taux15ans;
			case 20:
				return Settings.taux20ans;
			case 25:
				return Settings.taux25ans;
			case 30:
				return Settings.taux30ans;
			default:
				return Settings.taux25ans;
		}
	}
	
	/**
	 * Method to compute the value of the monthly credit (MensualiteCredit).
	 * 
	 * @param capitalEmprunte a double of the borrowing capital.
	 * @param nbMensualiteCredit an integer of the number of monthly credit.
	 * @param taux a double of the loan rate.
	 * @param tauxAssurance a double of the loan insurance rate.
	 * 
	 * @return a double representing the value of the monthly credit.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double calculMensualiteCredit(double capitalEmprunte,
			int nbMensualiteCredit, double taux, double tauxAssurance) {
	
		return (((capitalEmprunte * taux) / 12) / (1 - Math.pow((1 + (taux / 12)),
				(-nbMensualiteCredit)))) + ((capitalEmprunte * tauxAssurance) / 12);
	}
	
	/**
	 * Method to compute the number of monthly credit (NbMensualite).
	 * 
	 * @param dureeCredit an integer of the duration of the loan.
	 * 
	 * @return an integer representing the number of monthly credit of the loan.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static int calculNbMensualiteCredit(int dureeCredit) {
	
		return dureeCredit * 12;
	}
	
	/**
	 * Method to compute the borrowing capital of the loan (CapitalEmprunte).
	 * 
	 * @param coutTotal a double of the overall cost of the transaction.
	 * @param apport a double of the the buyer contribution.
	 * 
	 * @return a double representing the borrowing capital.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double calculCapitalEmprunte(double coutTotal, double apport) {
	
		return coutTotal - apport;
	}
	
	/**
	 * Method to compute the details of the loan, per month (Credit).
	 * 
	 * @param capitalEmprunte a double of the borrowing capital.
	 * @param nbMensualiteCredit an integer of the number of monthly credit.
	 * @param taux a double of the loan rate.
	 * @param tauxAssurance a double of the loan insurance rate.
	 * @param mensualiteCredit a double of the value of the monthly credit.
	 * 
	 * @return a table of double representing the details of the loan, per month.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double[][] calculCredit(double capitalEmprunte, int nbMensualiteCredit,
			double taux, double tauxAssurance, double mensualiteCredit) {
	
		final double[][] credit = new double[(nbMensualiteCredit + 1)][7];
		int i = 0, j = 0;
		
		//Initialize line 0 of the table with value 0
		for (i = 0; i < 7; i++) {
			credit[0][i] = 0;
		}
		
		//Initialize the first line of the table
		credit[1][0] = 1;
		credit[1][1] = 1;
		credit[1][2] = mensualiteCredit;
		credit[1][3] = (capitalEmprunte * tauxAssurance) / 12;
		credit[1][4] = capitalEmprunte;
		credit[1][5] = (credit[1][4] * taux) / 12;
		credit[1][6] = credit[1][2] - credit[1][3] - credit[1][5];
		
		//Calculate the different values for each Echeance 
		j = 2;
		for (i = 2; i < (nbMensualiteCredit + 1); i++) {
			
			//Column Annee, set the information of Annee, +1 each 12 Echeance
			if (j > 12) {
				credit[i][0] = credit[i - 1][0] + 1;
				j = 2;
			}
			else {
				credit[i][0] = credit[i - 1][0];
				j++;
			}
			
			//Column Echeance
			credit[i][1] = i;
			//Column Mensualite
			credit[i][2] = credit[i - 1][2];
			//Column Assurance part of the Mensualite
			credit[i][3] = (capitalEmprunte * tauxAssurance) / 12;
			//Column Capital restant du
			credit[i][4] = credit[i - 1][4] - credit[i - 1][6];
			//Column Interet d'emprunt
			credit[i][5] = (credit[i][4] * taux) / 12;
			//Column Remboursement Capital
			credit[i][6] = credit[i][2] - credit[i][3] - credit[i][5];
		}
		
		return credit;
	}
	
	/**
	 * Method to compute the details of the loan, per year (CreditAn).
	 * 
	 * @param credit the table of the details of the laon, per month.
	 * @param dureeCredit the duration opf the loan.
	 * 
	 * @return a table of double representing the details of the loan, per year.
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double[][] calculCreditAn(double credit[][], int dureeCredit) {
	
		//Set a table for the Credit per year, each line is a single year
		final double[][] creditAn = new double[(dureeCredit + 1)][7];
		int i = 0, j = 0;
		
		//Initialize line 0 of the table with value 0
		for (i = 0; i < 7; i++) {
			credit[0][i] = 0;
		}
		
		//Set for each line the total value of each Echeance for 1 year, except for the column 0 and 1
		for (i = 1; i < (dureeCredit + 1); i++) {
			//Column Annee
			creditAn[i][0] = i;
			//Column Echeance
			creditAn[i][1] = i * 12;
			for (j = ((i - 1) * 12) + 1; j < ((i * 12) + 1); j++) {
				//Column Mensualite
				creditAn[i][2] = creditAn[i][2] + credit[j][2];
				//Column Assurance part of the Mensualite
				creditAn[i][3] = creditAn[i][3] + credit[j][3];
				//Column Capital restant du
				creditAn[i][4] = credit[j][4];
				//Column Interet d'emprunt
				creditAn[i][5] = creditAn[i][5] + credit[j][5];
				//Column Remboursement Capital
				creditAn[i][6] = creditAn[i][6] + credit[j][6];
			}
		}
		
		return creditAn;
	}
	
	/**
	 * Method to compute TauxEndettement
	 * 
	 * @return
	 * 
	 * @see Emprunt
	 * 
	 * @since 1.0
	 */
	public static double calculTauxEndettement() {
	
		//TODO Create the methods for the calculation of the TauxEndettement
		return 0;
	}
}

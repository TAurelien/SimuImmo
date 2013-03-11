package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Settings;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

/**
 * @author Aurelien Ticot
 *
 */
public class CalculsAcquisition {
	
	//Functions for the class Acquisition
	//==============================================================================
	//Function to launch the calcul of "FraisAcquisition" and "Emprunt"
	public static Acquisition initialiser(){
		FraisAcquisition fraisAcquisition = calculerFraisAcquisitions();
		Emprunt emprunt = calculerEmprunt(fraisAcquisition);
		return new Acquisition(fraisAcquisition, emprunt); 
	}
	
	//Function to compute FraisAcquisition
	public static FraisAcquisition calculerFraisAcquisitions(){
		//constructor for FraisAcquisition
		FraisAcquisition fa = new FraisAcquisition(Inputs.prixFAI, Inputs.agence, Inputs.travaux, Inputs.amenagement, Inputs.autresFrais, Inputs.apport, Inputs.conseil);
		
		//Set NetVendeur according to computed or user filled
		if (Inputs.reelNetvendeur)
			fa.setNetVendeur(Inputs.netVendeur);
		else
			fa.setNetVendeur(calculNetVendeur(Inputs.prixFAI,fa.getAgence(), Settings.pourcentageFraisAgence));
		
		//Set FraisAgence according to computed or user filled
		if (Inputs.reelFraisAgence)
			fa.setFraisAgence(Inputs.fraisAgence);
		else
			fa.setFraisAgence(calculFraisAgence(fa.getNetVendeur(),fa.getAgence(), Settings.pourcentageFraisAgence));
		
		//Set PrixFAI
		fa.setPrixFAI(calculPrixFAI(fa.getNetVendeur(), fa.getFraisAgence()));
		
		//Set FraisNotaire according to computed or user filled
		if (Inputs.reelFraisNotaire){
			fa.setFraisNotaire(Inputs.fraisNotaire);
			System.out.println("Frais de notaire: " + Inputs.fraisNotaire + "\n" + fa.getFraisNotaire());
		}
		else
			fa.setFraisNotaire(calculFraisNotaire(fa.getNetVendeur(), Settings.pourcentageFraisNotaire));
		
		//Set HonoraireConseil according to computed or user filled
		if (Inputs.reelHonoraireConseil)
			fa.setHonoraireConseil(Inputs.honoraireConseil);
		else
			fa.setHonoraireConseil(calculHonorairesConseil(fa.getConseil(), fa.getNetVendeur(),fa.getTravaux(), fa.getAmenagement(),Settings.pourcentageHonorairesConseil));
		
		//
		fa.setCoutTotal(calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),fa.getFraisNotaire(), fa.getTravaux(),fa.getAmenagement(), fa.getHonoraireConseil(),fa.getAutresFrais()));
		
		//
		fa.setSequestre(calculSequestre(fa.getPrixFAI(), Settings.pourcentageSequestre));
		return fa;
	}

	//Function to compute Emprunt
	public static Emprunt calculerEmprunt(FraisAcquisition fa){
		//Constructor for Emprunt
		Emprunt emprunt = new Emprunt(Inputs.dureeCredit);
		
		//
		if (Inputs.reelTauxAssurance)
			emprunt.setTauxAssuranceCredit(Inputs.tauxAssuranceCredit);
		else
			emprunt.setTauxAssuranceCredit(Settings.tauxAssuranceCredit);
		
		
		emprunt.setNbMensualiteCredit(calculNbMensualiteCredit(emprunt.getDureeCredit()));
		
		if (Inputs.reelCapitalEmrpunte)
			emprunt.setCapitalEmprunte(Inputs.capitalEmprunte);
		else
			emprunt.setCapitalEmprunte(calculCapitalEmprunte(fa.getCoutTotal(), fa.getApport()));
		
		if (Inputs.reelTauxCredit)
			emprunt.setTauxCredit(Inputs.tauxCredit);
		else
			emprunt.setTauxCredit(calculTauxCredit(emprunt.getDureeCredit()));
		
		
		emprunt.setMensualiteCredit(calculMensualiteCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), 
				emprunt.getTauxCredit(), emprunt.getTauxAssuranceCredit()));
		
		emprunt.setTauxEndettement(0); //TODO Update after creation of the method for TauxEndettement 

		emprunt.setCredit(calculCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), emprunt.getTauxCredit(),
				emprunt.getTauxAssuranceCredit(), emprunt.getMensualiteCredit()));
		emprunt.setCreditAn(calculCreditAn(emprunt.getCredit(),emprunt.getDureeCredit()));

		return emprunt;
	}
	//==============================================================================
	
	
	//Functions for the part FraisAcquisition
	//==============================================================================
	//Method to compute CoutTotal
	public static double calculCoutTotal(double netVendeur, double fraisAgence, double fraisNotaire, 
			double travaux, double amenagement, double honoraireConseil, double autresFrais){
		return netVendeur + fraisAgence + fraisNotaire + travaux + amenagement + honoraireConseil + autresFrais;
	}
	
	//Method to compute NetVendeur
	public static double  calculNetVendeur(double prixFAI, boolean agence, double pourcentageFraisAgence){
		if (agence)		//According to the choice of going through estate agency or not
			return  prixFAI/(1 + pourcentageFraisAgence);
		else
			return prixFAI;
	}

	//Method to compute FraisAgence
	public static double  calculFraisAgence(double netVendeur, boolean agence, double pourcentageFraisAgence){
		if (agence)
			return  netVendeur * pourcentageFraisAgence;
		else
			return 0;
	}

	//Method to compute PrixFAI
	public static double  calculPrixFAI(double netVendeur, double fraisAgence){
			return  netVendeur + fraisAgence;
	}
	
	//Method to compute FraisNotaire
	public static double  calculFraisNotaire(double netVendeur, double pourcentageFraisNotaire){
		return  netVendeur * pourcentageFraisNotaire;
	}
	
	//Method to compute HonorairesConseil
	public static double calculHonorairesConseil(boolean conseil, double netVendeur, double travaux, 
			double amenagement, double pourcentageHonorairesConseil){
		if (conseil == true)	//According to the choice of Conseil or not set by the user
			return (netVendeur + travaux + amenagement) * pourcentageHonorairesConseil;
		else
			return 0d;	//If no Conseil, so HonorairesConseil equal zero
	}
	
	//Method to compute Sequestre
	public static double  calculSequestre(double prixFAI, double pourcentageSequestre){
		return  prixFAI * pourcentageSequestre;
	}	
	
	//==============================================================================
	
	
	
	//Functions for the part Emprunt
	//==============================================================================
	//Method to compute TauxCredit
	public static double calculTauxCredit(int dureeCredit){
		switch (dureeCredit) {		//According to the value of DureeCredit
		case 15:
			return  Settings.taux15ans;
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
	
	//Method to compute MensualiteCredit
	public static double calculMensualiteCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance){
		return (capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMensualiteCredit))) + (capitalEmprunte * tauxAssurance/12);
	}
	
	//Method to compute NbMensualite
	public static int calculNbMensualiteCredit(int dureeCredit){
		return dureeCredit * 12;
	}
	
	//Method to compute CapitalEmprunte
	public static double calculCapitalEmprunte(double coutTotal, double apport){
		return coutTotal - apport;
	}
	
	//Method to compute Credit
	
	public static double[][] calculCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance, double mensualiteCredit){
		double[][] credit = new double[(nbMensualiteCredit + 1)][7];
		int i = 0, j = 0;
		
		for (i = 0; i < 7; i++)
		{
			credit[0][i] = 0;
		}
		
		credit[1][0] = 1;
		credit[1][1] = 1;
		credit[1][2] = mensualiteCredit;
		credit[1][3] = capitalEmprunte * tauxAssurance /12;
		credit[1][4] = capitalEmprunte;
		credit[1][5] = credit[1][4] * taux /12;
		credit[1][6] = credit[1][2] - credit[1][3] - credit[1][5];
		//System.out.println(credit[1][0] + " " + credit[1][1] + " " + credit[1][2] + " " + credit[1][3] + " " + credit[1][4] + " " + credit[1][5] + " " + credit[1][6]);
		
		j = 2;
		for (i = 2; i < nbMensualiteCredit + 1; i++)
		{
			if (j > 12)
			{
				credit[i][0] = credit[i-1][0] + 1;
				j = 2;
			}
			else
			{
				credit[i][0] = credit[i-1][0];
				j++;
			}			
			credit[i][1] = i;
			credit[i][2] = credit[i-1][2];
			credit[i][3] = capitalEmprunte * tauxAssurance /12;
			credit[i][4] = credit[i-1][4] - credit[i-1][6];
			credit[i][5] = credit[i][4] * taux /12;
			credit[i][6] = credit[i][2] - credit[i][3] - credit[i][5];
			//System.out.println(credit[i][0] + " " + credit[i][1] + " " + credit[i][2] + " " + credit[i][3] + " " + credit[i][4] + " " + credit[i][5] + " " + credit[i][6]);
		}
		
		return credit;
	}
	
	//Method to compute Credit
	public static double[][] calculCreditAn(double credit[][], int dureeCredit){
		//TODO Make the calculation fo the CreditAn
		double[][] creditAn = new double[(dureeCredit + 1)][7];
		int i = 0, j = 0;
		
		for (i = 0; i < 7; i++)
		{
			credit[0][i] = 0;
		}
		
		for (i = 1; i < dureeCredit + 1; i++)
		{
			creditAn[i][0] = i;
			creditAn[i][1] = i * 12;
			for (j = ((i - 1) * 12) + 1; j < i * 12 + 1; j++)
			{
				creditAn[i][2] = creditAn[i][2] + credit[j][2];
				creditAn[i][3] = creditAn[i][3] + credit[j][3];
				creditAn[i][4] = credit[j][4];
				creditAn[i][5] = creditAn[i][5] + credit[j][5];
				creditAn[i][6] = creditAn[i][6] + credit[j][6];
			}
			//System.out.println(creditAn[i][0] + " " + creditAn[i][1] + " " + creditAn[i][2] + " " + creditAn[i][3] + " " + creditAn[i][4] + " " + creditAn[i][5] + " " + creditAn[i][6]);
		}
		
		return creditAn;
	}
	
	//TODO Create the methods for the calculation of the TauxEndettement
	
	//==============================================================================
	
}

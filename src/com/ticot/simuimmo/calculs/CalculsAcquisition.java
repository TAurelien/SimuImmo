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
		FraisAcquisition fa = new FraisAcquisition(Inputs.prixFAI, Inputs.agence, Inputs.travaux, Inputs.amenagement, Inputs.autresFrais, Inputs.apport, Inputs.conseil);
		fa.setNetVendeur(calculNetVendeur(Inputs.prixFAI,fa.getAgence(), Settings.pourcentageFraisAgence));
		fa.setFraisAgence(calculFraisAgence(fa.getNetVendeur(),fa.getAgence(), Settings.pourcentageFraisAgence));
		fa.setPrixFAI(calculPrixFAI(fa.getNetVendeur(), fa.getFraisAgence()));
		fa.setFraisNotaire(calculFraisNotaire(fa.getNetVendeur(), Settings.pourcentageFraisNotaire));
		fa.setHonoraireConseil(calculHonorairesConseil(fa.getConseil(), fa.getNetVendeur(),fa.getTravaux(), fa.getAmenagement(),Settings.pourcentageHonorairesConseil));
		fa.setCoutTotal(calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),fa.getFraisNotaire(), fa.getTravaux(),fa.getAmenagement(), fa.getHonoraireConseil(),fa.getAutresFrais()));
		fa.setSequestre(calculSequestre(fa.getPrixFAI(), Settings.pourcentageSequestre));
		return fa;
	}

	//Function to compute Emprunt
	public static Emprunt calculerEmprunt(FraisAcquisition fa){
		Emprunt emprunt = new Emprunt(Inputs.dureeCredit);
		emprunt.setTauxAssuranceCredit(Settings.tauxAssuranceCredit);
		emprunt.setNbMensualiteCredit(calculNbMensualiteCredit(emprunt.getDureeCredit()));
		emprunt.setCapitalEmprunte(calculCapitalEmprunte(fa.getCoutTotal(), fa.getApport()));
		emprunt.setTauxCredit(calculTauxCredit(emprunt.getDureeCredit()));
		emprunt.setMensualiteCredit(calculMensualiteCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), 
				emprunt.getTauxCredit(), emprunt.getTauxAssuranceCredit()));
		emprunt.setTauxEndettement(0); //TODO Update after creation of the method for TauxEndettement 
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
	
	//TODO Create the methods for the calculation of the TauxEndettement
	
	//==============================================================================
	
}

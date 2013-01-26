package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Settings;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

public class CalculsAcquisition {
	
	//Fonctions pour la partie Frais acquisition
	//==============================================================================
	//Fonction pour lancer les calculs de frais d'acquisition et d'emprunt
	public static Acquisition initialiser(){
		FraisAcquisition fraisAcquisition = calculerFraisAcquisitions();
		Emprunt emprunt = calculerEmprunt(fraisAcquisition);
		return new Acquisition(fraisAcquisition, emprunt); 
	}
	
	//Fonction pour calculer les frais acquisition
	public static FraisAcquisition calculerFraisAcquisitions(){
		FraisAcquisition fa = new FraisAcquisition(Inputs.prixFAI, Inputs.travaux, Inputs.amenagement, Inputs.autresFrais, Inputs.apport, Inputs.conseil);
		fa.setNetVendeur(calculNetVendeur(fa.getPrixFAI(), Settings.pourcentageFraisAgence));
		fa.setFraisAgence(calculFraisAgence(fa.getPrixFAI(), fa.getNetVendeur()));
		fa.setFraisNotaire(calculFraisNotaire(fa.getNetVendeur(), Settings.pourcentageFraisNotaire));
		fa.setHonoraireConseil(calculHonorairesConseil(fa.getConseil(), fa.getNetVendeur(),fa.getTravaux(), fa.getAmenagement(),Settings.pourcentageHonorairesConseil));
		fa.setCoutTotal(calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),fa.getFraisNotaire(), fa.getTravaux(),fa.getAmenagement(), fa.getHonoraireConseil(),fa.getAutresFrais()));
		fa.setSequestre(calculSequestre(fa.getPrixFAI(), Settings.pourcentageSequestre));
		return fa;
	}

	//Fonction pour calculer l'emprunt
	public static Emprunt calculerEmprunt(FraisAcquisition fa){
		Emprunt emprunt = new Emprunt(Inputs.dureeCredit);
		emprunt.setTauxAssuranceCredit(Settings.tauxAssuranceCredit);
		emprunt.setNbMensualiteCredit(calculNbMensualiteCredit(emprunt.getDureeCredit()));
		emprunt.setCapitalEmprunte(calculCapitalEmprunte(fa.getCoutTotal(), fa.getApport()));
		emprunt.setTauxCredit(calculTauxCredit(emprunt.getDureeCredit()));
		emprunt.setMensualiteCredit(calculMensualiteCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), 
				emprunt.getTauxCredit(), emprunt.getTauxAssuranceCredit()));
		emprunt.setTauxEndettement(0); //TODO Mettre à jour après calcul du taux d'endettement
		return emprunt;
	}
	//==============================================================================
	
	
	//Fonctions pour la partie Frais acquisition
	//==============================================================================
	//Calcul du cout total
	public static double calculCoutTotal(double netVendeur, double fraisAgence, double fraisNotaire, 
			double travaux, double amenagement, double honoraireConseil, double autresFrais){
		return netVendeur + fraisAgence + fraisNotaire + travaux + amenagement + honoraireConseil + autresFrais;
	}
	
	//Calcul du Net vendeur
	public static double  calculNetVendeur(double prixFAI, double pourcentageFraisAgence){
		return  Math.round(prixFAI/(1 + pourcentageFraisAgence)/100)*100;
	}

	//Calcul des frais d'agence
	public static double  calculFraisAgence(double prixFAI, double netVendeur){
		return  prixFAI - netVendeur;
	}

	//Calcul des frais de notaire
	public static double  calculFraisNotaire(double netVendeur, double pourcentageFraisNotaire){
		return  Math.round(netVendeur * pourcentageFraisNotaire/10)*10;
	}
	
	//Calcul des honoraires de conseils
	public static double calculHonorairesConseil(boolean conseil, double netVendeur, double travaux, 
			double amenagement, double pourcentageHonorairesConseil){
		if (conseil == true)
			return (netVendeur + travaux + amenagement) * pourcentageHonorairesConseil;
		else
			return 0d;
	}
	
	//Calcul du sequestre
	public static double  calculSequestre(double prixFAI, double pourcentageSequestre){
		return  Math.round(prixFAI * pourcentageSequestre /10)*10;
	}	
	
	//==============================================================================
	
	
	
	//Fonctions pour la partie Emprunt
	//==============================================================================
	//Calcul du taux de credit
	public static double calculTauxCredit(int dureeCredit){
		switch (dureeCredit) {
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
	
	//Calcul de la mensualité de credit
	public static double calculMensualiteCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance){
		return Math.round(((capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMensualiteCredit))) + (capitalEmprunte * tauxAssurance/12))*100)/100;
	}
	
	//Calcul du nombre de mensualite
	public static int calculNbMensualiteCredit(int dureeCredit){
		return dureeCredit * 12;
	}
	
	//Calcul du capital emprunté
	public static double calculCapitalEmprunte(double coutTotal, double apport){
		return Math.round((coutTotal - apport)/10)*10;
	}
	
	//TODO Calcul du taux d'endettement à faire
	
	//==============================================================================
	
}

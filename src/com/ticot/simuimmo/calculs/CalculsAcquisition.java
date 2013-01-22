package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Settings;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

public class CalculsAcquisition {
	
	//Fonctions pour la partie Frais acquisition
	//Statut OK
	//==============================================================================
	//Fonction pour lancer les calculs de frais d'acquisition et d'emprunt
	//Fonction OK
	public static Acquisition initialiser(){
		FraisAcquisition fraisAcquisition = calculerFraisAcquisitions();
		Emprunt emprunt = calculerEmprunt(fraisAcquisition);
		return new Acquisition(fraisAcquisition, emprunt); 
	}
	
	//Fonction pour calculer les frais acquisition
	//Fonction OK
	public static FraisAcquisition calculerFraisAcquisitions(){
		FraisAcquisition fa = new FraisAcquisition(Inputs.prixFAI, Inputs.travaux, Inputs.amenagement, Inputs.autresFrais, Inputs.apport, Inputs.conseil);
		fa.setNetVendeur(CalculsAcquisition.calculNetVendeur(fa.getPrixFAI(), Settings.pourcentageFraisAgence));
		fa.setFraisAgence(CalculsAcquisition.calculFraisAgence(fa.getPrixFAI(), fa.getNetVendeur()));
		fa.setFraisNotaire(CalculsAcquisition.calculFraisNotaire(fa.getNetVendeur(), Settings.pourcentageFraisNotaire));
		fa.setHonoraireConseil(CalculsAcquisition.calculHonorairesConseil(fa.getConseil(), fa.getNetVendeur(),fa.getTravaux(), fa.getAmenagement(),Settings.pourcentageHonorairesConseil));
		fa.setCoutTotal(CalculsAcquisition.calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),fa.getFraisNotaire(), fa.getTravaux(),fa.getAmenagement(), fa.getHonoraireConseil(),fa.getAutresFrais()));
		fa.setSequestre(CalculsAcquisition.calculSequestre(fa.getPrixFAI(), Settings.pourcentageSequestre));
		return fa;
	}

	//Fonction pour calculer l'emprunt
	//Fonction OK
	public static Emprunt calculerEmprunt(FraisAcquisition fa){
		Emprunt emprunt = new Emprunt(Inputs.dureeCredit);
		emprunt.setTauxAssuranceCredit(Settings.tauxAssuranceCredit);
		emprunt.setNbMensualiteCredit(CalculsAcquisition.calculNbMensualiteCredit(emprunt.getDureeCredit()));
		emprunt.setCapitalEmprunte(CalculsAcquisition.calculCapitalEmprunte(fa.getCoutTotal(), fa.getApport()));
		emprunt.setTauxCredit(CalculsAcquisition.calculTauxCredit(emprunt.getDureeCredit()));
		emprunt.setMensualitéCredit(CalculsAcquisition.calculMensualiteCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), 
				emprunt.getTauxCredit(), emprunt.getTauxAssuranceCredit()));
		emprunt.setTauxEndettement(0); //TODO Mettre à jour après calcul du taux d'endettement
		return emprunt;
	}
	//==============================================================================
	
	
	//Fonctions pour la partie Frais acquisition
	//Statut OK
	//==============================================================================
	//Calcul du cout total
	//Fonction OK
	public static double calculCoutTotal(double netVendeur, double fraisAgence, double fraisNotaire, 
			double travaux, double amenagement, double honoraireConseil, double autresFrais){
		return netVendeur + fraisAgence + fraisNotaire + travaux + amenagement + honoraireConseil + autresFrais;
	}
	
	//Calcul du Net vendeur
	//Fonction OK
	public static double  calculNetVendeur(double prixFAI, double pourcentageFraisAgence){
		return  Math.round(prixFAI/(1 + pourcentageFraisAgence)/100)*100;
	}

	//Calcul des frais d'agence
	//Fonction OK
	public static double  calculFraisAgence(double prixFAI, double netVendeur){
		return  prixFAI - netVendeur;
	}

	//Calcul des frais de notaire
	//Fonction OK
	public static double  calculFraisNotaire(double netVendeur, double pourcentageFraisNotaire){
		return  Math.round(netVendeur * pourcentageFraisNotaire/10)*10;
	}
	
	//Calcul des honoraires de conseils
	//Fonction OK
	public static double calculHonorairesConseil(boolean conseil, double netVendeur, double travaux, 
			double amenagement, double pourcentageHonorairesConseil){
		if (conseil == true)
			return (netVendeur + travaux + amenagement) * pourcentageHonorairesConseil;
		else
			return 0d;
	}
	
	//Calcul du sequestre
	//Fonction OK
	public static double  calculSequestre(double prixFAI, double pourcentageSequestre){
		return  Math.round(prixFAI * pourcentageSequestre /10)*10;
	}	
	
	//==============================================================================
	
	
	
	//Fonctions pour la partie Emprunt
	//Staut OK
	//==============================================================================
	//Calcul du taux de credit
	//Fonction OK
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
	//Fonction OK
	public static double calculMensualiteCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance){
		return Math.round(((capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMensualiteCredit))) + (capitalEmprunte * tauxAssurance/12))*100)/100;
	}
	
	//Calcul du nombre de mensualite
	//Fonction OK
	public static int calculNbMensualiteCredit(int dureeCredit){
		return dureeCredit * 12;
	}
	
	//Calcul du capital emprunté
	//Fonction OK
	public static double calculCapitalEmprunte(double coutTotal, double apport){
		return Math.round((coutTotal - apport)/10)*10;
	}
	
	//TODO Calcul du taux d'endettement à faire
	
	//==============================================================================
	
}

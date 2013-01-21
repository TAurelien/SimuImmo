package com.ticot.simuimmo.calculs;

public class CalculsAcquisition {
	
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
	public static double calculTauxCredit(int dureeCredit, double taux15ans, double taux20ans, double taux25ans, double taux30ans){
		switch (dureeCredit) {
		case 15:
			return  taux15ans;
		case 20:
			return taux20ans;
		case 25:
			return taux25ans;
		case 30:
			return taux30ans;
		default:
			return taux25ans;
		}
	}
	
	//Calcul de la mensualité de credit
	//Fonction OK
	public static double calculMensualiteCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance){
		return (capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMensualiteCredit))) + (capitalEmprunte * tauxAssurance/12);
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
	//==============================================================================
	
}

package com.ticot.simuimmo.calculs;

//Classe temporaire pour les tests de calculs


public class Temp {

	String tag = "Test";
	//Log.d(tag,"In the onCreate() event");
	
	//Fonction pour lancer les tests
	//==============================================================================
	public static void aTester(){
		
		//Déclaration des variables de tests
		//==========================================================================
		//Celles renseignées par l'utilisateur
		int dureeCredit = 30;
		double prixFAI = 137500;
		double travaux = 20090;
		double amenagement = 4000;
		boolean conseil = true;
		double apport = 12790;
		double autresFrais = 2300;
		
		//Celles venant d'autres calculs
		
		
		//Celles venant des hypothèses (settings)
		double pourcentageFraisAgence = 0.075;
		double pourcentageFraisNotaire = 0.075;
		double pourcentageHonorairesConseil = 0.08;
		double taux15ans = 0.0318;
		double taux20ans = 0.034;
		double taux25ans = 0.0365;
		double taux30ans = 0.044;
		double tauxAssuranceCredit = 0.0036;
		double pourcentageSequestre = 0.1;
				
		//Zone de test		
		//==========================================================================
		//Variables temporaires de tests
		double Temp_NetVendeur = calculNetVendeur(prixFAI, pourcentageFraisAgence);
		
		double Temp_FraisAgence = calculFraisAgence(prixFAI, Temp_NetVendeur);
		
		double Temp_FraisNotaire = calculFraisNotaire(Temp_NetVendeur, pourcentageFraisNotaire);
		
		double Temp_HonorairesConseil = calculHonorairesConseil(conseil, Temp_NetVendeur, travaux, amenagement, 
				pourcentageHonorairesConseil);
		
		double Temp_CoutTotal = calculCoutTotal(Temp_NetVendeur, Temp_FraisAgence, Temp_FraisNotaire, travaux, amenagement, 
				Temp_HonorairesConseil, autresFrais);
		
		double Temp_Sequestre = calculSequestre(prixFAI, pourcentageSequestre); 
		
		int Temp_NbMensualiteCredit = calculNbMensualiteCredit(dureeCredit);
		
		double Temp_CapitalEmprunte = calculCapitalEmprunte(Temp_CoutTotal, apport);
		
		double Temp_TauxCredit = calculTauxCredit(dureeCredit, taux15ans, taux20ans, taux25ans, taux30ans);
		
		double Temp_MensualiteCredit = calculMensualiteCredit(Temp_CapitalEmprunte, Temp_NbMensualiteCredit, 
				Temp_TauxCredit, tauxAssuranceCredit);
		
		//Affichages en consoles
		//System.out.println("Net vendeur = " + Temp_NetVendeur);
		//System.out.println("Frais agence = " + Temp_FraisAgence);
		//System.out.println("Frais notaire = " + Temp_FraisNotaire);
		//System.out.println("Honoraires conseil = " + Temp_HonorairesConseil);
		//System.out.println("Cout total = " + Temp_CoutTotal);
		//System.out.println("Sequestre = " + Temp_Sequestre);
		//System.out.println("capital emprunté = " + Temp_CapitalEmprunte);
		//System.out.println("Nombre de mois = " + Temp_NbMensualiteCredit);
		System.out.println("Taux de credit = " + Temp_TauxCredit);
		System.out.println("Mensualite = " + Temp_MensualiteCredit);
		
	}
	//==============================================================================
	
	
	
	
	
	//Fonctions pour la partie Frais acquisition
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
	//Fonction 
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
		return Math.round((coutTotal - apport)/100)*100;
	}
	//==============================================================================
}

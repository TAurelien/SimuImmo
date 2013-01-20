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
		int dureeCredit = 25;
		double prixFAI = 137500;
		double travaux = 20090;
		double amenagement = 4000;
		boolean conseil = true;
		double apport = 12790;
		double autresFrais = 2300;
		
		//Celles venant d'autres calculs
		double netVendeur = 127900;
		double fraisAgence = 9600;
		double fraisNotaire = 9600;
		double honoraireConseil = 12159.2;
		double sequestre = 13750;
		double tauxCredit = 0.0365;
		
		
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
		double Temp_CoutTotal = calculCoutTotal(netVendeur, fraisAgence, fraisNotaire, travaux, amenagement, 
				honoraireConseil, autresFrais);
		int Temp_NbMensualiteCredit = calculNbMensualiteCredit(dureeCredit);
		double Temp_CapitalEmprunte = calculCapitalEmprunte(Temp_CoutTotal, apport);
		double Temp_MensualiteCredit = calculMensualiteCredit(Temp_CapitalEmprunte, Temp_NbMensualiteCredit, 
				tauxCredit, tauxAssuranceCredit);
		
		//Affichages en consoles
		System.out.println("Cout total = " + Temp_CoutTotal);
		System.out.println("capital emprunté = " + Temp_CapitalEmprunte);
		System.out.println("Nombre de mois = " + Temp_NbMensualiteCredit);
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
	//Fonction NON TESTE
	public static double  calculNetVendeur(double prixFAI, double pourcentageFraisAgence){
		return  Math.round(prixFAI/(1 + pourcentageFraisAgence)/100)*100;
	}
	
	//==============================================================================
	
	
	
	//Fonctions pour la partie Emprunt
	//Staut OK
	//==============================================================================
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

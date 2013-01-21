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
		double Temp_NetVendeur = CalculsAcquisition.calculNetVendeur(prixFAI, pourcentageFraisAgence);
		
		double Temp_FraisAgence = CalculsAcquisition.calculFraisAgence(prixFAI, Temp_NetVendeur);
		
		double Temp_FraisNotaire = CalculsAcquisition.calculFraisNotaire(Temp_NetVendeur, pourcentageFraisNotaire);
		
		double Temp_HonorairesConseil = CalculsAcquisition.calculHonorairesConseil(conseil, Temp_NetVendeur, travaux, amenagement, 
				pourcentageHonorairesConseil);
		
		double Temp_CoutTotal = CalculsAcquisition.calculCoutTotal(Temp_NetVendeur, Temp_FraisAgence, Temp_FraisNotaire, travaux, amenagement, 
				Temp_HonorairesConseil, autresFrais);
		
		double Temp_Sequestre = CalculsAcquisition.calculSequestre(prixFAI, pourcentageSequestre); 
		
		int Temp_NbMensualiteCredit = CalculsAcquisition.calculNbMensualiteCredit(dureeCredit);
		
		double Temp_CapitalEmprunte = CalculsAcquisition.calculCapitalEmprunte(Temp_CoutTotal, apport);
		
		double Temp_TauxCredit = CalculsAcquisition.calculTauxCredit(dureeCredit, taux15ans, taux20ans, taux25ans, taux30ans);
		
		double Temp_MensualiteCredit = CalculsAcquisition.calculMensualiteCredit(Temp_CapitalEmprunte, Temp_NbMensualiteCredit, 
				Temp_TauxCredit, tauxAssuranceCredit);
		
		//Affichages en consoles
		System.out.println("Net vendeur = " + Temp_NetVendeur);
		System.out.println("Frais agence = " + Temp_FraisAgence);
		System.out.println("Frais notaire = " + Temp_FraisNotaire);
		System.out.println("Honoraires conseil = " + Temp_HonorairesConseil);
		System.out.println("Cout total = " + Temp_CoutTotal);
		System.out.println("Sequestre = " + Temp_Sequestre);
		System.out.println("capital emprunté = " + Temp_CapitalEmprunte);
		System.out.println("Nombre de mois = " + Temp_NbMensualiteCredit);
		System.out.println("Taux de credit = " + Temp_TauxCredit);
		System.out.println("Mensualite = " + Temp_MensualiteCredit);
		
	}
	//==============================================================================
	
	
	
	

	
	//Fonctions pour ...
	//Staut 
	//==============================================================================
	//Calcul ...
	//Fonction 




	//==============================================================================
}

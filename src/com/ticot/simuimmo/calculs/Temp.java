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
		
		//Celles venant d'autres calculs
		double capitalEmprunte = 172900;
		
		//Celles venant des hypothèses (settings)
		double tauxCredit = 0.0365;
		double tauxAssuranceCredit = 0.0036;
				
		//Zone de test		
		//==========================================================================
		System.out.println("Pour " + dureeCredit + " ans, le nombre de mois est de " + calculNbMensualiteCredit(dureeCredit));
		System.out.println("Le montant de la mensualite est de " + 
		calculMensualiteCredit(capitalEmprunte, calculNbMensualiteCredit(dureeCredit), tauxCredit, tauxAssuranceCredit) + "€");
		
	}
	//==============================================================================
	
	//Calcul de la mensualité de credit
	//Fonction OK
	public static double calculMensualiteCredit(double capitalEmprunte, int nbMensualiteCredit, double taux, double tauxAssurance){
		double mensualite = (capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMensualiteCredit))) + (capitalEmprunte * tauxAssurance/12);
		return mensualite;
	}
	
	//Calcul du nombre de mensualite
	//Fonction OK
	public static int calculNbMensualiteCredit(int dureeCredit){
		int nbMensualiteCredit = dureeCredit * 12;
		return nbMensualiteCredit;
	}
	
	//Calcul du capital emprunté
	//Fonction
	public static double calculCapitalEmprunte(double coutTotal, double apport){
		double capitalEmprunte = coutTotal - apport;
		return capitalEmprunte;
	}
}

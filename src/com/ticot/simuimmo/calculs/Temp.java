package com.ticot.simuimmo.calculs;

//Classe temporaire pour les tests de calculs


public class Temp {

	String tag = "Test";
	//Log.d(tag,"In the onCreate() event");
	
	//Fonction pour lancer les tests
	//==============================================================================
	public static void aTester(){
		
		int dureeCredit = 25;
		System.out.println("Pour " + dureeCredit + " ans, le nombre de mois est de " + calculNbMensualiteCredit(dureeCredit));
		System.out.println("Le montant de la mensualite est de " + 
		calculMensualiteCredit(172900, calculNbMensualiteCredit(dureeCredit), 0.0365, 0.0036) + "€");
		
		/*
		double capitalEmprunte = 172900;
		double taux = 0.0365;
		int nbMois = 300;
		double tauxAssurance = 0.0036;
		double mensualite = (capitalEmprunte * taux/12)/(1-Math.pow((1+taux/12), (-nbMois))) + (capitalEmprunte * tauxAssurance/12);
		System.out.println("Le résultat du calcul est " + mensualite);
		//Toast.makeText(getBaseContext(), "La mensualité est de " + mensualite, Toast.LENGTH_SHORT).show();
		 */
		
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
	
}

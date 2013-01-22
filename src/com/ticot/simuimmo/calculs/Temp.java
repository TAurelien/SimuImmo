package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Inputs;

//Classe temporaire pour les tests de calculs

public class Temp {

	//Déclaration des variables de tests
	//==========================================================================
	//Celles venant d'autres calculs
	//...

	
	
	
	//Fonction pour lancer les tests
	//==============================================================================
	public static String aTester(double vPrixFAI, double vTravaux){
		
		Inputs.prixFAI = vPrixFAI;
		Inputs.travaux = vTravaux;
		return CalculsAcquisition.initialiser().toString();
	}
	
	
	
	//Fonctions à tester
	//==============================================================================
	

	


}

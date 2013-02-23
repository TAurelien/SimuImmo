package com.ticot.simuimmo.calculs;

//Classe temporaire pour les tests de calculs

import com.ticot.simuimmo.model.acquisition.Acquisition;

public class Temp {

	//Déclaration des variables de tests
	//==========================================================================
	//Celles venant d'autres calculs
	//...

	//Fonction pour lancer les tests
	//==============================================================================
	public static String aTester(){
		
		
		return CalculsAcquisition.initialiser().toString() + "\n\n" +
				CalculsGestion.initialiser().toString();
	}
	
	public static Acquisition Test2(){
		
		return CalculsAcquisition.initialiser();
	}
	
	//Fonctions à tester
	//==============================================================================
	
	
}

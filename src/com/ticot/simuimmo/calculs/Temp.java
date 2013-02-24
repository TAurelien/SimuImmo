package com.ticot.simuimmo.calculs;

//Classe temporaire pour les tests de calculs

import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.gestion.Gestion;

public class Temp {

	//Déclaration des variables de tests
	//==========================================================================
	//Celles venant d'autres calculs
	//...

	//Fonction pour lancer les tests
	//==============================================================================
	
	public static Acquisition TestAcquisition(){	
		return CalculsAcquisition.initialiser();
	}
	
	public static Gestion TestGestion(){	
		return CalculsGestion.initialiser();
	}
	
	//Fonctions à tester
	//==============================================================================
	
	
}

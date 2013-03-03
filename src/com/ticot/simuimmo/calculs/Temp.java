package com.ticot.simuimmo.calculs;

//Temporary class for testing prupose

import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.bien.Bien;
import com.ticot.simuimmo.model.gestion.Gestion;

public class Temp {

	//Declaration of test variables
	//==========================================================================

	//Functions to launch tests
	//==============================================================================
	
	public static Bien test(){
		Bien bien = new Bien();
		return bien;
	}

	public static Acquisition TestAcquisition(){	
		return CalculsAcquisition.initialiser();
	}
	
	public static Gestion TestGestion(){	
		return CalculsGestion.initialiser();
	}
	
}

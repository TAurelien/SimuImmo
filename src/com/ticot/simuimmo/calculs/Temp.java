package com.ticot.simuimmo.calculs;

//Classe temporaire pour les tests de calculs

import android.webkit.WebView.FindListener;
import android.widget.TextView;

import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

public class Temp {

	//Déclaration des variables de tests
	//==========================================================================
	//Celles renseignées par l'utilisateur
	public static int dureeCredit = 25;
	public static double prixFAI = 137500;
	public static double travaux = 20090;
	public static double amenagement = 4000;
	public static boolean conseil = true;
	public static double apport = 12790;
	public static double autresFrais = 2300;
	
	//Celles venant d'autres calculs
	//...
	
	
	//Celles venant des hypothèses (settings)
	public static double pourcentageFraisAgence = 0.075;
	public static double pourcentageFraisNotaire = 0.075;
	public static double pourcentageHonorairesConseil = 0.08;
	public static double taux15ans = 0.0318;
	public static double taux20ans = 0.034;
	public static double taux25ans = 0.0365;
	public static double taux30ans = 0.044;
	public static double tauxAssuranceCredit = 0.0036;
	public static double pourcentageSequestre = 0.1;
	
	//Fonction pour lancer les tests
	//==============================================================================
	public static String aTester(){
		
		//Zone de test		
		//==========================================================================
		return initialiserAcquisition().toString();
	}
	//==============================================================================
	
	
	
	//Fonctions à tester
	//==============================================================================
	
	//Fonction pour lancer les calculs de frais d'acquisition et d'emprunt
	public static Acquisition initialiserAcquisition(){
		
		FraisAcquisition fraisAcquisition = calculerFraisAcquisitions();
		Emprunt emprunt = calculerEmprunt(fraisAcquisition);
		return new Acquisition(fraisAcquisition, emprunt); 
	}
	
	//Fonction pour calculer les frais acquisition
	public static FraisAcquisition calculerFraisAcquisitions(){
		FraisAcquisition fa = new FraisAcquisition(prixFAI, travaux, amenagement, autresFrais, apport, conseil);
		fa.setNetVendeur(CalculsAcquisition.calculNetVendeur(fa.getPrixFAI(), pourcentageFraisAgence));
		fa.setFraisAgence(CalculsAcquisition.calculFraisAgence(fa.getPrixFAI(), fa.getNetVendeur()));
		fa.setFraisNotaire(CalculsAcquisition.calculFraisNotaire(fa.getNetVendeur(), pourcentageFraisNotaire));
		fa.setHonoraireConseil(CalculsAcquisition.calculHonorairesConseil(fa.getConseil(), fa.getNetVendeur(),fa.getTravaux(), fa.getAmenagement(),pourcentageHonorairesConseil));
		fa.setCoutTotal(CalculsAcquisition.calculCoutTotal(fa.getNetVendeur(), fa.getFraisAgence(),fa.getFraisNotaire(), fa.getTravaux(),fa.getAmenagement(), fa.getHonoraireConseil(),fa.getAutresFrais()));
		fa.setSequestre(CalculsAcquisition.calculSequestre(fa.getPrixFAI(), pourcentageSequestre));
		return fa;
	}

	//Fonction pour calculer l'emprunt
	public static Emprunt calculerEmprunt(FraisAcquisition fa){
		Emprunt emprunt = new Emprunt(dureeCredit);
		emprunt.setTauxAssuranceCredit(tauxAssuranceCredit);
		emprunt.setNbMensualiteCredit(CalculsAcquisition.calculNbMensualiteCredit(emprunt.getDureeCredit()));
		emprunt.setCapitalEmprunte(CalculsAcquisition.calculCapitalEmprunte(fa.getCoutTotal(), fa.getApport()));
		emprunt.setTauxCredit(CalculsAcquisition.calculTauxCredit(emprunt.getDureeCredit(), taux15ans, taux20ans, taux25ans, taux30ans));
		emprunt.setMensualitéCredit(CalculsAcquisition.calculMensualiteCredit(emprunt.getCapitalEmprunte(), emprunt.getNbMensualiteCredit(), 
				emprunt.getTauxCredit(), emprunt.getTauxAssuranceCredit()));
		emprunt.setTauxEndettement(0); //TODO Mettre à jour après calcul du taux d'endettement
		return emprunt;
	}
	
	

	//==============================================================================
}

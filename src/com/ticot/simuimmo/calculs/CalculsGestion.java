package com.ticot.simuimmo.calculs;

import com.ticot.simuimmo.model.Settings;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.gestion.Gestion;
import com.ticot.simuimmo.model.gestion.ChargesAnnuelles;
import com.ticot.simuimmo.model.gestion.FraisLocationAnnuelle;
import com.ticot.simuimmo.model.gestion.FraisLocationSaisonniere;
import com.ticot.simuimmo.model.gestion.RecetteLocative;

/**
 * @author Aurelien Ticot
 *
 */
public class CalculsGestion {

	//Fonctions pour la la classe Gestion
	//==============================================================================
	//Fonction pour lancer les calculs des charges annuelles, des frais de location annuelles,
	//des frais de location saisonnière et les recettes locative
	public static Gestion initialiser(){
		ChargesAnnuelles chargesAnnuelles = calculerChargesAnnuelles();
		FraisLocationAnnuelle fraisLocationAnnuelle = calculerFraisLocationAnnuelle();
		FraisLocationSaisonniere fraisLocationSaisonniere = null;
		RecetteLocative recetteLocative = calculerRecetteLocative();
		return new Gestion(Inputs.typeGestion, chargesAnnuelles, fraisLocationAnnuelle,
				fraisLocationSaisonniere, recetteLocative);
	}

	//Fonction pour définir l'objet RecetteLocative
	public static RecetteLocative calculerRecetteLocative(){
		RecetteLocative rl = new RecetteLocative(Inputs.loyerNu, Inputs.loyerMeuble, Inputs.loyerNuit, Inputs.vacLocAnnuelle, Inputs.vacLocSaisonnier);
		rl.setLoyerSaisonnier(calculLoyerSaisonnier(rl.getLoyerNuit(), rl.getVacLocSaisonnier()));
		rl.setRecetteLocative(calculRecetteLocative(Inputs.typeGestion, rl.getLoyerNu(), rl.getLoyerMeuble(), rl.getLoyerNuit(),
				rl.getVacLocAnnuelle(), rl.getVacLocSaisonnier()));
		return rl;
	}
	
	//Fonction pour définir l'objet ChargesAnnuelles
	//public ...
	public static ChargesAnnuelles calculerChargesAnnuelles(){
		ChargesAnnuelles ca = new ChargesAnnuelles(Inputs.chargesFixes, Inputs.taxeFonciere, Inputs.assuranceLocation, Inputs.travauxAnnuels, Inputs.taxeHabitation);
		ca.setCharges(calculChargesAnnuelles(
				ca.getChargesFixes(),ca.getTaxeFonciere(), ca.getAssuranceLocation(),ca.getTravauxAnnuels(),ca.getTaxeHabitation()));
		return ca;
	}
	
	//Fonction pour calculer les frais de location annuelle
	public static FraisLocationAnnuelle calculerFraisLocationAnnuelle(){
		FraisLocationAnnuelle fla = new FraisLocationAnnuelle(Inputs.gestionParAgence);
		//TODO evaluer s'il est judicieux de mettre le type de gestion dans le fonction de calcul 
		fla.setFraisGestionLocation(calculFraisGestion(Inputs.loyerNu, Inputs.loyerMeuble, Inputs.vacLocAnnuelle));
		fla.setFraisLocation(calculFraisLocationAnnuelle(Inputs.typeGestion,
				fla.getFraisGestionLocation(), Inputs.taxeHabitation)); 			//TODO Prendre la taxe d'habitation depuis l'objet ChargesAnnuelles
		return fla;
	}
	
	//Fonction pour calculer les frais de location saisonnière
	//public ..
	
	//==============================================================================
	
	
	//Fonctions pour la partie Recette locative 
	//==============================================================================
	//Calcul du loyer en saisonnier
	public static double calculLoyerSaisonnier(double loyerNuit, int vacLocSaisonnier){
		double ls = 0;
		if (vacLocSaisonnier < Settings.nuitsParMois)
			ls = loyerNuit * (Settings.nuitsParMois - vacLocSaisonnier);
		return ls;
	}
	
	//Calcul du la recette locative annuelle
	//TODO Changer le type de gestion en "int"
	public static double calculRecetteLocative(int typeGestion, double loyerNu, double loyerMeuble, double loyerNuit, int vacLocAnnuelle, int vacLocSaisonnier){
		double rl = 0;
		
		//TODO Evaluer si c'est une bonne chose de mettre le choix du type de gestion dans la fonction de calcul 
		switch (typeGestion) {
		case 0:					//0 = "Location nue"
			rl = loyerNu * (Settings.moisParAn - vacLocAnnuelle);
			break;
		case 1:					//1 = "Location meublé"
			rl = loyerMeuble * (Settings.moisParAn - vacLocAnnuelle);
			break;
		case 2:					//2 = "Location saisonnière"
			rl = loyerNuit * (Settings.nuitsParMois - vacLocSaisonnier) * Settings.moisParAn;
			break;
		case 3:					//3 = "Résidence principale"
			rl = 0;
			break;
		default:				//Au cas où, je redefinis en location meublé
			Inputs.typeGestion = 1;
			rl = loyerMeuble * (Settings.moisParAn - vacLocAnnuelle);
			break;
		}
		
		return rl;
	}
	
	//==============================================================================
	
	
	//Fonctions pour la partie Charges annuelles
	//==============================================================================
	//Calcul des charges annuelles
	public static double calculChargesAnnuelles(double chargesFixes, double taxeFonciere, double assuranceLocation, double travauxAnnuels, double taxeHabitation){
		return chargesFixes + taxeFonciere + assuranceLocation + travauxAnnuels + taxeHabitation;
	}
		
	//==============================================================================
	
	
	//Fonctions pour la partie Charges de location annuelles
	//==============================================================================
	//Calcul des frais de gestion annuelle par une agence
	public static double calculFraisGestion(double loyerNu, double loyerMeuble, int vacanceLoc){
		double fa = 0;
		if (Inputs.typeGestion == 0)
			fa = Settings.fraisGestionAgence * loyerNu * (Settings.moisParAn - vacanceLoc);
		else if (Inputs.typeGestion == 1)
			fa = Settings.fraisGestionAgence * loyerMeuble * (Settings.moisParAn - vacanceLoc);
		else
			fa = 0;
		return fa;
	}
	
	//Calcul des charges de location annuelles
	public static double calculFraisLocationAnnuelle (int typeGestion, double fraisGestionAgence, double taxeHabitation){
		double cla = 0;
		if (typeGestion == 0 || typeGestion == 1)
				cla = fraisGestionAgence - taxeHabitation;
		return cla; 
	}
	
	
	//==============================================================================
	
	
	//Fonctions pour la partie Charges de location saisonnière
	//==============================================================================
	//Calcul 
	
	
	//==============================================================================	
	
}

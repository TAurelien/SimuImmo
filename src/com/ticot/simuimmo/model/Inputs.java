package com.ticot.simuimmo.model;

/**
 * @author Aurelien Ticot
 */
public class Inputs {

	//Déclaration des variables renseignées par l'utilisateur
	//==============================================================================
	//XXX Parmi toutes les valeurs du formulaires, certaines doivent être persistantes, donc être conservé en settings cachés
	//Partie Acquisition remplies par l'utilisateur
	public static double prixFAI = 0;						//Prix du bien, frais d'agence inclus
	public static boolean agence = false;					//Choice to buy through an estate agency 
	public static double travaux = 0;						//Cout des travaux de renovation
	public static double amenagement = 0;					//Cout de l'amenagement pour une location meublé
	public static boolean conseil = false;					//Choix de passer par un société de conseil pour la recherche, les travaux et l'amenagement
	public static double apport = 0;						//Valeur de l'apport personnel
	public static double autresFrais = 0;					//Autres frais d'acquisition (frais bancaires, ...)
	public static int dureeCredit = 0;						//Durée du credit demandé
	//Partie Acquisition estimées mais l'utilisateur à la possibilité de les remplir
	public static double netVendeur = 0;					//Prix d'achat du bien (frais d'agence exclue) 
	public static double fraisAgence = 0;					//Frais d'agence
	public static double fraisNotaire = 0;					//Frais de notaire
	public static double honoraireConseil = 0;				//Honoraires de la société de conseil pour la recherche, les travaux et l'amenagement
	public static double capitalEmprunte = 0;				//Valeur du capital emprunté
	public static double tauxCredit = 0;					//Taux de credit
	public static double tauxAssuranceCredit = 0;			//Taux de l'assurance de credit
	// 
	public static boolean reelNetvendeur = false;
	public static boolean reelFraisAgence = false;
	public static boolean reelFraisNotaire = false;
	public static boolean reelHonoraireConseil = false;
	public static boolean reelCapitalEmrpunte = false;
	public static boolean reelTauxCredit = false;
	public static boolean reelTauxAssurance = false;
	
	//Partie Gestion remplies par l'utilisateur
	public static int typeGestion = 1;					//Choix du type de gestion du bien (location nu - 0, meublé - 1, saisonnière - 2 ou résidence principale - 3)
	public static double loyerNu = 850;						//Estimation du loyer mensuel en location nu
	public static double loyerMeuble = 1150;					//Estimation du loyer mensuel en location meublé
	public static double loyerNuit = 100;						//Estimation du loyer à la nuité en location saisonnière
	public static int vacLocAnnuelle = 1;					//En mois, estimation de la vacance locative annuelle pour location à l'année (nu ou meublé)
	public static int vacLocSaisonnier = 10;					//En nuits par mois, estimation de la vacance locative pour la location saisonnière
	public static double chargesFixes = 1176;					//Estimation des charges fixes de copropriétés, ...
	public static double taxeFonciere = 300;					//Estimation de la taxe foncière
	public static double assuranceLocation = 60;				//Cout de l'assurance immobilière (assurance habitation, loyer impayé, ...) 
	public static double travauxAnnuels = 0;				//Estimation du cout des éventuels travaux par an
	public static double taxeHabitation = 300;				//Estimation de la taxe d'habitation
	public static boolean gestionParAgence = true;			//Choix de la gestion de la location par une agence ou non
	//Partie Gestion estimés mais l'utilisateur à la possibilité de les remplir
	public static double charges = 0;						//Charges annuelles du bien
	public static double fraisGestionLocation = 0;			//Frais de gestion de la location par une agence
	public static double chargesLocation = 0;				//Charges annuelles de location
	public static double fraisAccueil = 0;					//Frais d'accueil annuels pour la gestion en saisonnier 
	public static double fraisMenage = 0;					//Frais de menage annuels pour la gestion en saisonnier
	public static double fraisGestionSaisonnier = 0;		//Frais de gestion annuels pour la gestion en saisonnier
	public static double fraisLocationSaisonniere = 0;	//Charges annuelles pour la location saisonnière
	
	//Partie Imposition remplies par l'utilisateur
	public static double tauxMarginal = 0;					//Tranche marginale d'imposition
	public static double fraisComptable = 0;				//Frais Comptable pour le calcul en frais réels
	
	//Partie CashFlow remplies par l'utilisateur
	public static double loyerActuel = 0;					//Cout mensuel du loyer actuel
	
	//Partie Revente remplies par l'utilisateur
	public static int reventeAprès = 0;						//en année de possession avant revente 
	//Partie Revente estimés mais l'utilisateur à la possibilité de les remplir
	public static double valeurRevente = 0;					//Valeur de revente estimé
	
	//==============================================================================
}
package com.ticot.simuimmo.model;

/**
 * @author Aurelien Ticot
 */
public class Settings {

	//Déclaration des variables venant des hypothèses
	//==============================================================================
	//Partie Acquisition
	public static double pourcentageFraisAgence = 0.075;		//Pourcentage des frais d'agence à l'achat d'un bien
	public static double pourcentageFraisNotaire = 0.075;		//Pourcentage des frais de notaire à l'achat d'un bien
	public static double pourcentageHonorairesConseil = 0.08;	//Pourcentage des honoraires de conseil pour la recherche d'un bien
	public static double taux15ans = 0.0318;					//Estimation du taux de credit pour une durée de 15 ans
	public static double taux20ans = 0.034;						//Estimation du taux de credit pour une durée de 20 ans
	public static double taux25ans = 0.0365;					//Estimation du taux de credit pour une durée de 25 ans
	public static double taux30ans = 0.044;						//Estimation du taux de credit pour une durée de 30 ans
	public static double tauxAssuranceCredit = 0.0036;			//Estimation du taux d'assurance credit
	public static double pourcentageSequestre = 0.1;			//Pourcentage du sequestre à laisser en acompte à l'achat d'un bien
	
	//A categoriser
	public static double achatSousMarche = 0.3; 				//Pourcentage d'acquisition sous le marché
	public static double revenuMensuelNet = 2500;				//Revenu mensuel net servant au calcul du taux d'endettement
	public static double autresRevenus = 0; 					//Autres revenus mensuel rentrant en compte dans le calcul du taux d'endettement
	public static double autresCredit = 0; 						//Valeur mensuelle des autres credit pour le calcul du taux d'endettement
	
	//Partie Gestion
	public static int moisParAn = 12;							//Nombre de mois par an, pour les calculs en saisonnier
	public static int nuitsParMois = 30;						//Nombre de nuits par mois, pour les calculs en saisonnier
	public static int nuitsParAn = 365;							//Nombre de nuits par an, pour les calculs en saisonnier
	public static int dureeSejourSaisonnier = 5; 				//En jours, durée moyenne de séjour
	public static double fraisAccueilSaisonnier = 25; 			//Frais unitaire d'accueil en location saisonnière
	public static double fraisMenageSaisonnier = 10; 			//Frais unitaire de menage en location saisonnière
	public static double fraisGestionMensuel = 20;				//Frais de gestion mensuelle en location saisonnière
	public static double augmentationLoyer = 0.01; 				//Augmentation annuelle des prix des loyers
	public static double augmentationCharges = 0.02; 			//Augmentation annuelle des charges
	public static double fraisGestionAgence = 0.06; 			//Frais de gestion de location par une agence
	public static double maxMensualitéRP = 900; 				//Mensualité maximum supporté en cas de choix Résidence Principale
	
	//Partie Imposition
	public static double abattementMicroFoncier = 0.3;			//Abattement de revenus en regime micro foncier
	public static double limiteRegimeMicro = 32000;				//Limite de revenus en regime micro
	public static double limiteRegimeMicroFoncier = 15000;		//Limite de revenus en regime micro foncier
	public static double abattementMicroBIC = 0.5;				//Abattement de revenus en regime micro BIC
	public static double abattementClasseTourisme = 0.71;		//Abattement de revenus en regime meublé classé de tourisme
	public static double tauxCSG = 0.155;						//Taux d'imposition pour la CSG CRDS
	public static double tauxAmortissementBien = 0.85;			//Taux d'amortissment des biens immobiliers = 85% de la valeur du bien
	public static int dureeAmortissementBien = 30;				//Durée d'amortissement des biens immobilier, choix à 30 ans généralement
	public static int dureeAmortissmentMeubles = 10;			//Durée d'amortissement des meubles, choix à 10 ans généralement
	public static boolean priseEnCompteClasseTourisme = false;	//Choix de prise en compte des classé de tourisme ou non
	
	//Partie Cash Flow
	public static double maxCashFlowNeg = 500;					//Maximum de cash flow négatif mensuel
	
	//Partie Revente
	public static double evoPrixImmobilier = 0.01;				//Evolution des prix de l'immobilier par an
	public static double reventeAuDessusMarche = 0.1;			//Revente au dessus des prix du marché
	public static double minPlusValueRP = 20000;				//Minimum de plus value à la revente en Résidence principale
	public static double tauxImpotPlusValue = 0.19;				//Taux d'imposition de la plus value
	
	//==============================================================================
}

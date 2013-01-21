package com.ticot.simuimmo.model.acquisition;

import com.ticot.simuimmo.model.acquisition.Emprunt;
import com.ticot.simuimmo.model.acquisition.FraisAcquisition;

//TODO Modifier la javadoc de la classe Acquisition
/**
 * @author Aurelien Ticot
 *
 */
public class Acquisition {

	//Déclaration des variables
	//==============================================================================
	//La classe Acquisition se compose des deux classes Emprunt et FraisAcquisitions
	private Emprunt emprunt;
	private FraisAcquisition fraisAcquisition;

	
	//Constructeurs
	//==============================================================================
	
	//Constructeur vide
	/**
	 * 
	 */
	public Acquisition() {
		super();
	}
	
	//Constructeur avec les deux variables
	/**
	 * @param fraisAcquisition
	 * @param emprunt
	 */
	public Acquisition(FraisAcquisition fraisAcquisition, Emprunt emprunt) {
		super();
		this.fraisAcquisition = fraisAcquisition;
		this.emprunt = emprunt;
	}

	
	//Getters
	//==============================================================================
	
	/**
	 * @return Retourne l'emprunt
	 */
	public Emprunt getEmprunt() {
		return emprunt;
	}
	
	/**
	 * @return Retourne les frais d'acquisition
	 */
	public FraisAcquisition getFraisAcquisition() {
		return fraisAcquisition;
	}
	
	//Setters
	//==============================================================================
	/**
	 * @param Definit l'emprunt
	 */
	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}
	
	/**
	 * @param Definit les frais d'acquisition
	 */
	public void setFraisAcquisition(FraisAcquisition fraisAcquisition) {
		this.fraisAcquisition = fraisAcquisition;
	}
	
	//==============================================================================

	//TODO Faire le toString() de la classe Acquisition

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return fraisAcquisition + "\n" + emprunt;
	}
	
	//TODO Faire le equal() de la classe Acquisiton
	
}

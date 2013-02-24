package com.ticot.simuimmo.model.bien;

import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.cashflow.CashFlow;
import com.ticot.simuimmo.model.gestion.Gestion;
import com.ticot.simuimmo.model.imposition.Imposition;
import com.ticot.simuimmo.model.revente.Revente;

//TODO Modifier la javadoc de la classe Bien
/**
* @author Aurelien Ticot
*
*/
public class Bien {

	//Déclaration des variables
	//==============================================================================
	//La classe Bien se compose des classes Acquisition, Gestion, CashFlow, Imposition, Revente, ...
	private Acquisition acquisition;
	private CashFlow cashFlow;
	private Gestion gestion;
	private Imposition imposition;
	private Revente revente;
	
	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	/**
	 * 
	 */
	public Bien() {
		super();
	}

	//Constructeurs avec les variables
	/**
	 * @param acquisition
	 * @param gestion
	 * @param cashFlow
	 * @param imposition
	 * @param revente
	 */
	public Bien(Acquisition acquisition, Gestion gestion, CashFlow cashFlow,
			Imposition imposition, Revente revente) {
		super();
		this.acquisition = acquisition;
		this.gestion = gestion;
		this.cashFlow = cashFlow;
		this.imposition = imposition;
		this.revente = revente;
	}

	
	//Getters
	//==============================================================================
	
	/**
	 * @return the acquisition
	 */
	public Acquisition getAcquisition() {
		return acquisition;
	}

	/**
	 * @return the cashFlow
	 */
	public CashFlow getCashFlow() {
		return cashFlow;
	}

	/**
	 * @return the gestion
	 */
	public Gestion getGestion() {
		return gestion;
	}

	/**
	 * @return the imposition
	 */
	public Imposition getImposition() {
		return imposition;
	}

	/**
	 * @return the revente
	 */
	public Revente getRevente() {
		return revente;
	}

	
	//Setters
	//==============================================================================
	/**
	 * @param acquisition the acquisition to set
	 */
	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}

	/**
	 * @param cashFlow the cashFlow to set
	 */
	public void setCashFlow(CashFlow cashFlow) {
		this.cashFlow = cashFlow;
	}

	/**
	 * @param gestion the gestion to set
	 */
	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	/**
	 * @param imposition the imposition to set
	 */
	public void setImposition(Imposition imposition) {
		this.imposition = imposition;
	}

	/**
	 * @param revente the revente to set
	 */
	public void setRevente(Revente revente) {
		this.revente = revente;
	}

	//==============================================================================

	//TODO Eventuellement modifier le toString() de la classe Acquisition
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return acquisition +
				"\n\n" + cashFlow +
				"\n\n" + gestion +
				"\n\n" + imposition +
				"\n\n" + revente;
	}	
	
	//TODO Faire le equal() de la classe Acquisiton
	
}

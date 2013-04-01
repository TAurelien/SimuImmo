/*
 * Copyright (C) 2013 Aurélien Ticot
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ticot.simuimmo.model.bien;

import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.cashflow.CashFlow;
import com.ticot.simuimmo.model.gestion.Gestion;
import com.ticot.simuimmo.model.imposition.Imposition;
import com.ticot.simuimmo.model.revente.Revente;

/**
* The class Bien is the class to represent one real estate in the application.
* <p>
* It's characterized by several estimations like the acquisition, the management (gestion), the Cashflow, the taxation (imposition) and the resale.
* </p>
*  
* @see Acquisition
* @see Gestion
* @see CashFlow
* @see Imposition
* @see Revente
* 
* @author Aurelien Ticot
* @version 1.0
*/
public class Bien {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**
	 * The acquisition part of the real estate (Bien).
	 * <p>For additional information refer to the Acquisition class.</p>
	 * 
	 * @see Acquisition
	 */
	private Acquisition acquisition;
	
	/**
	 * The cahflow part of the real estate (Bien).
	 * <p>For additional information refer to the CashFlow class.</p>
	 * @see Cashflow
	 */
	private CashFlow cashFlow;
	
	/**
	 * The management (Gestion) part of the real estate (Bien).
	 * <p>For additional information refer to the Gestion class.</p>
	 * @see Gestion
	 */
	private Gestion gestion;
	
	/**
	 * The taxation (Imposition) part of the real estate (Bien).
	 * <p>For additional information refer to the Imposition class.</p>
	 * @see Imposition
	 */
	private Imposition imposition;
	
	/**
	 * The resale (Revente) part of the real estate (Bien).
	 * <p>For additional information refer to the Revente class.</p>
	 * @see Revente
	 */
	private Revente revente;
	
	
	
	//==============================================================================
	//Constructors
	//==============================================================================
	
	/**
	 * Constructor of Bien.
	 * <p>Empty constructor.</p>
	 */
	public Bien() {
		super();
	}
	
	
	
	//==============================================================================	
	//Getters
	//==============================================================================
	
	/**
	 * Return the estimation of the acquisition for the real estate (Bien).
	 * @return an instance of Acquisition
	 * @see Acquisition
	 */
	public Acquisition getAcquisition() {
		return acquisition;
	}

	/**
	 * Return the estimation of the expected cash-flow for the real estate (Bien).
	 * @return an instance of CashFlow
	 * @see CashFlow
	 */
	public CashFlow getCashFlow() {
		return cashFlow;
	}

	/**
	 * Return the estimation of management (Gestion) of the real estate (Bien).
	 * @return an instance of Gestion
	 * @see Gestion
	 */
	public Gestion getGestion() {
		return gestion;
	}

	/**
	 * Return the estimation of the taxation (Imposition) of the real estate (Bien).
	 * @return an instance of Imposition
	 * @see Imposition
	 */
	public Imposition getImposition() {
		return imposition;
	}

	/**
	 * Return the estimation of the resale (revente) of the real estate (Bien).
	 * @return an instance of Revente
	 * @see Revente
	 */
	public Revente getRevente() {
		return revente;
	}


	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the acquisition.
	 * @param acquisition the instance of Acquisition to set.
	 * @see Acquisition
	 */
	public void setAcquisition(Acquisition acquisition) {
		this.acquisition = acquisition;
	}

	/**
	 * Define the CashFlow.
	 * @param cashFlow the instance of CashFlow to set.
	 * @see CashFlow
	 */
	public void setCashFlow(CashFlow cashFlow) {
		this.cashFlow = cashFlow;
	}

	/**
	 * Define the management (Gestion).
	 * @param gestion the instance of Gestion to set.
	 * @see Gestion
	 */
	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	/**
	 * Define the taxtation (Imposition).
	 * @param imposition the instance of Imposition to set.
	 * @see Imposition
	 */
	public void setImposition(Imposition imposition) {
		this.imposition = imposition;
	}

	/**
	 * Define the resale (revente).
	 * @param revente the instance of Revente to set.
	 * @see Revente
	 */
	public void setRevente(Revente revente) {
		this.revente = revente;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return acquisition + "\n\n" +
				cashFlow + "\n\n" +
				gestion + "\n\n" +
				imposition + "\n\n" +
				revente;
	}	
	
	//TODO Define the methods equal() of the class Bien
	
}

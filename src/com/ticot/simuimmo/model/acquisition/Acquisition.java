/*
 * Copyright (C) 2013 Aurelien Ticot
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

package com.ticot.simuimmo.model.acquisition;

/**
 * The class Acquisition represents the acquisition part of the real estate deal.
 * <p>It's characterized by 2 estimations:
 * <ul>
 * <li>fraisAcquisition: the cost of the acquisition</li>
 * <li>emprunt: the details of the loan</li>
 * </ul>
 * </p>
 * 
 * @see FraisAcquisition
 * @see Emprunt
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Acquisition {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/**
	 * The Emprunt part of the acquisition.
	 * <p>For additional information refer to the Emprunt class.</p>
	 * @see Emprunt
	 */
	private Emprunt emprunt;
	
	/**
	 * The costs of the acquistion.
	 * <p>For additional information refer to the FraisAcquisition class.</p>
	 * @see FraisAcquisition
	 */
	private FraisAcquisition fraisAcquisition;
	
	
	
	//==============================================================================
	//Constructeurs
	//==============================================================================

	/**
	 * Constructor of Acquisition.
	 * <p>Empty constructor.</p>
	 */
	public Acquisition() {
		super();
	}
	
	/**
	 * Constructor of Acquisition.
	 * <p>Constructor with the 2 variables fraisAcquisition and emprunt.</p>
	 * 
	 * @param fraisAcquisition
	 * @param emprunt
	 * 
	 * @see FraisAcquisition
	 * @see Emprunt
	 */
	public Acquisition(FraisAcquisition fraisAcquisition, Emprunt emprunt) {
		super();
		this.fraisAcquisition = fraisAcquisition;
		this.emprunt = emprunt;
	}
	
	
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/**
	 * Return the estimation of the loan.
	 * @return an instance of Emprunt.
	 * @see Emprunt
	 */
	public Emprunt getEmprunt() {
		return emprunt;
	}
	
	/**
	 * Return the estimation of the acquisition costs.
	 * @return an instance of FraisAcquisition
	 * @see FraisAcquisition
	 */
	public FraisAcquisition getFraisAcquisition() {
		return fraisAcquisition;
	}
	
	
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	/**
	 * Define the loan.
	 * @param emprunt the instance of Emprunt to set.
	 * @see Emprunt
	 */
	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}
	
	/**
	 * Define the cost of acquisition.
	 * @param fraisAcquisition the instance of FraisAcquisition to set.
	 * @see FraisAcquisition
	 */
	public void setFraisAcquisition(FraisAcquisition fraisAcquisition) {
		this.fraisAcquisition = fraisAcquisition;
	}
	
	
	
	//==============================================================================
	//Other methods
	//==============================================================================

	@Override
	public String toString() {
		return fraisAcquisition + "\n\n" + 
				emprunt;
	}
	
	//TODO Define the methods equal() of the class Bien
	
}

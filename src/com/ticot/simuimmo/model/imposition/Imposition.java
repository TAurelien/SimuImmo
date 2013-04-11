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

package com.ticot.simuimmo.model.imposition;

/**
 * @author Aurelien Ticot
 * @version 1.0
 */
public class Imposition {

	//TODO Structurer la classe Imposition
	
	private DetailsFraisReels detailsFraisReels;
	private DetailsImposition detailsImposition;
	
	/**
	 * @param detailsImposition
	 * @param detailsFraisReels
	 */
	public Imposition(DetailsImposition detailsImposition,
			DetailsFraisReels detailsFraisReels) {
		super();
		this.detailsImposition = detailsImposition;
		this.detailsFraisReels = detailsFraisReels;
	}
	/**
	 * @return Retourne les details des frais réels
	 */
	public DetailsFraisReels getDetailsFraisReels() {
		return detailsFraisReels;
	}
	/**
	 * @return Retourne les details de l'imposition
	 */
	public DetailsImposition getDetailsImposition() {
		return detailsImposition;
	}
	/**
	 * @param Definit les details des frais reels
	 */
	public void setDetailsFraisReels(DetailsFraisReels detailsFraisReels) {
		this.detailsFraisReels = detailsFraisReels;
	}
	/**
	 * @param Définit les details de l'imposition
	 */
	public void setDetailsImposition(DetailsImposition detailsImposition) {
		this.detailsImposition = detailsImposition;
	} 
}

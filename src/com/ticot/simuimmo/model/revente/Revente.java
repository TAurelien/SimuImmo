/*
 * Copyright (C) 2013 Aurelien Ticot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ticot.simuimmo.model.revente;

/**
 * @author Aurelien Ticot
 * 
 */
public class Revente {
	
	
	//TODO Structure the class Revente
	
	private CoutAcquisition coutAcquisition;
	
	private DetailsRevente detailsRevente;
	
	private ROIRenovation roiRenovation;
	
	/**
	 * @param coutAcquisition
	 * @param roiRenovation
	 * @param detailsRevente
	 * 
	 * @deprecated
	 */
	@Deprecated
	public Revente(CoutAcquisition coutAcquisition, ROIRenovation roiRenovation,
			DetailsRevente detailsRevente) {
	
		super();
		this.coutAcquisition = coutAcquisition;
		this.roiRenovation = roiRenovation;
		this.detailsRevente = detailsRevente;
	}
	
	/**
	 * @return Retourne les couts d'acquisition
	 */
	public CoutAcquisition getCoutAcquisition() {
	
		return coutAcquisition;
	}
	
	/**
	 * @return Retourne les details de la revente
	 */
	public DetailsRevente getDetailsRevente() {
	
		return detailsRevente;
	}
	
	/**
	 * @return Retourne le ROI apres renovation
	 */
	public ROIRenovation getRoiRenovation() {
	
		return roiRenovation;
	}
	
	/**
	 * @param Definit les couts d'acquisition
	 */
	public void setCoutAcquisition(CoutAcquisition coutAcquisition) {
	
		this.coutAcquisition = coutAcquisition;
	}
	
	/**
	 * @param Definit les details de la revente
	 */
	public void setDetailsRevente(DetailsRevente detailsRevente) {
	
		this.detailsRevente = detailsRevente;
	}
	
	/**
	 * @param Definit les ROI apres renovation
	 */
	public void setRoiRenovation(ROIRenovation roiRenovation) {
	
		this.roiRenovation = roiRenovation;
	}
	
}

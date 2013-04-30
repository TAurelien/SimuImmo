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

package com.ticot.simuimmo.model.cashflow;

/**
 * @author Aurelien Ticot
 *
 */
public class CashFlow {

	//TODO Structurer la classe CashFlow
	private CashFlowAnnee1 cashFlowAnnee1;
	private DonneesEntree donneesEntree;
	private PatrimoineAnnee1 patrimoineAnnee1;
	private Rendements rendements;
	
	/**
	 * @param donneesEntree
	 * @param rendements
	 * @param cashFlowAnnee1
	 * @param patrimoineAnnee1
	 */
	public CashFlow(DonneesEntree donneesEntree, Rendements rendements,
			CashFlowAnnee1 cashFlowAnnee1, PatrimoineAnnee1 patrimoineAnnee1) {
		super();
		this.donneesEntree = donneesEntree;
		this.rendements = rendements;
		this.cashFlowAnnee1 = cashFlowAnnee1;
		this.patrimoineAnnee1 = patrimoineAnnee1;
	}
	
	/**
	 * @return Retourne le cash flow de la 1ere annee
	 */
	public CashFlowAnnee1 getCashFlowAnnee1() {
		return cashFlowAnnee1;
	}
	
	/**
	 * @return Retourne les donnees d'entree
	 */
	public DonneesEntree getDonneesEntree() {
		return donneesEntree;
	}
	
	/**
	 * @return Retourne le patrimoine de la 1ere annee
	 */
	public PatrimoineAnnee1 getPatrimoineAnnee1() {
		return patrimoineAnnee1;
	}
	
	/**
	 * @return Retourne les rendements
	 */
	public Rendements getRendements() {
		return rendements;
	}
	
	/**
	 * @param Definit le cash flow de la 1ere annee
	 */
	public void setCashFlowAnnee1(CashFlowAnnee1 cashFlowAnnee1) {
		this.cashFlowAnnee1 = cashFlowAnnee1;
	}
	
	/**
	 * @param Definit les donnees d'entree
	 */
	public void setDonneesEntree(DonneesEntree donneesEntree) {
		this.donneesEntree = donneesEntree;
	}
	
	/**
	 * @param Definit le patrimoine de la 1ere annee
	 */
	public void setPatrimoineAnnee1(PatrimoineAnnee1 patrimoineAnnee1) {
		this.patrimoineAnnee1 = patrimoineAnnee1;
	}
	
	/**
	 * @param Definit les rendements
	 */
	public void setRendements(Rendements rendements) {
		this.rendements = rendements;
	}
	
}

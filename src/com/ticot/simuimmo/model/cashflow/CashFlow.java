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
	 * @return Retourne le cash flow de la 1ère année
	 */
	public CashFlowAnnee1 getCashFlowAnnee1() {
		return cashFlowAnnee1;
	}
	
	/**
	 * @return Retourne les données d'entrée
	 */
	public DonneesEntree getDonneesEntree() {
		return donneesEntree;
	}
	
	/**
	 * @return Retourne le patrimoine de la 1ère année
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
	 * @param Definit le cash flow de la 1ère année
	 */
	public void setCashFlowAnnee1(CashFlowAnnee1 cashFlowAnnee1) {
		this.cashFlowAnnee1 = cashFlowAnnee1;
	}
	
	/**
	 * @param Definit les données d'entrée
	 */
	public void setDonneesEntree(DonneesEntree donneesEntree) {
		this.donneesEntree = donneesEntree;
	}
	
	/**
	 * @param Definit le patrimoine de la 1ère année
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

package com.ticot.simuimmo.model.imposition;

/**
 * @author Aurelien Ticot
 *
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

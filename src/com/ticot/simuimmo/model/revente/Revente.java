package com.ticot.simuimmo.model.revente;

/**
 * @author Aurelien Ticot
 *
 */
public class Revente {

	//TODO Structurer la classe Revente
	
	private CoutAcquisition coutAcquisition;
	private DetailsRevente detailsRevente;
	private ROIRenovation roiRenovation;
	
	/**
	 * @param coutAcquisition
	 * @param roiRenovation
	 * @param detailsRevente
	 */
	public Revente(CoutAcquisition coutAcquisition,
			ROIRenovation roiRenovation, DetailsRevente detailsRevente) {
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
	 * @return Retourne le ROI  après renovation
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
	 * @param Definit les ROI après renovation
	 */
	public void setRoiRenovation(ROIRenovation roiRenovation) {
		this.roiRenovation = roiRenovation;
	}
		
}


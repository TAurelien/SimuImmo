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

package com.ticot.simuimmo.model.gestion;

//TODO Modify the javadoc
/**
 * @author Aurelien Ticot
 *
 */
public class Gestion {
	
	//TODO Structurer la classe Gestion
	
	//Déclaration des variables
	//==============================================================================
	//La classe Gestion se compose des 4 classes ChargesAnnuelles, FraisLocationAnnuelle
	//FraisLocationSaisonnière et Recette Locative
	
	// TODO Define the ENUM for the "Type de gestion"
	//Pour le moment le type de gestion est un "int"
	private int typeGestion;
	private ChargesAnnuelles chargesAnnuelles;
	private FraisLocationAnnuelle fraisLocationAnnuelle;
	private FraisLocationSaisonniere fraisLocationSaisonniere;
	private RecetteLocative recetteLocative;
	
	
	//Constructeurs
	//==============================================================================
	//Constructeur vide
	/**
	 * 
	 */
	public Gestion() {
		super();
	}
	
	//Constructeur avec toutes les variables
	/**
	 * @param fraisAnnuels
	 * @param fraisLocationAnnuelle
	 * @param fraisLocationSaisonniere
	 * @param recetteLocative
	 */
	public Gestion(int typeGestion, ChargesAnnuelles chargesAnnuelles,
			FraisLocationAnnuelle fraisLocationAnnuelle,
			FraisLocationSaisonniere fraisLocationSaisonniere,
			RecetteLocative recetteLocative) {
		super();
		this.typeGestion = typeGestion;
		this.chargesAnnuelles = chargesAnnuelles;
		this.fraisLocationAnnuelle = fraisLocationAnnuelle;
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
		this.recetteLocative = recetteLocative;
	}	
	
	
	//Getters
	//==============================================================================
	
	/**
	 * @return the typeGestion
	 */
	public int getTypeGestion() {
		return typeGestion;
	}
	
	/**
	 * @return Retourne les frais annuels
	 */
	public ChargesAnnuelles getChargesAnnuelles() {
		return chargesAnnuelles;
	}

	/**
	 * @return Retourne les frais de location annuelle
	 */
	public FraisLocationAnnuelle getFraisLocationAnnuelle() {
		return fraisLocationAnnuelle;
	}
	
	/**
	 * @return Retourne les frais de location saisonniere
	 */
	public FraisLocationSaisonniere getFraisLocationSaisonniere() {
		return fraisLocationSaisonniere;
	}
	
	/**
	 * @return Retourne la recette locative
	 */
	public RecetteLocative getRecetteLocative() {
		return recetteLocative;
	}
	
	
	//Setters
	//==============================================================================
	
	/**
	 * @param typeGestion the typeGestion to set
	 */
	public void setTypeGestion(int typeGestion) {
		this.typeGestion = typeGestion;
	}
	
	/**
	 * @param Definit les frais annuels
	 */
	public void setChargesAnnuelles(ChargesAnnuelles chargesAnnuelles) {
		this.chargesAnnuelles = chargesAnnuelles;
	}
	
	/**
	 * @param Definit les frais de location annuelle
	 */
	public void setFraisLocationAnnuelle(FraisLocationAnnuelle fraisLocationAnnuelle) {
		this.fraisLocationAnnuelle = fraisLocationAnnuelle;
	}
	
	/**
	 * @param Definit les frais de location saisonniere
	 */
	public void setFraisLocationSaisonniere(
			FraisLocationSaisonniere fraisLocationSaisonniere) {
		this.fraisLocationSaisonniere = fraisLocationSaisonniere;
	}
	
	/**
	 * @param Definit la recette locative
	 */
	public void setRecetteLocative(RecetteLocative recetteLocative) {
		this.recetteLocative = recetteLocative;
	}

	// ==============================================================================

	// 
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gestion ---------------------------" +
				"\nLe type de gestion est " + typeGestion + 
				"\n\n" + chargesAnnuelles +
				"\n\n" + fraisLocationAnnuelle +
				"\n\n" + fraisLocationSaisonniere +
				"\n\n" + recetteLocative;
	}

	// TODO Define the methods equal() of the class Bien	
}


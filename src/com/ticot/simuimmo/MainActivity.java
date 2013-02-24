package com.ticot.simuimmo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.ticot.simuimmo.calculs.Temp;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.gestion.Gestion;

public class MainActivity extends Activity {

	/**Called when the activity is first created*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//TODO onCreateOptionsMenu à traiter
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//A faire dans la MainActivity
	//TODO Prendre en compte les champs obligatoires
	//TODO Faire le collapse des champs moins importants
	//TODO Prendre en compte les valeurs non-remplies et leur assigner une valeur par défaut = 0
	
	
	//Bouton de test
	//==============================================================================
	public void onClick (View v){
		
		Inputs.prixFAI = Double.valueOf(
				((EditText)findViewById(R.id.valuePrixFAI)).getText().toString());
		//Inputs.prixFAI = getDoubleValue(R.id.valuePrixFAI);
		//System.out.println("Prix FAI = " + Inputs.prixFAI);
		
		Inputs.agence = ((CheckBox)findViewById(R.id.valueAgence)).isChecked();
		Inputs.travaux = Double.valueOf(
				((EditText)findViewById(R.id.valueTravaux)).getText().toString());
		Inputs.dureeCredit = Integer.valueOf(
				((EditText)findViewById(R.id.valueDureeCredit)).getText().toString());
		Inputs.amenagement = Double.valueOf(
				((EditText)findViewById(R.id.valueAmenagement)).getText().toString());
		Inputs.conseil = ((CheckBox)findViewById(R.id.valueConseil)).isChecked();
		Inputs.apport = Double.valueOf(
				((EditText)findViewById(R.id.valueApport)).getText().toString()); 
		Inputs.autresFrais = Double.valueOf(
				((EditText)findViewById(R.id.valueAutresFrais)).getText().toString()); 
	
		Acquisition a = Temp.TestAcquisition();
		Gestion g = Temp.TestGestion();
		
		TextView tv = (TextView) findViewById(R.id.text_result);
		tv.setText(a.toString() + "\n\n" + g.toString());
		
		//Fill computed values for FraisAcquisition
		((TextView) findViewById(R.id.valueNetVendeur)).setText(
				String.valueOf((a.getFraisAcquisition()).getNetVendeur()));
		((TextView) findViewById(R.id.valueFraisAgence)).setText(
				String.valueOf((a.getFraisAcquisition()).getFraisAgence()));
		((TextView) findViewById(R.id.valueFraisNotaire)).setText(
				String.valueOf((a.getFraisAcquisition()).getFraisNotaire()));
		((TextView) findViewById(R.id.valueHonoraireConseil)).setText(
				String.valueOf((a.getFraisAcquisition()).getHonoraireConseil()));
		((TextView) findViewById(R.id.valueCoutTotal)).setText(
				String.valueOf((a.getFraisAcquisition()).getCoutTotal()));
		((TextView) findViewById(R.id.valueSequestre)).setText(
				String.valueOf((a.getFraisAcquisition()).getSequestre()));
		
		//Fill computed values for Emprunt
		((TextView) findViewById(R.id.valueCapitalEmprunte)).setText(
				String.valueOf((a.getEmprunt()).getCapitalEmprunte()));
		((TextView) findViewById(R.id.valueNbMensualite)).setText(
				String.valueOf((a.getEmprunt()).getNbMensualiteCredit()));
		((TextView) findViewById(R.id.valueTauxCredit)).setText(
				String.valueOf((a.getEmprunt()).getTauxCredit()));
		((TextView) findViewById(R.id.valueTauxAssurance)).setText(
				String.valueOf((a.getEmprunt()).getTauxAssuranceCredit()));
		((TextView) findViewById(R.id.valueMensualite)).setText(
				String.valueOf((a.getEmprunt()).getMensualiteCredit()));
		((TextView) findViewById(R.id.valueTauxEndettement)).setText(
				String.valueOf((a.getEmprunt()).getTauxEndettement()));
		
	}
	
	/*
	private double getDoubleValue(int id){
		return Double.valueOf(((EditText)findViewById(id)).getText().toString());
	}
	*/
}
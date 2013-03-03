package com.ticot.simuimmo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ticot.simuimmo.calculs.Temp;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.bien.Bien;
import com.ticot.simuimmo.model.gestion.Gestion;

public class MainActivity extends Activity {

	//Declaration of variables
	public boolean AcquisitionCollpased = true; 
	//Creation of the class Bien through the temporary class
	public Bien bien = Temp.test();
	
	/**Called when the activity is first created*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//TODO onCreateOptionsMenu to do
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	//To do list in the MainActivity
	//TODO Take into account the mandatory fields
	//TODO Create the methods to collapse less important fields
	//TODO Take into account the empty fields and if necessary assign them an appropriate value (0 for instance)
	
	
	//Calculation button
	//==============================================================================
	public void onClick (View v){
		
		//TODO Check user's input values (mandatory, empty, formated, ...) 
		//Inputs.prixFAI = getDoubleValue(R.id.valuePrixFAI);
		Inputs.prixFAI = Double.valueOf(
				((EditText)findViewById(R.id.valuePrixFAI)).getText().toString());
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
		//TODO Directly instanciate the fields' values in the object Bien instead of the Inputs intermediate classe
		
		//Popultate the created instance of Bien 
		bien.setAcquisition(Temp.TestAcquisition());
		bien.setGestion(Temp.TestGestion());
		
		//Launch the update of the UI to display the computed values
		fillComputedValues(bien.getAcquisition(), bien.getGestion());
		
		//Display the result of calculation through the dedicated textView (temporary solution for testing purpose)
		//TextView tv = (TextView) findViewById(R.id.text_result);
		//tv.setText(bien.getAcquisition().toString() + "\n\n" + bien.getGestion().toString());
	}
	
	private void fillComputedValues(Acquisition a, Gestion g){
		//Methods to update the UI fields with all the computed values;
		
		//Define the format for the values
		DecimalFormat formatEur = new DecimalFormat("###,### €");
		formatEur.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.FRANCE));
		formatEur.setMaximumFractionDigits(2);
		formatEur.setMinimumFractionDigits(2);
		formatEur.setMinimumIntegerDigits(1);
		DecimalFormat formatPer = new DecimalFormat("## %");
		formatPer.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.FRANCE));
		formatPer.setMaximumFractionDigits(2);
		formatPer.setMinimumFractionDigits(2);
		formatPer.setMinimumIntegerDigits(1);
		
		//Format user's inputs for FraisAcquisition
		//((EditText) findViewById(R.id.valuePrixFAI)).setText(
		//		String.valueOf(formatEur.format((a.getFraisAcquisition()).getPrixFAI())));
		
		//Fill computed values for FraisAcquisition
		((TextView) findViewById(R.id.valueNetVendeur)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getNetVendeur())));
		((TextView) findViewById(R.id.valueFraisAgence)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getFraisAgence())));
		((TextView) findViewById(R.id.valueFraisNotaire)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getFraisNotaire())));
		((TextView) findViewById(R.id.valueHonoraireConseil)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getHonoraireConseil())));
		((TextView) findViewById(R.id.valueCoutTotal)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getCoutTotal())));
		((TextView) findViewById(R.id.valueSequestre)).setText(
				String.valueOf(formatEur.format((a.getFraisAcquisition()).getSequestre())));
		
		//Fill computed values for Emprunt
		((TextView) findViewById(R.id.valueCapitalEmprunte)).setText(
				String.valueOf(formatEur.format((a.getEmprunt()).getCapitalEmprunte())));
		((TextView) findViewById(R.id.valueNbMensualite)).setText(
				String.valueOf(formatEur.format((a.getEmprunt()).getNbMensualiteCredit())));
		((TextView) findViewById(R.id.valueTauxCredit)).setText(
				String.valueOf(formatPer.format((a.getEmprunt()).getTauxCredit())));
		((TextView) findViewById(R.id.valueTauxAssurance)).setText(
				String.valueOf(formatPer.format((a.getEmprunt()).getTauxAssuranceCredit())));
		((TextView) findViewById(R.id.valueMensualite)).setText(
				String.valueOf(formatEur.format((a.getEmprunt()).getMensualiteCredit())));
		((TextView) findViewById(R.id.valueTauxEndettement)).setText(
				String.valueOf(formatPer.format((a.getEmprunt()).getTauxEndettement())));
	}
	
	public void collapseUI (View view){
		//Methods to collapse or expand the UI to focus on most important fields or display all fields
		
		//Get the Form layout aggregating all fields
		LinearLayout ll = (LinearLayout)findViewById(R.id.layoutForm);

		//Get all 
		for (int i=0; i < ll.getChildCount(); i++){
			View v = ll.getChildAt(i);
			if (v.getTag().toString().equals("Collapsable")){			//Condition doesn't work for view without tag, need to check if tag is empty
				//Checking if the UI is already collapsed or not
				if (AcquisitionCollpased)
					//If already collapse, so set to visible (0) 
					v.setVisibility(0);
				else
					//If not collapse, so set to gone (8)
					v.setVisibility(8);
			}
		}
		if (AcquisitionCollpased)
			AcquisitionCollpased = false;
		else
			AcquisitionCollpased = true;
	}
	
	public void switchRealField(View view){
		switch (view.getId()){
		case R.id.ReelNetVendeur:
			if (((CheckBox)view).isChecked()){
				findViewById(R.id.valueNetVendeur).setVisibility(8);
				findViewById(R.id.valueReelNetVendeur).setVisibility(0);
			} else{
				findViewById(R.id.valueNetVendeur).setVisibility(0);
				findViewById(R.id.valueReelNetVendeur).setVisibility(8);
			}
		}
	}
	
	/*
	private double getDoubleValue(int id){
		return Double.valueOf(((EditText)findViewById(id)).getText().toString());
	}
	*/
}
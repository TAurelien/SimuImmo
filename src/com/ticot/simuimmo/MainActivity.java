package com.ticot.simuimmo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.ticot.simuimmo.calculs.Temp;
import com.ticot.simuimmo.model.Inputs;
import com.ticot.simuimmo.model.acquisition.Acquisition;
import com.ticot.simuimmo.model.bien.Bien;
import com.ticot.simuimmo.model.gestion.Gestion;

public class MainActivity extends Activity {

	//Creation of the class Bien through the temporary class
	public Bien bien = Temp.test();
	
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
	
	
	//Calculation button
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
		//TODO Directly instanciate the fields' values in the object Bien instead of the Inputs intermediate classe
		
		bien.setAcquisition(Temp.TestAcquisition());
		bien.setGestion(Temp.TestGestion());
		//Launch the update of the UI to display the computed values
		fillComputedValues(bien.getAcquisition(), bien.getGestion());
		
		//TextView tv = (TextView) findViewById(R.id.text_result);
		//tv.setText(a.toString() + "\n\n" + g.toString());
		
		//testTag();

	}
	
	private void fillComputedValues(Acquisition a, Gestion g){
		//Methods to update the UI fields with all the computed values;
		
		DecimalFormat formatEur = new DecimalFormat("###,### €");
		formatEur.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.FRANCE));
		formatEur.setMaximumFractionDigits(2);
		formatEur.setMinimumFractionDigits(2);
		formatEur.setMinimumIntegerDigits(1);
		DecimalFormat formatPer = new DecimalFormat("### %");
		formatPer.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.FRANCE));
		formatPer.setMaximumFractionDigits(2);
		formatPer.setMinimumFractionDigits(2);
		formatPer.setMinimumIntegerDigits(1);
		
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
	
	private void testTag(){
		LinearLayout ll = (LinearLayout)findViewById(R.id.layoutForm);
		int childCount = ll.getChildCount();
		System.out.println(childCount);
		for (int i=0; i < childCount; i++){
		      View v = ll.getChildAt(i);
		      //if (v.getTag().toString().equals("collapse")){ 		//Condition doesn't work for view without tag, need to add a check if tag is empty
		    //	  v.setVisibility(8);								//Methods is OK
		      //}
		}
	}
	
	/*
	private double getDoubleValue(int id){
		return Double.valueOf(((EditText)findViewById(id)).getText().toString());
	}
	*/
}
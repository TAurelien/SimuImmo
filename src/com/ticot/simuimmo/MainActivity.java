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
	
	//Bouton de test
	//==============================================================================
	public void onClick (View v){
		
		Inputs.prixFAI = Double.valueOf(
				((EditText)findViewById(R.id.valuePrixFAI)).getText().toString());
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
	
		TextView tv = (TextView) findViewById(R.id.text_result);
		tv.setText(Temp.aTester());		
	}
}
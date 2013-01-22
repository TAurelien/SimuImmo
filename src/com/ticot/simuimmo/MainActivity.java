package com.ticot.simuimmo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.ticot.simuimmo.calculs.Temp;

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
		TextView tv = (TextView) findViewById(R.id.text_result);
		double vPrixFAI = Double.valueOf(((EditText)findViewById(R.id.valuePrixFAI)).getText().toString());
		double vTravaux = Double.valueOf(((EditText)findViewById(R.id.valueTravaux)).getText().toString());
		tv.setText(Temp.aTester(vPrixFAI, vTravaux));
		
	}
}

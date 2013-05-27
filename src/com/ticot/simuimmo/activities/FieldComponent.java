/*
 * Copyright (C) 2013 Aurelien Ticot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ticot.simuimmo.activities;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ticot.simuimmo.BuildConfig;
import com.ticot.simuimmo.R;

public class FieldComponent extends LinearLayout implements OnCheckedChangeListener {
	
	
	/**
	 * 
	 */
	private final View CONTAINER;
	
	/**
	 * 
	 * @param context
	 * @param attrs
	 */
	public FieldComponent(Context context, AttributeSet attrs) {
	
		super(context, attrs);
		final LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//Inflate the component layout
		CONTAINER = inflater.inflate(R.layout.component_form_field, this);
		
		//Set up the listeners
		((CheckBox) CONTAINER.findViewById(R.id.fieldReal))
				.setOnCheckedChangeListener(this);
		
		//
		final TypedArray arr = getContext().obtainStyledAttributes(attrs,
				R.styleable.form_field);
		final String xmlValue = arr.getString(R.styleable.form_field_test);
		
		if (BuildConfig.DEBUG) { //DEBUG
			Log.d("Testing", "Affichage de TypedArray" + arr.toString());
		}
		
		arr.recycle();
		
		setXMLValue(xmlValue);
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	
		//If it has been checked, turn TextView visibility to GONE, turn EditText
		//visibility to VISIBLE, set focus to the EditText and Set the tag of the
		//RealValue as mandatory
		if (isChecked) {
			CONTAINER.findViewById(R.id.fieldValue).setVisibility(8);
			CONTAINER.findViewById(R.id.fieldRealValue).setVisibility(0);
			CONTAINER.findViewById(R.id.fieldRealValue).requestFocus();
			CONTAINER.findViewById(R.id.fieldRealValue).setTag("Mandatory");
		}
		else {
			CONTAINER.findViewById(R.id.fieldValue).setVisibility(0);
			CONTAINER.findViewById(R.id.fieldRealValue).setVisibility(8);
			CONTAINER.findViewById(R.id.fieldRealValue).setTag("Optional");
		}
		
	}
	
	public void setXMLValue(String value) {
	
		((TextView) CONTAINER.findViewById(R.id.fieldName)).setText(value);
	}
	
}
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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ticot.simuimmo.R;

// TODO Write all javadoc
/***/
public class FieldComponent extends LinearLayout implements OnCheckedChangeListener {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/***/
	private final View CONTAINER;
	
	/***/
	private Boolean collapsible = false;
	
	/***/
	private Boolean mandatory = false;
	
	/***/
	private Boolean mandatoryInitial = false;
	
	/***/
	private Boolean choiceAvailable = false;
	
	/***/
	private int fieldValueConfig = 1;
	
	/***/
	private final DecimalFormat format = new DecimalFormat();
	
	/***/
	private Boolean valueOK = true;
	
	//==============================================================================
	//Methods
	//==============================================================================
	
	/***/
	public FieldComponent(Context context, AttributeSet attrs) {
	
		super(context, attrs);
		final LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//Inflate the component layout
		CONTAINER = inflater.inflate(R.layout.component_form_field, this);
		
		//Set up the listeners
		((CheckBox) CONTAINER.findViewById(R.id.fieldUserValueSwitch))
				.setOnCheckedChangeListener(this);
		
		//Get the attributes defined in the XML layout
		final TypedArray arr = getContext().obtainStyledAttributes(attrs,
				R.styleable.form_field);
		
		//Extract arguments
		final Boolean mCollapsible = arr.getBoolean(R.styleable.form_field_collapsible,
				false);
		final Boolean mMandatoryInitial = arr.getBoolean(
				R.styleable.form_field_mandatory, false);
		final Boolean mChoiceAvailability = arr.getBoolean(
				R.styleable.form_field_choiceAvailability, false);
		final Boolean mChoiceChecked = arr.getBoolean(
				R.styleable.form_field_choiceChecked, false);
		final int mFieldValueConfig = arr.getInteger(
				R.styleable.form_field_fieldValueConfig, 1);
		final String mFieldName = arr.getString(R.styleable.form_field_fieldName);
		final String mFieldValueHint = arr
				.getString(R.styleable.form_field_fieldValueHint);
		final String mFieldValueText = arr
				.getString(R.styleable.form_field_fieldValueText);
		final String mFieldUserValueHint = arr
				.getString(R.styleable.form_field_fieldUserValueHint);
		final String mFieldUserValueText = arr
				.getString(R.styleable.form_field_fieldUserValueText);
		final int mValueFormat = arr.getInteger(R.styleable.form_field_valueFormat, 1);
		
		arr.recycle();
		
		defineFormat(mValueFormat);
		setCollapsible(mCollapsible);
		setMandatoryInitial(mMandatoryInitial);
		setChoiceAvailability(mChoiceAvailability);
		setChoiceChecked(mChoiceChecked);
		setFieldValueConfig(mFieldValueConfig);
		setFieldName(mFieldName);
		setFieldValueHint(mFieldValueHint);
		setFieldValueText(mFieldValueText);
		setFieldUserValueHint(mFieldUserValueHint);
		setFieldUserValueText(mFieldUserValueText);
		
	}
	
	/***/
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	
		//If it has been checked, turn TextView visibility to GONE, turn EditText
		//visibility to VISIBLE, set focus to the EditText and Set the tag of the
		//RealValue as mandatory
		if (fieldValueConfig != 3) {
			return;
		}
		
		if (isChecked) {
			CONTAINER.findViewById(R.id.fieldValue).setVisibility(View.GONE);
			CONTAINER.findViewById(R.id.fieldUserValue).setVisibility(View.VISIBLE);
			CONTAINER.findViewById(R.id.fieldUserValue).requestFocus();
			if (mandatoryInitial) {
				setMandatory(true);
			}
		}
		else {
			CONTAINER.findViewById(R.id.fieldValue).setVisibility(View.VISIBLE);
			CONTAINER.findViewById(R.id.fieldUserValue).setVisibility(View.GONE);
			setMandatory(false);
		}
		
	}
	
	/***/
	private String formatValue(Double value) {
	
		return String.valueOf(format.format(value));
	}
	
	/***/
	private String removeFormatValue(String value) {
	
		if (!value.isEmpty() || (value != "")) {
			//TODO Take care of the localization with a different separator
			value = value.replaceAll("[^0-9,.]", "");
			value = value.replace(',', '.');
		}
		else {
			value = "";
		}
		return value;
	}
	
	/***/
	private Boolean checkValue(String value) {
	
		CONTAINER.setBackgroundResource(0);
		valueOK = true;
		if ((value == "") || (value.replaceAll("[^1-9]", "").isEmpty())) {
			if (mandatory) {
				valueOK = false;
				CONTAINER.setBackgroundResource(R.color.red_light);
			}
			return false;
		}
		return true;
	}
	
	//==============================================================================
	//Getters
	//==============================================================================
	
	/***/
	public Boolean isCollapsible() {
	
		return collapsible;
	}
	
	/***/
	public Boolean isMandatory() {
	
		return mandatory;
	}
	
	/***/
	public Boolean hasChoice() {
	
		return choiceAvailable;
	}
	
	/***/
	public Boolean isChoiceChecked() {
	
		return ((CheckBox) CONTAINER.findViewById(R.id.fieldChoice)).isChecked();
	}
	
	/***/
	public Boolean isUserValue() {
	
		//Check if the user value EditText is visible or not
		//Visible means user's input is expected
		final int visibility = ((EditText) CONTAINER.findViewById(R.id.fieldUserValue))
				.getVisibility();
		
		if (visibility == View.VISIBLE) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/***/
	public String getUserValue(String defaultValue) {
	
		String value = "";
		final EditText view = ((EditText) CONTAINER.findViewById(R.id.fieldUserValue));
		if (!view.getText().toString().isEmpty()) {
			value = view.getText().toString();
		}
		value = removeFormatValue(value);
		if (checkValue(value)) {
			return value;
		}
		else {
			return defaultValue;
		}
	}
	
	public Boolean isValueOK() {
	
		return valueOK;
	}
	
	//==============================================================================
	//Setters
	//==============================================================================
	
	private void defineFormat(int format) {
	
		switch (format) {
			case 1:
				break;
			case 2:
				this.format.applyPattern("###,##0.00 €");
				break;
			case 3:
				this.format.applyPattern("#0.00 %");
				break;
		}
		this.format.setDecimalFormatSymbols(DecimalFormatSymbols
				.getInstance(Locale.FRANCE));
	}
	
	/***/
	private void setCollapsible(Boolean collapsible) {
	
		this.collapsible = collapsible;
	}
	
	/***/
	private void setMandatory(Boolean mandatory) {
	
		this.mandatory = mandatory;
	}
	
	/***/
	private void setMandatoryInitial(Boolean mandatoryInitial) {
	
		this.mandatoryInitial = mandatoryInitial;
	}
	
	/***/
	private void setFieldValueConfig(int config) {
	
		switch (config) {
			case 1: //Only the TextView
				((EditText) CONTAINER.findViewById(R.id.fieldUserValue))
						.setVisibility(View.GONE);
				((TextView) CONTAINER.findViewById(R.id.fieldValue))
						.setVisibility(View.VISIBLE);
				((CheckBox) CONTAINER.findViewById(R.id.fieldUserValueSwitch))
						.setVisibility(View.INVISIBLE);
				fieldValueConfig = 1;
				setMandatory(false);
				break;
			case 2: //Only the EditText
				((EditText) CONTAINER.findViewById(R.id.fieldUserValue))
						.setVisibility(View.VISIBLE);
				((TextView) CONTAINER.findViewById(R.id.fieldValue))
						.setVisibility(View.GONE);
				((CheckBox) CONTAINER.findViewById(R.id.fieldUserValueSwitch))
						.setVisibility(View.INVISIBLE);
				fieldValueConfig = 2;
				if (mandatoryInitial) {
					setMandatory(true);
				}
				else {
					setMandatory(false);
				}
				break;
			case 3: //Both TextView and EditText
				((EditText) CONTAINER.findViewById(R.id.fieldUserValue))
						.setVisibility(View.GONE);
				((TextView) CONTAINER.findViewById(R.id.fieldValue))
						.setVisibility(View.VISIBLE);
				((CheckBox) CONTAINER.findViewById(R.id.fieldUserValueSwitch))
						.setVisibility(View.VISIBLE);
				fieldValueConfig = 3;
				setMandatory(false);
				break;
		}
		
	}
	
	/***/
	private void setFieldValueHint(String hint) {
	
		((TextView) CONTAINER.findViewById(R.id.fieldValue)).setHint(hint);
	}
	
	/***/
	private void setFieldUserValueHint(String hint) {
	
		((EditText) CONTAINER.findViewById(R.id.fieldUserValue)).setHint(hint);
	}
	
	/***/
	private void setFieldName(String name) {
	
		((TextView) CONTAINER.findViewById(R.id.fieldName)).setText(name);
	}
	
	/***/
	private void setChoiceAvailability(Boolean choice) {
	
		if (choice) {
			((CheckBox) CONTAINER.findViewById(R.id.fieldChoice))
					.setVisibility(View.VISIBLE);
			//TODO Turn style of the name to .WithOption
		}
		else {
			((CheckBox) CONTAINER.findViewById(R.id.fieldChoice))
					.setVisibility(View.GONE);
			//TODO Turn style of the name to .NoOption
		}
		choiceAvailable = choice;
	}
	
	/***/
	private void setChoiceChecked(Boolean isChecked) {
	
		if (((CheckBox) CONTAINER.findViewById(R.id.fieldChoice)).isChecked() != isChecked) {
			((CheckBox) CONTAINER.findViewById(R.id.fieldChoice)).toggle();
		}
	}
	
	/***/
	public void setFieldValueText(String value) {
	
		((TextView) CONTAINER.findViewById(R.id.fieldValue)).setText(value);
	}
	
	/***/
	public void setFieldValueText(int value) {
	
		((TextView) CONTAINER.findViewById(R.id.fieldValue)).setText(value);
	}
	
	/***/
	public void setFieldValueText(Double value) {
	
		final String valueTxt = formatValue(value);
		((TextView) CONTAINER.findViewById(R.id.fieldValue)).setText(valueTxt);
	}
	
	/***/
	public void setFieldUserValueText(String value) {
	
		((EditText) CONTAINER.findViewById(R.id.fieldUserValue)).setText(value);
	}
	
	/***/
	public void setFieldUserValueText(int value) {
	
		((EditText) CONTAINER.findViewById(R.id.fieldUserValue)).setText(value);
	}
	
	/***/
	public void setFieldUserValueText(Double value) {
	
		final String valueTxt = formatValue(value);
		((EditText) CONTAINER.findViewById(R.id.fieldUserValue)).setText(valueTxt);
	}
}
/*
 * Copyright (C) 2013 Aurelien Ticot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.ticot.simuimmo.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import com.ticot.simuimmo.R;

/**
 * Activity for the settings (Preferences).
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class AppPreferenceActivity extends PreferenceActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		final PreferenceManager prefMgr = this.getPreferenceManager();
		prefMgr.setSharedPreferencesName("appPreferences");
		
		// ---load the preferences from an XML file---
		// TODO Update settings with Preference Fragments
		this.addPreferencesFromResource(R.xml.preference);
	}
}

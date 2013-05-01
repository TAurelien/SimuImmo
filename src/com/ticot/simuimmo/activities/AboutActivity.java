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

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.ticot.simuimmo.R;

/**
 * 
 * 
 * @author Aurelien Ticot
 * @version 1.0
 */
public class AboutActivity extends Activity {
	
	private static final String tag = "LOG";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_about);
		
		//TODO Try to add non-harcoded text
		String app_ver = "Version ";
		
		try {
			app_ver = app_ver + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		}
		catch (final NameNotFoundException e) {
			Log.v(tag, e.getMessage());
		}
		
		((TextView) findViewById(R.id.about_tvVersion)).setText(app_ver);
		
	}
}

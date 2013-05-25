package com.ticot.simuimmo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ticot.simuimmo.BuildConfig;
import com.ticot.simuimmo.R;

/**
 * Instances of this class are fragments representing a single object in our collection.
 * 
 * @author Aurelien Ticot
 * @version 1.0
 * @see AllFormPages
 */
public class FormPageFragment extends Fragment {
	
	
	/** Key use for the argument "page id". */
	public static final String KEY_PAGE_ID = "PAGE";
	
	/**
	 * Variable representing the ID of the page. The correspondance is the following:
	 * <ul>
	 * <li>1 = Acquisition</li>
	 * <li>2 = Gestion</li>
	 * <li>3 = Imposition</li>
	 * <li>4 = CashFlow</li>
	 * <li>5 = Revente</li>
	 * <li>6 = Evolution</li>
	 * </ul>
	 * */
	public static int PAGE_ID = 1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		//Get the ID from the arguments, then choose the layout according to.
		final Bundle arguments = getArguments();
		PAGE_ID = arguments.getInt(KEY_PAGE_ID);
		if (BuildConfig.DEBUG) { //DEBUG
			Log.d("Testing", "FormPage onCreateView " + PAGE_ID);
		}
		return inflater.inflate(getLayoutID(PAGE_ID), container, false);
	}
	
	/**
	 * Method to get the ID of the layout from the ID of the page
	 * 
	 * @param i the ID of the page.
	 * @return the ID of the layout.
	 */
	private int getLayoutID(int id) {
	
		//TODO Modify according to the real ID and layout
		switch (id) {
			case 1:
				return R.layout.fragment_acquisition;
			case 2:
				return R.layout.fragment_gestion;
			case 3:
				return R.layout.fragment_imposition;
			case 4:
				return R.layout.fragment_revente;
			default:
				return R.layout.fragment_acquisition;
		}
		
	}
}

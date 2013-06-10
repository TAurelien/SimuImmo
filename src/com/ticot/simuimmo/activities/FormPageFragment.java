package com.ticot.simuimmo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ticot.simuimmo.BuildConfig;
import com.ticot.simuimmo.R;
import com.ticot.simuimmo.activities.MainActivity.AllFormPages;

/**
 * Instances of this class are fragments representing a single object in our collection.
 * 
 * @author Aurelien Ticot
 * @version 1.0
 * @see AllFormPages
 */
public class FormPageFragment extends Fragment {
	
	
	//==============================================================================
	//Variables declaration
	//==============================================================================
	
	/** Key use for the argument "page id". */
	public static final String KEY_PAGE_ID = "PAGE";
	
	/** Represents the total number of pages */
	public static final int PAGE_COUNT = 5;
	
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
	public int PAGE_ID = 1;
	
	/**
	 * Variable representing the title of the page, here is the list:
	 * <ul>
	 * <li>1 = Acquisition</li>
	 * <li>2 = Gestion</li>
	 * <li>3 = Imposition</li>
	 * <li>4 = CashFlow</li>
	 * <li>5 = Revente</li>
	 * <li>6 = Evolution</li>
	 * </ul>
	 * */
	public static CharSequence PAGE_TITLE = "";
	
	//==============================================================================
	//Methods
	//==============================================================================
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		//Get the ID from the arguments, then choose the title and the layout according to.
		final Bundle arguments = getArguments();
		PAGE_ID = arguments.getInt(KEY_PAGE_ID);
		setPageTitle(PAGE_ID);
		
		if (BuildConfig.DEBUG) { //DEBUG
			Log.d("Testing", "FormPage onCreateView " + PAGE_ID + " " + PAGE_TITLE);
		}
		
		final View layoutPage = inflater.inflate(getLayoutID(PAGE_ID), container, false);
		
		//initPageFields(layoutPage, PAGE_ID);
		
		return layoutPage;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
	
		super.onSaveInstanceState(outState);
		//outState.putBoolean(KEY_BACKUP_collapsed, AcquisitionCollpased);
		//outState.putBoolean(KEY_BACKUP_calcul, backupCalcul);
		//outState.putBooleanArray(KEY_BACKUP_realValueState, backupRealValueState());
		//if (backupCalcul) {
		//	Backup.bienBackup = bien;
		//}
		getData(PAGE_ID);
		
	}
	
	private Object[][] getData(int pageID) {
	
		final int j = 0;
		final Object formData[][] = null;
		if (pageID == 3) {
			final LinearLayout ll = (LinearLayout) getView()
					.findViewById(R.id.layoutForm);
			
			if (BuildConfig.DEBUG) { //DEBUG
				Log.d("Testing", "Number of child = " + ll.getChildCount());
			}
			
			for (int i = 0; i < ll.getChildCount(); i++) {
				final View child = ll.getChildAt(i);
				
				if (BuildConfig.DEBUG) { //DEBUG
					Log.d("Testing", "Tag of the child " + i + " = " + child.getTag());
				}
				
				if (child.getTag() == getResources().getString(R.string.KEY_label)) {
					
					if (BuildConfig.DEBUG) { //DEBUG
						Log.d("Testing", "in the condition Tag == Label for " + i);
					}
					
				}
				else if (child.getTag() == getResources().getString(R.string.KEY_field)) {
					
					if (BuildConfig.DEBUG) { //DEBUG
						Log.d("Testing", "in the condition Tag = field for " + i);
					}
					
					//					final FieldComponent field = (FieldComponent) child;
					//					formData[j][0] = field.getId();
					//					formData[j][1] = field.isChoiceChecked();
					//					formData[j][2] = field.getUserValue("");
					//					if (BuildConfig.DEBUG) { //DEBUG
					//						Log.d("Testing", "formData = " + formData[j][0] + " "
					//								+ formData[j][0] + " " + formData[j][0]);
					//					}
					//					j++;
				}
				
			}
		}
		return formData;
	}
	
	/**
	 * 
	 * @param id
	 */
	private void setPageTitle(int id) {
	
		PAGE_TITLE = getPageTitle(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static CharSequence getPageTitle(int id) {
	
		//TODO Change hardcoded string to Ressources
		switch (id) {
			case 1:
				return "Acquisition";
			case 2:
				return "Gestion";
			case 3:
				return "Imposition";
			case 4:
				return "Cashflow";
			case 5:
				return "Revente";
			default:
				return "Acquisition";
		}
	}
	
	/**
	 * Method to get the ID of the layout from the ID of the page
	 * 
	 * @param i the ID of the page.
	 * @return the ID of the layout.
	 */
	private int getLayoutID(int id) {
	
		switch (id) {
			case 1:
				return R.layout.fragment_acquisition;
			case 2:
				return R.layout.fragment_gestion;
			case 3:
				return R.layout.fragment_imposition;
			case 4:
				return R.layout.fragment_cashflow;
			case 5:
				return R.layout.fragment_revente;
			default:
				return R.layout.fragment_acquisition;
		}
		
	}
	
	/**
	 * 
	 * @param v
	 * @param pageID
	 */
	private void initPageFields(View v, int pageID) {
	
		if (pageID == 3) {
			final LinearLayout ll = (LinearLayout) v.findViewById(R.id.layoutForm);
			if (BuildConfig.DEBUG) { //DEBUG
				Log.d("Testing", "Number of fields = " + ll.getChildCount());
			}
			
			for (int i = 0; i < ll.getChildCount(); i++) {
				final View field = ll.getChildAt(i);
				if (BuildConfig.DEBUG) { //DEBUG
					Log.d("Testing", "ID = " + field.getId());
				}
			}
		}
		
	}
}

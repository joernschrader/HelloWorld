package de.wvsg.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * LanguageChooserFragment provides a list of languages to choose from. When a 
 * language is selected, the fragment informs the associated activity on the specific choice.
 * An activity hosting this fragment must implement the OnLanguageChoosenListener
 * interface. 
 *
 * @author Joern Schrader
 * @version 1.0
 * 
 */
public class LanguageChooserFragment extends ListFragment {
	public static final String DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG = "LanguageChooseFragmentTag";
	
	public interface OnLanguageChoosenListener {
		public void onLanguageChoosen(int languageId);
	}
	
	/**
	 *  mCallback is a reference to the activity object. It is required 
	 *  to enable communication between fragment and activity. 
	 */
	private OnLanguageChoosenListener mCallback;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			// enable communication between fragment and activity
			mCallback = (OnLanguageChoosenListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + 
					" must implement OnLanguageChoosen");
		}
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] daten = { "Deutsch", "Englisch", "Französisch", "Spanisch", "Tagalog" };
		setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.language_chooser, R.id.text1, daten)); 
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mCallback.onLanguageChoosen((int) id);
	}

}

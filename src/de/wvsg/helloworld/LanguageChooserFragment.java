package de.wvsg.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LanguageChooserFragment extends ListFragment {
	public static final String DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG = "LanguageChooseFragmentTag";
	
	public interface OnLanguageChoosenListener {
		public void onLanguageChoosen(int languageId);
	}
	
	private OnLanguageChoosenListener mCallback;
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
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

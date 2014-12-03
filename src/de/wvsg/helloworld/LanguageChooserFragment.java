package de.wvsg.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LanguageChooserFragment extends ListFragment {
	public static final String DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG = "LanguageChooseFragmentTag";
	
	public interface OnLanguageChoosenListener {
		public void onLanguageChoosen(int languageId);
	}
	
	private OnLanguageChoosenListener mCallback;
	
	private Button btnChooseLanguage;
	private TextView tvHelloWorld;
	
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.language_chooser, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mCallback.onLanguageChoosen((int) id);
	}

}

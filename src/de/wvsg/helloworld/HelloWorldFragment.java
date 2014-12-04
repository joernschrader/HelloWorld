package de.wvsg.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * HelloWorldFragment displays the message "Hello World" in different languages.
 * If the button is cliqued, the app will offer a list of languages.
 * An activity hosting this fragment must implement the OnLanguageChooserDisplayListener
 * interface. 
 *
 * @author Joern Schrader
 * @version 1.0
 * 
 */
public class HelloWorldFragment extends Fragment {
	public static final String DEFAULT_HELLOWORLD_FRAGMENT_TAG = "HelloWorldFragmentTag";
	
	/**
	 * This interface enables the communication between fragment and activity. 
	 *
	 */
	public interface OnLanguageChooserDisplayListener {
		/**
		 *	Hosting activity must override this method to display
		 *  the list for the language selection.
		 */
		public void displayLanguageChoose();
	}
	
	/**
	 *  mCallback is a reference to the activity object. It is required 
	 *  to enable communication between fragment and activity. 
	 */
	private OnLanguageChooserDisplayListener mCallback;
	private Button btnChooseLanguage;
	private TextView tvHelloWorld;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.hello_world_fragment, container, false);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			// enable communication between fragment and activity
			mCallback = (OnLanguageChooserDisplayListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + 
					" must implement OnLanguageChoosen");
		}
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		btnChooseLanguage = (Button) getActivity().findViewById(R.id.btn_display_language_chooser);
		tvHelloWorld = (TextView) getActivity().findViewById(R.id.hello);
		btnChooseLanguage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				// when the button is pressed, notify the activity
				mCallback.displayLanguageChoose();				
			}
		});
	}
	
	/**
	 * Changes the display text in the "Hello World" text view.
	 * @param languageId ID of the selected language
	 */
	public void updateHelloWorldTag(int languageId) {
		switch (languageId) {
		case 0:
			tvHelloWorld.setText(R.string.lan_german);
			break;
		case 1:
			tvHelloWorld.setText(R.string.lan_english);
			break;
		case 2:
			tvHelloWorld.setText(R.string.lan_french);
			break;
		case 3:
			tvHelloWorld.setText(R.string.lan_spanish);
			break;
		case 4:
			tvHelloWorld.setText(R.string.lan_tagalog);
			break;
		default:
			tvHelloWorld.setText(R.string.lan_german);
			break;
		}

	}
}

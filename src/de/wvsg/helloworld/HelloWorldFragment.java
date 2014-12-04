package de.wvsg.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldFragment extends Fragment {
	public static final String DEFAULT_HELLOWORLD_FRAGMENT_TAG = "HelloWorldFragmentTag";
	
	public interface OnLanguageChooserDisplayListener {
		public void displayLanguageChoose();
	}
	
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
				mCallback.displayLanguageChoose();				
			}
		});
	}
	
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

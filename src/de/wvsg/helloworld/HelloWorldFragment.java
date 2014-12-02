package de.wvsg.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldFragment extends Fragment {
	public static final String DEFAULT_HELLOWORLD_FRAGMENT_TAG = "HelloWorldFragmentTag";
	
	private Button btnChooseLanguage;
	private TextView tvHelloWorld;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		btnChooseLanguage = (Button) getActivity().findViewById(R.id.button1);
		tvHelloWorld = (TextView) getActivity().findViewById(R.id.hello);
	}
}

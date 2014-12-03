package de.wvsg.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import de.wvsg.helloworld.HelloWorldFragment.OnLanguageChooserDisplayListener;
import de.wvsg.helloworld.LanguageChooserFragment.OnLanguageChoosenListener;


public class MainActivity extends ActionBarActivity implements 
	OnClickListener, OnLanguageChoosenListener, OnLanguageChooserDisplayListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	@Override
	public void onClick(View view) {
		Intent chooseLanguageIntent = new Intent(this, MainListActivity.class);
		startActivityForResult(chooseLanguageIntent, 0);
	}
	

	@Override
	public void onLanguageChoosen(int languageId) {
		HelloWorldFragment hwFragment = (HelloWorldFragment) 
				getSupportFragmentManager().findFragmentByTag(HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
		if (hwFragment != null) {
			hwFragment.updateHelloWorldTag(languageId);
		}
	}


	@Override
	public void displayLanguageChoose() {
		LanguageChooserFragment lcFragment = (LanguageChooserFragment) 
				getSupportFragmentManager().findFragmentByTag(LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		if (lcFragment == null) {
			getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, lcFragment).commit();
		}
	}

}

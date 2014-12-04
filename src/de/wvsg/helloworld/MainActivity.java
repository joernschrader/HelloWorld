package de.wvsg.helloworld;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import de.wvsg.helloworld.HelloWorldFragment.OnLanguageChooserDisplayListener;
import de.wvsg.helloworld.LanguageChooserFragment.OnLanguageChoosenListener;


public class MainActivity extends ActionBarActivity implements 
  	OnLanguageChoosenListener, OnLanguageChooserDisplayListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		HelloWorldFragment hwFragment = new HelloWorldFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.fragment_container, hwFragment, HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
		transaction.addToBackStack(null);
		transaction.commit();
	}
	
	
	@Override
	public void onLanguageChoosen(int languageId) {		
		HelloWorldFragment hwFragment = (HelloWorldFragment) 
				getSupportFragmentManager().findFragmentByTag(HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
		if (hwFragment != null) {	
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(R.id.fragment_container, hwFragment);			
			transaction.addToBackStack(null);
			transaction.commit();
			hwFragment.updateHelloWorldTag(languageId);
		} 
	}


	@Override
	public void displayLanguageChoose() {
		LanguageChooserFragment lcFragment = (LanguageChooserFragment) 
				getSupportFragmentManager().findFragmentByTag(LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		if (lcFragment == null) {			
			lcFragment = new LanguageChooserFragment();
		}
		//LanguageChooserFragment lcFragment = new LanguageChooserFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_container, lcFragment,LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		//transaction.addToBackStack(null);
		transaction.commit();
	}

}

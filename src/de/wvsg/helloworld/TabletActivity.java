package de.wvsg.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import de.wvsg.helloworld.HelloWorldFragment.OnLanguageChooserDisplayListener;
import de.wvsg.helloworld.LanguageChooserFragment.OnLanguageChoosenListener;

public class TabletActivity extends FragmentActivity implements 
	OnLanguageChoosenListener, OnLanguageChooserDisplayListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tablet);
		Fragment hwFragment = new HelloWorldFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.display_container_tab, hwFragment,
				HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
		//transaction.addToBackStack(null);
		transaction.commit();
	}

	@Override
	public void displayLanguageChoose() {
		Fragment lcFragment = getSupportFragmentManager().findFragmentByTag(
				LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		if (lcFragment == null) {
			lcFragment = new LanguageChooserFragment();
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			transaction
					.add(R.id.list_container_tab,
							lcFragment,
							LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
			transaction.commit();
		}
	}

	@Override
	public void onLanguageChoosen(int languageId) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		HelloWorldFragment hwFragment = (HelloWorldFragment) fragmentManager
				.findFragmentByTag(
						HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
		hwFragment.updateHelloWorldTag(languageId);		
		Fragment previousFragment = fragmentManager.findFragmentByTag(
				LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.remove(previousFragment);
		transaction.commit();	
	}

}

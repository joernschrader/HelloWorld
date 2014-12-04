package de.wvsg.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import de.wvsg.helloworld.LanguageChooserFragment.OnLanguageChoosenListener;

/**
 * This activity is hosting the fragment that offers the list for language selection. 
 *  
 * @author Joern Schrader
 * @version 1.0
 */
public class MainListActivity extends ActionBarActivity implements
		OnLanguageChoosenListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_list);
		Fragment lcFragment = getSupportFragmentManager().findFragmentByTag(
				LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
		if (lcFragment == null) {
			lcFragment = new LanguageChooserFragment();
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			transaction
					.add(R.id.list_fragment_container,
							lcFragment,
							LanguageChooserFragment.DEFAULT_LANGUAGECHOOSE_FRAGMENT_TAG);
			transaction.commit();
		}
	}

	@Override
	public void onLanguageChoosen(int languageId) {
		Intent result = new Intent();
		result.putExtra("languageId", languageId);
		setResult(Activity.RESULT_OK, result);
		finish();
	}

}
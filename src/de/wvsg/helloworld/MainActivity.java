package de.wvsg.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import de.wvsg.helloworld.HelloWorldFragment.OnLanguageChooserDisplayListener;

public class MainActivity extends ActionBarActivity implements
		OnLanguageChooserDisplayListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isTablet()) {
			startActivity(new Intent(this, TabletActivity.class));
			finish();
			return;
		}
		setContentView(R.layout.activity_main);
		if (findViewById(R.id.fragment_container) != null) {
			if (savedInstanceState != null) {
				return;
			}
			HelloWorldFragment hwFragment = new HelloWorldFragment();
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();
			transaction.add(R.id.fragment_container, hwFragment,
					HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
			transaction.commit();
		}
	}

	@Override
	public void displayLanguageChoose() {
		Intent listIntent = new Intent(this, MainListActivity.class);
		startActivityForResult(listIntent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			int languageId = data.getIntExtra("languageId", 0);
			HelloWorldFragment hwFragment = (HelloWorldFragment) getSupportFragmentManager()
					.findFragmentByTag(
							HelloWorldFragment.DEFAULT_HELLOWORLD_FRAGMENT_TAG);
			hwFragment.updateHelloWorldTag(languageId);
		}
	}

	private boolean isTablet() {
		int sizeMask = this.getResources().getConfiguration().screenLayout
				& Configuration.SCREENLAYOUT_SIZE_MASK;
		boolean large = (sizeMask == Configuration.SCREENLAYOUT_SIZE_LARGE);
		boolean xlarge = (sizeMask == 4);
		return large || xlarge;
	}

}

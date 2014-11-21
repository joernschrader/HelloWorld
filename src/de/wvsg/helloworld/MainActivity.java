package de.wvsg.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	private Button btnChooseLanguage;
	private TextView tvHelloWorld;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnChooseLanguage = (Button) findViewById(R.id.button1);
		btnChooseLanguage.setOnClickListener(this);
		tvHelloWorld = (TextView) findViewById(R.id.hello);
	}
	
	
	@Override
	public void onClick(View view) {
		Log.d("Ausgabe","Ausgabe: Button wurde gedrückt!");	
		Intent chooseLanguageIntent = new Intent(this, MainListActivity.class);
		startActivityForResult(chooseLanguageIntent, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("Ausgabe","ResultCode: " + resultCode);	
		if (resultCode == Activity.RESULT_OK) {
			int languageId = data.getIntExtra("languageId",0);
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
}

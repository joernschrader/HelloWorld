package de.wvsg.helloworld;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fill ListView
		String[] daten = { "Deutsch", "Englisch", "Französisch", "Spanisch",
				"Tagalog" };
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, daten));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Log.d("Ausgabe", "Ausgewählt wurde: " + id);
		Intent result = new Intent();
		result.putExtra("languageId", (int) id);
		setResult(Activity.RESULT_OK, result);
		finish();
	}

}
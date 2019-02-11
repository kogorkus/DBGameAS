package ru.samsung.itschool.dbgame;

import java.util.ArrayList;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HoFActivity extends Activity {

	private DBManager dbManager;
	private ArrayList<String> data = new ArrayList<>();
	ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ho_f);
		dbManager = DBManager.getInstance(this);



		ArrayList<Result> results = dbManager.getAllResults();


		for (Result res : results)
		{
			data.add(res.name + ": " + res.score);
		}
		listview = (ListView)findViewById(R.id.MyList);
		MyAdapter myAdapter = new MyAdapter(data);
		listview.setAdapter(myAdapter);
		listview.setOnItemClickListener(myAdapter);


	}
	class MyAdapter extends  ArrayAdapter<String> implements AdapterView.OnItemClickListener{

		@NonNull
		@Override
		public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
			View v = LayoutInflater.from(HoFActivity.this).inflate(R.layout.myitem, null);
			TextView tv = (TextView) v.findViewById(R.id.TxtItem);
			tv.setText(data.get(position));
			String str = data.get(position);
			String[] tempstr = str.split(": ");
			if(Integer.parseInt(tempstr[1]) % 10 == 0){
				tv.setBackgroundColor(Color.BLUE);
			}
			return v;
		}

		public MyAdapter(ArrayList<String> data) {
			super(HoFActivity.this, R.layout.myitem, data);
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			String str = data.get(position);
			data.remove(position);
			Toast.makeText(HoFActivity.this, str, Toast.LENGTH_SHORT).show();
			String[] tempstr = str.split(": ");
			dbManager.deleteElement(tempstr[0], Integer.parseInt(tempstr[1]));
			this.notifyDataSetChanged();
		}
	}
}
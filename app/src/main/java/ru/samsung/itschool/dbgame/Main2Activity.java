package ru.samsung.itschool.dbgame;

import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {

    private ArrayList<String> data = new ArrayList<>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i = 0; i < 100; i++)
        {
            data.add(i + "");
        }
        listview = (ListView)findViewById(R.id.mListView);
        MyAdapter myAdapter = new MyAdapter(data);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(myAdapter);
    }

    class MyAdapter extends  ArrayAdapter<String> implements AdapterView.OnItemClickListener{

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = LayoutInflater.from(Main2Activity.this).inflate(R.layout.myitem, null);
            TextView tv = (TextView) v.findViewById(R.id.TxtItem);
            tv.setText(data.get(position));
            if(Integer.parseInt(data.get(position)) % 10 == 0){
                tv.setBackgroundColor(Color.BLUE);
            }
            return v;
        }

        public MyAdapter(ArrayList<String> data) {
            super(Main2Activity.this, R.layout.myitem, data);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            view.setBackgroundColor(Color.CYAN);
            data.set(position, Integer.parseInt(data.get(position)) + 1 + "");
            this.notifyDataSetChanged();
        }
    }
}


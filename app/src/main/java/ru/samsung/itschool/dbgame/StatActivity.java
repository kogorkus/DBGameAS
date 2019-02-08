package ru.samsung.itschool.dbgame;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class StatActivity extends Activity {

    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        dbManager = DBManager.getInstance(this);
        TextView tvCountGames = (TextView)this.findViewById(R.id.textView6);
        TextView sumPoints = (TextView)this.findViewById(R.id.textView7);
        TextView maxPoints = (TextView)this.findViewById(R.id.textView8);
        TextView Players = (TextView)this.findViewById(R.id.textView9);
        TextView OddEven = (TextView)this.findViewById(R.id.textView10);
        tvCountGames.setText(dbManager.countGames() +"");
        sumPoints.setText(dbManager.countSum() + "");
        maxPoints.setText(dbManager.countMax() + "");

    }
}

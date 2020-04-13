package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    DatabaseHelper myDB;

    String idMatch = "0";

    String J1 = "";
    String J2 = "";
    String gagnant = "";
    String premierServiceJ1 = "";
    String premierServiceJ2 = "";
    String doubleFauteJ1 = "";
    String doubleFauteJ2 = "";
    String pointGagnantJ1 = "";
    String pointGagnantJ2 = "";
    String fautesJ1 = "";
    String fautesJ2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        myDB = new DatabaseHelper(this);
        Bundle b = getIntent().getExtras();
        idMatch = b.getString("id");
        Log.d("id:", String.valueOf(idMatch));
        viewStats();
    }

    public void onClick4(View view)
    {
        switch(view.getId())
        {
            case R.id.buttonRetour:
                finish();
                break;
        }
    }

    public void viewStats(){
        Cursor res = myDB.getDataGame(idMatch);

        if(res.getCount() == 0){
            return;
        }

        while (res.moveToNext()) {
            J1 = res.getString(1);
            J2 =res.getString(2);
            gagnant = res.getString(3);
            premierServiceJ1 = res.getString(4);
            premierServiceJ2 = res.getString(5);
            doubleFauteJ1 = res.getString(6);
            doubleFauteJ2 = res.getString(7);
            pointGagnantJ1 = res.getString(8);
            pointGagnantJ2 = res.getString(9);
            fautesJ1 = res.getString(10);
            fautesJ2 = res.getString(11);
       }

        TextView textVs = (TextView) findViewById(R.id.textVs);
        TextView textGagnant = (TextView) findViewById(R.id.textGagnant);
        TextView textJ1 = (TextView) findViewById(R.id.textJ1);
        TextView textPremiersServicesJ1 = (TextView) findViewById(R.id.textPremiersServicesJ1);
        TextView textDoublesFautesJ1 = (TextView) findViewById(R.id.textDoublesFautesJ1);
        TextView textPointsGagnantsJ1 = (TextView) findViewById(R.id.textPointsGagnantsJ1);
        TextView textFautesJ1 = (TextView) findViewById(R.id.textFautesJ1);
        TextView textJ2 = (TextView) findViewById(R.id.textJ2);
        TextView textPremiersServicesJ2 = (TextView) findViewById(R.id.textPremiersServicesJ2);
        TextView textDoublesFautesJ2 = (TextView) findViewById(R.id.textDoublesFautesJ2);
        TextView textPointsGagnantsJ2 = (TextView) findViewById(R.id.textPointsGagnantsJ2);
        TextView textFautesJ2 = (TextView) findViewById(R.id.textFautesJ2);
        textVs.setText(J1 + " vs " + J2);
        textGagnant.setText("Gagnant : " + gagnant);
        textJ1.setText(J1 + " :");
        textPremiersServicesJ1.setText(premierServiceJ1 + "%");
        textDoublesFautesJ1.setText(doubleFauteJ1);
        textPointsGagnantsJ1.setText(pointGagnantJ1);
        textFautesJ1.setText(fautesJ1);
        textJ2.setText(J2 + " :");
        textPremiersServicesJ2.setText(premierServiceJ2 + "%");
        textDoublesFautesJ2.setText(doubleFauteJ2);
        textPointsGagnantsJ2.setText(pointGagnantJ2);
        textFautesJ2.setText(fautesJ2);
    }
}

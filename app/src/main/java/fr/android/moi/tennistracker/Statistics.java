package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Statistics extends AppCompatActivity {

    DatabaseHelper myDB;

    String idMatch = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Bundle b = getIntent().getExtras();
        idMatch = b.getString("number");
        Log.d("id:", String.valueOf(idMatch));

        //viewStats();
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
        Cursor res = myDB.getAllData(); // mettre l'id de la game

        if(res.getCount() == 0){
            return;
        }

        while (res.moveToNext()) {

        Log.d("id:", res.getString(0)); // ID
        Log.d("J1:", res.getString(1)); // J1
        Log.d("J2:", res.getString(2)); // J2
        Log.d("Gagnant:", res.getString(3)); // Gagnant
        Log.d("PSJ1:", res.getString(4)); // premierServiceJ1
        Log.d("PSJ2:", res.getString(5)); // premierServiceJ2
        Log.d("DFJ1:", res.getString(6)); // dFServiceJ1
        Log.d("DFJ2:", res.getString(7)); // dFServiceJ2
        Log.d("PGJ1:", res.getString(8)); // pointGagnantJ1
        Log.d("PGJ2:", res.getString(9)); // pointGagnantJ2
        Log.d("FJ1:", res.getString(10)); //fautesJ1
        Log.d("FJ2:", res.getString(11)); //fautesJ2
       }
    }
}

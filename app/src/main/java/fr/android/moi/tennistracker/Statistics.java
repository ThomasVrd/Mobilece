package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Statistics extends AppCompatActivity {

    DatabaseHelper myDB;

    int nbMatch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Bundle b = getIntent().getExtras();
        nbMatch = b.getInt("number");
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
        Cursor res = myDB.getAllData();

        if(res.getCount() == 0){
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            res.getString(0); // ID
            res.getString(1); // J1
            res.getString(2); // J2
            res.getString(3); // Gagnant
            res.getString(4); // premierServiceJ1
            res.getString(5); // premierServiceJ2
            res.getString(6); // dFServiceJ1
            res.getString(7); // dFServiceJ2
            res.getString(8); // pointGagnantJ1
            res.getString(9); // pointGagnantJ2
            res.getString(10); //fautesJ1
            res.getString(11); //fautesJ2
        }
    }
}

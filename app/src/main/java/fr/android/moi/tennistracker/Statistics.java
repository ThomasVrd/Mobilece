package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Statistics extends AppCompatActivity {

    int nbMatch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Bundle b = getIntent().getExtras();
        nbMatch = b.getInt("number");
    }
}

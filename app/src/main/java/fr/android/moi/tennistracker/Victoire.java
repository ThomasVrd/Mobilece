package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Victoire extends AppCompatActivity {

    String gagnant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoire);
        Bundle b = getIntent().getExtras();
        gagnant = b.getString("gagnant");

        TextView txtVictoire = (TextView) findViewById(R.id.textVictoire);
        txtVictoire.setText("Victoire " + gagnant + " !");
    }

    public void onClick3(View view)
    {
        switch(view.getId())
        {
            case R.id.buttonTer:
                finish();
                break;
            default:
                finish();
                break;
        }
    }
}

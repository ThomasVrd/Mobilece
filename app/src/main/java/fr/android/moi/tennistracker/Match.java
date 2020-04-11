package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Match extends AppCompatActivity {

    int nbMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        nbMatch = 1;
    }

    public void onClick2(View view)
    {
        TextView Service = (TextView) findViewById(R.id.textService);
        String textService = Service.getText().toString();

        switch(view.getId())
        {
            case R.id.button1Ace:
                if(textService.equals("Service Joueur 1 :"))
                {
                    showPoints("J1", "J2");
                }
                if(textService.equals("Service Joueur 2 :"))
                {
                    showPoints("J2", "J1");
                }
        }
    }

    public void showPoints(String gagnant, String perdant)
    {
        TextView textPoints1 = (TextView) findViewById(R.id.textPoints1);
        TextView textPoints2 = (TextView) findViewById(R.id.textPoints2);
        String points1 = textPoints1.getText().toString();
        String points2 = textPoints2.getText().toString();

        if(gagnant.equals("J1"))
        {
            switch (points1)
            {
                case "0":
                    textPoints1.setText("15");
                    break;
                case "15":
                    textPoints1.setText("30");
                    break;
                case "30":
                    textPoints1.setText("40");
                    break;
                case "40":
                    if(points2.equals("40"))
                    {
                        textPoints1.setText("AV");
                    }
                    if(points2.equals("AV"))
                    {
                        textPoints2.setText("40");
                    }
                    else
                    {
                        textPoints1.setText("0");
                        textPoints2.setText("0");
                        
                    }
                    break;
            }
        }
    }
}

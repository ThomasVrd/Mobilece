package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class  Match extends AppCompatActivity {

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
                    showPoints("J1");
                }
                if(textService.equals("Service Joueur 2 :"))
                {
                    showPoints("J2");
                }
        }
    }

    public void showPoints(String gagnant)
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
                        showSets("J1");
                    }
                    break;
            }
        }
        if(gagnant.equals("J2"))
        {
            switch (points2)
            {
                case "0":
                    textPoints2.setText("15");
                    break;
                case "15":
                    textPoints2.setText("30");
                    break;
                case "30":
                    textPoints2.setText("40");
                    break;
                case "40":
                    if(points1.equals("40"))
                    {
                        textPoints2.setText("AV");
                    }
                    if(points1.equals("AV"))
                    {
                        textPoints1.setText("40");
                    }
                    else
                    {
                        textPoints1.setText("0");
                        textPoints2.setText("0");
                        showSets("J2");
                    }
                    break;
            }
        }
    }

    public void showSets(String gagnant)
    {
        TextView textSet11 = (TextView) findViewById(R.id.textSet11);
        TextView textSet12 = (TextView) findViewById(R.id.textSet12);
        TextView textSet13 = (TextView) findViewById(R.id.textSet13);
        TextView textSet14 = (TextView) findViewById(R.id.textSet14);
        TextView textSet15 = (TextView) findViewById(R.id.textSet15);
        TextView textSet21 = (TextView) findViewById(R.id.textSet21);
        TextView textSet22 = (TextView) findViewById(R.id.textSet22);
        TextView textSet23 = (TextView) findViewById(R.id.textSet23);
        TextView textSet24 = (TextView) findViewById(R.id.textSet24);
        TextView textSet25 = (TextView) findViewById(R.id.textSet25);

            if(gagnant.equals("J1"))
            {
                switch(nbMatch)
                {
                    case 1:
                        int set11 = Integer.parseInt(textSet11.toString());
                        int set21 = Integer.parseInt(textSet21.toString());

                        set11 = set11 + 1;
                        textSet11.setText(set11);
                        if(set11>=6 && set21<=(set11-2))
                        {
                            nbMatch = nbMatch + 1;
                        }
                        break;
                    case 2:
                        int set12 = Integer.parseInt(textSet12.toString());
                        int set22 = Integer.parseInt(textSet22.toString());

                        set12 = set12 + 1;
                        textSet12.setText(set12);
                        if(set12>=6 && set22<=(set12-2))
                        {
                            nbMatch = nbMatch + 1;
                        }
                        break;
                    case 3:
                        int set13 = Integer.parseInt(textSet13.toString());
                        int set23 = Integer.parseInt(textSet23.toString());

                        set13 = set13 + 1;
                        textSet13.setText(set13);
                        if(set13>=6 && set23<=(set13-2))
                        {
                            nbMatch = nbMatch + 1;
                        }
                        break;
                    case 4:
                        int set14 = Integer.parseInt(textSet14.toString());
                        int set24 = Integer.parseInt(textSet24.toString());

                        set14 = set14 + 1;
                        textSet14.setText(set14);
                        if(set14>=6 && set24<=(set14-2))
                        {
                            nbMatch = nbMatch + 1;
                        }
                        break;
                    case 5:
                        int set15 = Integer.parseInt(textSet15.toString());
                        int set25 = Integer.parseInt(textSet25.toString());

                        set15 = set15 + 1;
                        textSet15.setText(set15);
                        if(set15>=6 && set25<=(set15-2))
                        {
                            //Victoire
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        }
                        break;

                }
            }

        if(gagnant.equals("J2"))
        {
            switch(nbMatch)
            {
                case 1:
                    int set11 = Integer.parseInt(textSet11.toString());
                    int set21 = Integer.parseInt(textSet21.toString());

                    set21 = set21 + 1;
                    textSet21.setText(set21);
                    if(set21>=6 && set11<=(set21-2))
                    {
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 2:
                    int set12 = Integer.parseInt(textSet12.toString());
                    int set22 = Integer.parseInt(textSet22.toString());

                    set22 = set22 + 1;
                    textSet22.setText(set22);
                    if(set22>=6 && set12<=(set22-2))
                    {
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 3:
                    int set13 = Integer.parseInt(textSet13.toString());
                    int set23 = Integer.parseInt(textSet23.toString());

                    set23 = set23 + 1;
                    textSet23.setText(set23);
                    if(set23>=6 && set13<=(set23-2))
                    {
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 4:
                    int set14 = Integer.parseInt(textSet14.toString());
                    int set24 = Integer.parseInt(textSet24.toString());

                    set24 = set24 + 1;
                    textSet24.setText(set24);
                    if(set24>=6 && set14<=(set24-2))
                    {
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 5:
                    int set15 = Integer.parseInt(textSet15.toString());
                    int set25 = Integer.parseInt(textSet25.toString());

                    set25 = set25 + 1;
                    textSet25.setText(set25);
                    if(set25>=6 && set15<=(set25-2))
                    {
                        //Victoire
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    }
                    break;

            }
        }
    }
}

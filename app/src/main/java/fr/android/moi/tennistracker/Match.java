package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class  Match extends AppCompatActivity {

    DatabaseHelper myDb;
    int nbMatch = 1;
    int win1 = 0;
    int win2 = 0;
    String J1 = "";
    String J2 = "";
    String JGagnant = "Aucun";
    float premierServiceJ1 = 0;
    float premierServiceJ2 = 0;
    float nbServicesJ1 = 0;
    float nbServicesJ2 = 0;
    float DFServiceJ1 = 0;
    float DFServiceJ2 = 0;
    float pointGagnantJ1 = 0;
    float pointGagnantJ2 = 0;
    float fautesJ1 = 0;
    float fautesJ2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        myDb = new DatabaseHelper(this);

        Bundle b = getIntent().getExtras();
        J1 = b.getString("J1");
        J2 = b.getString("J2");

        TextView textService = (TextView) findViewById(R.id.textService);
        TextView textJ1 = (TextView) findViewById(R.id.textJ1);
        TextView textJ2 = (TextView) findViewById(R.id.textJ2);
        TextView textEchangeJ1 = (TextView) findViewById(R.id.textEchangeJ1);
        TextView textEchangeJ2 = (TextView) findViewById(R.id.textEchangeJ2);
        textService.setText("Service " + J1 + " :");
        textJ1.setText(J1);
        textJ2.setText(J2);
        textEchangeJ1.setText(J1);
        textEchangeJ2.setText(J2);
    }

    public void onClick2(View view)
    {
        TextView Service = (TextView) findViewById(R.id.textService);
        String textService = Service.getText().toString();

        switch(view.getId())
        {
            case R.id.button1Ace:
                if(textService.equals("Service " + J1 + " :"))
                {
                    premierServiceJ1 = premierServiceJ1 + 1;
                    nbServicesJ1 = nbServicesJ1 + 1;
                    showPoints("J1");
                }
                if(textService.equals("Service " + J2 + " :"))
                {
                    premierServiceJ2 = premierServiceJ2 + 1;
                    nbServicesJ2 = nbServicesJ2 + 1;
                    showPoints("J2");
                }
                break;
            case R.id.button2Ace:
                if(textService.equals("Service " + J1 + " :"))
                {
                    nbServicesJ1 = nbServicesJ1 + 1;
                    showPoints("J1");
                }
                if(textService.equals("Service " + J2 + " :"))
                {
                    nbServicesJ2 = nbServicesJ2 + 1;
                    showPoints("J2");
                }
                break;
            case R.id.buttonDoubleFaute:
                if(textService.equals("Service " + J1 + " :"))
                {
                    DFServiceJ1 = DFServiceJ1 + 1;
                    nbServicesJ1 = nbServicesJ1 + 1;
                    showPoints("J2");
                }
                if(textService.equals("Service " + J2 + " :"))
                {
                    DFServiceJ2 = DFServiceJ2 + 1;
                    nbServicesJ2 = nbServicesJ2 + 1;
                    showPoints("J1");
                }
                break;
            case R.id.button1Service:
                if(textService.equals("Service " + J1 + " :"))
                {
                    premierServiceJ1 = premierServiceJ1 + 1;
                    nbServicesJ1 = nbServicesJ1 + 1;
                }
                if(textService.equals("Service " + J2 + " :"))
                {
                    premierServiceJ2 = premierServiceJ2 + 1;
                    nbServicesJ2 = nbServicesJ2 + 1;
                }
                break;
            case R.id.button2service:
                if(textService.equals("Service " + J1 + " :"))
                {
                    nbServicesJ1 = nbServicesJ1 + 1;
                }
                if(textService.equals("Service " + J2 + " :"))
                {
                    nbServicesJ2 = nbServicesJ2 + 1;
                }
                break;
            case R.id.button1PG:
                pointGagnantJ1 = pointGagnantJ1 + 1;
                showPoints("J1");
                break;
            case R.id.button2PG:
                pointGagnantJ2 = pointGagnantJ2 + 1;
                showPoints("J2");
                break;
            case R.id.button1FD:
                fautesJ1 = fautesJ1 + 1;
                showPoints("J2");
                break;
            case R.id.button2FD:
                fautesJ2 = fautesJ2 + 1;
                showPoints("J1");
                break;
            case R.id.button1FP:
                fautesJ1 = fautesJ1 + 1;
                showPoints("J2");
                break;
            case R.id.button2FP:
                fautesJ2 = fautesJ2 + 1;
                showPoints("J1");
                break;
            case R.id.buttonRetour:
                finish();
                break;
            case R.id.buttonTerminer:
                if(nbServicesJ1!=0)
                {
                    premierServiceJ1 = premierServiceJ1 / nbServicesJ1;
                    premierServiceJ1 = premierServiceJ1 * 100;
                }
                if(nbServicesJ2!=0)
                {
                    premierServiceJ2 = premierServiceJ2 / nbServicesJ2;
                    premierServiceJ2 = premierServiceJ2 * 100;
                }
                myDb.insertData(J1, J2, JGagnant, premierServiceJ1, premierServiceJ2, DFServiceJ1, DFServiceJ2, pointGagnantJ1, pointGagnantJ2, fautesJ1, fautesJ2);
                finish();
                break;
        }
    }

    public void showPoints(String gagnant)
    {
        TextView textPoints1 = (TextView) findViewById(R.id.textPoints1);
        TextView textPoints2 = (TextView) findViewById(R.id.textPoints2);
        TextView textService = (TextView) findViewById(R.id.textService) ;
        String points1 = textPoints1.getText().toString();
        String points2 = textPoints2.getText().toString();
        String service = textService.getText().toString();

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
                    else if(points2.equals("AV"))
                    {
                        textPoints2.setText("40");
                    }
                    else
                    {
                        textPoints1.setText("0");
                        textPoints2.setText("0");
                        showSets("J1");
                        if(service.equals("Service " + J1 + " :"))
                        {
                            textService.setText("Service " + J2 + " :");
                        }
                        if(service.equals("Service " + J2 + " :"))
                        {
                            textService.setText("Service " + J1 + " :");
                        }

                    }
                    break;
                case "AV":
                    textPoints1.setText("0");
                    textPoints2.setText("0");
                    showSets("J1");
                    if(service.equals("Service " + J1 + " :"))
                    {
                        textService.setText("Service " + J2 + " :");
                    }
                    if(service.equals("Service " + J2 + " :"))
                    {
                        textService.setText("Service " + J1 + " :");
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
                    else if(points1.equals("AV"))
                    {
                        textPoints1.setText("40");
                    }
                    else
                    {
                        textPoints1.setText("0");
                        textPoints2.setText("0");
                        showSets("J2");
                        if(service.equals("Service " + J1 + " :"))
                        {
                            textService.setText("Service " + J2 + " :");
                        }
                        if(service.equals("Service " + J2 + " :"))
                        {
                            textService.setText("Service " + J1 + " :");
                        }
                    }
                    break;
                case "AV":
                    textPoints1.setText("0");
                    textPoints2.setText("0");
                    showSets("J2");
                    if(service.equals("Service " + J1 + " :"))
                    {
                        textService.setText("Service " + J2 + " :");
                    }
                    if(service.equals("Service " + J2 + " :"))
                    {
                        textService.setText("Service " + J1 + " :");
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
                    int set11 = Integer.parseInt(textSet11.getText().toString());
                    int set21 = Integer.parseInt(textSet21.getText().toString());
                    set11 = set11 + 1;
                    textSet11.setText(String.valueOf(set11));
                    if(set11>=6 && set21<=(set11-2))
                    {
                        win1 = win1 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 2:
                    int set12 = Integer.parseInt(textSet12.getText().toString());
                    int set22 = Integer.parseInt(textSet22.getText().toString());
                    set12 = set12 + 1;
                    textSet12.setText(String.valueOf(set12));
                    if(set12>=6 && set22<=(set12-2))
                    {
                        win1 = win1 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 3:
                    int set13 = Integer.parseInt(textSet13.getText().toString());
                    int set23 = Integer.parseInt(textSet23.getText().toString());
                    set13 = set13 + 1;
                    textSet13.setText(String.valueOf(set13));
                    if(set13>=6 && set23<=(set13-2))
                    {
                        win1 = win1 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 4:
                    int set14 = Integer.parseInt(textSet14.getText().toString());
                    int set24 = Integer.parseInt(textSet24.getText().toString());
                    set14 = set14 + 1;
                    textSet14.setText(String.valueOf(set14));
                    if(set14>=6 && set24<=(set14-2))
                    {
                        win1 = win1 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 5:
                    int set15 = Integer.parseInt(textSet15.getText().toString());
                    int set25 = Integer.parseInt(textSet25.getText().toString());
                    set15 = set15 + 1;
                    textSet15.setText(String.valueOf(set15));
                    if(set15>=6 && set25<=(set15-2))
                    {
                        JGagnant = J1;
                        premierServiceJ1 = premierServiceJ1 / nbServicesJ1;
                        premierServiceJ2 = premierServiceJ2 / nbServicesJ2;
                        myDb.insertData(J1, J2, JGagnant, premierServiceJ1, premierServiceJ2, DFServiceJ1, DFServiceJ2, pointGagnantJ1, pointGagnantJ2, fautesJ1, fautesJ2);
                        Intent intent = new Intent(getApplicationContext(), Victoire.class);
                        intent.putExtra("gagnant", J1);
                        startActivity(intent);
                        finish();
                    }
                    break;

            }
        }

        if(gagnant.equals("J2"))
        {
            switch(nbMatch)
            {
                case 1:
                    int set11 = Integer.parseInt(textSet11.getText().toString());
                    int set21 = Integer.parseInt(textSet21.getText().toString());
                    set21 = set21 + 1;
                    textSet21.setText(String.valueOf(set21));
                    if(set21>=6 && set11<=(set21-2))
                    {
                        win2 = win2 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 2:
                    int set12 = Integer.parseInt(textSet12.getText().toString());
                    int set22 = Integer.parseInt(textSet22.getText().toString());
                    set22 = set22 + 1;
                    textSet22.setText(String.valueOf(set22));
                    if(set22>=6 && set12<=(set22-2))
                    {
                        win2 = win2 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 3:
                    int set13 = Integer.parseInt(textSet13.getText().toString());
                    int set23 = Integer.parseInt(textSet23.getText().toString());
                    set23 = set23 + 1;
                    textSet23.setText(String.valueOf(set23));
                    if(set23>=6 && set13<=(set23-2))
                    {
                        win2 = win2 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 4:
                    int set14 = Integer.parseInt(textSet14.getText().toString());
                    int set24 = Integer.parseInt(textSet24.getText().toString());
                    set24 = set24 + 1;
                    textSet24.setText(String.valueOf(set24));
                    if(set24>=6 && set14<=(set24-2))
                    {
                        win2 = win2 + 1;
                        testWin();
                        nbMatch = nbMatch + 1;
                    }
                    break;
                case 5:
                    int set15 = Integer.parseInt(textSet15.getText().toString());
                    int set25 = Integer.parseInt(textSet25.getText().toString());
                    set25 = set25 + 1;
                    textSet25.setText(String.valueOf(set25));
                    if(set25>=6 && set15<=(set25-2))
                    {
                        JGagnant = J2;
                        premierServiceJ1 = premierServiceJ1 / nbServicesJ1;
                        premierServiceJ2 = premierServiceJ2 / nbServicesJ2;
                        myDb.insertData(J1, J2, JGagnant, premierServiceJ1, premierServiceJ2, DFServiceJ1, DFServiceJ2, pointGagnantJ1, pointGagnantJ2, fautesJ1, fautesJ2);
                        Intent intent = new Intent(getApplicationContext(), Victoire.class);
                        intent.putExtra("gagnant", J2);
                        startActivity(intent);
                        finish();
                    }
                    break;

            }
        }
    }

    public void testWin()
    {
        if(win1>=3 && win2<=(win1-2))
        {
            JGagnant = J1;
            premierServiceJ1 = premierServiceJ1 / nbServicesJ1;
            premierServiceJ2 = premierServiceJ2 / nbServicesJ2;
            myDb.insertData(J1, J2, JGagnant, premierServiceJ1, premierServiceJ2, DFServiceJ1, DFServiceJ2, pointGagnantJ1, pointGagnantJ2, fautesJ1, fautesJ2);
            Intent intent = new Intent(getApplicationContext(), Victoire.class);
            intent.putExtra("gagnant", J1);
            startActivity(intent);
            finish();
        }
        if(win2>=3 && win1<=(win2-2))
        {
            JGagnant = J2;
            premierServiceJ1 = premierServiceJ1 / nbServicesJ1;
            premierServiceJ2 = premierServiceJ2 / nbServicesJ2;
            myDb.insertData(J1, J2, JGagnant, premierServiceJ1, premierServiceJ2, DFServiceJ1, DFServiceJ2, pointGagnantJ1, pointGagnantJ2, fautesJ1, fautesJ2);
            Intent intent = new Intent(getApplicationContext(), Victoire.class);
            intent.putExtra("gagnant", J2);
            startActivity(intent);
            finish();
        }
    }
}

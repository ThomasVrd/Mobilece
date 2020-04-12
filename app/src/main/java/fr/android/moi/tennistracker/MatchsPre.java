package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MatchsPre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchs_pre);
    }

    public void onClick5(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonRetour:
                finish();
                break;
            case R.id.match1:
                Intent intent = new Intent(getApplicationContext(), Statistics.class);
                intent.putExtra("number", 0);
                startActivity(intent);
                break;
            case R.id.match2:
                Intent intent1 = new Intent(getApplicationContext(), Statistics.class);
                intent1.putExtra("number", 1);
                startActivity(intent1);
                break;
            case R.id.match3:
                Intent intent2 = new Intent(getApplicationContext(), Statistics.class);
                intent2.putExtra("number", 2);
                startActivity(intent2);
                break;
            case R.id.match4:
                Intent intent3 = new Intent(getApplicationContext(), Statistics.class);
                intent3.putExtra("number", 3);
                startActivity(intent3);
                break;
            case R.id.match5:
                Intent intent4 = new Intent(getApplicationContext(), Statistics.class);
                intent4.putExtra("number", 4);
                startActivity(intent4);
                break;
            case R.id.match6:
                Intent intent5 = new Intent(getApplicationContext(), Statistics.class);
                intent5.putExtra("number", 5);
                startActivity(intent5);
                break;
            case R.id.match7:
                Intent intent6 = new Intent(getApplicationContext(), Statistics.class);
                intent6.putExtra("number", 6);
                startActivity(intent6);
                break;
            case R.id.match8:
                Intent intent7 = new Intent(getApplicationContext(), Statistics.class);
                intent7.putExtra("number", 7);
                startActivity(intent7);
                break;
            case R.id.match9:
                Intent intent8 = new Intent(getApplicationContext(), Statistics.class);
                intent8.putExtra("number", 8);
                startActivity(intent8);
                break;
            case R.id.match10:
                Intent intent9 = new Intent(getApplicationContext(), Statistics.class);
                intent9.putExtra("number", 9);
                startActivity(intent9);
                break;
        }
    }
}

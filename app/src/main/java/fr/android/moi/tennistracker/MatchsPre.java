package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class   MatchsPre extends AppCompatActivity {
    DatabaseHelper myDB;
    Stack<String> data = new Stack<String>();
    String[] ids = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchs_pre);
        myDB = new DatabaseHelper(this);
        ViewAll();
        setViews();

        /*for(int i = 0; i<ids.length; i++)
        {
            final String num = ids[i];
            int id = getResources().getIdentifier(ids[0], "id", "android");
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(getApplicationContext(), Statistics.class);
                    intent.putExtra("id", num);
                    startActivity(intent);
                }
            });
        }*/
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
                intent.putExtra("number", 1);
                startActivity(intent);
                break;
            case R.id.match2:
                Intent intent1 = new Intent(getApplicationContext(), Statistics.class);
                intent1.putExtra("number", 2);
                startActivity(intent1);
                break;
            case R.id.match3:
                Intent intent2 = new Intent(getApplicationContext(), Statistics.class);
                intent2.putExtra("number", 3);
                startActivity(intent2);
                break;
            case R.id.match4:
                Intent intent3 = new Intent(getApplicationContext(), Statistics.class);
                intent3.putExtra("number", 4);
                startActivity(intent3);
                break;
            case R.id.match5:
                Intent intent4 = new Intent(getApplicationContext(), Statistics.class);
                intent4.putExtra("number", 5);
                startActivity(intent4);
                break;
            case R.id.match6:
                Intent intent5 = new Intent(getApplicationContext(), Statistics.class);
                intent5.putExtra("number", 6);
                startActivity(intent5);
                break;
            case R.id.match7:
                Intent intent6 = new Intent(getApplicationContext(), Statistics.class);
                intent6.putExtra("number", 7);
                startActivity(intent6);
                break;
            case R.id.match8:
                Intent intent7 = new Intent(getApplicationContext(), Statistics.class);
                intent7.putExtra("number", 8);
                startActivity(intent7);
                break;
            case R.id.match9:
                Intent intent8 = new Intent(getApplicationContext(), Statistics.class);
                intent8.putExtra("number", 9);
                startActivity(intent8);
                break;
            case R.id.match10:
                Intent intent9 = new Intent(getApplicationContext(), Statistics.class);
                intent9.putExtra("number", 10);
                startActivity(intent9);
                break;
        }
    }


    public void ViewAll() {
        Cursor res = myDB.getAllData();

        if(res.getCount() == 0){
            return;
        }

        while (res.moveToNext()) {

            data.push(res.getString(0));
            data.push(res.getString(1));
            data.push(res.getString(2));
        }
        Log.d("data", String.valueOf(data));

    }

    @SuppressLint("ResourceType")
    public void setViews()
    {
        String J1 = "";
        String J2 = "";
        int i = 0;
        int size = data.size()/3;
        ids = new String[size];
        Log.d("ids", String.valueOf(ids));
        String[] textviews = {"match1", "match2", "match3", "match4", "match5", "match6", "match7", "match8", "match9", "match10"};
        while(!data.empty())
        {
            J2 = data.pop();
            J1 = data.pop();
            ids[i] = data.pop();
            Log.d("id", ids[i]);
            int textId = getResources().getIdentifier(textviews[i], "id", "android");
            Log.d("textId", String.valueOf(textId));
            TextView tv = findViewById(textId);
            tv.setText(J1 + " vs " + J2);
            i++;
        }

    }
}

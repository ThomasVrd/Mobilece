package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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
    }

    public void onClick5(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonRetour:
                finish();
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

    }

    @SuppressLint("ResourceType")
    public void setViews()
    {
        int size = data.size()/3;
        ids = new String[size];
        for(int i=0; i<size; i++)
        {
            String J2 = data.pop();
            String J1 = data.pop();
            ids[i] = data.pop();
            LinearLayout ll = (LinearLayout) findViewById(R.id.LinLay);
            Button tv = new Button(getApplicationContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(lp);
            tv.setText(J1 + " vs " + J2);
            tv.setTextSize(36);
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            tv.setTextColor(Color.parseColor("#FF000000"));
            tv.setBackgroundColor(0xFFFFFFFF);
            tv.setId(Integer.parseInt(ids[i]));
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Statistics.class);
                    intent.putExtra("id", ids[finalI]);
                    startActivity(intent);
                }
            });
            ll.addView(tv);
        }

    }
}

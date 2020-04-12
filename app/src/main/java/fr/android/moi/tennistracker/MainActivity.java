package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.buttonNvxMatch:
                Intent intent = new Intent(getApplicationContext(), NvxMatch.class);
                startActivity(intent);
                break;
            case R.id.buttonMatchsPre:
                Intent intent1 = new Intent(getApplicationContext(), MatchsPre.class);
                startActivity(intent1);
                break;
        }
    }
}

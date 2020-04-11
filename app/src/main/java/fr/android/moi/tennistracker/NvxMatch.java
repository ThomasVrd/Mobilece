package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NvxMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvx_match);
    }

    public void onClick1(View view)
    {
        switch(view.getId())
        {
            case R.id.buttonStart:
                Intent intent = new Intent(getApplicationContext(), Match.class);
                startActivity(intent);
                break;
        }
    }
}

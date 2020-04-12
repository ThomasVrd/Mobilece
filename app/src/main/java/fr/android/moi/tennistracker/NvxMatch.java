package fr.android.moi.tennistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
                EditText editJ1 = (EditText) findViewById(R.id.editJ1) ;
                EditText editJ2 = (EditText) findViewById(R.id.editJ2) ;
                Intent intent = new Intent(getApplicationContext(), Match.class);
                intent.putExtra("J1", editJ1.getText().toString());
                intent.putExtra("J2", editJ2.getText().toString());
                startActivity(intent);
                finish();
                break;
        }
    }
}

package com.example.ejesh.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {
    Button strtBtn;
    HealthilyPreference healthilyPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        healthilyPreference = new HealthilyPreference (this);
        strtBtn =(Button) findViewById(R.id.strtBtn);
        strtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(healthilyPreference.hasLoggedIn ()){
                    Intent startIntent = new Intent(Start.this , Category.class);
                    startActivity(startIntent);
                }else {
                    Intent startIntent = new Intent(Start.this , SignUp.class);
                    startActivity(startIntent);
                }


            }
        });
    }

}

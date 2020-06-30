package com.example.savedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThankYou extends AppCompatActivity {

    Button logout,New;
    TextView other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        other =(TextView)findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankYou.this, Questions.class);
                startActivity(intent);
            }
        });

        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceUtils.savePassword(null, ThankYou.this);
                PreferenceUtils.saveEmail(null, ThankYou.this);
                Intent intent = new Intent(ThankYou.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        New=(Button)findViewById(R.id.New);
        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankYou.this, MainActivity5.class);
                startActivity(intent);
            }
        });

    }
}

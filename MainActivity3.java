package com.example.savedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    CardView excellent,very,good,avg,poor;
    String string1 = "Very Good";
    String string2 = "Good";
    String string3 = "Average";
    String string4 = "Bad";
    String string5 = "Very Bad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        excellent=(CardView)findViewById(R.id.excellent);
        very=(CardView)findViewById(R.id.very);
        good=(CardView)findViewById(R.id.good);
        avg=(CardView)findViewById(R.id.avg);
        poor=(CardView)findViewById(R.id.poor);

        excellent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,search.class);
                intent.putExtra("responce",string1);
                startActivity(intent);
            }
        });

        very.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,search.class);
                intent.putExtra("responce",string2);

                startActivity(intent);
            }
        });

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,search.class);
                intent.putExtra("responce",string3);
                startActivity(intent);
            }
        });

        avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,search.class);
                intent.putExtra("responce",string4);
                startActivity(intent);
            }
        });

        poor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,search.class);
                intent.putExtra("responce",string5);
                startActivity(intent);
            }
        });




    }
}

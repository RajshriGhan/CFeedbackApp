package com.example.savedata;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText1,editText2,editText3;
    Button submit, fetch;
    DatabaseReference rootRef, demoRef;
    TextView demoValue,demoValue1,demoValue2,demoValue3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etName);
        editText1 = (EditText) findViewById(R.id.etRes);
        editText2 = (EditText) findViewById(R.id.etDate);
        editText3 = (EditText) findViewById(R.id.etMsg);
        demoValue = (TextView) findViewById(R.id.tvalue);
        demoValue1 = (TextView) findViewById(R.id.tvalue1);
        demoValue2 = (TextView) findViewById(R.id.tvalue2);
        demoValue3 = (TextView) findViewById(R.id.tvalue3);
        submit = (Button) findViewById(R.id.btnSubmit);
        fetch = (Button) findViewById(R.id.btnFetch);

        //EditText textViewDate = findViewById(R.id.etDate);
        //Date timenow = Calendar.getInstance().getTime();
        //textViewDate.setText(timenow.toString());

        //Date today = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //String dateToStr = format.format(today);
        //System.out.println(dateToStr);

        EditText tdate = (EditText) findViewById(R.id.etDate);
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy hh-mm-ss a");
        String dateString = sdf.format(date);
        //getActionBar().setTitle(dateString);
        tdate.setText(dateString);

        editText1.setText(getIntent().getStringExtra("responce"));

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("demo");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = editText.getText().toString();
                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();
                String value3 = editText3.getText().toString();

                //push creates a unique id in database
                demoRef.child("value").setValue(value);
                demoRef.child("value1").setValue(value1);
                demoRef.child("value2").setValue(value2);
                demoRef.child("value3").setValue(value3);

                Intent intent=new Intent(MainActivity.this,ThankYou.class);
                startActivity(intent);
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.child("value").getValue(String.class);
                        demoValue.setText(value);
                        String value1 = dataSnapshot.child("value1").getValue(String.class);
                        demoValue1.setText(value1);
                        String value2 = dataSnapshot.child("value2").getValue(String.class);
                        demoValue2.setText(value2);
                        String value3 = dataSnapshot.child("value3").getValue(String.class);
                        demoValue3.setText(value3);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
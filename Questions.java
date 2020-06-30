package com.example.savedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Questions extends AppCompatActivity {

    EditText Answer1, Answer2, Answer3;
    Button btn,fetch;
    DatabaseReference rootRef, answersRef;
    TextView demoAnswer1,demoAnswer2,demoAnswer3;



    private final AppCompatActivity activity = Questions.this;


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Answer1 = (EditText) findViewById(R.id.Answer1);
        Answer2 = (EditText) findViewById(R.id.Answer2);
        Answer3 = (EditText) findViewById(R.id.Answer3);
        btn = (Button) findViewById(R.id.btn);
        fetch = (Button) findViewById(R.id.fetch);


        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        answersRef = rootRef.child("answers");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String value1 = Answer1.getText().toString();
                String value2 = Answer2.getText().toString();
                String value3 = Answer3.getText().toString();

                //push creates a unique id in database
                answersRef.child("Answer1").setValue(value1);
                answersRef.child("Answer2").setValue(value2);
                answersRef.child("Answer3").setValue(value3);


                Intent intent= new Intent(Questions.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answersRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String Answer1 = dataSnapshot.child("Answer1").getValue(String.class);
                        demoAnswer1.setText(Answer1);
                        String Answer2 = dataSnapshot.child("Answer2").getValue(String.class);
                        demoAnswer2.setText(Answer2);
                        String Answer3 = dataSnapshot.child("Answer3").getValue(String.class);
                        demoAnswer3.setText(Answer3);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
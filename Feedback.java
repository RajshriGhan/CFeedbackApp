package com.example.savedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.savedata.InputValidation;

import java.util.Calendar;
import java.util.Date;

public class Feedback extends AppCompatActivity {

    Button submit;
    TextView tv;

    private final AppCompatActivity activity = Feedback.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private InputValidation inputValidation;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submit = (Button) findViewById(R.id.submit);
        tv = (TextView) findViewById(R.id.tv);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        //Calendar calendar = Calendar.getInstance();
        //String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextInputEditText textViewDate = findViewById(R.id.textInputEditTextPassword);
        Date timenow = Calendar.getInstance().getTime();
        textViewDate.setText(timenow.toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textInputEditTextName.getText().toString().isEmpty()) {
                    Toast.makeText(Feedback.this, "Name Field is Empty", Toast.LENGTH_SHORT).show();
                }
                if (textInputEditTextConfirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(Feedback.this, "Message Field is Empty", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Feedback.this, ThankYou.class);
                    startActivity(intent);
                    Toast.makeText(Feedback.this, "Success", Toast.LENGTH_LONG).show();
                }
            }
        });

        textInputEditTextEmail.setText(getIntent().getStringExtra("responce"));

        //initViews();
        //initListeners();
        //initObjects();

    }

    /*
    private void initViews(){
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        //appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        //appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);
    }

    private void initObjects(){
        inputValidation = new InputValidation(activity);
        //databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.submit:
                postDataToSQLite();
                Toast.makeText(Feedback.this,"Success",Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void postDataToSQLite(){
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message))) {
            return;
        }

    }*/
}

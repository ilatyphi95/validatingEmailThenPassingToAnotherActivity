package com.ilatyphi95.simpleemailvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static final Pattern EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String PASSWORD = "com.ilatyphi95.simpleemailvalidation.password";
    public static final String EMAIL = "com.ilatyphi95.simpleemailvalidation.email";

    private String mPassword;
    private String mEmail;
    private Boolean mValidInput;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtEmail = findViewById(R.id.et_email);
        mEtPassword = findViewById(R.id.et_password);
        mToast = new Toast(this);

        Button btSignIn = findViewById(R.id.button);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });


    }

    private void validateInput() {
        mValidInput = true;
        mPassword = mEtPassword.getText().toString().trim();
        mEmail = mEtEmail.getText().toString().trim();

        if(mPassword.isEmpty()) {
            mValidInput = false;
            if( mToast != null) {
                mToast.cancel();
            }
            mToast.makeText(this, "Invalid Password", Toast.LENGTH_LONG).show();
        }
        if(mEmail.isEmpty() || !(EMAIL_ADDRESS_REGEX.matcher(mEmail).find())){
            mValidInput = false;
            if( mToast != null) {
                mToast.cancel();
            }
            mToast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show();
        }

        if(mValidInput) {
            if( mToast != null) {
                mToast.cancel();
            }
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(PASSWORD, mPassword);
            intent.putExtra(EMAIL, mEmail);
            startActivity(intent);
        }

    }
}

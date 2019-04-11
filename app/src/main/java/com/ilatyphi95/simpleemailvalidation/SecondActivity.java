package com.ilatyphi95.simpleemailvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvPassword;
    private TextView mTvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        mTvEmail = findViewById(R.id.tv_email);
        mTvPassword = findViewById(R.id.tv_password);

        String email = intent.getStringExtra(MainActivity.EMAIL);
        String password = intent.getStringExtra(MainActivity.PASSWORD);

        mTvEmail.setText(email);
        mTvPassword.setText(password);
    }
}

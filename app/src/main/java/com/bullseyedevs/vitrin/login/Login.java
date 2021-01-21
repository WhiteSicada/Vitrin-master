package com.bullseyedevs.vitrin.login;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bullseyedevs.vitrin.MainActivity;
import com.bullseyedevs.vitrin.R;


public class Login extends AppCompatActivity {
    EditText usernameLogin, mPassword;
    Button mLoginBtn;
    TextView linkToRegister;
    ProgressBar progressBar;
    private DataBaseHelper myDb;

    //    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        mPassword = (EditText) findViewById(R.id.passwordLogin);
        mLoginBtn = (Button) findViewById(R.id.btnLogin);
        linkToRegister = (TextView) findViewById(R.id.linkToRegister);
        progressBar = findViewById(R.id.progressBar);

        linkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
        myDb = new DataBaseHelper(this);

        loginUser();


    }

    private void loginUser(){
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(usernameLogin.getText().toString() , mPassword.getText().toString());
                if (var){
                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this , MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


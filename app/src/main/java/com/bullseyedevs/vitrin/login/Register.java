package com.bullseyedevs.vitrin.login;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;




import com.bullseyedevs.vitrin.MainActivity;
import com.bullseyedevs.vitrin.R;


import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mEmail,mPassword,usernameRegister;
    Button mRegisterBtn;
    private DataBaseHelper myDB;
//    FirebaseAuth fAuth;
    ProgressBar progressBar;
//    FirebaseFirestore fStore;
    String userID;
    TextView linkToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameRegister = (EditText) findViewById(R.id.usernameRegister);
        mEmail = (EditText) findViewById(R.id.emailRegister);
        mPassword = (EditText) findViewById(R.id.passwordRegister);
        mRegisterBtn = (Button) findViewById(R.id.btnRegister);
        linkToLogin = (TextView) findViewById(R.id.linkToLogin);
        progressBar = findViewById(R.id.progressBar);



        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.bullseyedevs.vitrin.login.Register.this,Login.class);
                startActivity(intent);
            }
        });

        myDB = new DataBaseHelper(this);
        insertUser();



    }

    private void insertUser(){
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameRegister.getText().toString();
                String password = mPassword.getText().toString();
                String email = mEmail.getText().toString();
                boolean var = myDB.registerUser( username, email , password);
                if(var){
                    Toast.makeText(Register.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Register.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG ="LoginActivity" ;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;
    ParseUser user = new ParseUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(ParseUser.getCurrentUser() != null){
            gotMainActivity();
        }
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnLogin.setBackgroundColor(Color.BLUE);
        btnSignup.setBackgroundColor(Color.GREEN);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        }
        );
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick signup button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                signupUser(username, password);
                                        }
                                    }
        );

    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Atempting to log in user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
              if(e!=null){
                  Toast.makeText(LoginActivity.this, "Issue with Login!",Toast.LENGTH_SHORT).show();
                  Log.e(TAG, "Issue with login",e);
                  return;
              }
              gotMainActivity();
                Toast.makeText(LoginActivity.this, "Succes!",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void signupUser(String username, String password) {
        Log.i(TAG, "Atempting to Signup user" + username);
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.e(TAG, "signup succeed",e);
                } else {
                    Log.e(TAG, "Issue with Signup",e);
                    return;
                }

                Toast.makeText(LoginActivity.this, "Succes!",Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void gotMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        //user are not logged out when clicking on back button
        finish();
    }
}
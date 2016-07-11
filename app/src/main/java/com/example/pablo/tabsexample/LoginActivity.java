package com.example.pablo.tabsexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
    }

    public void loginClick(View view) {
        Log.d("LoginActivity", "You click me!");
        Log.d("LoginActivity", "Username: " +username.getText());
        Log.d("LoginActivity", "Password: " +password.getText());

        String rightUsername = "admin";
        String rightPassword = "foobar";

        if(rightUsername.equals(username.getText().toString()) &&
                rightPassword.equals(password.getText().toString())){
            //Login Ok
            Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show();

            SharedPreferences preferences = getSharedPreferences(getString(R.string.db_name), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", username.getText().toString());
            editor.commit();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            //Login Fail
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show();
        }

    }
}

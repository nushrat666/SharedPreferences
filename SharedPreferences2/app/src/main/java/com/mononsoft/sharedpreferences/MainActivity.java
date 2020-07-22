package com.mononsoft.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText emailET, passET;
    private TextView showInfoTV;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET=findViewById(R.id.userEmail);
        passET=findViewById(R.id.userPassword);
        showInfoTV=findViewById(R.id.showUser);

        sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public void loginUser(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();

        editor.putString("email",email);
        editor.putString("password",pass);
        editor.commit();
    }

    public void showUser(View view) {

        String email = sharedPreferences.getString("email","email not found");
        String pass = sharedPreferences.getString("password","no password was set");
        showInfoTV.setText(email+"\n"+pass);
    }

    public void resetUser(View view) {

        editor.clear();
        editor.commit();
    }
}
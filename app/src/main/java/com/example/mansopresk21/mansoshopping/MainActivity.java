package com.example.mansopresk21.mansoshopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button facebook,google,signup,signin;
    EditText email,password;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String pswrd = "pswrdKey";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook = (Button)findViewById(R.id.fb_btn);
        google = (Button)findViewById(R.id.google_btn);
        signup = (Button)findViewById(R.id.signup);
        signin = (Button)findViewById(R.id.signin);
        email = (EditText)findViewById(R.id.emailid);
        password = (EditText)findViewById(R.id.password);

        sharedpreferences = getSharedPreferences("userdetails",MODE_PRIVATE);
        String uname = sharedpreferences.getString("email",null);
        if(uname!=null){
            Intent i=new Intent(this,NavigationMainActivity.class);
            startActivity(i);
        }
    }
    public void valid(View v){
        if(email.getText().toString().isEmpty()){
            email.requestFocus();
            email.setError("");
        }
        else if (password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("");
        }
        else {
            String usrname = email.getText().toString();
            String pswrd = password.getText().toString();
//            sharedpreferences = getSharedPreferences("email",MODE_PRIVATE);
            editor = getSharedPreferences("userdetails",MODE_PRIVATE).edit();
            editor.putString("email",usrname);
            editor.putString("password",pswrd);
            editor.commit();
            if(sharedpreferences!=null) {

            Intent i = new Intent(MainActivity.this,NavigationMainActivity.class);
            startActivity(i);
        }
    }}

    public void close(View v){
        Intent i2 = new Intent(MainActivity.this,NavigationMainActivity.class);
        startActivity(i2);
    }
}

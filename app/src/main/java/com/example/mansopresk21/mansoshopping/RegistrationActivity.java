package com.example.mansopresk21.mansoshopping;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
    EditText firstname,lastname,edtemail,edtmobile,edtpass,edtcnfrmpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstname=(EditText)findViewById(R.id.edtfirstname);
        lastname=(EditText)findViewById(R.id.edtlastname);
        edtemail=(EditText)findViewById(R.id.edtemail);
        edtmobile=(EditText)findViewById(R.id.edtmobile);
        edtpass=(EditText)findViewById(R.id.edtPass);
        edtcnfrmpass=(EditText)findViewById(R.id.edtconfrmpass);
    }

    public void r1(View v){
        if (firstname.getText().toString().isEmpty()) {
            firstname.requestFocus();
            firstname.setError("");
        } else if (lastname.getText().toString().isEmpty()) {
            lastname.requestFocus();
            lastname.setError("");

        }
        else if (lastname.getText().toString().isEmpty()) {
            lastname.requestFocus();
            lastname.setError("");

        }
        else if (edtemail.getText().toString().isEmpty()) {
            edtemail.requestFocus();
            edtemail.setError("");

        }
        else if (edtmobile.getText().toString().isEmpty()) {
            edtmobile.requestFocus();
            edtmobile.setError("");

        }
        else if (edtpass.getText().toString().isEmpty()) {
            edtpass.requestFocus();
            edtpass.setError("");

        }

        else if (edtcnfrmpass.getText().toString().isEmpty()) {
            edtcnfrmpass.requestFocus();
            edtcnfrmpass.setError("");

        }else {
            Intent it = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(it);


        }
    }
}


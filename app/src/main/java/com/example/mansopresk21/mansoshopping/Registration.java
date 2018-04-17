package com.example.mansopresk21.mansoshopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registration extends Activity
{
    EditText et1, et2, et3, et4, et5, et6;
    public static final String REF_NAME = "RegisterValues";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        et1 = (EditText) findViewById(R.id.edtfirstname);
        et2 = (EditText) findViewById(R.id.edtlastname);
        et3 = (EditText) findViewById(R.id.edtemail);
        et4 = (EditText) findViewById(R.id.edtmobile);
        et5 = (EditText) findViewById(R.id.edtPass);
        et6 = (EditText) findViewById(R.id.edtconfrmpass);


    }

    public void register(View v)
    {

        if (et1.getText().toString().isEmpty())
        {
            et1.requestFocus();
            et1.setError("");
        }

         else if (et2.getText().toString().isEmpty())
         {
            et2.requestFocus();
            et2.setError("");
        }
        else if( et3.getText().toString().isEmpty())
        {
            et3.requestFocus();
            et3.setError("");

        }
       else if (et4.getText().toString().isEmpty())
       {
           et4.requestFocus();
           et4.setError("");

        }
        else if (et5.getText().toString().isEmpty())
        {
            et5.requestFocus();
            et5.setError("");

        }
        else if (et6.getText().toString().isEmpty())
        {
            et6.requestFocus();
            et6.setError("");

        }
        else
            {

            String uname = et1.getText().toString();
            String lastname = et2.getText().toString();
            String mail = et3.getText().toString().trim();
            String mobile = et4.getText().toString().trim();
            String password = et5.getText().toString().trim();
            String cnfrmpasword = et6.getText().toString().trim();

            if (mail.contains("@") && mail.contains(".com"))
            {
                RegisterValues register = new RegisterValues(uname, lastname, mail, mobile, password, cnfrmpasword);
                FirebaseDatabase fd = FirebaseDatabase.getInstance();
                DatabaseReference dr = fd.getReference(REF_NAME);
                dr.child(uname).setValue(register);
                Toast.makeText(this, "Data added to database", Toast.LENGTH_SHORT).show();

                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");

                DatabaseReference fd1 = FirebaseDatabase.getInstance().getReference(REF_NAME).child(uname);

                fd1.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {

                        if (dataSnapshot.exists())
                        {
                            RegisterValues d = dataSnapshot.getValue(RegisterValues.class);
                            String mail_get = d.getEmail();
                            String pass_get = d.getPassword();

                            Intent i = new Intent(Registration.this, MainActivity.class);
                            i.putExtra("k1", mail_get);
                            i.putExtra("k2", pass_get);
                            startActivity(i);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError)
                    {

                    }
                });
                Toast.makeText(this, "Registered succesfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "provide proper email id", Toast.LENGTH_SHORT).show();
            }
        }

    }

}

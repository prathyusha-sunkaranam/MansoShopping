package com.example.mansopresk21.mansoshopping;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import de.hdodenhof.circleimageview.CircleImageView;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    ImageView imgvw;

    Fragment fragment1,fragment2,fragmentkids;

    SharedPreferences sharedPreferences;
    TextView nav_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        imgvw = (ImageView)findViewById(R.id.content_img);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        nav_text = (TextView)header.findViewById(R.id.nav_text);
        CircleImageView drawerHeaderImage = (CircleImageView) header.findViewById(R.id.circularImageId);

        sharedPreferences = getSharedPreferences("userdetails", MODE_PRIVATE);
        String uname = sharedPreferences.getString("email", null);
        if(sharedPreferences!=null) {
            if (uname != null || uname != "") {
                nav_text.setText(uname);
            } else {
                Intent i = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Logout completely", Toast.LENGTH_SHORT).show();
                startActivity(i);

            }
        }

    }
    public void login (View v){
        Intent i = new Intent(NavigationMainActivity.this,MainActivity.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_main, menu);
//        fragment = new Home();
//        hf = (Home) fragment;
//        fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
//        Ftransaction=fragmentManager.beginTransaction();
//        Ftransaction.show(hf);
//        Ftransaction.commit();




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home){




        }

        else  if (id == R.id.women_label) {

            Fragment1 fragment1 = new Fragment1();
          FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fr1, fragment1);
            transaction.addToBackStack(null);

            transaction=fragmentManager.beginTransaction();
            transaction.show(fragment1);
            transaction.hide(fragment2);
            transaction.hide(fragmentkids);

            transaction.commit();





            // Handle the camera action
        } else if (id == R.id.men_label) {
            Fragment2 fragment2 = new Fragment2();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fr1, fragment2);
            transaction.addToBackStack(null);

            transaction=fragmentManager.beginTransaction();
            transaction.show(fragment2);
            transaction.hide(fragment1);
            transaction.hide(fragmentkids);
            transaction.commit();

            imgvw.setVisibility(View.GONE);

        } else if (id == R.id.kids_label) {
            FragmentKids fragmentKids = new FragmentKids();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fr1, fragmentKids);
            transaction.addToBackStack(null);
            transaction=fragmentManager.beginTransaction();

            transaction.show(fragmentkids);
            transaction.hide(fragment1);
            transaction.hide(fragment2);

            transaction.commit();

            imgvw.setVisibility(View.GONE);

        } else if (id == R.id.accessories_label) {

        } else if (id == R.id.homelvng_label) {

        } else if (id == R.id.sports_label) {

        }
        else if (id == R.id.aboutus_label) {

        }
        else if (id == R.id.rate_label) {

        }
        else if (id == R.id.logout_label) {
            getApplicationContext().getSharedPreferences("userdetails", 0).edit().clear().commit();
            nav_text.setText("Login/Sign Up");

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

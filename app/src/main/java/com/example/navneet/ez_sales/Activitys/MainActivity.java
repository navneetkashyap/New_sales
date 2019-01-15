package com.example.navneet.ez_sales.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.navneet.ez_sales.R;
import com.example.navneet.ez_sales.SessionManager.SessionManager;

public class MainActivity extends AppCompatActivity{

   LinearLayout logoutbtn,clinents,llopendwar;
    SessionManager  sessionManager;
    DrawerLayout drawerLayout;

    String open_close = "0";
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        llopendwar = findViewById(R.id.dwaropen);
        drawerLayout = findViewById(R.id.drawer_layout);

        logoutbtn = findViewById(R.id.ll_logoutbtn);
        clinents = findViewById(R.id.clinents);
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.My_clients, R.string.action_settings);

//        dl.addDrawerListener(t);
//        t.syncState();

        ///getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                //Toast.makeText(getApplicationContext(),"aaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
                if (id == R.id.nav_item_ones) {
                    Toast.makeText(getApplicationContext(),"dvddv",Toast.LENGTH_SHORT).show();
                    // Handle the camera action
                } else if (id == R.id.nav_item_two) {
                    Toast.makeText(getApplicationContext(),"hghghghghghghghg",Toast.LENGTH_SHORT).show();
                }

                //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                // drawer.closeDrawer(GravityCompat.START);
                return true;



                /*int id = item.getItemId();
                switch(id)
                {
                    case R.id.nav_item_ones:
                        Toast.makeText(Main2Activity.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.nav_item_two:
                        Toast.makeText(Main2Activity.this, "Settings",Toast.LENGTH_SHORT).show();
                    case R.id.nav_item_one:
                        Toast.makeText(Main2Activity.this, "My Cart",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }*/




            }
        });

        clinents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Clients.class);
                startActivity(i);
            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sessionManager.logoutUser();

                Intent i = new Intent(MainActivity.this,Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();

            }
        });

        llopendwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(open_close.equals("0")){

                   // open_close = "1";
                    drawerLayout.openDrawer(GravityCompat.START);
                }else {
                    //open_close = "0";
                    drawerLayout.closeDrawer(GravityCompat.START);


                }


            }
        });

       // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);

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

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

   /* @Override
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
    }*/

   // @SuppressWarnings("StatementWithEmptyBody")
    /*@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Toast.makeText(getApplicationContext(),"aaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
        if (id == R.id.nav_item_one) {
            Toast.makeText(getApplicationContext(),"dvddv",Toast.LENGTH_SHORT).show();
            // Handle the camera action
        } else if (id == R.id.nav_item_one) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}

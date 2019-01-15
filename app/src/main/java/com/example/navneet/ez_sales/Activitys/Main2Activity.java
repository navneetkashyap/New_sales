package com.example.navneet.ez_sales.Activitys;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navneet.ez_sales.Adapters.CustomAdapterMYClinents;
import com.example.navneet.ez_sales.R;
import com.example.navneet.ez_sales.SessionManager.SessionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

import static com.example.navneet.ez_sales.SessionManager.SessionManager.USER_NAME;

public class Main2Activity extends Activity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    LinearLayout logoutbtn,clinents,llopendwar;
    String open_close = "0";
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    public static Dialog dialog;
    SessionManager sessionManager;
    TextView tvnavhedername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sessionManager = new SessionManager(this);

         checkAndRequestPermissions();

        llopendwar = findViewById(R.id.dwaropen);
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.My_clients, R.string.action_settings);
        dl.addDrawerListener(t);
        t.syncState();
         recyclerView = (RecyclerView)findViewById(R.id.clintlidt);
         floatingActionButton = findViewById(R.id.flot_btn);
        ///getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView)findViewById(R.id.nv);
        View hView =  nv.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_header_textView);
        nav_user.setText(sessionManager.getUserDetails().get(USER_NAME));



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapterMYClinents customAdapter = new CustomAdapterMYClinents(this, personNames);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clickflot",Toast.LENGTH_SHORT).show();
                //dilogFor_addDoc();
                Intent i  = new Intent(Main2Activity.this,UploadDocuments.class);
                startActivity(i);

            }
        });

        Slider slider = findViewById(R.id.slider);

//create list of slides
        List<Slide> slideList = new ArrayList<>();
        slideList.add(new Slide(0,"https://content3.jdmagicbox.com/comp/delhi/t4/011pxx11.xx11.170720134922.f8t4/catalogue/ezswype-business-solutions-pvt-new-railway-road-gurgaon-swipe-card-machine-manufacturers-4ii7i5h.jpg" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(1,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVPI1oRJrnRqqf6bdYkVsR_5wQzqBWoCQMuIgbXHOTbcO-4maTaw" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(2,"https://content4.jdmagicbox.com/comp/delhi/t4/011pxx11.xx11.170720134922.f8t4/catalogue/ezswype-business-solutions-pvt-new-railway-road-gurgaon-swipe-card-machine-manufacturers-zvr3ph.jpg?interpolation=lanczos-none&amp;output-format=jpg&amp;resize=1024:370&amp;crop=1024:370px;*,*\" onload=\"typeof google==='object'&amp;&amp;google.aft&amp;&amp;google.aft(this)\" width=\"436\" height=\"158\" style=\"margin-top: 123px;\" alt=\"Image result for ezswype business solutions pvt. ltd images" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(3,"https://lh3.googleusercontent.com/hvlhV63eYKvGIKEZC3qJ8XXTeTRPezJYVo3yMZvOoYi3hT7Vu-l17Hc6oIDB_YHHvw4" , getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

//handle slider click listener
        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //do what you want
            }
        });

//add slides to slider
        slider.addSlides(slideList);

        llopendwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(open_close.equals("0")){

                    // open_close = "1";
                    dl.openDrawer(GravityCompat.START);
                }else {
                    //open_close = "0";
                    dl.closeDrawer(GravityCompat.START);


                }


            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                //Toast.makeText(getApplicationContext(),"aaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();
                if (id == R.id.nav_item_ones) {
                    //Toast.makeText(getApplicationContext(),"dvddv",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Main2Activity.this,Clients.class);
                    startActivity(i);
                    dl.closeDrawer(GravityCompat.START);
                    // Handle the camera action
                } else if (id == R.id.nav_item_two) {
                    //Toast.makeText(getApplicationContext(),"hghghghghghghghg",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Main2Activity.this,TodayCall.class);
                    startActivity(i);
                    dl.closeDrawer(GravityCompat.START);
                }else if (id == R.id.nav_item_fours) {
                  //  Toast.makeText(getApplicationContext(), "hghghghghghghghg", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Main2Activity.this,FollowUp.class);
                    startActivity(i);
                    dl.closeDrawer(GravityCompat.START);
                }else if (id == R.id.nav_item_three) {
                    //Toast.makeText(getApplicationContext(), "hghghghghghghghg", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Main2Activity.this,AddMerchant.class);
                    startActivity(i);
                    dl.closeDrawer(GravityCompat.START);
                }else if (id == R.id.nav_item_report) {
                   // Toast.makeText(getApplicationContext(), "hghghghghghghghg", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Main2Activity.this,DownloadReport.class);
                    startActivity(i);
                    dl.closeDrawer(GravityCompat.START);
                }else if (id == R.id.nav_item_addagent) {
                    Intent i = new Intent(Main2Activity.this,AddAgent.class);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(), "hghghghghghghghg", Toast.LENGTH_SHORT).show();
                    dl.closeDrawer(GravityCompat.START);
                }else if (id == R.id.nav_item_four) {
                   // Toast.makeText(getApplicationContext(), "hghghghghghghghg", Toast.LENGTH_SHORT).show();
                   dilogFor_Logout();
                    dl.closeDrawer(GravityCompat.START);
                }

              //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
               // drawer.closeDrawer(GravityCompat.START);
                return true;

            }
        });


    }

    private  boolean checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
        int storage = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int loc = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        int loc2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }
        if (storage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (loc2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }






    public void dilogFor_Logout() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.logout_dilog);

        LinearLayout yes = dialog.findViewById(R.id.yeslogout);
        LinearLayout no = dialog.findViewById(R.id.logout_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sessionManager.logoutUser();

                Intent i = new Intent(Main2Activity.this,Login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                dialog.dismiss();
                finish();

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


        dialog.show();



    }


}

package com.allsport.watherapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class SplashScreen extends Activity {

    static String lats, lngs;
    String s;
    Double lat, lng;
    Geocoder geo;
    Button btn7;
    private static final int REQUEST_CALL = 1;
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        getCurrentLocation();
        CheckingPermissionIsEnabledOrNot();
        init(CheckingPermissionIsEnabledOrNot());

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {


        init(CheckingPermissionIsEnabledOrNot());
    }



    public void getCurrentLocation() {
        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getSystemService(context);
        Criteria crta = new Criteria();
        crta.setAccuracy(Criteria.ACCURACY_FINE);
        crta.setAltitudeRequired(false);
        crta.setBearingRequired(false);
        crta.setCostAllowed(true);
        crta.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(crta, true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(provider, 0, 1,
                new LocationListener() {
                    @Override
                    public void onStatusChanged(String provider, int status,
                                                Bundle extras) {
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                    }

                    @Override
                    public void onLocationChanged(Location location) {
                        if (location != null) {
                            lat = location.getLatitude();
                            lng = location.getLongitude();
                            if (lat != 0.0 && lng != 0.0) {
                                System.out.println("WE GOT THE LOCATION");
                                System.out.println(lat);
                                System.out.println(lng);
                                lats = String.valueOf(lat);
                                lngs = String.valueOf(lng);
                                Toast.makeText(getApplicationContext(), "" + lats + lngs, Toast.LENGTH_SHORT).show();
                                //tv.setText(""+lat+""+lng);
                                geo = new Geocoder(getApplicationContext(), Locale.ENGLISH);
                                try {
                                    List<Address> mylist = geo.getFromLocation(lat, lng, 10);
                                    Address mynearadd = mylist.get(0);

                                    Log.e("addes",""+mylist.get(0).getSubLocality());
                                    Log.e("phone",""+mylist.get(0).getPhone());
                                    Log.e("adminarea",""+mylist.get(0).getAdminArea());
                                    Log.e("adminarea",""+mylist.get(0).getCountryName());
                                    Log.e("addreline",""+mylist.get(0).getAddressLine(0));
                                    Log.e("adminarea",""+mylist.get(0).getLocality());
                                    StringBuilder mystring = new StringBuilder();
                                    for (int i = 0; i < mynearadd.getMaxAddressLineIndex(); i++) {
                                        mystring.append(mynearadd.getAddressLine(i)).append("\n");
                                        s = mystring.toString();

                                        Log.e("address",""+s);


                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    }

                });

    }


    private boolean CheckingPermissionIsEnabledOrNot() {
        int CameraPermissionResult = ContextCompat.checkSelfPermission(SplashScreen.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int CallPermissionResult = ContextCompat.checkSelfPermission(SplashScreen.this,Manifest.permission.ACCESS_FINE_LOCATION);
        int readexternalPermissionResult = ContextCompat.checkSelfPermission(SplashScreen.this,Manifest.permission.ACCESS_NETWORK_STATE);
        //int ThirdPermissionResult = ContextCompat.checkSelfPermission(SplashScreen.this,Manifest.permission.READI);
        // int ForthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), GET_ACCOUNTS);

        return CallPermissionResult == PackageManager.PERMISSION_GRANTED&&
                CameraPermissionResult == PackageManager.PERMISSION_GRANTED
                && readexternalPermissionResult == PackageManager.PERMISSION_GRANTED ;
        // ForthPermissionResult == PackageManager.PERMISSION_GRANTED ;

    }

    public void init(boolean b) {

        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (b == false){
                if (ActivityCompat.checkSelfPermission(SplashScreen.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SplashScreen.this,new String[]{
                            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    },REQUEST_CALL);

                    //return;
                }else {

                }

            }else {

            }

        } else {
            // Pre-Marshmallow
        }

    }


}


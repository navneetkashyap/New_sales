package com.example.navneet.ez_sales;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.navneet.ez_sales.Activitys.Login;
import com.example.navneet.ez_sales.Activitys.Main2Activity;
import com.example.navneet.ez_sales.Activitys.MainActivity;
import com.example.navneet.ez_sales.SessionManager.SessionManager;

public class Splash extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sessionManager = new SessionManager(this);



        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                if(sessionManager.isLoggedIn()){
                    Intent i = new Intent(Splash.this, Main2Activity.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(Splash.this, Login.class);
                    startActivity(i);

                }


                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}

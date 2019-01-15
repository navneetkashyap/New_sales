package com.example.navneet.ez_sales.Activitys;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.example.navneet.ez_sales.ApiManager.ApiFetcher;
import com.example.navneet.ez_sales.Parsing_file.ViewModule;
import com.example.navneet.ez_sales.PojoClasses.Login_Pojo;
import com.example.navneet.ez_sales.R;
import com.example.navneet.ez_sales.SessionManager.SessionManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Login extends Activity implements ApiFetcher {

    EditText username_et,password_et;
    LinearLayout login_ll;
    String  username,password;
    Login_Pojo login_pojo;
    SessionManager sessionManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Login...");
        progressDialog.setCancelable(false);

        username_et = findViewById(R.id.ed_userid);
        password_et = findViewById(R.id.et_password);
        login_ll = findViewById(R.id.ll_login);

        login_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                username = username_et.getText().toString();
                password = password_et.getText().toString();
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                ViewModule logins = new ViewModule(Login.this);
                logins.Login_url(username,password,"1111.22252","155455.1255");

            }
        });



    }

    @Override
    public void onAPIRunningState(int a) {

        if (a == ApiFetcher.KEY_API_IS_RUNNING) {
            progressDialog.show();
        }
        if (a == ApiFetcher.KEY_API_IS_STOPPED) {
            progressDialog.dismiss();
        }


    }

    @Override
    public void onFetchProgress(int progress) {

    }

    @Override
    public void onFetchComplete(String response, String apiName) {


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (apiName.equals("LoginResponse")) {
            progressDialog.dismiss();
            try {

                login_pojo = new Login_Pojo();
                login_pojo = gson.fromJson(response, Login_Pojo.class);
                if (login_pojo.getStatus()==0) {

                    Log.e("role",""+login_pojo.getResult().getUserRole());
                    username = username_et.getText().toString();
                    sessionManager.createLoginSession(login_pojo.getResult().getUserRole(),login_pojo.getResult().getSessionId(),username);

                    Intent i = new Intent(Login.this,Main2Activity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                } else {

                    Log.e("role",""+login_pojo.getMessage());
                    Toast.makeText(this, ""+login_pojo.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
            }

        }

    }

    @Override
    public void onFetchFailed(ANError error) {
        progressDialog.dismiss();
    }

    @Override
    public void WhichApi(String apiName) {
        progressDialog.dismiss();
    }
}

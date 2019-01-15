package com.example.navneet.ez_sales.Activitys;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.navneet.ez_sales.Adapters.CustomAdapterMYClinents;
import com.example.navneet.ez_sales.R;

import java.util.ArrayList;
import java.util.Arrays;

public class TodayCall extends Activity {

    LinearLayout backbtn;
    RecyclerView  recyclerView;
    ArrayList personNames = new ArrayList<>(Arrays.asList("EZ Swype", "EZ Swype", "EZ Swype", "EZ Swype", "EZ Swype", "EZ Swype", "EZ Swype"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_call);

        backbtn = findViewById(R.id.backbtn);
        recyclerView = findViewById(R.id.todaycall_listview);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapterMYClinents customAdapter = new CustomAdapterMYClinents(this, personNames);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

    }
}

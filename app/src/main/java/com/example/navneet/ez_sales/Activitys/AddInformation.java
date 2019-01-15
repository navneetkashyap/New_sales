package com.example.navneet.ez_sales.Activitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navneet.ez_sales.Adapters.BusinessList_Adapter;
import com.example.navneet.ez_sales.Adapters.CustomAdapterMYClinents;
import com.example.navneet.ez_sales.PojoClasses.Busnisslistitem;
import com.example.navneet.ez_sales.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AddInformation extends Activity {
    public static Dialog dialog;
    TextView busnisstyp,tvAcceptcard,tvresponce,tv_actionrecquired;
    LinearLayout backbtn;

    String busnisslist[] = {"Pharmacy", "Grocery", "General Store", "Diagnostic labs", "Clothing and Garments", "Footwear", "Food and Beverage","Other"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);
        backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        busnisstyp = findViewById(R.id.businesstyp);
        tvAcceptcard = findViewById(R.id.tv_accept_card);
        tvresponce = findViewById(R.id.responce);
        tv_actionrecquired = findViewById(R.id.tvaction_requart);

        tv_actionrecquired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilogFor_ActionRequired();
            }
        });

        tvresponce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilogFor_Response();
            }
        });

        tvAcceptcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilogFor_Acceptcardx();
            }
        });

        busnisstyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilogFor_natureofbisnes();
            }
        });


    }

    public void dilogFor_natureofbisnes() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.adddocumets);
        ListView listView =  dialog.findViewById(R.id.busnesslist);
        BusinessList_Adapter customAdapter = new BusinessList_Adapter(getApplicationContext(), busnisslist);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                busnisstyp.setText(busnisslist[position]);
                Toast.makeText(getApplicationContext(),busnisslist[position],Toast.LENGTH_LONG).show();//show the selected image in toast according to position


                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void dilogFor_Acceptcardx() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.accept_cart_dilog);


        RadioGroup radioGroup =  dialog.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    Toast.makeText(AddInformation.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    tvAcceptcard.setText(rb.getText());
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
    }

    public void dilogFor_Response() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.response);


        RadioGroup radioGroup =  dialog.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    Toast.makeText(AddInformation.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    tvresponce.setText(rb.getText());
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
    }


    public void dilogFor_ActionRequired() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.action_required);


        RadioGroup radioGroup =  dialog.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    Toast.makeText(AddInformation.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    tv_actionrecquired.setText(rb.getText());
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
    }
}

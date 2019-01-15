package com.example.navneet.ez_sales.Activitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navneet.ez_sales.R;

public class AddAgent extends Activity {
    public static Dialog dialog;

    LinearLayout backbtn;
    TextView selectrole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agent);

        selectrole = findViewById(R.id.selectrole);
        selectrole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dilogFor_role();
            }
        });

        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public void dilogFor_role() {

        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_TranslucentDecor);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.addagent_dilog);


        RadioGroup radioGroup =  dialog.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {

                    Toast.makeText(AddAgent.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    selectrole.setText(rb.getText());
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
    }
}

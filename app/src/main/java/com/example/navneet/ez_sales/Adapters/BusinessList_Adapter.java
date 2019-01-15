package com.example.navneet.ez_sales.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navneet.ez_sales.Activitys.AddInformation;
import com.example.navneet.ez_sales.PojoClasses.Busnisslistitem;
import com.example.navneet.ez_sales.R;

import java.util.ArrayList;

public class BusinessList_Adapter extends BaseAdapter {
    Context context;
    String busnisslist [];
    LayoutInflater inflter;

    public BusinessList_Adapter(Context applicationContext, String[] busnisslistitem) {
        this.context = applicationContext;
        this.busnisslist = busnisslistitem;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return busnisslist.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.busnisslistitem, null);
        TextView tv1 = (TextView) view.findViewById(R.id.nemess);
        tv1.setText(busnisslist[i]);
        return view;
    }
}
package com.example.navneet.ez_sales.Parsing_file;



import android.util.Log;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.navneet.ez_sales.ApiManager.ApiFetcher;
import com.example.navneet.ez_sales.Urls.Apis;


public class ViewModule implements Apis {

    ApiFetcher apiFetcher;

    public ViewModule(ApiFetcher apiFetcher) {
        this.apiFetcher = apiFetcher;
    }

    public void Login_url(String s, String toString, String s1, String s2) {
        apiFetcher.onAPIRunningState(1);

        Log.e("url", "" + login_api);
        Log.e("para1", "" + s);
        Log.e("para2", "" + toString);

        AndroidNetworking.post(login_api)

                .addBodyParameter("username",s )
                .addBodyParameter("password",toString )
                .addBodyParameter("latitude",s1 )
                .addBodyParameter("longitude",s2 )
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("**response"," " + response);
                        apiFetcher.onFetchComplete("" + response, "LoginResponse");
                    }

                    @Override
                    public void onError(ANError anError)
                    {
                        apiFetcher.onFetchFailed(anError);
                    }
                });
    }




}
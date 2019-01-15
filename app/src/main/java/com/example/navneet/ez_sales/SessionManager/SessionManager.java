package com.example.navneet.ez_sales.SessionManager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LoginPrefrences";
    private static final String IS_LOGIN = "IsLoggedIn";


    public static final String SESSION_ID = "user_id";
    public static final String USER_ROLE = "user_email";
    public static final String USER_NAME = "user_email";


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void createLoginSession(String userRole, int sessionId, String username) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(SESSION_ID, String.valueOf(sessionId));
        editor.putString(USER_ROLE, userRole);
        editor.putString(USER_NAME, username);

        editor.commit();
    }




    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(SESSION_ID, pref.getString(SESSION_ID, ""));
        user.put(USER_ROLE, pref.getString(USER_ROLE, ""));
        user.put(USER_NAME, pref.getString(USER_ROLE, ""));

        return user;
    }


    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public void logoutUser() {
        editor.clear();
        editor.commit();
    }




}

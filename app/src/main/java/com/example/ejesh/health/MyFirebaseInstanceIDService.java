package com.example.ejesh.health;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{
    private static final String REG_TOKEN = "REG_TOKEN";
    @Override
    public void onTokenRefresh() {

        String recent_token = FirebaseInstanceId.getInstance ().getToken ();
        Log.d (REG_TOKEN,"Refreshed token" + recent_token );
        sendRegistrationToServer(recent_token);
    }
    private void sendRegistrationToServer(String token){

    }
}


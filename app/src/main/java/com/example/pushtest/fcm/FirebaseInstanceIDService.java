package com.example.pushtest.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDServices";

    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG,token);
        Log.d("jhTest",token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        Log.e("jhTest",token);
        Log.e("jhTest","너는 왜 안 찍히냐..");
    }
}

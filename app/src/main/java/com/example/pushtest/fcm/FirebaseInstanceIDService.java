package com.example.pushtest.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG     = "MyFirebaseIIDServices";
    private static final String jhTest  = "jhTest";

    @Override
    public void onTokenRefresh() {

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG,"Refreshed token : " + refreshedToken);
        Log.d(jhTest,"Refreshed token : " + refreshedToken);

        // 토튼이 바뀌면 여기에서 이벤트를 받습니다.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // 그러면 여기에 바뀐 토큰값을 저장해야겠지요?
        // 여기에 받아온 토큰값 저장
        // db에 저장 또는 앱자체 SharedPreferences 저장

        Log.e("jhTest",token);
        Log.e("jhTest","너는 왜 안 찍히냐..");
    }
}

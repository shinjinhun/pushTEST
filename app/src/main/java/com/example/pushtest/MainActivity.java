package com.example.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 단말기 토큰값 가져오기
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("jhTest",token);
        Log.d("jhTest",token);
    }
}

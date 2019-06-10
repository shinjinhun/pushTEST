package com.example.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 단말기 토큰값 가져오기
        final String token = FirebaseInstanceId.getInstance().getToken();

        Button button01 = (Button) findViewById(R.id.btn01);

        button01.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("jhTest",token);
            }
        });

        Log.e("jhTest",token);
        Log.d("jhTest",token);
    }
}

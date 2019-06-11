package com.example.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 단말기 토큰값 가져오기
        final String token = FirebaseInstanceId.getInstance().getToken();

        button = findViewById(R.id.btn01);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("jhTest",token);
                Log.d("jhTest",token);

                Toast.makeText(getApplicationContext(),"토큰값 : " + token, Toast.LENGTH_LONG).show();
            }
        });

    }
}

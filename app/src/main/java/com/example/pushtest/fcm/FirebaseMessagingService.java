package com.example.pushtest.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.pushtest.MainActivity;
import com.example.pushtest.R;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String TAG     = "FirebaseMsgService";
    private static final String jhTest  = "jhTest";

    private String msg, title;

    public FirebaseMessagingService() {

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

//        Log.d(TAG, "Notofication Title:" + remoteMessage.getNotification().getTitle());
//        Log.d(TAG,"Notification Message:" + remoteMessage.getNotification().getBody());

        String messageBody = remoteMessage.getData().get("message");
        String title = remoteMessage.getData().get("title");

        showNotification(title, messageBody);
        
//        // 메세지가 올때 여기서 처리
//        // 앱이 실행중일때 여기서 이벤트를 받습니다.
//        Map<String, String> bundle = remoteMessage.getData();
//
//        Log.e(TAG, "onMessageReceived");
//        Log.e(jhTest, "bundle : " + bundle);
//
//        title = remoteMessage.getNotification().getTitle();
//        msg = remoteMessage.getNotification().getBody();
//
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(title)
//                .setContentText(msg)
//                .setAutoCancel(true)
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setVibrate(new long[]{1, 1000});
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(0, mBuilder.build());
//
//        mBuilder.setContentIntent(contentIntent);

    }

    private void showNotification(String title, String message) {

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0 /*request code*/, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title+"님 의 메시지입니다.")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }

}

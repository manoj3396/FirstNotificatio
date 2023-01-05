package com.example.firstnotification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyApplication extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
       String title= message.getNotification().getTitle();
        String text= message.getNotification().getBody();
        final String CHANNEL_ID="headet_up_notofication";
        NotificationChannel channel=new NotificationChannel(
                CHANNEL_ID,"headet up notofication", NotificationManager.IMPORTANCE_HIGH
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification=new Notification.Builder(this,CHANNEL_ID)
                .setContentTitle(title)
                        .setContentText(text)
                                .setSmallIcon(R.drawable.noytification).setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(23, notification.build());
        super.onMessageReceived(message);
        if(message.getData().size()>0){
            Toast.makeText(this, ""+message.getData().toString(), Toast.LENGTH_SHORT).show();

        }



    }
}

package com.example.notifictaion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.os.Bundle;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Button;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Button button= (Button)findViewById(R.id.button);
        Button button1=(Button)findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            sendNotification();
        });
        button1.setOnClickListener(V -> {
            cancelNotification();
        });
    }

    @OnClick(R.id.button)
    public void sendNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.asana.com/0/1143309707546919/1146175586095061"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("This is a New Notification");
        builder.setContentText("You are created a Notification app successfully");
        builder.setSubText("Tap to view the website.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, builder.build());
    }

    @OnClick(R.id.button2)
    public void cancelNotification() {

        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
        nMgr.cancel(1);
    }
}
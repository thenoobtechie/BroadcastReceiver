package com.example.deepak.broadcast_reciever;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class broadcastReciever extends BroadcastReceiver {


    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("Message");
        notification(context, s);
    }

    public void notification(Context context, String msg){
        String title = "Server Message";
        Intent in = new Intent(context, MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(context,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.c).setTicker(msg).setContentTitle(title).setContentText(msg);
        NotificationManager notifyMan = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifyMan.notify(0, mBuilder.build());
    }
}

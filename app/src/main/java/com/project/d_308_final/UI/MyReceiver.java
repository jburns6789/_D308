package com.project.d_308_final.UI;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.project.d_308_final.R;

public class MyReceiver extends BroadcastReceiver {
    //have to create through android so it registers in the manifest if its not in the manifest it wont work

    String channel_id = "test";
    static int notificationID;

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, intent.getStringExtra("key"), Toast.LENGTH_LONG).show();

        createNotificationChannel(context, channel_id);

        Notification n = new NotificationCompat.Builder(context, channel_id)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText(intent.getStringExtra("key"))
                .setContentTitle("NotificationTest").build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID++, n);


        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

    }


    private void createNotificationChannel(Context context, String CHANNEL_ID ){
        CharSequence name = "vacationChannel";
        String description = "vacationAlerts";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);

        //Register the channel with the system; you can change importance
        //or other notification behaviors

        NotificationManager notificationManager =  context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

    }
}

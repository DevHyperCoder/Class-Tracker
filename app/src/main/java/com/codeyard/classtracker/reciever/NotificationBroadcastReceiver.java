package com.codeyard.classtracker.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.codeyard.classtracker.R;
import com.codeyard.classtracker.constants.Constants;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationBroadcastReceiver extends BroadcastReceiver {
    final String TAG = NotificationBroadcastReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");

        String title = intent.getStringExtra(Constants.LECTURE_TITLE);
        String desc = intent.getStringExtra(Constants.LECTURE_DESC);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "classChannelID")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(desc);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

//TODO        We would have to dynamically update these
        notificationManager.notify(200, builder.build());
    }
}

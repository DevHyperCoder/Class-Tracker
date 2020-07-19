package com.codeyard.classtracker.notification;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.codeyard.classtracker.reciever.NotificationBroadcastReceiver;

import java.util.Calendar;

import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper {

    public static void scheduleNotification(Context context, Calendar time) {

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent alarmIntent = new Intent(context, NotificationBroadcastReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent);


    }

    /**
     * Creates a Channel for the Upcoming Classes Notification
     * Only required for API Version >=26
     * @param context Context
     */
    @TargetApi(Build.VERSION_CODES.O)
    public static void createClassChannel(Context context) {

        CharSequence name = "ClassTrackerUpcomingClassReminder";
        String desc = "Notification for upcoming classes";

        int priority = NotificationManager.IMPORTANCE_HIGH;

        NotificationChannel notificationChannel = new NotificationChannel("classChannelID", name, priority);
        notificationChannel.setDescription(desc);

        NotificationManagerCompat.from(context).createNotificationChannel(notificationChannel);

    }

}

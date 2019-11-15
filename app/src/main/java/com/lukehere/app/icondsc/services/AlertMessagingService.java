package com.lukehere.app.icondsc.services;

import android.app.Notification;
import android.os.Build;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.lukehere.app.icondsc.R;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

public class AlertMessagingService extends FirebaseMessagingService {

    private static int ALERT_NOTIFICATION_ID = 0;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, getString(R.string.channel_id))
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getNotification().getBody()));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(++ALERT_NOTIFICATION_ID, notificationBuilder.build());
    }
}
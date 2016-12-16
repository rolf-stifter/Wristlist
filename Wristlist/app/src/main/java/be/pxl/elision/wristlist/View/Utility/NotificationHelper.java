package be.pxl.elision.wristlist.View.Utility;

/**
 * Created by Rolf on 14/12/2016.
 */

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class NotificationHelper {

    public static void showNotification(Context context, int smallIcon,Bitmap largeIcon, int notificationId, String title, String text, Intent contentIntent, long[] vibrationPattern, NotificationCompat.Action[] actions) {

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(smallIcon)
                .setContentTitle(title)
                .setContentText(text)
                .setWhen(System.currentTimeMillis());

        if(contentIntent != null)
            notificationBuilder.setContentIntent(PendingIntent.getActivity(context, 0, contentIntent, 0));
        if(vibrationPattern != null)
            notificationBuilder.setVibrate(vibrationPattern);
        if(largeIcon != null)
            notificationBuilder.setLargeIcon(largeIcon);
        if(actions!=null)
            for(int i =0;i<actions.length;i++)
                notificationBuilder.addAction(actions[i]);

        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
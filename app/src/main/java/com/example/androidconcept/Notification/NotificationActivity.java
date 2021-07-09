package com.example.androidconcept.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidconcept.R;

import static com.example.androidconcept.Notification.App.CHANNEL_1_ID;
import static com.example.androidconcept.Notification.App.CHANNEL_2_ID;

public class NotificationActivity extends AppCompatActivity {

    NotificationManagerCompat managerCompat;
    Button bv_show,bv_show2;
    Context context;
    MediaSessionCompat mediaSession;
    EditText  editTextPersonName,editTextWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        context = this;
        managerCompat = NotificationManagerCompat.from(this);

        // for color notification button according to bitmap (* use MediaSessionCompat)

        mediaSession = new MediaSessionCompat(context,"tag");

        editTextPersonName = findViewById(R.id.editTextPersonName);
        editTextWord = findViewById(R.id.editTextWord);
        bv_show = findViewById(R.id.bv_show);
        bv_show2 = findViewById(R.id.bv_show2);

        bv_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityIntent = new Intent(context,NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,activityIntent,0);

                /* for action button add Broadcast Recevier */
                Intent actionIntent = new Intent(context,NotificationRecevier.class);

                actionIntent.putExtra("toast","Notification BroadCast ");
                PendingIntent broadCast = PendingIntent.getBroadcast(context,0,actionIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                actionIntent.putExtra("rohit","rohit is called ");
                PendingIntent rohitCast = PendingIntent.getBroadcast(context,0,actionIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bg_image);

                Notification notification = new NotificationCompat.Builder(NotificationActivity.this,CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.bg_image)
                        .setContentTitle("Android Concept ")
                        .setContentText("Keep Learning New Thing ")
                        .setLargeIcon(bitmap)
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentIntent(pendingIntent)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .setColor(Color.BLUE)
                        .setOnlyAlertOnce(true)
                        .setAutoCancel(true)
                        .addAction(R.drawable.ic_launcher_foreground,"Play me ",rohitCast)
                        .addAction(R.drawable.ic_launcher_background,"Click Me",broadCast)
                        .build();

            /* {@link setbig text style in notification }**/
/*                .setStyle(new NotificationCompat.BigTextStyle().bigText("rohit is here and how are you doin all the thing ")
                        .setBigContentTitle("Big Content Title ").setSummaryText("Summary text ")) */


                managerCompat.notify(1,notification);
            }
        });

        bv_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.bg_image);

                Intent likeIntent = new Intent(context,NotificationRecevier.class);
                likeIntent.putExtra("like","like is click");
                PendingIntent likePending = PendingIntent.getBroadcast(context,0,likeIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new NotificationCompat.Builder(NotificationActivity.this,CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.bg_image)
                        .setContentTitle("Android Concept ")
                        .setLargeIcon(icon)
                        .addAction(R.drawable.ic_like,"Like",likePending)
                        .addAction(R.drawable.ic_back,"Back",null)
                        .addAction(R.drawable.ic_pause,"pause",null)
                        .addAction(R.drawable.ic_next,"Next",null)
                        .addAction(R.drawable.ic_dislike,"Dislike",null)

                        /* 1,2,3 is the index of action */

                        .setStyle(new  androidx.media.app.NotificationCompat.MediaStyle().setShowActionsInCompactView(1,2,3).setMediaSession(mediaSession.getSessionToken()))
                        .setSubText("sub text ")
                        .setContentText("Keep Learning New Thing ")
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .build();

                /** {@link setInbox type of notification }*/
                /*
  .setStyle(new NotificationCompat.InboxStyle().addLine("this is line 1")
                        .addLine("this is line 1")
                        .addLine("this is line 1")
                        .addLine("this is line 1")
                        .addLine("this is line 1")
                        .addLine("this is line 1").setBigContentTitle("Big Content Title ").setSummaryText("Summary text "))
*/


                managerCompat.notify(2,notification);
            }
        });
    }
    public static class NotificationRecevier extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            String value = intent.getStringExtra("like");
            if (value!=null)
            {
                Toast.makeText(context, "Favourite Song Added ", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String msg = intent.getStringExtra("toast");
                String msg1 = intent.getStringExtra("rohit");
                Toast.makeText(context, msg1, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
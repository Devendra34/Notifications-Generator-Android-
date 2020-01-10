package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import static com.example.notificationapp.App.CHANNEL_1_ID;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText title,message;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      notificationManager = NotificationManagerCompat.from(this);
        title = findViewById(R.id.mtitle);
        message = findViewById(R.id.mMessage);
    }

    public void sendOnChannel1(View view){
        String Title = title.getText().toString();
        String Message = message.getText().toString();

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_plus)
                .setContentTitle(Title)
                .setContentText(Message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .build();
        notificationManager.notify(1,notification);
    }

    public void sendOnChannel2(View view){
        final String c = title.getText().toString();
        Work work = new Work(Integer.parseInt(c));
        work.start();
    }

    class Work extends Thread{
        int count;

        public Work(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            super.run();
            for (int j = 0 ; j < count ; j++){
                sendNotification(App.i++);
            }
        }
    }

    void sendNotification(int id){

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle("Title "+id)
                .setContentText("Message " +id)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setOnlyAlertOnce(false)
                .build();

        notificationManager.notify(id,notification);
    }
}

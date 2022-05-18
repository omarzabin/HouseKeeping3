package com.example.housekeeping

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        createNotificationChannel()
        pendingNotification()


        var showName = findViewById<TextView>(R.id.welcomeTV)

        // using putExtra shoing name
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            showName.text = "welcome " + msg
        }



        var fragment1: Button = findViewById(R.id.bookBT)
        fragment1.setOnClickListener {
            var dialog_var = BookServiceDialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }

        var fragment2: Button = findViewById(R.id.provideBT)
        fragment2.setOnClickListener {
            var dialog_var2 = ProvideServiceDialogFragment()
            dialog_var2.show(supportFragmentManager, "hi")


        }


    }

    private fun pendingNotification() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(this, " App_Channel.testNotification")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Welcome back to the application")
            .setContentText("Book a service now what you waiting for!!").setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this))
        {
            notify(234, builder.build())
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "test_notification"
            val descriptionText = "Trying to test different types notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(" App_Channel.testNotification", name, importance).apply {
                    description = descriptionText
                }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
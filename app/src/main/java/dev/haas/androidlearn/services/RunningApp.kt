package dev.haas.androidlearn.services

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

//This also need to be register in the manifest file
class RunningApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "my-channel",
                "Runnign notif",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notifManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notifManager.createNotificationChannel(channel)
        }
    }
}
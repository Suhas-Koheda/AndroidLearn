package dev.haas.androidlearn.services

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import dev.haas.androidlearn.R

//user aware of the running service
//The service ahs to be registered in the manifest file
class Background : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    fun start() {
        var notif = NotificationCompat.Builder(
            this,
            "my-channel"
        ).setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("title")
            .setContentText("content")
            .build()
        startForeground(1, notif)
    }

    enum class Actions {
        START, STOP
    }
}

fun mainService(activity: Activity) {
    Intent(activity.applicationContext, Background::class.java).also {
        it.action = Background.Actions.START.toString()
        activity.startService(it)
    }
}
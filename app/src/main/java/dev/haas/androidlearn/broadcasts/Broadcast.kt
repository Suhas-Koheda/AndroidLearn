package dev.haas.androidlearn.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.provider.Settings


//dynamic receiver
class Broadcasts : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON,
            ) != 0
        }

        //to write in the main activity to register and unregister the broadcasts
        context?.registerReceiver(this, IntentFilter())
        context?.unregisterReceiver(this)
    }
}

//static receivers will be registered in the manifest file with the actions and intent filter
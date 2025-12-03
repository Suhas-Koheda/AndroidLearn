package dev.haas.androidlearn.intents

import android.app.Activity
import android.content.Intent


//Explicit intent - of other app
//Implicit intent
fun Intents(activity: Activity) {
    val intent = Intent(activity, NewActivity::class.java)
    activity.startActivity(intent)
    //External intent
    Intent(Intent.ACTION_MAIN).also {
        it.`package` = "com.google.android.youtube"
        if (it.resolveActivity(activity.packageManager) != null) {
            // can also be used with try catch block with ActivityNotFoundException
            activity.startActivity(it)
        }
    }
    //Implicit intent - just send the intent not specify the app ourselves
    Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_EMAIL, arrayOf("haas@gmail.com"))
    }
    activity.intent.getStringExtra("extra_key")//retrivigf extras
}

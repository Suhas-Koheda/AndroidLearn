package dev.haas.androidlearn.contexts

import android.app.Activity
import androidx.core.app.ActivityCompat

fun permissions(activity: Activity) {
    ActivityCompat.requestPermissions(
        activity,
        arrayOf(android.Manifest.permission.ADD_VOICEMAIL),
        100
    )
}
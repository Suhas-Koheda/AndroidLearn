package dev.haas.androidlearn.resquali

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import dev.haas.androidlearn.R

@Composable
fun Resources(activity: Activity) {
    activity.applicationContext.resources.getDrawable(R.drawable.ic_launcher_background)
    val context = activity.applicationContext
    context.getDrawable(R.drawable.ic_launcher_background)
    painterResource(R.drawable.ic_launcher_background)
    colorResource(R.color.black)
    context.getColor(R.color.black)
}
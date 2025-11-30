package dev.haas.androidlearn.jetpack

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun State() {
    val nameState = remember {
        mutableStateOf(StateClass(name = ""))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text(
            "Hello ${
                if (nameState.value.name == "") "Unknown"
                else nameState.value.name
            }!"
        )
        TextField(
            value = nameState.value.name,
            onValueChange = { newValue ->
                nameState.value = nameState.value.copy(name = newValue)
            })
        Text("Date: ${nameState.value.date}")
    }
}

data class StateClass @RequiresApi(Build.VERSION_CODES.O) constructor(
    var name: String = "Unknown",
    var date: LocalDateTime? = LocalDateTime.now()
)
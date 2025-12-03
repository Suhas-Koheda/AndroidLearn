package dev.haas.androidlearn

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.haas.androidlearn.contexts.permissions
import dev.haas.androidlearn.ui.theme.AndroidLearnTheme
import dev.haas.androidlearn.viewmodels.ViewModel
import dev.haas.androidlearn.viewmodels.ViewModel.Companion.Factory

class MainActivity : ComponentActivity() {

//    private val viewModel by viewModels<ViewModel>() //when initialising view model directly in the activity screen
    /**private val viewModel by viewModels<ViewModel>( //when you want to initialise the view models with arguments
    factory=object: ViewModelProvider.Factory{
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
    return ViewModel() as T
    }
    }
    )**/

    /**private val viewModel: ViewModel by viewModels {
    viewModelFactory {
    addInitializer(ViewModel::class) {
    ViewModel()
    }
    }
    }**/

    // to use when the companion object factory is defined in the view model class
    private val viewModel: ViewModel by viewModels {
        Factory
    }

    init {
        val myContext: Context = this
        permissions(this)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidLearnTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(viewModel.bgColor)     // full-screen background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = androidx.compose.ui.graphics.Color.Transparent
                    ) { _ ->
                        Button(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(40.dp),
                            onClick = { viewModel.changeBgColor() }
                        ) {
                            Text("Change Color")
                        }
                    }
                }
            }
        }
    }

}
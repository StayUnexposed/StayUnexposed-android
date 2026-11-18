package com.stayunexposed.startup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stayunexposed.startup.ui.CounterScreen
import com.stayunexposed.startup.ui.theme.StayUnexposedTheme
import com.stayunexposed.startup.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StayUnexposedTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: CounterViewModel = viewModel()
                    val count by viewModel.count.collectAsStateWithLifecycle()

                    CounterScreen(
                        count = count,
                        onIncrement = viewModel::increment,
                        onReset = viewModel::reset,
                    )
                }
            }
        }
    }
}

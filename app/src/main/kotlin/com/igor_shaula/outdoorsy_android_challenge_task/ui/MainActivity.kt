package com.igor_shaula.outdoorsy_android_challenge_task.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.igor_shaula.outdoorsy_android_challenge_task.ui.elements.TheAppUI

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // todo: add app toolbar for later search request
        setContentView(ProgressBar(this))
    }

    override fun onStart() {
        super.onStart()
        viewModel.vehiclesList.observe(this) { vehicles ->
            setContent { TheAppUI(vehicles) }
        }
    }
}

package com.adoyo.geminipro

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.adoyo.geminipro.presentation.CameraUi
import com.adoyo.geminipro.presentation.ChatViewModel
import com.adoyo.geminipro.presentation.MainScreen
import com.adoyo.geminipro.ui.theme.GeminiProTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(this, CAMERAX_PERMISSIONS, 0)
        }
        setContent {
            GeminiProTheme {

                val viewModel = koinViewModel<ChatViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val values = viewModel.chatState.collectAsState().value
                    if (values.isLoading) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(text = "Loading...")
                        }
                    } else {
                       // CameraUi()

                        MainScreen(
                            chatState = values,
                            onPromptChanged = viewModel::promptChanged,
                            onResult = viewModel::result
                        )
                    }

                }
            }
        }
    }

    private fun hasRequiredPermissions() = CAMERAX_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(applicationContext, it) == PackageManager.PERMISSION_GRANTED
    }
    companion object {
        private val CAMERAX_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA
        )
    }

}




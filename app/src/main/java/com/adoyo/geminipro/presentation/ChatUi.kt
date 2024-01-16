package com.adoyo.geminipro.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adoyo.geminipro.ui.theme.GeminiProTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(chatState: ChatState, onPromptChanged: (String) -> Unit, onResult: () -> Unit) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart

    ) {
        val chatListState = rememberLazyListState()


        LazyColumn(
           // modifier = Modifier.verticalScroll(scroll),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            item{
                Text(
                    text = chatState.result
                )
            }


        }

        ChatField(
            prompt = chatState.prompt,
            onPromptChanged = onPromptChanged,
            onResult = onResult, onCameraClicked = {

            },
            modifier = Modifier.align(Alignment.BottomStart))

    }
}

@Composable
fun ChatField(
    prompt: String,
    onPromptChanged: (String) -> Unit,
    onResult: () -> Unit,
    onCameraClicked: () -> Unit,
    modifier: Modifier
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = prompt,
            onValueChange = onPromptChanged,
            placeholder = { Text(text = "Message") },
            trailingIcon = {
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Mic, contentDescription = "Mic")
                    }
                    IconButton(onClick = onCameraClicked) {
                        Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Camera")
                    }
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.LightGray.copy(alpha = 0.5f)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),)

        IconButton(onClick = {
            onResult()
            onPromptChanged("")
        }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
        }
    }
}


package com.adoyo.geminipro.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TestUi(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn (
        state = listState,
        modifier = modifier.padding(16.dp),

    ){
        items(1000, key = {
            it
        }) { index ->
            Text(text = "Hello World$index")
        }
    }

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            listState.animateScrollToItem(index = 999)
          //  delay(1000)
        // Scroll to the last item
        }
    }
}
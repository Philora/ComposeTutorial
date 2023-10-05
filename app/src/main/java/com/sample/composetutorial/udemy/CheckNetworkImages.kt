package com.sample.composetutorial.udemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.coil.CoilImage

class CheckNetworkImages : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImage()
        }
    }
}

@Composable
fun NetworkImage() {
    Column {
        CoilImage(
            data = "https://picsum.photos/400/400",
            contentDescription = "Network Image",
            fadeIn = true
        )
    }
}

@Preview
@Composable
fun NetworkImagePreview() {
    NetworkImage()
}
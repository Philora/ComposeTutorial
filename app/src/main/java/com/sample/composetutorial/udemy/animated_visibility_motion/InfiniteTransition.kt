package com.sample.composetutorial.udemy.animated_visibility_motion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

class InfiniteTransition : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyInfiniteTransitionDemo1()
            }
        }
    }
}

@Preview
@Composable
fun MyInfiniteTransitionDemo1() {
    val infiniteTransition = rememberInfiniteTransition()
    val lineStart by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 300f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Canvas(Modifier.fillMaxSize()) {
            drawLine(
                Color.Blue,
                start = Offset(lineStart, size.height / 2),
                end = Offset(lineStart + 200f, size.height / 2),
                strokeWidth = 5f
            )
        }
    }

}

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

class InfiniteTransition : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyInfiniteTransitionDemo2()
            }
        }
    }
}

@Preview
@Composable
fun MyInfiniteTransitionDemo2() {
    val myInfiniteTransition = rememberInfiniteTransition()
    val pitch by myInfiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 90f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val yaw by myInfiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 90f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Canvas(
            Modifier
                .fillMaxSize(0.5f)
                .padding(8.dp)
                .align(Alignment.Center)
                .rotate(45f)
                .graphicsLayer {
                    rotationX = pitch
                }
        ) { drawCircle(Color.Black, style = Stroke(5f)) }

        Canvas(
            Modifier
                .fillMaxSize(0.5f)
                .padding(8.dp)
                .align(Alignment.Center)
                .rotate(45f)
                .graphicsLayer {
                    rotationY = yaw
                }
        ) { drawCircle(Color.Black, style = Stroke(5f)) }

    }
}

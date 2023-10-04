package com.sample.composetutorial.udemy.data_state_flow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DataStateMain : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var count by remember { // composable memory for remembering the value
                mutableStateOf(0)
            }
            BoxScreen(count) { newCount -> count = newCount }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScreen(count: Int, onCountChange: (Int) -> Unit) {
    val boxSize = 400.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(boxSize)
                .background(Color.Red), contentAlignment = Alignment.Center
        ) {
            var childSize = boxSize - 20.dp
            for (i in 0 until count) {
                Box(
                    modifier = Modifier
                        .size(childSize)
                        .rotate(i * 3f)
                        .background(Color.Gray)
                        .border(1.dp, Color.Black)
                )
                childSize -= 20.dp
            }

        }
        OutlinedTextField(
            value = "${count}",
            onValueChange = {/* TODO */ },
            modifier = Modifier.padding(4.dp)
        )

        Row(modifier = Modifier.weight(1f)) {
            Button(
                onClick = { onCountChange(count + 1) }, modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Increment")
            }
            Button(
                onClick = { onCountChange(if (count <= 0) 0 else count - 1) },
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Decrement")
            }
        }
    }

}

@Preview
@Composable
fun PreviewBoxScreen() {
    var count by remember { // composable memory for remembering the value
        mutableStateOf(0)
    }
    BoxScreen(count) { newCount -> count = newCount }
}
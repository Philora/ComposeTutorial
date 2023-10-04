package com.sample.composetutorial.udemy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .height(300.dp)
                .weight(3f), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Yellow)
                    .align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)
                    .align(Alignment.BottomStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray)
                    .align(Alignment.BottomEnd)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "0",
            onValueChange = {/* TODO */ },
            modifier = Modifier.padding(4.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.weight(1f)) {
            Button(
                onClick = {}, modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
            ) {
                Text(text = "Increment")
            }
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(4.dp)
                    .weight(1f)
            ) {
                Text(text = "Decrement")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewItemScreen() {
    ItemScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConstraintItemScreen() {
    val constraints = ConstraintSet {
        val box = createRefFor("box")
        val input = createRefFor("input")
        val increase = createRefFor("increase")
        val decrease = createRefFor("decrease")

        constrain(box) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }

        constrain(input) {
            top.linkTo(input.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(increase) {
            start.linkTo(parent.start)
            top.linkTo(input.bottom)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            end.linkTo(decrease.start)
        }

        constrain(decrease) {
            start.linkTo(increase.end)
            top.linkTo(increase.top)
            end.linkTo(parent.end)
            bottom.linkTo(increase.bottom)
            width = Dimension.fillToConstraints
        }

    }

    ConstraintLayout(modifier = Modifier.fillMaxHeight(), constraintSet = constraints) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .height(500.dp)
                .layoutId("box"), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
            )

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Yellow)
                    .align(Alignment.TopEnd)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)
                    .align(Alignment.BottomStart)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray)
                    .align(Alignment.BottomEnd)
            )
        }
        OutlinedTextField(
            value = "0",
            onValueChange = {/* TODO */ },
            modifier = Modifier
                .padding(4.dp)
                .layoutId("input")
        )

        Button(
            onClick = {}, modifier = Modifier
                .padding(4.dp)
                .layoutId("increase")
        ) {
            Text(text = "Increment")
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(4.dp)
                .layoutId("decrease")
        ) {
            Text(text = "Decrement")
        }
    }

}

@Preview
@Composable
fun PreviewConstraintItemScreen() {
    ConstraintItemScreen()
}
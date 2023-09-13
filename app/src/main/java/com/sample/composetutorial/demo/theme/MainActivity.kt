package com.sample.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(1f), color = MaterialTheme.colorScheme.background, shadowElevation = 3.dp) {
                    Greeting(ContentGreetings("macOS", "MacBookPro"))
                }
            }
        }
    }
}

data class ContentGreetings(val mOSversion: String, val mName: String)

@Composable
fun Greeting(contentGreetings: ContentGreetings) {
    Row(modifier = Modifier.padding(all = 8.dp), Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.nike_logo),
            contentDescription = "sample picture of developer",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape),
        )
        Spacer(modifier = Modifier.width(3.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = contentGreetings.mOSversion,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Divider(modifier = Modifier.height(1.dp))
            Text(
                text = contentGreetings.mName,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Surface {
            Greeting(contentGreetings = ContentGreetings("Windows", "Dell"))
        }
    }
}

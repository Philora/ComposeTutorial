package com.sample.composetutorial.dependency_injection.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sample.composetutorial.R
import com.sample.composetutorial.dependency_injection.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardScreen : ComponentActivity() {

    @Inject
    var dashboardViewModel: DashboardViewModel = hiltViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myNewsScreen(dashboardViewModel)
        }
    }
}

@Preview
@Composable
fun searchScreen() {

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {

        Box(
            modifier = Modifier
                .padding(top = 36.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LATEST NEWS",
//                    fontFamily = R.font.georgiab,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "Sunday, June 11, 1920",
//                    fontFamily = R.font.georgia,
                    fontSize = 16.sp
                )
            }

            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Black)
        )

    }

}

@Composable
fun myNewsScreen(dashboardViewModel: DashboardViewModel) {
    // todo android list news data on UI composable

}
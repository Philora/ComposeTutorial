package com.sample.composetutorial.poc.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sample.composetutorial.R
import com.sample.composetutorial.poc.viewmodel.AuthViewModel
import com.sample.composetutorial.poc.viewmodel.UserLoginStatus
import com.sample.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Login()
                }
            }
        }
    }

    //    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Login(
//        onSuccessFullLogin: () -> Unit,
        authViewModel: AuthViewModel = viewModel(),
    ) {
        val localContext = LocalContext.current

        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        val loginStatus by authViewModel.userLoginStatus.collectAsState() // instead of "=" we can use "by" for quick return

        var showFailedState by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = loginStatus) {
            when (loginStatus) {
                is UserLoginStatus.Failure -> {
                    showFailedState = true
                    showToast("Unable to Login")
                }

                UserLoginStatus.SuccessFull -> {
//                    onSuccessFullLogin() // raising an issue to add in Login passing
                    showToast("Login Successful")
                    localContext.startActivity(Intent(localContext, DashboardActivity::class.java))
                }

                null -> {
                }
            }
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(id = R.drawable.img_3),
                contentDescription = "login_background",
                modifier = Modifier
                    .fillMaxSize()
                    .blur(2.dp),
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .alpha(0.6f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp,
                        ),
                    )
                    .background(MaterialTheme.colorScheme.background),
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                LoginHeader()
//                Spacer(modifier = Modifier.height(120.dp))
                LoginFields(
                    username,
                    password,
                    onUsernameChanged = {
                        username = it
                    },
                    onPasswordChanged = {
                        password = it
                    },
                    onForgotPasswordClick = {},
                )
                LoginFooter(
                    onSignInClick = {
                        when {
                            username.isBlank() -> {
                                showToast("Please enter username")
                            }

                            password.isBlank() -> {
                                showToast("Please enter password")
                            }

                            else -> {
                                authViewModel.performLogin(username, password)
                            }
                        }
                    },
                    onSignUpClick = {
                        authViewModel.createAccount(username, password)
                    },
                )
            }
        }

        if (showFailedState) {
            // Alert Dialog, Toast, Snackbar, etc.
            // naviagtion.naviagte also we can incorporate with this composable
        }
    }

    @Composable
    fun LoginHeader() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Hello Guys!!!", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "Sign to Login", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }

    @Composable
    fun LoginFields(
        username: String,
        password: String,
        onUsernameChanged: (String) -> Unit,
        onPasswordChanged: (String) -> Unit,
        onForgotPasswordClick: () -> Unit,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            DemoField(
                value = username,
                label = "Username",
                placeholder = "Enter your E-Mail Address",
                onValueChange = onUsernameChanged,
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "Email icon")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            DemoField(
                value = password,
                label = "Password",
                placeholder = "Enter your Password",
                onValueChange = onPasswordChanged,
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password icon")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go,
                ),
            )
            TextButton(onClick = onForgotPasswordClick, modifier = Modifier.align(Alignment.End)) {
                Text(text = "Forgot Password?")
            }
        }
    }

    @Composable
    fun LoginFooter(
        onSignInClick: () -> Unit,
        onSignUpClick: () -> Unit,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = onSignInClick, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign In")
            }
            TextButton(onClick = onSignUpClick) {
                Text(text = "Don't you have account? Click Here!")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DemoField(
        value: String,
        label: String,
        placeholder: String,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default, // KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)
        leadingIcon: @Composable (() -> Unit)? = null,
        trailingIcon: @Composable (() -> Unit)? = null,
        onValueChange: (String) -> Unit,
    ) {
        OutlinedTextField(
            value = value,
            label = {
                Text(text = label)
            },
            placeholder = {
                Text(text = placeholder)
            },
            onValueChange = onValueChange,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            leadingIcon = leadingIcon,
            singleLine = true, // learned from separate y-tube.channel
            trailingIcon = trailingIcon,
        )
    }

    private fun showToast(showMessage: String) {
        Toast.makeText(this, showMessage, Toast.LENGTH_LONG).show()
    }
}

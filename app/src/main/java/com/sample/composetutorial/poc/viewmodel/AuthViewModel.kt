package com.sample.composetutorial.poc.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.sample.composetutorial.poc.repo.FirebaseAuthRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {

    private val _userLoginStatus = MutableStateFlow<UserLoginStatus?>(null)
    val userLoginStatus = _userLoginStatus.asStateFlow()

    private val firebaseAuth = FirebaseAuth.getInstance()

    /*init { // for initial check we don't have data, so created manually
        createAccount("stalon.giles@gmail.com", "Phiora7070$")
    }*/

    fun performLogin(username: String, password: String) {
        FirebaseAuthRepo.login(
            firebaseAuth,
            username,
            password,
            onSuccess = {
                _userLoginStatus.value = UserLoginStatus.SuccessFull
            },
            onFailure = {
                _userLoginStatus.value = UserLoginStatus.Failure(it)
            },
        )
    }

    fun createAccount(username: String, password: String) {
        FirebaseAuthRepo.signUp(
            firebaseAuth,
            username,
            password,
            onSuccess = {},
            onFailure = {},
        )
    }
}

sealed class UserLoginStatus {
    object SuccessFull : UserLoginStatus()
    class Failure(val exception: Exception?) : UserLoginStatus()
}

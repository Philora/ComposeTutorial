package com.sample.composetutorial.poc.repo

import com.google.firebase.auth.FirebaseAuth

object FirebaseAuthRepo {

    fun login(
        firebaseAuth: FirebaseAuth,
        username: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception?) -> Unit,
    ) { // :StateFlow<Boolean?> // todo in this case we has to add return for both the cases(onSuccess and onFailure)

//        val userAuthStatus = MutableStateFlow<Boolean?>(null)

        firebaseAuth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
//                    userAuthStatus.value = true
                } else {
                    onFailure(it.exception)
//                    userAuthStatus.value = false
                }
            }
    }

    fun signUp(
        firebaseAuth: FirebaseAuth,
        username: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception?) -> Unit,
    ) {
        firebaseAuth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onSuccess()
//                    userAuthStatus.value = true
                } else {
                    onFailure(it.exception)
//                    userAuthStatus.value = false
                }
            }
    }
}

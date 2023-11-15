package com.sample.composetutorial.dependency_injection.base

sealed class ResultActivity {
    data class Success(val data: String) : ResultActivity()
    data class Error(val errorMessage: String) : ResultActivity()
    object Loading : ResultActivity()
}

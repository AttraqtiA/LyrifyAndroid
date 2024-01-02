package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.User

data class LoginUIState(
    val userList: List<User> = emptyList(),
    val currentUser: User? = null
)

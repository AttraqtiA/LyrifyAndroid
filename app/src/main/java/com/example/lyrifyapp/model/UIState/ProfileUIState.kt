package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.User

data class ProfileUIState(
    val userList: List<User> = emptyList()
)

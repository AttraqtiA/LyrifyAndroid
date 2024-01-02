package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.Music
import com.example.lyrifyapp.User

data class RegisterUIState(
    val userList: List<User> = emptyList()
)

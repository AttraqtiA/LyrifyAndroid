package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.Music
import com.example.lyrifyapp.User
import com.example.lyrifyapp.model.Chapter

data class LoginUIState(
    val userList: List<User> = emptyList(),
    val currentUser: User? = null
)

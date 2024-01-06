package com.example.lyrifyapp.model.UIState

import androidx.annotation.DrawableRes
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.UserMusic

data class GameplayUIState(
    val music: Music,
    val userMusic: UserMusic
)

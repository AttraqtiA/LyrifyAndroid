package com.example.lyrifyapp.model.UIState

import androidx.annotation.DrawableRes
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.Music

data class GameplayUIState(
    val music: Music,
    val history: History
)

package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.Music

data class ChapterDetailUIState(
    val levelList: List<Level> = emptyList(),
    val currentMusic: Music? = null
)

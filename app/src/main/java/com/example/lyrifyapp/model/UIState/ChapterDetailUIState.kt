package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.Music
import com.example.lyrifyapp.model.Song

data class ChapterDetailUIState(
    val levelList: List<Level> = emptyList(),
    val currentSong: Song? = null
)

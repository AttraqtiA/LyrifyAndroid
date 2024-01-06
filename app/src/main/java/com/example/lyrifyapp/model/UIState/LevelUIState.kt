package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Music

data class LevelUIState(
    val songList: List<Music> = emptyList()
)

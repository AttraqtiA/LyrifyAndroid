package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Song

data class LevelUIState(
    val songList: List<Song> = emptyList()
)

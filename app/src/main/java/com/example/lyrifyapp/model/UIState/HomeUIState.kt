package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History

data class HomeUIState(
    val historyList: List<History> = emptyList(),
    val currentChapter: Chapter? = null
)

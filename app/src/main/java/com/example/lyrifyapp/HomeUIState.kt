package com.example.lyrifyapp

data class HomeUIState(
    val historyList: List<History> = emptyList(),
    val currentChapter: Chapter? = null
)

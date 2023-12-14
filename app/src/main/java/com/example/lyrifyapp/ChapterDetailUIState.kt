package com.example.lyrifyapp

data class ChapterDetailUIState(
    val levelList: List<Level> = emptyList(),
    val currentMusic: Music? = null
)

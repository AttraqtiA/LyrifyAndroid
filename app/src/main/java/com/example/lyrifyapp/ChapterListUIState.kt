package com.example.lyrifyapp

data class ChapterListUIState(
    val chapterList: List<Chapter> = emptyList(),
    val currentChapter: Chapter? = null
)

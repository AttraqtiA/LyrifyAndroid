package com.example.lyrifyapp.model.UIState

import com.example.lyrifyapp.model.Chapter

data class ChapterListUIState(
    val chapterList: List<Chapter> = emptyList(),
    val currentChapter: Chapter? = null
)

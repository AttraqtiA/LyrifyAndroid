package com.example.lyrifyapp.ui.screen.Chapter

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.Chapter
import com.example.lyrifyapp.ChapterListUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChapterListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ChapterListUIState())
    val uiState: StateFlow<ChapterListUIState> = _uiState.asStateFlow()

//    fun getChapterList(): List<Chapter>{
//
//    }
//
//    fun getCurrentChapter(){
//
//    }
}
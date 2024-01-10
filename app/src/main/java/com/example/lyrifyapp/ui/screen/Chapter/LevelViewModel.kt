package com.example.lyrifyapp.ui.screen.Chapter

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.model.UIState.LevelUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LevelViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LevelUIState())
    val uiState: StateFlow<LevelUIState> = _uiState.asStateFlow()
    val chapterDetailViewModel = ChapterDetailViewModel()

//    fun checkGuess(answer, level) {
//
//    }

}
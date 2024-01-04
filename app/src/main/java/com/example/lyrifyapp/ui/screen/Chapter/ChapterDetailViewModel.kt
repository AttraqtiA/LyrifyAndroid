package com.example.lyrifyapp.ui.screen.Chapter

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.model.UIState.ChapterDetailUIState
import com.example.lyrifyapp.ui.screen.Home.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChapterDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ChapterDetailUIState())
    val uiState: StateFlow<ChapterDetailUIState> = _uiState.asStateFlow()
    val chapterlistViewModel = ChapterListViewModel()
    val homeViewModel = HomeViewModel()

//    fun getMusicList(Chapter: Chapter): List<Music>{
//
//    }
//
//    fun getCurrentMusic(){
//
//    }
}
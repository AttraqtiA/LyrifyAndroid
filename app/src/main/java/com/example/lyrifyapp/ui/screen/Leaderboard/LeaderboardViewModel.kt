package com.example.lyrifyapp.ui.screen.Leaderboard

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.model.UIState.LeaderboardUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LeaderboardViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LeaderboardUIState(mutableListOf()))
    val uiState: StateFlow<LeaderboardUIState> = _uiState.asStateFlow()
}
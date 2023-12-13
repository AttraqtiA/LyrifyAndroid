package com.example.lyrifyapp.ui.screen.Gameplay

import androidx.compose.material3.Text
import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.model.UIState.LeaderboardUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameplayViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LeaderboardUIState(mutableListOf()))
    val uiState: StateFlow<LeaderboardUIState> = _uiState.asStateFlow()


//    Button(onClick = { isPaused = !isPaused }) {
//        Text(text = if (isPaused) "Resume" else "Pause")
//    }
//    Button(onClick = { resetTimer() }) {
//        Text(text = "Reset")
//    }
    fun converting(timeLeft: Int): String {
        val minutes = timeLeft / 60
        val seconds = timeLeft % 60

        return String.format("%02d:%02d", minutes, seconds)
    }

//    fun resetTimer(timeLeft: Int, isPaused: Boolean) {
//        timeLeft = 30
//        isPaused = false
//    }
}
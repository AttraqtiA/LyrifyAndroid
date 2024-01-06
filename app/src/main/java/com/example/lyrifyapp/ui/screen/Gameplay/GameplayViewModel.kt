package com.example.lyrifyapp.ui.screen.Gameplay

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.R
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.UIState.GameplayUIState
import com.example.lyrifyapp.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat

class GameplayViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        GameplayUIState(
            Music(
                "Normal",
                "Fix You",
                "Pop",
                "When you try your ....., but you dont succeed",
                mutableListOf("best", "day", "west", "way", "self", "well"),
                1,
                "AQl5nFnZPwk",
                "Coldplay",
                "2005",
                30,
                false,
                0,
                R.drawable.fix_you
            ),
            History(
                User(
                    "Yanto Kopling",
                    "Male",
                    R.drawable.edsheeran,
                    "halo@gmail.com",
                    "halow1232",
                    SimpleDateFormat("yyyy-MM-dd").parse("2023-09-22")!!,
                    SimpleDateFormat("yyyy-MM-dd").parse("2023-09-22")!!,
                    "aku seorang petualang",
                    3
                ),
                Music(
                    "Normal",
                    "Fix You",
                    "Pop",
                    "When you try your ....., but you dont succeed",
                    mutableListOf("best", "day", "west", "way", "self", "well"),
                    1,
                    "AQl5nFnZPwk",
                    "Coldplay",
                    "2005",
                    30,
                    false,
                    0,
                    R.drawable.fix_you
                ),
                0,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-09-22")!!
            )
        )
    )
    val uiState: StateFlow<GameplayUIState> = _uiState.asStateFlow()

    fun CalculatePoint(timeLeft: Int, answer: Int): Boolean {
        var base_point = 0

        // semisal indexnya 99 atau tdk menjawab sama sekali, ya otomatis dihitung incorrect
        if (answer + 1 == uiState.value.music.answer_key) {
            base_point = 50
        }

        _uiState.value = _uiState.value.copy(
            history = _uiState.value.history.copy(
                point = calculateUpdatedPoint(timeLeft, base_point)
            )
        )

        // _uiState.value = updatedUiState

        return _uiState.value.history.point > 50
    }

    fun calculateUpdatedPoint(timeLeft: Int, basePoint: Int): Int {
        return when {
            timeLeft in 21..30 -> basePoint + 50 // Adjust the points as needed
            timeLeft in 11..20 -> basePoint + 30
            timeLeft in 0..10 -> basePoint + 10
            else -> basePoint + 10
        }
    }
}
package com.example.lyrifyapp.ui.screen.Gameplay

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.MusicAPIResponse
import com.example.lyrifyapp.model.UIState.GameplayUIState
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.screen.Home.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat

//sealed interface GameplayUIState {
//    data class Success(
//        val user: Int,
//        val getMusic: Response<MusicAPIResponse>,
//    ) : GameplayUIState
//
//    object Error : GameplayUIState
//
//    object Loading : GameplayUIState
//}

class GameplayViewModel : ViewModel() {
//    var gameplayUIState: GameplayUIState by mutableStateOf(GameplayUIState.Loading)
//        private set
//
//    lateinit var getMusic: Response<MusicAPIResponse>
//    lateinit var getHistoryUser: Response<History>


    private val _uiState = MutableStateFlow(
        GameplayUIState(
            Music(
                "Normal",
                "Fix You",
                "Pop",
                "When you try your ....., but you dont succeed",
                "best",
                "west",
                "self",
                "well",
                "day",
                "way",
                1,
                "AQl5nFnZPwk",
                "Coldplay",
                "2005",
                30,
                false,
                0,
                "fixyou.jpg",
                "hard"
            ),
            History(
                User(
                    "Yanto Kopling",
                    "Male",
                    "",
                    "halo@gmail.com",
                    "halow1232",
                    "2023-09-22",
                    "aku seorang petualang",
                    3
                ),
                Music(
                    "Normal",
                    "Fix You",
                    "Pop",
                    "When you try your ....., but you dont succeed",
                    "best",
                    "west",
                    "west",
                    "a",
                    "b",
                    "c",
                    1,
                    "AQl5nFnZPwk",
                    "Coldplay",
                    "2005",
                    30,
                    false,
                    0,
                    "fixyou.jpg",
                    "ez"
                ),
                0,
                SimpleDateFormat("yyyy-MM-dd").parse("2023-09-22")!!
            )
        )
    )
    val uiState: StateFlow<GameplayUIState> = _uiState.asStateFlow()
//    init {
//        startUIState()
//    }

//    private fun checkHistoryUser() {
//        viewModelScope.launch {
//
//            getHistoryUser = MyDBContainer().myDBRepositories.getHistoryUser(MyDBContainer.ACCESS_TOKEN, MyDBContainer.USER_ID, MyDBContainer.MUSIC_ID)
//            Log.d("history_check", getHistoryUser.body().toString())
//
//        }
//    }
//

//    private fun startUIState() {
//        viewModelScope.launch {
//            getMusic = MyDBContainer().myDBRepositories.getMusic(MyDBContainer.ACCESS_TOKEN, MyDBContainer.MUSIC_ID)
//            Log.d("music_check", getMusic.body().toString())
//
//            gameplayUIState =
//                GameplayUIState.Success(MyDBContainer.USER_ID, getMusic)
//        }
//    }
    fun CalculatePoint(timeLeft: Int, answer: Int): Boolean {
        var base_point = 0

        // semisal indexnya 99 atau tdk menjawab sama sekali, ya otomatis dihitung incorrect
        if (answer == _uiState.value.music.answer_key) {
            base_point = 50
        }

//        if (getHistoryUser.body()?.point != 0) {
//
//        }
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


package com.example.lyrifyapp.ui.screen.Leaderboard

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.HistoryAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.screen.Profile.ProfileUIState
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface LeaderboardUIState {
    data class Success(
        val user: Int,
        val userNow: Response<UserAPIResponse>,
        val userList: Response<APIListResponse<List<User>>>,
        val histories: Response<HistoryAPIResponse>
    ) : LeaderboardUIState

    object Error : LeaderboardUIState

    object Loading : LeaderboardUIState
}

class LeaderboardViewModel : ViewModel() {
    var leaderboardUIState: LeaderboardUIState by mutableStateOf(LeaderboardUIState.Loading)
        private set

    lateinit var userNow: Response<UserAPIResponse>
    lateinit var userList: Response<APIListResponse<List<User>>>
    lateinit var histories: Response<HistoryAPIResponse>

    init {
        startUIState()
    }

    private fun startUIState() {
        viewModelScope.launch {

            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID)
            Log.d("user_check", userNow.body().toString())
            userList = MyDBContainer().myDBRepositories.user(MyDBContainer.ACCESS_TOKEN)
            Log.d("music_check", userList.body()?.data.toString())
            histories = MyDBContainer().myDBRepositories.histories(MyDBContainer.ACCESS_TOKEN)
            Log.d("chapter_check", histories.body()?.data.toString())

            leaderboardUIState =
                LeaderboardUIState.Success(MyDBContainer.USER_ID, userNow, userList, histories)
        }
    }
}
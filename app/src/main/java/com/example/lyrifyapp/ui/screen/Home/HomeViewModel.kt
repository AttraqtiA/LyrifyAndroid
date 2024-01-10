package com.example.lyrifyapp.ui.screen.Home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.UserAPIResponse
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface HomeUIState {
    data class Success(
        val user: Int,
        val userNow: Response<UserAPIResponse>,
        val musicList: Response<APIListResponse<List<Music>>>,
        val chapterList: Response<APIListResponse<List<Chapter>>>
    ) : HomeUIState

    object Error : HomeUIState

    object Loading : HomeUIState
}

class HomeViewModel : ViewModel() {
    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    lateinit var userNow: Response<UserAPIResponse>
    lateinit var musicList: Response<APIListResponse<List<Music>>>
    lateinit var chapterList: Response<APIListResponse<List<Chapter>>>

    init {
        startUIState()
    }

    private fun startUIState() {
        viewModelScope.launch {

            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.ACCESS_TOKEN, MyDBContainer.USER_ID)
            Log.d("user_check", userNow.body().toString())
            musicList = MyDBContainer().myDBRepositories.getAllMusic(MyDBContainer.ACCESS_TOKEN)
            Log.d("music_check", musicList.body()?.data.toString())
            chapterList = MyDBContainer().myDBRepositories.getAllChapters(MyDBContainer.ACCESS_TOKEN)

            homeUIState =
                HomeUIState.Success(MyDBContainer.USER_ID, userNow, musicList, chapterList)
        }
    }

    private fun toGameplay() {
        viewModelScope.launch {

        }
    }

    private fun toChapterDetail() {

    }

//    loginViewModel = LoginViewModel()

//    fun getLastChapter(User: User): Chapter {
//
//    }

//    fun getCurrentChapter(){
//
//    }
}
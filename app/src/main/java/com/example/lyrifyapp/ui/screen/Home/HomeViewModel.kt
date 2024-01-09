package com.example.lyrifyapp.ui.screen.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.AllMusicAPIResponse
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.MusicAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.screen.Profile.ProfileUIState
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface HomeUIState {
    data class Success(val data1: User, val data2: List<Music>) : HomeUIState

    object Error : HomeUIState

    object Loading : HomeUIState
}

class HomeViewModel : ViewModel() {
    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    lateinit var userNow: User
    lateinit var MusicList: List<Music>

    init {
        startUIState()
    }

    private fun startUIState() {
        viewModelScope.launch {
            val ResponseGetUser: UserAPIResponse = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID)
            val ResponseGetMusic: AllMusicAPIResponse = MyDBContainer().myDBRepositories.getAll_Music()

            userNow = ResponseGetUser.data
            MusicList = ResponseGetMusic.data
            homeUIState = HomeUIState.Success(userNow, MusicList)
        }
    }

    private fun getCurrentUser() {
        viewModelScope.launch {
            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID).data
        }
    }

//    loginViewModel = LoginViewModel()

//    fun getLastChapter(User: User): Chapter {
//
//    }

//    fun getCurrentChapter(){
//
//    }
}
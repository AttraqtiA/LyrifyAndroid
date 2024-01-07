package com.example.lyrifyapp.ui.screen.Home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.User
import kotlinx.coroutines.launch

sealed interface HomeUIState {
    data class Success(val data: User) : HomeUIState

    object Error : HomeUIState

    object Loading : HomeUIState
}

class HomeViewModel : ViewModel() {
    private lateinit var data: User
    var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    fun getUser(id : Int) {
        viewModelScope.launch {
            val result = MyDBContainer().myDBRepositories.getUser(id)
            homeUIState = HomeUIState.Success(data)
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
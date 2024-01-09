package com.example.lyrifyapp.ui.screen.Profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.screen.Home.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

sealed interface ProfileUIState {
    data class Success(val data: Response<UserAPIResponse>) : ProfileUIState

    object Error : ProfileUIState

    object Loading : ProfileUIState
}

class ProfileViewModel : ViewModel() {
    var profileUIState: ProfileUIState by mutableStateOf(ProfileUIState.Loading)
        private set

    lateinit var userNow: Response<UserAPIResponse>

    init {
        startUIState()
    }
    private fun startUIState() {
        viewModelScope.launch {
            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID)

            profileUIState = ProfileUIState.Success(userNow)
        }
    }

    private fun getCurrentUser() {
        viewModelScope.launch {
            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID)
        }
    }
}
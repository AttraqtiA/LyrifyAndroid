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

sealed interface ProfileUIState {
    data class Success(val data: User) : ProfileUIState

    object Error : ProfileUIState

    object Loading : ProfileUIState
}

class ProfileViewModel : ViewModel() {
    var profileUIState: ProfileUIState by mutableStateOf(ProfileUIState.Loading)
        private set

    lateinit var userNow: User

    init {
        startUIState()
    }
    private fun startUIState() {
        viewModelScope.launch {
            val ResponseGetUser: UserAPIResponse = MyDBContainer().myDBRepositories.getUser(
                MyDBContainer.USER_ID)

            userNow = ResponseGetUser.data
            profileUIState = ProfileUIState.Success(userNow)
        }
    }

    private fun getCurrentUser() {
        viewModelScope.launch {
            userNow = MyDBContainer().myDBRepositories.getUser(MyDBContainer.USER_ID).data
        }
    }
}
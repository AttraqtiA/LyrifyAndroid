package com.example.lyrifyapp.ui.screen.Profile

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.model.UIState.HomeUIState
import com.example.lyrifyapp.model.UIState.ProfileUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUIState())
    val uiState: StateFlow<ProfileUIState> = _uiState.asStateFlow()

//    loginViewModel = LoginViewModel()

//    fun editProfile(name, gender, image, email, password, birthdate, description) {
//
//    }
}
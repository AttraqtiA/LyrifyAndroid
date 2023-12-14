package com.example.lyrifyapp.ui.screen.Home

import androidx.lifecycle.ViewModel
import com.example.lyrifyapp.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())

    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

//    loginViewModel = LoginViewModel()
}
package com.example.lyrifyapp.ui.screen.Login

import android.content.Context
import android.graphics.Movie
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.Lyrify_Screen
import com.example.lyrifyapp.ui.screen.Home.HomeUIState
import com.example.lyrifyapp.ui.screen.Register.RegisterViewModel
import kotlinx.coroutines.launch

sealed interface LoginUIState {
    object Success : LoginUIState

    object Error : LoginUIState

    object Loading : LoginUIState
}

class LoginViewModel: ViewModel() {
    var loginUIState: LoginUIState by mutableStateOf(LoginUIState.Loading)
        private set

    val registerViewModel = RegisterViewModel()

    fun loginbutton(
        email: String,
        password: String,
        context: Context,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        viewModelScope.launch {
            //return token
            val token = MyDBContainer().myDBRepositories.login(email, password)

            //untuk error handling
            if (token.equals("Incorrect Password", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else if (token.equals("User Not Found", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else {
                navController.navigate(Lyrify_Screen.Home.name + "/user/" + registerViewModel.getUserId())
                {
                    popUpTo(Lyrify_Screen.LoginView.name) { inclusive = true }
                }
                dataStore.saveToken(token)

                dataStore.getToken.collect { token ->
                    if (token != null) {
                        MyDBContainer.ACCESS_TOKEN = token
                    }
                }
            }
        }
    }
}

package com.example.lyrifyapp.ui.screen.Login

import android.content.Context
import android.graphics.Movie
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.LoginAPIResponse
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

    fun loginbutton(
        email: String,
        password: String,
        context: Context,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        viewModelScope.launch {
            //return token
            val result : LoginAPIResponse = MyDBContainer().myDBRepositories.login(email, password)

            //untuk error handling
            if (result.message == "Incorrect Password" || result.message == "User Not Found") {
                Toast.makeText(context, result.toString(), Toast.LENGTH_LONG).show()
            } else {
                MyDBContainer.ACCESS_TOKEN = result.token
                MyDBContainer.USER_ID = result.user_id

                navController.navigate(Lyrify_Screen.Home.name) {
                    popUpTo(Lyrify_Screen.LoginView.name) { inclusive = true }
                }

                dataStore.saveToken(result.token, result.user_id)
                dataStore.getUser_id.collect {userid1->
                    if (userid1 != null) {
                        MyDBContainer.USER_ID = userid1.toInt()
                    }
                }
                dataStore.getToken.collect {token1->
                    if (token1 != null) {
                        MyDBContainer.ACCESS_TOKEN = token1.toString()
                    }
                }
            }
        }
    }
}

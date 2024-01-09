package com.example.lyrifyapp.ui.screen.Login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.LoginAPIResponse
import com.example.lyrifyapp.ui.Lyrify_Screen
import kotlinx.coroutines.launch

sealed interface LoginUIState {
    object Success : LoginUIState

    object Error : LoginUIState

    object Loading : LoginUIState
}

class LoginViewModel : ViewModel() {
    fun loginbutton(
        email: String,
        password: String,
        context: Context,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        viewModelScope.launch {
            //return token
            val result: LoginAPIResponse = MyDBContainer().myDBRepositories.login(email, password)

            //untuk error handling
            when {
                (result.message == "Incorrect Password" || result.message == "User Not Found") -> {
                    Toast.makeText(context, "Please Try Again!", Toast.LENGTH_LONG).show()
                }
                else -> {
                    dataStore.saveToken(result.token, result.user_id)
                    MyDBContainer.USER_ID = result.user_id

                    dataStore.getToken.collect { token1 ->
                        MyDBContainer.ACCESS_TOKEN = token1.toString()

                        navController.navigate(Lyrify_Screen.Home.name) {
                            popUpTo(Lyrify_Screen.LoginView.name) { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}

package com.example.lyrifyapp.ui.screen.Register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.Lyrify_Screen
import kotlinx.coroutines.launch


class RegisterViewModel : ViewModel() {
    fun registerbutton(
        name: String,
        email: String,
        pass: String,
        birthdate: String,
        gender: String,
        image: Any?,
        bio: String,
        context: Context,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        val text = birthdate
//        val date = formatter.parse(text)

        val user = User(
            name = name,
            email = email,
            password = pass,
            birthdate = birthdate,
            gender = gender,
            achievement = 0,
            description = bio,
            image = image,
//                registration_date = Date().toString()
        )
        viewModelScope.launch {
            val token = MyDBContainer().myDBRepositories.register(user)

            if (token.equals("Validation error", ignoreCase = true) || token.equals(
                    "Error",
                    ignoreCase = true
                )
            ) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else {
                navController.navigate(Lyrify_Screen.LoginView.name)
                {
                    popUpTo(Lyrify_Screen.RegisterView.name) { inclusive = true }
                }
            }
        }
    }
}
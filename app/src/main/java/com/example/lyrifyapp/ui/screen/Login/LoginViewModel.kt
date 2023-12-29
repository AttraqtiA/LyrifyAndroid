package com.example.lyrifyapp.ui.screen.Login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.container.MyDBContainer
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {
    fun loginbutton(email: String,
                    password: String,
                    context: Context,
                    dataStore: DataStoreManager
    ){
        viewModelScope.launch{
            //return token
            val token = MyDBContainer().myDBRepositories.login(email,password)
            //untuk error handling
            if(token.equals("Incorrect Password", true)){
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            }else if(token.equals("User Not Found",true)){
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            }else{
//                navController.navigate(ListScreen.ListMovie.name){
//                    popUpTo(ListScreen.Login.name){inclusive = true}
                }
                dataStore.saveToken(token)


                dataStore.getToken.collect{token->
                    if(token != null){
                        MyDBContainer.ACCESS_TOKEN = token
                    }
                }
            }
        }
    }

}
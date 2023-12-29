package com.example.lyrifyapp.ui.screen.Register

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import kotlinx.coroutines.launch

class RegisterViewModel:ViewModel() {
    fun registerbutton(name:String,
                       email:String,
                       pass:String,
                       birthdate:String,
                       gender:String,
                       context: Context,
                       dataStore:DataStoreManager)
    {
        viewModelScope.launch{
            //return token
            val token = MyDBContainer().myDBRepositories.register(name,email,pass,birthdate,gender)
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
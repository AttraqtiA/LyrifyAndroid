package com.example.lyrifyapp.ui.screen.Register

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.Lyrify_Screen
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date



class RegisterViewModel:ViewModel() {
    fun registerbutton(name:String,
                       email:String,
                       pass:String,
                       birthdate: String,
                       gender:String,
                       context: Context,
                       image: String,
                       dataStore:DataStoreManager,
                       navController:NavController)
    {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val text = birthdate
        val date = formatter.parse(text)


        viewModelScope.launch{
            val user = User(
                name=name,
                email=email,
                password = pass,
                birthdate= date,
                gender=gender,
                achievement = 0,
                description = " ",
                image=image,
                registration_date = Date()
                )

            Log.d("check", "true")
            MyDBContainer().myDBRepositories.register(user)

            navController.navigate(Lyrify_Screen.LoginView.name)
//            //return token
//            val token = MyDBContainer().myDBRepositories.register(name,email,pass,birthdate,gender)
//            //untuk error handling
//            if(token.equals("Incorrect Password", true)){
//                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
//            }else if(token.equals("User Not Found",true)){
//                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
//            }else{
////                navController.navigate(ListScreen.ListMovie.name){
////                    popUpTo(ListScreen.Login.name){inclusive = true}
//            }
//            dataStore.saveToken(token)
//
//
//            dataStore.getToken.collect{token->
//                if(token != null){
//                    MyDBContainer.ACCESS_TOKEN = token
//                }
//            }



        }
    }


}
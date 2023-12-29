package com.example.lyrifyapp.ui.screen.container

import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.screen.Service.MyDBService
import java.net.HttpURLConnection

class MyDBRepositories(private val myDBService: MyDBService) {
    suspend fun login(email: String, password: String):String{
        val user = User(email = email, password = password)
        val result = myDBService.login(user)

        if(result.status.toInt() == HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        else{
            return result.message
        }

    }

    suspend fun logout(): String{
        val result = myDBService.logout()

        return result.message

    }

    suspend fun register(user:User): String{
        val result = myDBService.register(user)

        if(result.status.toInt() == HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        else{
            return result.message
        }
    }






}
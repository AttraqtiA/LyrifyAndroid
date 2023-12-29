package com.example.lyrifyapp.container

import com.example.lyrifyapp.Service.MyDBService
import com.example.lyrifyapp.model.User
import java.net.HttpURLConnection

class MyDBRepositories(private val myDBService: MyDBService) {
    suspend fun login(email: String, password: String):String{
        val user = User(name = "", email = email, password = password)
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

    suspend fun register(name:String,
                         email:String,
                         pass:String,
                         birthdate:String,
                         gender:String): String{
        val result = myDBService.register(name,email,pass,birthdate,gender)

        if(result.status.toInt() == HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        else{
            return result.message
        }
    }






}
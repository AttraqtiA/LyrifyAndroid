package com.example.lyrifyapp.container

import com.example.lyrifyapp.Service.MyDBService
import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.LoginAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import retrofit2.Response
import java.net.HttpURLConnection

class MyDBRepositories(private val myDBService: MyDBService) {
        suspend fun login(email: String, password: String): LoginAPIResponse {
        val user = User(
            name = "",
            email = email,
            password = password,
            gender = "",
            image = "",
            birthdate = "",
            description = "",
            achievement = 0
        )
        val result = myDBService.login(user)

        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result
        }
            return result
    }

    suspend fun logout(): String {
        val result = myDBService.logout()

        return result.message
    }

    suspend fun register(user: User): Any? {
        val result = myDBService.register(user)

        if (result.status.toInt() == HttpURLConnection.HTTP_OK) {
            return result.data
        } else {
            return result.data
        }
    }

    suspend fun getUser(id: Int): UserAPIResponse {
        return myDBService.getUser(id)
    }



}
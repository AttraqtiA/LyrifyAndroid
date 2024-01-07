package com.example.lyrifyapp.container

import android.graphics.Movie
import com.example.lyrifyapp.Service.MyDBService
import com.example.lyrifyapp.model.User
import com.google.android.datatransport.runtime.util.PriorityMapping.toInt
import java.net.HttpURLConnection
import java.text.SimpleDateFormat

class MyDBRepositories(private val myDBService: MyDBService) {
    suspend fun login(email: String, password: String): Any {
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
            return result.data
        } else {
            return result.message
        }
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

    suspend fun getUser(id: Int): Any {

        val result = myDBService.getUser(id)

        if (result != null) {
            val data = User(
                result.name,
                result.gender,
                result.image,
                result.email,
                result.password,
                result.birthdate,
                result.description,
                result.achievement
            )
            return data
        } else {
            return "User Not Found"
        }
    }
}
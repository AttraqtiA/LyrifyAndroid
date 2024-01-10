package com.example.lyrifyapp.container

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.lyrifyapp.Service.MyDBService
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.HistoryAPIResponse
import com.example.lyrifyapp.model.LoginAPIResponse
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.MusicAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.google.gson.internal.LinkedTreeMap
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

    suspend fun register(user: User): Any {
        val result = myDBService.register(user)

        return result.data
    }

    suspend fun getUser(id: Int): Response<UserAPIResponse> {
        return myDBService.getUser(MyDBContainer.ACCESS_TOKEN, id)
    }

    // MUSIC
    suspend fun getAllMusic(token: String): Response<APIListResponse<List<Music>>> {
        return myDBService.getAllMusics(token)
    }

    suspend fun getMusic(id: Int): Response<MusicAPIResponse> {
        return myDBService.getMusic(MyDBContainer.ACCESS_TOKEN, id)
    }

    // CHAPTER
    suspend fun getAllChapters(token: String): Response<APIListResponse<List<Chapter>>> {
        return myDBService.getAllChapters(token)
    }

    suspend fun user(token: String): Response<APIListResponse<List<User>>> {
        return myDBService.user(token)
    }

    suspend fun histories(token: String): Response<HistoryAPIResponse> {
        return myDBService.histories(token)
    }
}
//hisorey where user score sum

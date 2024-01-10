package com.example.lyrifyapp.container

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.lyrifyapp.Service.MyDBService
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.LoginAPIResponse
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.MusicAPIResponse
import com.example.lyrifyapp.model.TotalPointAPIResponse
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

    // USER
    suspend fun logout(): String {
        val result = myDBService.logout()

        return result.message
    }

    suspend fun register(user: User): Any {
        val result = myDBService.register(user)

        return result.data
    }

    suspend fun getUser(token: String, id: Int): Response<UserAPIResponse> {
        return myDBService.getUser(token, id)
    }

    suspend fun updateUser(token: String, user: User): APIResponse {
        return myDBService.update(token, user)
    }

    // MUSIC
    suspend fun getAllMusic(token: String): Response<APIListResponse<List<Music>>> {
        return myDBService.getAllMusic(token)
    }

    suspend fun getMusic(token: String, id: Int): Response<MusicAPIResponse> {
        return myDBService.getMusic(token, id)
    }

    // CHAPTERS
    suspend fun getAllChapters(token: String): Response<APIListResponse<List<Chapter>>> {
        return myDBService.getAllChapters(token)
    }

    // TOTAL POINT ON CHAPTER
    suspend fun getTotalPoint(token: String, chapterID: Int, userID: Int): TotalPointAPIResponse {
        return myDBService.getTotalPoint(token, chapterID, userID)
    }

    // getMusicBasedOnChapter
    suspend fun getMusicBasedOnChapter(token: String, id: Int): Response<APIListResponse<List<Music>>> {
        return myDBService.getMusicBasedOnChapter(token, id)
    }

    // HISTORY
    suspend fun createHistory(token: String, history: History): APIResponse {
        return myDBService.createHistory(token, history)
    }

    suspend fun getHistoryUser(token: String, userId: Int, musicId: Int): Response<History> {
        return myDBService.getHistoryUser(token, userId, musicId)
    }
}
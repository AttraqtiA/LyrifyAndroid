package com.example.lyrifyapp.Service

import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.HistoryAPIResponse
import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.model.LevelAPIResponse
import com.example.lyrifyapp.model.LoginAPIResponse
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.MusicAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MyDBService {

    //REGISTER
    @POST("create_user")
    suspend fun register(@Body user: User): APIResponse

    //LOGIN
    @POST("login")
    suspend fun login(@Body user: User): LoginAPIResponse

    //LOGOUT
    @DELETE("logout")
    suspend fun logout(): APIResponse

    //USER
    @GET("all_user")
    suspend fun user(
        @Header("Authorization") token: String,
        ): Response<APIListResponse<List<User>>>

    @GET("user/{id}")
    suspend fun getUser(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<UserAPIResponse>

    @PATCH("update_user/{id}")
    suspend fun update(@Body user: User): APIResponse

    @DELETE("delete_user/{id}")
    suspend fun delete(): APIResponse

    // MUSIC
    @GET("/musics")
    suspend fun getAllMusics(
        @Header("Authorization") token: String
    ): Response<APIListResponse<List<Music>>>

    @GET("/musics/{id}")
    suspend fun getMusic(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<MusicAPIResponse>

    // CHAPTERS
    @GET("chapters")
    suspend fun getAllChapters(
        @Header("Authorization") token: String
    ): Response<APIListResponse<List<Chapter>>>

    @GET("chapter/{id}")
    suspend fun getChapter(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<Chapter>

    // HISTORY
    @GET("/histories")
    suspend fun histories(
        @Header("Authorization") token: String
    ): Response<HistoryAPIResponse>

    @POST("/create_history")
    suspend fun register(@Body history: History): APIResponse

    @PATCH("/update_history/{id}")
    suspend fun updatehistory(): APIResponse

    @DELETE("/delete_history/{id}")
    suspend fun deletehistory(): APIResponse

    // LEVELS
    @GET("/levels")
    suspend fun levels(
        @Header("Authorization") token: String
    ): Level

    @GET("/users/sorted-by-points")
    suspend fun getUsersSortedByPoints(
        @Header("Authorization") token: String
    ): APIListResponse<List<User>>

    @GET("/levels/{id}")
    suspend fun getLevel(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<LevelAPIResponse>

}
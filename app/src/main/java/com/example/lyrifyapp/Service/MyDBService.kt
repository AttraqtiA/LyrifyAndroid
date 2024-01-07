package com.example.lyrifyapp.Service

import com.example.lyrifyapp.model.APIResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.Level
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MyDBService {

    //REGISTER
    @POST("create_user")
    suspend fun register(@Body user: User): APIResponse

    //LOGIN
    @POST("login")
    suspend fun login(@Body user: User): APIResponse

    //LOGOUT
    @DELETE("logout")
    suspend fun logout(): APIResponse

    @GET("all_user")
    suspend fun user(): User

    @GET("user/{id}")
    suspend fun getUser(@Path("user/{id}") id: Int): User

    @PATCH("update_user/{id}")
    suspend fun update(): APIResponse

    @DELETE("delete_user/{id}")
    suspend fun delete(): APIResponse

//    @GET("user_music")
//    suspend fun usermusic(): UserMusic
//
//    @POST("create_user_music")
//    suspend fun createusermusic(@Body usermusic:UserMusic): APIResponse
//
//    @PATCH("update_user_music/{id}")
//    suspend fun updateusermusic():APIResponse
//
//    @DELETE("delete_user_music/{id}")
//    suspend fun deleteusermusic():APIResponse

    //history
    @GET("histories")
    suspend fun histories(): History

    @POST("create_history")
    suspend fun register(@Body history: History): APIResponse

    @PATCH("update_history/{id}")
    suspend fun updatehistory(): APIResponse

    @DELETE("delete_history/{id}")
    suspend fun deletehistory(): APIResponse

//chapter

    @GET("chapters")
    suspend fun chapters(): Chapter
    //level

    @GET("levels")
    suspend fun levels(): Level

    //music
    @GET("musics")
    suspend fun musics(): Music
}
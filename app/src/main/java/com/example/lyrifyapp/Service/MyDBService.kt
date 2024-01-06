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

    //login logout
    @POST("login")
    suspend fun login(@Body user: User): APIResponse

    @GET("user/{id}")
    suspend fun getUser(@Path("user/{id}") id:Int):User

    @DELETE("logout")
    suspend fun logout():APIResponse

    //register
    @POST("create_user")
    suspend fun register(@Body user: User): APIResponse


    @GET("histories")
    suspend fun histories(): History
    @GET("chapters")
    suspend fun chapters(): Chapter
    @GET("levels")
    suspend fun levels(): Level
    @GET("musics")
    suspend fun musics(): Music

    @GET("all_user")
    suspend fun user(): User

    @PATCH("update_user/{id}")
    suspend fun update():APIResponse

    @DELETE("delete_user/{id}")
    suspend fun delete():APIResponse
    

//    Route::post('create_user', [UserController::class, 'createUser']);
//    Route::post('login', [AuthenticationController::class, 'login'])->name('login');
//    Route::get('user/{id}', [UserController::class, 'getUser']);


}
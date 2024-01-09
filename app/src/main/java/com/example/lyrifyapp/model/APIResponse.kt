package com.example.lyrifyapp.model

class APIResponse (
    val status:String = "",
    val message:String = "",
    val data: Any,
)
class LoginAPIResponse (
    val status:String = "",
    val message:String = "",
    val token: String = "",
    val user_id: Int = -1
)

class UserAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: User,
)

class MusicAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: Music
)

class AllMusicAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: List<Music>
)
package com.example.lyrifyapp.model

import kotlinx.serialization.Serializable

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

class ChapterAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: Chapter
)

class LevelAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: Level
)

class HistoryAPIResponse (
    val status:String = "",
    val message:String = "",
    val data: History
)
class APIListResponse<T> (
    val status:String = "",
    val message:String = "",
    val data: T
)
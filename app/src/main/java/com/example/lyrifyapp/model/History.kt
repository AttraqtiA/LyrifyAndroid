package com.example.lyrifyapp.model

import java.util.Date

data class History(
    val id: Int,
    val User: User,
    val Chapter: Chapter,
    val last_played: Date
)

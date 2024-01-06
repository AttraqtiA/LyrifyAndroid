package com.example.lyrifyapp.model

import java.math.BigInteger
import java.util.Date

data class History(
//    val id: Int,
    val user: User,
    val music: Music,
    val point: Int,
    val last_played: Date
)

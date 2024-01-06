package com.example.lyrifyapp.model

import java.math.BigInteger
import java.util.Date

data class History(
    val id: Int,
    val user: User,
    val chapter: Chapter,
    val total_point: BigInteger,
    val last_played: Date
)

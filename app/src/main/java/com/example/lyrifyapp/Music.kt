package com.example.lyrifyapp

import androidx.annotation.RawRes
import java.util.Date

data class Music(
    val id: Int,
    val challenge_type: String,
    val title: String,
    val genre: String,
    val lyric: String,
    @RawRes val audio: Int,
    val artist: String,
    val year_released: Date,
    val guess_duration: Int,
    val status: Boolean,
    val point: Int
)

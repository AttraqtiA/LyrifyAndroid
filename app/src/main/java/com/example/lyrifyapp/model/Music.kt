package com.example.lyrifyapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import java.time.Year
import java.util.Date

data class Music (
//    val id: Int,
    val challenge_type: String,
    val title: String,
    val genre: String,
    val lyrics: String,
    val options: MutableList<String>,
    val answer_key: Int,
//    @RawRes val audio: Int,
    val youtube_link: String,
    val artist: String,
    val year_released: String,
    val guess_duration: Int,
    val status: Boolean,
    val point: Int,
    val image: String
)

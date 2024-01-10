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
    val lyric: String,
    val option: MutableList<String>,
//    val option1: String,
//    val option2: String,
//    val option3: String,
//    val option4: String,
//    val option5: String,
//    val option6: String,
    val answer_key: Int,
    val youtube_link: String,
    val artist: String,
    val year_released: String,
    val guess_duration: Int,
    val status: Boolean,
    val point: Int,
    val image: String,
    val difficulty: String
)

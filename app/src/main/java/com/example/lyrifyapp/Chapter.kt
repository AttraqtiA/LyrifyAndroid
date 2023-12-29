package com.example.lyrifyapp

import androidx.annotation.DrawableRes

data class Chapter(
    val id: Int,
    val title: String,
    val description: String,
    val total_point: Int,
    val status: Boolean,
    @DrawableRes val image: Int
)

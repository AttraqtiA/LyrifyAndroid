package com.example.lyrifyapp.model

import androidx.annotation.DrawableRes

data class Chapter(
//    val id: Int,
    val title: String,
    val description: String,
    val status: Boolean,
    @DrawableRes val image: Int
)

package com.example.lyrifyapp

import androidx.annotation.DrawableRes
import java.util.Date

data class User(
    val id: Int,
    val name: String,
    val gender: String,
    @DrawableRes val image: Int,
    val email: String,
    val password: String,
    val birthdate: Date,
    val registration_date: Date,
    val description: String,
    val achievement: Int
)

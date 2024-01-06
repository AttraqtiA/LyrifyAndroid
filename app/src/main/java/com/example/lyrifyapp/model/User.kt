package com.example.lyrifyapp.model

import java.util.Date

data class User(
    val name: String,
    val gender: String,
//    @DrawableRes
    val image: String,
    val email: String,
    val password: String,
    val birthdate: Date,
    val registration_date: Date,
    val description: String,
    val achievement: Int
)

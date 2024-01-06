package com.example.lyrifyapp.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val gender: String,
//    @DrawableRes
    val image: Any?,
    val email: String,
    val password: String,
    val birthdate: String,
//    val registration_date: String,
    val description: String,
    val achievement: Int
)

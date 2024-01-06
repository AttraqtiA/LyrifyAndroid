package com.example.lyrifyapp.model

import com.example.lyrifyapp.Music

data class Level(
    val id: Int,
    val chapter: Chapter,
    val music: Music,
    val difficulty: String
)

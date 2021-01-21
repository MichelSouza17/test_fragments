package com.example.testfragment.model

import android.graphics.drawable.Drawable

data class Game(
    var id: Long,
    var gameName: String,
    var gameImage: Drawable,
    var gameDescription: String,
    var gameRating: Double,
    var consoles: List<Console>
)
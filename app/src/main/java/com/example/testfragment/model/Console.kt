package com.example.testfragment.model

import android.graphics.drawable.Drawable

data class Console(
    var id: Long,
    var consoleName: String,
    var consoleReleaseDate: String,
    var consoleDescription: String,
    var consoleMaker: String,
    var consoleImage: Drawable
)
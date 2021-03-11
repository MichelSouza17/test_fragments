package com.example.testfragment.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Console(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var consoleName: String,

    @ColumnInfo(name = "date")
    var consoleReleaseDate: String,

    @ColumnInfo(name = "description")
    var consoleDescription: String,

    @ColumnInfo(name = "Maker")
    var consoleMaker: String,

    @ColumnInfo(name = "image")
    var consoleImage: Drawable
)
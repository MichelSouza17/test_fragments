package com.example.testfragment.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testfragment.model.Console

@Database(entities = [Console::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun consoleDao(): ConsoleDao

}

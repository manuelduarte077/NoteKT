package com.manuelduarte077.notyapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manuelduarte077.notyapp.data.TaskDao
import com.manuelduarte077.notyapp.data.TaskEntity

@Database(
    entities = [
        TaskEntity::class
    ],
    version = 1
)

abstract class TodoDatabase:RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
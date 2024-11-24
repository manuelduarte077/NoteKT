package com.manuelduarte077.notyapp.features.notes.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM notes")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getTaskById(id: String): TaskEntity?

    @Upsert
    suspend fun upsertTask(task: TaskEntity)

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteTaskById(id: String)

    @Query("DELETE FROM notes")
    suspend fun deleteAllTasks()
}
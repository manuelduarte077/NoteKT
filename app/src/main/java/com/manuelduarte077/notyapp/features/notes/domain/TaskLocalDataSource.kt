package com.manuelduarte077.notyapp.features.notes.domain

import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    val tasksFlow: Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun updateTask(updatedTask: Task)
    suspend fun removeTask(task: Task)
    suspend fun deleteAllTasks()
    suspend fun getTaskById(taskId: String): Task?
    suspend fun removeAllTasks()
}
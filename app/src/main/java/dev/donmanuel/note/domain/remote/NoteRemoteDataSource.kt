package dev.donmanuel.note.domain.remote

import dev.donmanuel.note.domain.Category
import dev.donmanuel.note.domain.Note
import dev.donmanuel.note.domain.Priority
import dev.donmanuel.note.domain.Tag

interface NoteRemoteDataSource {
    suspend fun getTasks(): List<Note>
    suspend fun getTaskById(id: Long): Note
    suspend fun insertTask(task: Note)
    suspend fun updateTask(task: Note)
    suspend fun deleteTask(task: Note)
    suspend fun searchTasks(query: String): List<Note>
    suspend fun getTasksByCategory(category: Category): List<Note>
    suspend fun getTasksByPriority(priority: Priority): List<Note>
    suspend fun getTasksByTag(tag: Tag): List<Note>
    suspend fun archiveTasks()
}
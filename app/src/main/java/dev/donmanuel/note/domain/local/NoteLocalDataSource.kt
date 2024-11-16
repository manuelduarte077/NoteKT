package dev.donmanuel.note.domain.local

import dev.donmanuel.note.domain.Category
import dev.donmanuel.note.domain.Priority
import dev.donmanuel.note.domain.Tag
import dev.donmanuel.note.domain.Note
import kotlinx.coroutines.flow.Flow

interface NoteLocalDataSource {
    val noteFlow: Flow<List<Note>>
    suspend fun getNotes(): List<Note>
    suspend fun getNoteById(id: String): Note?
    suspend fun insertNote(task: Note)
    suspend fun updateNote(task: Note)
    suspend fun deleteNote(task: Note)
    suspend fun deleteAllNotes()
    suspend fun searchNotes(query: String): List<Note>
    suspend fun getTasksByCategory(category: Category): List<Note>
    suspend fun getTasksByPriority(priority: Priority): List<Note>
    suspend fun getTasksByTag(tag: Tag): List<Note>
}
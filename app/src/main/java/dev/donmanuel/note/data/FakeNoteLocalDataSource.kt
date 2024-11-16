package dev.donmanuel.note.data

import dev.donmanuel.note.domain.Category
import dev.donmanuel.note.domain.Note
import dev.donmanuel.note.domain.Priority
import dev.donmanuel.note.domain.Tag
import dev.donmanuel.note.domain.local.NoteLocalDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object FakeNoteLocalDataSource : NoteLocalDataSource {
    private val _noteFlow = MutableStateFlow<List<Note>>(emptyList())

    override val noteFlow: Flow<List<Note>>
        get() = _noteFlow

    override suspend fun getNotes(): List<Note> {
        return _noteFlow.value
    }

    override suspend fun getNoteById(id: String): Note? {
        return _noteFlow.value.firstOrNull { it.id == id }
    }

    override suspend fun insertNote(task: Note) {
        val notes = _noteFlow.value.toMutableList()
        notes.add(task)
        delay(100)
        _noteFlow.value = notes
    }

    override suspend fun updateNote(task: Note) {
        val notes = _noteFlow.value.toMutableList()
        val noteIndex = notes.indexOfFirst { it.id == task.id }

        if (noteIndex != -1) {
            notes[noteIndex] = task
            delay(100)
            _noteFlow.value = notes
        }
    }

    override suspend fun deleteNote(task: Note) {
        val note = _noteFlow.value.toMutableList()
        note.remove(task)
        delay(100)
    }

    override suspend fun deleteAllNotes() {
        _noteFlow.value = emptyList()
    }

    override suspend fun searchNotes(query: String): List<Note> {
        return _noteFlow.value.filter {
            it.title.contains(query, ignoreCase = true) ||
                    it.description?.contains(query, ignoreCase = true) ?: false
        }
    }

    override suspend fun getTasksByCategory(category: Category): List<Note> {
        return _noteFlow.value.filter { it.category == category }
    }

    override suspend fun getTasksByPriority(priority: Priority): List<Note> {
        return _noteFlow.value.filter { it.priority == priority }
    }

    override suspend fun getTasksByTag(tag: Tag): List<Note> {
        return _noteFlow.value.filter { it.tags?.contains(tag) ?: false }
    }

}
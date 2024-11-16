package dev.donmanuel.note.domain

import java.time.LocalDateTime


data class Note(
    val id: String,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val category: Category? = null,
    val priority: Priority? = null,
    val subtasks: List<Note> = emptyList(),
    val tags: List<Tag>? = emptyList(),
    val createdAt: LocalDateTime? = null,
    val dueDate: LocalDateTime? = null,
    val reminderDate: LocalDateTime? = null,
    val recurrence: Recurrence? = null,
)

package com.manuelduarte077.notyapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manuelduarte077.notyapp.domain.Category
import com.manuelduarte077.notyapp.domain.Task
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val description: String?,
    val category: Int?,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean,
    val date: Long,
) {
    companion object {
        fun fromTask(task: Task): TaskEntity {
            return TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isCompleted = task.isCompleted,
                category = task.category?.ordinal,
                date = task.date
                    .atZone(
                        ZoneId.systemDefault()
                    ).toInstant()
                    .toEpochMilli(),
            )
        }
    }

    fun toTask(): Task {
        return Task(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            category = category?.let { Category.fromOrdinal(it) },
            date = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(date),
                ZoneId.systemDefault()
            )
        )
    }
}
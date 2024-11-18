package com.manuelduarte077.notyapp.domain

import com.manuelduarte077.notyapp.domain.Category
import java.time.LocalDateTime

data class Task(
    val id: String,
    val title:String,
    val description:String?,
    val isCompleted:Boolean = false,
    val category: Category? = null,
    val date: LocalDateTime = LocalDateTime.now()
)

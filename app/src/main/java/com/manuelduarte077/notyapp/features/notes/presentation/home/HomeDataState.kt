package com.manuelduarte077.notyapp.features.notes.presentation.home

import com.manuelduarte077.notyapp.features.notes.domain.Task

data class HomeDataState(
    val date: String = "",
    val summary: String = "",
    val completedTask: List<Task> = emptyList(),
    val pendingTask: List<Task> = emptyList(),
)
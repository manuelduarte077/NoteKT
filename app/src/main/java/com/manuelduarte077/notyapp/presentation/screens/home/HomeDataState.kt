package com.manuelduarte077.notyapp.presentation.screens.home

import com.manuelduarte077.notyapp.domain.Task

data class HomeDataState(
    val date: String = "",
    val summary: String = "",
    val completedTask: List<Task> = emptyList(),
    val pendingTask: List<Task> = emptyList(),
)
package com.manuelduarte077.notyapp.presentation.screens.detail

import androidx.compose.foundation.text.input.TextFieldState
import com.manuelduarte077.notyapp.domain.Category

data class TaskScreenState(
    val taskName:TextFieldState = TextFieldState(),
    val taskDescription: TextFieldState = TextFieldState(),
    val isTaskDone: Boolean = false,
    val category: Category? = null,
    val canSaveTask: Boolean = false
)
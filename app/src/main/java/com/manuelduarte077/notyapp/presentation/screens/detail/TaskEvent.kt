package com.manuelduarte077.notyapp.presentation.screens.detail

sealed interface TaskEvent{
    data object TaskCreated: TaskEvent
}
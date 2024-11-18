package com.manuelduarte077.notyapp.presentation.screens.home

import com.manuelduarte077.notyapp.domain.Task

sealed interface HomeScreenAction{
    data class OnToggleTask(val task: Task): HomeScreenAction
    data class OnDeleteTask(val task: Task): HomeScreenAction
    data object OnDeleteAllTasks: HomeScreenAction
    data object OnAddTask: HomeScreenAction
    data class OnClickTask(val taskId:String): HomeScreenAction
}
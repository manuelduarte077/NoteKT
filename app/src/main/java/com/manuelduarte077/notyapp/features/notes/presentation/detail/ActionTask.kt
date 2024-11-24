package com.manuelduarte077.notyapp.features.notes.presentation.detail

import com.manuelduarte077.notyapp.features.notes.domain.Category

sealed interface ActionTask {
    data object SaveTask : ActionTask
    data object Back : ActionTask
    data class ChangeTaskCategory(val category: Category?) : ActionTask
    data class ChangeTaskDone(val isTaskDone: Boolean) : ActionTask
}
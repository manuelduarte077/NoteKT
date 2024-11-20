package com.manuelduarte077.notyapp.features.notes.presentation.home

sealed interface HomeScreenEvent {
    data object UpdatedTask :
        HomeScreenEvent

    data object DeletedTask :
        HomeScreenEvent

    data object AllTaskDeleted :
        HomeScreenEvent
}
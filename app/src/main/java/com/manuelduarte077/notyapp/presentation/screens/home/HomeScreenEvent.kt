package com.manuelduarte077.notyapp.presentation.screens.home

sealed interface HomeScreenEvent {
    data object UpdatedTask : HomeScreenEvent
    data object DeletedTask : HomeScreenEvent
    data object AllTaskDeleted : HomeScreenEvent
}
package com.manuelduarte077.notyapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manuelduarte077.notyapp.features.notes.presentation.detail.TaskScreenRoot
import com.manuelduarte077.notyapp.features.notes.presentation.detail.TaskViewModel
import com.manuelduarte077.notyapp.features.notes.presentation.home.HomeScreenRoot
import com.manuelduarte077.notyapp.features.notes.presentation.home.HomeScreenViewModel

import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize())
    {
        NavHost(
            navController = navController,
            startDestination = HomeScreenDes
        ) {
            composable<HomeScreenDes> {
                val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

                HomeScreenRoot(
                    viewModel = homeScreenViewModel,
                    navigateToTaskScreen = { taskId ->
                        navController.navigate(
                            TaskScreenDes(
                                taskId = taskId
                            )
                        )
                    }
                )
            }

            composable<TaskScreenDes> {
                val taskViewModel = hiltViewModel<TaskViewModel>()
                TaskScreenRoot(
                    viewModel = taskViewModel,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Serializable
object HomeScreenDes

@Serializable
data class TaskScreenDes(val taskId: String? = null)

// Splash Screen

// Onboarding Screen

// SignIn Screen
@Serializable
object SignInScreen
package com.manuelduarte077.notyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.manuelduarte077.notyapp.navigation.NavigationRoot
import com.manuelduarte077.notyapp.ui.theme.NoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NoteTheme() {
                val navController = rememberNavController()
                NavigationRoot(navController)
            }
        }
    }
}


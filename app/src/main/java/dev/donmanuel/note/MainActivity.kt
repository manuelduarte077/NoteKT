package dev.donmanuel.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.donmanuel.note.data.FakeNoteLocalDataSource
import dev.donmanuel.note.domain.Category
import dev.donmanuel.note.domain.Note
import dev.donmanuel.note.domain.Priority
import dev.donmanuel.note.domain.Recurrence
import dev.donmanuel.note.domain.Tag
import dev.donmanuel.note.ui.theme.NoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteTheme {
                var text by remember { mutableStateOf("") }
                val fakeLocalDataSource = FakeNoteLocalDataSource

                LaunchedEffect(true) {
                    fakeLocalDataSource.noteFlow.collect {
                        text = it.toString()
                    }
                }

                LaunchedEffect(true) {
                    fakeLocalDataSource.insertNote(
                        Note(
                            id = "1",
                            title = "Title",
                            description = "Description",
                            isCompleted = false,
                            category = Category.WORK,
                            priority = Priority.HIGH,
                            subtasks = listOf(
                                Note(
                                    id = "2",
                                    title = "Subtask",
                                    description = "Subtask description",
                                    isCompleted = false,
                                    category = Category.PERSONAL,
                                    priority = Priority.LOW,
                                    tags = listOf(Tag("tag1"), Tag("tag2"), Tag("tag3")),
                                    recurrence = Recurrence.WEEKLY,
                                ),
                            ),
                            tags = listOf(Tag("tag")),
                            recurrence = Recurrence.DAILY,
                        ),
                    )
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = text,
                        modifier = Modifier
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                            )
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}


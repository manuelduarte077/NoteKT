package com.manuelduarte077.notyapp.features.notes.data.di

import android.content.Context
import androidx.room.Room
import com.manuelduarte077.notyapp.features.notes.data.RoomTaskLocalDataSource
import com.manuelduarte077.notyapp.features.notes.data.TaskDao
import com.manuelduarte077.notyapp.features.notes.data.TodoDatabase
import com.manuelduarte077.notyapp.features.notes.domain.TaskLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext
        context: Context
    ): TodoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "note_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(
        database: TodoDatabase
    ): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideTaskLocalDataSource(
        taskDao: TaskDao,
        @Named("dispatcherIO")
        dispatcherIO: CoroutineDispatcher
    ): TaskLocalDataSource {
        return RoomTaskLocalDataSource(taskDao, dispatcherIO)
    }
}
package com.practicing.notetakingapp2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practicing.notetakingapp2.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase()
{
    abstract fun noteDao(): NoteDao

    companion object
    {
        @Volatile
        private var instance: NoteDatabase?=null
        private val LOCK = Any()

        operator fun invoke(Context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: createDatabase(Context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_database").build()
    }
}
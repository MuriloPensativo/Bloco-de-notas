package com.example.blocodenotas.Database

import androidx.room.Database
import com.example.blocodenotas.Models.Note


@Database(entities = arrayOf(Note :: class), version = 1, exportSchema = false)
abstract class NoteDatabase {

    abstract fun getNotDao() : NoteDao


}
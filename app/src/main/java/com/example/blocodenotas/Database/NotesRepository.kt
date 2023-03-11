package com.example.blocodenotas.Database

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes : LiveData<List<Note>> = NoteDao.getAllNotes()

    suspend fun insert(note : Note){
        noteDao.insert(note)
    }


    suspend fun delete(note : Note){
        noteDao.delete(note)
    }

    suspend fun update(note : Note){
        NoteDao.update(note.javaClass.title,note.note)
    }

}
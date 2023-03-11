package com.example.blocodenotas.Database

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blocodenotas.Models.Note


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: ContactsContract.CommonDataKinds.Note)

    @Delete
    suspend fun delete(note: ContactsContract.CommonDataKinds.Note)


    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("UPDATE notes_table Set title = :title, note = :note WHERE id = :id")
    suspend fun update(id : Int?, title : String?, note : String?)
    abstract fun update(id: Int?)

    companion object {
        fun getAllNotes(): LiveData<List<ContactsContract.CommonDataKinds.Note>> {
            TODO("Not yet implemented")
        }

        fun update(title: Any, note: Any) {

        }
    }

}
package com.example.blocodenotas.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blocodenotas.Models.DATABASE_NAME
import com.example.blocodenotas.Models.Note


@Database(entities = arrayOf(Note :: class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun getNotDao() : NoteDao

    companion object{

        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getDatabase(contexte : Contexte) :NoteDatabase{


            return INSTANCE ?: synchronized(this){

                val instance = room.databaseBuilder(
                    contexte.applicationContext,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance

                instance


            }


        }



    }


}
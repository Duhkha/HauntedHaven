package com.example.hauntedhaven.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HauntedPlace::class], version=1, exportSchema=false)
abstract class HauntedDatabase: RoomDatabase() {

    abstract fun hauntedDao(): HauntedDao

    companion object {

        @Volatile
        private var INSTANCE: HauntedDatabase? = null


        fun getDatabase(context: Context): HauntedDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    HauntedDatabase::class.java,
                    "haunted_places_database"
                )
                    .createFromAsset("database/HauntedDatabase.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }

    }


}
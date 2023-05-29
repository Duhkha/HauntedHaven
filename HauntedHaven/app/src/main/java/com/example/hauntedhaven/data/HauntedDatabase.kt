package com.example.hauntedhaven.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
//kotlinx ako bude zezalo

@Database(entities = [HauntedPlace::class], version=1, exportSchema=false)
abstract class HauntedDatabase: RoomDatabase() {

    abstract fun hauntedDao(): HauntedDao

    companion object {
        @Volatile
        private var Instance: HauntedDatabase? = null

        fun getDatabase(context: Context): HauntedDatabase {
            return Instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HauntedDatabase::class.java,
                    "haunted_places_database"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<DatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    })
                    .build()
                Instance = instance
                instance
            }
        }
    }


}
package com.example.hauntedhaven.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class DatabaseWorker(context: Context, workerParams: WorkerParameters)
    : CoroutineWorker(context, workerParams) {

     override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val dao = HauntedDatabase.getDatabase(applicationContext).hauntedDao()
        val places = listOf(

            HauntedPlace(
            id = 0,
            name = "Stanley Hotel",
            location = "Colorado, USA",
            price = 300.0,
            availableDates = listOf("2023-05-28"),
            description = "This is a haunted hotel...",
            details = "Details about the place...",
            category = "Haunted Hotels",
            sleepoverAvailability= true,
            imageUri = "android.resource://com.example.hauntedhaven/drawable/stanley_hotel"
        ),
            //more haunted places

            )
         places.forEach { place ->
             dao.insertAll(place)
         }

         Result.success()
    }
}

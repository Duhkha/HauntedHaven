package com.example.hauntedhaven

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkerFactory
import com.example.hauntedhaven.data.HauntedDatabase
import com.example.hauntedhaven.data.MyWorkerFactory




class HauntedHavenApplication : Application(), Configuration.Provider {

    lateinit var myWorkerFactory: MyWorkerFactory

    override fun onCreate() {
        super.onCreate()
        myWorkerFactory = MyWorkerFactory()
    }

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(myWorkerFactory)
            .build()
}

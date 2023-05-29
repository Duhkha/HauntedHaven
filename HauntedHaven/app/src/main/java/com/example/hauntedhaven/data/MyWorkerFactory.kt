package com.example.hauntedhaven.data

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

class MyWorkerFactory : WorkerFactory() {
    override fun createWorker(appContext: Context, workerClassName: String, workerParameters: WorkerParameters): ListenableWorker? {
        return when (workerClassName) {
            DatabaseWorker::class.java.name ->
                DatabaseWorker(appContext, workerParameters)
            else ->
                null
        }
    }
}

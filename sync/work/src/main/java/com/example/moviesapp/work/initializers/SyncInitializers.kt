package com.example.moviesapp.work.initializers

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.moviesapp.work.workers.SyncWorker
import java.util.concurrent.TimeUnit
import javax.inject.Inject


object Sync{
    // This method initializes sync, the process that keeps the app's data current.
    // It is called from the app module's Application.onCreate() and should be only done once.

    fun initialize(context: Context) {
        WorkManager.getInstance(context).apply {
            // Run sync on app startup and ensure only one sync worker runs at any time
            enqueueUniquePeriodicWork(
                SYNC_WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                SyncWorker.startUpSyncWork()
            )
        }
    }
}

// This name should not be changed otherwise the app may have concurrent sync requests running
internal const val SYNC_WORK_NAME = "MovieSyncWork"

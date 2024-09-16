package com.example.moviesapp.work.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

/**
Syncs the data by delegating the task to the appropriate repository
which handles the actual sync
 */

@HiltWorker
internal class SyncWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: OfflineFirstMoviesAppRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result =
        withContext(IO) {
            try {
                Log.d("SyncWorker", "Worker started")

                // First sync the repositories in parallel
                launch { repository.syncTrendingMovies() }
                launch { repository.syncUpcomingMovies() }

                Log.d("SyncWorker", "Worker completed successfully")
                Result.success()
            } catch (e: Exception) {
                Log.e("SyncWorker", "Worker failed: ${e.message}", e)
                Result.failure()
            }
        }

    companion object {
        /**
         * Expedited one time work to sync data on app startup
         */
        fun startUpSyncWork() = PeriodicWorkRequestBuilder<SyncWorker>(
            15, TimeUnit.MINUTES // Minimum interval is 15 minutes
        ).build()
    }
}
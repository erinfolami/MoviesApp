package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.work.initializers.Sync
import dagger.hilt.android.HiltAndroidApp


/**
 * [Application] class for MoviesApp
 */
@HiltAndroidApp
class MoviesApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        // Initialize Sync; the system responsible for keeping data in the app up to date.
        Sync.initialize(context = this)
    }


}
package com.friendsapp.github

import android.app.Application

import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
/**
 * For DI this Application class is important
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
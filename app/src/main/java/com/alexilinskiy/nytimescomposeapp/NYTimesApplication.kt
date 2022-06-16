package com.alexilinskiy.nytimescomposeapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NYTimesApplication: Application() {
    init {
        app = this
    }

    companion object {
        private lateinit var app: NYTimesApplication
        fun getAppContext(): Context = app.applicationContext
    }
}
package com.prima.amphibians

import android.app.Application
import com.prima.amphibians.data.AppContainer
import com.prima.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
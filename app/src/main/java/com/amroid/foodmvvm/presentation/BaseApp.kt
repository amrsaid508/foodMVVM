package com.amroid.foodmvvm.presentation

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application() {
  override fun onCreate() {
    super.onCreate()

  }
}
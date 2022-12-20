package com.amroid.foodmvvm.di

import android.app.Application
import com.amroid.foodmvvm.presentation.BaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
  @Singleton
  @Provides
  fun provideApplication(@ApplicationContext application: Application):BaseApp{
    return application as BaseApp
  }
}
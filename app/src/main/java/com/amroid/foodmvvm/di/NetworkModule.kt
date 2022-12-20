package com.amroid.foodmvvm.di

import android.app.Application
import com.amroid.foodmvvm.domain.DomainMapper
import com.amroid.foodmvvm.network.RecipeService
import com.amroid.foodmvvm.network.model.RecipeDtoMapper
import com.amroid.foodmvvm.presentation.BaseApp
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
  @Singleton
  @Provides
  fun provideMapper(): RecipeDtoMapper {
    return RecipeDtoMapper()
  }

  @Singleton
  @Provides
  fun provideApplication(): RecipeService {
    return Retrofit.Builder()
      .baseUrl("https://food2fork.ca/api/recipe/")
      .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
      .build()
      .create(RecipeService::class.java)
  }

  @Singleton
  @Provides
  @Named("auth_token")
  fun provideAuthToken(): String {
    return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
  }
}
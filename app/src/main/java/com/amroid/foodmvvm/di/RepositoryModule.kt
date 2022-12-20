package com.amroid.foodmvvm.di

import com.amroid.foodmvvm.network.RecipeService
import com.amroid.foodmvvm.network.model.RecipeDtoMapper
import com.amroid.foodmvvm.repository.RecipeRepository
import com.amroid.foodmvvm.repository.RecipeRepository_Imp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
  @Singleton
  @Provides
  fun provideRecipeRepository(
    recipeService: RecipeService,
    recipeDtoMapper: RecipeDtoMapper
  ): RecipeRepository {
    return RecipeRepository_Imp(recipeService, recipeDtoMapper)
  }
}
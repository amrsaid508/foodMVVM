package com.amroid.foodmvvm.presentation.ui.food_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.amroid.foodmvvm.repository.RecipeRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(
  val recipeRepository: RecipeRepository,
  @Named("auth_token") private val token: String,
) : ViewModel() {
}
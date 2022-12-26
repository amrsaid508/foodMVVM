package com.amroid.foodmvvm.presentation.ui.food_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amroid.foodmvvm.domain.model.Recipe
import com.amroid.foodmvvm.repository.RecipeRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(
  val recipeRepository: RecipeRepository,
  @Named("auth_token") private val token: String,
) : ViewModel() {
  val recipeList = mutableStateOf<List<Recipe>>(emptyList())
  val query = mutableStateOf("chicken")

  init {
    searchRecipe()
  }

  private fun searchRecipe() {
    viewModelScope.launch {
      val list = recipeRepository.search(token, 1, "chicken")
      recipeList.value = list
    }
  }

  fun onQueryChange(search: String) {
    query.value = search
  }
}
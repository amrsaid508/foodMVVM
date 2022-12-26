package com.amroid.foodmvvm.presentation.ui.food_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.amroid.foodmvvm.R
import com.amroid.foodmvvm.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeApi
class RecipeListFragment : Fragment() {
  private val recipeListViewModel: RecipeListViewModel by viewModels()


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setContent {
        val recipes = recipeListViewModel.recipeList.value
        val query = recipeListViewModel.query.value
        Column(modifier = Modifier.padding(16.dp)) {
          TextField(label = {
            Text(text = "Search")
          }, value = query, onValueChange = {
            recipeListViewModel.onQueryChange(it)
          }, modifier = Modifier.fillMaxWidth())
          Spacer(modifier = Modifier.padding(10.dp))
          LazyColumn {
            itemsIndexed(recipes) { _, item ->
              RecipeCard(recipe = item) {

              }
            }
          }
        }
      }
    }
  }

}
package com.amroid.foodmvvm.repository

import com.amroid.foodmvvm.domain.model.Recipe
import com.amroid.foodmvvm.network.RecipeService
import com.amroid.foodmvvm.network.model.RecipeDtoMapper

class RecipeRepository_Imp(private val recipeService: RecipeService, private val recipeDtoMapper: RecipeDtoMapper) :
  RecipeRepository {
  override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
    return recipeDtoMapper.fromEntityList(recipeService.search(token, page, query).list)
  }

  override suspend fun get(token: String, id: Int): Recipe {
    return recipeDtoMapper.mapToDomainModel(recipeService.get(token = token, id))
  }
}
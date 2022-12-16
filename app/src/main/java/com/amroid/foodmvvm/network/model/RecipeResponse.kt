package com.amroid.foodmvvm.network.model

import com.amroid.foodmvvm.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
  @SerializedName("count")
  val count: Int,
  @SerializedName("result")
  val list: List<RecipeDto>
)
package com.amroid.foodmvvm.network

import com.amroid.foodmvvm.network.model.RecipeDto
import com.amroid.foodmvvm.network.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("search")
    suspend fun search(
      @Header("Authorization") token: String,
      @Query("page") page: Int,
      @Query("query") query: String
    ): RecipeResponse

    @GET("get")
    suspend fun get(
      @Header("Authorization") token: String,
      @Query("id") id: Int
    ): RecipeDto

}
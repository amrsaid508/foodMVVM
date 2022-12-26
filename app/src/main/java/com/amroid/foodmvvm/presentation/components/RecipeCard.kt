package com.amroid.foodmvvm.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.amroid.foodmvvm.domain.model.Recipe
import com.amroid.foodmvvm.utils.DEFAULT_RECIPE_IMAGE
import com.amroid.foodmvvm.utils.loadPicture

@ExperimentalComposeApi
@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
  Card(
    modifier = Modifier
      .padding(top = 6.dp, bottom = 6.dp)
      .fillMaxWidth()
      .clickable(onClick = onClick), shape = MaterialTheme.shapes.small, elevation = 6.dp
  ) {
    Column() {
      recipe.featuredImage?.let { url ->
        val image = loadPicture(url, DEFAULT_RECIPE_IMAGE).value
        image?.let {
          Image(
            bitmap = it.asImageBitmap(), modifier = Modifier
              .fillMaxWidth()
              .preferredHeight(255.dp), contentScale = ContentScale.Crop
          )
        }
        recipe.title?.let {
          Row(
            modifier = Modifier
              .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp)
              .fillMaxWidth()
          ) {
            Text(
              text = it,
              modifier = Modifier
                .fillMaxWidth(.85f)
                .wrapContentWidth(align = Alignment.Start),
              style = MaterialTheme.typography.h5
            )
            val rating = recipe.rating.toString()
            Text(
              text = rating,
              modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .align(Alignment.CenterVertically),
              style = MaterialTheme.typography.h6
            )
          }
        }

      }
    }
  }
}
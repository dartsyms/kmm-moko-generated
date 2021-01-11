package me.sanchez.shared.presentation

import me.sanchez.shared.models.Recipe

interface RecipesListView {
    fun setItemsFrom(list: List<Recipe>)
}
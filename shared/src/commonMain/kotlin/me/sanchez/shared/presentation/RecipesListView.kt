package me.sanchez.shared.presentation

import dev.icerock.moko.network.generated.models.Recipe

interface RecipesListView {
    fun setItemsFrom(list: List<Recipe>)
}
package me.sanchez.shared.services

import io.ktor.util.*
import dev.icerock.moko.network.generated.models.*
import me.sanchez.shared.models.RecipeList

class RecipeService {
    private val networkService = NetworkService()

    @KtorExperimentalAPI
    suspend fun searchRecipes(query: String, withPics: Boolean): RecipeList {
        return networkService.recipeApi.getRecipe("", query, 1)
    }
}
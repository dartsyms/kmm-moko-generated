package me.sanchez.shared.services

import io.ktor.client.*
import dev.icerock.moko.network.generated.apis.*
import me.sanchez.shared.apis.RecipeApi
import kotlinx.serialization.json.Json

class NetworkService {
    val recipeApi = RecipeApi(
        basePath = "http://www.recipepuppy.com/",
        httpClient = HttpClient(),
        json = Json { ignoreUnknownKeys = true }
    )
}
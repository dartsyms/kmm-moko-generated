package me.sanchez.shared.services

import io.ktor.client.*
import dev.icerock.moko.network.generated.apis.*

class NetworkService {
    val recipeApi = RecipeApi(
        basePath = "http://www.recipepuppy.com/",
        httpClient = HttpClient(),
        json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
    )
}
/**
* Recipe Puppy
* Recipe Puppy
*
* OpenAPI spec version: 1.0.0
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package dev.icerock.moko.network.generated.models

import dev.icerock.moko.network.generated.models.Recipe
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

/**
 * 
 * @param title 
 * @param results 
 */
@Serializable
data class RecipeList (
    @SerialName("title")
    val title: kotlin.String? = null,
    @SerialName("results")
    val results: kotlin.collections.List<Recipe>? = null
) {

}

/**
* Recipe Puppy
* Recipe Puppy
*
* The version of the OpenAPI document: 1.0.0
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.client.models


import kotlinx.serialization.*
import kotlinx.serialization.internal.CommonEnumSerializer

/**
 * 
 * @param message 
 * @param code 
 */
@Serializable
data class ErrorModel (
    @SerialName(value = "message") @Required val message: kotlin.String,
    @SerialName(value = "code") @Required val code: kotlin.Int
)


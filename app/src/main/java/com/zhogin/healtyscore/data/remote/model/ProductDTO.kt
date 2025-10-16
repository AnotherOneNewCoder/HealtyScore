package com.zhogin.healtyscore.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDTO(
    @SerialName("brands")
    val brands: String? = "",
    @SerialName("product_name")
    val productName: String? = "",
    @SerialName("image_url")
    val imageUrl: String? = "",
    @SerialName("ingredients_text")
    val ingredientsText: String? = "",
    @SerialName("nova_groups")
    val novaGroup: String? = "",
    @SerialName("nutriscore_grade")
    val nutriscoreGrade: String? = "",
    @SerialName("nutriments")
    val nutriments: NutrimentsDTO?,
)

package com.zhogin.healtyscore.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponseDTO(
    @SerialName("code")
    val code: String,
    @SerialName("product")
    val product: ProductDTO?,
    @SerialName("status")
    val status: Int,
)
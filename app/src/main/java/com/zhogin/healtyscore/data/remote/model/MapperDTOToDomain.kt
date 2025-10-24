package com.zhogin.healtyscore.data.remote.model

import com.zhogin.healtyscore.domain.model.ProductDetails

fun ProductResponseDTO.toDomain(): ProductDetails {
    return ProductDetails(
        barcode = this.code,
        name = this.product?.productName?.trim() ?: "Unknown",
        imageUrl = this.product?.imageUrl,
        nutriScore = this.product?.nutriscoreGrade?.trim()?.uppercase()?.first() ?: 'Z',
        novaGroup = this.product?.novaGroup?.toIntOrNull() ?: 0,
        ingredients = this.product?.ingredientsText ?: "No data",
        caloriesKcal = this.product?.nutriments?.energyKcalValue ?: 0.0,
        fatGrams = this.product?.nutriments?.fatValue ?: 0.0,
        sugarsGrams = this.product?.nutriments?.sugarsValue ?: 0.0
    )
}
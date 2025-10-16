package com.zhogin.healtyscore.domain.model

data class ProductDetails(
    val barcode: String,
    val name: String,
    val imageUrl: String?,
    val nutriScore: String,
    val novaGroup: Int,
    val ingredients: String,
    val caloriesKcal: Double,
    val fatGrams: Double,
    val sugarsGrams: Double,

)

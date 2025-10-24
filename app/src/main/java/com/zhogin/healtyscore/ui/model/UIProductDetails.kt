package com.zhogin.healtyscore.ui.model

import androidx.compose.ui.graphics.Color

data class UIProductDetails(
    val barcode: String,
    val name: String,
    val imageUrl: String?,
    val nutriScore: Char,
    val novaGroup: Int,
    val ingredients: String,
    val caloriesKcal: Double,
    val fatGrams: Double,
    val sugarsGrams: Double,
    val nutriColor: Color
)

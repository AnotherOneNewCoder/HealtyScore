package com.zhogin.healtyscore.ui

import com.zhogin.healtyscore.domain.model.ProductDetails

data class UIState(
    val productDetails: ProductDetails? = null,
    val loading : Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = null
)

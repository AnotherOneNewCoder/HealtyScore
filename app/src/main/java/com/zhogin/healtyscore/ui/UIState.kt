package com.zhogin.healtyscore.ui

import com.zhogin.healtyscore.ui.model.UIProductDetails

data class UIState(
    val productDetails: UIProductDetails? = null,
    val loading : Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = null
)

package com.zhogin.healtyscore.domain.repository

import com.zhogin.healtyscore.domain.model.ProductDetails
import com.zhogin.healtyscore.domain.util.RequestResult

interface ProductDetailsRepository {
    suspend fun getProductDetailsFromServer(barcode: String): RequestResult<ProductDetails>
}
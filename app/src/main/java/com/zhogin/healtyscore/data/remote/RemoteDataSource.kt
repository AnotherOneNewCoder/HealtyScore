package com.zhogin.healtyscore.data.remote

import com.zhogin.healtyscore.data.remote.model.ProductResponseDTO
import com.zhogin.healtyscore.data.utils.Resource

interface RemoteDataSource {
    suspend fun getProductDetails(barcode: String): Resource<ProductResponseDTO>
}
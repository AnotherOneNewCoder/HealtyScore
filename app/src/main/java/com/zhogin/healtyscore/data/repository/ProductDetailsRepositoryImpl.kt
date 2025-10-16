package com.zhogin.healtyscore.data.repository

import com.zhogin.healtyscore.data.remote.RemoteDataSource
import com.zhogin.healtyscore.data.remote.model.toDomain
import com.zhogin.healtyscore.data.utils.Resource
import com.zhogin.healtyscore.data.utils.map
import com.zhogin.healtyscore.data.utils.toRequestResult
import com.zhogin.healtyscore.domain.model.ProductDetails
import com.zhogin.healtyscore.domain.repository.ProductDetailsRepository
import com.zhogin.healtyscore.domain.util.RequestResult
import jakarta.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ProductDetailsRepository {
    override suspend fun getProductDetailsFromServer(barcode: String): RequestResult<ProductDetails> {
        val result = remoteDataSource.getProductDetails(barcode)
        return when(result) {
            is Resource.Failure<*> -> result.map { it.toDomain() }.toRequestResult()
            is Resource.Loading<*> -> RequestResult.InProgress(result.data?.toDomain())
            is Resource.Success<*> -> result.map { it.toDomain() }.toRequestResult()
        }
//                as RequestResult<ProductDetails>
//

    }
}
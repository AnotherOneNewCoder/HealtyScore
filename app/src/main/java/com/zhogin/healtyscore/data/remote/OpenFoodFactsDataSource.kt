package com.zhogin.healtyscore.data.remote

import com.zhogin.healtyscore.data.remote.model.ProductResponseDTO
import com.zhogin.healtyscore.data.utils.Resource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import jakarta.inject.Inject

class OpenFoodFactsDataSource @Inject constructor(
    private val httpClient: HttpClient
): RemoteDataSource {
    override suspend fun getProductDetails(barcode: String): Resource<ProductResponseDTO> {
        val url = "https://world.openfoodfacts.net/api/v2/product/$barcode"
        return try {
            Resource.Success(
                httpClient.get(url).body()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(error = e)
        }
    }

}
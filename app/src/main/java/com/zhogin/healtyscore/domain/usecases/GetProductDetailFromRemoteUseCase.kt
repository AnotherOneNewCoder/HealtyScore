package com.zhogin.healtyscore.domain.usecases

import com.zhogin.healtyscore.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class GetProductDetailFromRemoteUseCase @Inject constructor(
    private val repository: ProductDetailsRepository
) {
    suspend operator fun invoke(barcode: String) = repository.getProductDetailsFromServer(barcode)
}
package com.zhogin.healtyscore.ui

import androidx.lifecycle.ViewModel
import com.zhogin.healtyscore.domain.usecases.GetProductDetailFromRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailFromRemoteUseCase: GetProductDetailFromRemoteUseCase
) : ViewModel(){
    
}
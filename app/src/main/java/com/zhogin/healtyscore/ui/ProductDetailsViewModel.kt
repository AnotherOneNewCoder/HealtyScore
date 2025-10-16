package com.zhogin.healtyscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhogin.healtyscore.domain.usecases.GetProductDetailFromRemoteUseCase
import com.zhogin.healtyscore.domain.util.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailFromRemoteUseCase: GetProductDetailFromRemoteUseCase
) : ViewModel(){
    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()


    fun onSearch(barcode: String) = viewModelScope.launch {
        val result = getProductDetailFromRemoteUseCase.invoke(barcode)
        when(result) {
            is RequestResult.Error<*> -> _uiState.update { uistate ->
                uistate.copy(
                    loading = false,
                    error = true,
                    errorMessage = result.error?.message ?: "error 1"
                )
            }
            is RequestResult.InProgress<*> -> _uiState.update {
                it.copy(
                    loading = true,
                    error = false,
                    errorMessage = null,
                    productDetails = null
                )
            }
            is RequestResult.Success<*> -> _uiState.update {
                it.copy(
                    loading = false,
                    error = false,
                    errorMessage = null,
                    productDetails = result.data
                )
            }
        }
    }



    fun onEvent(uiEvent: UIEvent) {
        when(uiEvent) {
            is UIEvent.OnSearchClicked -> viewModelScope.launch {
                val result = getProductDetailFromRemoteUseCase.invoke(uiEvent.barcode)
                when(result) {
                    is RequestResult.Error<*> -> _uiState.update { uistate ->
                        uistate.copy(
                            loading = false,
                            error = true,
                            errorMessage = result.error?.message ?: "error 1"
                        )
                    }
                    is RequestResult.InProgress<*> -> _uiState.update {
                        it.copy(
                            loading = true,
                            error = false,
                            errorMessage = null,
                            productDetails = null
                        )
                    }
                    is RequestResult.Success<*> -> _uiState.update {
                        it.copy(
                            loading = false,
                            error = false,
                            errorMessage = null,
                            productDetails = result.data
                        )
                    }
                }
            }
        }
    }
}
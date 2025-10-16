package com.zhogin.healtyscore.ui

sealed interface UIEvent {
    data class OnSearchClicked(val barcode: String): UIEvent
}
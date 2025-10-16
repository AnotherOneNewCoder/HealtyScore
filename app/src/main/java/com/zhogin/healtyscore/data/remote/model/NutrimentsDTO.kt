package com.zhogin.healtyscore.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutrimentsDTO(
    @SerialName("energy-kcal_value")
    val energyKcalValue: Double?,
    @SerialName("fat_value")
    val fatValue: Double?,
    @SerialName("sugars_value")
    val sugarsValue: Double?,
    @SerialName("salt_value")
    val saltValue: Double?,
    @SerialName("proteins_value")
    val proteinsValue: Double?,
)
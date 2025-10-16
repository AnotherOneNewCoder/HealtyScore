package com.zhogin.healtyscore.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutrimentsDTO(
    @SerialName("energy-kcal_value")
    val energyKcalValue: Double? = 0.0,
    @SerialName("fat_value")
    val fatValue: Double? = 0.0,
    @SerialName("sugars_value")
    val sugarsValue: Double? = 0.0,
    @SerialName("salt_value")
    val saltValue: Double? = 0.0,
    @SerialName("proteins_value")
    val proteinsValue: Double? = 0.0,
)
package com.zhogin.healtyscore.ui.utils

import com.zhogin.healtyscore.domain.model.ProductDetails
import com.zhogin.healtyscore.ui.model.UIProductDetails
import com.zhogin.healtyscore.ui.theme.BadHealthGrade
import com.zhogin.healtyscore.ui.theme.BestHealthGrade
import com.zhogin.healtyscore.ui.theme.GoodHealthGrade
import com.zhogin.healtyscore.ui.theme.NeutralHealthGrade
import com.zhogin.healtyscore.ui.theme.PoorHealthGrade
import com.zhogin.healtyscore.ui.theme.UnknownHealthGrade

fun ProductDetails.toUIProductDetails(): UIProductDetails {
    return UIProductDetails(
        barcode = this.barcode,
        name = this.name,
        imageUrl = this.imageUrl,
        nutriScore = this.nutriScore,
        novaGroup = this.novaGroup,
        ingredients = this.ingredients,
        caloriesKcal = this.caloriesKcal,
        fatGrams = this.fatGrams,
        sugarsGrams = this.sugarsGrams,
        nutriColor = when(this.nutriScore) {
            'A' -> {
                BestHealthGrade
            }
            'B' -> {
                GoodHealthGrade
            }
            'C' -> {
                NeutralHealthGrade
            }
            'D' -> {
                PoorHealthGrade
            }
            'E' -> {
                BadHealthGrade
            }
            else -> {
                UnknownHealthGrade
            }
        }
    )
}
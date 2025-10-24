package com.zhogin.healtyscore.ui.components.scanners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zhogin.healtyscore.ui.theme.BarcodeColor

@Composable
fun ProductInfo(
    modifier: Modifier = Modifier,
    name: String,
    barcode: String,
    ingredient: String,
    caloriesKcal: Double,
    fatGrams: Double,
    sugarsGrams: Double,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 24.dp
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Text(
            text = barcode,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = BarcodeColor
        )
        Text(
            text = "Ingredients: $ingredient",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Kcal: $caloriesKcal",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Fats: $fatGrams",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Sugar: $sugarsGrams",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
        )
    }
}
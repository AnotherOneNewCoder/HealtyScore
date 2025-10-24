package com.zhogin.healtyscore.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NutriScoreBadge(
    modifier: Modifier = Modifier,
    score: Char,
    color: Color
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = color,
        modifier = Modifier.size(36.dp),
        shadowElevation = 2.dp
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = score.toString(),
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        }
    }
}
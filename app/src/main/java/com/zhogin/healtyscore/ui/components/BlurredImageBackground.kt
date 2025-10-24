package com.zhogin.healtyscore.ui.components


import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.zhogin.healtyscore.R
import com.zhogin.healtyscore.ui.theme.DarkBlue


@Composable
fun BlurredImageBackground(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    cardHeightDp: Dp,
    content: @Composable () -> Unit,
    score: Char,
    color: Color,
){
    var imageLoadResult by remember {
        mutableStateOf<Result<Painter>?>(null)
    }

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        onSuccess = {
            val size = it.painter.intrinsicSize
            imageLoadResult = if (size.width > 1 && size.height > 1) {
                Result.success(it.painter)
            } else {
                Result.failure(Exception("Invalid image dimensions"))
            }
        }
    )
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(DarkBlue)
            ) {
                imageLoadResult?.getOrNull()?.let { painter ->
                    Image(
                        painter = painter,
                        contentDescription = stringResource(R.string.product_image),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .blur(20.dp)
                    )
                }
            }
//            Box(
//                modifier = Modifier
//                    .weight(0.3f)
//                    .fillMaxWidth()
//                    .background(DesertWhite)
//            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.fillMaxHeight(0.15f))
            ElevatedCard(
                modifier = modifier
                    .height(cardHeightDp)
                    .aspectRatio(2 / 3f),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {
                AnimatedContent(
                    targetState = imageLoadResult
                ) { result ->
                    when(result) {
                        null -> Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            PulseAnimation(
                                modifier = Modifier.size(60.dp)
                            )
                        }
                        else -> {
                            Box {
                                Image(
                                    painter = if (result.isSuccess) painter
                                    else painterResource(R.drawable.product_error),
                                    contentDescription = stringResource(R.string.product_image),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Transparent),
                                    contentScale = if (result.isSuccess) ContentScale.Crop else ContentScale.Fit
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    NutriScoreBadge(
                                        score = score,
                                        color = color,
                                    )
                                }

                            }
                        }
                    }
                }
            }
            content()
        }
    }
}
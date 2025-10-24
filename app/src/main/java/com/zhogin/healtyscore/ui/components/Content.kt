package com.zhogin.healtyscore.ui.components

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.zhogin.healtyscore.ui.UIState
import com.google.accompanist.permissions.rememberPermissionState
import com.zhogin.healtyscore.ui.components.scanners.ProductInfo
import com.zhogin.healtyscore.ui.components.scanners.ScanCode

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Content(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    state: State<UIState>
) {
    Column(
        modifier = modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var openScanner by rememberSaveable {
            mutableStateOf(false)
        }
        var barcode by rememberSaveable {
            mutableStateOf("")
        }
        val cameraPermission = rememberPermissionState(Manifest.permission.CAMERA)

        TextField(
            value = barcode,
            onValueChange = {
                barcode = it
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )
        )
        Spacer(Modifier.height(18.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    onClick(barcode)
                }
            ) {
                Text("Search product")
            }
            if (cameraPermission.status.isGranted) {
                Button(
                    onClick = {
                        openScanner = !openScanner
                    }
                ) {
                    if (openScanner) {
                        Text("Stop scanning")
                    } else {
                        Text("Start scanning")
                    }

                }
            } else {
                Button(
                    onClick = {
                        cameraPermission.launchPermissionRequest()
                    }
                ) {
                    Text("Unleash the camera")
                }
            }
        }

        //Spacer(Modifier.height(18.dp))
        if (openScanner) {
            Box(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .fillMaxWidth()
                    .height(400.dp)
            ) {

                ScanCode(
                    onQrCodeDetected = {
                        barcode = it
                    }
                )
            }
        }
        if (state.value.loading) {
            CircularProgressIndicator()
        }
        if (state.value.error) {
            Text(
                text = state.value.errorMessage.toString()
            )
        }
        if (state.value.productDetails != null) {
            state.value.productDetails?.let {
//                ProductCard(
//                    modifier = modifier,
//                    product = it,
//                    onClick = { }
//                )
                BlurredImageBackground(
                    modifier = modifier,
                    imageUrl = it.imageUrl,
                    cardHeightDp = 200.dp,
                    content = {
                        ProductInfo(
                            name = it.name,
                            barcode = it.barcode,
                            ingredient = it.ingredients,
                            caloriesKcal = it.caloriesKcal,
                            fatGrams = it.fatGrams,
                            sugarsGrams = it.sugarsGrams
                        )
                    },
                    score = it.nutriScore,
                    color = it.nutriColor,
                )
            }

        }
    }
}
package com.zhogin.healtyscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zhogin.healtyscore.ui.ProductDetailsViewModel
import com.zhogin.healtyscore.ui.UIEvent
import com.zhogin.healtyscore.ui.UIState
import com.zhogin.healtyscore.ui.theme.HealtyScoreTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealtyScoreTheme {
                val viewModel = hiltViewModel<ProductDetailsViewModel>()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding),
                        onClick = {viewModel.onSearch(it)},
                        state = viewModel.uiState.collectAsStateWithLifecycle(),
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    state: State<UIState>
) {
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        var barcode by remember {
            mutableStateOf("")
        }

        TextField(
            value = barcode,
            onValueChange = {
                barcode = it
            }
        )

        Button(
            onClick = {
                onClick(barcode)
            }
        ) {
            Text("Search product")
        }
        Spacer(Modifier.height(18.dp))
        if (state.value.loading) {
            CircularProgressIndicator()
        }
        if (state.value.error) {
            Text(
                text = state.value.errorMessage.toString()
            )
        }
        if (state.value.productDetails != null) {
            Text(
                text = state.value.productDetails?.name ?: "fffff"
            )
        }
    }
}
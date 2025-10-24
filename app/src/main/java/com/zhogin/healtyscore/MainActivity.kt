package com.zhogin.healtyscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zhogin.healtyscore.ui.ProductDetailsViewModel
import com.zhogin.healtyscore.ui.components.Content
import com.zhogin.healtyscore.ui.theme.HealtyScoreTheme
import dagger.hilt.android.AndroidEntryPoint

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


package com.example.buildconfigsandsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buildconfigsandsearch.ui.feature.config.ConfigScreen
import com.example.buildconfigsandsearch.ui.feature.config.state.ConfigViewModel
import com.example.buildconfigsandsearch.ui.theme.BuildConfigsAndSearchTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    private val viewModel: ConfigViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildConfigsAndSearchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ConfigScreen(
                       viewModel = viewModel,
                       onOptionClick = viewModel::onOptionClick,
                       onSectionClick = viewModel::onSectionClick,
                       modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildConfigsAndSearchTheme {

    }
}
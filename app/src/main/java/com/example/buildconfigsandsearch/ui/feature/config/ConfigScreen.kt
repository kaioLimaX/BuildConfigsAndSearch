package com.example.buildconfigsandsearch.ui.feature.config

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buildconfigsandsearch.ui.components.ConfigSectionItem
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigOption
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection
import com.example.buildconfigsandsearch.ui.feature.config.state.ConfigViewModel

@Composable
fun ConfigScreen(
    viewModel: ConfigViewModel,
    onOptionClick: (ConfigOption.Type) -> Unit,
    onSectionClick: (ConfigSection) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(uiState.sections) { section ->
            ConfigSectionItem(
                section = section,
                onOptionClick = onOptionClick,
                onSectionClick = onSectionClick
            )
        }
    }
}
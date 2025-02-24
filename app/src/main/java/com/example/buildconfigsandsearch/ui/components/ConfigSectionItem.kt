package com.example.buildconfigsandsearch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigOption
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection

@Composable
fun ConfigSectionItem(
    section: ConfigSection,
    onOptionClick: (ConfigOption.Type) -> Unit,
    onSectionClick: (ConfigSection) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = section.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .clickable { onSectionClick(section) }
            )
            section.options.forEach { option ->
                ConfigOptionItem(option, onOptionClick)
            }
        }
    }
}

@Composable
fun ConfigOptionItem(
    option: ConfigOption,
    onOptionClick: (ConfigOption.Type) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onOptionClick(option.type) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = option.name, style = MaterialTheme.typography.bodyLarge)
        }
        when (option) {
            is ConfigOption.EnabledOption -> {
                Switch(checked = option.enabled, onCheckedChange = { onOptionClick(option.type) })
            }
            is ConfigOption.SelectableOption -> {
                Checkbox(checked = option.selected, onCheckedChange = { onOptionClick(option.type) })
            }
        }
    }
}


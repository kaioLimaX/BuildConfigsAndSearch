package com.example.buildconfigsandsearch.ui.feature.config.state

import androidx.compose.runtime.Stable
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigOption
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection

@Stable
interface ConfigUiAction {
    fun onOptionClick(option : ConfigOption.Type)
    fun onSectionClick(section : ConfigSection)
}
package com.example.buildconfigsandsearch.ui.feature.config.state

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigBuilder
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigOption
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ConfigViewModel(
    private val context: Context
) : ViewModel(), ConfigUiAction {

    private val _uiState = MutableStateFlow<ConfigUiState>(mutableConfigUiState())
    val uiState: StateFlow<ConfigUiState> = _uiState

    private val _sideEffects = MutableStateFlow<ConfigUiActionSideEffectConnector.ConfigUiActionSideEffect?>(null)
    val sideEffects: StateFlow<ConfigUiActionSideEffectConnector.ConfigUiActionSideEffect?> = _sideEffects

    init {
        loadConfig()
    }

    private fun loadConfig() {
        viewModelScope.launch {
            val configBuilder = ConfigBuilder()
            val sections = configBuilder.buildConfigSections(context)
            _uiState.update { mutableConfigUiState(sections = sections) }
        }
    }

    override fun onOptionClick(option: ConfigOption.Type) {
        _uiState.update { state ->
            val updatedSections = state.sections.map { section ->
                section.copy(
                    options = section.options.map { opt ->
                        if (opt.type == option) {
                            when (opt) {
                                is ConfigOption.EnabledOption -> opt.copy(enabled = !opt.enabled)
                                is ConfigOption.SelectableOption -> opt.copy(selected = !opt.selected)
                                else -> opt
                            }
                        } else {
                            opt
                        }
                    }
                )
            }
            mutableConfigUiState(sections = updatedSections)
        }
    }

    override fun onSectionClick(section: ConfigSection) {
        _sideEffects.value = ConfigUiActionSideEffectConnector.ConfigUiActionSideEffect.OpenSection(section)
    }

    fun clearSideEffect() {
        _sideEffects.value = null
    }
}

package com.example.buildconfigsandsearch.ui.feature.config.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigOption
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection

interface ConfigUiState{
    val search : String
    val sections : List<ConfigSection>

    fun isOptionChecked(optionType : ConfigOption.Type) : Boolean{
        for (section in sections){
            for(option in section.options){
                if(option.type == optionType && option is ConfigOption.EnabledOption){
                    return option.enabled
                }
            }
        }
        return false
    }
}

class mutableConfigUiState(
    sections : List<ConfigSection> = emptyList()
) : ConfigUiState{
    override val search: String by mutableStateOf("")
    override val sections: List<ConfigSection> = mutableStateListOf(*sections.toTypedArray())
}
package com.example.buildconfigsandsearch.ui.feature.config.state

import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection

interface ConfigUiActionSideEffectConnector {
    sealed interface ConfigUiActionSideEffect : ConfigUiActionSideEffectConnector {

        object back : ConfigUiActionSideEffect

        object OpenTheme : ConfigUiActionSideEffect
        object OpenBattery : ConfigUiActionSideEffect
        object OpenAbout : ConfigUiActionSideEffect
        object OpenLocation : ConfigUiActionSideEffect
        object OpenMode : ConfigUiActionSideEffect
        object OpenSound : ConfigUiActionSideEffect

        data class OpenSection(val section: ConfigSection) : ConfigUiActionSideEffect


    }
}
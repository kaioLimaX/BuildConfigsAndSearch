package com.example.buildconfigsandsearch.ui.feature.config.model

import android.content.Context
import com.example.buildconfigsandsearch.ui.components.ConfigOptionIcon
import com.example.buildconfigsandsearch.ui.feature.config.model.ConfigSection.Type.Companion.text
import com.example.buildconfigsandsearch.ui.theme.painter.IconsPainter

class ConfigBuilder {

    fun buildConfigSections(
        context: Context
    ): List<ConfigSection> {
        return mutableListOf(
            ConfigSection(
                name = ConfigSection.Type.GENERAL_CONFIG.text(context),
                type = ConfigSection.Type.GENERAL_CONFIG,
                icon = {
                    ConfigOptionIcon(
                        painter = IconsPainter.ThemeIcon
                    )
                },
                options = buildConfig(
                    context,
                    ConfigSection.Type.GENERAL_CONFIG
                )
            ),
            ConfigSection(
                name = ConfigSection.Type.SECURITY_CONFIG.text(context),
                type = ConfigSection.Type.SECURITY_CONFIG,
                icon = {
                    ConfigOptionIcon(
                        painter = IconsPainter.ModeIcon
                    )
                },
                options = buildConfig(
                    context,
                    ConfigSection.Type.SECURITY_CONFIG
                )
            ),
            ConfigSection(
                name = ConfigSection.Type.ADVANCED_CONFIG.text(context),
                type = ConfigSection.Type.ADVANCED_CONFIG,
                icon = {
                    ConfigOptionIcon(
                        painter = IconsPainter.SoundIcon
                    )
                },
                options = buildConfig(
                    context,
                    ConfigSection.Type.ADVANCED_CONFIG
                )
            )

        )
    }

    private fun buildConfig(
        context: Context,
        type: ConfigSection.Type,
    ): List<ConfigOption> {
        return when (type) {
            ConfigSection.Type.GENERAL_CONFIG -> {
                listOf(
                    ConfigOption.SelectableOption(
                        name = ConfigOption.Type.Theme.text(context),
                        description = ConfigOption.Type.Theme.description(context),
                        type = ConfigOption.Type.Theme,
                        selected = true
                    ),
                    ConfigOption.SelectableOption(
                        name = ConfigOption.Type.Battery.text(context),
                        description = ConfigOption.Type.Battery.description(context),
                        type = ConfigOption.Type.Battery,
                        selected = false
                    )
                )
            }

            ConfigSection.Type.SECURITY_CONFIG -> {
                listOf(
                    ConfigOption.EnabledOption(
                        name = ConfigOption.Type.Location.text(context),
                        description = ConfigOption.Type.Location.description(context),
                        type = ConfigOption.Type.Location,
                        enabled = true
                    ),
                    ConfigOption.SelectableOption(
                        name = ConfigOption.Type.Mode.text(context),
                        description = ConfigOption.Type.Mode.description(context),
                        type = ConfigOption.Type.Mode,
                        selected = true
                    )
                )

            }

            ConfigSection.Type.ADVANCED_CONFIG -> {
                listOf(
                    ConfigOption.EnabledOption(
                        name = ConfigOption.Type.Sound.text(context),
                        description = ConfigOption.Type.Sound.description(context),
                        type = ConfigOption.Type.Sound,
                        enabled = true
                    ),
                    ConfigOption.SelectableOption(
                        name = ConfigOption.Type.About.text(context),
                        description = ConfigOption.Type.About.description(context),
                        type = ConfigOption.Type.About,
                        selected = false
                    )
                )

            }
        }

    }
}